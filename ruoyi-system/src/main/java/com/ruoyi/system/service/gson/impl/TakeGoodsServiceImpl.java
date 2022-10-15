package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.constant.TakeOrderConstants;
import com.ruoyi.common.constant.WareHouseType;
import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.NumberToChineseUtil;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbpmTakeOrderDo;
import com.ruoyi.system.domain.Do.NumberDo;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TakeGoodsService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName TakeGoodsServiceImpl
 * Description
 * Create by gfy
 * Date 2022/8/10 17:51
 */
@Service
public class TakeGoodsServiceImpl implements TakeGoodsService {

    @Resource
    private CbpkMapper cbpkMapper;

    @Resource
    private CboaMapper cboaMapper;

    @Resource
    private CbplMapper cbplMapper;

    @Resource
    private GsGoodsUseMapper gsGoodsUseMapper;

    @Resource
    private NumberGenerate numberGenerate;

    @Resource
    private CalaMapper calaMapper;

    @Resource
    private CbcaMapper cbcaMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private CbwaMapper cbwaMapper;

    @Resource
    private CbpbMapper cbpbMapper;

    @Resource
    private CbobMapper cbobMapper;

    @Resource
    private CbpmMapper cbpmMapper;

    @Resource
    private CbpaMapper cbpaMapper;

    @Resource
    private CblaMapper cblaMapper;

    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private GsOutStockAdivceMapper gsOutStockAdivceMapper;

    @Resource
    private BaseCheckService baseCheckService;






    @Override
    public List<TakeGoodsOrderListVo> takeOrderList(TakeGoodsOrderListDto takeGoodsOrderListDto) {

         List<TakeGoodsOrderListVo> res=  cbpkMapper.takeOrderList(takeGoodsOrderListDto);
        return res;
    }

    @Transactional
    @Override
    public void addTakeGoodsOrder(TakeGoodsOrderAddDto takeGoodsOrderAddDto) {

        //查出销售订单 检查销售订单是否已复审通过
        CboaCriteria oaex=new CboaCriteria();
        oaex.createCriteria()
                .andCboa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCboa07EqualTo(takeGoodsOrderAddDto.getSaleOrderNo());
        List<Cboa> cboas = cboaMapper.selectByExample(oaex);
        if(cboas.size()==0){
            throw new SwException("没有查到该销售订单订单");
        }
        Cboa cboa = cboas.get(0);
        if(!SaleOrderStatusEnums.YIFUSHEN.getCode().equals(cboa.getCboa11())){
            throw new SwException("销售订单必须为已复审状态");
        }

        //只有该销售订单在此仓库最新一提货单质检完成之后才能再生成
       Cbpk old= cbpkMapper.selectLastBySaleOrderNo(takeGoodsOrderAddDto.getSaleOrderNo());
        if(old!=null && TakeOrderCheckStatus.NOCHECK.getCode().equals(old.getCheckStatus())){
            throw new SwException("该销售订单的最新提货单需要质检完成之后才能提交新的提货单");
        }

        Cbpk cbpk=new Cbpk();
        Date date = new Date();
        cbpk.setCbpk02(date);
        cbpk.setCbpk03(takeGoodsOrderAddDto.getUserId());
        cbpk.setCbpk04(date);
        cbpk.setCbpk05(takeGoodsOrderAddDto.getUserId());
        cbpk.setCbpk06(DeleteFlagEnum.NOT_DELETE.getCode());
        NumberDo numberDo = new NumberDo();
        numberDo.setType(NumberGenerateEnum.TAKEORDER.getCode());
        cbpk.setCbpk07(numberGenerate.createOrderNo(numberDo).getOrderNo());
        cbpk.setCbpk08(takeGoodsOrderAddDto.getOrderDate());
        cbpk.setCbpk09(takeGoodsOrderAddDto.getCustomerId());
        cbpk.setCbpk10(takeGoodsOrderAddDto.getWhId());
        cbpk.setCbpk11(SaleOrderStatusEnums.YITIJIAO.getCode());
//        cbpk.setCbpk12();
//        cbpk.setCbpk13();
//        cbpk.setCbpk14();/
//        cbpk.setCbpk15();
        cbpk.setCbpk16(takeGoodsOrderAddDto.getCurrency());
        cbpk.setCbpk17(takeGoodsOrderAddDto.getSaleUserId());
        cbpk.setCbpk18(takeGoodsOrderAddDto.getContacts());
        cbpk.setCbpk19(takeGoodsOrderAddDto.getPhone());
//        cbpk.setCbpk20();
        cbpk.setCbpk21(takeGoodsOrderAddDto.getReceiveAdress());
//        cbpk.setCbpk22();
//        cbpk.setCbpk23();
//        cbpk.setCbpk24();
//        cbpk.setCbpk25();
//        cbpk.setCbpk26();
//        cbpk.setCbpk27();
//        cbpk.setCbpk28();
//        cbpk.setCbpk29();
        cbpk.setCbpk30(takeGoodsOrderAddDto.getCustomerNo());

        cbpk.setCbpk31(TakeOrderConstants.WEIWANCHENG);
        cbpk.setCheckStatus(TakeOrderCheckStatus.NOCHECK.getCode().byteValue());
        cbpk.setSaleOrderNo(takeGoodsOrderAddDto.getSaleOrderNo());
        int insert = cbpkMapper.insertWithId(cbpk);
        Cbpl cbpl=null;
        for (TakeOrderGoodsDto good : takeGoodsOrderAddDto.getGoods()) {


            if(good.getGoodsId()==null){
                throw new SwException("提货货物不能为空");
            }

            //判断是否全部提货完
            CbobCriteria cbobex=new CbobCriteria();
            cbobex.createCriteria()
                    .andCboa01EqualTo(cboa.getCboa01())
                    .andCbob08EqualTo(good.getGoodsId());
            List<Cbob> cbobs = cbobMapper.selectByExample(cbobex);
            for (Cbob cbob : cbobs) {
                if(cbob.getTakeQty()!=null && (cbob.getTakeQty()+good.getQty())>=cbob.getCbob09()){
                    throw new SwException("提货数量不能超过订单数量");
                }
            }

            //检查是否已占用了库存 并且提货数量不能大于占用数量 以及历史提货数量减去良品数量
            GsGoodsUseCriteria guex=new GsGoodsUseCriteria();
            guex.createCriteria()
                    .andGoodsIdEqualTo(good.getGoodsId())
                    .andOrderNoEqualTo(takeGoodsOrderAddDto.getSaleOrderNo())
                    .andWhIdEqualTo(takeGoodsOrderAddDto.getWhId());
            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(guex);
            if(gsGoodsUses.size()==0){
                throw new SwException("该商品没有在本仓库占用库存，商品:");
            }

            GsGoodsUse goodsUse = gsGoodsUses.get(0);
            if(good.getQty()>goodsUse.getLockQty()){
                throw new SwException("该商品的提货数量不能大于占用数量");

            }
            //未出库数量
            Double noOutQty = goodsUse.getNoOutQty();
            Double lockQty = goodsUse.getLockQty();
            if(good.getQty()+noOutQty>lockQty){
                throw new SwException("该商品未出库的提货单数量相加超过占用数量");

            }

            //生成明细表
            cbpl=new Cbpl();
            cbpl.setCbpk01(cbpk.getCbpk01());
            cbpl.setCbpl02(good.getNumber());
            cbpl.setCbpl03(date);
            cbpl.setCbpl04(takeGoodsOrderAddDto.getUserId());
            cbpl.setCbpl05(date);
            cbpl.setCbpl06(takeGoodsOrderAddDto.getUserId());
            cbpl.setCbpl07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbpl.setCbpl08(good.getGoodsId());
            cbpl.setCbpl09(good.getQty());
            cbpl.setCbpl10(0.0);
            cbpl.setCbpl11(good.getPrice());
            cbpl.setCbpl12(good.getTotalPrice());
            cbpl.setGoodProductQty(good.getQty());
//            cbpl.setCbpl13();
//            cbpl.setCbpl14();
//            cbpl.setCbpl15();
//            cbpl.setCbpl16();
            cbpl.setGoodProductQty(0.0);
            cbplMapper.insert(cbpl);

//            List<Cbpl> list=cbplMapper.selectBySaleOrderNo(takeGoodsOrderAddDto.getSaleOrderNo());


            //提货数量
//            Double takeQty = list.stream().collect(Collectors.summingDouble(Cbpl::getCbpl09));
            //良品数量
//            Double goodQty = list.stream().collect(Collectors.summingDouble(Cbpl::getGoodProductQty));

//            Double lessQty=takeQty-goodQty;


        }

    }

