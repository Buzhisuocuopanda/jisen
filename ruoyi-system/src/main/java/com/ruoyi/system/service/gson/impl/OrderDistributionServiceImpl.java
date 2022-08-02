package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.constant.TotalOrderConstants;
import com.ruoyi.common.constant.WareHouseType;
import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.OrderTypeEnum;
import com.ruoyi.common.enums.UseFlagEnum;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.dto.DirectWarehousingDto;
import com.ruoyi.system.domain.vo.ChangeSkuUseVo;
import com.ruoyi.system.domain.vo.DirectWarehousingVo;
import com.ruoyi.system.domain.vo.QtyMsgVo;
import com.ruoyi.system.domain.vo.SaleOrderExitVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.OrderDistributionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * ClassName OrderDistributionServiceImpl
 * Description
 * Create by gfy
 * Date 2022/7/27 14:10
 */
@Service
@Slf4j
public class OrderDistributionServiceImpl implements OrderDistributionService {

    private Map<String, Long> lockMap = new ConcurrentHashMap<>();

    @Resource
    private GsAllocationBalanceMapper gsAllocationBalanceMapper;
    @Resource
    private GsGoodsUseMapper gsGoodsUseMapper;
    @Resource
    private CbpbMapper cbpbMapper;
    @Resource
    private BaseCheckService baseCheckService;
    @Resource
    private CbibMapper cbibMapper;
    @Resource
    private CbwaMapper cbwaMapper;


    /**
     * 总订单重新分配的key
     */
    private String totalOrderkey = "totalOrder";

    /**
     * 其他订单key
     */
    private String orderkey = "otherOrder";


    /**
     * key值过期时间30秒
     */
    private Long overTime = 30000L;

    /**
     * 拿锁超时时间
     */
    private Long lockGetTime = 5000L;

    @Resource
    private CbbaMapper cbbaMapper;


    private boolean lockTotalOrder() {
        Long time = System.currentTimeMillis();

        while (true) {
            Long now = System.currentTimeMillis();
            if (now - time > lockGetTime) {
                throw new ServiceException("获得锁超时，请稍后重试");
            }
            Long aLong = lockMap.putIfAbsent(totalOrderkey, time);
            if (aLong != null) {
                //说明没占到锁
                //判断时间是否过期
                if (aLong - now > overTime) {
                    Long put = lockMap.put(totalOrderkey, now);
                    if (put.equals(now)) {
                        return true;
                    }

                }
                continue;
            }

            return true;


        }


    }

    private boolean ifHasOthOrder() {
        Long time = System.currentTimeMillis();

        while (true) {
            Long now = System.currentTimeMillis();
            if (now - time > lockGetTime) {
                throw new ServiceException("获得锁超时，请稍后重试");
            }
            Long aLong = lockMap.get(orderkey);
            if (aLong != null || aLong != 0) {
                //说明有线程正在操作其他订单进行总订单的分配数量更改
                continue;

            } else {
                return false;
            }

        }


    }

    //锁其他订单
    private boolean lockOtherOrder() {
        //先锁住其他订单锁
        Long aLong = lockMap.get(orderkey);
        if (aLong == null) {
            lockMap.put(orderkey, 1L);
        } else {
            lockMap.put(orderkey, aLong + 1);
        }

        //判断有没有总订单在进行分配
        Long time = System.currentTimeMillis();

        while (true) {
            Long now = System.currentTimeMillis();
            if (now - time > lockGetTime) {
                throw new ServiceException("获得锁超时，请稍后重试");
            }
            Long ttime = lockMap.get(totalOrderkey);
            if (ttime != null) {
                //说明有线程正在操作其他订单进行总订单的分配数量更改
                if (aLong - now > overTime) {
                    Long put = lockMap.put(totalOrderkey, null);
                    return false;
                } else {
                    continue;
                }
            } else {
                return false;
            }

        }

    }

    /**
     * 其他订单释放锁
     *
     * @return
     */
    private void unLockOtherOrder() {
        Long aLong = lockMap.get(orderkey);
        if (aLong != null && aLong != 0) {

            lockMap.put(orderkey, aLong - 1);
        }
    }


