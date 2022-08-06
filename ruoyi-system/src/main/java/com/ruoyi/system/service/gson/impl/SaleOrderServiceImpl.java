package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.constant.TotalOrderConstants;
import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.OrderTypeEnum;
import com.ruoyi.common.enums.TotalOrderOperateEnum;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.OrderDistributionDo;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.SaleOrderListVo;
import com.ruoyi.system.domain.vo.SaleOrderSkuListVo;
import com.ruoyi.system.domain.vo.SaleOrderSkuVo;
import com.ruoyi.system.domain.vo.TotalOrderListVo;
import com.ruoyi.system.mapper.CbbaMapper;
import com.ruoyi.system.mapper.CboaMapper;
import com.ruoyi.system.mapper.CbpbMapper;
import com.ruoyi.system.mapper.GsGoodsUseMapper;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.OrderDistributionService;
import com.ruoyi.system.service.gson.SaleOrderService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName SaleOrderServiceImpl
 * Description
 * Create by gfy
 * Date 2022/8/1 17:27
 */
@Service
public class SaleOrderServiceImpl implements SaleOrderService {

    @Resource
    private CboaMapper cboaMapper;

    @Resource
    private CbbaMapper cbbaMapper;

    @Resource
    private BaseCheckService baseCheckService;

    @Resource
    private OrderDistributionService orderDistributionService;

    @Resource
    private GsGoodsUseMapper gsGoodsUseMapper;

    @Resource
    private CbpbMapper cbpbMapper;

    @Override
    public  List<SaleOrderSkuVo> saleOrderSkuList(SaleOrderSkuDto saleOrderSkuDto) {

        List<SaleOrderSkuVo> saleOrderSkuVos = cboaMapper.saleOrderSkuList(saleOrderSkuDto);
//        //查询可用库存 国际订单为生产订单分配数量减去占用数量
//        CbbaCriteria example=new CbbaCriteria();
//        example.createCriteria()
//                .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
//                .andCbba12EqualTo(TotalOrderConstants.NO)
//                .andCbba08EqualTo(saleOrderSkuDto.get())
//                .andCbba07NotLike("GBSH"+"%");
//        List<Cbba> cbbas = cbbaMapper.selectByExample(example);
//        Double sum = cbbas.stream().collect(Collectors.summingDouble(Cbba::getCbba13));
        return saleOrderSkuVos;
    }


    /**
     * 生产总订单列表
     * @param totalOrderListDto
     * @return
     */
    @Override
    public List<TotalOrderListVo> totalOrderList(TotalOrderListDto totalOrderListDto) {

        List<TotalOrderListVo> res=cbbaMapper.totalOrderList(totalOrderListDto);
        for (TotalOrderListVo re : res) {
            re.setCurrentOrderQty(re.getOrderQty()-re.getShippedQty());
//            if(re.getOrderNo().startsWith(TotalOrderConstants.GUONEIORDER)){
//                re.setOrderType(OrderTypeEnum.GUONEIDINGDAN.getCode());
//            }else {
//                re.setOrderType(OrderTypeEnum.GUOJIDINGDAN.getCode());
//            }

        }

        return res;

    }

    @Transactional
    @Override
    public Cbba addTotalOrder(TotalOrderAddDto totalOrderAddDto) {
        Cbba cbba = baseCheckService.checkTotalExist(totalOrderAddDto.getGoodsId(), totalOrderAddDto.getOrderNo());
        if(cbba!=null){
            Cbpb cbpb = cbpbMapper.selectByPrimaryKey(totalOrderAddDto.getGoodsId());
            throw new SwException("已存在相同商品，相同订单号的生产总订单,订单号："+totalOrderAddDto.getOrderNo()+"商品："+cbpb.getCbpb12());
        }
        //商品是否可用
        baseCheckService.checkGoods(totalOrderAddDto.getGoodsId(),null);


        //创建生产总订单
        cbba=new Cbba();
        Date date = new Date();
        cbba.setCbba02(date);
        cbba.setCbba03(totalOrderAddDto.getUserId());
        cbba.setCbba04(date);
        cbba.setCbba05(totalOrderAddDto.getUserId());
        cbba.setCbba06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbba.setCbba07(totalOrderAddDto.getOrderNo());
        cbba.setCbba08(totalOrderAddDto.getGoodsId());
        cbba.setCbba09(totalOrderAddDto.getQty());
        if(totalOrderAddDto.getOrderNo().startsWith(TotalOrderConstants.GUONEIORDER)){
            cbba.setCbba10(OrderTypeEnum.GUONEIDINGDAN.getCode());
        }else {
            cbba.setCbba10(OrderTypeEnum.GUOJIDINGDAN.getCode());

        }

        cbba.setCbba11(0.0);
        cbba.setCbba12(TotalOrderConstants.NO);
        cbba.setCbba13(0.0);
        cbba.setCbba14(0.0);
        cbba.setCbba15(totalOrderAddDto.getPriority());

        OrderDistributionDo send=new OrderDistributionDo();
        send.setCbba(cbba);
        send.setGoodsId(totalOrderAddDto.getGoodsId());
        send.setNum(totalOrderAddDto.getQty());

        send.setPriority(totalOrderAddDto.getPriority());
        send.setType(TotalOrderOperateEnum.MAKEORDER.getCode());
        cbba = orderDistributionService.reassign(send);
        cbbaMapper.insert(cbba);
        return cbba;


    }