    @Override
    public TakeGoodsOrderDetailVo takeOrderDetail(Integer id) {
        Cbpk cbpk = cbpkMapper.selectByPrimaryKey(id);
        if(cbpk==null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(cbpk.getCbpk06())){
            throw new SwException("没有查到该提货单");
        }

        TakeGoodsOrderDetailVo res=new TakeGoodsOrderDetailVo();
        res.setContacts(cbpk.getCbpk18());
        res.setCurrency(cbpk.getCbpk16());
        res.setOrderNo(cbpk.getCbpk07());
        if(CurrencyEnum.CNY.getCode().equals(cbpk.getCbpk16())){
            res.setCurrencyMsg(CurrencyEnum.CNY.getMsg());
        }else {
            res.setCurrencyMsg(CurrencyEnum.USD.getMsg());
        }
        res.setCustomerId(cbpk.getCbpk09());
        Cbca cbca = cbcaMapper.selectByPrimaryKey(cbpk.getCbpk09());
        if(cbca!=null){
            res.setCustomerName(cbca.getCbca08());
            res.setCustomerLevel(cbca.getCbca28());
        }

        res.setCustomerNo(cbpk.getCbpk30());
        res.setOrderDate(cbpk.getCbpk08());
        res.setPhone(cbpk.getCbpk19());
        res.setReceiveAdress(cbpk.getCbpk21());
        res.setReceiver(cbpk.getCbpk18());
        res.setReceivPhone(cbpk.getCbpk19());
        Cboa cboa=null;
        if(!StringUtils.isBlank(cbpk.getSaleOrderNo())){
            CboaCriteria oaex=new CboaCriteria();
            oaex.createCriteria()
                    .andCboa07EqualTo(cbpk.getSaleOrderNo());
            List<Cboa> cboas = cboaMapper.selectByExample(oaex);
            cboa= cboas.get(0);
            res.setSaleOrderId(cboas.get(0).getCboa01());

        }
        res.setSaleOrderNo(cbpk.getSaleOrderNo());
        SysUser user = sysUserMapper.selectByPrimaryKey(cbpk.getCbpk03().longValue());
        if(user!=null){
            res.setUserId(user.getUserId().intValue());
            res.setUserName(user.getNickName());
        }
        if(cbpk.getCbpk12()!=null){
            SysUser auditUser = sysUserMapper.selectByPrimaryKey(cbpk.getCbpk12().longValue());
            if(auditUser!=null){

                res.setAuditUserName(auditUser.getNickName());
            }
        }


        if(cbpk.getCbpk17()!=null){
            SysUser saleUser = sysUserMapper.selectByPrimaryKey(cbpk.getCbpk17().longValue());
            if(saleUser!=null){
                res.setSaleUserId(saleUser.getUserId().intValue());
                res.setSaleUserName(saleUser.getNickName());

            }
        }


        Cbwa cbwa = cbwaMapper.selectByPrimaryKey(cbpk.getCbpk10());
        if(cbwa!=null){
            res.setWhName(cbwa.getCbwa09());
            res.setWhId(cbwa.getCbwa01());

        }
        if(cbpk.getCheckStatus()!=null){
            if(TakeOrderCheckStatus.NOCHECK.getCode().equals(cbpk.getCheckStatus())){
                res.setCheckStatus(TakeOrderCheckStatus.NOCHECK.getMsg());
            }else {
                res.setCheckStatus(TakeOrderCheckStatus.CHECK.getMsg());
            }


        }
        CbplCriteria plex=new CbplCriteria();
        plex.createCriteria()
                .andCbpk01EqualTo(cbpk.getCbpk01())
                .andCbpl07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        plex.setOrderByClause("CBPL02 desc");
        List<Cbpl> cbpls = cbplMapper.selectByExample(plex);
        List<TakeOrderGoodsVo> goods = res.getGoods();


        //zhaoGuoLiang添加销售订单明细表id
        CboaCriteria cboaCriteria = new CboaCriteria();
        cboaCriteria.createCriteria().andCboa07EqualTo(cbpk.getSaleOrderNo())
                .andCboa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        List<Cboa> cboaList = cboaMapper.selectByExample(cboaCriteria);
        List<Cbob> cbobList = null;
        if(cboaList!=null&&cboaList.size()>0){
            CbobCriteria cbobCriteria = new CbobCriteria();
            cbobCriteria.createCriteria().andCboa01EqualTo(cboaList.get(0).getCboa01())
                    .andCbob07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            cbobCriteria.setOrderByClause("CBOB03 desc");
            cbobList = cbobMapper.selectByExample(cbobCriteria);
        }

//        CalaCriteria laexample = new CalaCriteria();
//        laexample.createCriteria()
//                .andCala10EqualTo("商品品牌");
//        List<Cala> calas = calaMapper.selectByExample(laexample);
//        Map<Integer, String> brandMap = new HashMap<>();
//        for (Cala cala : calas) {
//            brandMap.put(cala.getCala01(), cala.getCala08());
//        }
        Map<Integer, String> brandMap = baseCheckService.brandMap();

        TakeOrderGoodsVo good=null;
        Double sumQty=0.0;
        Double sunPrice=0.0;

        Map<Integer,TakeOrderGoodsVo> goodsMap=new HashMap<>();
        int i = 0;
        for (Cbpl cbpl : cbpls) {
            good=new TakeOrderGoodsVo();
//            CbpmCriteria pmex=new CbpmCriteria();
//            pmex.createCriteria()
//                    .andCbpk01EqualTo(cbpk.getCbpk01())
//                    .andCb
//            List<Cbpm> cbpms = cbpmMapper.selectByExample(pmex);

//            CbpmCriteria pmex=new CbpmCriteria();
//                 pmex.createCriteria()
//                .andCbpm07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
//                .andCbpm08EqualTo(good.getGoodsId())
//                .andCbpk01EqualTo(cbpk.getCbpk01());
//                List<Cbpm> cbpms = cbpmMapper.selectByExample(pmex);
//                good.setGoodsNum(Double.valueOf(cbpms.size()));


            //zhaoGuoLiang添加销售订单明细表id
            if(cbobList!=null&&cbobList.size()>i){
                good.setCbob01(cbobList.get(i).getCbob01());
            }
            good.setCbplId(cbpl.getCbpl01());
            Cbpb cbpb = cbpbMapper.selectByPrimaryKey(cbpl.getCbpl08());
            if (cbpb != null) {

//                good.setGoodsNum();
                good.setUpc(cbpb.getCbpb15());
                good.setBrand(brandMap.get(cbpb.getCbpb10()));
                good.setDescription(cbpb.getCbpb08());
                good.setModel(cbpb.getCbpb12());
                Cbpa cbpa = cbpaMapper.selectByPrimaryKey(cbpb.getCbpb14());
                if(cbpa!=null){
                    good.setGoodClass(cbpa.getCbpa07());
                }

            }



            good.setGoodsId(cbpl.getCbpl08());
            if(OrderTypeEnum.GUOJIDINGDAN.getCode().equals(cbpl.getCbpl16())){
                good.setOrderClass(OrderTypeEnum.GUOJIDINGDAN.getMsg());
            }else {
                good.setOrderClass(OrderTypeEnum.GUONEIDINGDAN.getMsg());
            }
            if(cboa!=null){
                GsGoodsUseCriteria usexample=new GsGoodsUseCriteria();
                usexample.createCriteria()
                        .andOrderNoEqualTo(cboa.getCboa07())
                        .andGoodsIdEqualTo(good.getGoodsId());
                List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(usexample);

                if(gsGoodsUses.size()>0){
                    GsGoodsUse goodsUse = gsGoodsUses.get(0);
                    good.setUseQty(goodsUse.getLockQty());



                }

                CbobCriteria obex=new CbobCriteria();
                obex.createCriteria()
                        .andCbob07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                        .andCbob08EqualTo(good.getGoodsId())
                        .andCboa01EqualTo(cboa.getCboa01());
                List<Cbob> cbobs = cbobMapper.selectByExample(obex);
                if(cbobs.size()>0){
                    Cbob cbob=cbobs.get(0);
                    good.setNoSendQty(cbob.getCbob09()-cbob.getCbob10());
                    good.setOrderQty(cbob.getCbob09());
                }


            }

            //良品数量

                good.setGoodsNum(cbpl.getGoodProductQty());



            good.setPrice(cbpl.getCbpl11());

            CbpmCriteria pmex=new CbpmCriteria();
            pmex.createCriteria()
                    .andCbpm08EqualTo(good.getGoodsId())
                    .andCbpm11EqualTo(1)
                    .andCbpk01EqualTo(cbpk.getCbpk01());
            List<Cbpm> cbpms = cbpmMapper.selectByExample(pmex);
            good.setScanQty(cbpms.size());
            good.setGoodsNum(Double.valueOf(cbpms.size()));
            //todo
//            good.setRemark();
            good.setQty(cbpl.getCbpl09());
            good.setGoodsNum(cbpl.getGoodProductQty());
            //TODO
//            good.setSupplierId();
            good.setTotalPrice(cbpl.getCbpl12());

            sumQty=sumQty+cbpl.getCbpl09();
            sunPrice=sunPrice+cbpl.getCbpl11();


            res.getGoods().add(good);

            goodsMap.put(good.getGoodsId(),good);
            i++;

        }
        res.setSumPrice(sunPrice);
        res.setSumQty(sumQty);
        res.setCapPrice(NumberToChineseUtil.moneyToChinese(res.getSumPrice()));

        res.setSumQty(sumQty);
//        CbpmCriteria pmex=new CbpmCriteria();
//        pmex.createCriteria()
//                .andCbpm07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
//                .andCbpm08EqualTo(good.getGoodsId())
//                .andCbpk01EqualTo(cbpk.getCbpk01());
//        pmex.setOrderByClause("CBPM11 ASC");
        List<CbpmTakeOrderDo> cbpms = cbpmMapper.selectByTakeId(cbpk.getCbpk01());
        //查提货建议表
        TakeOrderSugestVo sugest=null;
        Map<Integer,Integer> scanMap=new HashMap<>();
        for (int x=1;x<=cbpms.size();x++) {
            CbpmTakeOrderDo cbpm = cbpms.get(x);
            sugest=new TakeOrderSugestVo();
            TakeOrderGoodsVo takeOrderGoodsVo = goodsMap.get(cbpm.getCbpm08());
            if(takeOrderGoodsVo!=null){
                sugest.setBrand(takeOrderGoodsVo.getBrand());
                sugest.setDescription(takeOrderGoodsVo.getDescription());
                sugest.setModel(takeOrderGoodsVo.getModel());
                sugest.setGoodClass(takeOrderGoodsVo.getGoodClass());
                sugest.setUpc(takeOrderGoodsVo.getUpc());

//                sugest.setCbpm01(takeOrderGoodsVo.getCbplId());

            }
            sugest.setGoodsId(cbpm.getCbpm08());
            sugest.setNumber(x);
            sugest.setCbpm01(cbpm.getCbpm01());
            sugest.setScanStatus(ScanStatusEnum.findByKey(cbpm.getCbpm11()).getMsg());
            sugest.setBfSn(cbpm.getCbpm12());
            if(cbpm.getCbpm10()!=null){
                Cbla cbla = cblaMapper.selectByPrimaryKey(cbpm.getCbpm10());
                if(cbla!=null){
                    sugest.setCbla09(cbla.getCbla09());
                }
            }

            sugest.setSku(cbpm.getSku());
            sugest.setSn(cbpm.getCbpm09());
            res.getSugests().add(sugest);
            if(ScanStatusEnum.YISAOMA.getCode().equals(cbpm.getCbpm11())){
                res.getScans().add(sugest);
                Integer integer = scanMap.get(takeOrderGoodsVo.getGoodsId());
                if(integer==null){
                    scanMap.put(takeOrderGoodsVo.getGoodsId(),1);
                }else {
                    scanMap.put(takeOrderGoodsVo.getGoodsId(),integer+1);
                }
            }
            for (TakeOrderGoodsVo resGood : res.getGoods()) {
                if(scanMap.get(resGood.getGoodsId())==null){
                    resGood.setScanQty(0);
                }else {
                    resGood.setScanQty(scanMap.get(resGood.getGoodsId()));
                }


            }


        }
        List<TakeOrderGoodsVo> goods1 = res.getGoods();
        for (TakeOrderGoodsVo takeOrderGoodsVo : goods1) {
            if(scanMap.get(takeOrderGoodsVo.getGoodsId())!=null){
                takeOrderGoodsVo.setGoodsNum(scanMap.get(takeOrderGoodsVo.getGoodsId()).doubleValue());

            }
        }




        if(res.getOrderDate()!=null){
            SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
            String format = sd.format(res.getOrderDate());
            res.setOrderDateMsg(format);
        }
        return res;
    }

