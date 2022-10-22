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
import com.ruoyi.system.service.gson.*;
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
import java.util.*;
import java.util.stream.Collectors;

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

    @Resource
    private CbsaMapper cbsaMapper;

    @Resource
    private CbodMapper cbodMapper;

    @Resource
    private CblaMapper cblaMapper;

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;

    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;

    @Resource
    private CbpmMapper cbpmMapper;

    @Resource
    private TakeGoodsService takeGoodsService;

    @Resource
    private CboaMapper cboaMapper;
    /**
     * 新增销售出库主单
     *
     * @param cbsbDo 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public IdVo insertSelloutofwarehouse(CbsbDo cbsbDo) {

//if(cbsbDo.getCbsb30()==null){
//    throw new SwException("客户订单号不能为空");
//
//}
        CbsbCriteria cbsbCriteria = new CbsbCriteria();
        cbsbCriteria.createCriteria().andCbsb07EqualTo(cbsbDo.getCbsb07());
        List<Cbsb> cbsbList = cbsbMapper.selectByExample(cbsbCriteria);
        if (cbsbList.size() > 0) {
            throw new SwException("该订单已存在");
        }
if(cbsbDo.getCbsb20()==null){
    throw new SwException("提货单主表id不能为空");
}
        CbsbCriteria sdg=new CbsbCriteria();
        sdg.createCriteria().andCbsb20EqualTo(cbsbDo.getCbsb20())
                .andCbsb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsb> cbsbs = cbsbMapper.selectByExample(sdg);
        if(cbsbs.size()>0){
            throw new SwException("关联提货单重复");
        }


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
        if(cbsbDo.getTakeId()==null){
            throw new SwException("提货单id不能为空");
        }
        cbsb.setCbsb20(cbsbDo.getTakeId());


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


        if(itemList.size()==0){
            throw new SwException("销售出库明细不能为空");
        }
        if(itemList.get(0).getCbsb01()==null){
            throw new SwException("销售出库单主单id不能为空");
        }
        Cbsb cbsb = cbsbMapper.selectByPrimaryKey(itemList.get(0).getCbsb01());
        if(cbsb==null){
            throw new SwException("销售出库单主单不存在");
        }
        Integer storeid = cbsb.getCbsb10();
        GsGoodsSkuCriteria sku = new GsGoodsSkuCriteria();
        sku.createCriteria().andWhIdEqualTo(storeid);
        List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(sku);
        if(gsGoodsSkus.size()==0){
            throw new SwException("该仓库没有商品");
        }

        Set<Integer> skuIds = new HashSet<>();
        for (GsGoodsSku gsGoodsSku : gsGoodsSkus) {
            skuIds.add(gsGoodsSku.getGoodsId());
        }
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbscMapper mapper = session.getMapper(CbscMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        Set<Integer> skuIds1 = new HashSet<>();

        for (int i = 0; i < itemList.size(); i++) {

            if(itemList.get(i).getCbsc08()==null){
                throw new SwException("采购退货单明细商品id不能为空");
            }
            if(!skuIds.contains(itemList.get(i).getCbsc08())){
                throw new SwException("仓库里没有该商品");
            }

            if(itemList.get(i).getTakegoodsid()==null){
                throw new SwException("提货单id不能为空");
            }
            Cbpk cbpk = cbpkMapper.selectByPrimaryKey(itemList.get(i).getTakegoodsid());

           /* skuIds1.add(cbpk.getCbpk09());
            if(skuIds1.size()>1){
                throw new SwException("客户id不一致");
            }*/



            itemList.get(i).setCbsc03(date);
            itemList.get(i).setCbsc04(Math.toIntExact(userid));
            itemList.get(i).setCbsc05(date);
            itemList.get(i).setCbsc06(Math.toIntExact(userid));
            itemList.get(i).setCbsc07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));
            itemList.get(i).setTakegoodsid(itemList.get(i).getTakegoodsid());
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


        int sdw=0;
        CbscCriteria ett = new CbscCriteria();
        ett.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01());
        List<Cbsc> yio = cbscMapper.selectByExample(ett);
        if (yio.size() == 0) {
            throw new SwException("没有明细不能标记完成");
        }
        for(Cbsc cbsc:yio){
            Double cbsc09 = cbsc.getCbsc09();
            sdw+=cbsc09;
        }

        CbsdCriteria tuo = new CbsdCriteria();
        tuo.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01());
        List<Cbsd> yio1 = cbsdMapper.selectByExample(tuo);
        if(yio1.size()<sdw){
            throw new SwException("扫码数量小于任务数量不能标记完成");
        }
        List<String> collect = yio1.stream().map(Cbsd::getCbsd09).collect(Collectors.toList());

        for(int m=0;m<collect.size();m++){
            GsGoodsSn gsGoodsSn = new GsGoodsSn();
            gsGoodsSn.setStatus(GoodsType.yck.getCode());
            GsGoodsSnCriteria gssn = new GsGoodsSnCriteria();
            gssn.createCriteria().andSnEqualTo(collect.get(m));
            gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,gssn);

        }


        //回写生产总总订单
        CbscCriteria example = new CbscCriteria();
        example.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                .andCbsc07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsc> cbscs = cbscMapper.selectByExample(example);