    @Transactional
    @Override
    public Cbba mdfTotalOrder(TotalOrderAddDto totalOrderAddDto) {
        Cbba cbba=cbbaMapper.selectByPrimaryKeyForUpdate(totalOrderAddDto.getId());

        if(cbba==null){
            throw new SwException("");
        }
        OrderDistributionDo send=new OrderDistributionDo();
        send.setCbba(cbba);
        send.setGoodsId(cbba.getCbba08());
        //判断是否是删除
        if(DeleteFlagEnum.DELETE.getCode().equals(totalOrderAddDto.getDelete())){
            //删除
            //如果有已占用 和发货的不能删
            //如果有已分配的，则把已分配的设置为0
            GsGoodsUseCriteria example=new GsGoodsUseCriteria();
            example.createCriteria()
                    .andOrderNoEqualTo(cbba.getCbba07())
                    .andGoodsIdEqualTo(cbba.getCbba08());
            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(example);
            Double useNum=0.0;
            if(gsGoodsUses.size()>0){
                useNum=gsGoodsUses.get(0).getLockQty();
            }

            if(cbba.getCbba11()!=0.0 ){
                throw new SwException("该订单已有发货数量，不能删除");
            }

            if(useNum!=0.0){
                throw new SwException("该订单已有占用数量，不能删除");
            }
            Double cbba09 = cbba.getCbba09();
            cbba.setCbba09(0.0);
            if(cbba.getCbba13()!=0.0){
                send.setNum(0.0);
                send.setOldNum(cbba.getCbba09());

                send.setPriority(cbba.getCbba15());
                send.setType(TotalOrderOperateEnum.MDFQTY.getCode());
                cbba = orderDistributionService.reassign(send);

            }
            cbba.setCbba09(cbba09);
            cbba.setCbba06(DeleteFlagEnum.DELETE.getCode());
            cbbaMapper.updateByPrimaryKey(cbba);

        }else {
            //不删除修,改其他信息
            //是否是修改商品
            Integer oldgoodsId = cbba.getCbba08();
            if(oldgoodsId.equals(totalOrderAddDto.getGoodsId())){
                String oldPoririty=cbba.getCbba15();

                Double oldQty=cbba.getCbba09();
                cbba.setCbba15(totalOrderAddDto.getPriority());
                cbba.setCbba09(totalOrderAddDto.getQty());
                //修改优先级
                if(!oldPoririty.equals(totalOrderAddDto.getPriority())){
                    send.setNum(totalOrderAddDto.getQty());
                    send.setOldNum(oldQty);
                    send.setOldPriority(oldPoririty);
                    send.setPriority(cbba.getCbba15());
                    send.setType(TotalOrderOperateEnum.MDFPRIORITY.getCode());
                    cbba = orderDistributionService.reassign(send);
                }else if(!oldPoririty.equals(totalOrderAddDto.getQty())){

                    send.setNum(totalOrderAddDto.getQty());
                    send.setOldNum(oldQty);

                    send.setPriority(cbba.getCbba15());
                    send.setType(TotalOrderOperateEnum.MDFQTY.getCode());
                    cbba = orderDistributionService.reassign(send);
                }

                cbba.setCbba08(totalOrderAddDto.getGoodsId());
                cbba.setCbba07(totalOrderAddDto.getOrderNo());
                cbba.setCbba05(totalOrderAddDto.getUserId());
                cbba.setCbba04(new Date());
                cbbaMapper.updateByPrimaryKey(cbba);

            }else {
                baseCheckService.checkGoods(totalOrderAddDto.getGoodsId(),null);
                GsGoodsUseCriteria example=new GsGoodsUseCriteria();
                example.createCriteria()
                        .andOrderNoEqualTo(cbba.getCbba07())
                        .andGoodsIdEqualTo(cbba.getCbba08());
                List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(example);
                Double useNum=0.0;
                if(gsGoodsUses.size()>0){
                    useNum=gsGoodsUses.get(0).getLockQty();
                }

                if(cbba.getCbba11()!=0.0 ){
                    throw new SwException("该订单已有发货数量，不能修改商品");
                }

                if(useNum!=0.0){
                    throw new SwException("该订单已有占用数量，不能修改商品");
                }
                //先清空旧的分配
                Double cbba09 = cbba.getCbba09();
                cbba.setCbba09(0.0);
                if(cbba.getCbba13()!=0.0){
                    send.setNum(0.0);
                    send.setOldNum(cbba.getCbba09());

                    send.setPriority(cbba.getCbba15());
                    send.setType(TotalOrderOperateEnum.MDFQTY.getCode());
                   Cbba cbbadel = orderDistributionService.reassign(send);

                }
                cbba.setCbba09(totalOrderAddDto.getQty());
                cbba.setCbba08(totalOrderAddDto.getGoodsId());

                OrderDistributionDo sendAdd=new OrderDistributionDo();
                sendAdd.setCbba(cbba);
                sendAdd.setGoodsId(totalOrderAddDto.getGoodsId());
                sendAdd.setNum(totalOrderAddDto.getQty());

                sendAdd.setPriority(totalOrderAddDto.getPriority());
                sendAdd.setType(TotalOrderOperateEnum.MAKEORDER.getCode());
                cbba = orderDistributionService.reassign(sendAdd);
                //再增加新的分配
                cbba.setCbba07(totalOrderAddDto.getOrderNo());
                cbba.setCbba05(totalOrderAddDto.getUserId());
                cbba.setCbba04(new Date());
                cbbaMapper.updateByPrimaryKey(cbba);

            }

        }
        return cbba;

    }

