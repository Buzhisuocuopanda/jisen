package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.Do.GoodsOperationDo;
import com.ruoyi.system.domain.Do.OrderDistributionDo;
import com.ruoyi.system.domain.GsUnDistributionGoods;
import com.ruoyi.system.mapper.CbbaMapper;
import com.ruoyi.system.mapper.GsUnDistributionGoodsMapper;
import com.ruoyi.system.service.gson.OrderDistributionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName OrderDistributionServiceImpl
 * Description
 * Create by gfy
 * Date 2022/7/27 14:10
 */
@Service
@Slf4j
public class OrderDistributionServiceImpl2 implements OrderDistributionService {

    private Map<String,Long> lockMap =new ConcurrentHashMap<>();

    private GsUnDistributionGoodsMapper gsUnDistributionGoodsMapper;
    /**
     * 总订单重新分配的key
     */
    private String totalOrderkey="totalOrder";

    /**
     * 其他订单key
     */
    private String orderkey="otherOrder";


    /**
     * key值过期时间30秒
     */
    private Long overTime=30000L;

    /**
     * 拿锁超时时间
     */
    private Long lockGetTime=5000L;

    @Resource
    private CbbaMapper cbbaMapper;


    private boolean lockTotalOrder(){
        Long time= System.currentTimeMillis();

        while (true){
           Long now= System.currentTimeMillis();
           if(now-time>lockGetTime){
               throw new ServiceException("获得锁超时，请稍后重试");
           }
            Long aLong = lockMap.putIfAbsent(totalOrderkey, time);
            if(aLong!=null){
                //说明没占到锁
                //判断时间是否过期
                if(aLong-now>overTime){
                    Long put = lockMap.put(totalOrderkey, now);
                    if(put.equals(now)){
                        return true;
                    }

                }
                continue;
            }

            return true;


        }


    }

    private boolean ifHasOthOrder(){
        Long time= System.currentTimeMillis();

        while (true){
            Long now= System.currentTimeMillis();
            if(now-time>lockGetTime){
                throw new ServiceException("获得锁超时，请稍后重试");
            }
            Long aLong = lockMap.get(orderkey);
            if(aLong!=null){
                //说明没占到锁
                continue;

            }else {
                return false;
            }

        }


    }


    /**
     * 重新分配逻辑 用于创建新的总订单，和修改优先级使用
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
            GsUnDistributionGoods ungoods= gsUnDistributionGoodsMapper.selectByGoodsIdForUpdate(orderDistributionDo.getGoodsId());
            Cbba cbba = orderDistributionDo.getCbba();
            if(orderDistributionDo.getType()==1){
                //创建
                //先查找未分配订单的数量创建把
                 getUnDistributionGoods(cbba, ungoods);

                //优先级比这个订单低的未完成的订单的 分配数量减去占用数量分配给该订单
                if(!cbba.getCbba13().equals(cbba.getCbba09()-cbba.getCbba11())){
                    getOtherOrderMakeNum(cbba);
                }


            }else {
                //此处修改分两种情况
                //1、修改优先级
                //2、修改数量
                if(orderDistributionDo.getType()==2){
                    //优先级由高到低
                    if(orderDistributionDo.getPriority()>orderDistributionDo.getOldPriority()){
                        giveOrderPriority(cbba,orderDistributionDo.getOldPriority());
                    }else {
                        //优先级由低到高
                        getOrderPriority(cbba,orderDistributionDo.getOldPriority());
                    }



                }else {
                    //判断是大于原先数量还是小于原先数量
                    if(orderDistributionDo.getNum()>orderDistributionDo.getOldNum()){
                        //大于
                        //先查找未分配订单的数量创建把
                        getUnDistributionGoods(cbba, ungoods);
                        if(!cbba.getCbba13().equals(cbba.getCbba09()-cbba.getCbba11())){
                            getOtherOrderMakeNum(cbba);
                        }
                    }else {
                        //如果是小于并且有多出来的分配给其他订单
                        giveOtherOrder(cbba,orderDistributionDo.getOldNum(),ungoods);

                    }
                }



            }


//            Cbba cbba = cbbaMapper.select(orderDistributionDo.getOrderId());

        }finally {
            lockMap.put(totalOrderkey,null);
        }

        return null;
    }

    /**
     * 修改总订单数量从多变少
     * @param cbba
     * @param oldNum
     * @param ungoods
     * @return
     */