    @Override
    public TakeGoodsOrderDetailVo takeOrderDetailBySaleId(Integer saleOrderId,Integer whId) {
        Cboa cboa = cboaMapper.selectByPrimaryKey(saleOrderId);
        TakeGoodsOrderDetailVo res=new TakeGoodsOrderDetailVo();
        res.setContacts(cboa.getCboa17());
        res.setCurrency(cboa.getCboa16());
        if(CurrencyEnum.CNY.getCode().equals(cboa.getCboa16())){
            res.setCurrencyMsg(CurrencyEnum.CNY.getMsg());
        }else {
            res.setCurrencyMsg(CurrencyEnum.USD.getMsg());
        }
        res.setCustomerId(cboa.getCboa09());
        Cbca cbca = cbcaMapper.selectByPrimaryKey(res.getCustomerId());
        if(cbca!=null){
            res.setCustomerName(cbca.getCbca08());
            res.setCustomerLevel(cbca.getCbca28());
        }

        res.setCustomerNo(cboa.getCboa25());
        res.setOrderDate(cboa.getCboa08());
        res.setPhone(cboa.getCboa19());
        res.setReceiveAdress(cboa.getCboa18());

        res.setReceiver(cboa.getCboa17());
        res.setReceivPhone(cboa.getCboa19());
        res.setSaleOrderId(cboa.getCboa01());

        res.setSaleOrderNo(cboa.getCboa07());
//        SysUser user = sysUserMapper.selectByPrimaryKey(cbpk.getCbpk03().longValue());
//        if(user!=null){
//            res.setUserId(user.getUserId().intValue());
//            res.setUserName(user.getNickName());
//        }

        SysUser saleUser = sysUserMapper.selectByPrimaryKey(cboa.getCboa10().longValue());
        if(saleUser!=null){
            res.setSaleUserId(saleUser.getUserId().intValue());
            res.setSaleUserName(saleUser.getNickName());

        }

        Cbwa cbwa = cbwaMapper.selectByPrimaryKey(whId);
        if(cbwa!=null){
            res.setWhName(cbwa.getCbwa09());
            res.setWhId(cbwa.getCbwa01());

        }
//        if(cbpk.getCheckStatus()!=null){
//            if(TakeOrderCheckStatus.NOCHECK.getCode().equals(cbpk.getCheckStatus())){
//                res.setCheckStatus(TakeOrderCheckStatus.NOCHECK.getMsg());
//            }else {
//                res.setCheckStatus(TakeOrderCheckStatus.CHECK.getMsg());
//            }
//
//
//        }

        CalaCriteria laexample = new CalaCriteria();
        laexample.createCriteria()
                .andCala10EqualTo("商品品牌");
        List<Cala> calas = calaMapper.selectByExample(laexample);
        Map<Integer, String> brandMap = new HashMap<>();
        for (Cala cala : calas) {
            brandMap.put(cala.getCala01(), cala.getCala08());
        }
//        CbobCriteria obex=new CbobCriteria();
//        obex.createCriteria()
//                .andCbob07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
//                .andCboa01EqualTo(cboa.getCboa01());
//        List<Cbob> cbobs = cbobMapper.selectByExample(obex);
        TakeOrderGoodsVo good=null;
        //查占用表
        GsGoodsUseCriteria usex=new GsGoodsUseCriteria();
        usex.createCriteria().andOrderNoEqualTo(cboa.getCboa07())
                .andWhIdEqualTo(whId);
        List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(usex);
        for (GsGoodsUse goodsUse : gsGoodsUses) {
            good=new TakeOrderGoodsVo();
            Cbpb cbpb = cbpbMapper.selectByPrimaryKey(goodsUse.getGoodsId());
            if (cbpb != null) {
                good.setGoodsId(cbpb.getCbpb01());
                good.setBrand(brandMap.get(cbpb.getCbpb10()));
                good.setDescription(cbpb.getCbpb08());
                good.setModel(cbpb.getCbpb12());
                Cbpa cbpa = cbpaMapper.selectByPrimaryKey(cbpb.getCbpb14());
                if(cbpa!=null){
                    good.setGoodClass(cbpa.getCbpa07());
                }
            }
                CbobCriteria obex=new CbobCriteria();
                obex.createCriteria()
                        .andCbob08EqualTo(goodsUse.getGoodsId())
                        .andCbob07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                        .andCboa01EqualTo(cboa.getCboa01());
                List<Cbob> cbobs = cbobMapper.selectByExample(obex);
                if(cbobs.size()>0){
                    Cbob cbob=cbobs.get(0);
                    good.setNoSendQty(cbob.getCbob09()-cbob.getCbob10());
                    good.setPrice(cbob.getCbob11());
                    //todo
//            good.setRemark();
                    good.setQty(goodsUse.getLockQty());
                    good.setTotalPrice(cbob.getCbob12());
                    //TODO
//            good.setSupplierId();

                }

                good.setUseQty(goodsUse.getLockQty());


                //良品数量
                good.setGoodsNum(0.0);

                res.getGoods().add(good);

            }
        return res;

    }

