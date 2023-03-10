package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.dto.CbicDto;
import com.ruoyi.system.domain.dto.cbaaDto;
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
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

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
private CalaMapper calaMapper;
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
@Resource
private CbpaMapper cbpaMapper;
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
    throw new SwException("??????????????????");
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
                throw new SwException("??????????????????");
            }
            if(itemList.get(i).getCbab09()==null){
                throw new SwException("????????????????????????");
            }
            if(itemList.get(i).getCbab11()==null){
                throw new SwException("????????????????????????");
            }
            if(itemList.get(i).getCbaa01()==null){
                throw new SwException("?????????????????????id????????????");
            }
            itemList.get(i).setCbab11(itemList.get(i).getCbab11());

            itemList.get(i).setCbab09(itemList.get(i).getCbab09());
            itemList.get(i).setCbab12(itemList.get(i).getCbab12());
           if(itemList.get(i).getCbab14()!=null){
               Cbsa cbsa = cbsaMapper.selectByPrimaryKey(itemList.get(i).getCbab14());
               GsGoodsSnCriteria sa =new GsGoodsSnCriteria();
               sa.createCriteria().andGoodsIdEqualTo(itemList.get(i).getCbab08());


               GsGoodsSn goodsSn=new GsGoodsSn();
               if(cbsa.getCbsa09()!=null){
                   goodsSn.setFactory(cbsa.getCbsa09());
               }
               gsGoodsSnMapper.updateByExampleSelective(goodsSn,sa);

           }