    private Cbba giveOtherOrder(Cbba cbba, Integer oldNum, GsUnDistributionGoods ungoods) {
        Double orderNum=cbba.getCbba09();
        //已分配的数量
        Double makeNum = cbba.getCbba13();

        //已占用的数量
        Double useNum = cbba.getCbba14();


        if(makeNum-useNum<=0){
            //如果分配数量和占用数量一样不用重新分配
            return cbba;
        }
        if(makeNum-orderNum<=0){
            //如果分配数量没有超出订单数量，也不用重新分分配
            return cbba;
        }
        Double givenNum=makeNum-orderNum;

        List<Cbba> res=cbbaMapper.selectLowPriority(cbba);
        for (Cbba re : res) {
            //订单所需数量为 订单数量减去 分配数量减去发货数量
            Double needNum=re.getCbba09()-re.getCbba11()-re.getCbba13();
            if(needNum==0){
                continue;
            }

            if(givenNum<=needNum){
                re.setCbba13(re.getCbba13()+givenNum);
                givenNum=0.0;
            }else {
                re.setCbba13(re.getCbba13()+needNum);
                givenNum=givenNum-needNum;

            }

            re.setCbba04(new Date());
            cbbaMapper.updateByPrimaryKey(re);
            if(givenNum==0){
                break;
            }

        }
        cbba.setCbba13(cbba.getCbba13()-givenNum);

        if(givenNum>0){
            //存到未分配列表里
            if(ungoods!=null){
                ungoods.setNum(ungoods.getNum()+givenNum.intValue());
                ungoods.setUpdateTime(new Date());
                gsUnDistributionGoodsMapper.updateByPrimaryKey(ungoods);
            }else {
                ungoods=new GsUnDistributionGoods();
                ungoods.setUpdateTime(new Date());
                ungoods.setCreateTime(new Date());
                ungoods.setCreateBy(cbba.getCbba05().longValue());
                ungoods.setDeleteFlag(DeleteFlagEnum.NOT_DELETE.getCode().byteValue());
                ungoods.setNum(givenNum.intValue());
                ungoods.setGoodsId(cbba.getCbba08());
                gsUnDistributionGoodsMapper.insert(ungoods);

            }


        }
            return cbba;




    }

    //优先级由低到高
    private Cbba getOrderPriority(Cbba cbba,Integer oldPriority) {
        Double makeNum = cbba.getCbba13();

        if(makeNum.equals(cbba.getCbba09()-cbba.getCbba11())){
            return cbba;
        }
        Double needNum=cbba.getCbba09()-cbba.getCbba11()-makeNum;
        Integer goodsId = cbba.getCbba08();
        List<Cbba> list=cbbaMapper. selectByPriorityDurelow2H(goodsId,cbba.getCbba15(),oldPriority);
        for (Cbba res : list) {
            //可拿去的分配数量
            Double getNum=res.getCbba13()-res.getCbba14();
            if(getNum<=0){
                continue;
            }

            if(getNum>=needNum){
                res.setCbba13(res.getCbba13()-needNum);
                needNum=needNum-needNum;
                res.setCbba04(new Date());
                cbbaMapper.updateByPrimaryKey(res);
                break;

            }else {
                res.setCbba13(res.getCbba14());
                needNum=needNum-getNum;
                res.setCbba04(new Date());
                cbbaMapper.updateByPrimaryKey(res);
                continue;
            }
        }
        return cbba;

    }