    @Override
    public List<SaleOrderListVo> saleOrderList(SaleOrderListDto saleOrderListDto) {

        return cboaMapper.saleOrderList(saleOrderListDto);
    }

    @Transactional
    @Override
    public String importTotalOrder(List<TotalOrderExcelDto> list, Long userId) {



        TotalOrderAddDto totalOrderAddDto=null;
        for (TotalOrderExcelDto totalOrderExcelDto : list) {

            if(StringUtils.isBlank(totalOrderExcelDto.getPriority())){
                throw new SwException("优先级不能为空,商品："+totalOrderExcelDto.getModel());
            }

            if(StringUtils.isBlank(totalOrderExcelDto.getOrderNo())){
                throw new SwException("订单号不能为空,商品："+totalOrderExcelDto.getModel());
            }

            if(totalOrderExcelDto.getOrderQty()==null){
                throw new SwException("订单数量不能为空,商品："+totalOrderExcelDto.getModel());
            }


            if(StringUtils.isBlank(totalOrderExcelDto.getModel())){
                throw new SwException("商品型号不能为空");
            }

            totalOrderAddDto=new TotalOrderAddDto();
            totalOrderAddDto.setUserId(userId.intValue());
            totalOrderAddDto.setDelete(DeleteFlagEnum.NOT_DELETE.getCode());
            //根据型号
            CbpbCriteria example=new CbpbCriteria();
            example.createCriteria()
                    .andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                    .andCbpb12EqualTo(totalOrderExcelDto.getModel());
            List<Cbpb> cbpbs = cbpbMapper.selectByExample(example);
            if(cbpbs.size()==0){
                throw new SwException("没有查到该型号的商品:"+totalOrderExcelDto.getModel());
            }
            totalOrderAddDto.setGoodsId(cbpbs.get(0).getCbpb01());
            totalOrderAddDto.setOrderNo(totalOrderExcelDto.getOrderNo());
            totalOrderAddDto.setPriority(totalOrderExcelDto.getPriority());
            totalOrderAddDto.setQty(totalOrderExcelDto.getOrderQty());
            addTotalOrder(totalOrderAddDto);

        }

        return "导入成功";


    }

    /**
     * 添加销售订单
     * @param saleOrderAddDto
     */
    @Transactional
    @Override
    public void addSaleOrder(SaleOrderAddDto saleOrderAddDto) {
        //创建销售订单主表

        //创建销售订单明细表

        //创建销售订单要锁住库存

        //如果通过清单生成的销售订单，要清空清单




        return;

    }
}
