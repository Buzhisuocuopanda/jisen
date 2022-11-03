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
import com.ruoyi.system.service.gson.OrderDistributionService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
@Slf4j
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

    @Resource
    private CbwaMapper cbwaMapper;

    @Resource
    private CbpbMapper cbpbMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;

    @Resource
    private OrderDistributionService orderDistributionService;

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
        cbaa.setCbaa06(DeleteFlagEnum.DELETE.getCode());

        String warehouseinitializationNo = numberGenerate.getWarehouseinitializationNos(cbaaDo.getCbaa10());

        cbaa.setCbaa07(warehouseinitializationNo);
        cbaa.setCbaa11(TaskStatus.mr.getCode());
        cbaa.setCbaa08(date);
        cbaa.setUserId(Math.toIntExact(userId));
        cbaaMapper.insertSelective(cbaa);
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa07EqualTo(warehouseinitializationNo)
                .andCbaa06EqualTo(DeleteFlagEnum.DELETE.getCode());
        List<Cbaa> cbaas = cbaaMapper.selectByExample(example);
        IdVo idVo = new IdVo();
        if(CollectionUtils.isNotEmpty(cbaas)){
            idVo.setId(cbaas.get(0).getCbaa01());
        }
      //  idVo.setId(cbaas.get(0).getCbaa01());
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
            if(Objects.isNull(itemList.get(i).getCbab08())){
                throw new SwException("商品不能为空");
            }
            if(itemList.get(i).getCbab09()==null){
                throw new SwException("商品数量不能为空");
            }
            if(itemList.get(i).getCbab11()==null){
                throw new SwException("商品单价不能为空");
            }
            if(itemList.get(i).getCbaa01()==null){
                throw new SwException("仓库调拨单主表id不能为空");
            }
            itemList.get(i).setCbab11(itemList.get(i).getCbab11());

            itemList.get(i).setCbab09(itemList.get(i).getCbab09());
            itemList.get(i).setCbab12(itemList.get(i).getCbab12());

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



        Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(itemList.get(0).getCbaa01());
        cbaa.setCbaa06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbaaMapper.updateByPrimaryKeySelective(cbaa);

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
        CbacCriteria example2 = new CbacCriteria();
        example2.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
        List<Cbac> cbacs = cbacMapper.selectByExample(example2);
        if (cbacs.size() > 0) {
            throw new SwException("已扫码不能反审");

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
    @SneakyThrows
    @Transactional
    @Override
    public int insertSwJsSkuBarcodebjwc(CbaaDo cbaaDo) {

        Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(cbaaDo.getCbaa01());

        if(cbaa1==null){
            throw new SwException("该仓库调拨单不存在");
        }
        if (!cbaa1.getCbaa11().equals(TaskStatus.sh.getCode())){

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
            }else {//zgl  根据扫码记录修改gs_goods_sn表的仓库id
                for(Cbac cbac:cbacs){
                    if(cbac.getCbac09()!=null&&!("").equals(cbac.getCbac09())){
                        GsGoodsSn gsGoodsSn = new GsGoodsSn();
                        gsGoodsSn.setLocationId(cbac.getCbac10());
                        gsGoodsSn.setWhId(cbaa1.getCbaa10());
                        GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
                        gsGoodsSnCriteria.createCriteria().andSnEqualTo(cbac.getCbac09());
                        gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,gsGoodsSnCriteria);
                    }
                }
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
        example2.createCriteria().andCbaa01EqualTo(cbaa01)
                .andCbac07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbac> cbacss = cbacMapper.selectByExample(example2);

if(cbacss.size()>0) {
    for (int i = 0; i < cbaasVos.size(); i++) {
if(cbaasVos.get(0).getCbab15()!=null){
        Integer cbab15 = cbaasVos.get(0).getCbab15();
        if(cbab15!=null && cbab15==1){
            cbaasVos.get(0).setOrderClass("国内订单");
        }else{
            cbaasVos.get(0).setOrderClass("国际订单");

        }}


        CbacCriteria example = new CbacCriteria();
        example.createCriteria().andCbaa01EqualTo(cbaa01);
               // .andCbac08EqualTo(cbaasVos.get(i).getCbab08());
        List<Cbac> cbacs = cbacMapper.selectByExample(example);
        int size = cbacs.size();
        for (int j = 0; j < size; j++) {
            ScanVo scanVo = new ScanVo();
            scanVo.setLx(cbaasVos.get(i).getCbpa08());
            scanVo.setPinpai(cbaasVos.get(i).getPinpai());
            scanVo.setCbpb08(cbaasVos.get(i).getCbpb08());
            scanVo.setCbpb12(cbaasVos.get(i).getCbpb12());
            scanVo.setCbpb15(cbaasVos.get(i).getCbpb15());
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
    @Transactional
    public void Warehousetransferorderseditone(CbaaDo cbaaDo) {
        Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(cbaaDo.getCbaa01());
        if(!cbaa1.getCbaa11().equals(TaskStatus.mr.getCode())){
            throw new SwException("未审核状态才能修改");
        }

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

        CbabCriteria cbabCriteria = new CbabCriteria();
        cbabCriteria.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
        int i = cbabMapper.deleteByExample(cbabCriteria);

        Cbab cbab = null;
        for (Cbab good : goods) {
            cbab = new Cbab();
       /*     if(good.getCbab01()==null){
                throw new SwException("调拨单明细id不能为空");
            }*/
           // cbab.setCbab01(good.getCbab01());

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
            cbab.setCbaa01(good.getCbaa01());
     cbabMapper.insertSelective(cbab);

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
//调拨单调出接口
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int transferordersout(Cbac itemList) {
        log.info("线程名"+Thread.currentThread().getName()+itemList.getCbac09());
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();


        if (itemList.getCbaa01() == null) {
            throw new SwException("调拨单id不能为空");
        }
        Cbaa cbaa = cbaaMapper.selectByPrimaryKey(itemList.getCbaa01());
        if (cbaa == null) {
            throw new SwException("调拨单不存在");
        }
        if( cbaa.getCbaa09()==null){
            throw new SwException("调拨单调出仓库为空");
        }
        if(itemList.getCbac09()!=null) {
            GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
            gsGoodsSnCriteria.createCriteria().andSnEqualTo(itemList.getCbac09());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
            if(gsGoodsSns.size()>0){
                Cbpb cbpb = cbpbMapper.selectByPrimaryKey(gsGoodsSns.get(0).getGoodsId());
                if(Objects.equals(cbpb.getCbpb12(), itemList.getCbac09())){
                    throw new SwException("sn不正确");
                }
            }
        }

        //锁
        String cbic10 = itemList.getCbac09();
        String uuid = UUID.randomUUID().toString();
        Boolean lock = redisTemplate.opsForValue().setIfAbsent(cbic10, uuid, 3, TimeUnit.SECONDS);
        if (!lock) {
            throw new SwException("sn重复，请勿重复提交");
        }
        String s = redisTemplate.opsForValue().get(cbic10);


        GsGoodsSn gsGoodsSn;
        try {
            Integer outstoreid = cbaa.getCbaa09();

            CbabCriteria cbabCriteria = new CbabCriteria();
            cbabCriteria.createCriteria().andCbaa01EqualTo(itemList.getCbaa01());
            List<Cbab> cbphs = cbabMapper.selectByExample(cbabCriteria);
            List<Integer> goodsids = cbphs.stream().map(Cbab::getCbab08).collect(Collectors.toList());
            Set<Integer> sio = new HashSet<>(goodsids);


            if(itemList.getCbac09()==null){
               throw new SwException("sn不能为空");
           }
            CbacCriteria cbacCriteria = new CbacCriteria();
            cbacCriteria.createCriteria().andCbac09EqualTo(itemList.getCbac09())
                    .andCbaa01EqualTo(itemList.getCbaa01());
            List<Cbac> cbacs = cbacMapper.selectByExample(cbacCriteria);
            if(cbacs.size()>0){


                throw new SwException("sn已存在");}

            //校验sn
            GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
            gsGoodsSnCriteria.createCriteria().andSnEqualTo(itemList.getCbac09());
            List<GsGoodsSn> gsGoodsSnList = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
            if (CollectionUtils.isEmpty(gsGoodsSnList)) {
                throw new SwException("sn不存在");
            }
            //校验sn是否已经出库
            if(gsGoodsSnList.get(0).getStatus()==3){
                throw new SwException("该sn已经出库");
            }
            if(gsGoodsSnList.get(0).getLocationId()==null){
                throw new SwException("sn库位id不饿为空");
            }
            Cbla cbla = cblaMapper.selectByPrimaryKey(gsGoodsSnList.get(0).getLocationId());
            if(!cbla.getCbla10().equals(outstoreid)){
                throw new SwException("sn库位不在调出仓库");
            }
            if(gsGoodsSnList.get(0).getGoodsId()==null){
                throw new SwException("sn商品id不能为空");
            }
            if(!sio.contains(gsGoodsSnList.get(0).getGoodsId())){
                throw new SwException("sn商品id不在调拨单明细中");
            }

            itemList.setCbac03(date);
            itemList.setCbac04(Math.toIntExact(userid));
            itemList.setCbac05(date);
            itemList.setCbac06(Math.toIntExact(userid));
            itemList.setCbac07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.setCbac08(gsGoodsSnList.get(0).getGoodsId());
            itemList.setCbac09(itemList.getCbac09());
            itemList.setCbac11(gsGoodsSnList.get(0).getLocationId());
            itemList.setCbaa01(itemList.getCbaa01());
            itemList.setCbac14(1);
            itemList.setUserId(Math.toIntExact(userid));


            gsGoodsSn = new GsGoodsSn();
            gsGoodsSn.setId(gsGoodsSnList.get(0).getId());
            gsGoodsSn.setStatus((byte) 3);
            gsGoodsSn.setOutTime(date);
        } finally {
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                    "then " +
                    "return redis.call('del', KEYS[1]) " +
                    "else " +
                    "return 0 " +
                    "end";
            this.redisTemplate.execute(new DefaultRedisScript<>(script, Boolean.class), Arrays.asList("lock"), uuid);

        }


        gsGoodsSnMapper.updateByPrimaryKeySelective(gsGoodsSn);

        cbacMapper.insertSelective(itemList);

            return 1;
    }
//调拨单入库扫码
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int transferordersin(Cbac itemList) {




        Date date = new Date();
        Long userid = SecurityUtils.getUserId();


        if (itemList.getCbaa01() == null) {
            throw new SwException("调拨单id不能为空");
        }

        if (itemList.getCbac12() == null) {
            throw new SwException("upc不能为空");
        }
     CbpbCriteria cbpbCriteria = new CbpbCriteria();
        cbpbCriteria.createCriteria().andCbpb15EqualTo(itemList.getCbac12());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(cbpbCriteria);
        if(cbpbs.size()==0){
            throw new SwException("upc不存在");
        }
        Integer goodsid = cbpbs.get(0).getCbpb01();



        if(itemList.getCbac09()!=null) {
            GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
            gsGoodsSnCriteria.createCriteria().andSnEqualTo(itemList.getCbac09());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
            if(gsGoodsSns.size()>0){
                Cbpb cbpb = cbpbMapper.selectByPrimaryKey(gsGoodsSns.get(0).getGoodsId());
                if(Objects.equals(cbpb.getCbpb12(), itemList.getCbac09())){
                    throw new SwException("sn不正确");
                }
            }
        }

        Cbaa cbaa = cbaaMapper.selectByPrimaryKey(itemList.getCbaa01());
        if( cbaa.getCbaa10()==null){
            throw new SwException("调拨单调入仓库为空");
        }

        String cbic10 = itemList.getCbac09();
        String uuid = UUID.randomUUID().toString();
        Boolean lock = redisTemplate.opsForValue().setIfAbsent(cbic10, uuid, 3, TimeUnit.SECONDS);
        if (!lock) {
            throw new SwException("sn重复，请勿重复提交");
        }
        String s = redisTemplate.opsForValue().get(cbic10);


        try {
            Integer instoreid = cbaa.getCbaa10();

            CbabCriteria cbabCriteria = new CbabCriteria();
            cbabCriteria.createCriteria().andCbaa01EqualTo(itemList.getCbaa01());
            List<Cbab> cbphs = cbabMapper.selectByExample(cbabCriteria);
            List<Integer> goodsids = cbphs.stream().map(Cbab::getCbab08).collect(Collectors.toList());
            Set<Integer> sio = new HashSet<>(goodsids);


            Integer cbaa01 = itemList.getCbaa01();
            if(cbaa01==null){
                throw new SwException("调拨单id不能为空");
            }
            //调出数量仓库
            CbwaCriteria exampse1 = new CbwaCriteria();
            exampse1.createCriteria().andCbwa12EqualTo("数量管理");
            List<Cbwa> cbwas = cbwaMapper.selectByExample(exampse1);
            List<Integer> gyuygy = cbwas.stream().map(Cbwa::getCbwa01).collect(Collectors.toList());
            Set<Integer> fhji = new HashSet<>(gyuygy);
            Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(cbaa01);
            if(fhji.contains(cbaa1.getCbaa09()) ){


                Cbla cbla = cblaMapper.selectByPrimaryKey(itemList.getCbac10());
                if(cbla!=null){
                    if(!cbla.getCbla10().equals(cbaa.getCbaa10())){
                        throw new SwException("调拨单调库位不在单据调入仓库");
                    }
                }
                GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
                gsGoodsSnCriteria.createCriteria().andSnEqualTo(itemList.getCbac09());
                List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
                if(gsGoodsSns.size()>0){
                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
                    gsGoodsSn.setStatus((byte) 1);
                    gsGoodsSn.setGroudStatus((byte) 1);
                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,gsGoodsSnCriteria);
                }
                else{

                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                gsGoodsSn.setCreateTime(date);
                gsGoodsSn.setUpdateTime(date);
                gsGoodsSn.setCreateBy(Math.toIntExact(userid));
                gsGoodsSn.setUpdateBy(Math.toIntExact(userid));
                gsGoodsSn.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                gsGoodsSn.setSn(itemList.getCbac09());
                gsGoodsSn.setStatus((byte) 1);
                gsGoodsSn.setInTime(date);
                gsGoodsSn.setGoodsId(goodsid);
                gsGoodsSn.setLocationId(itemList.getCbac10());
                gsGoodsSn.setWhId(instoreid);
                gsGoodsSn.setGroudStatus((byte) 1);
                gsGoodsSnMapper.insertSelective(gsGoodsSn);}

                //判断调入扫码删除状态
                CbacCriteria cbacCriterias = new CbacCriteria();
                cbacCriterias.createCriteria().andCbaa01EqualTo(itemList.getCbaa01())
                        .andCbac09EqualTo(itemList.getCbac09())
                        .andCbac14EqualTo(1);
                List<Cbac> cbacss = cbacMapper.selectByExample(cbacCriterias);
                if(cbacss.size()>0){
                    Cbac cbac = new Cbac();
                    cbac.setCbaa01(itemList.getCbaa01());
                    cbac.setCbac09(itemList.getCbac09());
                    cbac.setCbac14(2);
                    cbacMapper.updateByExampleSelective(cbac,cbacCriterias);
                }else{

                itemList.setCbac03(date);
                itemList.setCbac04(Math.toIntExact(userid));
                itemList.setCbaa01(cbaa.getCbaa01());
                itemList.setCbac05(date);
                itemList.setCbac06(Math.toIntExact(userid));
                itemList.setCbac07(DeleteFlagEnum.NOT_DELETE.getCode());
                itemList.setCbac10(itemList.getCbac10());
                itemList.setCbac09(itemList.getCbac09());
                itemList.setCbac08(goodsid);

                itemList.setCbaa01(itemList.getCbaa01());
                itemList.setCbac14(2);
                itemList.setUserId(Math.toIntExact(userid));
               }
            }
            else{
                //判断调出扫码是否完成
                CbacCriteria cbacCriterias = new CbacCriteria();
                cbacCriterias.createCriteria().andCbaa01EqualTo(itemList.getCbaa01())
                        .andCbac07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                List<Cbac> cbacss = cbacMapper.selectByExample(cbacCriterias);

                CbabCriteria cbabCriterias = new CbabCriteria();
                cbabCriterias.createCriteria().andCbaa01EqualTo(itemList.getCbaa01());
                List<Cbab> cbpshs = cbabMapper.selectByExample(cbabCriterias);
                if(cbpshs.size()>0){
                    double sum = cbpshs.stream().mapToDouble(Cbab::getCbab09).sum();
                    if(cbacss.size()<sum){
                        throw new SwException("调拨单扫码调出未完成");
                    }
                }



            CbacCriteria cbaceria = new CbacCriteria();
            cbaceria.createCriteria().andCbac09EqualTo(itemList.getCbac09())
                    .andCbaa01EqualTo(itemList.getCbaa01());
            List<Cbac> cbacs = cbacMapper.selectByExample(cbaceria);
            if(cbacs.size()==0){
                throw new SwException("sn不存在");}




            if (itemList.getCbac10() == null) {
                throw new SwException("库位id不能为空");
            }
            Cbla cbla = cblaMapper.selectByPrimaryKey(itemList.getCbac10());
            if(!cbla.getCbla10().equals(instoreid)){
                throw new SwException("输入的库位库位不在调入仓库");
            }

            if(itemList.getCbac09()==null){
                throw new SwException("sn不能为空");
            }
            //校验sn
            GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
            gsGoodsSnCriteria.createCriteria().andSnEqualTo(itemList.getCbac09());
            List<GsGoodsSn> gsGoodsSnList = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
            if (CollectionUtils.isEmpty(gsGoodsSnList)) {
                throw new SwException("sn不存在");
            }
            //校验sn是否已经出库
           /* if(!gsGoodsSnList.get(i).getStatus().equals(3)){
                throw new SwException("该sn已经出库");
            }*/



            if(!sio.contains(gsGoodsSnList.get(0).getGoodsId())){
                throw new SwException("sn商品id不在调拨单明细中");
            }


            itemList.setCbac05(date);
            itemList.setCbac06(Math.toIntExact(userid));
            itemList.setCbac07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.setCbac10(itemList.getCbac10());
            itemList.setCbaa01(itemList.getCbaa01());
            itemList.setCbac14(2);
            itemList.setUserId(Math.toIntExact(userid));




                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                gsGoodsSn.setId(gsGoodsSnList.get(0).getId());
                gsGoodsSn.setStatus((byte) 1);
                gsGoodsSn.setInTime(date);
                gsGoodsSn.setLocationId(itemList.getCbac10());
                gsGoodsSn.setWhId(instoreid);


                gsGoodsSnMapper.updateByPrimaryKeySelective(gsGoodsSn);

                CbacCriteria cbacCriteria = new CbacCriteria();
                cbacCriteria.createCriteria().andCbac09EqualTo(itemList.getCbac09());

            return     cbacMapper.updateByExampleSelective(itemList, cbacCriteria);
            }
        } finally {

            String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                    "then " +
                    "return redis.call('del', KEYS[1]) " +
                    "else " +
                    "return 0 " +
                    "end";
            this.redisTemplate.execute(new DefaultRedisScript<>(script, Boolean.class), Arrays.asList("lock"), uuid);

        }

        cbacMapper.insertSelective(itemList);
        return 1;    }

    //调出标记完成
    @Override
    public int transferordersoutbjwc(CbaaDo cbaaDo) throws InterruptedException {


        Long userid = SecurityUtils.getUserId();
        Date date = new Date();

        Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(cbaaDo.getCbaa01());

        if (cbaa1 == null) {
            throw new SwException("该仓库调拨单不存在");
        }
        if (cbaa1.getCbaa11().equals(TaskStatus.sh.getCode())) {
        } else {
            throw new SwException("审核状态才能标记完成");
        }

//数量仓库出库
        CbwaCriteria exampse1 = new CbwaCriteria();
        exampse1.createCriteria().andCbwa12EqualTo("数量管理");
        List<Cbwa> cbwas = cbwaMapper.selectByExample(exampse1);
        List<Integer> goodsids = cbwas.stream().map(Cbwa::getCbwa01).collect(Collectors.toList());
        Set<Integer> sio = new HashSet<>(goodsids);
        if(sio.contains(cbaa1.getCbaa09())){

       CbabCriteria cbabCriteria = new CbabCriteria();
            cbabCriteria.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
            List<Cbab> cbabs = cbabMapper.selectByExample(cbabCriteria);
            if(cbabs.size()==0){
                throw new SwException("调拨单明细为空");
            }
            for(int i=0;i<cbabs.size();i++){
               if(cbabs.get(i).getCbab09()==null){
                   throw new SwException("调拨数量不能为空");
               }
                Double num = cbabs.get(i).getCbab09();
                if(cbabs.get(i).getCbab08()==null){
                   throw new SwException("调拨货物id不能为空");
               }
                Integer goodsid = cbabs.get(i).getCbab08();

                GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
                example.createCriteria()
                        .andGoodsIdEqualTo(goodsid)
                        .andWhIdEqualTo(cbaa1.getCbaa09());
                List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
                //对库存表的操作

                if(gsGoodsSkus.size()==0){
                    throw new SwException("仓库数量仓库没有该商品");
                }

                for(int j=0;j<gsGoodsSkus.size();j++) {

if(gsGoodsSkus.get(j).getLocationId()==null) {
    Integer id = gsGoodsSkus.get(0).getId();
    GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);

    if (num > gsGoodsSku.getQty()) {
        throw new SwException("调出数量大于库存数量");

    }
    gsGoodsSku.setId(id);
    gsGoodsSku.setQty(gsGoodsSku.getQty() - num);
    gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
    gsGoodsSku.setUpdateTime(date);
    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);

    TranUseQtyDo tranUseQtyDo = new TranUseQtyDo();
    tranUseQtyDo.setGoodsId(goodsid);
    tranUseQtyDo.setQty(num);
    tranUseQtyDo.setInWhId(cbaa1.getCbaa10());
    tranUseQtyDo.setOutWhId(cbaa1.getCbaa09());
    orderDistributionService.diaoboUseOp(tranUseQtyDo);

}
                }
                  //台账
                //供应商名称
                Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbabs.get(i).getCbab14());
                String vendername = cbsa.getCbsa08();
                //商品id


                //台账新增数据调出仓库
                CbibDo cbibDo1 = new CbibDo();
                cbibDo1.setCbib02(cbaa1.getCbaa09());
                cbibDo1.setCbib03(cbaa1.getCbaa07());
                cbibDo1.setCbib05(String.valueOf(TaskType.zjd.getCode()));
                cbibDo1.setCbib06(vendername);
                cbibDo1.setCbib07(cbaa1.getCbaa01());
                cbibDo1.setCbib08(goodsid);
                cbibDo1.setCbib11((double) 0);
                cbibDo1.setCbib12((double) 0);
                cbibDo1.setCbib13(num);
                cbibDo1.setCbib14(cbabs.get(i).getCbab11() * num);

                cbibDo1.setCbib17(TaskType.zjd.getMsg());
                cbibDo1.setCbib19(cbabs.get(i).getCbab14());
                taskService.InsertCBIB(cbibDo1);




            }

           // cbaa1.setCbaa11(TaskStatus.bjwc.getCode());
            cbaaMapper.updateByPrimaryKeySelective(cbaa1);




        }

//数量仓库出库

//扫码仓库出库
else {
            int sdw = 0;
            CbabCriteria etur = new CbabCriteria();
            etur.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
            List<Cbab> opi = cbabMapper.selectByExample(etur);
            if (opi.size() == 0) {
                throw new SwException("调拨单明细为空");
            }
            for (Cbab cbab : opi) {
                Double cbab09 = cbab.getCbab09();
                sdw += cbab09;
            }
            CbacCriteria etur1 = new CbacCriteria();
            etur1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
            List<Cbac> opi1 = cbacMapper.selectByExample(etur1);
            if (opi1.size() < sdw) {
                throw new SwException("扫码数量小于任务数量不能调出标记完成");
            }


            Long userId = SecurityUtils.getUserId();

            Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);

            cbaa.setCbaa04(date);
            cbaa.setCbaa05(Math.toIntExact(userId));
            cbaa.setCbaa11(TaskStatus.bjwc.getCode());
            CbaaCriteria example = new CbaaCriteria();
            example.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                    .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());


            CbabCriteria example2 = new CbabCriteria();
            example2.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
            List<Cbab> cbabs1 = cbabMapper.selectByExample(example2);
            if (cbabs1.size() == 0) {
                throw new SwException("该仓库调拨单明细不存在");
            }
            List<Cbac> cbacs = null;
            for (int i = 0; i < cbabs1.size(); i++) {
                CbacCriteria example3 = new CbacCriteria();
                example3.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                        .andCbac08EqualTo(cbabs1.get(i).getCbab08());
                cbacs = cbacMapper.selectByExample(example3);
                if (cbacs.size() == 0) {
                    throw new SwException("该仓库调拨单扫码记录不存在");

                }
                // Double num = (double) cbacs.size();


                for (int j = 0; j < cbacs.size(); j++) {
                    if (cbacs.get(j).getCbac11() == null) {
                        throw new SwException("调拨单调出库位为空");

                    }
                    if (cbacs.get(j).getCbac08() == null) {
                        throw new SwException("调拨单调入商品id为空");

                    }
                    //调出仓库
                    Integer outstore = cbaa1.getCbaa09();

                    GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
                    //获取调出仓库id
                    gsGoodsSkuDo.setWhId(outstore);
                    //获取商品id
                    gsGoodsSkuDo.setGoodsId(cbacs.get(j).getCbac08());
                    gsGoodsSkuDo.setLocationId(cbacs.get(j).getCbac11());
                    gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                    //通过仓库id和货物id判断是否存在
                    // 调出仓库
                    List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
                    if (gsGoodsSkus.size() == 0) {
                        throw new SwException("调出仓库库位没有该货物");
                    } else {
                        //加锁
                        baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                        GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                        //查出
                        Double qty = gsGoodsSkus.get(0).getQty();
                        if (qty == 0) {
                            throw new SwException("调出仓库该货物数量为0");
                        }
                        gsGoodsSkuDo1.setGoodsId(cbacs.get(j).getCbac08());
                        gsGoodsSkuDo1.setWhId(outstore);
                        gsGoodsSkuDo1.setLocationId(cbacs.get(j).getCbac11());
                        gsGoodsSkuDo1.setQty(qty - 1);
                        taskService.updateGsGoodsSku(gsGoodsSkuDo1);


                    }
                }
            }

            Double num = (double) cbacs.size();

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
                cbibDo1.setCbib13(num);
                cbibDo1.setCbib14(cbabs.get(i).getCbab11() * num);

                cbibDo1.setCbib17(TaskType.zjd.getMsg());
                cbibDo1.setCbib19(cbabs.get(i).getCbab14());
                taskService.InsertCBIB(cbibDo1);


                TranUseQtyDo tranUseQtyDo = new TranUseQtyDo();
                tranUseQtyDo.setGoodsId(goodsid);
                tranUseQtyDo.setQty(num);
                tranUseQtyDo.setInWhId(cbaa1.getCbaa10());
                tranUseQtyDo.setOutWhId(cbaa1.getCbaa09());
                orderDistributionService.diaoboUseOp(tranUseQtyDo);
            }

            cbaaMapper.updateByExampleSelective(cbaa, example);
        }
        return 1;
    }
    //仓库调拨单调入标记完成
    @Override
    @Transactional
    public int transferordersinbjwc(CbaaDo cbaaDo) throws InterruptedException {

        //调出标记完成
        transferordersoutbjwc(cbaaDo);

        Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(cbaaDo.getCbaa01());

        if (cbaa1 == null) {
            throw new SwException("该仓库调拨单不存在");
        }
   /*     if (!cbaa1.getCbaa11().equals(TaskStatus.bjwc.getCode())) {

            throw new SwException("调出标记完成之后调入标记完成");

        }*/
        Date date = new Date();
        Long userId = SecurityUtils.getUserId();


        //调入数量仓库
        CbwaCriteria exampse1 = new CbwaCriteria();
        exampse1.createCriteria().andCbwa12EqualTo("数量管理");
        List<Cbwa> cbwas = cbwaMapper.selectByExample(exampse1);
        List<Integer> goodsids = cbwas.stream().map(Cbwa::getCbwa01).collect(Collectors.toList());
        Set<Integer> sio = new HashSet<>(goodsids);

        //调出是扫码情况
        CbwaCriteria exartjr = new CbwaCriteria();
        exartjr.createCriteria().andCbwa12EqualTo("条码管理");
        List<Cbwa> cbwas1 = cbwaMapper.selectByExample(exartjr);
        List<Integer> goodsidss = cbwas1.stream().map(Cbwa::getCbwa01).collect(Collectors.toList());
        Set<Integer> icu = new HashSet<>(goodsidss);
        //调出是扫码情况

        if (sio.contains(cbaa1.getCbaa10())) {



            CbabCriteria cbabCriteria = new CbabCriteria();
            cbabCriteria.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
            List<Cbab> cbabs = cbabMapper.selectByExample(cbabCriteria);
            if (cbabs.size() == 0) {
                throw new SwException("调拨单明细为空");
            }

            //调出扫码
            if(icu.contains(cbaa1.getCbaa09())){
                Double kio= 0.0;
                CbacCriteria cbacCriteria = new CbacCriteria();
                cbacCriteria.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
                List<Cbac> cbacs = cbacMapper.selectByExample(cbacCriteria);
                int size = cbacs.size();
                for(int s=0;s<cbabs.size();s++){
                    if(cbabs.get(s).getCbab09()==0){
                        throw new SwException("调拨数量不能为空");
                    }
                    kio+=cbabs.get(s).getCbab09();
                }
                if(size<kio){
                    throw new SwException("调拨数量小于任务数量");
                } else {//zgl  根据扫码记录修改gs_goods_sn表的仓库id
                    if(cbacs!=null){
                        for(Cbac cbac:cbacs){
                            if(cbac.getCbac09()!=null&&!("").equals(cbac.getCbac09())){
                                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                                gsGoodsSn.setLocationId(cbac.getCbac10());
                                gsGoodsSn.setWhId(cbaa1.getCbaa10());
                                gsGoodsSn.setStatus(TaskStatus.sh.getCode().byteValue());
                                GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
                                gsGoodsSnCriteria.createCriteria().andSnEqualTo(cbac.getCbac09());
                                if(cbaa1.getCbaa10()==null){
                                    throw new SwException("调拨单调入仓库为空");
                                }else {
                                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,gsGoodsSnCriteria);
                                }

                            }
                        }
                    }

                }
            }
            //调出扫码


            for (int i = 0; i < cbabs.size(); i++) {
                if (cbabs.get(i).getCbab09() == null) {
                    throw new SwException("调拨数量不能为空");
                }
                Double num = cbabs.get(i).getCbab09();
                if (cbabs.get(i).getCbab08() == null) {
                    throw new SwException("调拨货物id不能为空");
                }
                Integer goodsid = cbabs.get(i).getCbab08();

                GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
                example.createCriteria()
                        .andGoodsIdEqualTo(goodsid)
                        .andWhIdEqualTo(cbaa1.getCbaa09());
                List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
                //对库存表的操作

                if (gsGoodsSkus.size() == 0) {
                    //新增数据
                    GsGoodsSku gsGoodsSku = new GsGoodsSku();
                    gsGoodsSku.setCreateTime(date);
                    gsGoodsSku.setUpdateTime(date);
                    gsGoodsSku.setCreateBy(Math.toIntExact(userId));
                    gsGoodsSku.setUpdateBy(Math.toIntExact(userId));
                    gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                    gsGoodsSku.setGoodsId(goodsid);
                    gsGoodsSku.setWhId(cbaa1.getCbaa10());
                    gsGoodsSku.setQty(num);
                    gsGoodsSkuMapper.insertSelective(gsGoodsSku);

                    TranUseQtyDo tranUseQtyDo = new TranUseQtyDo();
                    tranUseQtyDo.setGoodsId(goodsid);
                    tranUseQtyDo.setQty(num);
                    tranUseQtyDo.setInWhId(cbaa1.getCbaa10());
                    tranUseQtyDo.setOutWhId(cbaa1.getCbaa09());
                    orderDistributionService.diaoboUseOp(tranUseQtyDo);
                }
                else {

                    for (int j = 0; j < gsGoodsSkus.size(); j++) {

                        if (gsGoodsSkus.get(j).getLocationId()==null) {
                            Integer id = gsGoodsSkus.get(0).getId();
                            GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);

                            gsGoodsSku.setId(id);
                            gsGoodsSku.setQty(gsGoodsSku.getQty() + num);
                            gsGoodsSku.setUpdateBy(Math.toIntExact(userId));
                            gsGoodsSku.setUpdateTime(date);
                            gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);

                            TranUseQtyDo tranUseQtyDo = new TranUseQtyDo();
                            tranUseQtyDo.setGoodsId(goodsid);
                            tranUseQtyDo.setQty(num);
                            tranUseQtyDo.setInWhId(cbaa1.getCbaa10());
                            tranUseQtyDo.setOutWhId(cbaa1.getCbaa09());
                            orderDistributionService.diaoboUseOp(tranUseQtyDo);
                        }else {
                            gsGoodsSkus.remove(j);

                        }

                    }
                    if(gsGoodsSkus.size()==0){
                        GsGoodsSku gsGoodsSku = new GsGoodsSku();
                        gsGoodsSku.setCreateTime(date);
                        gsGoodsSku.setUpdateTime(date);
                        gsGoodsSku.setCreateBy(Math.toIntExact(userId));
                        gsGoodsSku.setUpdateBy(Math.toIntExact(userId));
                        gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                        gsGoodsSku.setGoodsId(goodsid);
                        gsGoodsSku.setWhId(cbaa1.getCbaa10());
                        gsGoodsSku.setQty(num);
                        gsGoodsSkuMapper.insertSelective(gsGoodsSku);

                        TranUseQtyDo tranUseQtyDo = new TranUseQtyDo();
                        tranUseQtyDo.setGoodsId(goodsid);
                        tranUseQtyDo.setQty(num);
                        tranUseQtyDo.setInWhId(cbaa1.getCbaa10());
                        tranUseQtyDo.setOutWhId(cbaa1.getCbaa09());
                        orderDistributionService.diaoboUseOp(tranUseQtyDo);
                    }
                }
                //台账
                //供应商名称
                Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbabs.get(i).getCbab14());
                String vendername = cbsa.getCbsa08();
                //商品id



                //台账新增数据调出仓库
                CbibDo cbibDo = new CbibDo();
                cbibDo.setCbib02(cbaa1.getCbaa10());
                cbibDo.setCbib03(cbaa1.getCbaa07());
                cbibDo.setCbib05(String.valueOf(TaskType.xsthd.getCode()));
                cbibDo.setCbib06(vendername);
                cbibDo.setCbib07(cbaa1.getCbaa01());
                cbibDo.setCbib08(goodsid);
                cbibDo.setCbib11((double) num);
                cbibDo.setCbib12(cbabs.get(i).getCbab11() * num);
                cbibDo.setCbib13((double) 0);
                cbibDo.setCbib14((double) 0);

                cbibDo.setCbib17(TaskType.xsthd.getMsg());
                cbibDo.setCbib19(cbabs.get(i).getCbab14());
                taskService.InsertCBIB(cbibDo);
                cbaa1.setCbaa11(TaskStatus.bjwc.getCode());
                cbaaMapper.updateByPrimaryKeySelective(cbaa1);

            }





        }