    /**
     * 更改总订单优先级的时候从高改到低
     * @param cbba
     */
    private Cbba giveOrderPriority(Cbba cbba,Integer oldPriority) {
        //可以分给其他订单的数量分配数量减去占用数量
        Double makeNum = cbba.getCbba13()-cbba.getCbba14();
        if(makeNum==0){
            return cbba;
        }
        Integer goodsId = cbba.getCbba08();
        List<Cbba> list=cbbaMapper. selectByPriorityDureH2low(goodsId,cbba.getCbba15(),oldPriority);
        for (Cbba res : list) {
            if(!cbba.getCbba07().equals(res.getCbba07())){
                //未发货数量
                Double orderNum = res.getCbba09()-res.getCbba11();
                Double resmakeNum = res.getCbba13();
                if(resmakeNum.equals(orderNum)){
                   continue;
                }
                Double resneedNum=orderNum-resmakeNum;
                if(resneedNum<0){
                    continue;
                }

                if(resneedNum>=makeNum){
                    res.setCbba13(res.getCbba13()+makeNum);
                    makeNum=0.0;
                }else {
                    res.setCbba13(res.getCbba13()+resneedNum);
                    makeNum=makeNum-resneedNum;
                }
                res.setCbba04(new Date());
                cbbaMapper.updateByPrimaryKey(res);

                if(makeNum==0){
                    break;
                }

            }
        }
        cbba.setCbba13(makeNum+cbba.getCbba14());
        return cbba;


    }



    public Cbba getUnDistributionGoods(Cbba cbba, GsUnDistributionGoods gsUnDistributionGoods){
        if(cbba==null){
            return null;
        }

        if(gsUnDistributionGoods==null){
            return cbba;
        }

        Integer num = gsUnDistributionGoods.getNum();
        //生产数量
        Double makeNum = cbba.getCbba13();
        if(makeNum==null){
            makeNum=0.00;
        }
        //未发货数量
        Double orderNum = cbba.getCbba09()-cbba.getCbba11();
        if(orderNum==null){
            orderNum=0.00;
        }


        Double unNum=0.00;
        if(num.doubleValue()>orderNum){
            unNum=orderNum-makeNum;
        }else {
            Double cha=orderNum- makeNum;
            if(num.doubleValue()>cha){
                unNum=num.doubleValue()-cha;
            }else {
                unNum=num.doubleValue();
            }

        }
        cbba.setCbba13(makeNum+unNum);
        gsUnDistributionGoods.setUpdateTime(new Date());
        gsUnDistributionGoods.setNum(gsUnDistributionGoods.getNum()-unNum.intValue());
        gsUnDistributionGoodsMapper.updateByPrimaryKey(gsUnDistributionGoods);
        return cbba;


    }
    public Cbba getOtherOrderMakeNum(Cbba cbba){
        if(cbba==null){
            return null;
        }

        List<Cbba> res=cbbaMapper.selectLowPriority(cbba);
        //先从优先级最低的取
        //未发货数量
        Double orderNum = cbba.getCbba09()-cbba.getCbba11();

        //已分配数量
        Double makeNum = cbba.getCbba13();
        if(makeNum==null){
            makeNum=0.00;
        }

        //需要分配的数量 未发货数量减去已分配的数量
        Double needMakeNum=orderNum-makeNum;
        //实际分配的数量
        Double realMakeNum=0.0;
        for (Cbba re : res) {
            Double canuseNum=re.getCbba13()-re.getCbba14();
            if(canuseNum<0){
                continue;
            }

            if(canuseNum>=needMakeNum){
                //如果可以使用的数量大于需要分配订单的所需数量
                realMakeNum=realMakeNum+needMakeNum;
                re.setCbba13(canuseNum-needMakeNum);
            }else {
                realMakeNum=realMakeNum+canuseNum;
                needMakeNum=needMakeNum-canuseNum;
                re.setCbba13(0.0);

            }
            re.setCbba04(new Date());
            cbbaMapper.updateByPrimaryKey(re);

        }

        cbba.setCbba13(cbba.getCbba13()+realMakeNum);
        return cbba;
    }




    @Override
    public Cbba directWarehousing(OrderDistributionDo orderDistributionDo) {
        return null;
    }



    @Override
    public Cbba saleOrderExit(OrderDistributionDo orderDistributionDo) {
        return null;
    }

    @Override
    public Cbba transferOrder(OrderDistributionDo orderDistributionDo) {
        return null;
    }

    /**
     * 销售订单下单占用逻辑
     * @param goodsOperationDo
     * @return
     */
    @Override
    public Cbba saleOrderMake(GoodsOperationDo goodsOperationDo) {
        //国际订单是在确认库存后进行占用库存的操作
        //国内订单是在销售下单的时候


        return null;
    }

    @Override
    public Cbba cancelOccupy(GoodsOperationDo goodsOperationDo) {
        return null;

    }
}