    @Transactional
    @Override
    public void mdfTakeGoodsOrder(TakeGoodsOrderAddDto takeGoodsOrderAddDto) {

        //只有在未提交状态下才能编辑
        Cbpk cbpk = cbpkMapper.selectByPrimaryKey(takeGoodsOrderAddDto.getId());
        if(!SaleOrderStatusEnums.WEITIJIAO.getCode().equals(cbpk.getCbpk11())){
            throw new SwException("提货单必须为未提交状态才能修改");
        }

        Date date = new Date();


        cbpk.setCbpk04(date);
        cbpk.setCbpk05(takeGoodsOrderAddDto.getUserId());
        cbpk.setCbpk08(takeGoodsOrderAddDto.getOrderDate());
        cbpk.setCbpk09(takeGoodsOrderAddDto.getCustomerId());
        cbpk.setCbpk10(takeGoodsOrderAddDto.getWhId());

//        cbpk.setCbpk12();
//        cbpk.setCbpk13();
//        cbpk.setCbpk14();/
//        cbpk.setCbpk15();
        cbpk.setCbpk16(takeGoodsOrderAddDto.getCurrency());
        cbpk.setCbpk17(takeGoodsOrderAddDto.getSaleUserId());
        cbpk.setCbpk18(takeGoodsOrderAddDto.getContacts());
        cbpk.setCbpk19(takeGoodsOrderAddDto.getPhone());
//        cbpk.setCbpk20();
        cbpk.setCbpk21(takeGoodsOrderAddDto.getReceiveAdress());
//        cbpk.setCbpk22();
//        cbpk.setCbpk23();
//        cbpk.setCbpk24();
//        cbpk.setCbpk25();
//        cbpk.setCbpk26();
//        cbpk.setCbpk27();
//        cbpk.setCbpk28();
//        cbpk.setCbpk29();
        cbpk.setCbpk30(takeGoodsOrderAddDto.getCustomerNo());
        cbpk.setCbpk31(TakeOrderConstants.WEIWANCHENG);
        cbpk.setCheckStatus(TakeOrderCheckStatus.NOCHECK.getCode().byteValue());
        cbpk.setSaleOrderNo(takeGoodsOrderAddDto.getSaleOrderNo());
        cbpk.setCbpk11(SaleOrderStatusEnums.YITIJIAO.getCode());
        int update = cbpkMapper.updateByPrimaryKey(cbpk);
        Cbpl cbpl=null;

        //删除cbpl

        CbplCriteria plex=new CbplCriteria();
        plex.createCriteria()
                .andCbpk01EqualTo(cbpk.getCbpk01());
        int i = cbplMapper.deleteByExample(plex);


        for (TakeOrderGoodsDto good : takeGoodsOrderAddDto.getGoods()) {
            if(good.getGoodsId()==null){
                throw new SwException("提货货物不能为空");
            }
            //检查是否已占用了库存 并且提货数量不能大于占用数量 以及历史提货数量减去良品数量
            GsGoodsUseCriteria guex=new GsGoodsUseCriteria();
            guex.createCriteria()
                    .andGoodsIdEqualTo(good.getGoodsId())
                    .andOrderNoEqualTo(takeGoodsOrderAddDto.getSaleOrderNo())
                    .andWhIdEqualTo(takeGoodsOrderAddDto.getWhId());
            List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(guex);
            if(gsGoodsUses.size()==0){
                throw new SwException("该商品没有在本仓库占用库存，商品:"+good.getGoodsMsg());
            }

            GsGoodsUse goodsUse = gsGoodsUses.get(0);
            if(good.getQty()>goodsUse.getLockQty()){
                throw new SwException("该商品的提货数量不能大于占用数量"+good.getGoodsMsg());

            }
            //未出库数量
            Double noOutQty = goodsUse.getNoOutQty();
            Double lockQty = goodsUse.getLockQty();
            if(good.getQty()+noOutQty>lockQty){
                throw new SwException("该商品未出库的提货单数量相加超过占用数量"+good.getGoodsMsg());

            }

            //生成明细表
            cbpl=new Cbpl();
            cbpl.setCbpk01(cbpk.getCbpk01());
            cbpl.setCbpl02(good.getNumber());
            cbpl.setCbpl03(date);
            cbpl.setCbpl04(takeGoodsOrderAddDto.getUserId());
            cbpl.setCbpl05(date);
            cbpl.setCbpl06(takeGoodsOrderAddDto.getUserId());
            cbpl.setCbpl07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbpl.setCbpl08(good.getGoodsId());
            cbpl.setCbpl09(good.getQty());
            cbpl.setCbpl10(0.0);
            cbpl.setCbpl11(good.getPrice());
            cbpl.setCbpl12(good.getTotalPrice());
//            cbpl.setCbpl13();
//            cbpl.setCbpl14();
//            cbpl.setCbpl15();
//            cbpl.setCbpl16();
            cbpl.setGoodProductQty(0.0);
            cbplMapper.insert(cbpl);



//            List<Cbpl> list=cbplMapper.selectBySaleOrderNo(takeGoodsOrderAddDto.getSaleOrderNo());


            //提货数量
//            Double takeQty = list.stream().collect(Collectors.summingDouble(Cbpl::getCbpl09));
            //良品数量
//            Double goodQty = list.stream().collect(Collectors.summingDouble(Cbpl::getGoodProductQty));

//            Double lessQty=takeQty-goodQty;


        }

    }