//数量仓库出库




//扫码仓库出库

        else {

//调出是数量，调入是扫码


            int sdw = 0;
            CbabCriteria etur = new CbabCriteria();
            etur.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
            List<Cbab> opi = cbabMapper.selectByExample(etur);
            if (opi.size() == 0) {
                throw new SwException("调拨单明细为空");
            }
            for (Cbab cbab : opi) {
                Double cbab09 = cbab.getCbab09();
                sdw += cbab09;
            }
            CbacCriteria etur1 = new CbacCriteria();
            etur1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                    .andCbac14EqualTo(2);
            List<Cbac> opi1 = cbacMapper.selectByExample(etur1);
            if (opi1.size() < sdw) {
                throw new SwException("扫码数量小于任务数量不能调入标记完成");
            }


            Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);

            cbaa.setCbaa04(date);
            cbaa.setCbaa05(Math.toIntExact(userId));
            cbaa.setCbaa11(TaskStatus.bjwc.getCode());
            CbaaCriteria example = new CbaaCriteria();
            example.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                    .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

            CbabCriteria example2 = new CbabCriteria();
            example2.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
            List<Cbab> cbabs1 = cbabMapper.selectByExample(example2);
            if (cbabs1.size() == 0) {
                throw new SwException("该仓库调拨单明细不存在");
            }
            List<Cbac> cbacs = null;
            for (int i = 0; i < cbabs1.size(); i++) {
                CbacCriteria example3 = new CbacCriteria();
                example3.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                        .andCbac08EqualTo(cbabs1.get(i).getCbab08());
                cbacs = cbacMapper.selectByExample(example3);
                if (cbacs.size() == 0) {
                    throw new SwException("该仓库调拨单扫码记录不存在");

                } else {
                    for(Cbac cbac:cbacs){//zgl  根据扫码记录修改gs_goods_sn表的仓库id
                        if(cbac.getCbac09()!=null&&!("").equals(cbac.getCbac09())){
                            GsGoodsSn gsGoodsSn = new GsGoodsSn();
                            gsGoodsSn.setLocationId(cbac.getCbac10());
                            gsGoodsSn.setWhId(cbaa1.getCbaa10());
                            GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
                            gsGoodsSnCriteria.createCriteria().andSnEqualTo(cbac.getCbac09());
                            if(cbaa1.getCbaa10()==null){
                                throw new SwException("调拨单调入仓库为空");
                            }else {
                                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,gsGoodsSnCriteria);
                            }

                        }
                    }
                }
            }
            int num = cbacs.size();
            for (int j = 0; j < cbacs.size(); j++) {
                if (cbacs.get(j).getCbac08() == null) {
                    throw new SwException("调拨单调入商品id为空");

                }
                if (cbacs.get(j).getCbac10() == null) {
                    throw new SwException("调拨单调入库位为空");

                }
                Integer instore = cbaa1.getCbaa10();

//调入仓库加
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                //获取调入仓库id
                gsGoodsSkuDo1.setWhId(instore);
                gsGoodsSkuDo1.setLocationId(cbacs.get(j).getCbac10());
                //获取商品id
                gsGoodsSkuDo1.setGoodsId(cbacs.get(j).getCbac08());
                gsGoodsSkuDo1.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                //通过仓库id和货物id判断是否存在
                List<GsGoodsSku> gsGoodsSkus1 = taskService.checkGsGoodsSku(gsGoodsSkuDo1);
                if (gsGoodsSkus1.size() == 0) {
                    Cbla cbla = cblaMapper.selectByPrimaryKey(cbacs.get(j).getCbac10());
                    if (cbla == null) {
                        throw new SwException("调入库位不存在");
                    }
                    GsGoodsSkuCriteria example1 = new GsGoodsSkuCriteria();
                    example1.createCriteria()
                            .andLocationIdEqualTo(cbacs.get(j).getCbac10());
                    List<GsGoodsSku> gsGoodsSkuss1 = gsGoodsSkuMapper.selectByExample(example1);
                    if(gsGoodsSkuss1.size()>0){
                        double sum = gsGoodsSkus1.stream().mapToDouble(GsGoodsSku::getQty).sum();
                        if(sum + 1>cbla.getCbla11()){
                            throw new SwException("库位容量不足");
                        }
                    }

                    GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();
                    gsGoodsSkuDo2.setGoodsId(cbacs.get(j).getCbac08());
                    gsGoodsSkuDo2.setWhId(instore);
                    gsGoodsSkuDo2.setLocationId(cbacs.get(j).getCbac10());
                    gsGoodsSkuDo2.setQty(1.0);
                    taskService.addGsGoodsSku(gsGoodsSkuDo2);


                } else {

                    Cbla cbla = cblaMapper.selectByPrimaryKey(cbacs.get(j).getCbac10());
                    if (cbla == null) {
                        throw new SwException("调入库位不存在");
                    }
                    GsGoodsSkuCriteria example1 = new GsGoodsSkuCriteria();
                    example1.createCriteria()
                            .andLocationIdEqualTo(cbacs.get(j).getCbac10());
                    List<GsGoodsSku> gsGoodsSkuss1 = gsGoodsSkuMapper.selectByExample(example1);
                    if(gsGoodsSkuss1.size()>0){
                        double sum = gsGoodsSkus1.stream().mapToDouble(GsGoodsSku::getQty).sum();
                        if(sum + 1>cbla.getCbla11()){
                            throw new SwException("库位容量不足");
                        }
                    }
                    //加锁
                    baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus1.get(0).getId());
                    GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();

                    gsGoodsSkuDo2.setGoodsId(cbacs.get(j).getCbac08());
                    gsGoodsSkuDo2.setWhId(instore);
                    gsGoodsSkuDo2.setLocationId(gsGoodsSkus1.get(0).getLocationId());
                    //查出
                    Double qty = gsGoodsSkus1.get(0).getQty();
                    double v = qty + 1;
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
                example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
                List<Cbab> cbabs = cbabMapper.selectByExample(example1);


            }

            Cbaa cbaa2 = cbaaMapper.selectByPrimaryKey(cbaaDo.getCbaa01());
            CbabCriteria cbabCriteria = new CbabCriteria();
            cbabCriteria.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
            List<Cbab> cbabs = cbabMapper.selectByExample(cbabCriteria);
            for (int i = 0; i < cbabs.size(); i++) {
                //供应商名称
                Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbabs.get(i).getCbab14());
                String vendername = cbsa.getCbsa08();
                //商品id
                Integer goodsid = cbabs.get(i).getCbab08();

                //台账新增数据调入仓库
                CbibDo cbibDo = new CbibDo();
                cbibDo.setCbib02(cbaa2.getCbaa10());
                cbibDo.setCbib03(cbaa2.getCbaa07());
                cbibDo.setCbib05(String.valueOf(TaskType.xsthd.getCode()));
                cbibDo.setCbib06(vendername);
                cbibDo.setCbib07(cbaa2.getCbaa01());
                cbibDo.setCbib08(goodsid);
                cbibDo.setCbib11((double) num);
                cbibDo.setCbib12(cbabs.get(i).getCbab11() * num);
                cbibDo.setCbib13((double) 0);
                cbibDo.setCbib14((double) 0);

                cbibDo.setCbib17(TaskType.xsthd.getMsg());
                cbibDo.setCbib19(cbabs.get(i).getCbab14());
                taskService.InsertCBIB(cbibDo);

      /*      //台账新增数据调出仓库
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

            cbibDo1.setCbib17(TaskType.zjd.getMsg());
            cbibDo1.setCbib19(cbabs.get(i).getCbab14());
            taskService.InsertCBIB(cbibDo1);*/
                TranUseQtyDo tranUseQtyDo = new TranUseQtyDo();
                tranUseQtyDo.setGoodsId(goodsid);
                tranUseQtyDo.setQty(Double.valueOf(num));
                tranUseQtyDo.setInWhId(cbaa1.getCbaa10());
                tranUseQtyDo.setOutWhId(cbaa1.getCbaa09());
                orderDistributionService.diaoboUseOp(tranUseQtyDo);
            }

            return cbaaMapper.updateByExampleSelective(cbaa, example);
        }
        return 1;
    }
    @Override
    public List<CbacVo> selectSwJsTaskGoodsRelListsss(CbacVo cbacVo){
            if (cbacVo.getCbaa01() == null) {
                throw new SwException("调拨单id不能为空");
            }
            CbacVo res = new CbacVo();
            CbabCriteria example = new CbabCriteria();
            example.createCriteria().andCbaa01EqualTo(cbacVo.getCbaa01())
                    .andCbab07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbab> cbabs = cbabMapper.selectByExample(example);

            if (cbabs.size() == 0) {
                throw new SwException("调拨单明细为空");
            }
            List<Double> collect = cbabs.stream().map(Cbab::getCbab09).collect(Collectors.toList());
            Double sum = 0.0;
            for (int i = 0; i < collect.size(); i++) {
                sum += collect.get(i);
            }
            List<CbacVo> cbacVos = cbacMapper.selectSwJsTaskGoodsRelListsss(cbacVo);
            res.setNums(sum);

            cbacVos.add(res);
            if (cbacVos.size() > 1) {
                cbacVos.get(0).setSaoma(cbacVos.size() - 1);
                cbacVos.get(0).setNums(sum);
            }

            return cbacVos;

    }

    @Override
    public List<CbacVo> swJsGoodslistsss(CbacVo cbacVo) {
        if(cbacVo.getCbaa01()==null){
            throw new SwException("调拨单id不能为空");
        }
        CbacVo res=new CbacVo();
        CbabCriteria example = new CbabCriteria();
        example.createCriteria().andCbaa01EqualTo(cbacVo.getCbaa01())
                .andCbab07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbab> cbabs = cbabMapper.selectByExample(example);
        if(cbabs.size()==0){
            throw new SwException("调拨单明细为空");
        }
        List<Double> collect = cbabs.stream().map(Cbab::getCbab09).collect(Collectors.toList());
        Double sum = 0.0;
        for(int i=0;i<collect.size();i++){
            sum+=collect.get(i);
        }
        List<CbacVo> cbacVos = cbacMapper.swJsGoodslistsss(cbacVo);
        res.setNums(sum);

        cbacVos.add(res);
        if(cbacVos.size()>1){
            cbacVos.get(0).setSaoma(cbacVos.size()-1);
            cbacVos.get(0).setNums(sum);
        }

        return cbacVos;
    }


}