//        List<Cbob> cbobs = cbobMapper.selectByExample(example2);
//        String cbob18 = cbobs.get(0).getCbob18();
        //在提货单id在明细表，for
        Cbpk cbpk = cbpkMapper.selectByPrimaryKey(cbsb1.getCbsb20());

                CboaCriteria afd = new CboaCriteria();
        afd.createCriteria().andCboa07EqualTo(cbpk.getSaleOrderNo());
        List<Cboa> cboas = cboaMapper.selectByExample(afd);
        Cboa cboa = cboas.get(0);
        if (cbscs.size() > 0) {
            for (int i = 0; i < cbscs.size(); i++) {
                SaleOrderExitDo saleOrderExitDo = new SaleOrderExitDo();
                saleOrderExitDo.setOrderNo(cboa.getCboa07());
                saleOrderExitDo.setGoodsId(cbscs.get(i).getCbsc08());
                saleOrderExitDo.setQty(cbscs.get(i).getCbsc09());
                saleOrderExitDo.setCbobId(cbscs.get(i).getCbsc14());
                saleOrderExitDo.setOrderClass(cboa.getCboa27());
                saleOrderExitDo.setWhId(cbsb1.getCbsb10());
                if(cbscs.get(i).getCbsc14()!=null) {
                    Cbob cbob = cbobMapper.selectByPrimaryKey(cbscs.get(i).getCbsc14());
                    if (cbob == null) {
                        throw new SwException("销售订单明细表未查到");
                    }

                    saleOrderExitDo.setTotalOrderNo(cbob.getCbob18());
                }
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

        UIOVo uioVo = new UIOVo();
        uioVo.setId(cbsbDo.getCbsb01());
        List<UIOVo> selectbyid = cbsdMapper.selectBYID(uioVo);
        if(selectbyid.size()>0){
            for(int k=0;k<selectbyid.size();k++) {
                GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();

                gsGoodsSkuDo.setLocationId(selectbyid.get(k).getStoreskuid());
                //获取仓库id
                gsGoodsSkuDo.setWhId(cbsb1.getCbsb10());
                //获取商品id
                gsGoodsSkuDo.setGoodsId(selectbyid.get(k).getGoodsId());
                gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                //通过仓库id和货物id判断是否存在
                List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
                if (gsGoodsSkus.size() == 0) {
                    throw new SwException("没有该库存信息");

                }
                //如果存在则更新库存数量
                else {
                    //加锁
                    baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                    GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                    //查出
                    Double qty = gsGoodsSkus.get(0).getQty();
                    if (qty == 0) {
                        throw new SwException("库存数量不足");
                    }
                    //获取仓库id
                    gsGoodsSkuDo1.setWhId(cbsb1.getCbsb10());
                    //获取商品id
                    gsGoodsSkuDo1.setGoodsId(selectbyid.get(k).getGoodsId());
                    gsGoodsSkuDo1.setLocationId(selectbyid.get(k).getStoreskuid());
//        if(num>qty){
//            throw new SwException("出库数量大于库存数量");
//
//        }
                    if(qty - selectbyid.get(k).getNums()<0){
                        throw new SwException("出库数量大于库存数量");
                    }
                    gsGoodsSkuDo1.setQty(qty - selectbyid.get(k).getNums());
                    taskService.updateGsGoodsSku(gsGoodsSkuDo1);
                }
            }}

        for(int i=0;i<size;i++){
            Integer cbsc14 = cbscs1.get(i).getCbsc14();
            Cbob cbob = cbobMapper.selectByPrimaryKey(cbsc14);
            if(cbob == null){
                throw new SwException("找不到此销售订单明细");
            }
            CbsdCriteria example3 = new CbsdCriteria();
            example3.createCriteria().andCbsd08EqualTo(cbscs1.get(i).getCbsc08())
                            .andCbsb01EqualTo(cbscs1.get(i).getCbsb01());
            List<Cbsd> cbsds = cbsdMapper.selectByExample(example3);
            if(cbsds.size()==0){
                throw new SwException("找不到此销售出货单扫码记录");

            }
            cbob.setCbob10(cbob.getCbob10()+cbsds.size());
            cbob.setCbob01(cbsc14);
            cbobMapper.updateByPrimaryKeySelective(cbob);
        }
        List<Cbsd> cbsds=null;
        for(int i=0;i<size;i++){

        CbsdCriteria examples=new CbsdCriteria();
        examples.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                .andCbsd08EqualTo(cbscs1.get(i).getCbsc08());
     cbsds = cbsdMapper.selectByExample(examples);
        if(cbsds.size()==0){
            throw new SwException("销售出库单扫描记录未查到");

        }
        if(   cbsds.get(i).getCbsd10()==null){
            throw new SwException("销售出库单库位未查到");

        }
        }

        Double num = (double) cbsds.size();

     /*   //更新库存
        for(int l=0;l<cbsds.size();l++) {

    GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
    if(cbsds.get(l).getCbsd10()==null){
        throw new SwException("销售出库单库位未查到");
    }
    gsGoodsSkuDo.setLocationId(cbsds.get(l).getCbsd10());
    //获取仓库id
    gsGoodsSkuDo.setWhId(cbsb1.getCbsb10());
    //获取商品id
    gsGoodsSkuDo.setGoodsId(cbsds.get(l).getCbsd08());
    gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
    //通过仓库id和货物id判断是否存在
    List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
    if (gsGoodsSkus.size() == 0) {
        throw new SwException("没有该库存信息");

    }
    //如果存在则更新库存数量
    else {
        //加锁
        baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
        GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
        //查出
        Double qty = gsGoodsSkus.get(0).getQty();
        if (qty == 0) {
            throw new SwException("库存数量不足");
        }
        //获取仓库id
        gsGoodsSkuDo1.setWhId(cbsb1.getCbsb10());
        //获取商品id
        gsGoodsSkuDo1.setGoodsId(cbsds.get(l).getCbsd08());
        gsGoodsSkuDo1.setLocationId(cbsds.get(l).getCbsd10());
//        if(num>qty){
//            throw new SwException("出库数量大于库存数量");
//
//        }
        gsGoodsSkuDo1.setQty(qty - 1);
        taskService.updateGsGoodsSku(gsGoodsSkuDo1);
    }
}*/

        //写台账

        CbscCriteria example6 = new CbscCriteria();
        example6.createCriteria()
                .andCbsb01EqualTo(cbsb1.getCbsb01())
                .andCbsc07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsc> cbscss = cbscMapper.selectByExample(example6);
        if(cbscs.size()==0){
            throw new SwException("销售出库单明细表为空");
        }

        for(int i=0;i<cbscs.size();i++){
            CbibDo cbibDo = new CbibDo();
            cbibDo.setCbib02(cbsb1.getCbsb10());
            cbibDo.setCbib03(cbsb1.getCbsb07());
            cbibDo.setCbib05(String.valueOf(TaskType.xcckd.getCode()));
            Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbscss.get(i).getCbsc15());

           // cbibDo.setCbib06(cbsa.getCbsa08());
            cbibDo.setCbib07(cbscss.get(i).getCbsc01());
            cbibDo.setCbib08(cbscss.get(i).getCbsc08());
            //本次入库数量
            cbibDo.setCbib11((double) 0);
            cbibDo.setCbib12((double) 0);
            cbibDo.setCbib13(num);
            cbibDo.setCbib14(cbscss.get(i).getCbsc11()*num);
            cbibDo.setCbib17(TaskType.xcckd.getMsg());
            cbibDo.setCbib19(cbscss.get(i).getCbsc15());
            taskService.InsertCBIB(cbibDo);
        }
        return cbsbMapper.updateByExampleSelective(cbsb, example1);

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
        List<CbsbsVo> cbsbsVos = cbpkMapper.selectSwJsTaskGoodsRelListss(cbsbsVo);

        CbsbsVo res = new CbsbsVo();
        List<ScanVo> goods = res.getGoods();
         List<TakeOrderSugestVo> outsuggestion = res.getOutsuggestion();

         if(cbsbsVos.get(0).getCbsb20()!=null){
             TakeGoodsOrderDetailVo takeGoodsOrderDetailVo = takeGoodsService.takeOrderDetail(cbsbsVos.get(0).getCbsb20());
             List<TakeOrderSugestVo> sugests = takeGoodsOrderDetailVo.getSugests();
             for(int y=0;y<sugests.size();y++){

                 CbsdCriteria eyer = new CbsdCriteria();
                 eyer.createCriteria().andCbsd09EqualTo(sugests.get(y).getSn());
                    List<Cbsd> cbsds = cbsdMapper.selectByExample(eyer);
                       if(cbsds.size()==0){
                           sugests.get(y).setScanStatus(ScanStatusEnum.WEISAOMA.getMsg());
                       }else{
                           sugests.get(y).setScanStatus(ScanStatusEnum.YISAOMA.getMsg());
                       }

             }

             outsuggestion.addAll(sugests);
         }



        Integer cbsb01 = cbsbsVo.getCbsb01();
        if(cbsb01==null){
            throw new SwException("销售出库单id不能为空");
        }
        CbsdCriteria example3 = new CbsdCriteria();
        example3.createCriteria().andCbsb01EqualTo(cbsb01);
        List<Cbsd> cbsds = cbsdMapper.selectByExample(example3);
        Double sum = 0.0;

        if(cbsds.size()>0) {
            Integer saoma = 0;

            for (int i = 0; i < cbsbsVos.size(); i++) {
                CbsdCriteria example2 = new CbsdCriteria();
                example2.createCriteria().andCbsb01EqualTo(cbsb01)
                        .andCbsd08EqualTo(cbsbsVos.get(i).getCbsc08());
                List<Cbsd> cbpes = cbsdMapper.selectByExample(example2);

                int size = cbpes.size();
                for (int j = 0; j < size; j++) {
                    ScanVo scanVo = new ScanVo();
                    scanVo.setLx(cbsbsVos.get(i).getCbpa07());
                    scanVo.setPinpai(cbsbsVos.get(i).getCala08());
                    scanVo.setCbpb08(cbsbsVos.get(i).getCbpb08());
                    scanVo.setCbpb12(cbsbsVos.get(i).getCbpb12());
                    scanVo.setSn(cbpes.get(j).getCbsd09());
                    Cbla cbla = cblaMapper.selectByPrimaryKey(cbpes.get(j).getCbsd10());
                    if(cbla==null){
                        throw new SwException("没有改库位信息");
                    }
                    scanVo.setKwm(cbla.getCbla09());
                    scanVo.setCbpe03(cbpes.get(j).getCbsd03());
                    goods.add(scanVo);
                }
                cbsbsVos.get(i).setSaoma(size);
                saoma +=cbsbsVos.get(i).getSaoma();
            }
            cbsbsVos.get(0).setSaomanums(saoma);

            cbsbsVos.get(0).setGoods(goods);
        }
        for(int i=0;i<cbsbsVos.size();i++){
            if(cbsbsVos.get(i).getCbsc09()==null){
                throw new SwException("明细表数量为空");

            }
            sum+=cbsbsVos.get(i).getCbsc09();
        }

        cbsbsVos.get(0).setNums(sum);
        cbsbsVos.get(0).setOutsuggestion(outsuggestion);
        return cbsbsVos;
        }


    @Transactional
    @Override
    public int insertSwJsStoress(Cbsd itemList) {
//id,sn

        CbsbsVo cbsbsVo = new CbsbsVo();
        cbsbsVo.setCbsb01(itemList.getCbsb01());
        List<CbsbsVo> cbsbsVos = selectSwJsTaskGoodsRelListss(cbsbsVo);

        if(cbsbsVos.get(0).getSaoma()!=null){
            double v = cbsbsVos.get(0).getSaoma().doubleValue();

            if( v==cbsbsVos.get(0).getNums()){
            throw new SwException("该销售出库单已扫描完成");
        }
        }

        if(itemList==null){
            throw new SwException("请扫描商品");
        }
        if (itemList.getCbsb01() == null) {
            throw new SwException("销售出库单主表id不能为空");
        }
        Cbsb cbsb2s = cbsbMapper.selectByPrimaryKey(itemList.getCbsb01());
        if(cbsb2s==null){
            throw new SwException("销售出库单主表不存在");
        }
        Integer storeid = cbsb2s.getCbsb10();
        CbscCriteria cas = new CbscCriteria();
        cas.createCriteria().andCbsb01EqualTo(itemList.getCbsb01())
                .andCbsc07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsc> cbphs = cbscMapper.selectByExample(cas);
        if (cbphs.size() == 0) {
            throw new SwException("销售出库单明细为空");
        }
        List<Integer> goodsids = cbphs.stream().map(Cbsc::getCbsc08).collect(Collectors.toList());
        Set<Integer> uio = new HashSet<>(goodsids);



        Cbsb cbsb1 = cbsbMapper.selectByPrimaryKey(itemList.getCbsb01());
        if (!cbsb1.getCbsb11().equals(TaskStatus.sh.getCode())) {
            throw new SwException(" 审核状态才能扫码");
        }
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbsdMapper mapper = session.getMapper(CbsdMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
            CbsdCriteria IOP = new CbsdCriteria();
            IOP.createCriteria().andCbsd09EqualTo(itemList.getCbsd09());
            List<Cbsd> cbsds = cbsdMapper.selectByExample(IOP);
            if (cbsds.size() > 0) {
                throw new SwException("SN码已存在销售出库扫码记录");
            }

            CbpmCriteria examplew = new CbpmCriteria();
            examplew.createCriteria().andCbpm09EqualTo(itemList.getCbsd09());
            List<Cbpm> cbpms = cbpmMapper.selectByExample(examplew);

/*            GsGoodsSnCriteria examples = new GsGoodsSnCriteria();
            examples.createCriteria().andSnEqualTo( itemList.get(i).getCbsd09());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(examples);*/
            if(cbpms.size()==0){
                throw new SwException("该sn不存在");
            }

/*if(gsGoodsSns.get(0).getLocationId()==null){
    throw new SwException("库位id为空");

}*/
            Cbla cbla = cblaMapper.selectByPrimaryKey(cbpms.get(0).getCbpm10());
            if (cbla == null) {
                throw new SwException("库位不存在");
            }
            if (!cbla.getCbla10().equals(storeid)) {
                throw new SwException("库位不属于该仓库");
            }

            if (cbpms.get(0).getCbpm08() == null) {
                throw new SwException("商品id不能为空");
            }
            if(!uio.contains(cbpms.get(0).getCbpm08())){
                throw new SwException("该商品不在销售出库单明细中");
            }


            itemList.setCbsd03(date);
            itemList.setCbsd04(Math.toIntExact(userid));
            itemList.setCbsd05(date);
            itemList.setCbsd06(Math.toIntExact(userid));
            itemList.setCbsd08(cbpms.get(0).getCbpm08());
            itemList.setCbsd10(cbpms.get(0).getCbpm10());
            itemList.setCbsd07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.setCbsd11(ScanStatusEnum.YISAOMA.getCode());
            itemList.setUserId(Math.toIntExact(userid));
            itemList.setCbsb01(itemList.getCbsb01());

            //如果查不到添加信息到库存表
            Cbsb cbsb = cbsbMapper.selectByPrimaryKey(itemList.getCbsb01());
            //判断是否在提货单里
            CbpkCriteria example = new CbpkCriteria();
            example.createCriteria().andCbpk09EqualTo(cbsb.getCbsb09())
                    .andCbpk01EqualTo(cbsb.getCbsb20());
//                    .andCheckStatusEqualTo(checkstatusEnum.ZJWC.getCode());
            List<Cbpk> cbpkList = cbpkMapper.selectByExample(example);
            if(cbpkList.size()==0){
                throw new SwException("该商品不在提货单里");
            }
            //更新sn表
            GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setSn(itemList.getCbsd09());
            gsGoodsSnDo.setStatus(GoodsType.ckz.getCode());
            gsGoodsSnDo.setOutTime(date);
            gsGoodsSnDo.setGroudStatus(Groudstatus.XJ.getCode());
            taskService.updateGsGoodsSn(gsGoodsSnDo);

          /* GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
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

            }*/


        cbsdMapper.insertSelective(itemList);

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

    @Override
    public void Selloutofwarehouseeditone(CbsbDo cbsbDo) {
        if(cbsbDo.getCbsb01()==null){
            throw new SwException("销售出库单id不能为空");
        }
        List<Cbsc> goods = cbsbDo.getGoods();
        if(goods==null||goods.size()==0){
            throw new SwException("请至少添加一件货物");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();

        Cbsb cbsb = BeanCopyUtils.coypToClass(cbsbDo, Cbsb.class, null);
        cbsb.setCbsb01(cbsbDo.getCbsb01());
        cbsb.setCbsb04(date);
        cbsb.setCbsb05(Math.toIntExact(userid));
        cbsbMapper.updateByPrimaryKeySelective(cbsb);

        CbscCriteria example1 = new CbscCriteria();
        example1.createCriteria().andCbsc01EqualTo(cbsbDo.getCbsb01());
        int i = cbscMapper.deleteByExample(example1);


        Cbsc cbsc = null;
        for (Cbsc good : goods) {
            cbsc = new Cbsc();
            if(good.getCbsc01()==null){
                throw new SwException("销售出库单明细id不能为空");
            }
            cbsc.setCbsc01(good.getCbsc01());
            cbsc.setCbsc02(good.getCbsc02());
            cbsc.setCbsc03(good.getCbsc03());
            cbsc.setCbsc04(good.getCbsc04());
            cbsc.setCbsc05(date);
            cbsc.setCbsc06(Math.toIntExact(userid));
            cbsc.setCbsc07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbsc.setCbsc08(good.getCbsc08());
            cbsc.setCbsc09(good.getCbsc09());
            cbsc.setCbsc10(good.getCbsc10());
            cbsc.setCbsc11(good.getCbsc11());
            cbsc.setCbsc12(good.getCbsc12());
            cbsc.setCbsc13(good.getCbsc13());
            cbsc.setCbsc15(good.getCbsc15());
            cbsc.setCbsc16(good.getCbsc16());
            cbsc.setCbsc17(good.getCbsc17());

            CbscCriteria example = new CbscCriteria();
            example.createCriteria().andCbsc01EqualTo(good.getCbsc01());
            cbscMapper.insertSelective(cbsc);
        }
        return;
    }

}