    @Transactional
    @Override
    public void delTakeGoodsOrder(Integer id, Long userId) {
        Cbpk cbpk = cbpkMapper.selectByPrimaryKey(id);
        if(cbpk==null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(cbpk.getCbpk06())){
            throw new SwException("没有查到该提货单");
        }
        if(!SaleOrderStatusEnums.WEITIJIAO.getCode().equals(cbpk.getCbpk11())){
            throw new SwException("必须在未提交状态下才能删除");
        }

        cbpk.setCbpk06(DeleteFlagEnum.DELETE.getCode());
        cbpk.setCbpk05(userId.intValue());
        cbpk.setCbpk04(new Date());
        cbpkMapper.updateByPrimaryKey(cbpk);


    }

    @Transactional
    @Override
    public void auditTakeOrder(AuditTakeOrderDto auditTakeOrderDto) {

        Cbpk cbpk = cbpkMapper.selectByPrimaryKey(auditTakeOrderDto.getTakeOrderId());
        //审核通过 生成提货建议表 并让出库建议的货品变成出库中
        if(cbpk==null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(cbpk.getCbpk06())){
            throw new SwException("没有查到该提货单");
        }

        Date date = new Date();
        if(auditTakeOrderDto.getOpType().equals(1)){
            if(!SaleOrderStatusEnums.YITIJIAO.getCode().equals(cbpk.getCbpk11())){
                throw new SwException("必须在已提交状态下才能审核");
            }
            cbpk.setCbpk11(SaleOrderStatusEnums.YISHENHE.getCode());
            cbpk.setCbpk12(auditTakeOrderDto.getUserId());

            //生成提货建议单

            CbplCriteria plex=new CbplCriteria();
            plex.createCriteria()
                    .andCbpl07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                    .andCbpk01EqualTo(cbpk.getCbpk01());
            List<Cbpl> cbpls = cbplMapper.selectByExample(plex);

            Cbpm cbpm=null;
            for (Cbpl cbpl : cbpls) {
                //先入先出 并且未占用

                //查找本仓库的占用数量
                GsGoodsUseCriteria usex=new GsGoodsUseCriteria();
                usex.createCriteria()
                        .andGoodsIdEqualTo(cbpl.getCbpl08())
                        .andWhIdEqualTo(cbpk.getCbpk10())
                        .andOrderNoEqualTo(cbpk.getSaleOrderNo())
                        ;

                List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(usex);

                if(gsGoodsUses.size()>0){
                    List<GsGoodsSn> list=gsGoodsSnMapper.selectOutByWhIdAndGoodsId(cbpk.getCbpk10(),cbpl.getCbpl08(),cbpl.getCbpl09().intValue());

                    for (int i=0;i< list.size() ;i++) {
                        GsGoodsSn gsGoodsSn = list.get(i);

                        cbpm=new Cbpm();
                        cbpm.setCbpk01(cbpk.getCbpk01());
                        cbpm.setCbpm02(i+1);
                        cbpm.setCbpm03(date);
                        cbpm.setCbpm04(auditTakeOrderDto.getUserId());
                        cbpm.setCbpm05(date);
                        cbpm.setCbpm06(auditTakeOrderDto.getUserId());
                        cbpm.setCbpm07(DeleteFlagEnum.NOT_DELETE.getCode());
                        cbpm.setCbpm08(cbpl.getCbpl08());
                        cbpm.setCbpm09(gsGoodsSn.getSn());
                        cbpm.setCbpm10(gsGoodsSn.getLocationId());
                        cbpm.setCbpm11(0);

                        cbpmMapper.insert(cbpm);
                        gsGoodsSn.setStatus(new Byte("2"));
                        gsGoodsSn.setUpdateTime(date);

                        gsGoodsSnMapper.updateByPrimaryKeySelective(gsGoodsSn);


                    }


                }


            }


        }else if(auditTakeOrderDto.getOpType().equals(2)) {
            //撤销 提交状态变成未提交状态
            if(!SaleOrderStatusEnums.YITIJIAO.getCode().equals(cbpk.getCbpk11())){
                throw new SwException("必须在待审核状态下才能撤销");
            }
            CbpmCriteria plex=new CbpmCriteria();
            plex.createCriteria()
                    .andCbpk01EqualTo(auditTakeOrderDto.getTakeOrderId());

            int i = cbpmMapper.deleteByExample(plex);
            cbpk.setCbpk11(SaleOrderStatusEnums.WEITIJIAO.getCode());

        }else if(auditTakeOrderDto.getOpType().equals(3)){
            //反审 库建议的货品改为未出库

            if(!SaleOrderStatusEnums.YISHENHE.getCode().equals(cbpk.getCbpk11())){
                throw new SwException("必须在已审核状态下才能撤销");
            }
            CbpmCriteria scex=new CbpmCriteria();
            scex.createCriteria()
                    .andCbpk01EqualTo(auditTakeOrderDto.getTakeOrderId());
            List<Cbpm> cbpms = cbpmMapper.selectByExample(scex);
//            if(cbpms.size()>0){
//                throw new SwException("已有扫码的商品，不能反审");
//            }
            cbpk.setCbpk11(SaleOrderStatusEnums.YITIJIAO.getCode());
            for (Cbpm cbpm : cbpms) {
                if(cbpm.getCbpm11()==1){
                   throw new SwException("已有扫码的商品，不能反审");

                }
                cbpmMapper.deleteByPrimaryKey(cbpm.getCbpm01());

                GsGoodsSn gs=new GsGoodsSn();
                gs.setStatus(new Byte("1"));

                GsGoodsSnCriteria example=new GsGoodsSnCriteria();
                example.createCriteria()
                        .andSnEqualTo(cbpm.getCbpm09());
                int i = gsGoodsSnMapper.updateByExampleSelective(gs,example);
            }


        }else if(auditTakeOrderDto.getOpType().equals(4)){
            //标记完成

            if(!SaleOrderStatusEnums.YISHENHE.getCode().equals(cbpk.getCbpk11())){
                throw new SwException("必须在已审核状态下才能标记完成");
            }

            if(cbpk.getCheckStatus()!=1){
                throw new SwException("必须在质检完成状态下才能标记完成");
            }


            cbpk.setCbpk11(SaleOrderStatusEnums.YIWANCHENG.getCode());
            CboaCriteria orderex=new CboaCriteria();
            orderex.createCriteria()
                    .andCboa07EqualTo(cbpk.getSaleOrderNo());
            List<Cboa> cboas = cboaMapper.selectByExample(orderex);
            if(cboas.size()>0){
                Cboa cboa = cboas.get(0);
                CbobCriteria obex=new CbobCriteria();
                obex.createCriteria()
                        .andCboa01EqualTo(cboa.getCboa01());
                List<Cbob> cbobs = cbobMapper.selectByExample(obex);

                for (Cbob cbob : cbobs) {
                    CbplCriteria plex=new CbplCriteria();
                    plex.createCriteria()
                            .andCbpk01EqualTo(cbpk.getCbpk01())
                            .andCbpl08EqualTo(cbob.getCbob08())
                            .andCbpl07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                    List<Cbpl> cbpls = cbplMapper.selectByExample(plex);
                    if(cbpls.size()>0){
                        if(cbob.getTakeQty()==null){
                            cbob.setTakeQty(cbpls.get(0).getGoodProductQty());

                        }else {
                            cbob.setTakeQty(cbob.getTakeQty()+cbpls.get(0).getGoodProductQty());

                        }
                    }

                }


            }


        }else if(auditTakeOrderDto.getOpType().equals(5)){
            //取消完成

            if(!SaleOrderStatusEnums.YIWANCHENG.getCode().equals(cbpk.getCbpk11())){
                throw new SwException("必须在已完成状态下才能取消完成");
            }

            cbpk.setCbpk11(SaleOrderStatusEnums.YISHENHE.getCode());
            CboaCriteria orderex=new CboaCriteria();
            orderex.createCriteria()
                    .andCboa07EqualTo(cbpk.getSaleOrderNo());
            List<Cboa> cboas = cboaMapper.selectByExample(orderex);
            if(cboas.size()>0){
                Cboa cboa = cboas.get(0);
                CbobCriteria obex=new CbobCriteria();
                obex.createCriteria()
                        .andCboa01EqualTo(cboa.getCboa01());
                List<Cbob> cbobs = cbobMapper.selectByExample(obex);

                for (Cbob cbob : cbobs) {
                    CbplCriteria plex=new CbplCriteria();
                    plex.createCriteria()
                            .andCbpk01EqualTo(cbpk.getCbpk01())
                            .andCbpl08EqualTo(cbob.getCbob08())
                            .andCbpl07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                    List<Cbpl> cbpls = cbplMapper.selectByExample(plex);
                    if(cbpls.size()>0){
                        cbob.setTakeQty(cbob.getTakeQty()-cbpls.get(0).getGoodProductQty());
                    }

                }


            }

        }else if(auditTakeOrderDto.getOpType().equals(6)){
            cbpk.setCheckStatus(new Byte("1"));
            List<GoodsDto> goods = auditTakeOrderDto.getGoods();
            for (GoodsDto good : goods) {
                Cbpl cbpl=new Cbpl();
                cbpl.setCbpl01(good.getPlId());
                cbpl.setGoodProductQty(good.getGoodQty());
                cbplMapper.updateByPrimaryKeySelective(cbpl);
            }

        }


        cbpk.setCbpk12(auditTakeOrderDto.getUserId());
        cbpk.setCbpk05(auditTakeOrderDto.getUserId());
        cbpk.setCbpk04(new Date());
        cbpkMapper.updateByPrimaryKey(cbpk);
        return;
    }

