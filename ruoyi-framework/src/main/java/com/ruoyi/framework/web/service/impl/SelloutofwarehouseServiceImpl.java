package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISelloutofwarehouseService;
import com.ruoyi.system.service.gson.*;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
@Resource
private CbwaMapper cbwaMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
@Resource
   private SysUserMapper sysUserMapper;
    @Resource
    private NumberGenerate numberGenerate;

    @Resource
    private TaskService taskService;

    @Resource
    private BaseCheckService baseCheckService;

    @Resource
    private CbpaMapper cbpaMapper;

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

   /* @Resource
    @Qualifier("StringredisTemplate")
    private StringRedisTemplate redisTemplate;*/

    @Resource
    private CboaMapper cboaMapper;

    @Resource
    private  CbpeMapper cbpeMapper;

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplates;
    @Resource
    private  CalaMapper calaMapper;

@Resource
private CbcaMapper cbcaMapper;
    @Resource
    private  CbpbMapper cbpbMapper;
    /**
     * 新增销售出库主单
     *
     * @param cbsbDo 审核信息
     * @return 结果
     */
   // @Transactional
    @Override
    public IdVo insertSelloutofwarehouse(CbsbDo cbsbDo) {

//if(cbsbDo.getCbsb30()==null){
//    throw new SwException("客户订单号不能为空");
//
//}



        Long userid = SecurityUtils.getUserId();
        Cbsb cbsb = BeanCopyUtils.coypToClass(cbsbDo, Cbsb.class, null);
        Date date = new Date();
        cbsb.setCbsb02(date);
        cbsb.setCbsb03(Math.toIntExact(userid));
        cbsb.setCbsb04(date);
        cbsb.setCbsb05(Math.toIntExact(userid));
        cbsb.setCbsb06(DeleteFlagEnum.DELETE.getCode());
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
                .andCbsb06EqualTo(DeleteFlagEnum.DELETE.getCode());
        List<Cbsb> cbsbss = cbsbMapper.selectByExample(example1);






        IdVo idVo = new IdVo();
        if(cbsbss.size()>0){
            idVo.setId(cbsbss.get(0).getCbsb01());
        }

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


 /*       itemList.parallelStream().collect(Collectors.groupingBy(o->(o.getCbsc08()),Collectors.toList()))
                .forEach((id,trans)->{
                    trans.stream().reduce((a,b)->new ResultDO(a.getTimes(),a.getPrice()+b.getPrice(),a.getCount()+b.getCount())).ifPresent(resultDOList::add);
                });*/




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


        //加入去重提货单id
        if(itemList.get(0).getTakegoodsid()!=null) {
            HashSet<Cbsc> skuIds2 = new HashSet<>();
            for (Cbsc cbsc : itemList) {
                if (cbsc.getTakegoodsid() != null) {
                    skuIds2.add(cbsc);
                }
            }
            if (skuIds2.size() < itemList.size()) {
                throw new SwException("提货单不能重复");
            }
        }


        for (Cbsc cbsc : itemList) {
            //校验提货单重复
            if (cbsc.getTakegoodsid() != null) {
                CbscCriteria sdg = new CbscCriteria();
                sdg.createCriteria().andTakegoodsidEqualTo(cbsc.getTakegoodsid())
                        .andCbsb01NotEqualTo(itemList.get(0).getCbsb01())
                        .andCbsc07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                List<Cbsc> cbsbs = cbscMapper.selectByExample(sdg);
                if (cbsbs.size() > 0) {
                    throw new SwException("关联提货单重复");
                }
            }


            if (cbsc.getCbsc08() == null) {
                throw new SwException("销售出库单明细商品id不能为空");
            }
            if (Objects.isNull(cbsc.getCbsc09())) {
                throw new SwException("销售出库数量不能为空");
            }
            if (Objects.isNull(cbsc.getCbsc11())) {
                throw new SwException("销售出库单价不能为空");
            }
            if (Objects.isNull(cbsc.getCbsb01())) {
                throw new SwException("销售出库主表id不能为空");
            }
            if (!skuIds.contains(cbsc.getCbsc08())) {
                throw new SwException("仓库里没有该商品");
            }


            cbsc.setCbsc03(date);
            cbsc.setCbsc04(Math.toIntExact(userid));
            cbsc.setCbsc05(date);
            cbsc.setCbsc06(Math.toIntExact(userid));
            cbsc.setCbsc07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbsc.setUserId(Math.toIntExact(userid));
            cbsc.setTakegoodsid(cbsc.getTakegoodsid());
            cbsc.setCbsc12(cbsc.getCbsc09() * cbsc.getCbsc11());

            //判断重复
            if (cbsc.getTakegoodsid() != null) {
                Cbpk cbpk = new Cbpk();
                cbpk.setCbpk01(cbsc.getTakegoodsid());
                cbpk.setCbpk11(4);
                cbpkMapper.updateByPrimaryKeySelective(cbpk);
            }


            mapper.insertSelective(cbsc);


            // mapper.insertSelective(itemList.get(i));
        }


 /*       List<Integer> collect = itemList.stream().map(Cbsc::getCbsc08).collect(Collectors.toList());
        HashSet<Integer> set = new HashSet<>(collect);

            List<Cbsc> newList = getNewList(itemList);

            for(int i=0;i<newList.size();i++){
                mapper.insertSelective(newList.get(i));
                if (i % 10 == 9) {//每10条提交一次
                    session.commit();
                    session.clearCache();
                }
            }*/
       // mapper.insertSelective(itemList.get(i));


        session.commit();
                                                                        session.clearCache();


        Cbsb cbsb1 = new Cbsb();
        cbsb1.setCbsb01(itemList.get(0).getCbsb01());
        cbsb1.setCbsb06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsbMapper.updateByPrimaryKeySelective(cbsb1);
//缓存
/*
        new Thread(() -> {
            List<TakeOrderSugestVo> outsuggestion = new ArrayList<>();
            //  List<TakeOrderSugestVo> outsuggestionss = new ArrayList<>();

            HashSet<TakeOrderSugestVo> outsuggestions = new HashSet<>();

            ListOperations<String,TakeOrderSugestVo> list = redisTemplates.opsForList();


            CbscCriteria asd = new CbscCriteria();
            asd.createCriteria().andCbsb01EqualTo(itemList.get(0).getCbsb01());
            List<Cbsc> cbscs1 = cbscMapper.selectByExample(asd);
            double sum = 0;
            if (cbscs1.size() > 0) {
                sum = cbscs1.stream().mapToDouble(Cbsc::getCbsc09).sum();
                for (int k = 0; k < cbscs1.size(); k++) {
                    if (cbscs1.get(k).getTakegoodsid() != null) {
                        CbpmCriteria example = new CbpmCriteria();
                        example.createCriteria().andCbpk01EqualTo(cbscs1.get(k).getTakegoodsid())
                                .andCbpm08EqualTo(cbscs1.get(k).getCbsc08())
                                .andCbpm07EqualTo(0);

                        List<Cbpm> cbpms = cbpmMapper.selectByExample(example);
                        for (int j = 0; j < cbpms.size(); j++) {
                            Cbla cbla = cblaMapper.selectByPrimaryKey(cbpms.get(j).getCbpm10());
                            Cbpb cbpb = cbpbMapper.selectByPrimaryKey(cbpms.get(j).getCbpm08());
                            Cbpa cbpa = cbpaMapper.selectByPrimaryKey(cbpb.getCbpb14());
                            Cala cala = calaMapper.selectByPrimaryKey(cbpb.getCbpb10());
                            TakeOrderSugestVo outsuggestio = new TakeOrderSugestVo();
                            if (cala != null) {
                                outsuggestio.setBrand(cala.getCala08());

                            }
                            if (cbpa != null) {
                                outsuggestio.setGoodClass(cbpa.getCbpa08());
                            }
                            if (cbpb != null) {
                                outsuggestio.setDescription(cbpb.getCbpb08());
                                outsuggestio.setModel(cbpb.getCbpb12());

                            }
                            if (cbpms.get(j).getCbpm09() != null) {
                                CbsdCriteria cbsdCriteria = new CbsdCriteria();
                                cbsdCriteria.createCriteria().andCbsd09EqualTo(cbpms.get(j).getCbpm09())
                                        .andCbsb01EqualTo(itemList.get(0).getCbsb01());
                                List<Cbsd> cbsds = cbsdMapper.selectByExample(cbsdCriteria);
                                if (cbsds.size() > 0) {
                                    outsuggestio.setScanStatus("已扫码");
                                } else {
                                    outsuggestio.setScanStatus("未扫码");
                                }

                            }
                            outsuggestio.setSn(cbpms.get(j).getCbpm09());
                            if (cbla != null) {
                                outsuggestio.setSku(cbla.getCbla09());
                            }

                            outsuggestions.add(outsuggestio);
                        }
                    }
                }
            }
            outsuggestion.addAll(outsuggestions);



            list.leftPushAll(itemList.get(0).getCbsb01().toString(),outsuggestion);
        }).start();
*/


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

        return getuserid(cbsbDo);
    }

    private int getuserid(CbsbDo cbsbDo) {
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
            for (Cbsd cbpe : cbpes) {
                if (cbpe.getCbsd11().equals(ScanStatusEnum.YISAOMA.getCode())) {

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
    public int insertSwJsSkuBarcodeshwc(CbsbDo cbsbDo) throws InterruptedException {
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

        CbsdCriteria dfsd=new CbsdCriteria();
        dfsd.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01());
        //List<Cbsd> cbsdList = cbsdMapper.selectByExample(dfsd);


        Cbwa cbwa = cbwaMapper.selectByPrimaryKey(cbsb1.getCbsb10());

        if (cbwa!=null && "条码管理".equals(cbwa.getCbwa12()))
        {
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

            for (String s : collect) {
                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                gsGoodsSn.setStatus(GoodsType.yck.getCode());
                GsGoodsSnCriteria gssn = new GsGoodsSnCriteria();
                gssn.createCriteria().andSnEqualTo(s);
                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, gssn);

            }

            //回写生产总总订单
            CbscCriteria example = new CbscCriteria();
            example.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                    .andCbsc07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbsc> cbscs = cbscMapper.selectByExample(example);

//        List<Cbob> cbobs = cbobMapper.selectByExample(example2);
//        String cbob18 = cbobs.get(0).getCbob18();

            //在提货单id在明细表，for
            if (cbscs.size() > 0) {
                for (Cbsc cbsc : cbscs) {
                    //                    if (cbscs.get(i).getTakegoodsid()!= null) {
//                        Cbpk cbpk1 = cbpkMapper.selectByPrimaryKey(cbscs.get(i).getTakegoodsid());
                    Cbob cbob = cbobMapper.selectByPrimaryKey(cbsc.getCbsc14());
                    if (cbob == null) {
                        throw new SwException("没有查到该销售订单明细");
                    }

                    Cboa cboa = cboaMapper.selectByPrimaryKey(cbob.getCboa01());
                    if (cboa == null) {
                        throw new SwException("没有查到该销售订单");
                    }
//                    CboaCriteria afd = new CboaCriteria();
//                        afd.createCriteria().andCboa07EqualTo(cbob.getSaleOrderNo());
//                        List<Cboa> cboas = cboaMapper.selectByExample(afd);
//                        Cboa cboa1 = cboas.get(0);

                    SaleOrderExitDo saleOrderExitDo = new SaleOrderExitDo();
                    saleOrderExitDo.setTotalOrderNo(cbob.getCbob18());
                    saleOrderExitDo.setOrderNo(cboa.getCboa07());
                    saleOrderExitDo.setGoodsId(cbsc.getCbsc08());
                    saleOrderExitDo.setQty(cbsc.getCbsc09());
                    saleOrderExitDo.setCbobId(cbsc.getCbsc14());
                    saleOrderExitDo.setOrderClass(cboa.getCboa27());
                    saleOrderExitDo.setWhId(cbsb1.getCbsb10());
//                        if(cbscs.get(i).getCbsc14()!=null) {
//                            Cbob cbob = cbobMapper.selectByPrimaryKey(cbscs.get(i).getCbsc14());
//                            if (cbob == null) {
//                                throw new SwException("销售订单明细表未查到");
//                            }
//
//                            saleOrderExitDo.setTotalOrderNo(cbob.getCbob18());
//                        }
                    orderDistributionService.saleOrderExit(saleOrderExitDo);
//                    }
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

            UIOVo uioVo = new UIOVo();
            uioVo.setId(cbsbDo.getCbsb01());
            List<UIOVo> selectbyid = cbsdMapper.selectBYID(uioVo);
            if(selectbyid.size()>0){
                for (UIOVo vo : selectbyid) {
                    GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();

                    gsGoodsSkuDo.setLocationId(vo.getStoreskuid());
                    //获取仓库id
                    gsGoodsSkuDo.setWhId(cbsb1.getCbsb10());
                    //获取商品id
                    gsGoodsSkuDo.setGoodsId(vo.getGoodsId());
                    gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                    //通过仓库id和货物id判断是否存在
                    List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByGoodsIdAndWhId(vo.getGoodsId(), cbsb1.getCbsb10());
                    if (gsGoodsSkus.size() == 0) {
                        List<GsGoodsSku> gsGoodsSkuss = taskService.checkGsGoodsSkuByWhId(gsGoodsSkuDo);
                        if (gsGoodsSkuss.size() == 0) {
                            throw new SwException("没有该库存信息");

                        } else {
                            GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                            gsGoodsSkuDo1.setId(gsGoodsSkuss.get(0).getId());
                            gsGoodsSkuDo1.setWhId(cbsb1.getCbsb10());
                            gsGoodsSkuDo1.setLocationId(vo.getStoreskuid());
                            //获取商品id
                            Double qty = gsGoodsSkuss.get(0).getQty();

                            gsGoodsSkuDo1.setGoodsId(vo.getGoodsId());
                            if (qty - vo.getNums() < 0) {
                                throw new SwException("出库数量大于库存数量");
                            }
                            gsGoodsSkuDo1.setQty(qty - vo.getNums());
                            taskService.updateGsGoodsSku(gsGoodsSkuDo1);
                        }


                    }
                    //如果存在则更新库存数量
                    else {
                        //加锁
                        baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                        GsGoodsSku gsGoodsSkuDo1 = new GsGoodsSku();
                        //查出
                        Double qty = gsGoodsSkus.get(0).getQty();
                        if (qty == 0) {
                            throw new SwException("库存数量不足" + "商品id为" + gsGoodsSkus.get(0).getGoodsId() + "仓库id为" + gsGoodsSkus.get(0).getWhId());
                        }
                        gsGoodsSkuDo1.setId(gsGoodsSkus.get(0).getId());
                        //获取仓库id
                        gsGoodsSkuDo1.setWhId(cbsb1.getCbsb10());
                        //获取商品id
                        gsGoodsSkuDo1.setGoodsId(vo.getGoodsId());
                        // gsGoodsSkuDo1.setLocationId(selectbyid.get(k).getStoreskuid());
                        //        if(num>qty){
                        //            throw new SwException("出库数量大于库存数量");
                        //
                        //        }
                        if (qty - vo.getNums() < 0) {
                            throw new SwException("出库数量大于库存数量");
                        }
                        gsGoodsSkuDo1.setQty(qty - vo.getNums());
                        gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSkuDo1);
                        //taskService.updateGsGoodsSku(gsGoodsSkuDo1);
                    }
                }
            }

//            for(int i=0;i<size;i++){
//                Integer cbsc14 = cbscs1.get(i).getCbsc14();
//                Cbob cbob = cbobMapper.selectByPrimaryKey(cbsc14);
//                if(cbob == null){
//                    throw new SwException("找不到此销售订单明细");
//                }
//                CbsdCriteria example3 = new CbsdCriteria();
//                example3.createCriteria().andCbsd08EqualTo(cbscs1.get(i).getCbsc08())
//                                .andCbsb01EqualTo(cbscs1.get(i).getCbsb01());
//                List<Cbsd> cbsds = cbsdMapper.selectByExample(example3);
//                if(cbsds.size()==0){
//                    throw new SwException("找不到此销售出货单扫码记录");
//
//                }
//                cbob.setCbob10(cbob.getCbob10()+cbsds.size());
//                cbob.setCbob01(cbsc14);
//                cbobMapper.updateByPrimaryKeySelective(cbob);
//            }
            List<Cbsd> cbsds=null;
            for (Cbsc cbsc : cbscs1) {

                CbsdCriteria examples = new CbsdCriteria();
                examples.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                        .andCbsd08EqualTo(cbsc.getCbsc08());
                cbsds = cbsdMapper.selectByExample(examples);
                if (cbsds.size() == 0) {
                    throw new SwException("销售出库单扫描记录未查到");

                }
          /*  if(   cbsds.get(i).getCbsd10()==null){
                throw new SwException("销售出库单库位未查到");

            }*/
            }


            //写台账

          /*  CbscCriteria example6 = new CbscCriteria();
            example6.createCriteria()
                    .andCbsb01EqualTo(cbsb1.getCbsb01())
                    .andCbsc07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbsc> cbscss = cbscMapper.selectByExample(example6);
            if(cbscs.size()==0){
                throw new SwException("销售出库单明细表为空");
            }*/

            List<Cbsc> selegroupgoodsid = cbscMapper.selegroupgoodsid(cbsb1.getCbsb01());
            // cbscss.stream().mapToDouble(Cbsc::getCbsc09).sum();
            for (Cbsc cbsc : selegroupgoodsid) {
                CbibDo cbibDo = new CbibDo();
                cbibDo.setCbib02(cbsb1.getCbsb10());
                cbibDo.setCbib03(cbsb1.getCbsb07());
                cbibDo.setCbib05(String.valueOf(TaskType.xcckd.getCode()));
                // Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbscss.get(i).getCbsc15());

                // cbibDo.setCbib06(cbsa.getCbsa08());
                cbibDo.setCbib07(cbsb1.getCbsb01());
                cbibDo.setCbib08(cbsc.getCbsc08());
                //本次入库数量
                cbibDo.setCbib11((double) 0);
                cbibDo.setCbib12((double) 0);
                cbibDo.setCbib13(cbsc.getCbsc09());
                cbibDo.setCbib14(cbsc.getCbsc12());
                cbibDo.setCbib17(TaskType.xcckd.getMsg());
                //cbibDo.setCbib19(cbscss.get(i).getCbsc15());
                taskService.InsertCBIB(cbibDo);
            }
/*
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
*/
            //更新sn表
            CbsdCriteria example7 = new CbsdCriteria();
            example7.createCriteria().andCbsb01EqualTo(cbsb1.getCbsb01());
            List<Cbsd> cbsds1 = cbsdMapper.selectByExample(example7);
            if(cbsds1.size()>0){
            for (Cbsd cbsd : cbsds1){
                String cbsd09 = cbsd.getCbsd09();
                //更新sn表
                GsGoodsSnDo   gsGoodsSnDo = new GsGoodsSnDo();
                gsGoodsSnDo.setUpdateTime(date);
                gsGoodsSnDo.setUpdateBy(Math.toIntExact(userid));
                gsGoodsSnDo.setSn(cbsd09);
                gsGoodsSnDo.setStatus(GoodsType.yck.getCode());
                gsGoodsSnDo.setOutTime(date);
                gsGoodsSnDo.setGroudStatus(Groudstatus.XJ.getCode());
                taskService.updateGsGoodsSn(gsGoodsSnDo);

            }

            }



            return cbsbMapper.updateByExampleSelective(cbsb, example1);
        }
        //数量
        else {

            //主表状态更新
            Long userid = SecurityUtils.getUserId();
            Cbsb cbsb = BeanCopyUtils.coypToClass(cbsbDo, Cbsb.class, null);
            Date date = new Date();
            cbsb.setCbsb04(date);
            cbsb.setCbsb05(Math.toIntExact(userid));
            cbsb.setCbsb11(TaskStatus.bjwc.getCode());
            CbsbCriteria example1 = new CbsbCriteria();
            example1.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01())
                    .andCbsb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
//库存
CbscCriteria afw = new CbscCriteria();
afw.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01());
List<Cbsc> cbscs = cbscMapper.selectByExample(afw);


            if (cbscs.size() >0) {
                for (Cbsc value : cbscs) {
                  /*  GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
                    example.createCriteria()
                            .andGoodsIdEqualTo(cbscs.get(i).getCbsc08())
                            .andWhIdEqualTo(cbsb1.getCbsb10());
                    List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);*/
                    List<GsGoodsSku> gsGoodsSkus =
                            gsGoodsSkuMapper.selectByGoodsIdAndWhId(value.getCbsc08(), cbsb1.getCbsb10());

                    if (gsGoodsSkus.size() == 0) {
                        throw new SwException("没有该库存信息");

                    }
                    //如果存在则更新库存数量
                    else {
                        for (int j = 0; j < gsGoodsSkus.size(); j++) {
                            if (gsGoodsSkus.get(j).getLocationId() != null) {
                                gsGoodsSkus.remove(j);
                            }
                        }
                        if (gsGoodsSkus.size() == 0) {
                            throw new SwException("没有该数量库存信息");

                        }
                        //加锁
                        baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                        GsGoodsSku gsGoodsSkuDo1 = new GsGoodsSku();
                        // BeanCopyUtils.coypToClass(gsGoodsSkuDo1, GsGoodsSku.class, null)
                        //查出
                        Double qty = gsGoodsSkus.get(0).getQty();
                        if (qty == 0) {
                            throw new SwException("库存数量不足");
                        }
                        gsGoodsSkuDo1.setId(gsGoodsSkus.get(0).getId());
                        //获取仓库id
                        gsGoodsSkuDo1.setWhId(cbsb1.getCbsb10());
                        //获取商品id
                        gsGoodsSkuDo1.setGoodsId(value.getCbsc08());
                        //        if(num>qty){
                        //            throw new SwException("出库数量大于库存数量");
                        //
                        //        }
                        if (qty - value.getCbsc09() < 0) {
                            throw new SwException("出库数量大于库存数量");
                        }
                        gsGoodsSkuDo1.setQty(qty - value.getCbsc09());
                        int i1 = gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSkuDo1);
                    }

                    Cbob cbob = cbobMapper.selectByPrimaryKey(value.getCbsc14());
                    if (cbob == null) {
                        throw new SwException("没有查到该销售订单明细");
                    }

                    Cboa cboa = cboaMapper.selectByPrimaryKey(cbob.getCboa01());
                    if (cboa == null) {
                        throw new SwException("没有查到该销售订单");
                    }
                    SaleOrderExitDo saleOrderExitDo = new SaleOrderExitDo();
                    saleOrderExitDo.setTotalOrderNo(cbob.getCbob18());
                    saleOrderExitDo.setOrderNo(cboa.getCboa07());
                    saleOrderExitDo.setGoodsId(value.getCbsc08());
                    saleOrderExitDo.setQty(value.getCbsc09());
                    saleOrderExitDo.setCbobId(value.getCbsc14());
                    saleOrderExitDo.setOrderClass(cboa.getCboa27());
                    saleOrderExitDo.setWhId(cbsb1.getCbsb10());
//                        if(cbscs.get(i).getCbsc14()!=null) {
//                            Cbob cbob = cbobMapper.selectByPrimaryKey(cbscs.get(i).getCbsc14());
//                            if (cbob == null) {
//                                throw new SwException("销售订单明细表未查到");
//                            }
//
//                            saleOrderExitDo.setTotalOrderNo(cbob.getCbob18());
//                        }
                    orderDistributionService.saleOrderExit(saleOrderExitDo);
                    //台账
                 /*   CbibDo cbibDo = new CbibDo();
                    cbibDo.setCbib02(cbsb1.getCbsb10());
                    cbibDo.setCbib03(cbsb1.getCbsb07());
                    cbibDo.setCbib05(String.valueOf(TaskType.xcckd.getCode()));
                    Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbscs.get(i).getCbsc15());

                    // cbibDo.setCbib06(cbsa.getCbsa08());
                    cbibDo.setCbib07(cbscs.get(i).getCbsc01());
                    cbibDo.setCbib08(cbscs.get(i).getCbsc08());
                    //本次入库数量
                    cbibDo.setCbib11((double) 0);
                    cbibDo.setCbib12((double) 0);
                    cbibDo.setCbib13(cbscs.get(i).getCbsc09());
                    cbibDo.setCbib14(cbscs.get(i).getCbsc11()*cbscs.get(i).getCbsc09());
                    cbibDo.setCbib17(TaskType.xcckd.getMsg());
                    cbibDo.setCbib19(cbscs.get(i).getCbsc15());
                    taskService.InsertCBIB(cbibDo);*/
                }


            }


            List<Cbsc> selegroupgoodsid = cbscMapper.selegroupgoodsid(cbsb1.getCbsb01());
            // cbscss.stream().mapToDouble(Cbsc::getCbsc09).sum();
            for (Cbsc cbsc : selegroupgoodsid) {
                CbibDo cbibDo = new CbibDo();
                cbibDo.setCbib02(cbsb1.getCbsb10());
                cbibDo.setCbib03(cbsb1.getCbsb07());
                cbibDo.setCbib05(String.valueOf(TaskType.xcckd.getCode()));
                // Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbscss.get(i).getCbsc15());

                // cbibDo.setCbib06(cbsa.getCbsa08());
                cbibDo.setCbib07(cbsb1.getCbsb01());
                cbibDo.setCbib08(cbsc.getCbsc08());
                //本次入库数量
                cbibDo.setCbib11((double) 0);
                cbibDo.setCbib12((double) 0);
                cbibDo.setCbib13(cbsc.getCbsc09());
                cbibDo.setCbib14(cbsc.getCbsc12());
                cbibDo.setCbib17(TaskType.xcckd.getMsg());
                //cbibDo.setCbib19(cbscss.get(i).getCbsc15());
                taskService.InsertCBIB(cbibDo);
            }



            cbsbMapper.updateByExampleSelective(cbsb, example1);
        }

