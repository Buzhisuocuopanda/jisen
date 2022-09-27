package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.IWarehousetransferordersService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WarehousetransferordersServiceImpl implements IWarehousetransferordersService {
    @Resource
    private CbaaMapper cbaaMapper;

    @Resource
    private CbabMapper cbabMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;
    @Resource
    private NumberGenerate numberGenerate;

    @Resource
    private TaskService taskService;

    @Resource
    private CbsaMapper cbsaMapper;

    @Resource
    private BaseCheckService baseCheckService;

    @Resource
    private CbacMapper cbacMapper;

    @Resource
    private CblaMapper cblaMapper;
    @Transactional
    @Override
    public IdVo insertSwJsStore(CbaaDo cbaaDo) {

        Long userId = SecurityUtils.getUserId();
        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();
        cbaa.setCbaa02(date);
        cbaa.setCbaa03(Math.toIntExact(userId));
        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        cbaa.setCbaa06(DeleteFlagEnum.NOT_DELETE.getCode());

        String warehouseinitializationNo = numberGenerate.getWarehouseinitializationNos(cbaaDo.getCbaa10());

        cbaa.setCbaa07(warehouseinitializationNo);
        cbaa.setCbaa11(TaskStatus.mr.getCode());
        cbaa.setCbaa08(date);
        cbaa.setUserId(Math.toIntExact(userId));
        cbaaMapper.insertSelective(cbaa);
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa07EqualTo(warehouseinitializationNo)
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaas = cbaaMapper.selectByExample(example);
        IdVo idVo = new IdVo();
        idVo.setId(cbaas.get(0).getCbaa01());
        return idVo;
    }

    @Transactional
    @Override
    public int insertSwJsStores(List<Cbab> itemList) {
if(itemList.size()==0){
    throw new SwException("明细不能为空");
}
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbabMapper mapper = session.getMapper(CbabMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbab03(date);
            itemList.get(i).setCbab04(Math.toIntExact(userid));
            itemList.get(i).setCbab05(date);
            itemList.get(i).setCbab06(Math.toIntExact(userid));
            itemList.get(i).setCbab07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));
//            Cbaa cbaa = cbaaMapper.selectByPrimaryKey(itemList.get(i).getCbaa01());
//            //调出仓库id
//            Integer cbaa09 = cbaa.getCbaa09();
//            //调出仓库数量
//            Double qty = gsGoodsSkuMapper.selectByPrimaryKey(cbaa09).getQty();

            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次防止内存溢出
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
        return 1;
    }

    /**
     * 仓库调拨单列表
     */
    @Override
    public List<CbaaVo> selectSwJsTaskGoodsRelList(CbaaVo cbaaVo) {
        return cbaaMapper.selectSwJsTaskGoodsRelList(cbaaVo);
    }

    /**
     * 仓库调拨单查询
     */
    @Override
    public List<CbaaVo> selectSwJsTaskGoodsRelLists(CbaaVo cbaaVo) {
       return  cbaaMapper.selectSwJsTaskGoodsRelLists(cbaaVo);

    }

    /**
     * 仓库调拨单审核
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodesh(CbaaDo cbaaDo) {

        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (!cbaasw.get(0).getCbaa11().equals(TaskStatus.mr.getCode())) {
            throw new SwException("未审核状态才能审核");

        }
        Long userId = SecurityUtils.getUserId();

        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();

        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        cbaa.setCbaa11(TaskStatus.sh.getCode());
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbaaMapper.updateByExampleSelective(cbaa, example);
    }

    /**
     * 仓库调拨单反审
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodefs(CbaaDo cbaaDo) {
        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (!cbaasw.get(0).getCbaa11().equals(TaskStatus.sh.getCode())) {
            throw new SwException("审核状态才能反审");

        }
        Long userId = SecurityUtils.getUserId();

        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();

        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        cbaa.setCbaa11(TaskStatus.mr.getCode());
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbaaMapper.updateByExampleSelective(cbaa, example);


    }
    /**
     * 仓库调拨单标记完成
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodebjwc(CbaaDo cbaaDo) {

        Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(cbaaDo.getCbaa01());

        if(cbaa1==null){
            throw new SwException("该仓库调拨单不存在");
        }
        if (cbaa1.getCbaa11().equals(TaskStatus.sh.getCode())){}
        else {
            throw new SwException("审核状态才能标记完成");

        }
        Long userId = SecurityUtils.getUserId();

        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();

        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        cbaa.setCbaa11(TaskStatus.bjwc.getCode());
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        CbabCriteria example2 = new CbabCriteria();
        example2.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
        List<Cbab> cbabs1 = cbabMapper.selectByExample(example2);
        if(cbabs1.size() == 0){
            throw new SwException("该仓库调拨单明细不存在");
        }
        List<Cbac> cbacs=null;
      for(int i=0;i<cbabs1.size();i++) {
        CbacCriteria example3 = new CbacCriteria();
         example3.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
            .andCbac08EqualTo(cbabs1.get(i).getCbab08());
            cbacs = cbacMapper.selectByExample(example3);
            if(cbacs.size()==0){
                throw new SwException("该仓库调拨单扫码记录不存在");

            }
      }

        for(int j=0;j<cbacs.size();j++) {
            Double num = (double) cbacs.size();
            //调出仓库
        Integer outstore = cbaa.getCbaa09();
        Integer instore = cbaa.getCbaa10();
        GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
        //获取调出仓库id
        gsGoodsSkuDo.setWhId(outstore);
        //获取商品id
        gsGoodsSkuDo.setGoodsId(cbacs.get(j).getCbac08());
        gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
        //通过仓库id和货物id判断是否存在
        // 调出仓库
        List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
        if(gsGoodsSkus.size()==0){
            throw new SwException("调出仓库没有该货物");
        }
        else {
            //加锁
            baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
            GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
            //查出
            Double qty = gsGoodsSkus.get(0).getQty();
            if(qty==0){
                throw new SwException("调出仓库该货物数量为0");
            }
            gsGoodsSkuDo1.setGoodsId(gsGoodsSkus.get(0).getGoodsId());
            gsGoodsSkuDo1.setWhId(outstore);
            gsGoodsSkuDo1.setLocationId(gsGoodsSkus.get(j).getLocationId());

            double v1 = qty - num;
            gsGoodsSkuDo1.setQty(v1);
            taskService.updateGsGoodsSku(gsGoodsSkuDo1);


        }

        //调入仓库加
        GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
        //获取调入仓库id
        gsGoodsSkuDo1.setWhId(instore);
        //获取商品id
        gsGoodsSkuDo1.setGoodsId(cbacs.get(j).getCbac08());
        gsGoodsSkuDo1.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
        //通过仓库id和货物id判断是否存在
        List<GsGoodsSku> gsGoodsSkus1 = taskService.checkGsGoodsSku(gsGoodsSkuDo1);
        if(gsGoodsSkus1.size()==0){
            GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();
            gsGoodsSkuDo2.setGoodsId(cbacs.get(j).getCbac08());
            gsGoodsSkuDo2.setWhId(instore);
            gsGoodsSkuDo2.setLocationId(cbacs.get(j).getCbac10());
            gsGoodsSkuDo2.setQty(num);
            taskService.addGsGoodsSku(gsGoodsSkuDo2);
        }
        else {
            //加锁
            baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
            GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();

            gsGoodsSkuDo2.setGoodsId(gsGoodsSkus1.get(0).getGoodsId());
            gsGoodsSkuDo2.setWhId(instore);
            gsGoodsSkuDo2.setLocationId(gsGoodsSkus1.get(j).getLocationId());
            //查出
            Double qty = gsGoodsSkus1.get(0).getQty();
            double v = qty + num;
            gsGoodsSkuDo2.setQty(v);
            taskService.updateGsGoodsSku(gsGoodsSkuDo2);
        }

            //调入仓库
            Integer storeid = cbaa1.getCbaa10();
            //调出仓库
            Integer storeid1 = cbaa1.getCbaa09();
            //编号
            String number = cbaa1.getCbaa07();
            //单据id
            Integer id = cbaa1.getCbaa01();

            //查仓库调拨单明细表
            CbabCriteria example1 = new CbabCriteria();
            example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                    .andCbab07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbab> cbabs = cbabMapper.selectByExample(example1);
            for (int i = 0; i < cbabs.size(); i++) {
                //供应商名称
                Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbabs.get(i).getCbab14());
                String vendername = cbsa.getCbsa08();
                //商品id
                Integer goodsid = cbabs.get(i).getCbab08();

                //台账新增数据调入仓库
                CbibDo cbibDo = new CbibDo();
                cbibDo.setCbib02(storeid);
                cbibDo.setCbib03(number);
                cbibDo.setCbib05(String.valueOf(TaskType.xsthd.getCode()));
                cbibDo.setCbib06(vendername);
                cbibDo.setCbib07(id);
                cbibDo.setCbib08(goodsid);
                cbibDo.setCbib11(cbabs.get(i).getCbab09());
                cbibDo.setCbib12(cbabs.get(i).getCbab12());
                cbibDo.setCbib13((double) 0);
                cbibDo.setCbib14((double) 0);

                cbibDo.setCbib17(TaskType.cqrk.getMsg());
                cbibDo.setCbib19(cbabs.get(i).getCbab14());
                taskService.InsertCBIB(cbibDo);

                //台账新增数据调出仓库
                CbibDo cbibDo1 = new CbibDo();
                cbibDo1.setCbib02(storeid1);
                cbibDo1.setCbib03(number);
                cbibDo1.setCbib05(String.valueOf(TaskType.zjd.getCode()));
                cbibDo1.setCbib06(vendername);
                cbibDo1.setCbib07(id);
                cbibDo1.setCbib08(goodsid);
                cbibDo1.setCbib11((double) 0);
                cbibDo1.setCbib12((double) 0);
                cbibDo1.setCbib13(cbabs.get(i).getCbab09());
                cbibDo1.setCbib14(cbabs.get(i).getCbab12());

                cbibDo1.setCbib17(TaskType.cqrk.getMsg());
                cbibDo1.setCbib19(cbabs.get(i).getCbab14());
                taskService.InsertCBIB(cbibDo1);

            }

        }
        return cbaaMapper.updateByExampleSelective(cbaa, example);
    }
    /**
     * 仓库调拨单取消完成
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodeqxwc(CbaaDo cbaaDo) {
        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (!cbaasw.get(0).getCbaa11().equals(TaskStatus.bjwc.getCode())) {
            throw new SwException("标记完成才能取消完成");

        }
        Long userId = SecurityUtils.getUserId();

        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();

        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        cbaa.setCbaa11(TaskStatus.sh.getCode());
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbaaMapper.updateByExampleSelective(cbaa, example);
    }
    /**
     * 仓库调拨单修改
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodeupdate(CbaaDo cbaaDo) {
        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (!cbaasw.get(0).getCbaa11().equals(TaskStatus.mr.getCode())) {
            throw new SwException("默认才能修改");

        }
        Long userId = SecurityUtils.getUserId();

        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();
        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbaaMapper.updateByExampleSelective(cbaa, example);
    }

    @Override
    public List<CbaasVo> selectSwJsTaskGoodsRelListss(CbaasVo cbaasVo) {
        List<CbaasVo> cbaasVos = cbaaMapper.selectSwJsTaskGoodsRelListss(cbaasVo);

        CbaasVo res = new CbaasVo();
        List<ScanVo> goods = res.getGoods();

        Integer cbaa01 = cbaasVo.getCbaa01();
        if(cbaa01==null){
            throw new SwException("调拨单id不能为空");
        }
        CbacCriteria example2 = new CbacCriteria();
        example2.createCriteria().andCbac02EqualTo(cbaa01);
        List<Cbac> cbacss = cbacMapper.selectByExample(example2);

if(cbacss.size()>0) {
    for (int i = 0; i < cbaasVos.size(); i++) {
        CbacCriteria example = new CbacCriteria();
        example.createCriteria().andCbaa01EqualTo(cbaa01)
                .andCbac08EqualTo(cbaasVos.get(i).getCbab08());
        List<Cbac> cbacs = cbacMapper.selectByExample(example);
        int size = cbacs.size();
        for (int j = 0; j < size; j++) {
            ScanVo scanVo = new ScanVo();
            scanVo.setLx(cbaasVos.get(i).getCbpa08());
            scanVo.setPinpai(cbaasVos.get(i).getPinpai());
            scanVo.setCbpb08(cbaasVos.get(i).getCbpb08());
            scanVo.setCbpb12(cbaasVos.get(i).getCbpb12());
            scanVo.setSn(cbacs.get(j).getCbac09());
            scanVo.setKwm(cbaasVos.get(i).getCbla09());
            scanVo.setCbpe03(cbacs.get(j).getCbac03());
            goods.add(scanVo);
        }
        cbaasVos.get(i).setSaoma(size);
    }
    cbaasVos.get(0).setGoods(goods);
}
        return cbaasVos;
    }

    @Transactional
    @Override
    public int insertSwJsStoress(List<Cbac> itemList) {
        if(itemList.size() == 0){
            throw new SwException("请选择要扫描商品");
        }
        if(itemList.get(0).getCbaa01() == null){
            throw new SwException("调拨单主表id不能为空");
        }
        Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(itemList.get(0).getCbaa01());
        if (!cbaa1.getCbaa11().equals(TaskStatus.sh.getCode())) {
            throw new SwException("审核状态才能扫码");
        }
        Integer outstore = cbaa1.getCbaa09();
        Integer instore = cbaa1.getCbaa10();

        CbabCriteria cas = new CbabCriteria();
        cas.createCriteria().andCbaa01EqualTo(itemList.get(0).getCbaa01())
                .andCbab07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbab> cbphs = cbabMapper.selectByExample(cas);
        if (cbphs.size() == 0) {
            throw new SwException("调拨单明细为空");
        }
        Set<Integer> uio = null;
        for (int i = 0; i < cbphs.size(); i++) {
            Integer cbph08 = cbphs.get(i).getCbab08();
            uio = new HashSet<>();
            uio.add(cbph08);
        }

        Integer cbaa09 = cbaa1.getCbaa09();
        GsGoodsSkuCriteria example5 = new GsGoodsSkuCriteria();
        example5.createCriteria().andWhIdEqualTo(cbaa09);
        List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example5);
        if (gsGoodsSkus.size() == 0) {
            throw new SwException("调出仓库不存在库存中");
        }
        Set<Integer> nio = null;
        for (int i = 0; i < gsGoodsSkus.size(); i++) {
            Integer cbph08 = gsGoodsSkus.get(i).getWhId();
            nio = new HashSet<>();
            nio.add(cbph08);
        }

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbacMapper mapper = session.getMapper(CbacMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {

            if (itemList.get(i).getCbac08() == null) {
                throw new SwException("商品id不能为空");
            }
            if(!uio.contains(itemList.get(i).getCbac08())){
                throw new SwException("该商品不在采购退货单明细中");
            }

            if(!nio.contains(itemList.get(i).getCbac08())){
                throw new SwException("该商品不在调出仓库中");
            }

            Cbla cbla = cblaMapper.selectByPrimaryKey(itemList.get(i).getCbac10());
            if (cbla == null) {
                throw new SwException("库位不存在");
            }
            if (!cbla.getCbla03().equals(instore)) {
                throw new SwException("调入仓库没有该库位");
            }
            String sn = itemList.get(i).getCbac09();
            CbacCriteria erd = new CbacCriteria();
            erd.createCriteria().andCbac09EqualTo(sn)
                    .andCbac07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbac> cbpiList = cbacMapper.selectByExample(erd);
            if (cbpiList.size() > 0) {
                throw new SwException("该sn已存在");
            }
            //校验sn库存表李是否有该sn
            GsGoodsSnDo gsGoodsSnDoss = new GsGoodsSnDo();
            gsGoodsSnDoss.setSn(sn);
            baseCheckService.checkGsGoodsSn(gsGoodsSnDoss);

            itemList.get(i).setCbac03(date);
            itemList.get(i).setCbac04(Math.toIntExact(userid));
            itemList.get(i).setCbac05(date);
            itemList.get(i).setCbac06(Math.toIntExact(userid));
            itemList.get(i).setCbac07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));

           /* //如果查不到添加信息到库存表
            Cbaa cbaa = cbaaMapper.selectByPrimaryKey(itemList.get(i).getCbaa01());
            if(cbaa==null){
                throw new SwException("调拨单不存在");
            }
            //调出仓库
            Integer outstore = cbaa.getCbaa09();
            Integer instore = cbaa.getCbaa10();
            GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
            //获取调出仓库id
            gsGoodsSkuDo.setWhId(outstore);
            //获取商品id
            gsGoodsSkuDo.setGoodsId(itemList.get(i).getCbac08());
            gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //通过仓库id和货物id判断是否存在
            // 调出仓库
            List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
            if(gsGoodsSkus.size()==0){
             throw new SwException("调出仓库没有该货物");
            }
            else {
                //加锁
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                //查出
                Double qty = gsGoodsSkus.get(0).getQty();
                if(qty==0){
                    throw new SwException("调出仓库该货物数量为0");
                }
                gsGoodsSkuDo1.setGoodsId(gsGoodsSkus.get(0).getGoodsId());
                gsGoodsSkuDo1.setWhId(outstore);
                gsGoodsSkuDo1.setLocationId(gsGoodsSkus.get(i).getLocationId());
                double v = 1.0;
                double v1 = qty - v;
                gsGoodsSkuDo1.setQty(v1);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);


            }

            //调入仓库加
            GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
            //获取调入仓库id
            gsGoodsSkuDo1.setWhId(instore);
            //获取商品id
            gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbac08());
            gsGoodsSkuDo1.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //通过仓库id和货物id判断是否存在
            List<GsGoodsSku> gsGoodsSkus1 = taskService.checkGsGoodsSku(gsGoodsSkuDo1);
            if(gsGoodsSkus1.size()==0){
                GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();
                gsGoodsSkuDo2.setGoodsId(itemList.get(i).getCbac08());
                gsGoodsSkuDo2.setWhId(instore);
                gsGoodsSkuDo2.setLocationId(itemList.get(i).getCbac10());
                gsGoodsSkuDo2.setQty(1.0);
                taskService.addGsGoodsSku(gsGoodsSkuDo2);
            }
            else {
                //加锁
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();

                gsGoodsSkuDo2.setGoodsId(gsGoodsSkus1.get(0).getGoodsId());
                gsGoodsSkuDo2.setWhId(instore);
                gsGoodsSkuDo2.setLocationId(gsGoodsSkus1.get(i).getLocationId());
                //查出
                Double qty = gsGoodsSkus1.get(0).getQty();
                double v = qty + 1.0;
                gsGoodsSkuDo2.setQty(v);
                taskService.updateGsGoodsSku(gsGoodsSkuDo2);

            }*/
            //更新sn表
            GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setSn(itemList.get(i).getCbac09());
            gsGoodsSnDo.setStatus(GoodsType.yrk.getCode());
            gsGoodsSnDo.setOutTime(date);
            gsGoodsSnDo.setGroudStatus(Groudstatus.SJ.getCode());
            taskService.updateGsGoodsSn(gsGoodsSnDo);

            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次防止内存溢出
                session.commit();
                session.clearCache();
            }
        }