//            Cbaa cbaa = cbaaMapper.selectByPrimaryKey(itemList.get(i).getCbaa01());
//            //????????????id
//            Integer cbaa09 = cbaa.getCbaa09();
//            //??????????????????
//            Double qty = gsGoodsSkuMapper.selectByPrimaryKey(cbaa09).getQty();

            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//???10?????????????????????????????????
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
     * ?????????????????????
     */
    @Override
    public List<CbaaVo> selectSwJsTaskGoodsRelList(CbaaVo cbaaVo) {
        return cbaaMapper.selectSwJsTaskGoodsRelList(cbaaVo);
    }

    /**
     * ?????????????????????
     */
    @Override
    public List<CbaaVo> selectSwJsTaskGoodsRelLists(CbaaVo cbaaVo) {
       return  cbaaMapper.selectSwJsTaskGoodsRelLists(cbaaVo);

    }

    /**
     * ?????????????????????
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodesh(CbaaDo cbaaDo) {

        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (!cbaasw.get(0).getCbaa11().equals(TaskStatus.mr.getCode())) {
            throw new SwException("???????????????????????????");

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
     * ?????????????????????
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodefs(CbaaDo cbaaDo) {
        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (!cbaasw.get(0).getCbaa11().equals(TaskStatus.sh.getCode())) {
            throw new SwException("????????????????????????");

        }
        CbacCriteria example2 = new CbacCriteria();
        example2.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
        List<Cbac> cbacs = cbacMapper.selectByExample(example2);
        if (cbacs.size() > 0) {
            throw new SwException("?????????????????????");

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
     * ???????????????????????????
     */
    @SneakyThrows
    @Transactional
    @Override
    public int insertSwJsSkuBarcodebjwc(CbaaDo cbaaDo) {

        Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(cbaaDo.getCbaa01());

        if(cbaa1==null){
            throw new SwException("???????????????????????????");
        }
        if (!cbaa1.getCbaa11().equals(TaskStatus.sh.getCode())){

            throw new SwException("??????????????????????????????");

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
            throw new SwException("?????????????????????????????????");
        }
        List<Cbac> cbacs=null;
        for (Cbab value : cbabs1) {
            CbacCriteria example3 = new CbacCriteria();
            example3.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                    .andCbac08EqualTo(value.getCbab08());
            cbacs = cbacMapper.selectByExample(example3);
            if (cbacs.size() == 0) {
                throw new SwException("???????????????????????????????????????");
            } else {//zgl  ????????????????????????gs_goods_sn????????????id
                for (Cbac cbac : cbacs) {
                    if (cbac.getCbac09() != null && !("").equals(cbac.getCbac09())) {
                        GsGoodsSn gsGoodsSn = new GsGoodsSn();
                        gsGoodsSn.setLocationId(cbac.getCbac10());
                        gsGoodsSn.setWhId(cbaa1.getCbaa10());
                        GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
                        gsGoodsSnCriteria.createCriteria().andSnEqualTo(cbac.getCbac09());
                        gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, gsGoodsSnCriteria);
                    }
                }
            }
        }

        for(int j=0;j<cbacs.size();j++) {
            Double num = (double) cbacs.size();
            //????????????
        Integer outstore = cbaa.getCbaa09();
        Integer instore = cbaa.getCbaa10();
        GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
        //??????????????????id
        gsGoodsSkuDo.setWhId(outstore);
        //????????????id
        gsGoodsSkuDo.setGoodsId(cbacs.get(j).getCbac08());
        gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
        //????????????id?????????id??????????????????
        // ????????????
        List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
        if(gsGoodsSkus.size()==0){
            throw new SwException("???????????????????????????");
        }
        else {
            //??????
            baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
            GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
            //??????
            Double qty = gsGoodsSkus.get(0).getQty();
            if(qty==0){
                throw new SwException("??????????????????????????????0");
            }
            gsGoodsSkuDo1.setGoodsId(gsGoodsSkus.get(0).getGoodsId());
            gsGoodsSkuDo1.setWhId(outstore);
            gsGoodsSkuDo1.setLocationId(gsGoodsSkus.get(j).getLocationId());

            double v1 = qty - num;
            gsGoodsSkuDo1.setQty(v1);
            taskService.updateGsGoodsSku(gsGoodsSkuDo1);


        }

        //???????????????
        GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
        //??????????????????id
        gsGoodsSkuDo1.setWhId(instore);
        //????????????id
        gsGoodsSkuDo1.setGoodsId(cbacs.get(j).getCbac08());
        gsGoodsSkuDo1.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
        //????????????id?????????id??????????????????
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
            //??????
            baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
            GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();

            gsGoodsSkuDo2.setGoodsId(gsGoodsSkus1.get(0).getGoodsId());
            gsGoodsSkuDo2.setWhId(instore);
            gsGoodsSkuDo2.setLocationId(gsGoodsSkus1.get(j).getLocationId());
            //??????
            Double qty = gsGoodsSkus1.get(0).getQty();
            double v = qty + num;
            gsGoodsSkuDo2.setQty(v);
            taskService.updateGsGoodsSku(gsGoodsSkuDo2);
        }

            //????????????
            Integer storeid = cbaa1.getCbaa10();
            //????????????
            Integer storeid1 = cbaa1.getCbaa09();
            //??????
            String number = cbaa1.getCbaa07();
            //??????id
            Integer id = cbaa1.getCbaa01();

            //???????????????????????????
            CbabCriteria example1 = new CbabCriteria();
            example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                    .andCbab07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbab> cbabs = cbabMapper.selectByExample(example1);
            for (Cbab cbab : cbabs) {
                //???????????????
                Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbab.getCbab14());
                String vendername = cbsa.getCbsa08();
                //??????id
                Integer goodsid = cbab.getCbab08();

                //??????????????????????????????
                CbibDo cbibDo = new CbibDo();
                cbibDo.setCbib02(storeid);
                cbibDo.setCbib03(number);
                cbibDo.setCbib05(String.valueOf(TaskType.xsthd.getCode()));
                cbibDo.setCbib06(vendername);
                cbibDo.setCbib07(id);
                cbibDo.setCbib08(goodsid);
                cbibDo.setCbib11(cbab.getCbab09());
                cbibDo.setCbib12(cbab.getCbab12());
                cbibDo.setCbib13((double) 0);
                cbibDo.setCbib14((double) 0);

                cbibDo.setCbib17(TaskType.cqrk.getMsg());
                cbibDo.setCbib19(cbab.getCbab14());
                taskService.InsertCBIB(cbibDo);

                //??????????????????????????????
                CbibDo cbibDo1 = new CbibDo();
                cbibDo1.setCbib02(storeid1);
                cbibDo1.setCbib03(number);
                cbibDo1.setCbib05(String.valueOf(TaskType.zjd.getCode()));
                cbibDo1.setCbib06(vendername);
                cbibDo1.setCbib07(id);
                cbibDo1.setCbib08(goodsid);
                cbibDo1.setCbib11((double) 0);
                cbibDo1.setCbib12((double) 0);
                cbibDo1.setCbib13(cbab.getCbab09());
                cbibDo1.setCbib14(cbab.getCbab12());

                cbibDo1.setCbib17(TaskType.cqrk.getMsg());
                cbibDo1.setCbib19(cbab.getCbab14());
                taskService.InsertCBIB(cbibDo1);

            }

        }
        return cbaaMapper.updateByExampleSelective(cbaa, example);
    }
    /**
     * ???????????????????????????
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodeqxwc(CbaaDo cbaaDo) {
        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (!cbaasw.get(0).getCbaa11().equals(TaskStatus.bjwc.getCode())) {
            throw new SwException("??????????????????????????????");

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
     * ?????????????????????
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodeupdate(CbaaDo cbaaDo) {
        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (!cbaasw.get(0).getCbaa11().equals(TaskStatus.mr.getCode())) {
            throw new SwException("??????????????????");

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
            throw new SwException("?????????id????????????");
        }
        CbacCriteria example2 = new CbacCriteria();
        example2.createCriteria().andCbaa01EqualTo(cbaa01)
                .andCbac07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbac> cbacss = cbacMapper.selectByExample(example2);


        int size;
        for (CbaasVo cbaasVo1 : cbaasVos) {
            CbacCriteria example = new CbacCriteria();
            example.createCriteria().andCbaa01EqualTo(cbaa01)
                    .andCbac07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                    .andCbac08EqualTo(cbaasVo1.getCbab08());
            List<Cbac> cbacs = cbacMapper.selectByExample(example);
            size = cbacs.size();
            if (size>0) {
                for (Cbac cbac : cbacs) {

                    ScanVo scanVo = new ScanVo();
                    if (cbac.getCbac08() != null) {
                        Cbpb cbpb = cbpbMapper.selectByPrimaryKey(cbac.getCbac08());
                        if (cbpb != null) {
                            scanVo.setCbpb08(cbpb.getCbpb08());
                            scanVo.setCbpb12(cbpb.getCbpb12());
                            scanVo.setCbpb15(cbpb.getCbpb15());
                            if (cbpb.getCbpb10() != null) {
                                Cala cala = calaMapper.selectByPrimaryKey(cbpb.getCbpb10());
                                if (cala != null) {
                                    scanVo.setPinpai(cala.getCala08());
                                }
                            }
                            //??????
                            if (cbpb.getCbpb14() != null) {
                                Cbpa cbpa = cbpaMapper.selectByPrimaryKey(cbpb.getCbpb14());
                                if (cbpa != null) {
                                    scanVo.setLx(cbpa.getCbpa08());
                                }
                            }

                        }
                    }
                    if (cbac.getCbac10() != null) {
                        Cbla cbla = cblaMapper.selectByPrimaryKey(cbac.getCbac10());
                        if (cbla != null) {
                            scanVo.setKwm(cbla.getCbla09());

                        }

                    }
                    scanVo.setSn(cbac.getCbac09());
                    scanVo.setCbpe03(cbac.getCbac03());
                    goods.add(scanVo);

                    cbaasVo1.setSaoma(size);

                }

                cbaasVo1.setSaoma(size);


            }
        }


        if(cbacss.size()>0) {
    for (int i = 0; i < cbaasVos.size(); i++) {
    if(cbaasVos.get(0).getCbab15()!=null){
        Integer cbab15 = cbaasVos.get(0).getCbab15();
        if(cbab15!=null && cbab15==1){
            cbaasVos.get(0).setOrderClass("????????????");
        }else{
            cbaasVos.get(0).setOrderClass("????????????");

        }}



       // cbaasVos.get(i).setSaoma(size);
    }
    cbaasVos.get(0).setGoods(goods);
}
        return cbaasVos;
    }

    @Transactional
    @Override
    public int insertSwJsStoress(List<Cbac> itemList) {
        if(itemList.size() == 0){
            throw new SwException("????????????????????????");
        }
        if(itemList.get(0).getCbaa01() == null){
            throw new SwException("???????????????id????????????");
        }
        Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(itemList.get(0).getCbaa01());
        if (!cbaa1.getCbaa11().equals(TaskStatus.sh.getCode())) {
            throw new SwException("????????????????????????");
        }
        Integer instore = cbaa1.getCbaa10();

        CbabCriteria cas = new CbabCriteria();
        cas.createCriteria().andCbaa01EqualTo(itemList.get(0).getCbaa01())
                .andCbab07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbab> cbphs = cbabMapper.selectByExample(cas);
        if (cbphs.size() == 0) {
            throw new SwException("?????????????????????");
        }
        Set<Integer> uio = null;
        for (Cbab cbph : cbphs) {
            Integer cbph08 = cbph.getCbab08();
            uio = new HashSet<>();
            uio.add(cbph08);
        }

        Integer cbaa09 = cbaa1.getCbaa09();
        GsGoodsSkuCriteria example5 = new GsGoodsSkuCriteria();
        example5.createCriteria().andWhIdEqualTo(cbaa09);
        List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example5);
        if (gsGoodsSkus.size() == 0) {
            throw new SwException("??????????????????????????????");
        }
        Set<Integer> nio = null;
        for (GsGoodsSku goodsSkus : gsGoodsSkus) {
            Integer cbph08 = goodsSkus.getWhId();
            nio = new HashSet<>();
            nio.add(cbph08);
        }

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbacMapper mapper = session.getMapper(CbacMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {

            if (itemList.get(i).getCbac08() == null) {
                throw new SwException("??????id????????????");
            }
            if(!uio.contains(itemList.get(i).getCbac08())){
                throw new SwException("???????????????????????????????????????");
            }

            if(!nio.contains(itemList.get(i).getCbac08())){
                throw new SwException("??????????????????????????????");
            }

            Cbla cbla = cblaMapper.selectByPrimaryKey(itemList.get(i).getCbac10());
            if (cbla == null) {
                throw new SwException("???????????????");
            }
            if (!cbla.getCbla03().equals(instore)) {
                throw new SwException("???????????????????????????");
            }
            String sn = itemList.get(i).getCbac09();
            CbacCriteria erd = new CbacCriteria();
            erd.createCriteria().andCbac09EqualTo(sn)
                    .andCbac07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbac> cbpiList = cbacMapper.selectByExample(erd);
            if (cbpiList.size() > 0) {
                throw new SwException("???sn?????????");
            }
            //??????sn????????????????????????sn
            GsGoodsSnDo gsGoodsSnDoss = new GsGoodsSnDo();
            gsGoodsSnDoss.setSn(sn);
            baseCheckService.checkGsGoodsSn(gsGoodsSnDoss);

            itemList.get(i).setCbac03(date);
            itemList.get(i).setCbac04(Math.toIntExact(userid));
            itemList.get(i).setCbac05(date);
            itemList.get(i).setCbac06(Math.toIntExact(userid));
            itemList.get(i).setCbac07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));

           /* //???????????????????????????????????????
            Cbaa cbaa = cbaaMapper.selectByPrimaryKey(itemList.get(i).getCbaa01());
            if(cbaa==null){
                throw new SwException("??????????????????");
            }
            //????????????
            Integer outstore = cbaa.getCbaa09();
            Integer instore = cbaa.getCbaa10();
            GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
            //??????????????????id
            gsGoodsSkuDo.setWhId(outstore);
            //????????????id
            gsGoodsSkuDo.setGoodsId(itemList.get(i).getCbac08());
            gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //????????????id?????????id??????????????????
            // ????????????
            List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
            if(gsGoodsSkus.size()==0){
             throw new SwException("???????????????????????????");
            }
            else {
                //??????
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                //??????
                Double qty = gsGoodsSkus.get(0).getQty();
                if(qty==0){
                    throw new SwException("??????????????????????????????0");
                }
                gsGoodsSkuDo1.setGoodsId(gsGoodsSkus.get(0).getGoodsId());
                gsGoodsSkuDo1.setWhId(outstore);
                gsGoodsSkuDo1.setLocationId(gsGoodsSkus.get(i).getLocationId());
                double v = 1.0;
                double v1 = qty - v;
                gsGoodsSkuDo1.setQty(v1);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);


            }

            //???????????????
            GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
            //??????????????????id
            gsGoodsSkuDo1.setWhId(instore);
            //????????????id
            gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbac08());
            gsGoodsSkuDo1.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //????????????id?????????id??????????????????
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
                //??????
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();

                gsGoodsSkuDo2.setGoodsId(gsGoodsSkus1.get(0).getGoodsId());
                gsGoodsSkuDo2.setWhId(instore);
                gsGoodsSkuDo2.setLocationId(gsGoodsSkus1.get(i).getLocationId());
                //??????
                Double qty = gsGoodsSkus1.get(0).getQty();
                double v = qty + 1.0;
                gsGoodsSkuDo2.setQty(v);
                taskService.updateGsGoodsSku(gsGoodsSkuDo2);

            }*/
            //??????sn???
            GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setSn(itemList.get(i).getCbac09());
            gsGoodsSnDo.setStatus(GoodsType.yrk.getCode());
            gsGoodsSnDo.setOutTime(date);
            gsGoodsSnDo.setGroudStatus(Groudstatus.SJ.getCode());
            taskService.updateGsGoodsSn(gsGoodsSnDo);

            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//???10?????????????????????????????????
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
            throw new SwException("???????????????????????????");
        }

        if(cbaaDo.getCbaa01()==null){
            throw new SwException("?????????id????????????");
        }
        List<Cbab> goods = cbaaDo.getGoods();
        if(goods==null||goods.size()==0){
            throw new SwException("???????????????????????????");
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
        cbabMapper.deleteByExample(cbabCriteria);

        Cbab cbab;
        for (Cbab good : goods) {
            cbab = new Cbab();
       /*     if(good.getCbab01()==null){
                throw new SwException("???????????????id????????????");
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
            throw new SwException("?????????id????????????");
        }
        Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(cbaaDo.getCbaa01());
if(cbaa1==null){
            throw new SwException("??????????????????");
        }
if(!cbaa1.getCbaa11().equals(TaskStatus.mr.getCode())){
            throw new SwException("???????????????????????????");
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
//?????????????????????
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int transferordersout(Cbac itemList) {

        log.info("?????????"+Thread.currentThread().getName()+itemList.getCbac09());
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();


        if (itemList.getCbaa01() == null) {
            throw new SwException("?????????id????????????");
        }
        Cbaa cbaa = cbaaMapper.selectByPrimaryKey(itemList.getCbaa01());
        if (cbaa == null) {
            throw new SwException("??????????????????");
        }
        if( cbaa.getCbaa09()==null){
            throw new SwException("???????????????????????????");
        }
        if(itemList.getCbac09()!=null) {
            List<GsGoodsSn> gsGoodsSns = getGsGoodsSns(itemList);
            if(gsGoodsSns.size()>0){
                Cbpb cbpb = cbpbMapper.selectByPrimaryKey(gsGoodsSns.get(0).getGoodsId());
                if(Objects.equals(cbpb.getCbpb12(), itemList.getCbac09())){
                    throw new SwException("sn?????????");
                }
            }
        }

        //???
        String cbic10 = itemList.getCbac09();
        String uuid = UUID.randomUUID().toString();
        Boolean lock = redisTemplate.opsForValue().setIfAbsent(cbic10, uuid, 3, TimeUnit.SECONDS);
        if (Boolean.FALSE.equals(lock)) {
            throw new SwException("sn???????????????????????????");
        }
        redisTemplate.opsForValue().get(cbic10);


        GsGoodsSn gsGoodsSn;
        try {
            Integer outstoreid = cbaa.getCbaa09();

            CbabCriteria cbabCriteria = new CbabCriteria();
            cbabCriteria.createCriteria().andCbaa01EqualTo(itemList.getCbaa01());
            List<Cbab> cbphs = cbabMapper.selectByExample(cbabCriteria);
            Set<Integer> sio = cbphs.stream().map(Cbab::getCbab08).collect(Collectors.toSet());


            if(itemList.getCbac09()==null){
               throw new SwException("sn????????????");
           }
            CbacCriteria cbacCriteria = new CbacCriteria();
            cbacCriteria.createCriteria().andCbac09EqualTo(itemList.getCbac09())
                    .andCbaa01EqualTo(itemList.getCbaa01());
            List<Cbac> cbacs = cbacMapper.selectByExample(cbacCriteria);
            if(cbacs.size()>0){
                throw new SwException("sn????????????");
             /*   if(cbacs.get(0).getCbac07().equals(DeleteFlagEnum.NOT_DELETE.getCode())){
                    throw new SwException("sn????????????");
                }
                else {
                Cbac cbac = new Cbac();
                cbac.setCbac07(DeleteFlagEnum.NOT_DELETE.getCode());
                cbacMapper.updateByExampleSelective(cbac,cbacCriteria);
            }*/

            }

            //??????sn
            GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
            gsGoodsSnCriteria.createCriteria().andSnEqualTo(itemList.getCbac09());
            List<GsGoodsSn> gsGoodsSnList = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
            if (CollectionUtils.isEmpty(gsGoodsSnList)) {
                throw new SwException("sn?????????");
            }
            //??????sn??????????????????
            if(gsGoodsSnList.get(0).getStatus()==3){
                throw new SwException("???sn????????????");
            }
            if(gsGoodsSnList.get(0).getLocationId()==null){
                throw new SwException("sn??????id????????????");
            }
            Cbla cbla = cblaMapper.selectByPrimaryKey(gsGoodsSnList.get(0).getLocationId());
            if(!cbla.getCbla10().equals(outstoreid)){
                throw new SwException("sn????????????????????????");
            }
            if(gsGoodsSnList.get(0).getGoodsId()==null){
                throw new SwException("sn??????id????????????");
            }
            if(!sio.contains(gsGoodsSnList.get(0).getGoodsId())){
                throw new SwException("sn??????id????????????????????????");
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
            this.redisTemplate.execute(new DefaultRedisScript<>(script, Boolean.class), Collections.singletonList("lock"), uuid);

        }


        gsGoodsSnMapper.updateByPrimaryKeySelective(gsGoodsSn);

        cbacMapper.insertSelective(itemList);

            return 1;
    }

    private List<GsGoodsSn> getGsGoodsSns(Cbac itemList) {
        GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
        gsGoodsSnCriteria.createCriteria().andSnEqualTo(itemList.getCbac09());
        return gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
    }


    public int updates(CbaasVo cbaasVo){
        List<CbaasVo> cbaasVos = selectSwJsTaskGoodsRelListss(cbaasVo);
        Optional.ofNullable(cbaasVo.getCbac10()).orElseThrow(() -> new SwException("???????????????????????????"));
        Optional.ofNullable(cbaasVo.getCbac12()).orElseThrow(() -> new SwException("???????????????????????????"));
        Cbla cbla = cblaMapper.selectByPrimaryKey(cbaasVo.getCbac10());
        Optional.ofNullable(cbla.getCbla09()).orElseThrow(() -> new SwException("????????????????????????"));
        String cbla09 = cbla.getCbla09();
        if(cbaasVos.size()>0){
            int size=0;
            if(cbaasVos.get(0).getGoods().size()>0){
                if(cbaasVos.get(0).getGoods().stream().filter(s -> s.getKwm()!=null).count()>0){
                    List<ScanVo> collect = cbaasVos.get(0).getGoods().stream().filter(s -> s.getKwm().equals(cbla09)).collect(Collectors.toList());
                    if(collect.size()>0){
                        size = collect.size();
                    }
                }


      GsGoodsSkuCriteria gsGoodsSkuCriteria = new GsGoodsSkuCriteria();
            gsGoodsSkuCriteria.createCriteria().andLocationIdEqualTo(cbaasVo.getCbac10());
            List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(gsGoodsSkuCriteria);
            if(gsGoodsSkus.size()>0){
                double sum = gsGoodsSkus.stream().mapToDouble(GsGoodsSku::getQty).sum();
                if(size+sum+1>cbla.getCbla11()){
                    throw new SwException("????????????,??????"+cbla09);
                }
            }else{
                if(size+1>cbla.getCbla11()){
                    throw new SwException("????????????,??????"+cbla09);
                }
            }

                int goodsize = 0;
            //??????????????????
                List<ScanVo> collects = cbaasVos.get(0).getGoods().stream().filter(s -> s.getCbpb15().equals(cbaasVo.getCbac12())).collect(Collectors.toList());
                if(collects.size()>0){
                     goodsize = collects.size();
                }
                CbpbCriteria cbpbCriteria = new CbpbCriteria();
                cbpbCriteria.createCriteria().andCbpb15EqualTo(cbaasVo.getCbac12());
                List<Cbpb> cbpbs = cbpbMapper.selectByExample(cbpbCriteria);
                if(cbpbs.size()==0){
                    throw new SwException("???????????????");
                }
                Optional.ofNullable(cbpbs.get(0).getCbpb01()).orElseThrow(() -> new SwException("??????id??????"));

                double sum = cbaasVos.stream().filter(s -> s.getCbab08().equals(cbpbs.get(0).getCbpb01()))
                        .collect(Collectors.toList()).stream().mapToDouble(CbaasVo::getCbab09).sum();
                if(goodsize+1>sum){
                    throw new SwException("???????????????????????????????????????");
                }


            }
        }
        return 1;
    }
    public int update(CbaasVo cbaasVo){
        List<CbaasVo> cbaasVos = selectSwJsTaskGoodsRelListss(cbaasVo);
        Optional.ofNullable(cbaasVo.getCbac10()).orElseThrow(() -> new SwException("???????????????????????????"));
        Optional.ofNullable(cbaasVo.getCbac12()).orElseThrow(() -> new SwException("???????????????????????????"));
        Cbla cbla = cblaMapper.selectByPrimaryKey(cbaasVo.getCbac10());
        Optional.ofNullable(cbla.getCbla09()).orElseThrow(() -> new SwException("????????????????????????"));
        CbacCriteria cbacCriteria = new CbacCriteria();
        cbacCriteria.createCriteria().andCbaa01EqualTo(cbaasVo.getCbaa01())
                .andCbac09EqualTo(cbaasVo.getCbac09())
                .andCbac14EqualTo(2)
                .andCbac07EqualTo(0);
        List<Cbac> cbacs = cbacMapper.selectByExample(cbacCriteria);
        if(cbacs.size()>0){
            throw new SwException("sn????????????"+cbaasVo.getCbac09());
        }




        CbpbCriteria cbpbCriteria = new CbpbCriteria();
        cbpbCriteria.createCriteria().andCbpb15EqualTo(cbaasVo.getCbac12());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(cbpbCriteria);



        GsGoodsSnCriteria  gsGoodsSnCriteria = new GsGoodsSnCriteria();
        gsGoodsSnCriteria.createCriteria().andSnEqualTo(cbaasVo.getCbac09());
        List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
        if(gsGoodsSns.size()>0){

            if(cbpbs.size()>0){
                if(!gsGoodsSns.get(0).getGoodsId().equals(cbpbs.get(0).getCbpb01())){
                    throw new SwException("sn???????????????upc????????????sn???"+cbaasVo.getCbac09()+"???????????????"+cbpbs.get(0).getCbpb12());
                }
            }
        }




        String cbla09 = cbla.getCbla09();
        if(cbaasVos.size()>0){
            int size=0;

            if(cbpbs.size()>0) {
                CbacCriteria cbacCriteria1 = new CbacCriteria();
                cbacCriteria1.createCriteria().andCbaa01EqualTo(cbaasVo.getCbaa01())
                        .andCbac08EqualTo(cbpbs.get(0).getCbpb01())
                        .andCbac14EqualTo(2);
                List<Cbac> cbacs1 = cbacMapper.selectByExample(cbacCriteria1);
                if (cbacs1.size() > 0) {
                    double sum = cbaasVos.stream().filter(s -> s.getCbab08() != null)
                            .filter(s -> s.getCbab08().equals(cbpbs.get(0).getCbpb01()))
                            .collect(Collectors.toList()).stream().mapToDouble(CbaasVo::getCbab09).sum();
                    if(sum==cbacs1.size()){
                        throw new SwException("???????????????????????????");
                    }

                }
            }
            if(cbaasVos.get(0).getGoods().size()>0){






                if(cbaasVos.get(0).getGoods().stream().anyMatch(s -> s.getKwm() != null)){

                    List<ScanVo> collect = cbaasVos.get(0).getGoods().stream().filter(s -> s.getKwm() != null)
                                          .filter(s -> s.getKwm().equals(cbla09)).collect(Collectors.toList());
                    if(collect.size()>0){
                        size = collect.size();
                    }
                }


                GsGoodsSkuCriteria gsGoodsSkuCriteria = new GsGoodsSkuCriteria();
                gsGoodsSkuCriteria.createCriteria().andLocationIdEqualTo(cbaasVo.getCbac10());
                List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(gsGoodsSkuCriteria);
                if(gsGoodsSkus.size()>0){
                    double sum = gsGoodsSkus.stream().mapToDouble(GsGoodsSku::getQty).sum();
                    if(size+sum+1>cbla.getCbla11()){
                        throw new SwException("????????????,??????"+cbla09);
                    }
                }else{
                    if(size+1>cbla.getCbla11()){
                        throw new SwException("????????????,??????"+cbla09);
                    }
                }



            }
        }
        return 1;
    }