return 1;
    }

    @Transactional
    @Override
    public int insertSwJsSkuBarcodeqxwc(CbsbDo cbsbDo) {

        CbsdCriteria example2 = new CbsdCriteria();
        example2.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01());
        List<Cbsd> cbpes = cbsdMapper.selectByExample(example2);
        if(cbpes.size()>0 ){
            int size = cbpes.size();
            for (Cbsd cbpe : cbpes) {
                if (cbpe.getCbsd11().equals(ScanStatusEnum.YISAOMA.getCode())) {

                    throw new SwException("已扫码不能反审");
                }
            }
        }

        Cbsb cbsb1 = cbsbMapper.selectByPrimaryKey(cbsbDo.getCbsb01());
        if(!cbsb1.getCbsb11().equals(TaskStatus.bjwc.getCode())){
            throw new SwException(" 标记完成才能取消完成");
        }
        return getuserid(cbsbDo);
    }

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

        CbscCriteria example2 = new CbscCriteria();
        example2.createCriteria().andCbsb01EqualTo(cbsbDo.getCbsb01());
      //  List<Cbsc> cbscs = cbscMapper.selectByExample(example2);
/*
        if(cbscs.size()>0){
            for(int i=0;i<cbscs.size();i++){
                if(cbscs.get(i).getTakegoodsid()!=null){
                    Cbpk cbpk = new Cbpk();
                    cbpk.setCbpk01(cbscs.get(i).getTakegoodsid());
                    cbpk.setCbpk11(TaskStatus.fsh.getCode());
                    cbpkMapper.updateByPrimaryKeySelective(cbpk);

                }
            }
        }
*/
        int i = cbscMapper.deleteByExample(example2);



        return cbsbMapper.updateByExampleSelective(cbsb,example1);    }


    /**
     * 销售出库单详情
     */
    @Override
    public List<CbsbsVo> selectSwJsTaskGoodsRelListss(CbsbsVo cbsbsVo) throws ExecutionException, InterruptedException {

        CompletableFuture<List<CbsbsVo>> f1 =
                CompletableFuture.supplyAsync(()->{
        int sizes=0;
      //  List<CbsbsVo> cbsbsVos1 = cbpkMapper.selectSwJsTaskGoodsRelListss(cbsbsVo);
                   // HashSet<CbsbsVo> cbsbsVoss = new HashSet<>(cbsbsVos1);
                    Cbsb cbsb = cbsbMapper.selectByPrimaryKey(cbsbsVo.getCbsb01());
                    CbscCriteria example2 = new CbscCriteria();
                    example2.createCriteria().andCbsb01EqualTo(cbsbsVo.getCbsb01());
                    List<Cbsc> cbscs = cbscMapper.selectByExample(example2);

                    List<CbsbsVo> cbsbsVos = new ArrayList<>(cbscs.size());
                    for (Cbsc cbsc : cbscs) {
                        CbsbsVo cbsbsVo1 = new CbsbsVo();
                        cbsbsVo1.setCbsb01(cbsb.getCbsb01());
                        cbsbsVo1.setCbsb07(cbsb.getCbsb07());
                        cbsbsVo1.setCbsb08(cbsb.getCbsb08());
                        cbsbsVo1.setCbsb09(cbsb.getCbsb09());
                        cbsbsVo1.setCbsb10(cbsb.getCbsb10());
                        cbsbsVo1.setCbsb18(cbsb.getCbsb18());
                        cbsbsVo1.setCbsb19(cbsb.getCbsb19());
                        cbsbsVo1.setCbsb20(cbsb.getCbsb20());
                        cbsbsVo1.setCbsb21(cbsb.getCbsb21());
                        cbsbsVo1.setCbsb17(cbsb.getCbsb17());
                        //货币
                        if (cbsb.getCbsb16() != null) {
                            Cala cala = calaMapper.selectByPrimaryKey(cbsb.getCbsb16());
                            cbsbsVo1.setCny(cala.getCala08());
                        }
                        //仓库
                        if (cbsb.getCbsb10() != null) {
                            Cbwa cbwa = cbwaMapper.selectByPrimaryKey(cbsb.getCbsb10());
                            cbsbsVo1.setCbwa09(cbwa.getCbwa09());
                        }
                        //客户名称
                        if (cbsb.getCbsb09() != null) {
                            Cbca cbca = cbcaMapper.selectByPrimaryKey(cbsb.getCbsb09());
                            cbsbsVo1.setCbca08(cbca.getCbca08());
                            cbsbsVo1.setCbca28(cbca.getCbca28());
                        }
                        //销售人员
                        if (cbsb.getCbsb17() != null) {
                            SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(cbsb.getCbsb17()));
                            cbsbsVo1.setCaua15(sysUser.getNickName());
                        }
                        cbsbsVo1.setCbsc01(cbsc.getCbsc01());
                        cbsbsVo1.setCbsc11(cbsc.getCbsc11());
                        cbsbsVo1.setCbsc12(cbsc.getCbsc12());
                        cbsbsVo1.setCbsc13(cbsc.getCbsc13());
                        cbsbsVo1.setCbsc17(cbsc.getCbsc17());
                        cbsbsVo1.setCbsc09(cbsc.getCbsc09());
                        cbsbsVo1.setSaoma(cbsc.getScannum());
                        if (cbsc.getCbsc08() != null) {
                            Cbpb cbpb = cbpbMapper.selectByPrimaryKey(cbsc.getCbsc08());
                            cbsbsVo1.setCbpb08(cbpb.getCbpb08());
                            cbsbsVo1.setCbpb15(cbpb.getCbpb15());
                            cbsbsVo1.setCbpb12(cbpb.getCbpb12());
                            //品牌
                            if (cbpb.getCbpb10() != null) {
                                Cala cala = calaMapper.selectByPrimaryKey(cbpb.getCbpb10());
                                cbsbsVo1.setCala08(cala.getCala08());
                            }
                            if (cbpb.getCbpb14() != null) {
                                Cbpa cbpa = cbpaMapper.selectByPrimaryKey(cbpb.getCbpb14());
                                cbsbsVo1.setCbpa07(cbpa.getCbpa07());
                            }
                        }
                        cbsbsVos.add(cbsbsVo1);
                    }

                    return cbsbsVos;
                });

        CbsbsVo res = new CbsbsVo();
        List<ScanVo> goods = res.getGoods();
        List<TakeOrderSugestVo> outsuggestion = res.getOutsuggestion();
      //  List<TakeOrderSugestVo> outsuggestionss = new ArrayList<>();

        HashSet<TakeOrderSugestVo> outsuggestions = new HashSet<>();

        CompletableFuture<List<TakeOrderSugestVo>> f2 =
                CompletableFuture.supplyAsync(() -> {
                    String key=String.valueOf(cbsbsVo.getCbsb01());
                    ListOperations<String,TakeOrderSugestVo> list = redisTemplates.opsForList();
                    Boolean bool=redisTemplates.hasKey(key);
                    if (bool){
                        List<TakeOrderSugestVo> range = list.range(key, 0, -1);
                        for(TakeOrderSugestVo takeOrderSugestVo:range){

                            CbsdCriteria cbsdCriteria = new CbsdCriteria();
                            cbsdCriteria.createCriteria().andCbsd09EqualTo(takeOrderSugestVo.getSn())
                                    .andCbsb01EqualTo(cbsbsVo.getCbsb01());
                            List<Cbsd> cbsds = cbsdMapper.selectByExample(cbsdCriteria);
                            if (cbsds.size() > 0) {
                                takeOrderSugestVo.setScanStatus("已扫码");
                            } else {
                                takeOrderSugestVo.setScanStatus("未扫码");
                            }
                        }
                        outsuggestion.addAll(range);
                        return  outsuggestion; //如果存在直接从缓存查询返回集合
                         }
else{
                    //  for (int k=0;k<cbsbsVos.size();k++) {
                    CbscCriteria asd = new CbscCriteria();
                    asd.createCriteria().andCbsb01EqualTo(cbsbsVo.getCbsb01());
                    List<Cbsc> cbscs1 = cbscMapper.selectByExample(asd);
                    double sum = 0;
                    if (cbscs1.size() > 0) {
                        sum = cbscs1.stream().mapToDouble(Cbsc::getCbsc09).sum();
                        for (Cbsc cbsc : cbscs1) {
                            if (cbsc.getTakegoodsid() != null) {
                                CbpmCriteria example = new CbpmCriteria();
                                example.createCriteria().andCbpk01EqualTo(cbsc.getTakegoodsid())
                                        .andCbpm08EqualTo(cbsc.getCbsc08())
                                        .andCbpm07EqualTo(0);

                                List<Cbpm> cbpms = cbpmMapper.selectByExample(example);
                                for (Cbpm cbpm : cbpms) {
                                    Cbla cbla = cblaMapper.selectByPrimaryKey(cbpm.getCbpm10());
                                    Cbpb cbpb = cbpbMapper.selectByPrimaryKey(cbpm.getCbpm08());
                                    Cbpa cbpa = cbpaMapper.selectByPrimaryKey(cbpb.getCbpb14());
                                    Cala cala = calaMapper.selectByPrimaryKey(cbpb.getCbpb10());
                                    TakeOrderSugestVo outsuggestio = new TakeOrderSugestVo();
                                    if (cala != null) {
                                        outsuggestio.setBrand(cala.getCala08());

                                    }
                                    if (cbpa != null) {
                                        outsuggestio.setGoodClass(cbpa.getCbpa08());
                                    }
                                    if (cbpb != null) {
                                        outsuggestio.setDescription(cbpb.getCbpb08());
                                        outsuggestio.setModel(cbpb.getCbpb12());

                                    }
                                    if (cbpm.getCbpm09() != null) {
                                        CbsdCriteria cbsdCriteria = new CbsdCriteria();
                                        cbsdCriteria.createCriteria().andCbsd09EqualTo(cbpm.getCbpm09())
                                                .andCbsb01EqualTo(cbsbsVo.getCbsb01());
                                        List<Cbsd> cbsds = cbsdMapper.selectByExample(cbsdCriteria);
                                        if (cbsds.size() > 0) {
                                            outsuggestio.setScanStatus("已扫码");
                                        } else {
                                            outsuggestio.setScanStatus("未扫码");
                                        }

                                    }
                                    outsuggestio.setSn(cbpm.getCbpm09());
                                    if (cbla != null) {
                                        outsuggestio.setSku(cbla.getCbla09());
                                    }

                                    outsuggestions.add(outsuggestio);
                                }
                            }
                        }
                    }
                   outsuggestion.addAll(outsuggestions);
//            outsuggestion.addAll(outsuggestions);
                  //  int a= (int) sum;
               /*     if (outsuggestionss.size() > sum) {
                        List<TakeOrderSugestVo> takeOrderSugestVos = outsuggestionss.subList(0, (int) sum);
                        outsuggestion.addAll(takeOrderSugestVos);

                    } else {
                        outsuggestion.addAll(outsuggestionss);
                    }*/
                        if(outsuggestion.size()>0){
                            list.leftPushAll(key,outsuggestion);
                        }
                    return outsuggestion;}
                });

        double sum;

       // List<CbsbsVo> finalCbsbsVos = cbsbsVos;
        CompletableFuture<List<ScanVo>> f3 =
                CompletableFuture.supplyAsync(() -> {


        Integer cbsb01 = cbsbsVo.getCbsb01();
        if(cbsb01==null){
            throw new SwException("销售出库单id不能为空");
        }
        CbsdCriteria example3 = new CbsdCriteria();
        example3.createCriteria().andCbsb01EqualTo(cbsb01);
        List<Cbsd> cbsds = cbsdMapper.selectByExample(example3);
        //扫描记录
        if(cbsds.size()>0) {
            HashSet<ScanVo> good = new HashSet<>();

            //for (int i = 0; i < cbsbsVos.size(); i++) {

                Date date = new Date();
            for (Cbsd cbsd : cbsds) {
                Cbpb cbpb = cbpbMapper.selectByPrimaryKey(cbsd.getCbsd08());

                Cala cala = calaMapper.selectByPrimaryKey(cbpb.getCbpb10());
                ScanVo scanVo = new ScanVo();
                if (cbpb != null) {
                    Cbpa cbpa = cbpaMapper.selectByPrimaryKey(cbpb.getCbpb14());
                    if (cbpa != null) {
                        scanVo.setLx(cbpa.getCbpa07());
                    }
                }
                scanVo.setCbpe03(date);
                scanVo.setPinpai(cala.getCala08());
                scanVo.setCbpb08(cbpb.getCbpb08());
                scanVo.setCbpb12(cbpb.getCbpb12());
                scanVo.setCbpb15(cbpb.getCbpb15());
                scanVo.setSn(cbsd.getCbsd09());
               /*     Cbla cbla = cblaMapper.selectByPrimaryKey(cbsds.get(j).getCbsd10());
                    if(cbla==null){
                        throw new SwException("没有改库位信息");
                    }
                    scanVo.setKwm(cbla.getCbla09());*/
                scanVo.setCbpe03(cbsd.getCbsd03());
                good.add(scanVo);
            }


               // cbsbsVos.get(i).setSaoma(size);
               // saoma +=cbsbsVos.get(i).getSaoma();
           // }
            Stream<ScanVo> sorted = good.stream().sorted(Comparator.comparing(ScanVo::getCbpe03).reversed());
            goods.addAll(sorted.collect(Collectors.toList()));
        }
        //扫描记录
            return goods;
        });

        CompletableFuture.allOf(f1, f2, f3).join();
        List<CbsbsVo> cbsbsVos = f1.get();
        List<TakeOrderSugestVo> takeOrderSugestVos = f2.get();
        List<ScanVo> scanVos = f3.get();
         sum = cbsbsVos.stream().mapToDouble(CbsbsVo::getCbsc09).sum();
    /*    for(int i=0;i<cbsbsVos.size();i++){
            if(cbsbsVos.get(i).getCbsc09()==null){
                throw new SwException("明细表数量为空");

            }
            sum+=cbsbsVos.get(i).getCbsc09();
        }*/
        if(cbsbsVos.size()>0){
            cbsbsVos.get(0).setSaomanums(scanVos.size());

            cbsbsVos.get(0).setGoods(scanVos);
            cbsbsVos.get(0).setNums(sum);
            cbsbsVos.get(0).setOutsuggestion(takeOrderSugestVos);
        }

        return cbsbsVos;
        }


    @Transactional
    @Override
    public int insertSwJsStoress(Cbsd itemList) throws ExecutionException, InterruptedException {
//id,sn

        if(itemList==null){
            throw new SwException("请扫描商品");
        }

        CbsbsVo cbsbsVo = new CbsbsVo();
        cbsbsVo.setCbsb01(itemList.getCbsb01());
        List<CbsbsVo> cbsbsVos = selectSwJsTaskGoodsRelListss(cbsbsVo);
        if(cbsbsVos.size()>0){
        if(cbsbsVos.get(0).getSaomanums()!=null){
            double v = cbsbsVos.get(0).getSaomanums().doubleValue();

            if( v==cbsbsVos.get(0).getNums()){
            throw new SwException("该销售出库单已扫描完成");
        }
       if(cbsbsVos.get(0).getOutsuggestion().size()>0){
           List<String> collect = cbsbsVos.get(0).getOutsuggestion().stream().map(TakeOrderSugestVo::getSn).collect(Collectors.toList());
           String cbsd09 = itemList.getCbsd09();
           if(!collect.contains(cbsd09)){
               throw new SwException("该商品sn不在建议出库列表中"+cbsd09);
           }

       }
        }}


        //对比sn和sku
        if(itemList.getCbsd08()!=null) {
            Cbpb cbpb = cbpbMapper.selectByPrimaryKey(itemList.getCbsd08());
            if(cbpb!=null){
                if(Objects.equals(cbpb.getCbpb12(), itemList.getCbsd09())){
                    throw new SwException("sn不正确");
                }
            }
        }

        if (itemList.getCbsb01() == null) {
            throw new SwException("销售出库单主表id不能为空");
        }
        Cbsb cbsb2s = cbsbMapper.selectByPrimaryKey(itemList.getCbsb01());
        if(cbsb2s==null){
            throw new SwException("销售出库单主表不存在");
        }
//锁
        String cbic10 = itemList.getCbsd09();
        String uuid = UUID.randomUUID().toString();
        Boolean lock = redisTemplates.opsForValue().setIfAbsent(cbic10, uuid, 3, TimeUnit.SECONDS);
        if (!lock) {
            throw new SwException("sn重复，请勿重复提交");
        }
      //  String s = redisTemplates.opsForValue().get(cbic10);

        GsGoodsSnDo gsGoodsSnDo;
        try {
            CbscCriteria cas = new CbscCriteria();
            cas.createCriteria().andCbsb01EqualTo(itemList.getCbsb01())
                    .andCbsc07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbsc> cbphs = cbscMapper.selectByExample(cas);
            if (cbphs.size() == 0) {
                throw new SwException("销售出库单明细为空");
            }
            Set<Integer> uio = cbphs.stream().map(Cbsc::getCbsc08).collect(Collectors.toSet());


            Cbsb cbsb1 = cbsbMapper.selectByPrimaryKey(itemList.getCbsb01());
            if (!cbsb1.getCbsb11().equals(TaskStatus.sh.getCode())) {
                throw new SwException(" 审核状态才能扫码");
            }
            SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
            CbsdMapper mapper = session.getMapper(CbsdMapper.class);
            Date date = new Date();
            Long userid = SecurityUtils.getUserId();
            CbsdCriteria IOP = new CbsdCriteria();
            IOP.createCriteria().andCbsd09EqualTo(itemList.getCbsd09())
                    .andCbsb01EqualTo(itemList.getCbsb01());
            List<Cbsd> cbsds = cbsdMapper.selectByExample(IOP);
            if (cbsds.size() > 0) {
                throw new SwException("SN码已存在销售出库扫码记录"+itemList.getCbsd09());
            }

            CbpmCriteria examplew = new CbpmCriteria();
            examplew.createCriteria().andCbpm09EqualTo(itemList.getCbsd09());
            List<Cbpm> cbpms = cbpmMapper.selectByExample(examplew);

/*            GsGoodsSnCriteria examples = new GsGoodsSnCriteria();
            examples.createCriteria().andSnEqualTo( itemList.get(i).getCbsd09());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(examples);*/
            if(cbpms.size()==0){
                throw new SwException("该sn不存在"+itemList.getCbsd09());
            }

/*if(gsGoodsSns.get(0).getLocationId()==null){
    throw new SwException("库位id为空");

}*/
           /* Cbla cbla = cblaMapper.selectByPrimaryKey(cbpms.get(0).getCbpm10());
            if (cbla == null) {
                throw new SwException("提货单扫描表库位不存在");
            }
            if (!cbla.getCbla10().equals(storeid)) {
                throw new SwException("库位不属于该仓库");
            }*/

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
            CbscCriteria examplae = new CbscCriteria();
            examplae.createCriteria().andCbsb01EqualTo(itemList.getCbsb01());
            List<Cbsc> cbscs = cbscMapper.selectByExample(examplae);
                 if(cbscs.size()>0){
                     for (Cbsc cbsc : cbscs) {
                         if (cbsc.getTakegoodsid() != null) {
                             CbpkCriteria example = new CbpkCriteria();
                             example.createCriteria().andCbpk09EqualTo(cbsb.getCbsb09())
                                     .andCbpk01EqualTo(cbsc.getTakegoodsid());
//                    .andCheckStatusEqualTo(checkstatusEnum.ZJWC.getCode());
                             List<Cbpk> cbpkList = cbpkMapper.selectByExample(example);
                             if (cbpkList.size() == 0) {
                                 throw new SwException("该商品不在提货单里");
                             }
                         }
                     }
                 }
            //判断是否在提货单里
            //判断sn是不是下架状态
           GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
            gsGoodsSnCriteria.createCriteria().andSnEqualTo(itemList.getCbsd09());
            List<GsGoodsSn> gsGoodsSnList = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
            if(gsGoodsSnList.size()>0){
                if (gsGoodsSnList.get(0).getGroudStatus()!=null) {

                }
            }


            //更新sn表
            gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setSn(itemList.getCbsd09());
            gsGoodsSnDo.setOutTime(date);
            gsGoodsSnDo.setGroudStatus(Groudstatus.XJ.getCode());

            CbscCriteria example1 = new CbscCriteria();
            example1.createCriteria().andCbsb01EqualTo(itemList.getCbsb01())
                    .andCbsc08EqualTo(itemList.getCbsd08());
            List<Cbsc> cbscList = cbscMapper.selectByExample(example1);
            if(cbscList.size()>0){
                for (Cbsc cbsc : cbscList) {
                    if (cbsc.getScannum() == null || cbsc.getScannum() == 0) {
                        cbsc.setScannum(1);
                        cbscMapper.updateByPrimaryKeySelective(cbsc);
                        break;
                    } else {
                        if (cbsc.getScannum() + 1 > cbsc.getCbsc09()) continue;

                        cbsc.setScannum(cbsc.getScannum() + 1);
                        cbscMapper.updateByPrimaryKeySelective(cbsc);
                        break;

                    }
                }
            }


        } finally {
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                    "then " +
                    "return redis.call('del', KEYS[1]) " +
                    "else " +
                    "return 0 " +
                    "end";
            this.redisTemplates.execute(new DefaultRedisScript<>(script, Boolean.class), Arrays.asList("lock"), uuid);

        }


        taskService.updateGsGoodsSn(gsGoodsSnDo);




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
            for (Cbsd cbpe : cbpes) {
                if (cbpe.getCbsd11().equals(ScanStatusEnum.YISAOMA.getCode())) {

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
        Cbsb cbsb1 = cbsbMapper.selectByPrimaryKey(cbsbDo.getCbsb01());
        if(!cbsb1.getCbsb11().equals(TaskStatus.mr.getCode())){
            throw new SwException(" 未审核状态才能编辑");
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

      /*      CbscCriteria example = new CbscCriteria();
            example.createCriteria().andCbsc01EqualTo(good.getCbsc01());*/
            cbscMapper.insertSelective(cbsc);
        }
        return;
    }

    @Override
    public int insertSelloutofwarehouseplus(CbsbDo cbsbDo) {

        Long userid = SecurityUtils.getUserId();
        Cbsb cbsb = BeanCopyUtils.coypToClass(cbsbDo, Cbsb.class, null);
        Date date = new Date();
        cbsb.setCbsb02(date);
        cbsb.setCbsb03(Math.toIntExact(userid));
        cbsb.setCbsb04(date);
        cbsb.setCbsb05(Math.toIntExact(userid));
        cbsb.setCbsb06(DeleteFlagEnum.DELETE.getCode());
        cbsb.setCbsb10(cbsbDo.getCbsb10());
        String sellofwarehouseNo = numberGenerate.getSellofwarehouseNo(cbsbDo.getCbsb10());
        cbsb.setCbsb07(sellofwarehouseNo);
        cbsb.setCbsb08(date);
        cbsb.setCbsb11(TaskStatus.mr.getCode());
        cbsb.setCbsb12(Math.toIntExact(userid));
        cbsb.setUserId(Math.toIntExact(userid));


        cbsbMapper.insertSelective(cbsb);
        CbsbCriteria example = new CbsbCriteria();
        example.createCriteria().andCbsb07EqualTo(sellofwarehouseNo);
        List<Cbsb> cbsbs = cbsbMapper.selectByExample(example);

        List<Cbsc> goods = cbsbDo.getGoods();
        if(goods==null||goods.size()==0){
            throw new SwException("请至少添加一件货物");
        }
        Cbsc cbsc;
        for (Cbsc good : goods) {
            cbsc = new Cbsc();
            if(good.getCbsc01()==null){
                throw new SwException("销售出库单明细id不能为空");
            }
            cbsc.setCbsc02(good.getCbsc02());
            cbsc.setCbsc03(date);
     //       cbsc.setCbsc04(Math.toIntExact(userid));
            cbsc.setCbsc05(date);
    //        cbsc.setCbsc06(Math.toIntExact(userid));
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
            if(cbsbs.size()>0){
                Cbsb cbsb1 = cbsbs.get(0);
                cbsc.setCbsb01(cbsb1.getCbsb01());
            }

      /*      CbscCriteria example = new CbscCriteria();
            example.createCriteria().andCbsc01EqualTo(good.getCbsc01());*/
            cbscMapper.insertSelective(cbsc);
        }
        return 1;
    }

    @Override
    public List<CbsbsVo> swJsGoodslistcheck(CbsbsVo cbsbsVo) throws ExecutionException, InterruptedException {

        List<CbsbsVo> cbsbsVos = selectSwJsTaskGoodsRelListss(cbsbsVo);
        List<ScanVo> goods = cbsbsVos.get(0).getGoods();
        List<String> scan = goods.stream().map(ScanVo::getSn).collect(Collectors.toList());
        List<TakeOrderSugestVo> outsuggestion = cbsbsVos.get(0).getOutsuggestion();

        return null;
    }

    @SneakyThrows
    @Override
    public int insertSwJsStoresslist(List<Cbsd> itemLists) {

        //id,sn

        if(itemLists==null){
            throw new SwException("请扫描商品");
        }

        for (Cbsd itemList : itemLists) {
            CbsbsVo cbsbsVo = new CbsbsVo();
            cbsbsVo.setCbsb01(itemList.getCbsb01());
            List<CbsbsVo> cbsbsVos = selectSwJsTaskGoodsRelListss(cbsbsVo);
            if(cbsbsVos.size()>0){
                if(cbsbsVos.get(0).getSaomanums()!=null){
                    double v = cbsbsVos.get(0).getSaomanums().doubleValue();

                    if( v==cbsbsVos.get(0).getNums()){
                        throw new SwException("该销售出库单已扫描完成");
                    }
                    if(cbsbsVos.get(0).getOutsuggestion().size()>0){
                        List<String> collect = cbsbsVos.get(0).getOutsuggestion().stream().map(TakeOrderSugestVo::getSn).collect(Collectors.toList());
                        String cbsd09 = itemList.getCbsd09();
                        if(!collect.contains(cbsd09)){
                            throw new SwException("该商品sn不在建议出库列表中"+cbsd09);
                        }

                    }
                }}


            //对比sn和sku
            if(itemList.getCbsd08()!=null) {
                Cbpb cbpb = cbpbMapper.selectByPrimaryKey(itemList.getCbsd08());
                if(cbpb!=null){
                    if(Objects.equals(cbpb.getCbpb12(), itemList.getCbsd09())){
                        throw new SwException("sn不正确"+itemList.getCbsd09());
                    }
                }
            }

            if (itemList.getCbsb01() == null) {
                throw new SwException("销售出库单主表id不能为空");
            }
            Cbsb cbsb2s = cbsbMapper.selectByPrimaryKey(itemList.getCbsb01());
            if(cbsb2s==null){
                throw new SwException("销售出库单主表不存在");
            }
//锁
            String cbic10 = itemList.getCbsd09();
            String uuid = UUID.randomUUID().toString();
            Boolean lock = redisTemplates.opsForValue().setIfAbsent(cbic10, uuid, 3, TimeUnit.SECONDS);
            if (!lock) {
                throw new SwException("sn重复，请勿重复提交"+cbic10);
            }
            //  String s = redisTemplates.opsForValue().get(cbic10);

            GsGoodsSnDo gsGoodsSnDo;
            try {
                CbscCriteria cas = new CbscCriteria();
                cas.createCriteria().andCbsb01EqualTo(itemList.getCbsb01())
                        .andCbsc07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                List<Cbsc> cbphs = cbscMapper.selectByExample(cas);
                if (cbphs.size() == 0) {
                    throw new SwException("销售出库单明细为空");
                }
                Set<Integer> uio = cbphs.stream().map(Cbsc::getCbsc08).collect(Collectors.toSet());


                Cbsb cbsb1 = cbsbMapper.selectByPrimaryKey(itemList.getCbsb01());
                if (!cbsb1.getCbsb11().equals(TaskStatus.sh.getCode())) {
                    throw new SwException(" 审核状态才能扫码");
                }
                SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
                CbsdMapper mapper = session.getMapper(CbsdMapper.class);
                Date date = new Date();
                Long userid = SecurityUtils.getUserId();
                CbsdCriteria IOP = new CbsdCriteria();
                IOP.createCriteria().andCbsd09EqualTo(itemList.getCbsd09())
                        .andCbsb01EqualTo(itemList.getCbsb01());
                List<Cbsd> cbsds = cbsdMapper.selectByExample(IOP);
                if (cbsds.size() > 0) {
                    throw new SwException("SN码已存在销售出库扫码记录"+itemList.getCbsd09());
                }

                CbpmCriteria examplew = new CbpmCriteria();
                examplew.createCriteria().andCbpm09EqualTo(itemList.getCbsd09());
                List<Cbpm> cbpms = cbpmMapper.selectByExample(examplew);

    /*            GsGoodsSnCriteria examples = new GsGoodsSnCriteria();
                examples.createCriteria().andSnEqualTo( itemList.get(i).getCbsd09());
                List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(examples);*/
                if(cbpms.size()==0){
                    throw new SwException("该sn不存在"+itemList.getCbsd09());
                }

    /*if(gsGoodsSns.get(0).getLocationId()==null){
        throw new SwException("库位id为空");

    }*/
               /* Cbla cbla = cblaMapper.selectByPrimaryKey(cbpms.get(0).getCbpm10());
                if (cbla == null) {
                    throw new SwException("提货单扫描表库位不存在");
                }
                if (!cbla.getCbla10().equals(storeid)) {
                    throw new SwException("库位不属于该仓库");
                }*/

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
                CbscCriteria examplae = new CbscCriteria();
                examplae.createCriteria().andCbsb01EqualTo(itemList.getCbsb01());
                List<Cbsc> cbscs = cbscMapper.selectByExample(examplae);
                if(cbscs.size()>0){
                    for (Cbsc cbsc : cbscs) {
                        if (cbsc.getTakegoodsid() != null) {
                            CbpkCriteria example = new CbpkCriteria();
                            example.createCriteria().andCbpk09EqualTo(cbsb.getCbsb09())
                                    .andCbpk01EqualTo(cbsc.getTakegoodsid());
    //                    .andCheckStatusEqualTo(checkstatusEnum.ZJWC.getCode());
                            List<Cbpk> cbpkList = cbpkMapper.selectByExample(example);
                            if (cbpkList.size() == 0) {
                                throw new SwException("该商品不在提货单里");
                            }
                        }
                    }
                }
                //判断是否在提货单里
                //判断sn是不是下架状态
                GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
                gsGoodsSnCriteria.createCriteria().andSnEqualTo(itemList.getCbsd09());
                List<GsGoodsSn> gsGoodsSnList = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
                if(gsGoodsSnList.size()>0){
                    if (gsGoodsSnList.get(0).getGroudStatus()!=null) {

                    }
                }


                //更新sn表
                gsGoodsSnDo = new GsGoodsSnDo();
                gsGoodsSnDo.setSn(itemList.getCbsd09());
                gsGoodsSnDo.setOutTime(date);
                gsGoodsSnDo.setGroudStatus(Groudstatus.XJ.getCode());

                CbscCriteria example1 = new CbscCriteria();
                example1.createCriteria().andCbsb01EqualTo(itemList.getCbsb01())
                        .andCbsc08EqualTo(itemList.getCbsd08());
                List<Cbsc> cbscList = cbscMapper.selectByExample(example1);
                if(cbscList.size()>0){
                    for (Cbsc cbsc : cbscList) {
                        if (cbsc.getScannum() == null || cbsc.getScannum() == 0) {
                            cbsc.setScannum(1);
                            cbscMapper.updateByPrimaryKeySelective(cbsc);
                            break;
                        } else {
                            if (cbsc.getScannum() + 1 > cbsc.getCbsc09()) continue;

                            cbsc.setScannum(cbsc.getScannum() + 1);
                            cbscMapper.updateByPrimaryKeySelective(cbsc);
                            break;

                        }
                    }
                }


            } finally {
                String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                        "then " +
                        "return redis.call('del', KEYS[1]) " +
                        "else " +
                        "return 0 " +
                        "end";
                this.redisTemplates.execute(new DefaultRedisScript<>(script, Boolean.class), Arrays.asList("lock"), uuid);

            }


            taskService.updateGsGoodsSn(gsGoodsSnDo);


            cbsdMapper.insertSelective(itemList);
        }

        return 1;
    }

}