//        CbaaDo cbaaDo = new CbaaDo();
//        cbaaDo.setCbaa01(itemList.get(0).getCbaa01());
//        this.insertSwJsSkuBarcodebjwc(cbaaDo);
        session.commit();
        session.clearCache();
        return 1;    }

    @Override
    public void Warehousetransferorderseditone(CbaaDo cbaaDo) {
        if(cbaaDo.getCbaa01()==null){
            throw new SwException("调拨单id不能为空");
        }
        List<Cbab> goods = cbaaDo.getGoods();
        if(goods==null||goods.size()==0){
            throw new SwException("请至少添加一件货物");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        cbaa.setCbaa01(cbaaDo.getCbaa01());
        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userid));
        cbaaMapper.updateByPrimaryKeySelective(cbaa);

        Cbab cbab = null;
        for (Cbab good : goods) {
            cbab = new Cbab();
            if(good.getCbab01()==null){
                throw new SwException("调拨单明细id不能为空");
            }
            cbab.setCbab01(good.getCbab01());

            cbab.setCbab04(Math.toIntExact(userid));
            cbab.setCbab05(date);
            cbab.setCbab06(good.getCbab06());
            cbab.setCbab07(good.getCbab07());
            cbab.setCbab08(good.getCbab08());
            cbab.setCbab09(good.getCbab09());
            cbab.setCbab10(good.getCbab10());
            cbab.setCbab11(good.getCbab11());
            cbab.setCbab12(good.getCbab12());
            cbab.setCbab13(good.getCbab13());
            cbab.setCbab14(good.getCbab14());
            cbab.setCbab15(good.getCbab15());
            cbab.setCbab16(good.getCbab16());
            cbab.setCbab17(good.getCbab17());
     cbabMapper.updateByPrimaryKeySelective(cbab);

        }
            return;
        }

    @Override
    public int Selloutofwarehousedel(CbaaDo cbaaDo) {
if(cbaaDo.getCbaa01()==null){
            throw new SwException("调拨单id不能为空");
        }
        Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(cbaaDo.getCbaa01());
if(cbaa1==null){
            throw new SwException("调拨单不存在");
        }
if(!cbaa1.getCbaa11().equals(TaskStatus.mr.getCode())){
            throw new SwException("未审核状态才能删除");
        }


        Long userId = SecurityUtils.getUserId();

        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();
        cbaa.setCbaa01(cbaaDo.getCbaa01());
        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        cbaa.setCbaa06(DeleteFlagEnum.DELETE.getCode());
        cbaaMapper.updateByPrimaryKeySelective(cbaa);
        return 1;
    }


}