//?????????????????????
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int transferordersin(Cbac itemList) {
        Date date = new Date();

        System.out.println("???????????????????????????id"+Thread.currentThread().getId()+"????????????"+date);

        Long userid = SecurityUtils.getUserId();


        if (itemList.getCbaa01() == null) {
            throw new SwException("?????????id????????????");
        }

        if (itemList.getCbac12() == null) {
            throw new SwException("upc????????????");
        }
     CbpbCriteria cbpbCriteria = new CbpbCriteria();
        cbpbCriteria.createCriteria().andCbpb15EqualTo(itemList.getCbac12());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(cbpbCriteria);
        if(cbpbs.size()==0){
            throw new SwException("upc?????????");
        }
        Integer goodsid = cbpbs.get(0).getCbpb01();



        if(itemList.getCbac09()!=null) {
            GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
            gsGoodsSnCriteria.createCriteria().andSnEqualTo(itemList.getCbac09());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
            if(gsGoodsSns.size()>0){
                Cbpb cbpb = cbpbMapper.selectByPrimaryKey(gsGoodsSns.get(0).getGoodsId());
                if(Objects.equals(cbpb.getCbpb12(), itemList.getCbac09())){
                    throw new SwException("sn?????????");
                }
            }
        }

        Cbaa cbaa = cbaaMapper.selectByPrimaryKey(itemList.getCbaa01());
        if( cbaa.getCbaa10()==null){
            throw new SwException("???????????????????????????");
        }

        String cbic10 = itemList.getCbac09();
        String uuid = UUID.randomUUID().toString();
        Boolean lock = redisTemplate.opsForValue().setIfAbsent(cbic10, uuid, 3, TimeUnit.SECONDS);
        if (Boolean.FALSE.equals(lock)) {
            throw new SwException("sn???????????????????????????");
        }
        redisTemplate.opsForValue().get(cbic10);


        try {
            CbabCriteria cbabCritesria = new CbabCriteria();
            cbabCritesria.createCriteria().andCbaa01EqualTo(itemList.getCbaa01())
                    .andCbab08EqualTo(goodsid);
            List<Cbab> cbabs = cbabMapper.selectByExample(cbabCritesria);
            if (cbabs.size() == 0) {
                throw new SwException("?????????????????????????????????");
            }


            Integer instoreid = cbaa.getCbaa10();

            CbabCriteria cbabCriteria = new CbabCriteria();
            cbabCriteria.createCriteria().andCbaa01EqualTo(itemList.getCbaa01());
            List<Cbab> cbphs = cbabMapper.selectByExample(cbabCriteria);
            Set<Integer> sio = cbphs.stream().map(Cbab::getCbab08).collect(Collectors.toSet());


            Integer cbaa01 = itemList.getCbaa01();
            if(cbaa01==null){
                throw new SwException("?????????id????????????");
            }
            //??????????????????
            CbwaCriteria exampse1 = new CbwaCriteria();
            exampse1.createCriteria().andCbwa12EqualTo("????????????");
            List<Cbwa> cbwas = cbwaMapper.selectByExample(exampse1);
            Set<Integer> fhji = cbwas.stream().map(Cbwa::getCbwa01).collect(Collectors.toSet());
            Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(cbaa01);
            if(fhji.contains(cbaa1.getCbaa09()) ){

                CbaasVo cbaasVo = new CbaasVo();
                cbaasVo.setCbaa01(itemList.getCbaa01());
                cbaasVo.setCbac10(itemList.getCbac10());
                cbaasVo.setCbac12(itemList.getCbac12());
                updates(cbaasVo);

                Cbla cbla = cblaMapper.selectByPrimaryKey(itemList.getCbac10());
                if(cbla!=null){
                    if(!cbla.getCbla10().equals(cbaa.getCbaa10())){
                        throw new SwException("??????????????????????????????????????????");
                    }
                }
                GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
                gsGoodsSnCriteria.createCriteria().andSnEqualTo(itemList.getCbac09());
                List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
                if(gsGoodsSns.size()>0){
                    if(gsGoodsSns.get(0).getStatus()==1){
                        if(gsGoodsSns.get(0).getLocationId()==0){
                            GsGoodsSn gsGoodsSn = new GsGoodsSn();
                            gsGoodsSn.setLocationId(itemList.getCbac10());
                            gsGoodsSn.setStatus((byte) 1);
                            gsGoodsSn.setGroudStatus((byte) 1);
                            gsGoodsSn.setPrice(cbabs.get(0).getCbab11());
                        }else{
                            throw new SwException("sn????????????");
                        }

                    }
                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
                    gsGoodsSn.setLocationId(itemList.getCbac10());
                    gsGoodsSn.setStatus((byte) 1);
                    gsGoodsSn.setGroudStatus((byte) 1);
                    gsGoodsSn.setPrice(cbabs.get(0).getCbab11());

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
                    gsGoodsSn.setPrice(cbabs.get(0).getCbab11());
                gsGoodsSnMapper.insertSelective(gsGoodsSn);}

                //??????????????????????????????
                CbacCriteria cbacCriterias = new CbacCriteria();
                cbacCriterias.createCriteria().andCbaa01EqualTo(itemList.getCbaa01())
                        .andCbac09EqualTo(itemList.getCbac09());
                List<Cbac> cbacss = cbacMapper.selectByExample(cbacCriterias);
                if(cbacss.size()>0){
                    if(cbacss.get(0).getCbac14()==1){
                        Cbac cbac = Cbac.getInstance();
                        cbac.setCbaa01(itemList.getCbaa01());
                        cbac.setCbac09(itemList.getCbac09());
                        cbac.setCbac10(itemList.getCbac10());
                        cbac.setCbac08(goodsid);
                        cbac.setCbac14(2);
                        cbacMapper.updateByExampleSelective(cbac,cbacCriterias);
                    }else {
                        throw new SwException("?????????????????????");
                    }

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
                    cbacMapper.insertSelective(itemList);
               }
            }
            else{
                CbaasVo cbaasVo = new CbaasVo();
                cbaasVo.setCbaa01(itemList.getCbaa01());
                cbaasVo.setCbac10(itemList.getCbac10());
                cbaasVo.setCbac09(itemList.getCbac09());
                cbaasVo.setCbac12(itemList.getCbac12());
                update(cbaasVo);

                //??????????????????????????????
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
                        throw new SwException("??????????????????????????????");
                    }
                }



            CbacCriteria cbaceria = new CbacCriteria();
            cbaceria.createCriteria().andCbac09EqualTo(itemList.getCbac09())
                    .andCbaa01EqualTo(itemList.getCbaa01());
            List<Cbac> cbacs = cbacMapper.selectByExample(cbaceria);
            if(cbacs.size()==0){
                throw new SwException("sn?????????");}




            if (itemList.getCbac10() == null) {
                throw new SwException("??????id????????????");
            }
            Cbla cbla = cblaMapper.selectByPrimaryKey(itemList.getCbac10());
            if(!cbla.getCbla10().equals(instoreid)){
                throw new SwException("???????????????????????????????????????");
            }

            if(itemList.getCbac09()==null){
                throw new SwException("sn????????????");
            }
            //??????sn
            GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
            gsGoodsSnCriteria.createCriteria().andSnEqualTo(itemList.getCbac09());
            List<GsGoodsSn> gsGoodsSnList = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
            if (CollectionUtils.isEmpty(gsGoodsSnList)) {
                throw new SwException("sn?????????");
            }
            //??????sn??????????????????
           if(gsGoodsSnList.get(0).getStatus()==1){
               throw new SwException("???sn????????????");
            }



            if(!sio.contains(gsGoodsSnList.get(0).getGoodsId())){
                throw new SwException("sn??????id????????????????????????");
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
                gsGoodsSn.setPrice(cbabs.get(0).getCbab11());


                gsGoodsSnMapper.updateByPrimaryKeySelective(gsGoodsSn);

                CbacCriteria cbacCriteria = new CbacCriteria();
                cbacCriteria.createCriteria().andCbac09EqualTo(itemList.getCbac09())
                        .andCbaa01EqualTo(itemList.getCbaa01());

            return     cbacMapper.updateByExampleSelective(itemList, cbacCriteria);
            }
        }
        finally {

            String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                    "then " +
                    "return redis.call('del', KEYS[1]) " +
                    "else " +
                    "return 0 " +
                    "end";
            this.redisTemplate.execute(new DefaultRedisScript<>(script, Boolean.class), Collections.singletonList("lock"), uuid);

        }


        return 1;    }

    //??????????????????
    @Override
    public int transferordersoutbjwc(CbaaDo cbaaDo) throws InterruptedException {


        Long userid = SecurityUtils.getUserId();
        Date date = new Date();

        Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(cbaaDo.getCbaa01());

        if (cbaa1 == null) {
            throw new SwException("???????????????????????????");
        }
        if (cbaa1.getCbaa11().equals(TaskStatus.sh.getCode())) {
        } else {
            throw new SwException("??????????????????????????????");
        }


        List<Cbac> selectbytype = cbaaMapper.selectbytype(cbaaDo.getCbaa01());
        if(selectbytype.size()>1){
            throw new SwException("????????????????????????");
        }
        //??????????????????
        List<Cbwa> cbwas = getCbwas();
        Set<Integer> sio = cbwas.stream().map(Cbwa::getCbwa01).collect(Collectors.toSet());
        if(sio.contains(cbaa1.getCbaa09())){
            extracted(cbaaDo, userid, date, cbaa1);
        } else {
            //????????????
            extracted(cbaaDo, date, cbaa1);
        }

        return 1;
    }

    private List<Cbwa> getCbwas() {
        CbwaCriteria exampse1 = new CbwaCriteria();
        exampse1.createCriteria().andCbwa12EqualTo("????????????");
        return cbwaMapper.selectByExample(exampse1);
    }

    private void extracted(CbaaDo cbaaDo, Date date, Cbaa cbaa1) throws InterruptedException {
        int sdw = 0;
        CbabCriteria etur = new CbabCriteria();
        etur.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
        List<Cbab> opi = cbabMapper.selectByExample(etur);
        if (opi.size() == 0) {
            throw new SwException("?????????????????????");
        }
        for (Cbab cbab : opi) {
            Double cbab09 = cbab.getCbab09();
            sdw += cbab09;
        }
        CbacCriteria etur1 = new CbacCriteria();
        etur1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
        List<Cbac> opi1 = cbacMapper.selectByExample(etur1);
        if (opi1.size() < sdw) {
            throw new SwException("??????????????????????????????????????????????????????");
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
            throw new SwException("?????????????????????????????????");
        }
        List<Cbac> cbacs;
        for (Cbab cbab : cbabs1) {
            CbacCriteria example3 = new CbacCriteria();
            example3.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                    .andCbac08EqualTo(cbab.getCbab08());
            //.andCbac14EqualTo(2);
            cbacs = cbacMapper.selectByExample(example3);
            if (cbacs.size() == 0) {
                throw new SwException("???????????????????????????????????????");

            }
            // Double num = (double) cbacs.size();


            for (Cbac cbac : cbacs) {
                if (cbac.getCbac11() == null) {
                    throw new SwException("???????????????????????????");

                }
                if (cbac.getCbac08() == null) {
                    throw new SwException("?????????????????????id??????");

                }
                //????????????
                Integer outstore = cbaa1.getCbaa09();

                GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
                //??????????????????id
                gsGoodsSkuDo.setWhId(outstore);
                //????????????id
                gsGoodsSkuDo.setGoodsId(cbac.getCbac08());
                gsGoodsSkuDo.setLocationId(cbac.getCbac11());
                gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                //????????????id?????????id??????????????????
                // ????????????
                List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
                if (gsGoodsSkus.size() == 0) {
                    throw new SwException("?????????????????????????????????");
                }
                else {
                    //??????
                    baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                    GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                    //??????
                    Double qty = gsGoodsSkus.get(0).getQty();
                    if (qty == 0) {
                        throw new SwException("??????????????????????????????0");
                    }
                    gsGoodsSkuDo1.setGoodsId(cbac.getCbac08());
                    gsGoodsSkuDo1.setWhId(outstore);
                    gsGoodsSkuDo1.setLocationId(cbac.getCbac11());
                    gsGoodsSkuDo1.setQty(qty - 1);
                    taskService.updateGsGoodsSku(gsGoodsSkuDo1);


                }
            }
        }

        //????????????
        //????????????
        Integer storeid1 = cbaa1.getCbaa09();
        //??????
        String number = cbaa1.getCbaa07();
        //??????id
        Integer id = cbaa1.getCbaa01();

        //???????????????????????????
        CbabCriteria example1 = new CbabCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbab07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbab> cbabs = cbabMapper.selectByExample(example1);
        for (Cbab cbab : cbabs) {
            //???????????????
            Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbab.getCbab14());
            String vendername = cbsa.getCbsa08();
            //??????id
            Integer goodsid = cbab.getCbab08();


            //??????????????????????????????
            CbibDo cbibDo1 = new CbibDo();
            cbibDo1.setCbib02(storeid1);
            cbibDo1.setCbib03(number);
            cbibDo1.setCbib05(String.valueOf(TaskType.zjd.getCode()));
            cbibDo1.setCbib06(vendername);
            cbibDo1.setCbib07(id);
            cbibDo1.setCbib08(goodsid);
            cbibDo1.setCbib11((double) 0);
            cbibDo1.setCbib12((double) 0);
            cbibDo1.setCbib13(cbab.getCbab09());
            cbibDo1.setCbib14(cbab.getCbab11() * cbab.getCbab09());

            cbibDo1.setCbib17(TaskType.zjd.getMsg());
            cbibDo1.setCbib19(cbab.getCbab14());
            taskService.InsertCBIB(cbibDo1);


            /*TranUseQtyDo tranUseQtyDo = new TranUseQtyDo();
            tranUseQtyDo.setGoodsId(goodsid);
            tranUseQtyDo.setQty(cbabs.get(i).getCbab09());
            tranUseQtyDo.setInWhId(cbaa1.getCbaa10());
            tranUseQtyDo.setOutWhId(cbaa1.getCbaa09());
            orderDistributionService.diaoboUseOp(tranUseQtyDo);*/
        }

        cbaaMapper.updateByExampleSelective(cbaa, example);
    }

    private void extracted(CbaaDo cbaaDo, Long userid, Date date, Cbaa cbaa1) throws InterruptedException {
        CbabCriteria cbabCriteria = new CbabCriteria();
        cbabCriteria.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
        List<Cbab> cbabs = cbabMapper.selectByExample(cbabCriteria);
        if(cbabs.size()==0){
            throw new SwException("?????????????????????");
        }
        for (Cbab cbab : cbabs) {
            if (cbab.getCbab09() == null) {
                throw new SwException("????????????????????????");
            }
            Double num = cbab.getCbab09();
            if (cbab.getCbab08() == null) {
                throw new SwException("????????????id????????????");
            }
            Integer goodsid = cbab.getCbab08();

          /*  GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
            example.createCriteria()
                    .andGoodsIdEqualTo(goodsid)
                    .andWhIdEqualTo(cbaa1.getCbaa09());
            List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);*/
            List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByGoodsIdAndWhId(goodsid, cbaa1.getCbaa09());

            //?????????????????????

            if (gsGoodsSkus.size() == 0) {
                throw new SwException("?????????????????????????????????");
            }
            for (GsGoodsSku goodsSkus : gsGoodsSkus) {

                if (goodsSkus.getLocationId() == null) {
                    Integer id = gsGoodsSkus.get(0).getId();
                    GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);

                    if (num > gsGoodsSku.getQty()) {
                        throw new SwException("??????????????????????????????");

                    }
                    gsGoodsSku.setId(id);
                    gsGoodsSku.setQty(gsGoodsSku.getQty() - num);
                    gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                    gsGoodsSku.setUpdateTime(date);
                    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);

/*  TranUseQtyDo tranUseQtyDo = new TranUseQtyDo();
tranUseQtyDo.setGoodsId(goodsid);
tranUseQtyDo.setQty(num);
tranUseQtyDo.setInWhId(cbaa1.getCbaa10());
tranUseQtyDo.setOutWhId(cbaa1.getCbaa09());
orderDistributionService.diaoboUseOp(tranUseQtyDo);*/

                }
            }
            //??????
            //???????????????
            Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbab.getCbab14());


            //??????id


            //??????????????????????????????
            CbibDo cbibDo1 = new CbibDo();
            cbibDo1.setCbib02(cbaa1.getCbaa09());
            cbibDo1.setCbib03(cbaa1.getCbaa07());
            cbibDo1.setCbib05(String.valueOf(TaskType.zjd.getCode()));
            if(cbsa!=null){
                String vendername = cbsa.getCbsa08();
                cbibDo1.setCbib06(vendername);

            }
            cbibDo1.setCbib07(cbaa1.getCbaa01());
            cbibDo1.setCbib08(goodsid);
            cbibDo1.setCbib11((double) 0);
            cbibDo1.setCbib12((double) 0);
            cbibDo1.setCbib13(num);
            cbibDo1.setCbib14(cbab.getCbab11() * num);

            cbibDo1.setCbib17(TaskType.zjd.getMsg());
            cbibDo1.setCbib19(cbab.getCbab14());
            taskService.InsertCBIB(cbibDo1);


        }

        // cbaa1.setCbaa11(TaskStatus.bjwc.getCode());
        cbaaMapper.updateByPrimaryKeySelective(cbaa1);
    }

    //?????????????????????????????????
    @Override
    @Transactional
    public int transferordersinbjwc(CbaaDo cbaaDo) throws InterruptedException {

        //??????????????????
        transferordersoutbjwc(cbaaDo);

        Cbaa cbaa1 = cbaaMapper.selectByPrimaryKey(cbaaDo.getCbaa01());

        if (cbaa1 == null) {
            throw new SwException("???????????????????????????");
        }
   /*     if (!cbaa1.getCbaa11().equals(TaskStatus.bjwc.getCode())) {

            throw new SwException("??????????????????????????????????????????");

        }*/
        Date date = new Date();
        Long userId = SecurityUtils.getUserId();


        //??????????????????
        Set<Integer> sio = getIntegers();

        //?????????????????????
        Set<Integer> icu = getIntegerSet();
        //?????????????????????

        //???????????????
        if (sio.contains(cbaa1.getCbaa10())) {
            extracted(cbaaDo, cbaa1, date, userId, icu);
        }
//??????????????????

//??????????????????

        else {
//?????????????????????????????????
            return extracted(cbaaDo, cbaa1, date, userId);
        }
        return 1;
    }

    private int extracted(CbaaDo cbaaDo, Cbaa cbaa1, Date date, Long userId) throws InterruptedException {
        int sdw = 0;
        CbabCriteria etur = new CbabCriteria();
        etur.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
        List<Cbab> opi = cbabMapper.selectByExample(etur);
        if (opi.size() == 0) {
            throw new SwException("?????????????????????");
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
            throw new SwException("??????????????????????????????????????????????????????");
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
            throw new SwException("?????????????????????????????????");
        }
        List<Cbac> cbacs;
        for (Cbab cbab : cbabs1) {
            CbacCriteria example3 = new CbacCriteria();
            example3.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                    .andCbac08EqualTo(cbab.getCbab08());
            // .andCbac14EqualTo(2);
            cbacs = cbacMapper.selectByExample(example3);
            if (cbacs.size() == 0) {
                throw new SwException("???????????????????????????????????????");

            } else {
                for (Cbac cbac : cbacs) {//zgl  ????????????????????????gs_goods_sn????????????id
                    if (cbac.getCbac09() != null && !("").equals(cbac.getCbac09())) {
                        GsGoodsSn gsGoodsSn = new GsGoodsSn();
                        gsGoodsSn.setLocationId(cbac.getCbac10());
                        gsGoodsSn.setWhId(cbaa1.getCbaa10());
                        GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
                        gsGoodsSnCriteria.createCriteria().andSnEqualTo(cbac.getCbac09());
                        if (cbaa1.getCbaa10() == null) {
                            throw new SwException("???????????????????????????");
                        } else {
                            gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, gsGoodsSnCriteria);
                        }

                    }
                }
            }
        }
        for (Cbac cbac : opi1) {
            if (cbac.getCbac08() == null) {
                throw new SwException("?????????????????????id??????");

            }
            if (cbac.getCbac10() == null) {
                throw new SwException("???????????????????????????");

            }
            Integer instore = cbaa1.getCbaa10();

//???????????????
            GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
            //??????????????????id
            gsGoodsSkuDo1.setWhId(instore);
            gsGoodsSkuDo1.setLocationId(cbac.getCbac10());
            //????????????id
            gsGoodsSkuDo1.setGoodsId(cbac.getCbac08());
            gsGoodsSkuDo1.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //????????????id?????????id??????????????????
            List<GsGoodsSku> gsGoodsSkus1 = taskService.checkGsGoodsSku(gsGoodsSkuDo1);
            if (gsGoodsSkus1.size() == 0) {
                Cbla cbla = cblaMapper.selectByPrimaryKey(cbac.getCbac10());
                if (cbla == null) {
                    throw new SwException("?????????????????????");
                }
                GsGoodsSkuCriteria example1 = new GsGoodsSkuCriteria();
                example1.createCriteria()
                        .andLocationIdEqualTo(cbac.getCbac10());
                List<GsGoodsSku> gsGoodsSkuss1 = gsGoodsSkuMapper.selectByExample(example1);
                if (gsGoodsSkuss1.size() > 0) {
                    double sum = gsGoodsSkuss1.stream().mapToDouble(GsGoodsSku::getQty).sum();
                    if (sum + 1 > cbla.getCbla11()) {
                        throw new SwException("??????????????????");
                    } else {
                        GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();
                        gsGoodsSkuDo2.setGoodsId(cbac.getCbac08());
                        gsGoodsSkuDo2.setWhId(instore);
                        gsGoodsSkuDo2.setLocationId(cbac.getCbac10());
                        gsGoodsSkuDo2.setQty(1.0);
                        taskService.addGsGoodsSku(gsGoodsSkuDo2);
                    }

                } else {
                    GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();
                    gsGoodsSkuDo2.setGoodsId(cbac.getCbac08());
                    gsGoodsSkuDo2.setWhId(instore);
                    gsGoodsSkuDo2.setLocationId(cbac.getCbac10());
                    gsGoodsSkuDo2.setQty(1.0);
                    taskService.addGsGoodsSku(gsGoodsSkuDo2);
                }


            }
            else {

                Cbla cbla = cblaMapper.selectByPrimaryKey(cbac.getCbac10());
                if (cbla == null) {
                    throw new SwException("?????????????????????");
                }
                GsGoodsSkuCriteria example1 = new GsGoodsSkuCriteria();
                example1.createCriteria()
                        .andLocationIdEqualTo(cbac.getCbac10());
                List<GsGoodsSku> gsGoodsSkuss1 = gsGoodsSkuMapper.selectByExample(example1);
                if (gsGoodsSkuss1.size() > 0) {
                    double sum = gsGoodsSkus1.stream().mapToDouble(GsGoodsSku::getQty).sum();
                    if (sum + 1 > cbla.getCbla11()) {
                        throw new SwException("??????????????????");
                    }
                }
                //??????
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus1.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();

                gsGoodsSkuDo2.setGoodsId(cbac.getCbac08());
                gsGoodsSkuDo2.setWhId(instore);
                gsGoodsSkuDo2.setLocationId(cbac.getCbac10());
                //??????
                Double qty = gsGoodsSkus1.get(0).getQty();
                double v = qty + 1;
                gsGoodsSkuDo2.setQty(v);
                taskService.updateGsGoodsSku(gsGoodsSkuDo2);


            }
//???????????????

        }

        Cbaa cbaa2 = cbaaMapper.selectByPrimaryKey(cbaaDo.getCbaa01());
        CbabCriteria cbabCriteria = new CbabCriteria();
        cbabCriteria.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
        List<Cbab> cbabs = cbabMapper.selectByExample(cbabCriteria);
        for (Cbab cbab : cbabs) {
            //???????????????
            Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbab.getCbab14());
            //??????id
            Integer goodsid = cbab.getCbab08();

            //??????????????????????????????
            CbibDo cbibDo = new CbibDo();
            cbibDo.setCbib02(cbaa2.getCbaa10());
            cbibDo.setCbib03(cbaa2.getCbaa07());
            cbibDo.setCbib05(String.valueOf(TaskType.xsthd.getCode()));
            if(cbsa!=null){
            String vendername = cbsa.getCbsa08();
            cbibDo.setCbib06(vendername);}
            cbibDo.setCbib07(cbaa2.getCbaa01());
            cbibDo.setCbib08(goodsid);
            cbibDo.setCbib11((double) cbab.getCbab09());
            cbibDo.setCbib12(cbab.getCbab11() * cbab.getCbab09());
            cbibDo.setCbib13((double) 0);
            cbibDo.setCbib14((double) 0);

            cbibDo.setCbib17(TaskType.xsthd.getMsg());
            cbibDo.setCbib19(cbab.getCbab14());
            taskService.InsertCBIB(cbibDo);


            extracted(cbaa1, cbab, goodsid);
        }

        return cbaaMapper.updateByExampleSelective(cbaa, example);
    }

    private void extracted(Cbaa cbaa1, Cbab cbab, Integer goodsid) {
        TranUseQtyDo tranUseQtyDo = new TranUseQtyDo();
        tranUseQtyDo.setGoodsId(goodsid);
        tranUseQtyDo.setQty(cbab.getCbab09());
        tranUseQtyDo.setInWhId(cbaa1.getCbaa10());
        tranUseQtyDo.setOutWhId(cbaa1.getCbaa09());
        orderDistributionService.diaoboUseOp(tranUseQtyDo);
    }

    private void extracted(CbaaDo cbaaDo, Cbaa cbaa1, Date date, Long userId, Set<Integer> icu) throws InterruptedException {
        CbabCriteria cbabCriteria = new CbabCriteria();
        cbabCriteria.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
        List<Cbab> cbabs = cbabMapper.selectByExample(cbabCriteria);
        if (cbabs.size() == 0) {
            throw new SwException("?????????????????????");
        }

        //????????????
        if(icu.contains(cbaa1.getCbaa09())){
            Double kio= 0.0;
            CbacCriteria cbacCriteria = new CbacCriteria();
            cbacCriteria.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01());
            List<Cbac> cbacs = cbacMapper.selectByExample(cbacCriteria);
            int size = cbacs.size();
            for (Cbab cbab : cbabs) {
                if (cbab.getCbab09() == 0) {
                    throw new SwException("????????????????????????");
                }
                kio += cbab.getCbab09();
            }
            if(size<kio){
                throw new SwException("??????????????????????????????");
            } else {//zgl  ????????????????????????gs_goods_sn????????????id
                if(cbacs!=null){
                    for(Cbac cbac:cbacs){
                        if(cbac.getCbac09()!=null&&!("").equals(cbac.getCbac09())){
                            GsGoodsSn gsGoodsSn = new GsGoodsSn();
                            gsGoodsSn.setLocationId(0);
                            gsGoodsSn.setWhId(cbaa1.getCbaa10());
                            gsGoodsSn.setStatus(TaskStatus.sh.getCode().byteValue());
                            GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
                            gsGoodsSnCriteria.createCriteria().andSnEqualTo(cbac.getCbac09());
                            if(cbaa1.getCbaa10()==null){
                                throw new SwException("???????????????????????????");
                            }else {
                                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,gsGoodsSnCriteria);
                            }

                        }
                    }
                }

            }
        }
        //????????????

        //????????????
        for (Cbab cbab : cbabs) {
            if (cbab.getCbab09() == null) {
                throw new SwException("????????????????????????");
            }
            Double num = cbab.getCbab09();
            if (cbab.getCbab08() == null) {
                throw new SwException("????????????id????????????");
            }
            Integer goodsid = cbab.getCbab08();


            //?????????????????????
            List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByGoodsIdAndWhId(goodsid, cbaa1.getCbaa10());

            if (gsGoodsSkus.size() == 0) {
                //????????????
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
            } else {

                for (int j = 0; j < gsGoodsSkus.size(); j++) {

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


                }

            }
            //??????
            //???????????????
            Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbab.getCbab14());
            String vendername = cbsa.getCbsa08();
            //??????id


            //??????????????????????????????
            CbibDo cbibDo = new CbibDo();
            cbibDo.setCbib02(cbaa1.getCbaa10());
            cbibDo.setCbib03(cbaa1.getCbaa07());
            cbibDo.setCbib05(String.valueOf(TaskType.xsthd.getCode()));
            cbibDo.setCbib06(vendername);
            cbibDo.setCbib07(cbaa1.getCbaa01());
            cbibDo.setCbib08(goodsid);
            cbibDo.setCbib11(num);
            cbibDo.setCbib12(cbab.getCbab11() * num);
            cbibDo.setCbib13((double) 0);
            cbibDo.setCbib14((double) 0);

            cbibDo.setCbib17(TaskType.xsthd.getMsg());
            cbibDo.setCbib19(cbab.getCbab14());
            taskService.InsertCBIB(cbibDo);
            cbaa1.setCbaa11(TaskStatus.bjwc.getCode());
            cbaaMapper.updateByPrimaryKeySelective(cbaa1);

        }
    }

    private Set<Integer> getIntegerSet() {
        CbwaCriteria exartjr = new CbwaCriteria();
        exartjr.createCriteria().andCbwa12EqualTo("????????????");
        List<Cbwa> cbwas1 = cbwaMapper.selectByExample(exartjr);
        return cbwas1.stream().map(Cbwa::getCbwa01).collect(Collectors.toSet());
    }

    private Set<Integer> getIntegers() {
        CbwaCriteria exampse1 = new CbwaCriteria();
        exampse1.createCriteria().andCbwa12EqualTo("????????????");
        List<Cbwa> cbwas = cbwaMapper.selectByExample(exampse1);
        return cbwas.stream().map(Cbwa::getCbwa01).collect(Collectors.toSet());
    }

    @Override
    public List<CbacVo> selectSwJsTaskGoodsRelListsss(CbacVo cbacVo){
            if (cbacVo.getCbaa01() == null) {
                throw new SwException("?????????id????????????");
            }
            CbacVo res = new CbacVo();
            CbabCriteria example = new CbabCriteria();
            example.createCriteria().andCbaa01EqualTo(cbacVo.getCbaa01())
                    .andCbab07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbab> cbabs = cbabMapper.selectByExample(example);

            if (cbabs.size() == 0) {
                throw new SwException("?????????????????????");
            }
            List<Double> collect = cbabs.stream().map(Cbab::getCbab09).collect(Collectors.toList());
        Double sum1 = 0.0;

        if(collect.size()>0){
                 sum1 = cbabs.stream().mapToDouble(Cbab::getCbab09).sum();
            }
        Double sum = 0.0;
        for (Double aDouble : collect) {
            sum += aDouble;
        }
            List<CbacVo> cbacVos = cbacMapper.selectSwJsTaskGoodsRelListsss(cbacVo);
            res.setNums(sum1);

            cbacVos.add(res);
            if (cbacVos.size() > 1) {
                cbacVos.get(0).setSaoma(cbacVos.size() - 1);
                cbacVos.get(0).setNums(sum1);
            }

            return cbacVos;

    }

    @Override
    public List<CbacVo> swJsGoodslistsss(CbacVo cbacVo) {
        if(cbacVo.getCbaa01()==null){
            throw new SwException("?????????id????????????");
        }
        CbacVo res=new CbacVo();
        CbabCriteria example = new CbabCriteria();
        example.createCriteria().andCbaa01EqualTo(cbacVo.getCbaa01())
                .andCbab07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbab> cbabs = cbabMapper.selectByExample(example);
        if(cbabs.size()==0){
            throw new SwException("?????????????????????");
        }
        List<Double> collect = cbabs.stream().map(Cbab::getCbab09).collect(Collectors.toList());
        Double sum = 0.0;
        for (Double aDouble : collect) {
            sum += aDouble;
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

    @Override
    @Transactional
    public String importSwJsGoods(List<cbaaDto> swJsGoodsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(swJsGoodsList) || swJsGoodsList.size() == 0)
        {
            throw new ServiceException("?????????????????????????????????");
        }
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        this.inserttake(swJsGoodsList);


        if (failureNum > 0)
        {
            failureMsg.insert(0, "?????????????????????????????? " + failureNum + " ??????????????????????????????????????????");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "????????????????????????????????????????????? " + swJsGoodsList.size() + " ?????????????????????");
        }
        return successMsg.toString();    }

    @Override
    public int insertSwJsStoreplus(CbaaDo cbaaDo) {

        List<Cbab> goods = cbaaDo.getGoods();
        if(goods==null||goods.size()==0){
            throw new SwException("???????????????????????????");
        }

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
        int insert = cbaaMapper.insert(cbaa);


        Cbab cbab;
        for (Cbab good : goods) {
            cbab = new Cbab();
            cbab.setCbab03(date);
            cbab.setCbab04(Math.toIntExact(userId));
            cbab.setCbab05(date);
            cbab.setCbab06(Math.toIntExact(userId));
            cbab.setCbab07(DeleteFlagEnum.NOT_DELETE.getCode());
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
                cbab.setCbaa01(cbaa.getCbaa01());

            cbabMapper.insertSelective(cbab);

        }
        return 1;
    }

    @Override
    public ValueVo check(CbaaDo cbaaDo) {
        ValueVo valueVo = new ValueVo();
        GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
        example.createCriteria().andWhIdEqualTo(cbaaDo.getCbaa09())
                .andGoodsIdEqualTo(cbaaDo.getGoodsId());
        List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
        if(gsGoodsSkus.size()>0){
            double sum = gsGoodsSkus.stream().mapToDouble(GsGoodsSku::getQty).sum();
            valueVo.setNum(sum);
            return valueVo;
        }
        valueVo.setNum(0.0);
        return valueVo;
    }

    private void inserttake(List<cbaaDto> swJsGoodsList) {
        if(swJsGoodsList.size()==0){
            throw new SwException("??????????????????");
        }
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();

        if(swJsGoodsList.get(0).getTime()==null){
            throw new SwException("??????????????????");
        }
        if(swJsGoodsList.get(0).getIntstore()==null){
            throw new SwException("????????????????????????");
        }
        CbwaCriteria example = new CbwaCriteria();
        example.createCriteria().andCbwa09EqualTo(swJsGoodsList.get(0).getIntstore());
        List<Cbwa> cbwas = cbwaMapper.selectByExample(example);
        if(cbwas.size()==0){
            throw new SwException("?????????????????????");
        }
        if(swJsGoodsList.get(0).getOutstore()==null){
            throw new SwException("???????????????????????????");
        }
        CbwaCriteria example1 = new CbwaCriteria();
        example1.createCriteria().andCbwa09EqualTo(swJsGoodsList.get(0).getOutstore());
        List<Cbwa> cbwass = cbwaMapper.selectByExample(example1);
        if(cbwass.size()==0){
            throw new SwException("????????????????????????");
        }

        if(swJsGoodsList.get(0).getCurrent()==null){
            throw new SwException("????????????????????????");
        }
        CalaCriteria example2 = new CalaCriteria();
        example2.createCriteria().andCala08EqualTo(swJsGoodsList.get(0).getCurrent());
        List<Cala> calas = calaMapper.selectByExample(example2);
        if(calas.size()==0){
            throw new SwException("?????????????????????");
        }
        Cbaa cbaa =new Cbaa();
        cbaa.setCbaa02(date);
        cbaa.setCbaa03(Math.toIntExact(userid));
        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userid));
        cbaa.setCbaa06(DeleteFlagEnum.NOT_DELETE.getCode());
        String warehouseinitializationNo = numberGenerate.getWarehouseinitializationNos(cbwas.get(0).getCbwa01());
        cbaa.setCbaa07(warehouseinitializationNo);
        cbaa.setCbaa08(swJsGoodsList.get(0).getTime());
        cbaa.setCbaa09(cbwass.get(0).getCbwa01());
        cbaa.setCbaa10(cbwas.get(0).getCbwa01());
        cbaa.setCbaa11(TaskStatus.mr.getCode());
        cbaa.setCbaa12(Math.toIntExact(userid));
        cbaa.setCbaa16(calas.get(0).getCala01());
        cbaaMapper.insertSelective(cbaa);

        CbaaCriteria example3 = new CbaaCriteria();
        example3.createCriteria().andCbaa07EqualTo(warehouseinitializationNo);
        List<Cbaa> cbaas = cbaaMapper.selectByExample(example3);
        if(cbaas.size()>0){
            Integer cbaa01 = cbaas.get(0).getCbaa01();
        }
        cbaaDto cbaaDto1 = swJsGoodsList.get(0);
        for (com.ruoyi.system.domain.dto.cbaaDto cbaaDto : swJsGoodsList) {

            if (cbaaDto.getSupplierName() == null) {
                throw new SwException("?????????????????????");
            }
            CbsaCriteria example4 = new CbsaCriteria();
            example4.createCriteria().andCbsa08EqualTo(cbaaDto.getSupplierName());
            List<Cbsa> cbsas = cbsaMapper.selectByExample(example4);
            if (cbsas.size() == 0) {
                throw new SwException("??????????????????");
            }

            if (cbaaDto.getOrderNo() == null) {
                throw new SwException("????????????????????????");
            }
            if (cbaaDto.getGoodssku() == null) {
                throw new SwException("????????????????????????");
            }

            CbpbCriteria example5 = new CbpbCriteria();
            example5.createCriteria().andCbpb12EqualTo(cbaaDto.getGoodssku());
            List<Cbpb> cbpbs = cbpbMapper.selectByExample(example5);
            if (cbpbs.size() == 0) {
                throw new SwException("?????????????????????");
            }

            if (cbaaDto.getNum() == null) {
                throw new SwException("??????????????????");
            }
            if (cbaaDto.getPrice() == null) {
                throw new SwException("??????????????????");
            }
            Cbab cbab = new Cbab();
            cbab.setCbab03(date);
            cbab.setCbab04(Math.toIntExact(userid));
            cbab.setCbab05(date);
            cbab.setCbab06(Math.toIntExact(userid));
            cbab.setCbab07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbab.setCbab08(cbpbs.get(0).getCbpb01());
            cbab.setCbab09(Double.valueOf(cbaaDto.getNum()));
            cbab.setCbab11(cbaaDto.getPrice());
            cbab.setCbab12(cbaaDto.getNum() * cbaaDto.getPrice());
            cbab.setCbab13(cbaaDto.getMark());
            cbab.setCbab14(cbsas.get(0).getCbsa01());
            if (cbaas.size() > 0) {
                Integer cbaa01 = cbaas.get(0).getCbaa01();
                cbab.setCbaa01(cbaa01);
            }
            if (Objects.equals(cbaaDto.getOrderNo(), "????????????")) {
                cbab.setCbab15(1);
            }
            if (Objects.equals(cbaaDto.getOrderNo(), "????????????")) {
                cbab.setCbab15(2);
            }
            cbabMapper.insertSelective(cbab);


        }


return ;
    }


}
