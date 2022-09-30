package com.ruoyi.framework.web.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISalesreturnordersService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SalesreturnordersServiceImpl implements ISalesreturnordersService {

    @Resource
    private CbseMapper cbseMapper;

    @Resource
    private CbsfMapper cbsfMapper;

    @Resource
    private CbsgMapper cbsgMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    private  NumberGenerate numberGenerate;

    @Resource
    private TaskService taskService;

    @Resource
    private CbsaMapper cbsaMapper;

    @Resource
    private BaseCheckService baseCheckService;


    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;
    /**
     * 新增销售退库单主表
     */
    @Transactional
    @Override
    public IdVo insertSelloutofwarehouse(CbseDo cbseDo) {

        Long userid = SecurityUtils.getUserId();
        String salesreturnordersNo = numberGenerate.getSalesreturnordersNo(cbseDo.getCbse10());
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        Date date = new Date();
        cbse.setCbse02(date);
        cbse.setCbse03(Math.toIntExact(userid));
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbse.setCbse06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbse.setCbse07(salesreturnordersNo);
        cbse.setCbse08(date);
        cbse.setCbse11(TaskStatus.mr.getCode());
        cbse.setUserId(Math.toIntExact(userid));
        cbseMapper.insertSelective(cbse);
        CbseCriteria example1 = new CbseCriteria();
        example1.createCriteria().andCbse07EqualTo(salesreturnordersNo)
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbse> cbsess = cbseMapper.selectByExample(example1);
        IdVo idVo = new IdVo();
        idVo.setId(cbsess.get(0).getCbse01());
        return idVo;
    }
    /**
     * 新增销售退库单明细表
     */
    @Transactional
    @Override
    public int insertSwJsStores(List<Cbsf> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbsfMapper mapper = session.getMapper(CbsfMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbsf03(date);
            itemList.get(i).setCbsf04(Math.toIntExact(userid));
            itemList.get(i).setCbsf05(date);
            itemList.get(i).setCbsf06(Math.toIntExact(userid));
            itemList.get(i).setCbsf07(DeleteFlagEnum.NOT_DELETE.getCode());
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
     * 销售退库单审核
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodesh(CbseDo cbseDo) {
        //校验审核状态
        CbseCriteria example = new CbseCriteria();
        example.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbse> cbses = cbseMapper.selectByExample(example);
        if(!cbses.get(0).getCbse11().equals(TaskStatus.mr.getCode())){
            throw new SwException("未审核状态才能审核");
        }
        Long userid = SecurityUtils.getUserId();
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        Date date = new Date();
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbse.setCbse11(TaskStatus.sh.getCode());
        CbseCriteria example1 = new CbseCriteria();
        example1.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbseMapper.updateByExampleSelective(cbse,example1);
    }
    /**
     * 销售退库单反审
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodesf(CbseDo cbseDo) {

        CbsgCriteria example2 = new CbsgCriteria();
        example2.createCriteria().andCbse01EqualTo(cbseDo.getCbse01());
        List<Cbsg> cbpes = cbsgMapper.selectByExample(example2);
        if(cbpes.size()>0 ){
            int size = cbpes.size();
            for(int i=0;i<size;i++){
                if(cbpes.get(i).getCbsg11().equals(ScanStatusEnum.YISAOMA.getCode())) {

                    throw new SwException("已扫码不能反审");
                }
            }
        }
        //校验审核状态
        CbseCriteria example = new CbseCriteria();
        example.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbse> cbses = cbseMapper.selectByExample(example);
        if(!cbses.get(0).getCbse11().equals(TaskStatus.sh.getCode())){
            throw new SwException("审核状态才能反审");
        }


        Long userid = SecurityUtils.getUserId();
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        Date date = new Date();
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbse.setCbse11(TaskStatus.mr.getCode());
        CbseCriteria example1 = new CbseCriteria();
        example1.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbseMapper.updateByExampleSelective(cbse,example1);
    }
    /**
     * 销售退库单取消完成
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodeqxwc(CbseDo cbseDo) {

        CbsgCriteria example2 = new CbsgCriteria();
        example2.createCriteria().andCbse01EqualTo(cbseDo.getCbse01());
        List<Cbsg> cbpes = cbsgMapper.selectByExample(example2);
        if(cbpes.size()>0 ){
            int size = cbpes.size();
            for(int i=0;i<size;i++){
                if(cbpes.get(i).getCbsg11().equals(ScanStatusEnum.YISAOMA.getCode())) {

                    throw new SwException("已扫码不能取消完成");
                }
            }
        }
        //校验审核状态
        CbseCriteria example = new CbseCriteria();
        example.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbse> cbses = cbseMapper.selectByExample(example);
        if(!cbses.get(0).getCbse11().equals(TaskStatus.bjwc.getCode())){
            throw new SwException("标记完成状态才能取消完成");
        }
        Long userid = SecurityUtils.getUserId();
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        Date date = new Date();
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbse.setCbse11(TaskStatus.sh.getCode());
        CbseCriteria example1 = new CbseCriteria();
        example1.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbseMapper.updateByExampleSelective(cbse,example1);    }

    @Override
    public int insertSwJsSkuBarcodebjwc(CbseDo cbseDo) {
        //校验审核状态
        CbseCriteria example = new CbseCriteria();
        example.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbse> cbses = cbseMapper.selectByExample(example);
        if(cbses.get(0).getCbse11().equals(TaskStatus.sh.getCode())||cbses.get(0).getCbse11().equals(TaskStatus.fsh.getCode())){}
        else{
            throw new SwException("审核状态才能标记完成");
        }
        Long userid = SecurityUtils.getUserId();
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        Date date = new Date();
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbse.setCbse11(TaskStatus.bjwc.getCode());
        CbseCriteria example1 = new CbseCriteria();
        example1.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        CbsfCriteria example3 = new CbsfCriteria();
        example.createCriteria().andCbse01EqualTo(cbseDo.getCbse01());
        List<Cbsf> cbsfs = cbsfMapper.selectByExample(example3);
        if(cbsfs.size()==0){
            throw new SwException("销售退货单明细表为空");
        }

        List<Cbsg> cbsgs=null;
        for(int j=0;j<cbsfs.size();j++){
        CbsgCriteria example2 = new CbsgCriteria();
             example2.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                     .andCbsg08EqualTo(cbsfs.get(j).getCbsf08());
     cbsgs = cbsgMapper.selectByExample(example2);
        if(cbsgs.size()==0){
            throw new SwException("没有扫码记录");

        }
            double num = cbsgs.size();

        for(int i=0;i<cbsgs.size();i++){
            GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
            if(cbsgs.get(i).getCbsg10()==null){
                throw new SwException("销售退库没有库位信息");
            }
            gsGoodsSkuDo.setLocationId(cbsgs.get(i).getCbsg10());
            //获取仓库id
            gsGoodsSkuDo.setWhId(cbse.getCbse10());
            //获取商品id
            gsGoodsSkuDo.setGoodsId(cbsgs.get(i).getCbsg08());
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
                if (qty == 0) {
                    throw new SwException("库存数量不足");
                }
                //获取仓库id
                gsGoodsSkuDo1.setWhId(cbse.getCbse10());
                //获取商品id
                gsGoodsSkuDo1.setGoodsId(cbsgs.get(i).getCbsg08());
                gsGoodsSkuDo1.setLocationId(cbsgs.get(i).getCbsg10());
             /*   if(num>qty){
                    throw new SwException("退库数量大于库存数量");
                }*/
                gsGoodsSkuDo1.setQty(qty - 1);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);
            }


            }
        CbibDo cbibDo = new CbibDo();
        cbibDo.setCbib02(cbse.getCbse10());
        cbibDo.setCbib03(cbse.getCbse07());
        cbibDo.setCbib05(String.valueOf(TaskType.xcckd.getCode()));
        Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbsfs.get(j).getCbsf15());

        cbibDo.setCbib06(cbsa.getCbsa08());
        cbibDo.setCbib07(cbsfs.get(j).getCbsf01());
        cbibDo.setCbib08(cbsgs.get(j).getCbsg08());
        //本次入库数量
        cbibDo.setCbib11((double) 0);
        cbibDo.setCbib12((double) 0);
        cbibDo.setCbib13(num);
        cbibDo.setCbib14(num*cbsfs.get(0).getCbsf11());
        cbibDo.setCbib17(TaskType.xstkd.getMsg());
        cbibDo.setCbib19(cbsfs.get(j).getCbsf15());
        taskService.InsertCBIB(cbibDo);
        }
        return cbseMapper.updateByExampleSelective(cbse,example1);    }

    @Override
    public int insertSwJsSkuBarcodel(CbseDo cbseDo) {
        Cbse cbse1 = cbseMapper.selectByPrimaryKey(cbseDo.getCbse01());
        if(!cbse1.getCbse11().equals(TaskStatus.mr.getCode())){
            throw new SwException("未审核状态才能删除");
        }
        Long userid = SecurityUtils.getUserId();
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        Date date = new Date();
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbse.setCbse06(DeleteFlagEnum.DELETE.getCode());
        CbseCriteria example1 = new CbseCriteria();
        example1.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbseMapper.updateByExampleSelective(cbse,example1);    }

    @Override
    public List<CbseVo> selectSwJsTaskGoodsRelLists(CbseVo cbsbVo) {

        return cbseMapper.selectSwJsTaskGoodsRelLists(cbsbVo); }

    @Override
    public List<CbsesVo> selectSwJsTaskGoodsRelListss(CbsesVo cbsesVo) {
        List<CbsesVo> cbsesVos = cbseMapper.selectSwJsTaskGoodsRelListss(cbsesVo);
        CbsesVo res = new CbsesVo();
        List<ScanVo> goods = res.getGoods();

        Integer cbse01 = cbsesVo.getCbse01();
        if(cbse01==null){
            throw new SwException("销售退库单id不能为空");
        }
        CbsgCriteria example1 = new CbsgCriteria();
        example1.createCriteria().andCbse01EqualTo(cbse01);
        List<Cbsg> cbsgss = cbsgMapper.selectByExample(example1);
        Double sum = 0.0;

if(cbsgss.size()>0){
    Integer saoma = 0;

    for(int i=0;i<cbsesVos.size();i++) {
            CbsgCriteria example = new CbsgCriteria();
            example.createCriteria().andCbse01EqualTo(cbse01)
                    .andCbsg08EqualTo(cbsesVos.get(i).getCbsf08());
            List<Cbsg> cbsgs = cbsgMapper.selectByExample(example);
            int size = cbsgs.size();
            if (size > 0) {
                for (int j = 0; j < size; j++) {
                    ScanVo scanVo = new ScanVo();
                    scanVo.setLx(cbsesVos.get(i).getCbpa08());
                    scanVo.setPinpai(cbsesVos.get(i).getPinpai());
                    scanVo.setCbpb08(cbsesVos.get(i).getCbpb08());
                    scanVo.setCbpb12(cbsesVos.get(i).getCbpb12());
                    scanVo.setSn(cbsgs.get(j).getCbsg09());
                    scanVo.setKwm(cbsesVos.get(i).getCbla09());
                    scanVo.setCbpe03(cbsgs.get(j).getCbsg03());
                    scanVo.setUpc(cbsesVos.get(i).getCbpb15());
                    goods.add(scanVo);
                }

                cbsesVos.get(i).setSaoma(size);
                saoma += cbsesVos.get(i).getSaoma();


            cbsesVos.get(0).setGoods(goods);
        }
        }
    cbsesVos.get(0).setSaomanums(saoma);

}
        for(int i=0;i<cbsesVos.size();i++){
            sum+=cbsesVos.get(i).getCbsf09();
        }
        cbsesVos.get(0).setNums(sum);

        return cbsesVos;
    }
    @Transactional
    @Override
    public int insertSwJsStoress(List<Cbsg> itemList) {
        if (itemList.size() == 0) {
            throw new SwException("请选择要扫的商品");
        }
        Cbse cbse1 = cbseMapper.selectByPrimaryKey(itemList.get(0).getCbse01());
        if(!cbse1.getCbse11().equals(TaskStatus.sh.getCode())){
            throw new SwException("审核状态才能扫码");
        }

        CbsfCriteria cas = new CbsfCriteria();
        cas.createCriteria().andCbse01EqualTo(itemList.get(0).getCbse01());
        List<Cbsf> cbphs = cbsfMapper.selectByExample(cas);
        if (cbphs.size() == 0) {
            throw new SwException("销售退库单明细为空");
        }
        List<Integer> goodsids = cbphs.stream().map(Cbsf::getCbsf08).collect(Collectors.toList());
        Set<Integer> uio = new HashSet<>(goodsids);



        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbsgMapper mapper = session.getMapper(CbsgMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            if(itemList.get(i).getCbsg09()==null){
                throw new SwException("商品sn不能为空");
            }

            GsGoodsSnCriteria examples = new GsGoodsSnCriteria();
            examples.createCriteria().andSnEqualTo( itemList.get(i).getCbsg09());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(examples);
            if(gsGoodsSns.size()==0){
                throw new SwException("该sn不存在与库存表");
            }

            if(!uio.contains(gsGoodsSns.get(0).getGoodsId())){
                throw new SwException("该商品不在采购退货单明细中");
            }
            itemList.get(i).setCbsg03(date);
            itemList.get(i).setCbsg04(Math.toIntExact(userid));
            itemList.get(i).setCbsg05(date);
            itemList.get(i).setCbsg06(Math.toIntExact(userid));
            itemList.get(i).setCbsg07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));

            //如果查不到添加信息到库存表
            Cbse cbse = cbseMapper.selectByPrimaryKey(itemList.get(i).getCbse01());
   /*         GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
            //获取仓库id
            gsGoodsSkuDo.setWhId(cbse.getCbse10());
            //获取商品id
            gsGoodsSkuDo.setGoodsId(itemList.get(i).getCbsg08());
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
                gsGoodsSkuDo1.setWhId(cbse.getCbse10());
                //获取商品id
                gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbsg08());
                gsGoodsSkuDo1.setLocationId(itemList.get(i).getCbsg10());
                gsGoodsSkuDo1.setQty(qty-1);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);

            }*/


            //更新sn表
            GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setSn(itemList.get(i).getCbsg09());
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
        Cbse cbse = cbseMapper.selectByPrimaryKey(itemList.get(0).getCbse01());
        if(cbse==null){
            throw new SwException("没有该销售退库单");
        }
        CbsfCriteria example = new CbsfCriteria();
        example.createCriteria().andCbse01EqualTo(cbse.getCbse01())
                .andCbsf07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsf> cbscs = cbsfMapper.selectByExample(example);
        if(cbscs.size()==0){
            throw new SwException("没有该销售出库单明细表为空");
        }

