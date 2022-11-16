package com.ruoyi.system.service.gson.impl;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.constant.TotalOrderConstants;
import com.ruoyi.common.constant.WareHouseType;
import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.dto.DirectWarehousingDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.OrderDistributionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
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

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;

    @Resource
    private CbobMapper cbobMapper;

    @Resource
    private CboaMapper cboaMapper;


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
                throw new SwException("获得锁超时，请稍后重试");
            }
            Long aLong = lockMap.putIfAbsent(totalOrderkey, time);
            if (aLong != null) {
                //说明没占到锁
                //判断时间是否过期
                if (now - aLong > overTime) {
                    Long put = lockMap.put(totalOrderkey, now);
                    if (put.equals(aLong)) {
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
                throw new SwException("获得锁超时，请稍后重试");
            }
            Long aLong = lockMap.get(orderkey);
            if (aLong != null) {
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
                throw new SwException("获得锁超时，请稍后重试");
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
        Cbba cbba = null;
        try {
            //总订单重新分配 需要先判断其他订单有没有进行分配
//            lockTotalOrder();
            //判断是否有其他操作总订单的业务
//            ifHasOthOrder();

            //是修改生产订单还是创建生产订单
            //查未分配订单的数量
            GsAllocationBalance ungoods = gsAllocationBalanceMapper.selectByGoodsIdForUpdate(orderDistributionDo.getGoodsId());
            cbba = orderDistributionDo.getCbba();
            if (TotalOrderOperateEnum.MAKEORDER.getCode().equals(orderDistributionDo.getType())) {
                //创建
                //先查找未分配订单的数量创建把
                getUnDistributionGoods(cbba, ungoods);

                //优先级比这个订单低的未完成的订单的 分配数量减去占用数量分配给该订单
                if (!cbba.getCbba13().equals(cbba.getCbba09() - cbba.getCbba11())) {
                    getOtherOrderMakeNum(cbba);
                }


            } else if (TotalOrderOperateEnum.DELETE.getCode().equals(orderDistributionDo.getType())) {
                delgiveOrderPriority(cbba, orderDistributionDo.getOldPriority());
            } else {
                //此处修改分两种情况
                //1、修改优先级
                //2、修改数量
                if (TotalOrderOperateEnum.MDFPRIORITY.getCode().equals(orderDistributionDo.getType())) {
                    //优先级由高到低
                    if (orderDistributionDo.getPriority() < orderDistributionDo.getOldPriority()) {
                        getUnDistributionGoods(cbba, ungoods);
                        if (!cbba.getCbba13().equals(cbba.getCbba09() - cbba.getCbba11())) {
                            getOrderPriority(cbba, orderDistributionDo.getOldPriority());
                        }


                    } else {
                        //优先级由低到高
                        giveOrderPriority(cbba, orderDistributionDo.getOldPriority());

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
            lockMap.remove(totalOrderkey);
        }

        return cbba;
    }

    /**
     * 修改总订单数量从多变少
     *
     * @param cbba
     * @param oldNum
     * @param ungoods
     * @return
     */

    private Cbba giveOtherOrder(Cbba cbba, Double oldNum, GsAllocationBalance ungoods) {
        Double orderNum = cbba.getCbba09();
        //已分配的数量
        Double makeNum = cbba.getCbba13();

        //已占用的数量
//        Double useNum = cbba.getCbba14();
        Double useNum = 0.0;
//        if (!cbba.getCbba07().startsWith(TotalOrderConstants.GUONEIORDER)) {
//            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByTotalOrderNo(cbba.getCbba08(), cbba.getCbba07());
//            useNum = gsGoodsUses.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
//
//        }
        useNum=cbba.getCbba14();
        if (orderNum < useNum) {
            throw new SwException("修改订单数量不能小于该订单的占用数量");
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
        cbba.setCbba13(cbba.getCbba13() - givenNum);
        List<Cbba> res = cbbaMapper.selectLowPriority(cbba.getCbba08(), cbba.getCbba15(), cbba.getCbba01());
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
    private Cbba getOrderPriority(Cbba cbba, Long oldPriority) {


//        Double makeNum = cbba.getCbba13() - useNum;

//        if (makeNum.equals(cbba.getCbba09() - cbba.getCbba11())) {
//            return cbba;
//        }
        Double needNumOr = cbba.getCbba09() - cbba.getCbba11() - cbba.getCbba13();
        Double needNum = cbba.getCbba09() - cbba.getCbba11() - cbba.getCbba13();
        Integer goodsId = cbba.getCbba08();
//        List<Cbba> list = cbbaMapper.selectByPriorityDurelow2H(goodsId, Integer.valueOf(cbba.getCbba15()), Integer.valueOf(oldPriority),cbba.getCbba01());
        List<Cbba> list = cbbaMapper.selectByPriorityDurelow2H(goodsId, cbba.getCbba15(), oldPriority, cbba.getCbba01());
        for (Cbba res : list) {
            Double useNum = 0.0;
//            if (!res.getCbba07().startsWith(TotalOrderConstants.GUONEIORDER)) {
//
////            GsGoodsUseCriteria example = new GsGoodsUseCriteria();
////            example.createCriteria().andGoodsIdEqualTo(cbba.getCbba08())
////                    .andOrderNoEqualTo(cbba.getCbba07());
//                List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByTotalOrderNo(res.getCbba08(), res.getCbba07());
//                useNum = gsGoodsUses.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
//
//
//            }
            useNum=res.getCbba14();
            //可拿去的分配数量
            Double getNum = res.getCbba13() - useNum;
            if (getNum <= 0) {
                continue;
            }

            if (getNum >= needNum) {
                res.setCbba13(res.getCbba13() - needNum);
                needNum = 0.0;
                res.setCbba04(new Date());
                cbbaMapper.updateByPrimaryKey(res);
                break;

            } else {
                res.setCbba13(useNum);
                needNum = needNum - getNum;
                res.setCbba04(new Date());
                cbbaMapper.updateByPrimaryKey(res);
                continue;
            }
        }
        Double num = needNumOr - needNum;
        cbba.setCbba13(cbba.getCbba13() + num);
        return cbba;

    }

    /**
     * 更改总订单优先级的时候从高改到低
     *
     * @param cbba
     */
    private Cbba giveOrderPriority(Cbba cbba, Long oldPriority) {
        // 国际订单可能会出现占用数量大于分配数量
        Double useNum = 0.0;
//        if (!cbba.getCbba07().startsWith(TotalOrderConstants.GUONEIORDER)) {
////            GsGoodsUseCriteria example = new GsGoodsUseCriteria();
////            example.createCriteria().andGoodsIdEqualTo(cbba.getCbba08())
////                    .andOrderNoEqualTo(cbba.getCbba07());
////            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(example);
////            useNum = gsGoodsUses.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
//
//            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByTotalOrderNo(cbba.getCbba08(), cbba.getCbba07());
//            useNum = gsGoodsUses.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
//
//        }
        useNum=cbba.getCbba14();
        //可以分给其他订单的数量分配数量减去占用数量
        Double makeNum = cbba.getCbba13() - useNum;
        Double zjmakeNum = 0.0;
        if (makeNum == 0) {
            return cbba;
        }
        Integer goodsId = cbba.getCbba08();
        List<Cbba> list = cbbaMapper.selectByPriorityDureH2low(goodsId, cbba.getCbba15(), oldPriority, cbba.getCbba01());

        for (Cbba res : list) {
            if (res.getCbba01().equals(cbba.getCbba01())) {
                res.setCbba15(cbba.getCbba15());
            }

        }


        list = list.stream().sorted(Comparator.comparing(Cbba::getCbba15)).collect(Collectors.toList());


        for (Cbba res : list) {
            if (res.getCbba01().equals(cbba.getCbba01())) {

                Double orderNum = cbba.getCbba09() - res.getCbba11();
                Double resmakeNum = 0.0;
                if (resmakeNum.equals(orderNum)) {
                    continue;
                }
                Double resneedNum = orderNum - resmakeNum;
                if (resneedNum < 0) {
                    continue;
                }

                if (resneedNum >= makeNum) {
                    zjmakeNum = makeNum;
                    makeNum = 0.0;
                } else {
                    zjmakeNum = 0 + resneedNum;
                    makeNum = makeNum - resneedNum;
                }
                res.setCbba04(new Date());

//                cbbaMapper.updateByPrimaryKey(res);

                if (makeNum == 0) {
                    break;
                }
                continue;
            }
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


//        if(oldPriority>cbba.getCbba15()){
        //优先级从低到高

        if (zjmakeNum > 0.0) {

            if (makeNum > 0.0) {
                GsAllocationBalanceCriteria aex = new GsAllocationBalanceCriteria();
                aex.createCriteria()
                        .andGoodsIdEqualTo(goodsId);
                List<GsAllocationBalance> gsAllocationBalances = gsAllocationBalanceMapper.selectByExample(aex);
                if (gsAllocationBalances.size() > 0) {
                    GsAllocationBalance gsAllocationBalance = gsAllocationBalances.get(0);
                    gsAllocationBalance.setQty(gsAllocationBalance.getQty() + makeNum);
                    gsAllocationBalance.setUpdateTime(new Date());
                    gsAllocationBalanceMapper.updateByPrimaryKey(gsAllocationBalance);
                } else {
                    GsAllocationBalance gsAllocationBalance = new GsAllocationBalance();
                    gsAllocationBalance.setUpdateTime(new Date());
                    gsAllocationBalance.setQty(makeNum);
                    gsAllocationBalance.setGoodsId(goodsId);
                    gsAllocationBalance.setCreateTime(new Date());
                    gsAllocationBalanceMapper.insert(gsAllocationBalance);
                }
            }

            cbba.setCbba13(zjmakeNum);

        } else {
            cbba.setCbba13(makeNum);
        }

//            if(makeNum-cbba.getCbba09()>0.0){
//                GsAllocationBalanceCriteria aex=new GsAllocationBalanceCriteria();
//                aex.createCriteria()
//                        .andGoodsIdEqualTo(goodsId);
//                List<GsAllocationBalance> gsAllocationBalances = gsAllocationBalanceMapper.selectByExample(aex);
//                if(gsAllocationBalances.size()>0){
//                    GsAllocationBalance gsAllocationBalance = gsAllocationBalances.get(0);
//                    gsAllocationBalance.setQty(gsAllocationBalance.getQty()+makeNum-cbba.getCbba09());
//                    gsAllocationBalance.setUpdateTime(new Date());
//                    gsAllocationBalanceMapper.updateByPrimaryKey(gsAllocationBalance);
//                }else {
//                    GsAllocationBalance gsAllocationBalance = new GsAllocationBalance();
//                    gsAllocationBalance.setUpdateTime(new Date());
//                    gsAllocationBalance.setQty(makeNum-cbba.getCbba09());
//                    gsAllocationBalance.setGoodsId(goodsId);
//                    gsAllocationBalance.setCreateTime(new Date());
//                    gsAllocationBalanceMapper.insert(gsAllocationBalance);
//                }
//                cbba.setCbba13(cbba.getCbba09());
//            }else {
//
//                             cbba.setCbba13(makeNum);
//            }


//        }else {

        //        if(makeNum!=0.0){
//            GsAllocationBalanceCriteria aex=new GsAllocationBalanceCriteria();
//            aex.createCriteria()
//                    .andGoodsIdEqualTo(goodsId);
//            List<GsAllocationBalance> gsAllocationBalances = gsAllocationBalanceMapper.selectByExample(aex);
//            if(gsAllocationBalances.size()>0){
//                GsAllocationBalance gsAllocationBalance = gsAllocationBalances.get(0);
//                gsAllocationBalance.setQty(gsAllocationBalance.getQty()+makeNum);
//                gsAllocationBalance.setUpdateTime(new Date());
//                gsAllocationBalanceMapper.updateByPrimaryKey(gsAllocationBalance);
//            }else {
//                GsAllocationBalance gsAllocationBalance = new GsAllocationBalance();
//                gsAllocationBalance.setUpdateTime(new Date());
//                gsAllocationBalance.setQty(makeNum);
//                gsAllocationBalance.setGoodsId(goodsId);
//                gsAllocationBalance.setCreateTime(new Date());
//                gsAllocationBalanceMapper.insert(gsAllocationBalance);
//            }
//
//        }

//        }


        return cbba;


    }

    private Cbba delgiveOrderPriority(Cbba cbba, Long oldPriority) {
        // 国际订单可能会出现占用数量大于分配数量
        Double useNum = 0.0;

        if(cbba.getCbba14()!=0 || cbba.getCbba11()!=0){
            throw new SwException("删除失败，该生产总订单发货数量或占用数量不为0："+cbba.getCbba07());
        }

//        if (!cbba.getCbba07().startsWith(TotalOrderConstants.GUONEIORDER)) {
////            GsGoodsUseCriteria example = new GsGoodsUseCriteria();
////            example.createCriteria().andGoodsIdEqualTo(cbba.getCbba08())
////                    .andOrderNoEqualTo(cbba.getCbba07());
////            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(example);
////            useNum = gsGoodsUses.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
//
//            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByTotalOrderNo(cbba.getCbba08(), cbba.getCbba07());
//            useNum = gsGoodsUses.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
//
//        }
        useNum=cbba.getCbba14();
        //可以分给其他订单的数量分配数量减去占用数量
        Double makeNum = cbba.getCbba13() - useNum;
        if (makeNum == 0) {
            return cbba;
        }
        Integer goodsId = cbba.getCbba08();
//        List<Cbba> list = cbbaMapper.selectByPriorityDureH2low(goodsId, Integer.valueOf(cbba.getCbba15()), Integer.valueOf(oldPriority),cbba.getCbba01());
        List<Cbba> list = cbbaMapper.selectByOther(goodsId, cbba.getCbba01());

        if (list.size() == 0 && makeNum == 0.0) {
            return cbba;

        }
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

        if (makeNum != 0.0) {
            GsAllocationBalanceCriteria aex = new GsAllocationBalanceCriteria();
            aex.createCriteria()
                    .andGoodsIdEqualTo(goodsId);
            List<GsAllocationBalance> gsAllocationBalances = gsAllocationBalanceMapper.selectByExample(aex);
            if (gsAllocationBalances.size() > 0) {
                GsAllocationBalance gsAllocationBalance = gsAllocationBalances.get(0);
                gsAllocationBalance.setQty(gsAllocationBalance.getQty() + makeNum);
                gsAllocationBalance.setUpdateTime(new Date());
                gsAllocationBalanceMapper.updateByPrimaryKey(gsAllocationBalance);
            } else {
                GsAllocationBalance gsAllocationBalance = new GsAllocationBalance();
                gsAllocationBalance.setUpdateTime(new Date());
                gsAllocationBalance.setQty(makeNum);
                gsAllocationBalance.setGoodsId(goodsId);
                gsAllocationBalance.setCreateTime(new Date());
                gsAllocationBalanceMapper.insert(gsAllocationBalance);
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
                unNum = cha;
            } else {
                unNum = num.doubleValue();
            }

        }
        cbba.setCbba13(makeNum + unNum);
        gsAllocationBalance.setUpdateTime(new Date());
        gsAllocationBalance.setQty(gsAllocationBalance.getQty() - unNum.intValue());
        if (gsAllocationBalance.getQty() == 0) {
            gsAllocationBalanceMapper.deleteByPrimaryKey(gsAllocationBalance.getId());
        } else {
            gsAllocationBalanceMapper.updateByPrimaryKey(gsAllocationBalance);
        }

        return cbba;

    }

    public Cbba getOtherOrderMakeNum(Cbba cbba) {
        if (cbba == null) {
            return null;
        }

        List<Cbba> res = cbbaMapper.selectLowPriorityGet(cbba.getCbba08(), cbba.getCbba15(), cbba.getCbba01());
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
//            if (!cbba.getCbba07().startsWith(TotalOrderConstants.GUONEIORDER)) {
//                List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByTotalOrderNo(cbba.getCbba08(), cbba.getCbba07());
//                useNum = gsGoodsUses.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
//
//
//            }
            useNum=re.getCbba14();
            Double canuseNum = re.getCbba13() - useNum;
            if (canuseNum < 0) {
                continue;
            }

            if (canuseNum >= needMakeNum) {
                //如果可以使用的数量大于需要分配订单的所需数量
                realMakeNum = realMakeNum + needMakeNum;
                re.setCbba13( re.getCbba13() - needMakeNum);
                needMakeNum = 0.0;
            } else {
                realMakeNum = realMakeNum + canuseNum;
                needMakeNum = needMakeNum - canuseNum;
                re.setCbba13(re.getCbba13()-canuseNum);

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
//            lockOtherOrder();
            DirectWarehousingVo res = new DirectWarehousingVo();
            //
            //分配给总订单
            List<Cbba> list = cbbaMapper.selectByGoodsId(directWarehousingDto.getGoodsId());
            Boolean give = false;
            for (Cbba cbba : list) {
                Double needQty = cbba.getCbba09() - cbba.getCbba11() - cbba.getCbba13();
                if (needQty > 0) {
                    give = true;

                    if (TotalOrderConstants.GUONEIORDER.equals(cbba.getCbba07())) {
                        res.setOrderType(2);
                    } else {
                        res.setOrderType(1);
                    }
                    cbba.setCbba13(cbba.getCbba13() + 1);
                    cbba.setCbba04(new Date());
                    cbba.setCbba05(directWarehousingDto.getUserId());


                    cbbaMapper.updateByPrimaryKey(cbba);
                    break;

                }
            }
            if (!give) {
                GsAllocationBalanceCriteria baex = new GsAllocationBalanceCriteria();
                baex.createCriteria()
                        .andGoodsIdEqualTo(directWarehousingDto.getGoodsId());
                List<GsAllocationBalance> gsAllocationBalances = gsAllocationBalanceMapper.selectByExample(baex);
                if (gsAllocationBalances.size() > 0) {
                    GsAllocationBalance gsAllocationBalance = gsAllocationBalances.get(0);
                    gsAllocationBalance.setQty(gsAllocationBalance.getQty() + 1);
                    gsAllocationBalance.setUpdateTime(new Date());
                    gsAllocationBalanceMapper.updateByPrimaryKey(gsAllocationBalance);
                } else {
                    GsAllocationBalance gsAllocationBalance = new GsAllocationBalance();
                    gsAllocationBalance.setGoodsId(directWarehousingDto.getGoodsId());
                    gsAllocationBalance.setCreateTime(new Date());
                    gsAllocationBalance.setQty(new Double(1));
                    gsAllocationBalance.setUpdateTime(new Date());
                    gsAllocationBalanceMapper.insert(gsAllocationBalance);
                }

            }


            return res;


        } finally {
//            unLockOtherOrder();
        }

    }

    @Override
    public DirectWarehousingVo deldirectWarehousing(DirectWarehousingDto directWarehousingDto) {
        try {
//            lockOtherOrder();
            DirectWarehousingVo res = new DirectWarehousingVo();
            //
            GsAllocationBalanceCriteria baex = new GsAllocationBalanceCriteria();
            baex.createCriteria()
                    .andGoodsIdEqualTo(directWarehousingDto.getGoodsId());
            List<GsAllocationBalance> gsAllocationBalances = gsAllocationBalanceMapper.selectByExample(baex);
            Integer giveQty=1;
            if(gsAllocationBalances.size()>0){
                GsAllocationBalance gsAllocationBalance = gsAllocationBalances.get(0);
                if(gsAllocationBalance.getQty()>0){
                    gsAllocationBalance.setQty(gsAllocationBalance.getQty()-1);
                    gsAllocationBalance.setUpdateTime(new Date());
                    gsAllocationBalanceMapper.updateByPrimaryKey(gsAllocationBalance);
                    giveQty=0;
                }
            }
            if(giveQty!=0){
                //分配给总订单
                List<Cbba> list = cbbaMapper.selectByGoodsIdGive(directWarehousingDto.getGoodsId());

                for (Cbba cbba : list) {
                    Double hasqty=cbba.getCbba13()-cbba.getCbba14();
                    if(hasqty>0){
                        cbba.setCbba13(cbba.getCbba13()-1);
                        cbbaMapper.updateByPrimaryKey(cbba);
                        giveQty=0;
                    }
                    if(giveQty==0){
                        break;
                    }
                }
            }
            if(giveQty!=0){
                throw new SwException("无法删除,已经被总订单占用");
            }

           return res;


        } finally {
//            unLockOtherOrder();
        }

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
    @Transactional
    @Override
    public SaleOrderExitVo saleOrderExit(SaleOrderExitDo saleOrderExitDo) {

        log.info("销售出库回写订单参数"+JSON.toJSON(saleOrderExitDo));
        SaleOrderExitVo saleOrderExitVo = new SaleOrderExitVo();
        try {
            //   lockTotalOrder();
            List<Cbba> cbbas = new ArrayList<>();
            Cbob thiscbob = cbobMapper.selectByPrimaryKey(saleOrderExitDo.getCbobId());
            if(thiscbob==null){
                throw new SwException("没有查到销售订单明细");
            }

            Cboa cboa = cboaMapper.selectByPrimaryKey(thiscbob.getCboa01());
            if(cboa==null){
                throw new SwException("没有查到销售订单");
            }
            if (cboa.getCboa27() == 2) {
                //国内订单根据优先级来
                //如果出库仓库是GQW
                if(WareHouseType.GQWWHID.equals(saleOrderExitDo.getWhId())){
                    cbbas = cbbaMapper.selectByGoodsId(saleOrderExitDo.getGoodsId());
                }


            } else {
                //国际订单可根据订单号查总订单
//                CbbaCriteria baex = new CbbaCriteria();
//                baex.createCriteria()
//                        .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
//                        .andCbba07EqualTo(saleOrderExitDo.getOrderNo())
//                        .andCbba12EqualTo(TotalOrderConstants.NO);
//                cbbas = cbbaMapper.selectByExample(baex);
//                Cbob cbob = cbobMapper.selectByPrimaryKey(saleOrderExitDo.getCbobId());
//                if (cbob == null) {
//                    throw new SwException("没有查到该出库单的销售订单明细");
//                }

                if (thiscbob.getCbob17() == null) {
                    throw new SwException("没有查到该出库单的生产总订单");

                }
                Cbba cbba = cbbaMapper.selectByPrimaryKey(thiscbob.getCbob17());
                if (cbba == null) {
                    throw new SwException("没有查到该出库单的生产总订单");

                }
                cbbas.add(cbba);


            }
            Double num = saleOrderExitDo.getQty();
//            Double subNum=0.0;
            for (Cbba cbba : cbbas) {
                //减去分配数量 增加发货数量
                Double subNum = 0.0;
                Double makNum = cbba.getCbba13();
                if (makNum > num) {
                    cbba.setCbba13(makNum - num);
                    cbba.setCbba11(cbba.getCbba11() + num);
                    cbba.setCbba14(cbba.getCbba14()-num);
                    num = 0.0;

                } else {

                    cbba.setCbba13(0.0);
                    cbba.setCbba11(cbba.getCbba11() + makNum);
                    cbba.setCbba14(cbba.getCbba14()-makNum);
                    num = num - makNum;

                }

                if (cbba.getCbba11().equals(cbba.getCbba09())) {
                    cbba.setCbba12(4);
                }


                cbbaMapper.updateByPrimaryKey(cbba);
                if (num == 0.0) {
                    break;
                }

            }


            //扣除占用数量

            GsGoodsUseCriteria usex = new GsGoodsUseCriteria();
            usex.createCriteria()
                    .andGoodsIdEqualTo(saleOrderExitDo.getGoodsId())
                    .andWhIdEqualTo(saleOrderExitDo.getWhId());
//                    .andOrderNoEqualTo(saleOrderExitDo.getOrderNo());
            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(usex);
            Double qty = saleOrderExitDo.getQty();


            for (GsGoodsUse gsGoodsUs : gsGoodsUses) {
                if(qty>gsGoodsUs.getLockQty()){

                        gsGoodsUseMapper.deleteByPrimaryKey(gsGoodsUs.getId());

                }else {
                    gsGoodsUs.setLockQty(gsGoodsUs.getLockQty() - qty);
                    gsGoodsUs.setUpdateTime(new Date());
                    if (gsGoodsUs.getLockQty() == 0.0) {
                        gsGoodsUseMapper.deleteByPrimaryKey(gsGoodsUs.getId());
                    } else {
                        gsGoodsUseMapper.updateByPrimaryKey(gsGoodsUs);
                    }
                }


                if(qty==0.0){
                    break;
                }
            }


            Integer sendNum = 0;
//            if (cboas.size() > 0) {
//                Cboa cboa = cboas.get(0);

                CbobCriteria obex=new CbobCriteria();
                obex.createCriteria()
                        .andCboa01EqualTo(cboa.getCboa01());
                List<Cbob> cbobs = cbobMapper.selectByExample(obex);
                for (Cbob cbob : cbobs) {
                    if (cbob.getCbob09().equals(cbob.getCbob10())) {
                        sendNum = sendNum + 1;
                        continue;
                    }
                    if (cbob.getCbob01().equals(thiscbob.getCbob01())) {
                        if (cbob.getCbob09().equals(cbob.getCbob10() + saleOrderExitDo.getQty())) {
                            cbob.setCbob10(cbob.getCbob10() + saleOrderExitDo.getQty());
                            cbobMapper.updateByPrimaryKey(cbob);
                            sendNum = sendNum + 1;
                        }else {
                            cbob.setCbob10(cbob.getCbob10() + saleOrderExitDo.getQty());
                            cbobMapper.updateByPrimaryKey(cbob);
                        }
                    }

                }

                if (sendNum.equals(cbobs.size())) {
                    cboa.setCboa04(new Date());
                    cboa.setCboa11(SaleOrderStatusEnums.YIWANCHENG.getCode());
                    cboaMapper.updateByPrimaryKey(cboa);
                }
//            }
//        throw new SwException("czsb");
        } finally {
            // unLockOtherOrder();
        }
        return saleOrderExitVo;
    }

    /**
     * 调拨单入库 另一个库的占用删掉，增加CDC仓库的占用
     *
     * @param transferOrderDo
     * @return
     */
    @Transactional
    @Override
    public TransferOrderVo transferOrder(TransferOrderDo transferOrderDo) {
        //分两种情况 基于销售订单的调拨 和不基于销售订单的调拨
        List<GsGoodsSku> list = gsGoodsSkuMapper.selectByGoodsIdAndWhIdForUpdate(transferOrderDo.getGoodsId(), transferOrderDo.getOutWhId());
        for (GsGoodsSku gsGoodsSku : list) {
            gsGoodsSku.setUpdateTime(new Date());
            gsGoodsSku.setUpdateBy(transferOrderDo.getUserId());
            Double qty = transferOrderDo.getQty() - transferOrderDo.getQty();
            gsGoodsSku.setQty(qty < 0 ? 0 : qty);
            gsGoodsSkuMapper.updateByPrimaryKey(gsGoodsSku);

        }
        List<GsGoodsSku> outs = gsGoodsSkuMapper.selectByGoodsIdAndWhIdForUpdate(transferOrderDo.getGoodsId(), transferOrderDo.getInWhId());
        for (GsGoodsSku gsGoodsSku : outs) {
            gsGoodsSku.setUpdateTime(new Date());
            gsGoodsSku.setUpdateBy(transferOrderDo.getUserId());
            Double qty = transferOrderDo.getQty() + transferOrderDo.getQty();
            gsGoodsSku.setQty(qty < 0 ? 0 : qty);
            gsGoodsSkuMapper.updateByPrimaryKey(gsGoodsSku);

        }
        if (StringUtils.isBlank(transferOrderDo.getOrderNo())) {
            //不基于销售订单的调拨，只需要去掉转出仓库的库存占用
            GsGoodsUseCriteria example = new GsGoodsUseCriteria();
            example.createCriteria()
                    .andGoodsIdEqualTo(transferOrderDo.getGoodsId())
                    .andTransNoEqualTo(transferOrderDo.getTransNo())
                    .andWhIdEqualTo(transferOrderDo.getOutWhId());
            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(example);
            for (GsGoodsUse gsGoodsUs : gsGoodsUses) {
                Double lockQty = gsGoodsUs.getLockQty() - transferOrderDo.getQty();
                if (lockQty > 0) {
                    gsGoodsUs.setLockQty(lockQty);
                    gsGoodsUs.setUpdateTime(new Date());
                    gsGoodsUs.setUpdateBy(transferOrderDo.getUserId());
                    gsGoodsUseMapper.updateByPrimaryKey(gsGoodsUs);
                } else {
                    gsGoodsUseMapper.deleteByPrimaryKey(gsGoodsUs.getId());
                }

            }


        } else {
            //基于销售订单的调拨 ，需要去掉转出仓库的库存占用 增加转入仓库的库存占用
            GsGoodsUseCriteria example = new GsGoodsUseCriteria();
            example.createCriteria()
                    .andGoodsIdEqualTo(transferOrderDo.getGoodsId())
                    .andOrderNoEqualTo(transferOrderDo.getOrderNo())
                    .andWhIdEqualTo(transferOrderDo.getOutWhId());

            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(example);
            for (GsGoodsUse gsGoodsUs : gsGoodsUses) {
                Double lockQty = gsGoodsUs.getLockQty() - transferOrderDo.getQty();
                if (lockQty > 0) {
                    gsGoodsUs.setLockQty(lockQty);
                    gsGoodsUs.setUpdateTime(new Date());
                    gsGoodsUs.setUpdateBy(transferOrderDo.getUserId());
                    gsGoodsUseMapper.updateByPrimaryKey(gsGoodsUs);
                } else {
                    gsGoodsUseMapper.deleteByPrimaryKey(gsGoodsUs.getId());
                }

            }

            //增加转入仓的库存占用

            GsGoodsUseCriteria outExample = new GsGoodsUseCriteria();
            example.createCriteria()
                    .andGoodsIdEqualTo(transferOrderDo.getGoodsId())
                    .andOrderNoEqualTo(transferOrderDo.getOrderNo())
                    .andWhIdEqualTo(transferOrderDo.getInWhId());

            List<GsGoodsUse> outUses = gsGoodsUseMapper.selectByExample(outExample);

            if (outUses.size() == 0) {
                //新建
                GsGoodsUse use = new GsGoodsUse();
                use.setUpdateBy(transferOrderDo.getUserId());
                use.setUpdateTime(new Date());
                use.setLockQty(transferOrderDo.getQty());
                use.setWhId(transferOrderDo.getInWhId());
                if (transferOrderDo.getOrderNo().contains(TotalOrderConstants.GUONEIORDER)) {
                    use.setOrderType(OrderTypeEnum.GUONEIDINGDAN.getCode().byteValue());
                } else {
                    use.setOrderType(OrderTypeEnum.GUOJIDINGDAN.getCode().byteValue());
                }

                use.setOrderNo(transferOrderDo.getOrderNo());
                use.setOrderQty(transferOrderDo.getOrderQty());
                use.setGoodsId(transferOrderDo.getGoodsId());
                use.setCreateTime(new Date());
                use.setCreateBy(transferOrderDo.getUserId());
                use.setTransNo(transferOrderDo.getTransNo());
                gsGoodsUseMapper.insert(use);

            } else {
                //更新
                for (GsGoodsUse gsGoodsUs : outUses) {
                    Double lockQty = gsGoodsUs.getLockQty() + transferOrderDo.getQty();
                    if (lockQty > 0) {
                        gsGoodsUs.setLockQty(lockQty);
                        gsGoodsUs.setUpdateTime(new Date());
                        gsGoodsUs.setUpdateBy(transferOrderDo.getUserId());
                        gsGoodsUseMapper.updateByPrimaryKey(gsGoodsUs);
                    }

                }
            }


        }


        return null;
    }

//    /**
//     * 国际订单销售订单下单占用逻辑  国际订单确认库存操作
//     *
//     * @param goodsOperationDo
//     * @return
//     */
//    @Override
//    public SaleOrderMakeDo saleOrderMake(GoodsOperationDo goodsOperationDo) {
//        SaleOrderMakeDo res = new SaleOrderMakeDo();
////        //国际订单是在确认库存后进行占用库存的操作
////        //国内订单是在销售下单的时候
////        //先判断库存是否够用
////        //国内订单判断库存是否可用通过仓库台账来判断 先锁商品表
//        Cbpb cbpb = baseCheckService.checkGoodsForUpdate(goodsOperationDo.getGoodsId(), goodsOperationDo.getGoodsName());
//        goodsOperationDo.setGoodsName(cbpb.getCbpb12());
//        if (OrderTypeEnum.GUONEIDINGDAN.getCode().equals(goodsOperationDo.getOrderType())) {
//
//
//            //查该商品的仓库台账
//            List<Cbwa> list = cbwaMapper.selectCalculationOrderPriority();
//
//            if (list.size() == 0) {
//                throw new SwException("无可用分配库存的仓库");
//            }
//
//            Integer prompt = 2;
//            Double num = goodsOperationDo.getNum();
//            OutSuggestionsDo out = null;
//            for (Cbwa cbwa : list) {
//                Double canUseNum=0.0;
//                Double useNum=0.0;
//                if(!WareHouseType.GUOJIWAREHOUSE.equals(cbwa.getCbwa09())){
//                    //查台账
//                    Cbib cbib = cbibMapper.selectLastByGoodsIdAndStoreId(goodsOperationDo.getGoodsId(), cbwa.getCbwa01());
//                    if (cbib == null) {
//                        continue;
//                    }
//
//                    if (cbib.getCbib15() == 0) {
//                        continue;
//                    }
//                    //查占用
//                    List<GsGoodsUse> goodsUseList = gsGoodsUseMapper.selectByWhIdAndGoodsId(cbwa.getCbwa01(), goodsOperationDo.getGoodsId());
//                     useNum = goodsUseList.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
//                    canUseNum=cbib.getCbib15();
//                }else {
//                            //再查GQW的 gqw分配给GBSH开头的订单的分配数量 -占用数量
//                            CbbaCriteria baex=new CbbaCriteria();
//                            baex.createCriteria()
//                                    .andCbba08EqualTo(goodsOperationDo.getGoodsId())
//                                    .andCbba07Like("GBSH"+"%");
//                            List<Cbba> cbbas = cbbaMapper.selectByExample(baex);
//        //            Double countQty=gsGoodsSkus.stream().mapToDouble(GsGoodsSku::getQty).sum();
//
//                             canUseNum=cbbas.stream().mapToDouble(Cbba::getCbba13).sum();
//
//                            //查占用数量
//                            GsGoodsUseCriteria gqwEx=new GsGoodsUseCriteria();
//                            gqwEx.createCriteria()
//                                    .andWhIdEqualTo(WareHouseType.GQWWHID)
//                                    .andGoodsIdEqualTo(goodsOperationDo.getGoodsId());
//                            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(gqwEx);
//                             useNum = gsGoodsUses.stream().mapToDouble(GsGoodsUse::getLockQty).sum();
//
//        //            gqw仓库数据
//        //                    Double gqwQty=gqwMakeQty-sum;
//
////                            if(gqwQty<0){
////                                gqwQty=0.0;
////                            }
//
////                            num=num+gqwMakeQty;
//                }
//
//
//
//                out = new OutSuggestionsDo();
//                if (canUseNum - useNum < num.doubleValue()) {
//                    out.setQty(canUseNum - useNum);
//                    num = num - canUseNum + useNum;
//                } else {
//                    out.setQty(num);
//                    num = 0.0;
//                }
//
//
//                out.setWhId(cbwa.getCbwa01());
//                out.setWhName(cbwa.getCbwa09());
//                out.setGoodsId(goodsOperationDo.getGoodsId());
//                out.setGoodsName(goodsOperationDo.getGoodsName());
//                res.getList().add(out);
//
//                //进行库存占用
//                if(out.getQty()==0){
//                    continue;
//                }
//                GsGoodsUse goodsUse = new GsGoodsUse();
//                goodsUse.setCreateBy(goodsOperationDo.getUserId());
//                goodsUse.setCreateTime(new Date());
//                goodsUse.setGoodsId(goodsOperationDo.getGoodsId());
//                goodsUse.setLockQty(out.getQty());
//                goodsUse.setOrderNo(goodsOperationDo.getOrderNo());
//                goodsUse.setOrderQty(goodsOperationDo.getOrderNum());
//                goodsUse.setOrderType(goodsOperationDo.getOrderType().byteValue());
//                goodsUse.setUpdateBy(goodsOperationDo.getUserId());
//                goodsUse.setUpdateTime(new Date());
//                goodsUse.setWhId(cbwa.getCbwa01());
//                goodsUse.setNoOutQty(0.0);
//                gsGoodsUseMapper.insert(goodsUse);
//
//                if (num.equals(0.0)) {
//                    break;
//                }
//
//            }
//
//
//
//            if (num > 0.0) {
//                //说明库存不够
//                throw new SwException("选择的货物库存不够，请刷新后重试，商品：" + goodsOperationDo.getGoodsName());
//            }
//
//            if (res.getList().size() > 0) {
//                prompt = 1;
//            }
//
//            res.setPrompt(prompt);
//        } else {
//            //国际订单库存是否可用通过生产总订单减去占用数量
//            //国际订单只查GQW仓库
//            CbbaCriteria example = new CbbaCriteria();
//            example.createCriteria()
//                    .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
//                    .andCbba12EqualTo(TotalOrderConstants.NO)
//                    .andCbba08EqualTo(goodsOperationDo.getGoodsId())
//                    .andCbba07NotLike("GBSH" + "%");
//            List<Cbba> cbbas = cbbaMapper.selectByExample(example);
//            Double sum = cbbas.stream().collect(Collectors.summingDouble(Cbba::getCbba13));
//
//            CbwaCriteria whexample = new CbwaCriteria();
//            whexample.createCriteria().andCbwa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
//                    .andCbwa08EqualTo("启用")
//                    .andCbwa09EqualTo(WareHouseType.GUOJIWAREHOUSE);
//            List<Cbwa> cbwas = cbwaMapper.selectByExample(whexample);
//
//            if (cbwas.size() == 0) {
//                throw new SwException("没有可用的仓库");
//            }
//
//            //查询占用用的
////            Double useNum = 0.0;
////            for (Cbwa cbwa : cbwas) {
////                GsGoodsUseCriteria useex = new GsGoodsUseCriteria();
////                useex.createCriteria()
////                        .andGoodsIdEqualTo(goodsOperationDo.getGoodsId())
////                        .andWhIdEqualTo(cbwa.getCbwa01());
////                List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(useex);
////                for (GsGoodsUse gsGoodsUs : gsGoodsUses) {
////                    useNum = useNum + gsGoodsUs.getLockQty();
////                }
////            }
//
////            if (useNum + goodsOperationDo.getNum() > sum) {
////                throw new SwException("您选择的商品库存不足，请刷新重试,商品：" + goodsOperationDo.getGoodsName());
////            }
//
//            //生成占用
//            //进行库存占用
////            GsGoodsUse goodsUse = new GsGoodsUse();
////            goodsUse.setCreateBy(goodsOperationDo.getUserId());
////            goodsUse.setCreateTime(new Date());
////            goodsUse.setGoodsId(goodsOperationDo.getGoodsId());
////            goodsUse.setLockQty(goodsOperationDo.getNum());
////            goodsUse.setOrderNo(goodsOperationDo.getOrderNo());
////            goodsUse.setOrderQty(goodsOperationDo.getNum());
////            byte b = goodsOperationDo.getOrderType().byteValue();
////            goodsUse.setOrderType(b);
////            goodsUse.setUpdateBy(goodsOperationDo.getUserId());
////            goodsUse.setUpdateTime(new Date());
////            goodsUse.setWhId(cbwas.get(0).getCbwa01());
////            gsGoodsUseMapper.insert(goodsUse);
//
//        }
//        return res;
//    }

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
        goodsOperationDo.setGoodsName(cbpb.getCbpb12());
        Date date = new Date();

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
                List<Cbba> cbbas =new ArrayList<>();
                Double canUseNum = 0.0;
                Double useNum = 0.0;
                if (!WareHouseType.GUOJIWAREHOUSE.equals(cbwa.getCbwa09())) {
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
                    useNum = goodsUseList.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
                    canUseNum = cbib.getCbib15()-useNum;
                } else {

                    //再查GQW的 gqw分配给GBSH开头的订单的分配数量 -占用数量
                    CbbaCriteria baex = new CbbaCriteria();
                    baex.createCriteria()
                            .andCbba08EqualTo(goodsOperationDo.getGoodsId())
                            .andCbba12EqualTo(TotalOrderConstants.NO)
                            .andCbba07Like("%"+"GBSH" + "%");
                    baex.setOrderByClause("CBBA15 asc");
                    cbbas = cbbaMapper.selectByExample(baex);
                    //            Double countQty=gsGoodsSkus.stream().mapToDouble(GsGoodsSku::getQty).sum();

//                    canUseNum = cbbas.stream().mapToDouble(Cbba::getCbba13).sum();

                    for (Cbba cbba : cbbas) {
                      Double cbbausenum=  cbba.getCbba13()-cbba.getCbba14();
                      canUseNum=canUseNum+cbbausenum;
                    }
                    //查占用数量
//                    GsGoodsUseCriteria gqwEx = new GsGoodsUseCriteria();
//                    gqwEx.createCriteria()
//                            .andWhIdEqualTo(WareHouseType.GQWWHID)
//                            .andGoodsIdEqualTo(goodsOperationDo.getGoodsId());
//                    List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(gqwEx);
//                    useNum = gsGoodsUses.stream().mapToDouble(GsGoodsUse::getLockQty).sum();

                    //            gqw仓库数据
                    //                    Double gqwQty=gqwMakeQty-sum;

//                            if(gqwQty<0){
//                                gqwQty=0.0;
//                            }

//                            num=num+gqwMakeQty;
                }


                out = new OutSuggestionsDo();
                if (canUseNum  < num.doubleValue()) {
                    out.setQty(canUseNum );
                    num = num - canUseNum ;
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
                if (out.getQty() == 0) {
                    continue;
                }
                GsGoodsUseCriteria usex=new GsGoodsUseCriteria();
                usex.createCriteria()
                        .andWhIdEqualTo(cbwa.getCbwa01())
                        .andGoodsIdEqualTo(goodsOperationDo.getGoodsId());
                List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(usex);
                if(gsGoodsUses.size()>0){
                    GsGoodsUse goodsUse =gsGoodsUses.get(0);

                    goodsUse.setLockQty(goodsUse.getLockQty()+out.getQty());
//
                    goodsUse.setUpdateTime(new Date());

                    gsGoodsUseMapper.updateByPrimaryKey(goodsUse);
                }else {
                    GsGoodsUse goodsUse = new GsGoodsUse();
                    goodsUse.setCreateBy(goodsOperationDo.getUserId());
                    goodsUse.setCreateTime(new Date());
                    goodsUse.setGoodsId(goodsOperationDo.getGoodsId());
                    goodsUse.setLockQty(out.getQty());
//                goodsUse.setOrderNo(goodsOperationDo.getOrderNo());
                    goodsUse.setOrderQty(goodsOperationDo.getOrderNum());
                    goodsUse.setOrderType(goodsOperationDo.getOrderType().byteValue());
                    goodsUse.setUpdateBy(goodsOperationDo.getUserId());
                    goodsUse.setUpdateTime(new Date());
                    goodsUse.setWhId(cbwa.getCbwa01());
                    goodsUse.setNoOutQty(0.0);
                    gsGoodsUseMapper.insert(goodsUse);
                }
                Double qty = out.getQty();

                for (Cbba cbba : cbbas) {
                  Double canuseqty=  cbba.getCbba13()-cbba.getCbba14();
                    if(canuseqty>qty){
                        cbba.setCbba14(cbba.getCbba14()+qty);
                        qty=0.0;
                        cbba.setCbba04(date);
                        cbbaMapper.updateByPrimaryKey(cbba);
                    }else {
                        cbba.setCbba14(cbba.getCbba13());
                        qty=qty-canUseNum;
                        cbba.setCbba04(date);
                        cbbaMapper.updateByPrimaryKey(cbba);
                    }
                    if(qty==0.0){
                        break;
                    }
                }


                if (num.equals(0.0)) {
                    break;
                }

            }


            if (num > 0.0) {
                //说明库存不够
                throw new SwException("选择的货物库存不够，请刷新后重试，商品：" + goodsOperationDo.getGoodsName());
            }

            if (res.getList().size() > 0) {
                prompt = 1;
            }

            res.setPrompt(prompt);
        } else {
            //国际订单库存是否可用通过生产总订单减去占用数量
            //国际订单只查GQW仓库
//            CbbaCriteria example = new CbbaCriteria();
//            example.createCriteria()
//                    .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
//                    .andCbba12EqualTo(TotalOrderConstants.NO)
//                    .andCbba08EqualTo(goodsOperationDo.getGoodsId())
//                    .andCbba07NotLike("GBSH" + "%");
//            List<Cbba> cbbas = cbbaMapper.selectByExample(example);
//            Double sum = cbbas.stream().collect(Collectors.summingDouble(Cbba::getCbba13));
//
//            CbwaCriteria whexample = new CbwaCriteria();
//            whexample.createCriteria().andCbwa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
//                    .andCbwa08EqualTo("启用")
//                    .andCbwa09EqualTo(WareHouseType.GUOJIWAREHOUSE);
//            List<Cbwa> cbwas = cbwaMapper.selectByExample(whexample);
//
//            if (cbwas.size() == 0) {
//                throw new SwException("没有可用的仓库");
//            }


            GsGoodsUseCriteria useex = new GsGoodsUseCriteria();
            useex.createCriteria()
                    .andWhIdEqualTo(WareHouseType.GQWWHID)
                    .andGoodsIdEqualTo(goodsOperationDo.getGoodsId());
            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(useex);
            if (gsGoodsUses.size() == 0) {
                GsGoodsUse goodsUse = new GsGoodsUse();
                goodsUse.setCreateBy(goodsOperationDo.getUserId());

                goodsUse.setCreateTime(new Date());
                goodsUse.setGoodsId(goodsOperationDo.getGoodsId());
                goodsUse.setLockQty(goodsOperationDo.getNum());
                byte b = goodsOperationDo.getOrderType().byteValue();
                goodsUse.setOrderType(b);
                goodsUse.setUpdateBy(goodsOperationDo.getUserId());
                goodsUse.setUpdateTime(new Date());
                goodsUse.setWhId(WareHouseType.GQWWHID);
                gsGoodsUseMapper.insert(goodsUse);
            }else {
                GsGoodsUse goodsUse = gsGoodsUses.get(0);
                goodsUse.setLockQty(goodsUse.getLockQty()+goodsOperationDo.getNum());
                goodsUse.setUpdateTime(new Date());
                gsGoodsUseMapper.updateByPrimaryKey(goodsUse);
            }

            //增加相关生产总订单的占用

            CbbaCriteria baex=new CbbaCriteria();
            baex.createCriteria()
                    .andCbba08EqualTo(goodsOperationDo.getGoodsId())
                    .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                    .andCbba07EqualTo(goodsOperationDo.getTotalOrderNo());
            List<Cbba> cbbas = cbbaMapper.selectByExample(baex);
            for (Cbba cbba : cbbas) {
                cbba.setCbba14(cbba.getCbba14()+goodsOperationDo.getNum());
                cbba.setCbba04(date);
                cbbaMapper.updateByPrimaryKey(cbba);
            }

            //查询占用用的
//            Double useNum = 0.0;
//            for (Cbwa cbwa : cbwas) {
//                GsGoodsUseCriteria useex = new GsGoodsUseCriteria();
//                useex.createCriteria()
//                        .andGoodsIdEqualTo(goodsOperationDo.getGoodsId())
//                        .andWhIdEqualTo(cbwa.getCbwa01());
//                List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(useex);
//                for (GsGoodsUse gsGoodsUs : gsGoodsUses) {
//                    useNum = useNum + gsGoodsUs.getLockQty();
//                }
//            }

//            if (useNum + goodsOperationDo.getNum() > sum) {
//                throw new SwException("您选择的商品库存不足，请刷新重试,商品：" + goodsOperationDo.getGoodsName());
//            }

            //生成占用
            //进行库存占用
//            GsGoodsUse goodsUse = new GsGoodsUse();
//            goodsUse.setCreateBy(goodsOperationDo.getUserId());
//            goodsUse.setCreateTime(new Date());
//            goodsUse.setGoodsId(goodsOperationDo.getGoodsId());
//            goodsUse.setLockQty(goodsOperationDo.getNum());
//            goodsUse.setOrderNo(goodsOperationDo.getOrderNo());
//            goodsUse.setOrderQty(goodsOperationDo.getNum());
//            byte b = goodsOperationDo.getOrderType().byteValue();
//            goodsUse.setOrderType(b);
//            goodsUse.setUpdateBy(goodsOperationDo.getUserId());
//            goodsUse.setUpdateTime(new Date());
//            goodsUse.setWhId(cbwas.get(0).getCbwa01());
//            gsGoodsUseMapper.insert(goodsUse);

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
    public Integer cancelOccupy(GoodsOperationDo goodsOperationDo) {
        GsGoodsUseCriteria example = new GsGoodsUseCriteria();
        example.createCriteria()
                .andOrderNoEqualTo(goodsOperationDo.getOrderNo());
        return gsGoodsUseMapper.deleteByExample(example);

    }


    @Override
    //国内订单查可用库存
    public QtyMsgVo checkSku(CheckSkuDo checkSkuDo) {
        Double canUseNum = 0.0;
        Double totalqty = 0.0;

        if (OrderTypeEnum.GUONEIDINGDAN.getCode().equals(checkSkuDo.getOrderClass())) {

            //该库存检测适用于国内订单创建
            //查该商品的仓库台账
            List<Cbwa> list = cbwaMapper.selectCalculationOrderPriorityNoGqw();

            if (list.size() == 0) {
                throw new SwException("无可用分配库存的仓库");
            }


            for (Cbwa cbwa : list) {
                //查台账
                Cbib cbib = cbibMapper.selectLastByGoodsIdAndStoreId(checkSkuDo.getGoodsId(), cbwa.getCbwa01());
                if (cbib == null) {
                    continue;
                }

                if (cbib.getCbib15() == null || cbib.getCbib15() == 0) {
                    continue;
                }
                //查占用
                List<GsGoodsUse> goodsUseList = gsGoodsUseMapper.selectByWhIdAndGoodsId(cbwa.getCbwa01(), checkSkuDo.getGoodsId());
                Double useNum = goodsUseList.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
                Double num = cbib.getCbib15() - useNum;
                canUseNum = canUseNum + num;
                totalqty= totalqty+cbib.getCbib15();
            }


            //再查GQW的 gqw分配给GBSH开头的订单的分配数量 -占用数量
            CbbaCriteria baex = new CbbaCriteria();
            baex.createCriteria()
                    .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())

                    .andCbba08EqualTo(checkSkuDo.getGoodsId())
                    .andCbba12EqualTo(TotalOrderConstants.NO)
                    .andCbba07Like("%"+"GBSH" + "%");
            List<Cbba> cbbas = cbbaMapper.selectByExample(baex);
            Double gqwQty=0.0;
            Double totalGqwQty=0.0;
            for (Cbba cbba : cbbas) {
                Double usenum=  cbba.getCbba13()-cbba.getCbba14();
                gqwQty=gqwQty+usenum;
                totalGqwQty=totalGqwQty+cbba.getCbba13();
            }

//            Double countQty=gsGoodsSkus.stream().mapToDouble(GsGoodsSku::getQty).sum();

//            Double gqwMakeQty = cbbas.stream().mapToDouble(Cbba::getCbba13).sum();

            //查占用数量
//            GsGoodsUseCriteria gqwEx = new GsGoodsUseCriteria();
//            gqwEx.createCriteria()
//                    .andWhIdEqualTo(WareHouseType.GQWWHID)
//
//                    .andGoodsIdEqualTo(checkSkuDo.getGoodsId());
//            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(gqwEx);
//            Double sum = gsGoodsUses.stream().mapToDouble(GsGoodsUse::getLockQty).sum();

//            gqw仓库数据

            totalqty= totalqty+totalGqwQty;
            if (gqwQty < 0) {
                gqwQty = 0.0;
            }

            canUseNum = canUseNum + gqwQty;

        } else {
            CbbaCriteria example = new CbbaCriteria();
            example.createCriteria()
                    .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                    .andCbba12EqualTo(TotalOrderConstants.NO)
                    .andCbba08EqualTo(checkSkuDo.getGoodsId())
                    .andCbba07Like("%"+"GBSH" + "%");
            List<Cbba> cbbas = cbbaMapper.selectByExample(example);
            Double gqwMakeQty = cbbas.stream().collect(Collectors.summingDouble(Cbba::getCbba13));
            GsGoodsUseCriteria gqwEx = new GsGoodsUseCriteria();
            gqwEx.createCriteria()
                    .andWhIdEqualTo(WareHouseType.GQWWHID)

                    .andGoodsIdEqualTo(checkSkuDo.getGoodsId());
            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(gqwEx);
            Double sum = gsGoodsUses.stream().mapToDouble(GsGoodsUse::getLockQty).sum();

            Double gqwQty = gqwMakeQty - sum;
            canUseNum = gqwQty;
        }

        QtyMsgVo res = new QtyMsgVo();
        res.setGoodsId(checkSkuDo.getGoodsId());
        res.setCanUseNum(canUseNum);


        return res;
    }

    @Override
    public QtyMsgVo checkSkuAll(CheckSkuDo checkSkuDo) {
        Double canUseNum = 0.0;

        if (OrderTypeEnum.GUONEIDINGDAN.getCode().equals(checkSkuDo.getOrderClass())) {

            //该库存检测适用于国内订单创建
            //查该商品的仓库台账
            List<Cbwa> list = cbwaMapper.selectCalculationOrderPriorityNoGqw();

            if (list.size() == 0) {
                throw new SwException("无可用分配库存的仓库");
            }


            for (Cbwa cbwa : list) {
                //查台账
                Cbib cbib = cbibMapper.selectLastByGoodsIdAndStoreId(checkSkuDo.getGoodsId(), cbwa.getCbwa01());
                if (cbib == null) {
                    continue;
                }

                if (cbib.getCbib15() == null || cbib.getCbib15() == 0) {
                    continue;
                }
                //查占用
                List<GsGoodsUse> goodsUseList = gsGoodsUseMapper.selectByWhIdAndGoodsId(cbwa.getCbwa01(), checkSkuDo.getGoodsId());
                Double useNum = goodsUseList.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
                Double num = cbib.getCbib15();
                canUseNum = canUseNum + num;

            }


            //再查GQW的 gqw分配给GBSH开头的订单的分配数量 -占用数量
            CbbaCriteria baex = new CbbaCriteria();
            baex.createCriteria()
                    .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())

                    .andCbba08EqualTo(checkSkuDo.getGoodsId())
                    .andCbba12EqualTo(TotalOrderConstants.NO)
                    .andCbba07Like("%"+"GBSH" + "%");
            List<Cbba> cbbas = cbbaMapper.selectByExample(baex);
            Double gqwQty=0.0;
            for (Cbba cbba : cbbas) {
                Double usenum=  cbba.getCbba13();
                gqwQty=gqwQty+usenum;
            }
//            Double countQty=gsGoodsSkus.stream().mapToDouble(GsGoodsSku::getQty).sum();

//            Double gqwMakeQty = cbbas.stream().mapToDouble(Cbba::getCbba13).sum();

            //查占用数量
//            GsGoodsUseCriteria gqwEx = new GsGoodsUseCriteria();
//            gqwEx.createCriteria()
//                    .andWhIdEqualTo(WareHouseType.GQWWHID)
//
//                    .andGoodsIdEqualTo(checkSkuDo.getGoodsId());
//            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(gqwEx);
//            Double sum = gsGoodsUses.stream().mapToDouble(GsGoodsUse::getLockQty).sum();

//            gqw仓库数据


            if (gqwQty < 0) {
                gqwQty = 0.0;
            }

            canUseNum = canUseNum + gqwQty;

        } else {
            CbbaCriteria example = new CbbaCriteria();
            example.createCriteria()
                    .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                    .andCbba12EqualTo(TotalOrderConstants.NO)
                    .andCbba08EqualTo(checkSkuDo.getGoodsId())
                    .andCbba07Like("%"+"GBSH" + "%");
            List<Cbba> cbbas = cbbaMapper.selectByExample(example);
            Double gqwMakeQty = cbbas.stream().collect(Collectors.summingDouble(Cbba::getCbba13));
            GsGoodsUseCriteria gqwEx = new GsGoodsUseCriteria();
            gqwEx.createCriteria()
                    .andWhIdEqualTo(WareHouseType.GQWWHID)

                    .andGoodsIdEqualTo(checkSkuDo.getGoodsId());
            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(gqwEx);
            Double sum = gsGoodsUses.stream().mapToDouble(GsGoodsUse::getLockQty).sum();

            Double gqwQty = gqwMakeQty - sum;
            canUseNum = gqwQty;
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
        if (changeSkuUseDo.getOrderNo().contains(TotalOrderConstants.GUONEIORDER)) {
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

    @Override
    @Transactional
    public Boolean diaoboUseOp(TranUseQtyDo tranUseQtyDo) {
        log.info("调拨标记完成"+ JSON.toJSON(tranUseQtyDo));
        if(!tranUseQtyDo.getInWhId().equals(WareHouseType.CDCWHID)   ){
            return true;
        }
        Date date = new Date();
        Double orginQty=tranUseQtyDo.getQty();
        Double qty=tranUseQtyDo.getQty();
        //减去调出仓库库存占用
        GsGoodsUseCriteria outUseEx=new GsGoodsUseCriteria();
        outUseEx.createCriteria()
                .andWhIdEqualTo(tranUseQtyDo.getOutWhId())
                .andGoodsIdEqualTo(tranUseQtyDo.getGoodsId());
        outUseEx.setOrderByClause("update_time");
        List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(outUseEx);
        for (GsGoodsUse gsGoodsUs : gsGoodsUses) {
            if(gsGoodsUs.getLockQty()<=qty){
                qty=qty-gsGoodsUs.getLockQty();
                gsGoodsUseMapper.deleteByPrimaryKey(gsGoodsUs.getId());

            }else {
             gsGoodsUs.setLockQty(gsGoodsUs.getLockQty()-qty);
             qty=0.0;
             gsGoodsUs.setUpdateTime(date);
             gsGoodsUseMapper.updateByPrimaryKey(gsGoodsUs);

            }

            if(qty==0.0){
                break;
            }
        }
        Double inuseQty=orginQty-qty;
        //增加调入仓库库存占用
        GsGoodsUseCriteria inUseEx=new GsGoodsUseCriteria();
        inUseEx.createCriteria()
                .andWhIdEqualTo(tranUseQtyDo.getInWhId())
                .andGoodsIdEqualTo(tranUseQtyDo.getGoodsId());

        List<GsGoodsUse> ingsuse = gsGoodsUseMapper.selectByExample(inUseEx);
        if(ingsuse.size()>0){
            GsGoodsUse goodsUse = ingsuse.get(0);

            goodsUse.setUpdateTime(date);
            goodsUse.setLockQty(goodsUse.getLockQty()+inuseQty);
            gsGoodsUseMapper.updateByPrimaryKey(goodsUse);

        }else {
            GsGoodsUse goodsUse = new GsGoodsUse();


            goodsUse.setCreateTime(new Date());
            goodsUse.setGoodsId(tranUseQtyDo.getGoodsId());
            goodsUse.setLockQty(inuseQty);


            goodsUse.setUpdateTime(new Date());
            goodsUse.setWhId(tranUseQtyDo.getInWhId());
            gsGoodsUseMapper.insert(goodsUse);
        }


        return true;

    }


}