    /**
     * 重新分配逻辑 用于创建新的总订单，和修改优先级使用
     *
     * @param orderDistributionDo
     */
    @Override
    @Transactional
    public Cbba reassign(OrderDistributionDo orderDistributionDo) {

        try {
            //总订单重新分配 需要先判断其他订单有没有进行分配
            lockTotalOrder();
            //判断是否有其他操作总订单的业务
            ifHasOthOrder();

            //是修改生产订单还是创建生产订单
            //查未分配订单的数量
            GsAllocationBalance ungoods = gsAllocationBalanceMapper.selectByGoodsIdForUpdate(orderDistributionDo.getGoodsId());
            Cbba cbba = orderDistributionDo.getCbba();
            if (orderDistributionDo.getType() == 1) {
                //创建
                //先查找未分配订单的数量创建把
                getUnDistributionGoods(cbba, ungoods);

                //优先级比这个订单低的未完成的订单的 分配数量减去占用数量分配给该订单
                if (!cbba.getCbba13().equals(cbba.getCbba09() - cbba.getCbba11())) {
                    getOtherOrderMakeNum(cbba);
                }


            } else {
                //此处修改分两种情况
                //1、修改优先级
                //2、修改数量
                if (orderDistributionDo.getType() == 2) {
                    //优先级由高到低
                    if (orderDistributionDo.getPriority() > orderDistributionDo.getOldPriority()) {
                        giveOrderPriority(cbba, orderDistributionDo.getOldPriority());
                    } else {
                        //优先级由低到高
                        getOrderPriority(cbba, orderDistributionDo.getOldPriority());
                    }


                } else {
                    //判断是大于原先数量还是小于原先数量
                    if (orderDistributionDo.getNum() > orderDistributionDo.getOldNum()) {
                        //大于
                        //先查找未分配订单的数量创建把
                        getUnDistributionGoods(cbba, ungoods);
                        if (!cbba.getCbba13().equals(cbba.getCbba09() - cbba.getCbba11())) {
                            getOtherOrderMakeNum(cbba);
                        }
                    } else {
                        //如果是小于并且有多出来的分配给其他订单
                        giveOtherOrder(cbba, orderDistributionDo.getOldNum(), ungoods);

                    }
                }


            }


//            Cbba cbba = cbbaMapper.select(orderDistributionDo.getOrderId());

        } finally {
            lockMap.put(totalOrderkey, null);
        }

        return null;
    }

    /**
     * 修改总订单数量从多变少
     *
     * @param cbba
     * @param oldNum
     * @param ungoods
     * @return
     */

    private Cbba giveOtherOrder(Cbba cbba, Integer oldNum, GsAllocationBalance ungoods) {
        Double orderNum = cbba.getCbba09();
        //已分配的数量
        Double makeNum = cbba.getCbba13();

        //已占用的数量
//        Double useNum = cbba.getCbba14();
        Double useNum = 0.0;
        if (!cbba.getCbba07().startsWith(TotalOrderConstants.GUONEIORDER)) {
            GsGoodsUseCriteria example = new GsGoodsUseCriteria();
            example.createCriteria().andGoodsIdEqualTo(cbba.getCbba08())
                    .andOrderNoEqualTo(cbba.getCbba07());
            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(example);
            useNum = gsGoodsUses.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));


        }
        if (orderNum < useNum) {
            throw new ServiceException("修改订单数量不能小于该订单的占用数量");
        }