/*
        for(int i=0;i<cbscs.size();i++){
            CbibDo cbibDo = new CbibDo();
            cbibDo.setCbib02(cbse.getCbse10());
            cbibDo.setCbib03(cbse.getCbse07());
            cbibDo.setCbib05(String.valueOf(TaskType.xcckd.getCode()));
            Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbscs.get(i).getCbsf15());

            cbibDo.setCbib06(cbsa.getCbsa08());
            cbibDo.setCbib07(cbscs.get(i).getCbsf01());
            cbibDo.setCbib08(cbscs.get(i).getCbsf08());
            //本次入库数量
            cbibDo.setCbib11((double) 0);
            cbibDo.setCbib12((double) 0);
            cbibDo.setCbib13(cbscs.get(i).getCbsf09());
            cbibDo.setCbib14(cbscs.get(i).getCbsf11());
            cbibDo.setCbib17(TaskType.xstkd.getMsg());
            cbibDo.setCbib19(cbscs.get(i).getCbsf15());
            taskService.InsertCBIB(cbibDo);
        }
*/
//        CbseDo cbseDo = new CbseDo();
//        cbseDo.setCbse01(itemList.get(0).getCbse01());
       // this.insertSwJsSkuBarcodebjwc(cbseDo);
        session.commit();
        session.clearCache();
        return 1;
    }
    @Transactional
    @Override
    public int insertSwJsSkuBarcodergqr(CbseDo cbseDo) {
        //查主表
        Cbse cbse = cbseMapper.selectByPrimaryKey(cbseDo.getCbse01());

        CbsfCriteria example = new CbsfCriteria();
        example.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbsf07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsf> cbsfs = cbsfMapper.selectByExample(example);
        if(cbsfs.size()==0){
            throw new SwException("没有销售退货单明细表信息");
        }
        for(int i=0;i<cbsfs.size();i++) {
            //获取数量
            Double nums = cbsfs.get(i).getCbsf09();

            GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();

            //获取仓库id
            gsGoodsSkuDo.setWhId(cbse.getCbse10());
            //获取商品id
            gsGoodsSkuDo.setGoodsId(cbsfs.get(i).getCbsf08());
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
                gsGoodsSkuDo1.setWhId(cbse.getCbse10());
                //获取商品id
                gsGoodsSkuDo1.setGoodsId(cbsfs.get(i).getCbsf08());
              //  gsGoodsSkuDo1.setLocationId(itemList.get(i).getCbsg10());
                if(nums>qty){
                    throw new SwException("库存数量不足");
                }
                gsGoodsSkuDo1.setQty(qty - nums);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);

            }
        }
        //更新sn表
      /*  GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
        gsGoodsSnDo.setSn(itemList.get(i).getCbsg09());
        gsGoodsSnDo.setStatus(GoodsType.yck.getCode());
        gsGoodsSnDo.setOutTime(date);
        gsGoodsSnDo.setGroudStatus(Groudstatus.XJ.getCode());
        taskService.updateGsGoodsSn(gsGoodsSnDo);*/

        return 1;
    }

    @Override
    public void Selloutofwarehousedeitone(CbseDo cbseDo) {
        List<Cbsf> goods = cbseDo.getGoods();

        if(goods==null||goods.size()==0){
            throw new SwException("请至少添加一件货物");
        }
        if(cbseDo.getCbse01()==null){
            throw new SwException("销售出库单id不能为空");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        cbse.setCbse01(cbseDo.getCbse01());
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbseMapper.updateByPrimaryKeySelective(cbse);

        CbsfCriteria cbsfs = new CbsfCriteria();
        cbsfs.createCriteria().andCbse01EqualTo(cbseDo.getCbse01());
        List<Cbsf> cbsfs1 = cbsfMapper.selectByExample(cbsfs);
        if(cbsfs1.size()==0){
            throw new SwException("没有销售出库单明细表信息");
        }

        Set<Integer> uio = null;
        for (int i = 0; i < cbsfs1.size(); i++) {
            int id = cbsfs1.get(i).getCbsf01();
            uio = new HashSet<>();
            uio.add(id);
        }
        Cbsf cbsf = null;
        for(Cbsf good:goods){
         cbsf=new Cbsf();
         cbsf.setCbsf05(date);
            cbsf.setCbsf06(Math.toIntExact(userid));
            if(good.getCbsf01()==null){
                throw new SwException("销售出库单明细id不能为空");
            }
            if(!uio.contains(good.getCbsf01())){
                throw new SwException("该商品不在销售出库单明细中");
            }
            cbsf.setCbsf01(good.getCbsf01());
            cbsf.setCbsf08(good.getCbsf08());
            cbsf.setCbsf09(good.getCbsf09());
            cbsf.setCbsf10(good.getCbsf10());
            cbsf.setCbsf11(good.getCbsf11());
            cbsf.setCbsf12(good.getCbsf12());
            cbsf.setCbsf13(good.getCbsf13());
            cbsf.setCbsf14(good.getCbsf14());
            cbsf.setCbsf15(good.getCbsf15());
            cbsf.setCbsf16(good.getCbsf16());
            CbsfCriteria example = new CbsfCriteria();
            example.createCriteria().andCbsf01EqualTo(good.getCbsf01());
            cbsfMapper.updateByExampleSelective(cbsf, example);
        }
        return;

    }


}