    @Override
    @Transactional
    public void mdfTakeSuggest(ChangeSuggestDto changeSuggestDto) {
        Date date = new Date();
        List<ChangeSuggestModel> list = changeSuggestDto.getList();
        for (ChangeSuggestModel changeSuggestModel : list) {
            //检查修改的商品是否在建议出库单中存在

            Cbpm cbpm = cbpmMapper.selectByPrimaryKey(changeSuggestModel.getCbpm01());
            if(cbpm==null){
                throw new SwException("没有查到该提货建议");
            }
            if(!cbpm.getCbpm09().equals(changeSuggestModel.getCbpm09())){
                GsGoodsSnCriteria snex=new GsGoodsSnCriteria();
                snex.createCriteria()
                        .andSnEqualTo(changeSuggestModel.getCbpm09())
                        .andDeleteFlagEqualTo(DeleteFlagEnum.NOT_DELETE.getCode().byteValue());
                List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(snex);
                if(gsGoodsSns.size()==0){
                    throw new SwException("该SN不存在");
                }
                GsGoodsSn gsGoodsSn = gsGoodsSns.get(0);
                if(gsGoodsSn.getStatus()!=1){
                    throw new SwException("该Sn不是入库状态");
                }

                gsGoodsSn.setStatus(new Byte("2"));
                gsGoodsSn.setUpdateTime(date);
                gsGoodsSnMapper.updateByPrimaryKeySelective(gsGoodsSn);

                GsGoodsSnCriteria snex2=new GsGoodsSnCriteria();
                snex2.createCriteria()
                        .andSnEqualTo(cbpm.getCbpm09())
                        .andDeleteFlagEqualTo(DeleteFlagEnum.NOT_DELETE.getCode().byteValue());
                List<GsGoodsSn> gsGoodsSns2 = gsGoodsSnMapper.selectByExample(snex2);
                if(gsGoodsSns2.size()==0){
                    throw new SwException("该SN不存在");
                }

                GsGoodsSn gsGoodsSn2 = gsGoodsSns2.get(0);


                gsGoodsSn2.setStatus(new Byte("1"));
                gsGoodsSn2.setUpdateTime(date);
                gsGoodsSnMapper.updateByPrimaryKeySelective(gsGoodsSn2);
//                gsGoodsSn.set
//
                cbpm.setCbpm01(changeSuggestModel.getCbpm01());
                cbpm.setCbpm07(changeSuggestModel.getCbpm07());
                cbpm.setCbpm08(changeSuggestModel.getCbpm08());
                cbpm.setCbpm12(cbpm.getCbpm09());
                cbpm.setCbpm09(changeSuggestModel.getCbpm09());

                cbpm.setCbpm05(date);
                cbpm.setCbpm06(changeSuggestDto.getUserId());
                cbpm.setCbpm09(changeSuggestModel.getCbpm09());
                cbpm.setCbpm08(changeSuggestModel.getCbpm08());
                cbpm.setCbpm10(changeSuggestModel.getCbpm10());
                cbpmMapper.updateByPrimaryKeySelective(cbpm);
            }
//            CbpmCriteria example=new CbpmCriteria();
//            example.createCriteria()
//                    .andCbpm09EqualTo(changeSuggestModel.getCbpm09());
//            List<Cbpm> cbpms = cbpmMapper.selectByExample(example);
//            if(cbpms.size()>0 && !cbpms.get(0).getCbpm01().equals(changeSuggestModel.getCbpm01())){
//                throw new SwException("您选择的Sn商品已经在别的出库单中存在:" + changeSuggestModel.getCbpm09());
//            }



//            gsGoodsSnMapper.selectByExample()

        }

    }