//        if(makeNum-useNum<=0){
//            //如果分配数量和占用数量一样不用重新分配
//            return cbba;
//        }
        if (makeNum - orderNum <= 0) {
            //如果分配数量没有超出订单数量，也不用重新分分配
            return cbba;
        }

        Double givenNum = makeNum - orderNum;

        List<Cbba> res = cbbaMapper.selectLowPriority(cbba);
        for (Cbba re : res) {
            //订单所需数量为 订单数量减去 分配数量减去发货数量
            Double needNum = re.getCbba09() - re.getCbba11() - re.getCbba13();
            if (needNum == 0) {
                continue;
            }

            if (givenNum <= needNum) {
                re.setCbba13(re.getCbba13() + givenNum);
                givenNum = 0.0;
            } else {
                re.setCbba13(re.getCbba13() + needNum);
                givenNum = givenNum - needNum;

            }

            re.setCbba04(new Date());
            cbbaMapper.updateByPrimaryKey(re);
            if (givenNum == 0) {
                break;
            }

        }
        cbba.setCbba13(cbba.getCbba13() - givenNum);

        if (givenNum > 0) {
            //存到未分配列表里
            if (ungoods != null && ungoods.getQty() > 0) {
                ungoods.setQty(ungoods.getQty() + givenNum.intValue());
                ungoods.setUpdateTime(new Date());
                gsAllocationBalanceMapper.updateByPrimaryKey(ungoods);
            } else {
                ungoods = new GsAllocationBalance();
                ungoods.setUpdateTime(new Date());
                ungoods.setCreateTime(new Date());
                ungoods.setCreateBy(cbba.getCbba05().longValue());

                ungoods.setQty(givenNum);
                ungoods.setGoodsId(cbba.getCbba08());
                gsAllocationBalanceMapper.insert(ungoods);

            }


        }
        return cbba;


    }

    //优先级由低到高
    private Cbba getOrderPriority(Cbba cbba, Integer oldPriority) {
        Double useNum = 0.0;
        if (!cbba.getCbba07().startsWith(TotalOrderConstants.GUONEIORDER)) {
            GsGoodsUseCriteria example = new GsGoodsUseCriteria();
            example.createCriteria().andGoodsIdEqualTo(cbba.getCbba08())
                    .andOrderNoEqualTo(cbba.getCbba07());
            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(example);
            useNum = gsGoodsUses.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));


        }
        Double makeNum = cbba.getCbba13() - useNum;

        if (makeNum.equals(cbba.getCbba09() - cbba.getCbba11())) {
            return cbba;
        }
        Double needNum = cbba.getCbba09() - cbba.getCbba11() - makeNum;
        Integer goodsId = cbba.getCbba08();
        List<Cbba> list = cbbaMapper.selectByPriorityDurelow2H(goodsId, cbba.getCbba15(), oldPriority);
        for (Cbba res : list) {
            //可拿去的分配数量
            Double getNum = res.getCbba13();
            if (getNum <= 0) {
                continue;
            }

            if (getNum >= needNum) {
                res.setCbba13(res.getCbba13() - needNum);
                needNum = needNum - needNum;
                res.setCbba04(new Date());
                cbbaMapper.updateByPrimaryKey(res);
                break;

            } else {
                res.setCbba13(9.0);
                needNum = needNum - getNum;
                res.setCbba04(new Date());
                cbbaMapper.updateByPrimaryKey(res);
                continue;
            }
        }
        return cbba;

    }

    /**
     * 更改总订单优先级的时候从高改到低
     *
     * @param cbba
     */
    private Cbba giveOrderPriority(Cbba cbba, Integer oldPriority) {
        // 国际订单可能会出现占用数量大于分配数量
        Double useNum = 0.0;
        if (!cbba.getCbba07().startsWith(TotalOrderConstants.GUONEIORDER)) {
            GsGoodsUseCriteria example = new GsGoodsUseCriteria();
            example.createCriteria().andGoodsIdEqualTo(cbba.getCbba08())
                    .andOrderNoEqualTo(cbba.getCbba07());
            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(example);
            useNum = gsGoodsUses.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));


        }

        //可以分给其他订单的数量分配数量减去占用数量
        Double makeNum = cbba.getCbba13() - useNum;
        if (makeNum == 0) {
            return cbba;
        }
        Integer goodsId = cbba.getCbba08();
        List<Cbba> list = cbbaMapper.selectByPriorityDureH2low(goodsId, cbba.getCbba15(), oldPriority);
        for (Cbba res : list) {
            if (!cbba.getCbba07().equals(res.getCbba07())) {
                //未发货数量
                Double orderNum = res.getCbba09() - res.getCbba11();
                Double resmakeNum = res.getCbba13();
                if (resmakeNum.equals(orderNum)) {
                    continue;
                }
                Double resneedNum = orderNum - resmakeNum;
                if (resneedNum < 0) {
                    continue;
                }

                if (resneedNum >= makeNum) {
                    res.setCbba13(res.getCbba13() + makeNum);
                    makeNum = 0.0;
                } else {
                    res.setCbba13(res.getCbba13() + resneedNum);
                    makeNum = makeNum - resneedNum;
                }
                res.setCbba04(new Date());
                cbbaMapper.updateByPrimaryKey(res);

                if (makeNum == 0) {
                    break;
                }

            }
        }
        cbba.setCbba13(makeNum);
        return cbba;


    }


    public Cbba getUnDistributionGoods(Cbba cbba, GsAllocationBalance gsAllocationBalance) {
        if (cbba == null) {
            return null;
        }

        if (gsAllocationBalance == null) {
            return cbba;
        }

        Double num = gsAllocationBalance.getQty();
        //生产数量
        Double makeNum = cbba.getCbba13();
        if (makeNum == null) {
            makeNum = 0.00;
        }
        //未发货数量
        Double orderNum = cbba.getCbba09() - cbba.getCbba11();
        if (orderNum == null) {
            orderNum = 0.00;
        }


        Double unNum = 0.00;
        if (num.doubleValue() > orderNum) {
            unNum = orderNum - makeNum;
        } else {
            Double cha = orderNum - makeNum;
            if (num.doubleValue() > cha) {
                unNum = num.doubleValue() - cha;
            } else {
                unNum = num.doubleValue();
            }

        }
        cbba.setCbba13(makeNum + unNum);
        gsAllocationBalance.setUpdateTime(new Date());
        gsAllocationBalance.setQty(gsAllocationBalance.getQty() - unNum.intValue());
        gsAllocationBalanceMapper.updateByPrimaryKey(gsAllocationBalance);
        return cbba;


    }

    public Cbba getOtherOrderMakeNum(Cbba cbba) {
        if (cbba == null) {
            return null;
        }

        List<Cbba> res = cbbaMapper.selectLowPriority(cbba);
        //先从优先级最低的取
        //未发货数量
        Double orderNum = cbba.getCbba09() - cbba.getCbba11();

        //已分配数量
        Double makeNum = cbba.getCbba13();
        if (makeNum == null) {
            makeNum = 0.00;
        }

        //需要分配的数量 未发货数量减去已分配的数量
        Double needMakeNum = orderNum - makeNum;
        //实际分配的数量
        Double realMakeNum = 0.0;
        for (Cbba re : res) {
            Double useNum = 0.0;
            if (!cbba.getCbba07().startsWith(TotalOrderConstants.GUONEIORDER)) {
                GsGoodsUseCriteria example = new GsGoodsUseCriteria();
                example.createCriteria().andGoodsIdEqualTo(cbba.getCbba08())
                        .andOrderNoEqualTo(cbba.getCbba07());
                List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(example);
                useNum = gsGoodsUses.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));


            }
            Double canuseNum = re.getCbba13() - useNum;
            if (canuseNum < 0) {
                continue;
            }

            if (canuseNum >= needMakeNum) {
                //如果可以使用的数量大于需要分配订单的所需数量
                realMakeNum = realMakeNum + needMakeNum;
                re.setCbba13(canuseNum - needMakeNum);
            } else {
                realMakeNum = realMakeNum + canuseNum;
                needMakeNum = needMakeNum - canuseNum;
                re.setCbba13(0.0);

            }
            re.setCbba04(new Date());
            cbbaMapper.updateByPrimaryKey(re);

        }

        cbba.setCbba13(cbba.getCbba13() + realMakeNum);
        return cbba;
    }


