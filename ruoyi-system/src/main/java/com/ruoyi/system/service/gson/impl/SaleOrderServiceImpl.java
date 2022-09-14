package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.constant.AuditStatusConstants;
import com.ruoyi.common.constant.TotalOrderConstants;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.NumberToChineseUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.OrderDistributionService;
import com.ruoyi.system.service.gson.SaleOrderService;
import com.ruoyi.system.service.gson.TaskService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
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

    @Resource
    private NumberGenerate numberGenerate;

    @Resource
    private CbobMapper cbobMapper;

    @Resource
    private GsOutStockAdivceMapper gsOutStockAdivceMapper;

    @Resource
    private CbcaMapper cbcaMapper;
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private CalaMapper calaMapper;

    @Resource
    private CabraaMapper cabraaMapper;

    @Resource
    private CbpfMapper cbpfMapper;

    @Resource
    private CbwaMapper cbwaMapper;


    @Resource
    private CbibMapper cbibMapper;

    @Resource
    private GsSaleShoppingMapper gsSaleShoppingMapper;

    @Resource
    private CbocMapper cbocMapper;

    @Resource
    private CbodMapper cbodMapper;

    @Resource
    private TaskService taskService;

    @Override
    public List<SaleOrderSkuVo> saleOrderSkuList(SaleOrderSkuDto saleOrderSkuDto) {

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
     *
     * @param totalOrderListDto
     * @return
     */
    @Override
    public List<TotalOrderListVo> totalOrderList(TotalOrderListDto totalOrderListDto) {

        List<TotalOrderListVo> res = cbbaMapper.totalOrderList(totalOrderListDto);
        for (TotalOrderListVo re : res) {
            re.setCurrentOrderQty(re.getOrderQty() - re.getShippedQty());
            if (OrderTypeEnum.GUOJIDINGDAN.getCode().equals(re.getOrderType())) {
                re.setOrderTypeMsg(OrderTypeEnum.GUOJIDINGDAN.getMsg());
            } else {
                re.setOrderTypeMsg(OrderTypeEnum.GUONEIDINGDAN.getMsg());
            }

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
        if (cbba != null) {
            Cbpb cbpb = cbpbMapper.selectByPrimaryKey(totalOrderAddDto.getGoodsId());
            throw new SwException("已存在相同商品，相同订单号的生产总订单,订单号：" + totalOrderAddDto.getOrderNo() + "商品：" + cbpb.getCbpb12());
        }
        //商品是否可用
        baseCheckService.checkGoods(totalOrderAddDto.getGoodsId(), null);


        //创建生产总订单
        cbba = new Cbba();
        Date date = new Date();
        cbba.setCbba02(date);
        cbba.setCbba03(totalOrderAddDto.getUserId());
        cbba.setCbba04(date);
        cbba.setCbba05(totalOrderAddDto.getUserId());
        cbba.setCbba06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbba.setCbba07(totalOrderAddDto.getOrderNo());
        cbba.setCbba08(totalOrderAddDto.getGoodsId());
        cbba.setCbba09(totalOrderAddDto.getQty());
        if (totalOrderAddDto.getOrderNo().startsWith(TotalOrderConstants.GUONEIORDER)) {
            cbba.setCbba10(OrderTypeEnum.GUONEIDINGDAN.getCode());
        } else {
            cbba.setCbba10(OrderTypeEnum.GUOJIDINGDAN.getCode());

        }

        cbba.setCbba11(0.0);
        cbba.setCbba12(TotalOrderConstants.NO);
        cbba.setCbba13(0.0);
        cbba.setCbba14(0.0);
        cbba.setCbba15(totalOrderAddDto.getPriority());

        OrderDistributionDo send = new OrderDistributionDo();
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
        Cbba cbba = cbbaMapper.selectByPrimaryKeyForUpdate(totalOrderAddDto.getId());

        if (cbba == null) {
            throw new SwException("没有查到该生产总订单");
        }
        OrderDistributionDo send = new OrderDistributionDo();
        send.setCbba(cbba);
        send.setGoodsId(cbba.getCbba08());
        //判断是否是删除
        if (DeleteFlagEnum.DELETE.getCode().equals(totalOrderAddDto.getDelete())) {
            //删除
            //如果有已占用 和发货的不能删
            //如果有已分配的，则把已分配的设置为0
            GsGoodsUseCriteria example = new GsGoodsUseCriteria();
            example.createCriteria()
                    .andOrderNoEqualTo(cbba.getCbba07())
                    .andGoodsIdEqualTo(cbba.getCbba08());
            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(example);
            Double useNum = 0.0;
            if (gsGoodsUses.size() > 0) {
                useNum = gsGoodsUses.get(0).getLockQty();
            }

            if (cbba.getCbba11() != 0.0) {
                throw new SwException("该订单已有发货数量，不能删除");
            }

            if (useNum != 0.0) {
                throw new SwException("该订单已有占用数量，不能删除");
            }
            Double cbba09 = cbba.getCbba09();
            cbba.setCbba09(0.0);
            if (cbba.getCbba13() != 0.0) {
                send.setNum(0.0);
                send.setOldNum(cbba.getCbba09());

                send.setPriority(cbba.getCbba15());
                send.setType(TotalOrderOperateEnum.MDFQTY.getCode());
                cbba = orderDistributionService.reassign(send);

            }
            cbba.setCbba09(cbba09);
            cbba.setCbba06(DeleteFlagEnum.DELETE.getCode());
            cbbaMapper.updateByPrimaryKey(cbba);

        } else {
            //不删除修,改其他信息
            //是否是修改商品
            Integer oldgoodsId = cbba.getCbba08();
            if (oldgoodsId.equals(totalOrderAddDto.getGoodsId())) {
                String oldPoririty = cbba.getCbba15();

                Double oldQty = cbba.getCbba09();
                cbba.setCbba15(totalOrderAddDto.getPriority());
                cbba.setCbba09(totalOrderAddDto.getQty());
                //修改优先级
                if (!oldPoririty.equals(totalOrderAddDto.getPriority())) {
                    send.setNum(totalOrderAddDto.getQty());
                    send.setOldNum(oldQty);
                    send.setOldPriority(oldPoririty);
                    send.setPriority(cbba.getCbba15());
                    send.setType(TotalOrderOperateEnum.MDFPRIORITY.getCode());
                    cbba = orderDistributionService.reassign(send);
                } else if (!oldPoririty.equals(totalOrderAddDto.getQty())) {

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

            } else {
                baseCheckService.checkGoods(totalOrderAddDto.getGoodsId(), null);
                GsGoodsUseCriteria example = new GsGoodsUseCriteria();
                example.createCriteria()
                        .andOrderNoEqualTo(cbba.getCbba07())
                        .andGoodsIdEqualTo(cbba.getCbba08());
                List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(example);
                Double useNum = 0.0;
                if (gsGoodsUses.size() > 0) {
                    useNum = gsGoodsUses.get(0).getLockQty();
                }

                if (cbba.getCbba11() != 0.0) {
                    throw new SwException("该订单已有发货数量，不能修改商品");
                }

                if (useNum != 0.0) {
                    throw new SwException("该订单已有占用数量，不能修改商品");
                }
                //先清空旧的分配
                Double cbba09 = cbba.getCbba09();
                cbba.setCbba09(0.0);
                if (cbba.getCbba13() != 0.0) {
                    send.setNum(0.0);
                    send.setOldNum(cbba.getCbba09());

                    send.setPriority(cbba.getCbba15());
                    send.setType(TotalOrderOperateEnum.MDFQTY.getCode());
                    Cbba cbbadel = orderDistributionService.reassign(send);

                }
                cbba.setCbba09(totalOrderAddDto.getQty());
                cbba.setCbba08(totalOrderAddDto.getGoodsId());

                OrderDistributionDo sendAdd = new OrderDistributionDo();
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

        List<SaleOrderListVo> saleOrderListVos = cboaMapper.saleOrderList(saleOrderListDto);
        for (SaleOrderListVo saleOrderListVo : saleOrderListVos) {
            if(saleOrderListVo.getSettleCurrent().equals(6)){
                saleOrderListVo.setSettleCurrentMsg("CNY");
            }else {
                saleOrderListVo.setSettleCurrentMsg("USD");
            }

            if(saleOrderListVo.getOrderClass().equals(OrderTypeEnum.GUOJIDINGDAN)){
                saleOrderListVo.setOrderClassMsg(OrderTypeEnum.GUOJIDINGDAN.getMsg());
            }else {
                saleOrderListVo.setOrderClassMsg(OrderTypeEnum.GUONEIDINGDAN.getMsg());
            }

            if(saleOrderListVo.getOrderType().equals(10)){
                saleOrderListVo.setOrderTypeMsg("销售订单");
            }else {
                saleOrderListVo.setOrderTypeMsg("预订单");
            }

            saleOrderListVo.setStatusMsg(SaleOrderStatusEnums.findByKey(saleOrderListVo.getStatus()).getMsg());

        }
        return saleOrderListVos;
    }

    @Transactional
    @Override
    public String importTotalOrder(List<TotalOrderExcelDto> list, Long userId) {


        TotalOrderAddDto totalOrderAddDto = null;
        for (TotalOrderExcelDto totalOrderExcelDto : list) {

            if (StringUtils.isBlank(totalOrderExcelDto.getPriority())) {
                throw new SwException("优先级不能为空,商品：" + totalOrderExcelDto.getModel());
            }

            if (StringUtils.isBlank(totalOrderExcelDto.getOrderNo())) {
                throw new SwException("订单号不能为空,商品：" + totalOrderExcelDto.getModel());
            }

            if (totalOrderExcelDto.getOrderQty() == null) {
                throw new SwException("订单数量不能为空,商品：" + totalOrderExcelDto.getModel());
            }


            if (StringUtils.isBlank(totalOrderExcelDto.getModel())) {
                throw new SwException("商品型号不能为空");
            }

            totalOrderAddDto = new TotalOrderAddDto();
            totalOrderAddDto.setUserId(userId.intValue());
            totalOrderAddDto.setDelete(DeleteFlagEnum.NOT_DELETE.getCode());
            //根据型号
            CbpbCriteria example = new CbpbCriteria();
            example.createCriteria()
                    .andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                    .andCbpb12EqualTo(totalOrderExcelDto.getModel());
            List<Cbpb> cbpbs = cbpbMapper.selectByExample(example);
            if (cbpbs.size() == 0) {
                throw new SwException("没有查到该型号的商品:" + totalOrderExcelDto.getModel());
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
     *
     * @param saleOrderAddDto
     */
    @Transactional
    @Override
    public void addSaleOrder(SaleOrderAddDto saleOrderAddDto) {

        //判断客户是否可用
        Cbca cbca = baseCheckService.checkCustomer(saleOrderAddDto.getCustomerId());

        //检查是否销售货物
        List<SaleOrderGoodsDto> goods = saleOrderAddDto.getGoods();
        if (goods.size() == 0) {
            throw new SwException("请选择要销售的货物");
        }

        //
        //创建销售订单主表
        Cboa cboa = new Cboa();
        Date date = new Date();
        cboa.setCboa02(date);
        cboa.setCboa03(saleOrderAddDto.getUserId());
        cboa.setCboa04(date);
        cboa.setCboa05(saleOrderAddDto.getUserId());
        cboa.setCboa06(DeleteFlagEnum.NOT_DELETE.getCode());
        NumberDo numberDo = new NumberDo();
        numberDo.setType(NumberGenerateEnum.SALEORDER.getCode());
        cboa.setCboa07(numberGenerate.createOrderNo(numberDo).getOrderNo());
        cboa.setCboa08(date);
        cboa.setCboa09(saleOrderAddDto.getCustomerId());
        cboa.setCboa10(saleOrderAddDto.getSaleUserId());
        cboa.setCboa11(AuditStatusConstants.SO_COMMIT);
        cboa.setCboa13(date);
        cboa.setCboa16(saleOrderAddDto.getCurrency());
        cboa.setCboa17(saleOrderAddDto.getReceiveName());
        cboa.setCboa18(saleOrderAddDto.getAddress());
        cboa.setCboa19(saleOrderAddDto.getReceivePhone());
        cboa.setCboa22(saleOrderAddDto.getInvoiceType());
        cboa.setCboa24(saleOrderAddDto.getOrderType());
        cboa.setCboa25(saleOrderAddDto.getCustomerNo());
        cboa.setCboa27(saleOrderAddDto.getOrderClass());
        cboaMapper.insertWithId(cboa);
        GsWorkInstanceDo gsWorkInstanceDo = new GsWorkInstanceDo();
        gsWorkInstanceDo.setOrderType((byte) 1);
        gsWorkInstanceDo.setOrderClose((byte) 2);
        gsWorkInstanceDo.setOrderStatus((byte) 1);
        gsWorkInstanceDo.setOrderNo(cboa.getCboa07());
        taskService.addGsWorkInstance(gsWorkInstanceDo);
        Cbob cbob = null;
        //创建销售订单明细表
        for (SaleOrderGoodsDto good : goods) {
            //判断库存是否足够
//            GoodsCheckStockVo goodsCheckStockVo=baseCheckService.checkGoodsStock(good.getGoodsId(),saleOrderAddDto.getOrderClass());
            cbob = new Cbob();
            cbob.setCbob02(good.getNumber());
            cbob.setCbob03(date);
            cbob.setCbob04(saleOrderAddDto.getUserId());
            cbob.setCbob05(date);
            cbob.setCbob06(saleOrderAddDto.getUserId());
            cbob.setCbob07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbob.setCbob08(good.getGoodsId());
            cbob.setCbob09(good.getQty());
            cbob.setCbob10(0.0);
            cbob.setCbob11(good.getCurrentPrice());
            cbob.setCbob12(good.getTotalPrice());
            cbob.setCbob13(good.getRemark());
            cbob.setCboa01(cboa.getCboa01());
            cbob.setCbob14(good.getNormalPrice());
            cbobMapper.insert(cbob);
            //创建销售订单要锁住库存
            GoodsOperationDo goodsOperationDo = new GoodsOperationDo();
            goodsOperationDo.setGoodsId(good.getGoodsId());
            goodsOperationDo.setNum(good.getQty());
            goodsOperationDo.setOrderNo(cboa.getCboa07());
            goodsOperationDo.setOrderNum(good.getQty());
            goodsOperationDo.setOrderType(saleOrderAddDto.getOrderClass());
            goodsOperationDo.setUserId(saleOrderAddDto.getUserId());

            SaleOrderMakeDo saleOrderMakeDo = orderDistributionService.saleOrderMake(goodsOperationDo);
            //插入缺货建议
            if (saleOrderMakeDo.getPrompt() == 1&&saleOrderMakeDo.getPrompt()!=null) {
                GsOutStockAdivce advice = null;
                for (OutSuggestionsDo outSuggestionsDo : saleOrderMakeDo.getList()) {
                    advice=new GsOutStockAdivce();
                    advice.setCreateBy(saleOrderAddDto.getUserId());
                    advice.setCreateTime(date);
                    advice.setDeleteFlag(DeleteFlagEnum.NOT_DELETE.getCode().byteValue());
                    advice.setGoodsId(outSuggestionsDo.getGoodsId());
                    advice.setQty(outSuggestionsDo.getQty());
                    advice.setSaleOrderNo(cboa.getCboa07());
                    advice.setStatus(new Byte("1"));
                    advice.setUpdateBy(saleOrderAddDto.getUserId());
                    advice.setUpdateTime(date);
                    advice.setWhId(outSuggestionsDo.getWhId());
                    gsOutStockAdivceMapper.insert(advice);


                }
            }
            //  如果通过清单生成的销售订单，要清空清单
            if(saleOrderAddDto.getFromShopping()==2){
                GsSaleShoppingCriteria shex=new GsSaleShoppingCriteria();
                shex.createCriteria()
                        .andUserIdEqualTo(saleOrderAddDto.getUserId())
                        .andGoodsIdEqualTo(good.getGoodsId());
                int i = gsSaleShoppingMapper.deleteByExample(shex);
            }

        }




        return;

    }

    @Override
    public SaleOrderDetailVo saleOderDetail(Integer orderId) {
        SaleOrderDetailVo res = new SaleOrderDetailVo();
        Cboa cboa = cboaMapper.selectByPrimaryKey(orderId);
        if (cboa == null || DeleteFlagEnum.DELETE.getCode().equals(cboa.getCboa06())) {
            throw new SwException("未找到该订单");
        }
        res.setId(cboa.getCboa01());
        res.setAddress(cboa.getCboa18());
        res.setCustomerId(cboa.getCboa09());
        res.setCustomerNo(cboa.getCboa25());
        Cbca cbca = cbcaMapper.selectByPrimaryKey(cboa.getCboa09());
        if (cbca != null) {
            //todo 待确认
//            res.setFcNumber();
            res.setFpAdress(cbca.getCbca26());
            res.setFpbank(cbca.getCbca11());
            res.setFpNumber(cbca.getCbca12());
            res.setFpPhone(cbca.getCbca27());
            res.setFpReceiveAddress(cbca.getCbca25());
            res.setTaxpayerid(cbca.getCbca13());

        }
        res.setInvoiceType(cboa.getCboa22());
        SysUser createUser = sysUserMapper.selectByPrimaryKey(cboa.getCboa03().longValue());
        if (createUser != null) {
            res.setMakeUser(createUser.getNickName());
        }

        res.setOrderClass(cboa.getCboa27());
        if (OrderTypeEnum.GUONEIDINGDAN.getCode().equals(cboa.getCboa27())) {
            res.setOrderClassMsg(OrderTypeEnum.GUONEIDINGDAN.getMsg());
        } else {
            res.setOrderClassMsg(OrderTypeEnum.GUOJIDINGDAN.getMsg());
        }

        res.setOrderDate(cboa.getCboa08());
        res.setOrderNo(cboa.getCboa07());
        res.setOrderType(cboa.getCboa24());
        //todo 待确认
//        res.setOther();
        res.setReceiveName(cboa.getCboa17());
        res.setReceivePhone(cboa.getCboa19());
        if(cboa.getCboa10()!=null){
            SysUser saleUser = sysUserMapper.selectByPrimaryKey(cboa.getCboa10().longValue());
            if (saleUser != null) {
                res.setSaleUser(saleUser.getNickName());
            }
        }



        //货物明细
        CbobCriteria example = new CbobCriteria();
        example.createCriteria()
                .andCbob07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCboa01EqualTo(cboa.getCboa01());
        List<Cbob> cbobs = cbobMapper.selectByExample(example);

        Double sunPrice = 0.0;
        Double sumQty = 0.0;

        List<SaleOderDetailGoods> goods = res.getGoods();
        SaleOderDetailGoods good = null;
        CalaCriteria laexample = new CalaCriteria();
        laexample.createCriteria()
                .andCala10EqualTo("商品品牌");
        List<Cala> calas = calaMapper.selectByExample(laexample);
        Map<String, String> brandMap = new HashMap<>();
        for (Cala cala : calas) {
            brandMap.put(cala.getCala02(), cala.getCala08());
        }


        for (Cbob cbob : cbobs) {
            good = new SaleOderDetailGoods();
            good.setId(cbob.getCboa01());
            Cbpb cbpb = cbpbMapper.selectByPrimaryKey(cbob.getCbob08());
            if (cbpb != null) {
                good.setBrand(brandMap.get(cbpb.getCbpb10()));
                good.setDescription(cbpb.getCbpb08());
                good.setModel(cbpb.getCbpb12());

            }
            good.setCurrentPrice(cbob.getCbob11());
            good.setNormPrice(cbob.getCbob14());
            good.setRemark(cbob.getCbob13());
            good.setQty(cbob.getCbob09());
            good.setTotalPrice(cbob.getCbob12());
            good.setTotalOrderNo(cbob.getCbob18());
            sunPrice = sunPrice + cbob.getCbob12();
            sumQty = sumQty + cbob.getCbob09();
            res.getGoods().add(good);
        }
        //金额数量合计

        res.setSumPrice(sunPrice);
        res.setSumQty(sumQty);
        res.setCapPrice(NumberToChineseUtil.moneyToChinese(res.getSumPrice()));

        //审批记录
        CabraaCriteria raaexample = new CabraaCriteria();
        raaexample.createCriteria()
                .andCabraa14EqualTo(cboa.getCboa07());
        List<Cabraa> cabraas = cabraaMapper.selectByExample(raaexample);

        SaleOrderAudit saleOrderAudit = null;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Cabraa cabraa : cabraas) {
            saleOrderAudit = new SaleOrderAudit();
            saleOrderAudit.setAuditResult(cabraa.getCabraa18());
            String createTime = sd.format(cabraa.getCabraa15());
            SysUser auditUser = sysUserMapper.selectByPrimaryKey(cabraa.getCabraa04().longValue());
            String audit = null;
            if (auditUser != null) {
                audit = auditUser.getNickName() == null ? "" : auditUser.getNickName();
            }

            saleOrderAudit.setDescription(createTime + " 由 " + audit + " 审核");
            saleOrderAudit.setId(cabraa.getCabraa01());
            saleOrderAudit.setRole(cabraa.getCabraa19());
            res.getAudits().add(saleOrderAudit);
        }

        return res;
    }

    /**
     * 修改销售订单
     *
     * @param saleOrderAddDto
     */
    @Transactional
    @Override
    public void mdfSaleOrder(SaleOrderAddDto saleOrderAddDto) {
        //只有在未提交状态下才能修改
        Cboa cboa = cboaMapper.selectByPrimaryKey(saleOrderAddDto.getOrderId());
        if (cboa == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(cboa.getCboa06())) {
            throw new SwException("没有查到该订单");
        }
        if(!SaleOrderStatusEnums.WEITIJIAO.getCode().equals(cboa.getCboa11())){
            throw new SwException("销售订单状态必须为未提交状态");
        }

        Date date = new Date();
        if (!cboa.getCboa10().equals(saleOrderAddDto.getUserId())) {
            throw new SwException("只能由销售人员本人操作");
        }

        cboa.setCboa04(date);
        cboa.setCboa05(saleOrderAddDto.getUserId());
        cboa.setCboa06(DeleteFlagEnum.NOT_DELETE.getCode());
        NumberDo numberDo = new NumberDo();
        numberDo.setType(NumberGenerateEnum.SALEORDER.getCode());
        cboa.setCboa07(numberGenerate.createOrderNo(numberDo).getOrderNo());
        cboa.setCboa08(date);
        cboa.setCboa09(saleOrderAddDto.getCustomerId());
        cboa.setCboa10(saleOrderAddDto.getSaleUserId());
        cboa.setCboa11(AuditStatusConstants.SO_COMMIT);
        cboa.setCboa13(date);
        cboa.setCboa16(saleOrderAddDto.getCurrency());
        cboa.setCboa17(saleOrderAddDto.getReceiveName());
        cboa.setCboa18(saleOrderAddDto.getAddress());
        cboa.setCboa19(saleOrderAddDto.getReceivePhone());
        cboa.setCboa22(saleOrderAddDto.getInvoiceType());
        cboa.setCboa24(saleOrderAddDto.getOrderType());
        cboa.setCboa27(saleOrderAddDto.getOrderClass());
        cboa.setCboa25(saleOrderAddDto.getCustomerNo());
        int insert = cboaMapper.updateByPrimaryKey(cboa);

        //删除原先的货物详情
        CbobCriteria example = new CbobCriteria();
        example.createCriteria()
                .andCboa01EqualTo(cboa.getCboa01());
        int i = cbobMapper.deleteByExample(example);


        //增加新的
        List<SaleOrderGoodsDto> goods = saleOrderAddDto.getGoods();
        Cbob cbob = null;
        for (SaleOrderGoodsDto good : goods) {
            if(OrderTypeEnum.GUOJIDINGDAN.getCode().equals(saleOrderAddDto.getOrderClass())){
                if(StringUtils.isBlank(good.getTotalOrderNo())){
                    throw new SwException("国际订单要输入生产总订单号");
                }
            }

            //判断库存是否足够
//            GoodsCheckStockVo goodsCheckStockVo=baseCheckService.checkGoodsStock(good.getGoodsId(),saleOrderAddDto.getOrderClass());
            cbob = new Cbob();
            cbob.setCbob02(good.getNumber());
            cbob.setCbob03(date);
            cbob.setCbob04(saleOrderAddDto.getUserId());
            cbob.setCbob05(date);
            cbob.setCbob06(saleOrderAddDto.getUserId());
            cbob.setCbob07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbob.setCbob08(good.getGoodsId());
            cbob.setCbob09(good.getQty());
            cbob.setCbob10(0.0);
            cbob.setCbob11(good.getCurrentPrice());
            cbob.setCbob12(good.getTotalPrice());
            cbob.setCbob13(good.getRemark());
            cbob.setCboa01(cboa.getCboa01());
            cbob.setCbob14(good.getNormalPrice());
            if(StringUtils.isNotBlank(good.getTotalOrderNo())){
                CbbaCriteria baex=new CbbaCriteria();
                baex.createCriteria()
                        .andCbba07EqualTo(good.getTotalOrderNo())
                        .andCbba08EqualTo(good.getGoodsId())
                        .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                List<Cbba> cbbas = cbbaMapper.selectByExample(baex);
                if(cbbas.size()==0){
                    throw new SwException("没有查到该生产总订单，请先添加生产总订单，订单号:"+good.getTotalOrderNo());
                }
                Cbba cbba=cbbas.get(0);
                cbob.setCbob17(cbba.getCbba01());
                cbob.setCbob18(good.getTotalOrderNo());
            }

            cbobMapper.insert(cbob);


        }


    }

    @Transactional
    @Override
    public void delSaleOrder(DelSaleOrderDto delSaleOrderDto) {
        //只能删除自己的
        Cboa cboa = cboaMapper.selectByPrimaryKey(delSaleOrderDto.getOrderId());
        if (!cboa.getCboa10().equals(delSaleOrderDto.getUserId())) {
            throw new SwException("只能由销售人员本人操作");
        }


        cboa.setCboa01(delSaleOrderDto.getOrderId());
        cboa.setCboa06(DeleteFlagEnum.DELETE.getCode());
        cboa.setCboa04(new Date());
        cboa.setCboa05(delSaleOrderDto.getUserId());
        int i = cboaMapper.updateByPrimaryKeySelective(cboa);

    }

    /**
     * 撤销  销售订单
     *
     * @param orderId
     * @param userId
     */
    @Override
    public void revokeSaleOrder(Integer orderId, Integer userId) {
        Cboa cboa = cboaMapper.selectByPrimaryKey(orderId);
        if (cboa == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(cboa.getCboa06())) {
            throw new SwException("没有查到该订单");
        }

        //只能是已提交状态才能撤销
        if (!SaleOrderStatusEnums.YITIJIAO.getCode().equals(cboa.getCboa11())) {
            throw new SwException("订单状态为未提交才能进行撤销");
        }

        //撤销后删除商品占用
        GsGoodsUseCriteria usexample = new GsGoodsUseCriteria();
        usexample.createCriteria()
                .andOrderNoEqualTo(cboa.getCboa07());
        int i = gsGoodsUseMapper.deleteByExample(usexample);


        //删除缺货建议
        //删除缺货建议
        GsOutStockAdivceCriteria adexample = new GsOutStockAdivceCriteria();
        adexample.createCriteria()
                .andSaleOrderNoEqualTo(cboa.getCboa07());
        int i1 = gsOutStockAdivceMapper.deleteByExample(adexample);


    }

    @Transactional
    @Override
    public String importySaleOrder(List<SaleOrderExcelDto> list, Long userId) {
        //国际订单入不需要判断库存是足够
        if (list.size() == 0) {
            throw new SwException("请填写要导入的货物");
        }

        Map<String, List<String>> customerMap = new HashMap<>();
        Map<String, List<SaleOrderExcelDto>> goodsMap = new HashMap<>();
        Map<String, Integer> totalOrderMap = new HashMap<>();


        for (SaleOrderExcelDto saleOrderExcelDto : list) {
            if (StringUtils.isBlank(saleOrderExcelDto.getCustomerName())) {
                throw new SwException("客戶那一列有为空的数据");
            }

            if (StringUtils.isBlank(saleOrderExcelDto.getSku())) {
                throw new SwException("SKU那一列有为空的数据");
            }

            if (StringUtils.isBlank(saleOrderExcelDto.getSaleUserName())) {
                throw new SwException("销售人员那一列有为空的数据");
            }


            if (saleOrderExcelDto.getQty() == null) {
                throw new SwException("Release Quantity那一列有为空的数据");
            }

            totalOrderMap.put(saleOrderExcelDto.getTotalOrderNo(), 1);

            List<SaleOrderExcelDto> strings = goodsMap.get(saleOrderExcelDto.getTotalOrderNo() + "_" + saleOrderExcelDto.getCustomerName());
            if (strings == null) {
                strings = new ArrayList<>();
            }
            strings.add(saleOrderExcelDto);

            List<String> customers = customerMap.get(saleOrderExcelDto.getTotalOrderNo());
            if (strings == null) {
                customers = new ArrayList<>();
            }
            customers.add(saleOrderExcelDto.getCustomerName());

        }

        for (String key : totalOrderMap.keySet()) {
            List<String> customers = customerMap.get(key);
            for (String customer : customers) {
                List<SaleOrderExcelDto> saleOrderExcelDtos = goodsMap.get(key + "_" + customer);
                CbcaCriteria caex = new CbcaCriteria();
                caex.createCriteria()
                        .andCbca08EqualTo(customer)
                        .andCbca06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                        .andCbca07EqualTo("启用");
                List<Cbca> cbcas = cbcaMapper.selectByExample(caex);
                if (cbcas.size() == 0) {
                    throw new SwException("该客户不可用，客户:" + customer);
                }
                Cbca cbca = cbcas.get(0);
                String saleUser = "";
                String orderType = "";
                String currency = "1";
                Double normalPrice = 0.0;
                if (saleOrderExcelDtos.size() > 0) {
                    SaleOrderExcelDto saleOrderExcelDto = saleOrderExcelDtos.get(0);
                    saleUser = saleOrderExcelDto.getSaleUserName();
                    orderType = saleOrderExcelDto.getOrderType();
                    CalaCriteria laex = new CalaCriteria();
                    laex.createCriteria()
                            .andCala08EqualTo(saleOrderExcelDto.getCurrency());
                    List<Cala> calas = calaMapper.selectByExample(laex);
                    if (calas.size() > 0) {
                        currency = calas.get(0).getCala02();
                    }
                }
                //查销售人员
                SysUserCriteria suex = new SysUserCriteria();
                suex.createCriteria()
                        .andNickNameEqualTo(saleUser);
                List<SysUser> sysUsers = sysUserMapper.selectByExample(suex);
                Integer saleUserId = null;
                if (sysUsers.size() > 0) {
                    saleUserId = sysUsers.get(0).getUserId().intValue();
                }

                //创建销售订单主表
                Cboa cboa = new Cboa();
                Date date = new Date();
                cboa.setCboa02(date);
                cboa.setCboa03(userId.intValue());
                cboa.setCboa04(date);
                cboa.setCboa05(userId.intValue());
                cboa.setCboa06(DeleteFlagEnum.NOT_DELETE.getCode());
                NumberDo numberDo = new NumberDo();
                numberDo.setType(NumberGenerateEnum.SALEORDER.getCode());
                cboa.setCboa07(numberGenerate.createOrderNo(numberDo).getOrderNo());
                cboa.setCboa08(date);
                cboa.setCboa09(cbca.getCbca01());
                cboa.setCboa10(saleUserId);
                cboa.setCboa11(AuditStatusConstants.SO_COMMIT);
                cboa.setCboa13(date);
                cboa.setCboa16(Integer.valueOf(currency));
                cboa.setCboa17(cbca.getCbca14());
                cboa.setCboa18(cbca.getCbca15());
                cboa.setCboa19(cbca.getCbca16());
                cboa.setCboa22(cbca.getCbca24());
                if (SaleOrderTypeEnum.XIAOSHOUDINGDAN.getMsg().equals(orderType)) {
                    cboa.setCboa24(SaleOrderTypeEnum.XIAOSHOUDINGDAN.getCode());
                } else {
                    cboa.setCboa24(SaleOrderTypeEnum.YUDINGDAN.getCode());
                }


                cboa.setCboa27(OrderTypeEnum.GUOJIDINGDAN.getCode());
                int insert = cboaMapper.insert(cboa);
                Cbob cbob = null;
                for (int i = 0; i < saleOrderExcelDtos.size(); i++) {
                    SaleOrderExcelDto saleOrderExcelDto = saleOrderExcelDtos.get(i);
                    CbpbCriteria pbex = new CbpbCriteria();
                    pbex.createCriteria()
                            .andCbpb12EqualTo(saleOrderExcelDto.getSku())
                            .andCbpb07EqualTo("启用")
                            .andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                    List<Cbpb> cbpbs = cbpbMapper.selectByExample(pbex);


                    if (cbpbs.size() == 0) {
                        throw new SwException("该商品不可用，商品：" + saleOrderExcelDto.getSku());
                    }
                    Cbpb cbpb = cbpbs.get(0);

                    CbpfCriteria pfex = new CbpfCriteria();
                    pfex.createCriteria()
                            .andCbpf03EqualTo(6)
                            .andCbpb01EqualTo(cbpb.getCbpb01())
                            .andCbpf02EqualTo(cbca.getCbca28());
                    pfex.setOrderByClause("CBPF07 desc");
                    List<Cbpf> cbpfs = cbpfMapper.selectByExample(pfex);
                    if (cbpfs.size() > 0 && cbpfs.get(0).getCbpf07().getTime() <= date.getTime()) {
                        normalPrice = cbpfs.get(0).getCbpf05();
                    }

                    //查生产总订单
                    CbbaCriteria baex=new CbbaCriteria();
                    baex.createCriteria()
                            .andCbba07EqualTo(saleOrderExcelDto.getTotalOrderNo())
                            .andCbba08EqualTo(cbpb.getCbpb01())
                            .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                    List<Cbba> cbbas = cbbaMapper.selectByExample(baex);
                    if(cbbas.size()==0){
                        throw new SwException("没有查到该生产总订单，请先添加生产总订单，订单号:"+saleOrderExcelDto.getTotalOrderNo());
                    }
                    Cbba cbba=cbbas.get(0);
                    cbob = new Cbob();
                    cbob.setCbob02(i);
                    cbob.setCbob03(date);
                    cbob.setCbob04(userId.intValue());
                    cbob.setCbob05(date);
                    cbob.setCbob06(userId.intValue());
                    cbob.setCbob07(DeleteFlagEnum.NOT_DELETE.getCode());
                    cbob.setCbob08(cbpb.getCbpb01());
                    cbob.setCbob09(saleOrderExcelDto.getQty());
                    cbob.setCbob10(0.0);
                    cbob.setCbob11(saleOrderExcelDto.getPrice());
                    cbob.setCbob12(saleOrderExcelDto.getPrice() * saleOrderExcelDto.getQty());
                    cbob.setCbob13(saleOrderExcelDto.getRemark());
                    cbob.setCboa01(cboa.getCboa01());
                    cbob.setCbob14(normalPrice);

                    cbob.setCbob17(cbba.getCbba01());
                    cbob.setCbob18(saleOrderExcelDto.getTotalOrderNo());
                    cbobMapper.insert(cbob);
                    //创建销售订单要锁住库存
                    GoodsOperationDo goodsOperationDo = new GoodsOperationDo();
                    goodsOperationDo.setGoodsId(cbpb.getCbpb01());
                    goodsOperationDo.setNum(saleOrderExcelDto.getQty());
                    goodsOperationDo.setOrderNo(saleOrderExcelDto.getTotalOrderNo());
                    goodsOperationDo.setOrderNum(saleOrderExcelDto.getQty());
                    goodsOperationDo.setOrderType(OrderTypeEnum.GUOJIDINGDAN.getCode());
                    goodsOperationDo.setUserId(userId.intValue());
                    SaleOrderMakeDo saleOrderMakeDo = orderDistributionService.saleOrderMake(goodsOperationDo);

                }


            }

        }

        return "导入成功";


    }
    @Transactional
    @Override
    public void reAddSaleOrder(Integer orderId, Long userId) {

        //只能提交自己的
        Cboa cboa = cboaMapper.selectByPrimaryKey(orderId);
        if (cboa == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(cboa.getCboa06())) {
            throw new SwException("没有查到该订单");
        }
        if(!SaleOrderStatusEnums.WEITIJIAO.getCode().equals(cboa.getCboa11())){
            throw new SwException("销售订单状态必须为未提交状态");
        }

        Date date = new Date();
        if (!cboa.getCboa10().equals(userId.intValue())) {
            throw new SwException("只能由销售人员本人操作");
        }

        //国内订单增加占用
        if(OrderTypeEnum.GUONEIDINGDAN.getCode().equals(cboa.getCboa27())){
            CbobCriteria obex=new CbobCriteria();
            obex.createCriteria()
                    .andCboa01EqualTo(cboa.getCboa01())
                    .andCbob07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbob> cbobs = cbobMapper.selectByExample(obex);


            for (Cbob good : cbobs) {


                //创建销售订单要锁住库存
                GoodsOperationDo goodsOperationDo = new GoodsOperationDo();
                goodsOperationDo.setGoodsId(good.getCboa01());
                goodsOperationDo.setNum(cboa.getCboa09().doubleValue());
                goodsOperationDo.setOrderNo(cboa.getCboa07());
                goodsOperationDo.setOrderNum(cboa.getCboa09().doubleValue());
                goodsOperationDo.setOrderType(OrderTypeEnum.GUONEIDINGDAN.getCode());
                goodsOperationDo.setUserId(userId.intValue());
                SaleOrderMakeDo saleOrderMakeDo = orderDistributionService.saleOrderMake(goodsOperationDo);
                //插入缺货建议
                if (saleOrderMakeDo.getPrompt() == 1) {
                    GsOutStockAdivce advice = null;
                    for (OutSuggestionsDo outSuggestionsDo : saleOrderMakeDo.getList()) {
                        advice.setCreateBy(userId.intValue());
                        advice.setCreateTime(date);
                        advice.setDeleteFlag(DeleteFlagEnum.NOT_DELETE.getCode().byteValue());
                        advice.setGoodsId(outSuggestionsDo.getGoodsId());
                        advice.setQty(outSuggestionsDo.getQty());
                        advice.setSaleOrderNo(cboa.getCboa07());
                        advice.setStatus(new Byte("1"));
                        advice.setUpdateBy(userId.intValue());
                        advice.setUpdateTime(date);
                        advice.setWhId(outSuggestionsDo.getWhId());
                        gsOutStockAdivceMapper.insert(advice);


                    }
                }

            }
            GsWorkInstanceDo goodsWorkInstanceDo = new GsWorkInstanceDo();
            goodsWorkInstanceDo.setOrderType((byte) 2);
            goodsWorkInstanceDo.setOrderClose(OrdercloseEnum.WEIJIESHU.getCode());
            goodsWorkInstanceDo.setOrderStatus(OrderstatusEnum.DAISHENPI.getCode());
            taskService.editGsWorkInstance(goodsWorkInstanceDo);
        }

        //更改销售订单状态
        cboa.setCboa11(SaleOrderStatusEnums.YITIJIAO.getCode());
        cboa.setCboa04(new Date());
        cboa.setCboa05(userId.intValue());
        cboaMapper.updateByPrimaryKey(cboa);


    }



    @Override
    public GoodsPriceAndSkuVo goodsPriceAndSku(GoodsPriceAndSkuDto goodsPriceAndSkuDto) {
        GoodsPriceAndSkuVo res=new GoodsPriceAndSkuVo();

        //查询客户是否可用
        Cbca cbca = baseCheckService.checkCustomer(goodsPriceAndSkuDto.getCustomerId());


        CbpfCriteria pfex=new CbpfCriteria();
        pfex.createCriteria()
                .andCbpf02EqualTo(cbca.getCbca28())
                .andCbpb01EqualTo(goodsPriceAndSkuDto.getGoodsId());
        pfex.setOrderByClause("CBPF07 desc");
        List<Cbpf> cbpfs = cbpfMapper.selectByExample(pfex);
        Date date=new Date();
        if (cbpfs.size() > 0 && cbpfs.get(0).getCbpf07().getTime() <= date.getTime()) {
            res.setNormalPrice(cbpfs.get(0).getCbpf05());
        }
        res.setGoodsId(goodsPriceAndSkuDto.getGoodsId());



        List<Cbwa> list = cbwaMapper.selectCalculationOrderPriority();

        if (list.size() == 0) {
            throw new SwException("无可用分配库存的仓库");
        }

        Cbib cbib = cbibMapper.selectLastByGoodsId(goodsPriceAndSkuDto.getGoodsId());
        if(cbib==null){
            throw new SwException("没有找到该商品的仓库台账");
        }
        List<GsGoodsUse> goodsUseList = gsGoodsUseMapper.selectByGoodsId(goodsPriceAndSkuDto.getGoodsId());
        Double useNum = goodsUseList.stream().collect(Collectors.summingDouble(GsGoodsUse::getLockQty));
        Double num = cbib.getCbib15() - useNum;
        if(num<0){
            num=0.0;
        }

        res.setCanUseSku(num);
        res.setCkSku(num);
        if(res.getNormalPrice()==null){
            res.setNormalPrice(0.0);
        }
        return res;

    }

    @Transactional
    @Override
    public void auditSaleOrder(AuditSaleOrderDto auditSaleOrderDto) {
        Date date = new Date();

        Cboa cboa= baseCheckService.checkSaleOrder(auditSaleOrderDto.getOrderId());
        Integer orderStatus = cboa.getCboa11();
        //检查是否具有审核权限
        Byte perType=1;
        if(OrderTypeEnum.GUOJIDINGDAN.getCode().equals(cboa.getCboa27())){
            perType=2;
        }
        baseCheckService.checkUserTask(auditSaleOrderDto.getUserId().longValue(),perType);

        if(auditSaleOrderDto.getOpeateType().equals(5)){

            if(!SaleOrderStatusEnums.YIFUSHEN.getCode().equals(orderStatus)){
                throw new SwException("只有在已复审的状态下才能指定结束");
            }
            //指定结束
            cboa.setCboa11(SaleOrderStatusEnums.ZHIDINGJIESHU.getCode());
            //除未提交都要释放未发货的库存占用
            if(!SaleOrderStatusEnums.WEITIJIAO.getCode().equals(cboa.getCboa11())){
                CbobCriteria obex=new CbobCriteria();
                obex.createCriteria()
                        .andCboa01EqualTo(cboa.getCboa01())
                        .andCbob07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                List<Cbob> cbobs = cbobMapper.selectByExample(obex);
                for (Cbob cbob : cbobs) {
                    GsGoodsUseCriteria guex=new GsGoodsUseCriteria();
                    guex.createCriteria()
                            .andOrderNoEqualTo(cboa.getCboa07())
                            .andGoodsIdEqualTo(cbob.getCbob08());
                    List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(guex);
                    Double noUse=cbob.getCbob09()-cbob.getCbob10();

                    for (GsGoodsUse gsGoodsUs : gsGoodsUses) {
                        if(noUse>=gsGoodsUs.getLockQty()){
                            gsGoodsUseMapper.deleteByPrimaryKey(gsGoodsUs.getId());
                            noUse=noUse-gsGoodsUs.getLockQty();

                        }else {
                            gsGoodsUs.setLockQty(gsGoodsUs.getLockQty()-noUse);
                            gsGoodsUs.setUpdateTime(new Date());
                            gsGoodsUseMapper.updateByPrimaryKey(gsGoodsUs);
                            noUse=0.0;
                        }

                        if(noUse==0){
                            break;
                        }
                    }

                }
            }


        }else if(auditSaleOrderDto.getOpeateType().equals(SaleOrderStatusEnums.YISHENHE.getCode())){
            //审核通过
            if(!SaleOrderStatusEnums.YITIJIAO.getCode().equals(orderStatus)){
                throw new SwException("失败，订单状态必须为已提交");
            }
            cboa.setCboa11(SaleOrderStatusEnums.YISHENHE.getCode());
            Cabraa cabraa=new Cabraa();
            cabraa.setCabraa02(date);
            cabraa.setCabraa03(date);
            cabraa.setCabraa04(auditSaleOrderDto.getUserId());
            cabraa.setCabraa05(auditSaleOrderDto.getUserId());
            cabraa.setCabraa06(DeleteFlagEnum.NOT_DELETE.getCode());
            cabraa.setCabraa07("销售订单");
            cabraa.setCabraa12(date);
            cabraa.setCabraa14(cboa.getCboa07());
            cabraa.setCabraa15(date);
            cabraa.setCabraa18("[审核]ok");
            cabraa.setCabraa11(auditSaleOrderDto.getUserId());
            cabraaMapper.insert(cabraa);

        }else if(auditSaleOrderDto.getOpeateType().equals(SaleOrderStatusEnums.YIFUSHEN.getCode())){

            if(!SaleOrderStatusEnums.YIFUSHEN.getCode().equals(orderStatus)){
                throw new SwException("只有在已复审的状态下才能指定结束");
            }
            //指定结束
            cboa.setCboa11(SaleOrderStatusEnums.YIWANCHENG.getCode());
            //除未提交都要释放未发货的库存占用
            if(!SaleOrderStatusEnums.WEITIJIAO.getCode().equals(cboa.getCboa11())){
                CbobCriteria obex=new CbobCriteria();
                obex.createCriteria()
                        .andCboa01EqualTo(cboa.getCboa01())
                        .andCbob07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                List<Cbob> cbobs = cbobMapper.selectByExample(obex);
                for (Cbob cbob : cbobs) {
                    GsGoodsUseCriteria guex=new GsGoodsUseCriteria();
                    guex.createCriteria()
                            .andOrderNoEqualTo(cboa.getCboa07())
                            .andGoodsIdEqualTo(cbob.getCbob08());
                    List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(guex);
                    Double noUse=cbob.getCbob09()-cbob.getCbob10();

                    for (GsGoodsUse gsGoodsUs : gsGoodsUses) {
                        if(noUse>=gsGoodsUs.getLockQty()){
                            gsGoodsUseMapper.deleteByPrimaryKey(gsGoodsUs.getId());
                            noUse=noUse-gsGoodsUs.getLockQty();

                        }else {
                            gsGoodsUs.setLockQty(gsGoodsUs.getLockQty()-noUse);
                            gsGoodsUs.setUpdateTime(new Date());
                            gsGoodsUseMapper.updateByPrimaryKey(gsGoodsUs);
                            noUse=0.0;
                        }

                        if(noUse==0){
                            break;
                        }
                    }

                }
            }
        }



        cboa.setCboa05(auditSaleOrderDto.getUserId());
        cboa.setCboa04(date);
        cboaMapper.updateByPrimaryKey(cboa);

    }

    @Override
    public List<SaleOrderListVo> finsaleOrderList(SaleOrderListDto saleOrderListDto) {


        List<SaleOrderListVo> saleOrderListVos = cboaMapper.finsaleOrderList(saleOrderListDto);
        for (SaleOrderListVo saleOrderListVo : saleOrderListVos) {
            if(saleOrderListVo.getSettleCurrent().equals(6)){
                saleOrderListVo.setSettleCurrentMsg("CNY");
            }else {
                saleOrderListVo.setSettleCurrentMsg("USD");
            }

            if(saleOrderListVo.getOrderClass().equals(OrderTypeEnum.GUOJIDINGDAN)){
                saleOrderListVo.setOrderClassMsg(OrderTypeEnum.GUOJIDINGDAN.getMsg());
            }else {
                saleOrderListVo.setOrderClassMsg(OrderTypeEnum.GUONEIDINGDAN.getMsg());
            }

            if(saleOrderListVo.getOrderType().equals(10)){
                saleOrderListVo.setOrderTypeMsg("销售订单");
            }else {
                saleOrderListVo.setOrderTypeMsg("预订单");
            }

            saleOrderListVo.setStatusMsg(SaleOrderStatusEnums.findByKey(saleOrderListVo.getStatus()).getMsg());

        }
        return saleOrderListVos;

    }

    @Override
    public void auditFinSaleOrder(AuditSaleOrderDto auditSaleOrderDto) {

        Cboa cboa= baseCheckService.checkSaleOrder(auditSaleOrderDto.getOrderId());
        //检查是否具有审核权限

        SysUser sysUser = baseCheckService.checkUserTask(auditSaleOrderDto.getUserId().longValue(), new Byte("11"));

        //判断是反审还是复审
        if(auditSaleOrderDto.getOpeateType().equals(4)){
            if(!SaleOrderStatusEnums.YISHENHE.getCode().equals(cboa.getCboa11())){
                throw new SwException("只有已审核状态才能进行复审");
            }

            Date date = new Date();
            cboa.setCboa04(date);
            cboa.setCboa05(auditSaleOrderDto.getUserId());
            cboa.setCboa11(SaleOrderStatusEnums.YIFUSHEN.getCode());
            cboaMapper.insert(cboa);

        }else {
            if(!SaleOrderStatusEnums.YIFUSHEN.getCode().equals(cboa.getCboa11())){
                throw new SwException("只有已复核状态才能进行反审");
            }

            Date date = new Date();
            cboa.setCboa04(date);
            cboa.setCboa05(auditSaleOrderDto.getUserId());
            cboa.setCboa11(SaleOrderStatusEnums.YISHENHE.getCode());
            cboaMapper.insert(cboa);
        }


    }


    @Override
    public List<GoodsShopVo> goodsShopList(Integer userId) {
        return gsSaleShoppingMapper.goodsShopList(userId);

    }



    @Override
    public List<SaleOrderListVo> saleChangeList(SaleOrderListDto saleOrderListDto) {

        List<SaleOrderListVo> saleOrderListVos = cbocMapper.saleChangeList(saleOrderListDto);
        for (SaleOrderListVo saleOrderListVo : saleOrderListVos) {
            if(saleOrderListVo.getSettleCurrent().equals(6)){
                saleOrderListVo.setSettleCurrentMsg("CNY");
            }else {
                saleOrderListVo.setSettleCurrentMsg("USD");
            }

            if(saleOrderListVo.getOrderClass().equals(OrderTypeEnum.GUOJIDINGDAN)){
                saleOrderListVo.setOrderClassMsg(OrderTypeEnum.GUOJIDINGDAN.getMsg());
            }else {
                saleOrderListVo.setOrderClassMsg(OrderTypeEnum.GUONEIDINGDAN.getMsg());
            }

            if(saleOrderListVo.getOrderType().equals(10)){
                saleOrderListVo.setOrderTypeMsg("销售订单");
            }else {
                saleOrderListVo.setOrderTypeMsg("预订单");
            }

            saleOrderListVo.setStatusMsg(SaleOrderStatusEnums.findByKey(saleOrderListVo.getStatus()).getMsg());

        }
        return saleOrderListVos;
    }

    @Transactional
    @Override
    public void addSaleOrderChange(SaleOrderChangeDto saleOrderChangeDto) {
        Cboa cboa = cboaMapper.selectByPrimaryKey(saleOrderChangeDto.getOrderId());
        if(cboa==null || ! DeleteFlagEnum.NOT_DELETE.equals(cboa.getCboa06())){
            throw new SwException("没有查到该销售订单");
        }

        //判断操作人员是否是销售人员
        if(!cboa.getCboa11().equals(saleOrderChangeDto.getUserId())){
            throw new SwException("必须为销售人员本人");
        }


        //创建销售订单主表
        Cboc cboc = new Cboc();
        Date date = new Date();
        cboc.setCboc02(date);
        cboc.setCboc03(saleOrderChangeDto.getUserId());
        cboc.setCboc04(date);
        cboc.setCboc05(saleOrderChangeDto.getUserId());
        cboc.setCboc06(DeleteFlagEnum.NOT_DELETE.getCode());
        NumberDo numberDo = new NumberDo();
        numberDo.setType(NumberGenerateEnum.SALEORDERCHANGE.getCode());
        cboc.setCboc07(numberGenerate.createOrderNo(numberDo).getOrderNo());
        cboc.setCboc08(date);
        cboc.setCboc09(cboa.getCboa09());
        cboc.setCboc10(cboa.getCboa10());
        cboc.setCboc11(AuditStatusConstants.SO_COMMIT);
        cboc.setCboc13(date);
        cboc.setCboc16(cboa.getCboa16());
        cboc.setCboc17(cboa.getCboa17());
        cboc.setCboc18(cboa.getCboa18());
        cboc.setCboc19(cboa.getCboa19());
        cboc.setCboc22(cboa.getCboa22());
         cboc.setCboc24(cboa.getCboa24());
        cboc.setCboc26(cboa.getCboa01());
         cbocMapper.insertWithId(cboc);
        GsWorkInstanceDo gsWorkInstanceDo = new GsWorkInstanceDo();
        gsWorkInstanceDo.setOrderType((byte) 2);
        gsWorkInstanceDo.setOrderClose(OrdercloseEnum.WEIJIESHU.getCode());
        gsWorkInstanceDo.setOrderStatus(OrderstatusEnum.DAISHENPI.getCode());
        gsWorkInstanceDo.setOrderNo(cboc.getCboc07());
        taskService.addGsWorkInstance(gsWorkInstanceDo);
        Cbod cbod=null;
        for (SaleOrderChangeGoodsDto good : saleOrderChangeDto.getGoods()) {

            //查出原先旧数据
            CbobCriteria obexample=new CbobCriteria();
            obexample.createCriteria()
                    .andCbob08EqualTo(good.getGoodsId())
                    .andCboa01EqualTo(cboa.getCboa01())
                    .andCbob06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbob> cbobs = cbobMapper.selectByExample(obexample);
            if(cbobs.size()==0){
                throw new SwException("没有在原销售订单查到该商品:"+good.getGoodsId());
            }
            //数量只能减少不能增加 不能小于发货数量
            Cbob cbob = cbobs.get(0);
            if(good.getQty()>cbob.getCbob09()){
                throw new SwException("数量只能减少不能增加");
            }

            if(good.getQty()<cbob.getCbob10()){
                throw new SwException("修改后的数量不能小于发货数量");
            }

            cbod = new Cbod();
            cbod.setCbod02(good.getNumber());
            cbod.setCbod03(date);
            cbod.setCbod04(saleOrderChangeDto.getUserId());
            cbod.setCbod05(date);
            cbod.setCbod06(saleOrderChangeDto.getUserId());
            cbod.setCbod07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbod.setCbod08(good.getGoodsId());
            cbod.setCbod09(good.getQty());
            cbod.setCbod10(cbob.getCbob10());
            cbod.setCbod11(good.getCurrentPrice());
            cbod.setCbod12(good.getCurrentPrice()*good.getQty());
            cbod.setCbod13(good.getRemark());
            cbod.setCbod01(cboc.getCboc01());
            cbod.setCbod14(good.getNormalPrice());
            cbod.setBefPrice(cbob.getCbob11());
            cbod.setBefQty(cbob.getCbob09());
            cbodMapper.insert(cbod);
            //如果有占用 释放占用库存
            Double noneedNum=cbob.getCbob09()-cbod.getCbod09();
            if(noneedNum!=0.0){
                GsGoodsUseCriteria usex=new GsGoodsUseCriteria();
                usex.createCriteria()
                        .andGoodsIdEqualTo(good.getGoodsId())
                        .andOrderNoEqualTo(cboa.getCboa17());
                List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(usex);
                for (GsGoodsUse gsGoodsUs : gsGoodsUses) {
                    gsGoodsUs.setLockQty(gsGoodsUs.getLockQty()-noneedNum);
                    gsGoodsUs.setOrderQty(cbod.getCbod09());
                    gsGoodsUs.setUpdateTime(date);
                    if(gsGoodsUs.getLockQty()==0.0){
                        gsGoodsUseMapper.deleteByPrimaryKey(gsGoodsUs.getId());
                    }else {
                        gsGoodsUseMapper.updateByPrimaryKey(gsGoodsUs);
                    }
                }
            }


        }
    }

    @Override
    public List<OrderChangeGoodsMsgVo> orderChangeGoodsMsg(OrderChangeGoodsMsgDto orderChangeGoodsMsgDto) {
            return cbobMapper.orderChangeGoodsMsg(orderChangeGoodsMsgDto);

    }

    @Transactional
    @Override
    public OrderChangeDetailVo orderChangeDetail(Integer orderId) {
        OrderChangeDetailVo res = new OrderChangeDetailVo();
        Cboc cboc = cbocMapper.selectByPrimaryKey(orderId);
        if (cboc == null || DeleteFlagEnum.DELETE.getCode().equals(cboc.getCboc06())) {
            throw new SwException("未找到该订单");
        }
        res.setId(cboc.getCboc01());
        res.setAddress(cboc.getCboc18());
        res.setCustomerId(cboc.getCboc09());
        res.setCustomerNo(cboc.getCboc25());
        Cbca cbca = cbcaMapper.selectByPrimaryKey(cboc.getCboc09());
        if (cbca != null) {
            //todo 待确认
//            res.setFcNumber();
            res.setFpAdress(cbca.getCbca26());
            res.setFpbank(cbca.getCbca11());
            res.setFpNumber(cbca.getCbca12());
            res.setFpPhone(cbca.getCbca27());
            res.setFpReceiveAddress(cbca.getCbca25());
            res.setTaxpayerid(cbca.getCbca13());

        }
        res.setInvoiceType(cboc.getCboc22());
        SysUser createUser = sysUserMapper.selectByPrimaryKey(cboc.getCboc03().longValue());
        if (createUser != null) {
            res.setMakeUser(createUser.getNickName());
        }




        res.setOrderDate(cboc.getCboc08());
        res.setOrderChangeNo(cboc.getCboc07());

        Cboa cboa = cboaMapper.selectByPrimaryKey(cboc.getCboc26());
        if(cboa!=null){
            res.setOrderNo(cboa.getCboa07());
        }

        res.setOrderType(cboc.getCboc24());
        //todo 待确认
//        res.setOther();
        res.setReceiveName(cboc.getCboc17());
        res.setReceivePhone(cboc.getCboc19());
        SysUser saleUser = sysUserMapper.selectByPrimaryKey(cboc.getCboc10().longValue());
        if (saleUser != null) {
            res.setSaleUser(saleUser.getNickName());
        }


        //货物明细
        CbodCriteria example = new CbodCriteria();
        List<Cbod> cbods = cbodMapper.selectByExample(example);

        Double sunPrice = 0.0;
        Double sumQty = 0.0;

        List<SaleOrderChangeDetailGoods> goods = res.getGoods();
        SaleOrderChangeDetailGoods good = null;
        CalaCriteria laexample = new CalaCriteria();
        laexample.createCriteria()
                .andCala10EqualTo("商品品牌");
        List<Cala> calas = calaMapper.selectByExample(laexample);
        Map<String, String> brandMap = new HashMap<>();
        for (Cala cala : calas) {
            brandMap.put(cala.getCala02(), cala.getCala08());
        }


        for (Cbod cbod : cbods) {
            good = new SaleOrderChangeDetailGoods();
            good.setId(cbod.getCbod01());
            Cbpb cbpb = cbpbMapper.selectByPrimaryKey(cbod.getCbod08());
            if (cbpb != null) {
                good.setBrand(brandMap.get(cbpb.getCbpb10()));
                good.setDescription(cbpb.getCbpb08());
                good.setModel(cbpb.getCbpb12());

            }
            good.setCurrentPrice(cbod.getCbod11());
            good.setNormPrice(cbod.getCbod14());
            good.setRemark(cbod.getCbod13());
            good.setQty(cbod.getCbod09());
            good.setTotalPrice(cbod.getCbod12());
            good.setBfPrice(cbod.getBefPrice());
            good.setBfQty(cbod.getBefQty());

            sunPrice = sunPrice + cbod.getCbod12();
            sumQty = sumQty + cbod.getCbod09();
            res.getGoods().add(good);
        }
        //金额数量合计

        res.setSumPrice(sunPrice);
        res.setSumQty(sumQty);
        res.setCapPrice(NumberToChineseUtil.moneyToChinese(res.getSumPrice()));

        //审批记录
        CabraaCriteria raaexample = new CabraaCriteria();
        raaexample.createCriteria()
                .andCabraa14EqualTo(cboc.getCboc07());
        List<Cabraa> cabraas = cabraaMapper.selectByExample(raaexample);

        SaleOrderAudit saleOrderAudit = null;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Cabraa cabraa : cabraas) {
            saleOrderAudit = new SaleOrderAudit();
            saleOrderAudit.setAuditResult(cabraa.getCabraa18());
            String createTime = sd.format(cabraa.getCabraa15());
            SysUser auditUser = sysUserMapper.selectByPrimaryKey(cabraa.getCabraa04().longValue());
            String audit = null;
            if (auditUser != null) {
                audit = auditUser.getNickName() == null ? "" : auditUser.getNickName();
            }

            saleOrderAudit.setDescription(createTime + " 由 " + audit + " 审核");
            saleOrderAudit.setId(cabraa.getCabraa01());
            saleOrderAudit.setRole(cabraa.getCabraa19());
            res.getAudits().add(saleOrderAudit);
        }

        return res;

    }

    @Transactional
    @Override
    public void mdfSaleOrderChange(SaleOrderChangeDto saleOrderChangeDto) {


        Cboc cboc = cbocMapper.selectByPrimaryKey(saleOrderChangeDto.getId());
        if(cboc==null || ! DeleteFlagEnum.NOT_DELETE.equals(cboc.getCboc06())){
            throw new SwException("没有查到该销售变更单");
        }

        if(!SaleOrderStatusEnums.WEITIJIAO.getCode().equals(cboc.getCboc11())){
            throw new SwException("只有在未提交的状态下才能修改");
        }

        Cboa cboa = cboaMapper.selectByPrimaryKey(cboc.getCboc26());


        //判断操作人员是否是销售人员
        if(!cboc.getCboc11().equals(saleOrderChangeDto.getUserId())){
            throw new SwException("必须为销售人员本人");
        }


        //创建销售订单主表

        Date date = new Date();

        cboc.setCboc04(date);
        cboc.setCboc05(saleOrderChangeDto.getUserId());

        int insert = cbocMapper.insert(cboc);
        Cbod cbod=null;
        //先删除旧的
        CbodCriteria example=new CbodCriteria();
        example.createCriteria()
                .andCboc01EqualTo(cboc.getCboc01());
        int i = cbodMapper.deleteByExample(example);

        for (SaleOrderChangeGoodsDto good : saleOrderChangeDto.getGoods()) {

            //查出原先旧数据传
            CbobCriteria obexample=new CbobCriteria();
            obexample.createCriteria()
                    .andCbob08EqualTo(good.getGoodsId())
                    .andCboa01EqualTo(cboc.getCboc26())
                    .andCbob06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbob> cbobs = cbobMapper.selectByExample(obexample);
            if(cbobs.size()==0){
                throw new SwException("没有在原销售订单查到该商品:"+good.getGoodsId());
            }
            //数量只能减少不能增加 不能小于发货数量
            Cbob cbob = cbobs.get(0);
            if(good.getQty()>cbob.getCbob09()){
                throw new SwException("数量只能减少不能增加");
            }

            if(good.getQty()<cbob.getCbob10()){
                throw new SwException("修改后的数量不能小于发货数量");
            }

            cbod = new Cbod();
            cbod.setCbod02(good.getNumber());
            cbod.setCbod03(date);
            cbod.setCbod04(saleOrderChangeDto.getUserId());
            cbod.setCbod05(date);
            cbod.setCbod06(saleOrderChangeDto.getUserId());
            cbod.setCbod07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbod.setCbod08(good.getGoodsId());
            cbod.setCbod09(good.getQty());
            cbod.setCbod10(cbob.getCbob10());
            cbod.setCbod11(good.getCurrentPrice());
            cbod.setCbod12(good.getCurrentPrice()*good.getQty());
            cbod.setCbod13(good.getRemark());
            cbod.setCbod01(insert);
            cbod.setCbod14(good.getNormalPrice());
            cbod.setBefPrice(cbob.getCbob11());
            cbod.setBefQty(cbob.getCbob09());
            cbodMapper.insert(cbod);
            //如果有占用 释放占用库存


        }
    }

    @Transactional
    @Override
    public void auditSaleChange(AuditSaleOrderDto auditSaleOrderDto) {
        Cboc cboc = cbocMapper.selectByPrimaryKey(auditSaleOrderDto.getOrderId());
        if(cboc==null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(cboc.getCboc06())){
            throw new SwException("没有查到该销售变更单");
        }
        Date date = new Date();
        cboc.setCboc04(date);
        cboc.setCboc05(auditSaleOrderDto.getUserId());

        if(auditSaleOrderDto.getOpeateType()==1){
            //提交
            if(!SaleOrderStatusEnums.WEITIJIAO.getCode().equals(cboc.getCboc11())){
                throw new SwException("只有在未提交状态下才能提交");
            }


            cboc.setCboc11(SaleOrderStatusEnums.YITIJIAO.getCode());
            cbocMapper.updateByPrimaryKey(cboc);
            //更新审批流程表
            GsWorkInstanceDo goodsWorkInstanceDo = new GsWorkInstanceDo();
            goodsWorkInstanceDo.setOrderType((byte) 2);
            goodsWorkInstanceDo.setOrderClose(OrdercloseEnum.WEIJIESHU.getCode());
            goodsWorkInstanceDo.setOrderStatus(OrderstatusEnum.DAISHENPI.getCode());
            taskService.editGsWorkInstance(goodsWorkInstanceDo);

        }else  if(auditSaleOrderDto.getOpeateType()==2){
            if(!SaleOrderStatusEnums.YITIJIAO.getCode().equals(cboc.getCboc11())){
                throw new SwException("只有在已提交状态下才能操作");
            }
            cboc.setCboc11(SaleOrderStatusEnums.WEITIJIAO.getCode());
            cbocMapper.updateByPrimaryKey(cboc);
        }else  if(auditSaleOrderDto.getOpeateType()==3){
            if(!SaleOrderStatusEnums.YITIJIAO.getCode().equals(cboc.getCboc11())){
                throw new SwException("只有在已提交状态下才能操作");
            }
            baseCheckService.checkUserTask(auditSaleOrderDto.getUserId().longValue(),new Byte("12"));

            cboc.setCboc11(SaleOrderStatusEnums.YISHENHE.getCode());
            cbocMapper.updateByPrimaryKey(cboc);
            Cboa cboa = cboaMapper.selectByPrimaryKey(cboc.getCboc26());
            if(cboa==null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(cboa.getCboa06())){
                throw new SwException("没有查到该订单号的销售订单");
            }
            CbodCriteria odex=new CbodCriteria();
            odex.createCriteria()
                    .andCboc01EqualTo(cboc.getCboc01());
            List<Cbod> cbods = cbodMapper.selectByExample(odex);
            for (Cbod cbod : cbods) {
                CbobCriteria obexample=new CbobCriteria();
                obexample.createCriteria()
                        .andCbob08EqualTo(cbod.getCbod08())
                        .andCboa01EqualTo(cboc.getCboc26())
                        .andCbob06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                List<Cbob> cbobs = cbobMapper.selectByExample(obexample);
                if(cbobs.size()==0){
                    throw new SwException("没有在原销售订单查到该商品:"+cbod.getCbod08());
                }
                //数量只能减少不能增加 不能小于发货数量
                Cbob cbob = cbobs.get(0);

                Double noneedNum=cbob.getCbob09()-cbod.getCbod09();
                if(noneedNum!=0.0){
                    GsGoodsUseCriteria usex=new GsGoodsUseCriteria();
                    usex.createCriteria()
                            .andGoodsIdEqualTo(cbod.getCbod08())
                            .andOrderNoEqualTo(cboa.getCboa17());
                    List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(usex);
                    for (GsGoodsUse gsGoodsUs : gsGoodsUses) {
                        gsGoodsUs.setLockQty(gsGoodsUs.getLockQty()-noneedNum);
                        gsGoodsUs.setOrderQty(cbod.getCbod09());
                        gsGoodsUs.setUpdateTime(date);
                        if(gsGoodsUs.getLockQty()==0.0){
                            gsGoodsUseMapper.deleteByPrimaryKey(gsGoodsUs.getId());
                        }else {
                            gsGoodsUseMapper.updateByPrimaryKey(gsGoodsUs);
                        }
                    }
                }
                //更改cbob的数量

                cbob.setCbob05(date);
                cbob.setCbob06(auditSaleOrderDto.getUserId());
                cbob.setCbob09(cbod.getCbod09());
                cbob.setCbob11(cbod.getCbod11());
                cbob.setCbob12(cbob.getCbob12());
                cbobMapper.updateByPrimaryKey(cbob);






            }



        }

    }

    @Transactional
    @Override
    public void delSaleChange(DelSaleChangeDto delSaleChangeDto) {

        Cboc cboc = cbocMapper.selectByPrimaryKey(delSaleChangeDto.getId());
        if(cboc==null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(cboc.getCboc06())){
            throw new SwException("没有查到该销售变更单");
        }
        if(!SaleOrderStatusEnums.WEITIJIAO.getCode().equals(cboc.getCboc11())){
            throw new SwException("只有在未提交状态下才能删除");
        }

        Cbod cbod=new Cbod();
        cbod.setCbod06(DeleteFlagEnum.DELETE.getCode());

        CbodCriteria example=new CbodCriteria();
        example.createCriteria()
                .andCboc01EqualTo(cboc.getCboc01());
        int i = cbodMapper.updateByExampleSelective(cbod,example);

    }

    @Override
    public void printSaleOrder(Integer sqleOrderId) {

    }

//    @Override
//    public GsWorkInstance createTask() {
//
//        //创建审批任务
//
//
//
//    }


}