    @Override
    public int TakeGoodsOrdersm(List<Cbpm> itemList) {
        if(itemList.size()==0){
            throw new SwException("请选择要扫码的商品");
        }



        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbpmMapper mapper = session.getMapper(CbpmMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            Cbpk cbpk = cbpkMapper.selectByPrimaryKey(itemList.get(i).getCbpk01());
            if(!cbpk.getCbpk11().equals(2)){
                throw new SwException("审核状态才能扫码");
            }
            CbpmCriteria example=new CbpmCriteria();
                example.createCriteria()
                        .andCbpk01EqualTo(cbpk.getCbpk01())
                    .andCbpm09EqualTo(itemList.get(i).getCbpm09());
            List<Cbpm> cbpms = cbpmMapper.selectByExample(example);
            if(cbpms.size()==0){
                throw new SwException("您选择的Sn商品不在出库建议表中" );
            }


/*GsGoodsSnCriteria example0=new GsGoodsSnCriteria();
            example0.createCriteria()
                    .andSnEqualTo(itemList.get(i).getCbpm09());
            List<GsGoodsSn> gsGoodsSnss = gsGoodsSnMapper.selectByExample(example0);
            if(gsGoodsSnss.size()>0){
                throw new SwException("替换后sn已存在" );
            }*/
          CbpmCriteria sfgu=new CbpmCriteria();
            sfgu.createCriteria()
                    .andCbpm09EqualTo(itemList.get(i).getCbpm09())
                            .andCbpm11EqualTo(ScanStatusEnum.YISAOMA.getCode());
            List<Cbpm> cbpmss = cbpmMapper.selectByExample(sfgu);
            if(cbpmss.size()>0){
                throw new SwException("sn已扫码" );
            }



            itemList.get(i).setCbpm05(date);
            itemList.get(i).setCbpm06(Math.toIntExact(userid));
            itemList.get(i).setCbpm11(ScanStatusEnum.YISAOMA.getCode());


            GsGoodsSnCriteria example1 = new GsGoodsSnCriteria();
            example1.createCriteria()
                    .andSnEqualTo(itemList.get(i).getCbpm09());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example1);
            if(gsGoodsSns.size()==0){
                throw new SwException("您选择的Sn商品不在货物SN表中" );
            }

            GsGoodsSnCriteria example6 = new GsGoodsSnCriteria();
            example6.createCriteria()
                    .andSnEqualTo(itemList.get(i).getCbpm09())
            .andStatusEqualTo(GoodsType.yck.getCode());
            List<GsGoodsSn> gsGoodsSnss = gsGoodsSnMapper.selectByExample(example6);
            if(gsGoodsSnss.size()>0){
                throw new SwException("您选择的Sn商品已经出库" );
            }

            GsGoodsSn goodsSn = new GsGoodsSn();
            goodsSn.setId(gsGoodsSns.get(i).getId());
            goodsSn.setCreateTime(gsGoodsSns.get(i).getCreateTime());
            goodsSn.setCreateBy(gsGoodsSns.get(i).getCreateBy());
            goodsSn.setUpdateTime(date);
            goodsSn.setUpdateBy(Math.toIntExact(userid));
            goodsSn.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            goodsSn.setWhId(gsGoodsSns.get(i).getWhId());
            goodsSn.setGoodsId(gsGoodsSns.get(i).getGoodsId());
            goodsSn.setSn(itemList.get(i).getCbpm09());
            goodsSn.setGroudStatus(Groudstatus.XJ.getCode());
            goodsSn.setStatus(GoodsType.ckz.getCode());
            goodsSn.setLocationId(null);

            GsGoodsSnCriteria example2 = new GsGoodsSnCriteria();
            example2.createCriteria()
                    .andSnEqualTo(itemList.get(i).getCbpm09());
            gsGoodsSnMapper.updateByExample(goodsSn, example2);

            mapper.updateByExampleSelective(itemList.get(i),example);

        }
      //  Cbpk cbpk=new Cbpk();
      //  cbpk.setCbpk01(itemList.get(0).getCbpk01());
        //cbpk.setCbpk11(TaskStatus.bjwc.getCode());
      //  cbpkMapper.updateByPrimaryKeySelective(cbpk);
//        CbpkCriteria example=new CbpkCriteria();
//        example.createCriteria()
//                .andCbpk01EqualTo(itemList.get(0).getCbpk01());
//        cbpkMapper.updateByExampleSelective(cbpk,example);
        session.commit();
        session.clearCache();
        return 1;
    }

    @Override
    public List<GsOutStockAdivceVo> saleOrderSuggest(GsOutStockAdivceDto gsOutStockAdivceDto) {
        List<GsOutStockAdivceVo> list=   gsOutStockAdivceMapper.saleOrderSuggest(gsOutStockAdivceDto);
        Map<Integer, String> brandMap = baseCheckService.brandMap();

        for (GsOutStockAdivceVo gsOutStockAdivceVo : list) {

            if (brandMap.get(Integer.parseInt(gsOutStockAdivceVo.getBrand())) != null) {
//                gsOutStockAdivceVo.setGoodsMsg((brandMap.get(gsOutStockAdivceVo.getBrand()) + "-" + gsOutStockAdivceVo.getModel() + "-" + gsOutStockAdivceVo.getDescription()));
                gsOutStockAdivceVo.setBrand(brandMap.get(Integer.parseInt(gsOutStockAdivceVo.getBrand())));
            }
        }

        return list;
    }

    @Override
    public void auditOutStockEnd(GsOutStockAdivceDto gsOutStockAdivceDto) {

        GsOutStockAdivce gsOutStockAdivce = gsOutStockAdivceMapper.selectByPrimaryKey(gsOutStockAdivceDto.getId());
        if(gsOutStockAdivce==null){
            throw new SwException("没有查到该调拨建议");
        }

        if(gsOutStockAdivce.getStatus()!=2){
            throw new SwException("必须为待调拨状态才能标记完成");
        }



        Date date = new Date();
        gsOutStockAdivce.setUpdateTime(date);
        gsOutStockAdivce.setUpdateBy(gsOutStockAdivceDto.getUserId());
        gsOutStockAdivce.setStatus(new Byte("3"));
        gsOutStockAdivceMapper.updateByPrimaryKey(gsOutStockAdivce);
        if(gsOutStockAdivce.getWhId().equals(WareHouseType.GQWWHID)){
            return;
        }
        //增加占用
        GsGoodsUseCriteria exeample=new GsGoodsUseCriteria();
        exeample.createCriteria()
                //cdc仓库id
                .andWhIdEqualTo(WareHouseType.CDCWHID)
                .andOrderNoEqualTo(gsOutStockAdivce.getSaleOrderNo())
                .andGoodsIdEqualTo(gsOutStockAdivce.getGoodsId());
        List<GsGoodsUse> gsGoodsUses = gsGoodsUseMapper.selectByExample(exeample);
        if(gsGoodsUses.size()>0){
            GsGoodsUse goodsUse = gsGoodsUses.get(0);
            goodsUse.setLockQty(goodsUse.getLockQty()+gsOutStockAdivce.getQty());
            goodsUse.setUpdateTime(date);
            gsGoodsUseMapper.updateByPrimaryKey(goodsUse);
        }else {
            GsGoodsUse gsGoodsUse=new GsGoodsUse();
            gsGoodsUse.setLockQty(gsOutStockAdivce.getQty());
            gsGoodsUse.setUpdateTime(date);
            gsGoodsUse.setUpdateBy(gsOutStockAdivceDto.getUserId());
            gsGoodsUse.setWhId(WareHouseType.CDCWHID);
//            gsGoodsUse.setOrderType(new Byte("1"));
            gsGoodsUse.setOrderNo(gsOutStockAdivce.getSaleOrderNo());
            gsGoodsUse.setGoodsId(gsOutStockAdivce.getGoodsId());
            gsGoodsUse.setCreateTime(date);
            gsGoodsUse.setCreateBy(gsOutStockAdivceDto.getUserId());
            gsGoodsUse.setOrderQty(0.0);
            gsGoodsUseMapper.insert(gsGoodsUse);
        }


        //除CDC和GQW 减去仓库的库存占用
        GsGoodsUseCriteria usex=new GsGoodsUseCriteria();
        usex.createCriteria()
                .andWhIdEqualTo(gsOutStockAdivce.getWhId())
                .andGoodsIdEqualTo(gsOutStockAdivce.getGoodsId())
                .andOrderNoEqualTo(gsOutStockAdivce.getSaleOrderNo());
        List<GsGoodsUse> gsGoodsUsessub = gsGoodsUseMapper.selectByExample(usex);
        if(gsGoodsUsessub.size()>0){
            GsGoodsUse goodsUse = gsGoodsUsessub.get(0);
            if((goodsUse.getLockQty()-gsOutStockAdivce.getQty())>0){
                goodsUse.setLockQty(goodsUse.getLockQty()-gsOutStockAdivce.getQty());
                goodsUse.setUpdateTime(date);
                gsGoodsUseMapper.updateByPrimaryKey(goodsUse);
            }else {
                gsGoodsUseMapper.deleteByPrimaryKey(goodsUse.getId());
            }


        }
    }
    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/29 17:31
     *根据商品id和仓库id查未被占用的sn商品
     *
     */
    @Override
    public List<GsGoodsSnVo> selectGoodsSnByWhIdAndGoodsId(Integer whId, Integer goodsId) {
        List<GsGoodsSnVo> gsGoodsSnVos = gsGoodsSnMapper.selectGoodsSnByWhIdAndGoodsId(whId,goodsId);
        Map<Integer, String> integerStringMap = baseCheckService.brandMap();
        for (GsGoodsSnVo gsGoodsSnVo:gsGoodsSnVos) {
            if(gsGoodsSnVo.getCbpb10()!=null){
                gsGoodsSnVo.setCbpb10(integerStringMap.get(Integer.parseInt(gsGoodsSnVo.getCbpb10())));
            }
            gsGoodsSnVo.setGoodsMsg(gsGoodsSnVo.getSn()+" - "+gsGoodsSnVo.getCbla09()+" - "+gsGoodsSnVo.getCbpb10()+" - "+gsGoodsSnVo.getCbpb12()+" - "+gsGoodsSnVo.getCbpb08());
        }

        return gsGoodsSnVos;
    }

    @Override
    @Transactional
    public void mdfTakeSuggest2(CbpmDto cbpmDto) {

        CbpmCriteria cbpmCriteria =new CbpmCriteria();
        cbpmCriteria.createCriteria().andCbpk01EqualTo(cbpmDto.getCbpk01());
        //出货单中的扫码记录
        List<Cbpm> cbpmList = cbpmMapper.selectByExample(cbpmCriteria);
        //前端传过来的参数
        List<CbpmDto.CbpmDtoItem> canList = cbpmDto.getGoodsSnList();
        //检查出库单中的商品是否存在，如果不存在，则说明在执行删除操作
        //销售提货单主表关联的数据遍历
        for(Cbpm cbpm:cbpmList){
            int index =0;
            //前端传来的商品遍历
            for (CbpmDto.CbpmDtoItem cbpmDtoItem : canList) {
                //商品在传来的前端传来的商品中
                if(cbpm.getCbpm09().equals(cbpmDtoItem.getSn())){
                    index =1;
                }
            }
            //index为1则说明此商品未被前端删除，index为0则说明商品不在前端传来的商品集合中，已被前端删除
            if(index == 0){
                //判断商品是否已扫码
                if(cbpm.getCbpm11() == 1){
                    throw new SwException("您选择删除的Sn商品已扫码:" + cbpm.getCbpm09());
                }
           /*     CbpmCriteria cbpmCriteria2 =new CbpmCriteria();
                cbpmCriteria2.createCriteria()
                        .andCbpm09EqualTo(cbpm.getCbpm09());*/
                //删除CBPM表中的数据
                cbpmMapper.deleteByPrimaryKey(cbpm.getCbpm01());

                GsGoodsSn gsGoodsSn3 = new GsGoodsSn();
                gsGoodsSn3.setStatus((byte) 1L);
                gsGoodsSn3.setGroudStatus((byte) 1L);
                GsGoodsSnCriteria gsGoodsSnCriteria =new GsGoodsSnCriteria();
                gsGoodsSnCriteria.createCriteria().andSnEqualTo(cbpm.getCbpm09());
                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn3,gsGoodsSnCriteria);
            }

        }

        for (CbpmDto.CbpmDtoItem cbpmDtoItem : canList) {
            int index =0;
            for(Cbpm cbpm:cbpmList){
                if(cbpm.getCbpm09().equals(cbpmDtoItem.getSn())){
                    index =1;
                }
            }
            if(index == 0){
                //检查修改的商品是否在建议出库单中存在
                CbpmCriteria example=new CbpmCriteria();
                example.createCriteria()
                        .andCbpm09EqualTo(cbpmDtoItem.getSn());
                List<Cbpm> cbpms = cbpmMapper.selectByExample(example);
                if(cbpms.size()>0){
                    throw new SwException("您选择的Sn商品已经在别的出库单中存在:" + cbpmDtoItem.getSn());
                }
                Cbpm cbpm=new Cbpm();
                cbpm.setCbpm07(0);
                cbpm.setCbpm08(cbpmDtoItem.getGoodsId());
                cbpm.setCbpm09(cbpmDtoItem.getSn());
                cbpm.setCbpm10(cbpmDtoItem.getLocationId());
                cbpm.setCbpm05(new Date());
                cbpm.setCbpk01(cbpmDto.getCbpk01());
                cbpm.setCbpm06(Integer.parseInt(SecurityUtils.getUserId()+""));
                cbpmMapper.insertSelective(cbpm);

                GsGoodsSn gsGoodsSn2 = new GsGoodsSn();
                gsGoodsSn2.setId(cbpmDtoItem.getId());
                gsGoodsSn2.setStatus((byte) 2L);
                gsGoodsSn2.setGroudStatus((byte) 2L);
                gsGoodsSnMapper.updateByPrimaryKeySelective(gsGoodsSn2);
            }

           /* //检查修改的商品是否在建议出库单中存在
            CbpmCriteria example=new CbpmCriteria();
            example.createCriteria()
                    .andCbpm09EqualTo(changeSuggestModel.getCbpm09());
            List<Cbpm> cbpms = cbpmMapper.selectByExample(example);
            if(cbpms.size()>0 && !cbpms.get(0).getCbpm01().equals(changeSuggestModel.getCbpm01())){
                throw new SwException("您选择的Sn商品已经在别的出库单中存在:" + changeSuggestModel.getCbpm09());
            }

            Cbpm cbpm=new Cbpm();
            cbpm.setCbpm01(changeSuggestModel.getCbpm01());
            cbpm.setCbpm07(changeSuggestModel.getCbpm07());
            cbpm.setCbpm08(changeSuggestModel.getCbpm08());
            cbpm.setCbpm09(changeSuggestModel.getCbpm09());
            cbpm.setCbpm10(changeSuggestModel.getCbpm10());
            cbpm.setCbpm05(date);
            cbpm.setCbpm06(changeSuggestDto.getUserId());
            cbpmMapper.updateByPrimaryKey(cbpm);*/
        }

    }

}
