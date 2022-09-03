package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.dto.SaleOrderAddDto;
import com.ruoyi.system.domain.dto.SaleOrderGoodsDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISelloutofwarehouseService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.OrderDistributionService;
import com.ruoyi.system.service.gson.SaleOrderService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.params.shadow.com.univocity.parsers.tsv.TsvFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class SelloutofwarehouseServiceImpl implements ISelloutofwarehouseService {

    @Resource
    private CbsbMapper cbsbMapper;

    @Resource
    private CbscMapper cbscMapper;

    @Resource
    private CbsdMapper cbsdMapper;

    @Resource
    private CbpkMapper cbpkMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private NumberGenerate numberGenerate;

    @Resource
    private TaskService taskService;

    @Resource
    private BaseCheckService baseCheckService;

    @Resource
    private OrderDistributionService orderDistributionService;

    @Resource
    private CbobMapper cbobMapper;

    @Resource
    private   CbbaMapper  cbbaMapper;

    @Resource
    private SaleOrderService saleOrderService;

    /**
     * 新增销售出库主单
     *
     * @param cbsbDo 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public IdVo insertSelloutofwarehouse(CbsbDo cbsbDo) {


        Long userid = SecurityUtils.getUserId();
        Cbsb cbsb = BeanCopyUtils.coypToClass(cbsbDo, Cbsb.class, null);
        Date date = new Date();
        cbsb.setCbsb02(date);
        cbsb.setCbsb03(Math.toIntExact(userid));
        cbsb.setCbsb04(date);
        cbsb.setCbsb05(Math.toIntExact(userid));
        cbsb.setCbsb06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsb.setCbsb10(cbsbDo.getCbsb10());
        String sellofwarehouseNo = numberGenerate.getSellofwarehouseNo(cbsbDo.getCbsb10());
        cbsb.setCbsb07(sellofwarehouseNo);
        cbsb.setCbsb08(date);
        cbsb.setCbsb11(TaskStatus.mr.getCode());
        cbsb.setCbsb12(Math.toIntExact(userid));
        cbsb.setUserId(Math.toIntExact(userid));
        cbsbMapper.insertSelective(cbsb);

        CbsbCriteria example1 = new CbsbCriteria();
        example1.createCriteria().andCbsb07EqualTo(sellofwarehouseNo)
                .andCbsb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsb> cbsbss = cbsbMapper.selectByExample(example1);

        IdVo idVo = new IdVo();
        idVo.setId(cbsbss.get(0).getCbsb01());
        return idVo;
    }
    /**
     * 新增销售出库明细表
     *
     * @param itemList 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSwJsStores(List<Cbsc> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbscMapper mapper = session.getMapper(CbscMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbsc03(date);
            itemList.get(i).setCbsc04(Math.toIntExact(userid));
            itemList.get(i).setCbsc05(date);
            itemList.get(i).setCbsc06(Math.toIntExact(userid));
            itemList.get(i).setCbsc07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));
            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
        return 1;
    }
    /**
     * 销售出库单审核
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodesh(CbsbDo cbsbDo) {
        CbsbCriteria example = new CbsbCriteria();
        example.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                .andCbsb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsb> cbsbs = cbsbMapper.selectByExample(example);
        if(!cbsbs.get(0).getCbsb11().equals(TaskStatus.mr.getCode())){
            throw new SwException("未审核状态才能审核");
        }

        Long userid = SecurityUtils.getUserId();
        Cbsb cbsb = BeanCopyUtils.coypToClass(cbsbDo, Cbsb.class, null);
        Date date = new Date();
        cbsb.setCbsb04(date);
        cbsb.setCbsb05(Math.toIntExact(userid));
        cbsb.setCbsb11(TaskStatus.sh.getCode());
        CbsbCriteria example1 = new CbsbCriteria();
        example1.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                .andCbsb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbsbMapper.updateByExampleSelective(cbsb,example1);
    }

    @Transactional
    @Override
    public int insertSwJsSkuBarcodesf(CbsbDo cbsbDo) {

        CbsdCriteria example2 = new CbsdCriteria();
        example2.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01());
        List<Cbsd> cbpes = cbsdMapper.selectByExample(example2);
        if(cbpes.size()>0 ){
            int size = cbpes.size();
            for(int i=0;i<size;i++){
                if(cbpes.get(i).getCbsd11().equals(ScanStatusEnum.YISAOMA.getCode())) {

                    throw new SwException("已扫码不能反审");
                }
            }
        }
        Cbsb cbsb1 = cbsbMapper.selectByPrimaryKey(cbsbDo.getCbsb01());
        if(!cbsb1.getCbsb11().equals(TaskStatus.sh.getCode())){
            throw new SwException(" 审核状态才能反审");
        }
        Long userid = SecurityUtils.getUserId();
        Cbsb cbsb = BeanCopyUtils.coypToClass(cbsbDo, Cbsb.class, null);
        Date date = new Date();
        cbsb.setCbsb04(date);
        cbsb.setCbsb05(Math.toIntExact(userid));
        cbsb.setCbsb11(TaskStatus.mr.getCode());
        CbsbCriteria example1 = new CbsbCriteria();
        example1.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                .andCbsb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbsbMapper.updateByExampleSelective(cbsb,example1);    }

    @Transactional
    @Override
    public int insertSwJsSkuBarcodeshwc(CbsbDo cbsbDo) {
        Cbsb cbsb1 = cbsbMapper.selectByPrimaryKey(cbsbDo.getCbsb01());
        if (cbsb1.getCbsb11().equals(TaskStatus.sh.getCode())) {
        } else {
            throw new SwException(" 审核状态才能标记完成");
        }

        //回写生产总总订单
        CbscCriteria example = new CbscCriteria();
        example.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                .andCbsc07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsc> cbscs = cbscMapper.selectByExample(example);

//        List<Cbob> cbobs = cbobMapper.selectByExample(example2);
//        String cbob18 = cbobs.get(0).getCbob18();
        if (cbscs.size() > 0) {
            for (int i = 0; i < cbscs.size(); i++) {
                SaleOrderExitDo saleOrderExitDo = new SaleOrderExitDo();
                saleOrderExitDo.setOrderNo(cbsb1.getCbsb07());
                saleOrderExitDo.setGoodsId(cbscs.get(i).getCbsc08());
                saleOrderExitDo.setQty(cbscs.get(i).getCbsc09());
                Cbob cbob = cbobMapper.selectByPrimaryKey(cbscs.get(i).getCbsc14());
if(cbob==null){
    throw new SwException("销售订单明细表未查到");
}

                saleOrderExitDo.setTotalOrderNo(cbob.getCbob18());
                orderDistributionService.saleOrderExit(saleOrderExitDo);
            }
        }

        Long userid = SecurityUtils.getUserId();
        Cbsb cbsb = BeanCopyUtils.coypToClass(cbsbDo, Cbsb.class, null);
        Date date = new Date();
        cbsb.setCbsb04(date);
        cbsb.setCbsb05(Math.toIntExact(userid));
        cbsb.setCbsb11(TaskStatus.bjwc.getCode());
        CbsbCriteria example1 = new CbsbCriteria();
        example1.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                .andCbsb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        CbscCriteria example2 = new CbscCriteria();
        example2.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                .andCbsc07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsc> cbscs1 = cbscMapper.selectByExample(example2);
        int size = cbscs1.size();

        List<SaleOrderGoodsDto> goods =   new ArrayList<>(size);
        ;
        for (int i = 0; i < cbscs1.size(); i++) {

            goods.add(new SaleOrderGoodsDto());
            goods.get(i).setNumber(cbscs1.get(i).getCbsc02());
            goods.get(i).setGoodsId(cbscs1.get(i).getCbsc08());
            goods.get(i).setQty(cbscs1.get(i).getCbsc09());
            goods.get(i).setNormalPrice(cbscs1.get(i).getCbsc11());
            goods.get(i).setCurrentPrice(cbscs1.get(i).getCbsc11());
            goods.get(i).setTotalPrice(cbscs1.get(i).getCbsc12());
            goods.get(i).setRemark(cbscs1.get(i).getCbsc13());
            goods.get(i).setTotalOrderNo(cbsb1.getCbsb07());
        }
        int size1 = goods.size();
        SaleOrderAddDto saleOrderAddDto = new SaleOrderAddDto();
        saleOrderAddDto.setCustomerNo(cbsb1.getCbsb30());
        saleOrderAddDto.setOrderDate(date);
        saleOrderAddDto.setCustomerId(cbsb1.getCbsb09());
        int i = cbsb1.getCbsb17() == null ? 0 : Integer.parseInt(cbsb1.getCbsb17());
        saleOrderAddDto.setSaleUserId(i);
        saleOrderAddDto.setCurrency(cbsb1.getCbsb16());
        saleOrderAddDto.setInvoiceType(cbsb1.getCbsb24());
        saleOrderAddDto.setOrderType(cbsb1.getCbsb32());
        saleOrderAddDto.setOrderClass(cbsb1.getCbsb31());
        saleOrderAddDto.setGoods(goods);
       saleOrderService.addSaleOrder(saleOrderAddDto);



        return         cbsbMapper.updateByExampleSelective(cbsb, example1);

    }

    @Transactional
    @Override
    public int insertSwJsSkuBarcodeqxwc(CbsbDo cbsbDo) {

        CbsdCriteria example2 = new CbsdCriteria();
        example2.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01());
        List<Cbsd> cbpes = cbsdMapper.selectByExample(example2);
        if(cbpes.size()>0 ){
            int size = cbpes.size();
            for(int i=0;i<size;i++){
                if(cbpes.get(i).getCbsd11().equals(ScanStatusEnum.YISAOMA.getCode())) {

                    throw new SwException("已扫码不能反审");
                }
            }
        }

        Cbsb cbsb1 = cbsbMapper.selectByPrimaryKey(cbsbDo.getCbsb01());
        if(!cbsb1.getCbsb11().equals(TaskStatus.bjwc.getCode())){
            throw new SwException(" 标记完成才能取消完成");
        }
        Long userid = SecurityUtils.getUserId();
        Cbsb cbsb = BeanCopyUtils.coypToClass(cbsbDo, Cbsb.class, null);
        Date date = new Date();
        cbsb.setCbsb04(date);
        cbsb.setCbsb05(Math.toIntExact(userid));
        cbsb.setCbsb11(TaskStatus.sh.getCode());
        CbsbCriteria example1 = new CbsbCriteria();
        example1.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                .andCbsb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbsbMapper.updateByExampleSelective(cbsb,example1);    }

    @Override
    public List<CbsbVo> selectSwJsTaskGoodsRelList(CbsbVo cbsbVo) {
        return cbsbMapper.selectSwJsTaskGoodsRelList(cbsbVo);
    }

    @Override
    public List<CbsbVo> selectSwJsTaskGoodsRelLists(CbsbVo cbsbVo) {
        return cbsbMapper.selectSwJsTaskGoodsRelLists(cbsbVo);
    }

    @Transactional
    @Override
    public int insertSwJsSkuBarcodel(CbsbDo cbsbDo) {
        Cbsb cbsb1 = cbsbMapper.selectByPrimaryKey(cbsbDo.getCbsb01());
        if(!cbsb1.getCbsb11().equals(TaskStatus.mr.getCode())){
            throw new SwException("未审核状态才能删除");
        }
        Long userid = SecurityUtils.getUserId();
        Cbsb cbsb = BeanCopyUtils.coypToClass(cbsbDo, Cbsb.class, null);
        Date date = new Date();
        cbsb.setCbsb04(date);
        cbsb.setCbsb05(Math.toIntExact(userid));
        cbsb.setCbsb06(DeleteFlagEnum.DELETE.getCode());
        CbsbCriteria example1 = new CbsbCriteria();
        example1.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                .andCbsb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbsbMapper.updateByExampleSelective(cbsb,example1);    }


    /**
     * 销售出库单详情
     */
    @Override
    public List<CbsbsVo> selectSwJsTaskGoodsRelListss(CbsbsVo cbsbsVo) {
        return cbpkMapper.selectSwJsTaskGoodsRelListss(cbsbsVo);
    }

    @Transactional
    @Override
    public int insertSwJsStoress(List<Cbsd> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbsdMapper mapper = session.getMapper(CbsdMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbsd03(date);
            itemList.get(i).setCbsd04(Math.toIntExact(userid));
            itemList.get(i).setCbsd05(date);
            itemList.get(i).setCbsd06(Math.toIntExact(userid));
            itemList.get(i).setCbsd07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));

            //如果查不到添加信息到库存表
            Cbsb cbsb = cbsbMapper.selectByPrimaryKey(itemList.get(i).getCbsb01());
            //判断是否在提货单里
            CbpkCriteria example = new CbpkCriteria();
            example.createCriteria().andCbpk09EqualTo(cbsb.getCbsb09())
                    .andCbpk30EqualTo(cbsb.getCbsb30())
                    .andCheckStatusEqualTo(checkstatusEnum.ZJWC.getCode());
            List<Cbpk> cbpkList = cbpkMapper.selectByExample(example);
            if(cbpkList.size()==0){
                throw new SwException("该商品不在提货单里");
            }
            GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
            //获取仓库id
            gsGoodsSkuDo.setWhId(cbsb.getCbsb10());
            //获取商品id
            gsGoodsSkuDo.setGoodsId(itemList.get(i).getCbsd08());
            gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //通过仓库id和货物id判断是否存在
            List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
            if(gsGoodsSkus.size()==0){
                throw new SwException("没有该库存信息");

            }
            //如果存在则更新库存数量
            else {
                //加锁
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                //查出
                Double qty = gsGoodsSkus.get(0).getQty();
                if(qty==0){
                    throw new SwException("库存数量不足");
                }
                //获取仓库id
                gsGoodsSkuDo1.setWhId(cbsb.getCbsb10());
                //获取商品id
                gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbsd08());
                gsGoodsSkuDo1.setLocationId(itemList.get(i).getCbsd10());
                gsGoodsSkuDo1.setQty(qty-1);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);

            }
            //更新sn表
            GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setSn(itemList.get(i).getCbsd09());
            gsGoodsSnDo.setStatus(GoodsType.yck.getCode());
            gsGoodsSnDo.setOutTime(date);
            gsGoodsSnDo.setGroudStatus(Groudstatus.XJ.getCode());
            taskService.updateGsGoodsSn(gsGoodsSnDo);

            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }

        //写台账
        Cbsb cbsb = cbsbMapper.selectByPrimaryKey(itemList.get(0).getCbsb01());
        if(cbsb==null){
            throw new SwException("没有该销售出库单");
        }
        CbscCriteria example = new CbscCriteria();
        example.createCriteria().andCbsb01EqualTo(cbsb.getCbsb01())
                .andCbsc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsc> cbscs = cbscMapper.selectByExample(example);
        if(cbscs.size()==0){
            throw new SwException("没有该销售出库单明细表为空");
        }
     /*   Cbsa cbsa = cbasMapper.selectByPrimaryKey(cbpc1.getCbpc09());

        for(int i=0;i<cbscs.size();i++){
            CbibDo cbibDo = new CbibDo();
            cbibDo.setCbib02(cbsb.getCbsb10());
            cbibDo.setCbib03(cbsb.getCbsb07());
            cbibDo.setCbib05(String.valueOf(TaskType.xcckd.getCode()));
            cbibDo.setCbib06(cbscs.get(i).getCbsc15());
            cbibDo.setCbib07(cbpc1.getCbpc01());
            cbibDo.setCbib08(cbpds.get(i).getCbpd08());
            //本次入库数量
            cbibDo.setCbib11(cbpds1.get(i).getCbpd09());
            cbibDo.setCbib12(cbpds1.get(i).getCbpd12());
            cbibDo.setCbib15(cbpds1.get(i).getCbpd09());
            cbibDo.setCbib16(cbpds1.get(i).getCbpd12());
            cbibDo.setCbib17(TaskType.cgrkd.getMsg());
            cbibDo.setCbib19(cbpc1.getCbpc09());
            taskService.InsertCBIB(cbibDo);
        }*/
        //状态设为标记完成，回写总订单

        CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(itemList.get(0).getCbsb01());
       this.insertSwJsSkuBarcodeshwc(cbsbDo);
        session.commit();
        session.clearCache();
        return 1;
    }

    @Transactional
    @Override
    public int insertSwJsSkuBarcodedit(CbsbDo cbsbDo) {
        CbsdCriteria example2 = new CbsdCriteria();
        example2.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01());
        List<Cbsd> cbpes = cbsdMapper.selectByExample(example2);
        if(cbpes.size()>0 ){
            int size = cbpes.size();
            for(int i=0;i<size;i++){
                if(cbpes.get(i).getCbsd11().equals(ScanStatusEnum.YISAOMA.getCode())) {

                    throw new SwException("已扫码不能编辑");
                }
            }
        }

        Cbsb cbsb1 = cbsbMapper.selectByPrimaryKey(cbsbDo.getCbsb01());
        if(!cbsb1.getCbsb11().equals(TaskStatus.mr.getCode())){
            throw new SwException(" 未审核才能编辑");
        }
        Long userid = SecurityUtils.getUserId();
        Cbsb cbsb = BeanCopyUtils.coypToClass(cbsbDo, Cbsb.class, null);
        Date date = new Date();
        cbsb.setCbsb04(date);
        cbsb.setCbsb05(Math.toIntExact(userid));
        CbsbCriteria example1 = new CbsbCriteria();
        example1.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                .andCbsb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
         cbsbMapper.updateByExampleSelective(cbsb,example1);
               return 1;}

}