//        @Override
//    public Cbba purhaseOrderWarehousing(OrderDistributionDo orderDistributionDo) {
//        return null;
//    }

//    @Override
//    public Cbba purchaseWarehousing(OrderDistributionDo orderDistributionDo) {
//        return null;
//    }

    /**
     * 直接入库
     *
     * @param directWarehousingDto
     * @return
     */

    @Override
    public DirectWarehousingVo directWarehousing(DirectWarehousingDto directWarehousingDto) {
        try {
            lockOtherOrder();
            //
            //分配给总订单
            List<Cbba> list = cbbaMapper.selectByGoodsId(directWarehousingDto.getGoodsId());
            for (Cbba cbba : list) {
                Double needQty = cbba.getCbba09() - cbba.getCbba11() - cbba.getCbba13();
                if (needQty > 0) {
                    cbba.setCbba13(cbba.getCbba13() + 1);
                    cbba.setCbba04(new Date());
                    cbba.setCbba05(directWarehousingDto.getUserId());
                    cbbaMapper.updateByPrimaryKey(cbba);

                }
            }


        } finally {
            unLockOtherOrder();
        }
        return null;
    }

//    @Override
//    public Cbba purchaseExit(OrderDistributionDo orderDistributionDo) {
//        return null;
//    }

    /**
     * 销售订单出库  修改总订单的发货数量 修改销售订单的发货数量，减掉或者删除商品的占用数量
     *
     * @param saleOrderExitDo
     * @return
     */
    @Override
    public SaleOrderExitVo saleOrderExit(SaleOrderExitDo saleOrderExitDo) {
        try {
            lockTotalOrder();
            List<Cbba> cbbas = null;
            if (saleOrderExitDo.getOrderNo().startsWith(TotalOrderConstants.GUONEIORDER)) {
                //国内订单根据优先级来
                cbbas = cbbaMapper.selectByGoodsId(saleOrderExitDo.getGoodsId());

            } else {
                //国际订单可根据订单号查总订单
                CbbaCriteria baex = new CbbaCriteria();
                baex.createCriteria()
                        .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                        .andCbba07EqualTo(saleOrderExitDo.getOrderNo())
                        .andCbba12EqualTo(TotalOrderConstants.NO);
                cbbas = cbbaMapper.selectByExample(baex);

            }
            Double num = saleOrderExitDo.getQty();
            for (Cbba cbba : cbbas) {
                //减去分配数量 增加发货数量
                Double makNum = cbba.getCbba13();
                if(makNum>num){
                    cbba.setCbba13(makNum-num);
                    cbba.setCbba11(cbba.getCbba11()+num);
                    num=0.0;
                }else {

                }


            }

        } finally {
            unLockOtherOrder();
        }
        return null;
    }

    /**
     * 调拨单入库 另一个库的占用删掉，增加CDC仓库的占用
     *
     * @param orderDistributionDo
     * @return
     */

    @Override
    public Cbba transferOrder(OrderDistributionDo orderDistributionDo) {
        return null;
    }

    /**
     * 国际订单销售订单下单占用逻辑  国际订单确认库存操作
     *
     * @param goodsOperationDo
     * @return
     */
    @Override
    public SaleOrderMakeDo saleOrderMake(GoodsOperationDo goodsOperationDo) {
        SaleOrderMakeDo res = new SaleOrderMakeDo();
//        //国际订单是在确认库存后进行占用库存的操作
//        //国内订单是在销售下单的时候
//        //先判断库存是否够用
//        //国内订单判断库存是否可用通过仓库台账来判断 先锁商品表
        Cbpb cbpb = baseCheckService.checkGoodsForUpdate(goodsOperationDo.getGoodsId(), goodsOperationDo.getGoodsName());

        if (OrderTypeEnum.GUONEIDINGDAN.getCode().equals(goodsOperationDo.getOrderType())) {


            //查该商品的仓库台账
            List<Cbwa> list = cbwaMapper.selectCalculationOrderPriority();

            if (list.size() == 0) {
                throw new SwException("无可用分配库存的仓库");
            }

            Integer prompt = 2;
            Double num = goodsOperationDo.getNum();
            OutSuggestionsDo out = null;
            for (Cbwa cbwa : list) {
                //查台账
                Cbib cbib = cbibMapper.selectLastByGoodsIdAndStoreId(goodsOperationDo.getGoodsId(), cbwa.getCbwa01());
                if (cbib == null) {
                    continue;
                }

                if (cbib.getCbib15() == 0) {
                    continue;
                }
                //查占用
                List<GsGoodsUse> goodsUseList = gsGoodsUseMapper.selectByWhIdAndGoodsId(cbwa.getCbwa01(), goodsOperationDo.getGoodsId());
                Double useNum = goodsUseList.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));


                out = new OutSuggestionsDo();
                if (cbib.getCbib15() - useNum < num.doubleValue()) {
                    out.setQty(cbib.getCbib15() - useNum);
                    num = num - cbib.getCbib15() + useNum;
                } else {
                    out.setQty(num);
                    num = 0.0;
                }


                out.setWhId(cbwa.getCbwa01());
                out.setWhName(cbwa.getCbwa09());
                out.setGoodsId(goodsOperationDo.getGoodsId());
                out.setGoodsName(goodsOperationDo.getGoodsName());
                res.getList().add(out);

                //进行库存占用
                GsGoodsUse goodsUse = new GsGoodsUse();
                goodsUse.setCreateBy(goodsOperationDo.getUserId());
                goodsUse.setCreateTime(new Date());
                goodsUse.setGoodsId(goodsOperationDo.getGoodsId());
                goodsUse.setLockQty(out.getQty());
                goodsUse.setOrderNo(goodsOperationDo.getOrderNo());
                goodsUse.setOrderQty(goodsOperationDo.getOrderNum());
                goodsUse.setOrderType(goodsOperationDo.getOrderType().byteValue());
                goodsUse.setUpdateBy(goodsOperationDo.getUserId());
                goodsUse.setUpdateTime(new Date());
                goodsUse.setWhId(cbwa.getCbwa01());
                gsGoodsUseMapper.insert(goodsUse);

                if (num.equals(0.0)) {
                    break;
                }

            }
            if (num > 0.0) {
                //说明库存不够
                throw new ServiceException("选择的货物库存不够，请刷新后重试，商品：" + goodsOperationDo.getGoodsName());
            }

            if (res.getList().size() > 1) {
                prompt = 1;
            }

            res.setPrompt(prompt);
        } else {
            //国际订单库存是否可用通过生产总订单减去占用数量
            //国际订单只查GQW仓库
            CbbaCriteria example = new CbbaCriteria();
            example.createCriteria()
                    .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                    .andCbba12EqualTo(TotalOrderConstants.NO)
                    .andCbba08EqualTo(goodsOperationDo.getGoodsId())
                    .andCbba07NotLike("GBSH" + "%");
            List<Cbba> cbbas = cbbaMapper.selectByExample(example);
            Double sum = cbbas.stream().collect(Collectors.summingDouble(Cbba::getCbba13));

            CbwaCriteria whexample = new CbwaCriteria();
            whexample.createCriteria().andCbwa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                    .andCbwa15EqualTo(1)
                    .andCbwa09EqualTo(WareHouseType.GUOJIWAREHOUSE);
            List<Cbwa> cbwas = cbwaMapper.selectByExample(whexample);

            if (cbwas.size() == 0) {
                throw new ServiceException("没有可用的仓库");
            }

            //查询占用用的
            Double useNum = 0.0;
            for (Cbwa cbwa : cbwas) {
                GsGoodsUseCriteria useex = new GsGoodsUseCriteria();
                useex.createCriteria()
                        .andGoodsIdEqualTo(goodsOperationDo.getGoodsId())
                        .andWhIdEqualTo(cbwa.getCbwa01());
                List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(useex);
                for (GsGoodsUse gsGoodsUs : gsGoodsUses) {
                    useNum = useNum + gsGoodsUs.getLockQty();
                }
            }

            if (useNum + goodsOperationDo.getNum() > sum) {
                throw new ServiceException("您选择的商品库存不足，请刷新重试,商品：" + goodsOperationDo.getGoodsName());
            }

            //生成占用
            //进行库存占用
            GsGoodsUse goodsUse = new GsGoodsUse();
            goodsUse.setCreateBy(goodsOperationDo.getUserId());
            goodsUse.setCreateTime(new Date());
            goodsUse.setGoodsId(goodsOperationDo.getGoodsId());
            goodsUse.setLockQty(goodsOperationDo.getNum());
            goodsUse.setOrderNo(goodsOperationDo.getOrderNo());
            goodsUse.setOrderQty(goodsOperationDo.getNum());
            goodsUse.setOrderType(goodsOperationDo.getOrderType().byteValue());
            goodsUse.setUpdateBy(goodsOperationDo.getUserId());
            goodsUse.setUpdateTime(new Date());
            goodsUse.setWhId(cbwas.get(0).getCbwa01());
            gsGoodsUseMapper.insert(goodsUse);

        }
        return res;
    }

    /**
     * 释放库存占用，在销售订单取消的时候释放
     *
     * @param goodsOperationDo
     * @return
     */
    @Override
    public Cbba cancelOccupy(GoodsOperationDo goodsOperationDo) {
        return null;

    }

    @Override
    public QtyMsgVo checkSku(CheckSkuDo checkSkuDo) {

        //该库存检测适用于国内订单创建
        //查该商品的仓库台账
        List<Cbwa> list = cbwaMapper.selectCalculationOrderPriority();

        if (list.size() == 0) {
            throw new ServiceException("无可用分配库存的仓库");
        }

        Double canUseNum = 0.0;

        for (Cbwa cbwa : list) {
            //查台账
            Cbib cbib = cbibMapper.selectLastByGoodsIdAndStoreId(checkSkuDo.getGoodsId(), cbwa.getCbwa01());
            if (cbib == null) {
                continue;
            }

            if (cbib.getCbib15() == 0) {
                continue;
            }
            //查占用
            List<GsGoodsUse> goodsUseList = gsGoodsUseMapper.selectByWhIdAndGoodsId(cbwa.getCbwa01(), checkSkuDo.getGoodsId());
            Double useNum = goodsUseList.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
            Double num = cbib.getCbib15() - useNum;
            canUseNum = canUseNum + num;

        }

        QtyMsgVo res = new QtyMsgVo();
        res.setGoodsId(checkSkuDo.getGoodsId());
        res.setCanUseNum(canUseNum);


        return res;
    }

    /**
     * 修改库存占用（仅限国际订单）
     *
     * @param changeSkuUseDo
     * @return
     */
    @Override
    public ChangeSkuUseVo changeSkuUse(ChangeSkuUseDo changeSkuUseDo) {
        ChangeSkuUseVo res = new ChangeSkuUseVo();
        //判断是否是国际订单
        if (changeSkuUseDo.getOrderNo().startsWith(TotalOrderConstants.GUONEIORDER)) {
            throw new SwException("修改占用必须为国际订单");
        }

        CbbaCriteria baexample = new CbbaCriteria();
        baexample.createCriteria()
                .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCbba07EqualTo(changeSkuUseDo.getOrderNo());
        List<Cbba> cbbas = cbbaMapper.selectByExample(baexample);
        if (cbbas.size() == 0) {
            throw new SwException("没有查到该销售订单的生产总订单");
        }

        if (changeSkuUseDo.getQty() > cbbas.get(0).getCbba13()) {
            throw new SwException("修改的占用数量不能高于该生产总订单的分配数量");
        }

        //修改占用库存不能大于分配库存
        GsGoodsUseCriteria goodsEx = new GsGoodsUseCriteria();
        goodsEx.createCriteria()
                .andOrderNoEqualTo(changeSkuUseDo.getOrderNo())
                .andGoodsIdEqualTo(changeSkuUseDo.getGoodsId());
        List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(goodsEx);
        if (gsGoodsUses.size() == 0) {
            throw new SwException("没有查到该销售订单商品的占用");
        }

        GsGoodsUse goodsUse = gsGoodsUses.get(0);
        goodsUse.setUpdateBy(changeSkuUseDo.getUserId());
        goodsUse.setUpdateTime(new Date());
        goodsUse.setLockQty(changeSkuUseDo.getQty());
        gsGoodsUseMapper.updateByPrimaryKey(goodsUse);


        return res;
    }
}
