package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.dto.CbpcDto;
import com.ruoyi.system.domain.dto.CbpdDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISwJsPurchaseinboundService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author 15698
 */
@Slf4j
@Service
public class SwJsPurchaseinboundServiceImpl implements ISwJsPurchaseinboundService {
@Resource
private GsGoodsSnMapper gsGoodsSnMapper;
@Resource
private BaseCheckService baseCheckService;
@Resource
private GsGoodsSkuMapper gsGoodsSkuMapper;
    @Resource
    private CbpcMapper cbpcMapper;

    @Resource
    private CbpdMapper cbpdMapper;

    @Resource
    private CbsaMapper cbasMapper;

    @Resource
    private CbpeMapper cbpeMapper;

   @Resource
   private TaskService taskService;

   @Resource
   private CbsaMapper cbsaMapper;

   @Resource
   private CblaMapper cblaMapper;

   @Resource
   private CbwaMapper cbwaMapper;

   @Resource
   private CalaMapper calaMapper;

   @Resource
   private CbpbMapper cbpbMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Resource
    private CbibMapper cbibMapper;


@Resource
private NumberGenerate numberGenerate;


    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    /**
     * 新增采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public IdVo insertSwJsSkuBarcodes(CbpdDto cbpdDto) {

       // 检查供应商
        baseCheckService.checksupplier(cbpdDto.getCbpc09());
        //检查仓库
        baseCheckService.checkStore(cbpdDto.getCbpc10());
        //检查商品
     //  baseCheckService.checkGoods(cbpdDto.getCbpd08());

        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc07EqualTo(cbpdDto.getCbpc07())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpc> cbpcs = cbpcMapper.selectByExample(example);
        //主表根据输入编号查不到数据，添加数据
            Long userid = SecurityUtils.getUserId();
            Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
            Date date = new Date();
            cbpc.setCbpc02(date);
            cbpc.setCbpc03(Math.toIntExact(userid));
            cbpc.setCbpc04(date);
            cbpc.setCbpc05(Math.toIntExact(userid));
            cbpc.setCbpc08(date);
            cbpc.setCbpc11(TaskStatus.mr.getCode());
            cbpc.setCbpc06(DeleteFlagEnum.NOT_DELETE.getCode());
            String purchaseinboundNo = numberGenerate.getPurchaseinboundNo(cbpdDto.getCbpc10());
            cbpc.setCbpc07(purchaseinboundNo);
            cbpc.setCbpc13(date);
            cbpc.setCbpc15(date);
            cbpc.setUserId(Math.toIntExact(userid));
            cbpcMapper.insertSelective(cbpc);

            CbpcCriteria example1 = new CbpcCriteria();
            example1.createCriteria().andCbpc07EqualTo(purchaseinboundNo)
                    .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbpc> cbpcs1 = cbpcMapper.selectByExample(example1);
        IdVo idVo = new IdVo();
        if(!CollectionUtils.isEmpty(cbpcs1)){
            idVo.setId(cbpcs1.get(0).getCbpc01());
        }
       // idVo.setId(cbpcs1.get(0).getCbpc01());

        List<Cbpd> goods = cbpdDto.getGoods();
        for(Cbpd cbpd : goods){
            cbpd.setCbpc01(idVo.getId());
        }
        this.insertSwJsSkuBarcsodesm(goods);


        return idVo;


    }
    /**
     * 新增采购入库单扫码
     *
     * @param itemList 审核信息
     * @return 结果
     */
   @Transactional
    @Override
    public int insertSwJsSkuBarcodesm(Cbpe itemList) {

       log.info("打印" + Thread.currentThread().getName() + "sn表");


       if (itemList == null) {
           throw new SwException("请选择要扫的商品");
       }
       if (itemList.getCbpc01() == null) {
           throw new SwException("采购订单主单id不能为空");
       }
       CbpcVo cbpcVo = new CbpcVo();
       cbpcVo.setCbpc01(itemList.getCbpc01());
       List<CbpcVo> cbpcVos = selectSwJsTaskGoodsRelListsss(cbpcVo);

       if(  cbpcVos.get(0).getSaoma()!=null){
           double v = cbpcVos.get(0).getSaoma().doubleValue();

           if( v==cbpcVos.get(0).getNums()){
               throw new SwException("该销售出库单已扫描完成");
           }
       }



       Cbpc cbpcs = cbpcMapper.selectByPrimaryKey(itemList.getCbpc01());
       Integer storeid = cbpcs.getCbpc10();

       CbpdCriteria cas = new CbpdCriteria();
       cas.createCriteria().andCbpc01EqualTo(itemList.getCbpc01());
       List<Cbpd> cbphs = cbpdMapper.selectByExample(cas);
       if (cbphs.size() == 0) {
           throw new SwException("采购入库单明细为空");
       }
       List<Integer> goodsids = cbphs.stream().map(Cbpd::getCbpd08).collect(Collectors.toList());
       Set<Integer> sio = new HashSet<>(goodsids);






       Date date = new Date();
       Long userid = SecurityUtils.getUserId();
           if (itemList.getCbpe09() == null) {
               throw new SwException("sn码不能为空");
           }


           String cbic10 = itemList.getCbpe09();
           String uuid = UUID.randomUUID().toString();
           Boolean lock = redisTemplate.opsForValue().setIfAbsent(cbic10, uuid, 3, TimeUnit.SECONDS);
           if (!lock) {
               throw new SwException("sn重复，请勿重复提交");
           }
           String s = redisTemplate.opsForValue().get(cbic10);



           GsGoodsSnDo gsGoodsSnDo;
           try {
               if (itemList.getCbpe08() == null) {
                   throw new SwException("商品id不能为空");
               }
               if (!sio.contains(itemList.getCbpe08())) {
                   throw new SwException("该商品不在采购入货单明细中");
               }

               if (itemList.getCbpe10() == null) {
                   throw new SwException("库位id不能为空");
               }
               Cbla cblas = cblaMapper.selectByPrimaryKey(itemList.getCbpe10());
               if (cblas == null) {
                   throw new SwException("库位不存在");
               }
               if (!cblas.getCbla10().equals(storeid)) {
                   throw new SwException("库位不属于该仓库");
               }
               String sn = itemList.getCbpe09();
           /*  boolean redisKeyBoolean = redisTemplate.opsForValue().setIfAbsent("lock",sn, 5, TimeUnit.SECONDS);
           String lock = redisTemplate.opsForValue().get("lock");*/
/*
           while (!redisTemplate.opsForValue().setIfAbsent("lock",sn, 3, TimeUnit.SECONDS)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace(); }
            }
           String lock = redisTemplate.opsForValue().get("lock");*/

               //校验sn码
               CbpeCriteria examples = new CbpeCriteria();
               examples.createCriteria().andCbpe09EqualTo(sn);
               List<Cbpe> cbpes = cbpeMapper.selectByExample(examples);
               if (cbpes.size() > 0) {
                   throw new SwException("该sn已存在");
               }
               //校验库位
               Cbla cbla = baseCheckService.checkStoresku(itemList.getCbpe10());

               itemList.setCbpe03(date);
               itemList.setCbpe04(Math.toIntExact(userid));
               itemList.setCbpe05(date);
               itemList.setCbpe06(Math.toIntExact(userid));
               itemList.setCbpe07(DeleteFlagEnum.NOT_DELETE.getCode());
               itemList.setUserId(Math.toIntExact(userid));
               itemList.setCbpe11(ScanStatusEnum.YISAOMA.getCode());
               //如果查不到添加信息到库存表
               Cbpc cbpc = cbpcMapper.selectByPrimaryKey(itemList.getCbpc01());
               if (cbpc == null) {
                   throw new SwException("采购入库单不存在");
               }


               GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
               gsGoodsSnCriteria.createCriteria().andSnEqualTo(sn);
               List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(gsGoodsSnCriteria);
               if (gsGoodsSns.size() > 0) {
                   throw new SwException("该sn已存在库存sn表里");
               }

               gsGoodsSnDo = new GsGoodsSnDo();
               gsGoodsSnDo.setSn(itemList.getCbpe09());
               gsGoodsSnDo.setGoodsId(itemList.getCbpe08());
               gsGoodsSnDo.setWhId(cbpc.getCbpc10());
               gsGoodsSnDo.setLocationId(itemList.getCbpe10());
               gsGoodsSnDo.setStatus(GoodsType.yrk.getCode());
               gsGoodsSnDo.setInTime(date);
               gsGoodsSnDo.setGroudStatus(Groudstatus.SJ.getCode());
           } finally {

               String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                       "then " +
                       "return redis.call('del', KEYS[1]) " +
                       "else " +
                       "return 0 " +
                       "end";
               this.redisTemplate.execute(new DefaultRedisScript<>(script, Boolean.class), Arrays.asList("lock"), uuid);

           }

           // this.redisTemplate.delete("lock");

           cbpeMapper.insertSelective(itemList);
           taskService.addGsGoodsSns(gsGoodsSnDo);


           //  redisTemplate.delete("lock");



       return 1;
   }
    //导入新增
    @Transactional
    @Override
    public int insertSwJsStores(List<CbpcDto> itemList) {

        if(CollectionUtils.isEmpty(itemList)){
            throw new SwException("导入数据为空");
        }

        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        if(itemList.get(0).getStorename()==null){
            throw new SwException("仓库名称不能为空");
        }
        String storename = itemList.get(0).getStorename();
        CbwaCriteria cbwaCriteria = new CbwaCriteria();
        cbwaCriteria.createCriteria().andCbwa09EqualTo(storename);
        List<Cbwa> cbwas = cbwaMapper.selectByExample(cbwaCriteria);
        if(CollectionUtils.isEmpty(cbwas)){
            throw new SwException("仓库不存在");
        }
        if(Objects.isNull(itemList.get(0).getSuppierName())){
            throw new SwException("供应商名称不能为空");

        }
        CbsaCriteria cbsaCriteria = new CbsaCriteria();
        cbsaCriteria.createCriteria().andCbsa08EqualTo(itemList.get(0).getSuppierName());
        List<Cbsa> cbsas = cbsaMapper.selectByExample(cbsaCriteria);
        if(CollectionUtils.isEmpty(cbsas)){
            throw new SwException("供应商不存在");
        }

        if(Objects.isNull(itemList.get(0).getMoneytype())){
            throw new SwException("货币类形不能为空");
        }
         CalaCriteria calaCriteria = new CalaCriteria();
        calaCriteria.createCriteria()
                .andCala08EqualTo(itemList.get(0).getMoneytype())
                .andCala10EqualTo("币种");
        List<Cala> calas = calaMapper.selectByExample(calaCriteria);
        if(CollectionUtils.isEmpty(calas)){
                throw new SwException("货币类形不存在");
            }



        Integer cala01 = calas.get(0).getCala01();
        Integer cbsa01 = cbsas.get(0).getCbsa01();

        Integer cbwa01 = cbwas.get(0).getCbwa01();

        Date cbpc08 = itemList.get(0).getCbpc08();
        Integer cbpc09 = itemList.get(0).getCbpc09();
        Integer cbpc10 = itemList.get(0).getCbpc10();
        Integer cbpc16 = itemList.get(0).getCbpc16();
        String purchaseinboundNo = numberGenerate.getPurchaseinboundNo(cbwa01);

        Cbpc cbpc = new Cbpc();
        cbpc.setCbpc02(date);
        cbpc.setCbpc03(Math.toIntExact(userid));
        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpc.setCbpc07(purchaseinboundNo);
        cbpc.setCbpc08(date);
        cbpc.setCbpc09(cbsa01);
        cbpc.setCbpc10(cbwa01);
        cbpc.setCbpc11(TaskStatus.mr.getCode());
        cbpc.setCbpc16(cala01);
        cbpc.setCbpc06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpcMapper.insertSelective(cbpc);
CbpcCriteria cbpcCriteria = new CbpcCriteria();
        cbpcCriteria.createCriteria().andCbpc07EqualTo(purchaseinboundNo);
        List<Cbpc> cbpcs = cbpcMapper.selectByExample(cbpcCriteria);
        Integer cbpc01 = cbpcs.get(0).getCbpc01();

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbpdMapper mapper = session.getMapper(CbpdMapper.class);

        for (int i = 0; i < itemList.size(); i++) {
            if(Objects.isNull(itemList.get(i).getGoodtype())){
                throw new SwException("商品不能为空");
            }
            CbpbCriteria cbpbCriteria = new CbpbCriteria();
            cbpbCriteria.createCriteria().andCbpb12EqualTo(itemList.get(i).getGoodtype());
            List<Cbpb> cbpbs = cbpbMapper.selectByExample(cbpbCriteria);
            if(cbpbs.size()==0){
                throw new SwException("商品不存在");
            }
            Integer cbpb01 = cbpbs.get(i).getCbpb01();


            itemList.get(i).setCbpd03(date);
            itemList.get(i).setCbpd04(Math.toIntExact(userid));
            itemList.get(i).setCbpd05(date);
            itemList.get(i).setCbpd06(Math.toIntExact(userid));
            itemList.get(i).setCbpd07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));
            itemList.get(i).setCbpd08(cbpb01);
            itemList.get(i).setCbpd09(itemList.get(i).getCbpd09());
            itemList.get(i).setCbpd11(itemList.get(i).getCbpd11());
            itemList.get(i).setCbpd13(itemList.get(i).getCbpd13());
            itemList.get(i).setCbpc01(cbpc01);
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

    @Transactional
    @Override
    public int insertSwJsSkuBarcsodesm(List<Cbpd> itemList) {
        if(itemList.size()==0){
            throw new SwException("采购入库明细不能为空");
        }

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbpdMapper mapper = session.getMapper(CbpdMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            if(Objects.isNull(itemList.get(i).getCbpc01())){
                throw new SwException("采购入库主表id不能为空");
            }
            if(Objects.isNull(itemList.get(i).getCbpd08())){
                throw new SwException("商品不能为空");
            }
            if(Objects.isNull(itemList.get(i).getCbpd09())){
                throw new SwException("数量不能为空");
            }
            if(Objects.isNull(itemList.get(i).getCbpd11())){
                throw new SwException("单价不能为空");
            }

            itemList.get(i).setCbpd03(date);
            itemList.get(i).setCbpd04(Math.toIntExact(userid));
            itemList.get(i).setCbpd05(date);
            itemList.get(i).setCbpd06(Math.toIntExact(userid));
            itemList.get(i).setCbpd07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));

            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();

 Cbpc cbpc = new Cbpc();
 if(itemList.get(0).getCbpc01()==null){
     throw new SwException("采购入库主表id不能为空");
 }
        cbpc.setCbpc01(itemList.get(0).getCbpc01());
        cbpc.setCbpc06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpcMapper.updateByPrimaryKeySelective(cbpc);
        return 1;
    }

    @Override
    public void SwJsPurchaseinboundeditone(CbpdDto cbpdDto) {
        if(cbpdDto.getCbpc01()==null){
            throw new SwException("采购订单id不能为空");
        }
        Cbpc cbpc1 = cbpcMapper.selectByPrimaryKey(cbpdDto.getCbpc01());
        if(!cbpc1.getCbpc11().equals(TaskStatus.mr.getCode())){
            throw new SwException("未审核状态才能修改");
        }

        List<Cbpd> goods = cbpdDto.getGoods();
        if(goods==null||goods.size()==0){
            throw new SwException("请至少添加一件货物");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        cbpc.setCbpc01(cbpdDto.getCbpc01());
        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpcMapper.updateByPrimaryKeySelective(cbpc);

        CbpdCriteria cbpdCriterisa = new CbpdCriteria();
        cbpdCriterisa.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01());
        int i = cbpdMapper.deleteByExample(cbpdCriterisa);

        Cbpd cbpd = null;
        for(Cbpd good:goods){
            cbpd = new Cbpd();
            if(good.getCbpd01()==null){
                throw new SwException("采购订单明细id不能为空");
            }
            cbpd.setCbpd01(null);
            cbpd.setCbpd05(date);
            cbpd.setCbpd06(Math.toIntExact(userid));
            cbpd.setCbpd07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbpd.setCbpd08(good.getCbpd08());
            cbpd.setCbpd09(good.getCbpd09());
            cbpd.setCbpd10(good.getCbpd10());
            cbpd.setCbpd11(good.getCbpd11());
            cbpd.setCbpd12(good.getCbpd12());
            cbpd.setCbpd13(good.getCbpd13());
            cbpd.setCbpc01(cbpdDto.getCbpc01());

            CbpdCriteria cbpdCriteria = new CbpdCriteria();
            cbpdCriteria.createCriteria().andCbpd01EqualTo(good.getCbpd01());
            cbpdMapper.insertSelective(cbpd);
        }
        return;

    }

    /**
     * 审核采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int SwJsSkuBarcodeshs(CbpdDto cbpdDto) {




        Cbpc cbpc1 = cbpcMapper.selectByPrimaryKey(cbpdDto.getCbpc01());

        if(!cbpc1.getCbpc11().equals(TaskStatus.mr.getCode())){
            throw new SwException("不是未审核状态");
        }

        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc11(TaskStatus.sh.getCode());
        cbpc.setCbpc12(cbpdDto.getCbpc12());
        cbpc.setCbpc13(cbpdDto.getCbpc13());


        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpcMapper.updateByExampleSelective(cbpc, example);
    }
    /**
     * 反审采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int SwJsSkuBarcodeshss(CbpdDto cbpdDto) {

        CbpeCriteria example1 = new CbpeCriteria();
        example1.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01());
        List<Cbpe> cbpes = cbpeMapper.selectByExample(example1);
        if(cbpes.size()>0 ){
            int size = cbpes.size();
            for(int i=0;i<size;i++){
                if(cbpes.get(i).getCbpe11().equals(ScanStatusEnum.YISAOMA.getCode())) {

                    throw new SwException("已扫码不能反审");
                }
            }
        }

        Cbpc cbpc1 = cbpcMapper.selectByPrimaryKey(cbpdDto.getCbpc01());

        if(!cbpc1.getCbpc11().equals(TaskStatus.sh.getCode())){
            throw new SwException("不是 审核状态");
        }

        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc11(TaskStatus.mr.getCode());
        cbpc.setCbpc12(cbpdDto.getCbpc12());
        cbpc.setCbpc13(cbpdDto.getCbpc13());
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpcMapper.updateByExampleSelective(cbpc, example);
    }
    /**
     * 采购入库单标记完成
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int SwJsSkuBarcodeshsss(CbpdDto cbpdDto) {

        Cbpc cbpc1 = cbpcMapper.selectByPrimaryKey(cbpdDto.getCbpc01());
        if(cbpc1.getCbpc11().equals(TaskStatus.sh.getCode())||cbpc1.getCbpc11().equals(TaskStatus.fsh.getCode())){}
        else {
            throw new SwException("不是审核状态或反审状态不能标记完成");
        }


/*        int sdw=0;
        CbpdCriteria hji = new CbpdCriteria();
        hji.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01());
        List<Cbpd> ser = cbpdMapper.selectByExample(hji);
        if(ser.size()==0){
            throw new SwException("没有明细不能标记完成");
        }
        for (Cbpd cbpd : ser) {
            Double cbpd09 = cbpd.getCbpd09();
            sdw+=cbpd09;
        }
     CbpeCriteria ehks = new CbpeCriteria();
        ehks.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01());
        List<Cbpe> aoc = cbpeMapper.selectByExample(ehks);
        if(aoc.size()<sdw){
            throw new SwException("扫码数量小于任务数量不能标记完成");
        }*/




        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc11(TaskStatus.bjwc.getCode());
        cbpc.setCbpc12(cbpdDto.getCbpc12());
        cbpc.setCbpc13(cbpdDto.getCbpc13());

        Cbsa cbsa = cbasMapper.selectByPrimaryKey(cbpc1.getCbpc09());
        if(cbsa==null){
            throw new SwException("供应商不存在");
        }

        //
        CbwaCriteria exampse1 = new CbwaCriteria();
        exampse1.createCriteria().andCbwa12EqualTo("数量管理");
        List<Cbwa> cbwas = cbwaMapper.selectByExample(exampse1);
        List<Integer> goodsids = cbwas.stream().map(Cbwa::getCbwa01).collect(Collectors.toList());
        Set<Integer> sio = new HashSet<>(goodsids);



        //判断是哪个仓库  数量仓库
        if(sio.contains(cbpc1.getCbpc10())){
            //数量管理查找商品id和仓库id，没有就加入
            CbpdCriteria cbpdexample1=new CbpdCriteria();
            cbpdexample1.createCriteria()
                    .andCbpc01EqualTo(cbpdDto.getCbpc01());
            List<Cbpd> cbpds = cbpdMapper.selectByExample(cbpdexample1);
            //得到数量
            List<Double> collect2 = cbpds.stream().map(Cbpd::getCbpd09).collect(Collectors.toList());
            double[] doubles = collect2.stream().mapToDouble(Double::doubleValue).toArray();


            //得到商品id
            List<Integer> collect = cbpds.stream().map(Cbpd::getCbpd08).collect(Collectors.toList());
            int[] ints = collect.stream().mapToInt(Integer::intValue).toArray();
            if (ints.length == 0) {
                throw new SwException("采购入库明细没有商品id");
            }
            for(int i=0;i<ints.length;i++) {
                int goodsid = ints[i];
               // cbpds.get(i).getCbpd08();
                GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
                example.createCriteria()
                        .andGoodsIdEqualTo(goodsid)
                        .andWhIdEqualTo(cbpc1.getCbpc10());
                List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
                double num = doubles[i];
                //对库存表的操作
                if (gsGoodsSkus.size() == 0) {
                    //新增数据
                    GsGoodsSku gsGoodsSku = new GsGoodsSku();
                    gsGoodsSku.setCreateTime(date);
                    gsGoodsSku.setUpdateTime(date);
                    gsGoodsSku.setCreateBy(Math.toIntExact(userid));
                    gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                    gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                    gsGoodsSku.setGoodsId(goodsid);
                    gsGoodsSku.setWhId(cbpc1.getCbpc10());
                    gsGoodsSku.setQty(num);
                    gsGoodsSkuMapper.insertSelective(gsGoodsSku);

                }
                else {
                    //更新数据
//                    List<Integer> collect1 = gsGoodsSkus.stream().map(GsGoodsSku::getId).collect(Collectors.toList());
//                    int[] ints1 = collect1.stream().mapToInt(Integer::intValue).toArray();
//                    int id = ints1[0];

                    Integer id = gsGoodsSkus.get(0).getId();
                    GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);
                    gsGoodsSku.setId(id);
                    gsGoodsSku.setQty(gsGoodsSku.getQty() + num);
                    gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                    gsGoodsSku.setUpdateTime(date);
                    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
                }

            }
            //台账操作
            //调用台账方法，最后加
            CbpdCriteria example3 = new CbpdCriteria();
            example3.createCriteria()
                    .andCbpc01EqualTo(cbpdDto.getCbpc01());
            List<Cbpd> cbpds1 = cbpdMapper.selectByExample(example3);
            for(int j=0;j<cbpds1.size();j++) {
                CbibDo cbibDo = new CbibDo();
                cbibDo.setCbib02(cbpc1.getCbpc10());
                cbibDo.setCbib03(cbpc1.getCbpc07());
                cbibDo.setCbib05(String.valueOf(TaskType.cgrkd.getCode()));
                cbibDo.setCbib06(cbsa.getCbsa07());
                cbibDo.setCbib07(cbpc1.getCbpc01());
                cbibDo.setCbib08(cbpds1.get(j).getCbpd08());
                //本次入库数量
                cbibDo.setCbib11(cbpds1.get(j).getCbpd09());
                cbibDo.setCbib12(cbpds1.get(j).getCbpd12());


                cbibDo.setCbib17(TaskType.cgrkd.getMsg());
                cbibDo.setCbib19(cbpc1.getCbpc09());
                taskService.InsertCBIB(cbibDo);
            }
            }

        else {

            int sdw=0;
            CbpdCriteria hji = new CbpdCriteria();
            hji.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01());
            List<Cbpd> ser = cbpdMapper.selectByExample(hji);
            if(ser.size()==0){
                throw new SwException("没有明细不能标记完成");
            }
            for (Cbpd cbpd : ser) {
                Double cbpd09 = cbpd.getCbpd09();
                sdw+=cbpd09;
            }
            CbpeCriteria ehks = new CbpeCriteria();
            ehks.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01());
            List<Cbpe> aoc = cbpeMapper.selectByExample(ehks);
            if(aoc.size()<sdw){
                throw new SwException("扫码数量小于任务数量不能标记完成");
            }

            CbpdCriteria example2 = new CbpdCriteria();
            example2.createCriteria()
                    .andCbpc01EqualTo(cbpdDto.getCbpc01());
            List<Cbpd> cbpds = cbpdMapper.selectByExample(example2);

            List<Cbpe> cbpes = null;
            Double num= 0.0;
            Double nums= 0.0;

            UIOVo uioVo = new UIOVo();
            uioVo.setId(cbpdDto.getCbpc01());
            List<UIOVo> selectbyid = cbpeMapper.selectbyid(uioVo);
            if(selectbyid.size()>0){
                for(int k=0;k<selectbyid.size();k++){
                GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
                example.createCriteria()
                        .andGoodsIdEqualTo(selectbyid.get(k).getGoodsId())
                        .andWhIdEqualTo(cbpc1.getCbpc10())
                        .andLocationIdEqualTo(selectbyid.get(k).getStoreskuid());
                List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
                // double num = doubles[i];
                //对库存表的操作
                if (gsGoodsSkus.size() == 0) {
                    //新增数据
                    GsGoodsSku gsGoodsSku = new GsGoodsSku();
                    gsGoodsSku.setCreateTime(date);
                    gsGoodsSku.setUpdateTime(date);
                    gsGoodsSku.setCreateBy(Math.toIntExact(userid));
                    gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                    gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                    gsGoodsSku.setGoodsId(selectbyid.get(k).getGoodsId());
                    gsGoodsSku.setWhId(cbpc1.getCbpc10());
                    gsGoodsSku.setQty((double) selectbyid.get(k).getNums());
                    gsGoodsSku.setLocationId(selectbyid.get(k).getStoreskuid());
                    gsGoodsSkuMapper.insertSelective(gsGoodsSku);

                }
                else {

                    Cbla cbla = cblaMapper.selectByPrimaryKey(selectbyid.get(k).getStoreskuid());
                    Double cbla11 = cbla.getCbla11();
                    //更新数据
//                    List<Integer> collect1 = gsGoodsSkus.stream().map(GsGoodsSku::getId).collect(Collectors.toList());
//                    int[] ints1 = collect1.stream().mapToInt(Integer::intValue).toArray();
//                    int id = ints1[0];

                    Integer id = gsGoodsSkus.get(0).getId();
                    GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);
                    gsGoodsSku.setId(id);
                    if(gsGoodsSku.getQty() + selectbyid.get(k).getNums()>=cbla11){
                        throw new SwException("入库数量为"+gsGoodsSku.getQty()+"所在库位数量"+gsGoodsSku.getQty()
                                +"大于库位最大容量"+cbla11);
                    }
                    gsGoodsSku.setQty(gsGoodsSku.getQty() + selectbyid.get(k).getNums());
                    gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                    gsGoodsSku.setUpdateTime(date);
                    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
                }
            }}

            for (int j = 0; j < cbpds.size(); j++) {
                //判断是哪个仓库  扫码仓库
                CbpeCriteria example1 = new CbpeCriteria();
                example1.createCriteria()
                        .andCbpc01EqualTo(cbpdDto.getCbpc01())
                        .andCbpe08EqualTo(cbpds.get(j).getCbpd08());
                cbpes = cbpeMapper.selectByExample(example1);
                if (cbpes.size() == 0) {
                    throw new SwException("商品id为" + cbpds.get(j).getCbpd08() + "扫码数量为0条");
                }
                //按仓库分的数量
                nums = (double) cbpes.size();
                //库存操作
/*
                for (int i = 0; i < cbpes.size(); i++) {





                    Integer goodsid = cbpes.get(i).getCbpe08();
                    if (cbpes.get(i).getCbpe10() == null) {
                        throw new SwException("库位id不能为空");
                    }
                    Integer cbpe10 = cbpes.get(i).getCbpe10();
                    //库存操作
                    GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
                    example.createCriteria()
                            .andGoodsIdEqualTo(goodsid)
                            .andWhIdEqualTo(cbpc1.getCbpc10())
                            .andLocationIdEqualTo(cbpe10);
                    List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
                    // double num = doubles[i];
                    //对库存表的操作
                    if (gsGoodsSkus.size() == 0) {
                        //新增数据
                        GsGoodsSku gsGoodsSku = new GsGoodsSku();
                        gsGoodsSku.setCreateTime(date);
                        gsGoodsSku.setUpdateTime(date);
                        gsGoodsSku.setCreateBy(Math.toIntExact(userid));
                        gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                        gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                        gsGoodsSku.setGoodsId(goodsid);
                        gsGoodsSku.setWhId(cbpc1.getCbpc10());
                        gsGoodsSku.setQty(1.0);
                        gsGoodsSku.setLocationId(cbpe10);
                        gsGoodsSkuMapper.insertSelective(gsGoodsSku);

                    }
                    else {

                        Cbla cbla = cblaMapper.selectByPrimaryKey(cbpe10);
                        Double cbla11 = cbla.getCbla11();
                        //更新数据
//                    List<Integer> collect1 = gsGoodsSkus.stream().map(GsGoodsSku::getId).collect(Collectors.toList());
//                    int[] ints1 = collect1.stream().mapToInt(Integer::intValue).toArray();
//                    int id = ints1[0];

                        Integer id = gsGoodsSkus.get(0).getId();
                        GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);
                        gsGoodsSku.setId(id);
                        if(gsGoodsSku.getQty()>=cbla11){
                            throw new SwException("库位id为"+cbpe10+"的库位已满");

                        }
                        gsGoodsSku.setQty(gsGoodsSku.getQty() + 1);
                        gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                        gsGoodsSku.setUpdateTime(date);
                        gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
                    }

                }
*/


                //台账操作
                //调用台账方法，最后加
                CbpdCriteria example3 = new CbpdCriteria();
                example3.createCriteria()
                        .andCbpd07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                        .andCbpc01EqualTo(cbpdDto.getCbpc01());
                List<Cbpd> cbpds1 = cbpdMapper.selectByExample(example3);

                CbibDo cbibDo = new CbibDo();
                cbibDo.setCbib02(cbpc1.getCbpc10());
                cbibDo.setCbib03(cbpc1.getCbpc07());
                cbibDo.setCbib05(String.valueOf(TaskType.cgrkd.getCode()));
                cbibDo.setCbib06(cbsa.getCbsa08());
                cbibDo.setCbib07(cbpc1.getCbpc01());
                cbibDo.setCbib08(cbpes.get(0).getCbpe08());
                //本次入库数量
                cbibDo.setCbib11(nums);
                Double cbpd11 = cbpds1.get(0).getCbpd11();
                Double prices = cbpd11 * nums;
                cbibDo.setCbib12(prices);

                cbibDo.setCbib17(TaskType.cgrkd.getMsg());
                cbibDo.setCbib19(cbpc1.getCbpc09());
                taskService.InsertCBIB(cbibDo);
            }



        }


    /*    //扫码仓库
        else {
            CbpeCriteria example = new CbpeCriteria();
            example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                    .andCbpe06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbpe> cbpes = cbpeMapper.selectByExample(example);
            for (int i = 0; i < cbpes.size(); i++) {
                //商品id
                Integer goodsid = cbpes.get(i).getCbpe08();
                //库位id
                Integer sku = cbpes.get(i).getCbpe10();
                //sn码
                String sn = cbpes.get(i).getCbpe09();


                GsGoodsSkuCriteria example1 = new GsGoodsSkuCriteria();

                //检查是否有数据存在
                example1.createCriteria()
                        .andGoodsIdEqualTo(goodsid)
                        .andLocationIdEqualTo(sku);
                List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example1);
                //对库存表的操作
                if (gsGoodsSkus.size() == 0) {
                    //新增数据
                    GsGoodsSku gsGoodsSku = new GsGoodsSku();
                    gsGoodsSku.setCreateTime(date);
                    gsGoodsSku.setUpdateTime(date);
                    gsGoodsSku.setCreateBy(Math.toIntExact(userid));
                    gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                    gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                    gsGoodsSku.setGoodsId(goodsid);
                    gsGoodsSku.setLocationId(sku);
                    gsGoodsSku.setQty(1.0);
                    gsGoodsSkuMapper.insertSelective(gsGoodsSku);
                } else {
                    //对库存进行更新操作
                    Integer id = gsGoodsSkus.get(i).getId();
                    GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);
                    gsGoodsSku.setQty(gsGoodsSku.getQty() + 1);
                    gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                    gsGoodsSku.setUpdateTime(date);
                    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);

                }
                //对货物sn表操作
                GsGoodsSnDo goodsSnDo = new GsGoodsSnDo();
                goodsSnDo.setSn(sn);
                goodsSnDo.setGoodsId(goodsid);
                goodsSnDo.setLocationId(sku);
                goodsSnDo.setStatus(GoodsType.yrk.getCode());
                goodsSnDo.setInTime(date);
                taskService.InsertGsGoodsn(goodsSnDo);

                //商品sn扫码交易表
                GsGoodsSnTransDo goodsSnTransDo = new GsGoodsSnTransDo();
                goodsSnTransDo.setSn(sn);
                goodsSnTransDo.setTransType(TaskType.cgrkd.getCode());
                goodsSnTransDo.setTransId(cbpdDto.getCbpc01());
                goodsSnTransDo.setTransLineId(cbpc1.getCbpc07());
                goodsSnTransDo.setGoodsId(goodsid);
                goodsSnTransDo.setLocationId(sku);
                taskService.InsertGsGoodsntrans(goodsSnTransDo);

                //调用台账方法，最后加
                CbpdCriteria example3 = new CbpdCriteria();
                example3.createCriteria()
                        .andCbpd06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                        .andCbpc01EqualTo(cbpdDto.getCbpc01());
                List<Cbpd> cbpds = cbpdMapper.selectByExample(example3);

                CbibDo cbibDo = new CbibDo();
                cbibDo.setCbib02(cbpc1.getCbpc10());
                cbibDo.setCbib03(cbpc1.getCbpc07());
                cbibDo.setCbib05(String.valueOf(TaskType.cgrkd.getCode()));
                cbibDo.setCbib06(cbsa.getCbsa07());
                cbibDo.setCbib07(cbpc1.getCbpc01());
                cbibDo.setCbib08(goodsid);
                cbibDo.setCbib11(cbpds.get(i).getCbpd09());
                cbibDo.setCbib12(cbpds.get(i).getCbpd12());
                cbibDo.setCbib15(cbpds.get(i).getCbpd09());
                cbibDo.setCbib16(cbpds.get(i).getCbpd12());
                cbibDo.setCbib17(TaskType.cgrkd.getMsg());
                cbibDo.setCbib19(cbpc1.getCbpc09());
                taskService.InsertCBIB(cbibDo);
            }
            }*/

            CbpcCriteria example = new CbpcCriteria();
            example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                    .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
             cbpcMapper.updateByExampleSelective(cbpc, example);
        return 1;
    }
    /**
     * 采购入库单取消完成
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int SwJsSkuBarcodesh(CbpdDto cbpdDto) {
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();


        if(cbpdDto.getCbpc01()==null){
            throw new SwException("采购入库单id不能为空");
        }
//数量仓库
        Cbpc cbpc2 = cbpcMapper.selectByPrimaryKey(cbpdDto.getCbpc01());
        if(cbpc2==null){
            throw new SwException("采购入库单不存在");
        }
        if(cbpc2.getCbpc10()==null){
            throw new SwException("采购入库单仓库不能为空");
        }
        Integer storeid = cbpc2.getCbpc10();
        Cbwa cbwa = cbwaMapper.selectByPrimaryKey(storeid);
        if(Objects.equals(cbwa.getCbwa12(), "数量管理")){

            CbpdCriteria exawple = new CbpdCriteria();
            exawple.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01());
            List<Cbpd> cbpds = cbpdMapper.selectByExample(exawple);
            if(cbpds.size()>0){
                for(int i=0;i< cbpds.size();i++){
                    Integer goodsid = cbpds.get(i).getCbpd08();
                    Double qty = cbpds.get(i).getCbpd09();
                    //对库存进行更新操作
                    GsGoodsSkuCriteria exoample = new GsGoodsSkuCriteria();
                    exoample.createCriteria().andGoodsIdEqualTo(goodsid)
                                               .andWhIdEqualTo(storeid);
                    List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(exoample);
                    if(gsGoodsSkus.size()>0){
                        baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());

                        Integer id = gsGoodsSkus.get(0).getId();
                        GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);
                        if(gsGoodsSku.getQty()<qty){
                            throw new SwException("仓库id为"+storeid+"商品id为"+goodsid+"的商品库存不足");
                        }
                        gsGoodsSku.setId(id);
                        gsGoodsSku.setQty(gsGoodsSku.getQty() - qty);
                        gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                        gsGoodsSku.setUpdateTime(date);
                        gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
                    }


                }
                Cbsa cbsa = cbasMapper.selectByPrimaryKey(cbpc2.getCbpc09());
                if(cbsa==null){
                    throw new SwException("供应商不存在");
                }
                //台账操作
                //调用台账方法，最后加
                CbpdCriteria example3 = new CbpdCriteria();
                example3.createCriteria()
                        .andCbpc01EqualTo(cbpdDto.getCbpc01());
                List<Cbpd> cbpds1 = cbpdMapper.selectByExample(example3);
                for(int j=0;j<cbpds1.size();j++) {
                    CbibDo cbibDo = new CbibDo();
                    Cbib cbib = BeanCopyUtils.coypToClass(cbibDo, Cbib.class, null);

                    cbib.setCbib02(cbpc2.getCbpc10());
                    cbib.setCbib03(cbpc2.getCbpc07());
                    cbib.setCbib04(date);
                    cbib.setCbib05(String.valueOf(TaskType.cgrkd.getCode()));
                    cbib.setCbib06(cbsa.getCbsa07());
                    cbib.setCbib07(cbpc2.getCbpc01());
                    cbib.setCbib08(cbpds1.get(j).getCbpd08());
                    //本次入库数量
                    cbib.setCbib11(cbpds1.get(j).getCbpd09());
                    cbib.setCbib12(cbpds1.get(j).getCbpd12());


                    cbib.setCbib17(TaskType.cgrkd.getMsg());
                    cbib.setCbib19(cbpc2.getCbpc09());
                    Cbib cbib1 = cbibMapper.selectLastByGoodsIdAndStoreId(cbib.getCbib08(), cbib.getCbib02());
                    if(cbib1!=null){
                        cbib.setCbib09(cbib1.getCbib15());
                        cbib.setCbib10(cbib1.getCbib16());

                        cbib.setCbib13(cbib1.getCbib13());
                        cbib.setCbib14(cbib1.getCbib14());
                        cbib.setCbib15(cbib.getCbib09()-cbib.getCbib11());
                        cbib.setCbib16(cbib.getCbib10()-cbib.getCbib12());
                        cbib.setCbib18(cbib1.getCbib18()+1);
                    }
                    cbibMapper.insertSelective(cbib);

                }
            }
        }


        CbpeCriteria example1 = new CbpeCriteria();
        example1.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01());
        List<Cbpe> cbpes = cbpeMapper.selectByExample(example1);
        if(cbpes.size()>0 ){
            int size = cbpes.size();
            for(int i=0;i<size;i++){
                if(cbpes.get(i).getCbpe11().equals(ScanStatusEnum.YISAOMA.getCode())) {

                    throw new SwException("已扫码不能取消完成");
                }
            }
        }


        Cbpc cbpc1 = cbpcMapper.selectByPrimaryKey(cbpdDto.getCbpc01());

        if(!cbpc1.getCbpc11().equals(TaskStatus.bjwc.getCode())){
            throw new SwException("不是标记完成状态");
        }
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc11(TaskStatus.sh.getCode());
        cbpc.setCbpc12(Math.toIntExact(userid));
        cbpc.setCbpc13(date);
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());


         cbpcMapper.updateByExampleSelective(cbpc, example);
        return 1;
    }

    @Override
    public List<CbpcVo> selectSwJsTaskGoodsRelListss(CbpcVo cbpcVo) {
        return  cbpdMapper.getInfosss(cbpcVo);
    }



    /**
     * 删除采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSwJsSkuBarcodsById(CbpdDto cbpdDto) {

        //标记完成不可删除
        Cbpc cbpc1 = cbpcMapper.selectByPrimaryKey(cbpdDto.getCbpc01());
        if(!cbpc1.getCbpc11().equals(TaskStatus.mr.getCode())){
            throw new SwException("默认情况才能删除");
        }
        Integer storeid = cbpc1.getCbpc10();
        CbpdCriteria example1=new CbpdCriteria();
        example1.createCriteria().andCbpd08EqualTo(cbpdDto.getCbpc01())
                .andCbpd07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpd> cbpds = cbpdMapper.selectByExample(example1);
        if(cbpds.size()>0) {
           Integer goodsid = cbpds.get(0).getCbpd08();
            //检查是否有库存
              baseCheckService.checkGoodsSku(goodsid,storeid);
        }
        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc06(DeleteFlagEnum.DELETE.getCode());
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        Cbpd cbpd = BeanCopyUtils.coypToClass(cbpdDto, Cbpd.class, null);
        cbpd.setCbpd05(date);
        cbpd.setCbpd06(Math.toIntExact(userid));
        cbpd.setCbpd07(DeleteFlagEnum.DELETE.getCode());
        CbpdCriteria example2 = new CbpdCriteria();
        example2.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpd07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpdMapper.updateByExampleSelective(cbpd,example2);


        return   cbpcMapper.updateByExampleSelective(cbpc, example);

    }
    /**
     * 修改采购入库单
     *
     * @param cbpcDo 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSwJsSkuBarcodes(CbpcDo cbpcDo) {
        //标记完成不可修改
        Cbpc cbpc1 = cbpcMapper.selectByPrimaryKey(cbpcDo.getCbpc01());
        if(cbpc1.getCbpc11().equals(TaskStatus.bjwc.getCode()) ||
                cbpc1.getCbpc11().equals(TaskStatus.qxwc.getCode()) ||
                cbpc1.getCbpc11().equals(TaskStatus.sh.getCode())  ){
            throw new SwException("非反审或默认不可修改");
        }

        if(cbpcDo.getCbpc07()!=null){
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc07EqualTo(cbpcDo.getCbpc07())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpc> cbpcs = cbpcMapper.selectByExample(example);
        if(cbpcs.size() >0 && !cbpcs.get(0).getCbpc01().equals(cbpcDo.getCbpc01())){
            throw new SwException("编号已存在");

        }
        }
        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpcDo, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc07(cbpcDo.getCbpc07());
        cbpc.setCbpc08(cbpcDo.getCbpc08());
        cbpc.setCbpc09(cbpcDo.getCbpc09());
        cbpc.setCbpc10(cbpcDo.getCbpc10());
        cbpc.setCbpc11(cbpcDo.getCbpc11());
        cbpc.setCbpc12(cbpcDo.getCbpc12());
        cbpc.setCbpc13(cbpcDo.getCbpc13());
        cbpc.setCbpc14(cbpcDo.getCbpc14());
        cbpc.setCbpc15(cbpcDo.getCbpc15());
        cbpc.setCbpc16(cbpcDo.getCbpc16());
        cbpc.setCbpc17(cbpcDo.getCbpc17());
        CbpcCriteria example2 = new CbpcCriteria();
        example2.createCriteria().andCbpc01EqualTo(cbpcDo.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
      return  cbpcMapper.updateByExampleSelective(cbpc, example2);

       /* Cbpd cbpd = BeanCopyUtils.coypToClass(cbpdDto, Cbpd.class, null);
        cbpd.setCbpd05(date);
        cbpd.setCbpd06(Math.toIntExact(userid));
        cbpd.setCbpd08(cbpdDto.getCbpd08());
        cbpd.setCbpd09(cbpdDto.getCbpd09());
        cbpd.setCbpd10(cbpdDto.getCbpd10());
        cbpd.setCbpd11(cbpdDto.getCbpd11());
        cbpd.setCbpd12(cbpdDto.getCbpd12());
        CbpdCriteria example1 = new CbpdCriteria();
        example1.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpd07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return  cbpdMapper.updateByExampleSelective(cbpd, example1);*/
    }
    /**
     * 采购入库单查询
     * @param cbpcVo 审核信息
     * @return 结果
     */
    @Override
    public List<CbpcVo> selectSwJsTaskGoodsRelLists(CbpcVo cbpcVo) {
        return  cbpdMapper.getInfoss(cbpcVo);
    }
    /**
     * 采购入库单详情
     * @param cbpcVo 审核信息
     * @return 结果
     */
    @Override
    public List<CbpcVo> selectSwJsTaskGoodsRelListsss(CbpcVo cbpcVo) {
        List<CbpcVo> infossss = cbpdMapper.getInfossss(cbpcVo);
        CbpcVo res = new CbpcVo();
        List<ScanVo> goods = res.getGoods();

        Integer cbpc01 = cbpcVo.getCbpc01();
        if (cbpc01 == null) {
            throw new SwException("采购入库单id不能为空");
        }
        CbpeCriteria example4 = new CbpeCriteria();
        example4.createCriteria().andCbpc01EqualTo(cbpc01);
        List<Cbpe> cbpess = cbpeMapper.selectByExample(example4);
        Double sum = 0.0;

        if(cbpess.size()>0){
            Integer saoma = 0;

        for (int i = 0; i < infossss.size(); i++) {
            CbpeCriteria example = new CbpeCriteria();
            example.createCriteria().andCbpc01EqualTo(cbpc01)
                    .andCbpe08EqualTo(infossss.get(i).getCbpd08());
            List<Cbpe> cbpes = cbpeMapper.selectByExample(example);
            int size = cbpes.size();
            if (size > 0) {
                for (int j = 0; j < size; j++) {
                    ScanVo scanVo = new ScanVo();
                    scanVo.setLx(infossss.get(i).getCbpa07());
                    scanVo.setPinpai(infossss.get(i).getCala08());
                    scanVo.setCbpb08(infossss.get(i).getCbpb08());
                    scanVo.setCbpb12(infossss.get(i).getCbpb12());
                    scanVo.setSn(cbpes.get(j).getCbpe09());
                    Cbla cbla = cblaMapper.selectByPrimaryKey(cbpes.get(j).getCbpe10());
                    if(cbla==null){
                        throw new SwException("没有改库位信息");
                    }
                    scanVo.setKwm(cbla.getCbla09());
                    scanVo.setCbpe03(cbpes.get(j).getCbpe03());
                    scanVo.setCbpb15(infossss.get(i).getCbpb15());
                    goods.add(scanVo);

                }
                infossss.get(i).setSaoma(size);
                 saoma += infossss.get(i).getSaoma();


            }

            infossss.get(0).setGoods(goods);
            // List<CbpcVo> list = new ArrayList<CbpcVo>(select);
        }

            infossss.get(0).setSaomanums(saoma);
        }

        if(infossss.size()>0) {
            for (int i = 0; i < infossss.size(); i++) {
                if(infossss.get(i).getCbpd09()==null){
                    throw new SwException("明细表数量为空");

                }
                sum += infossss.get(i).getCbpd09();
            }
            infossss.get(0).setNums(sum);
        }
        return infossss;
    }



    @Override
    public List<Cbpc> selectCBPCList(Cbpc cbpc) {
        return cbpdMapper.selectCBPCList(cbpc);
    }
    /**
     * 采购入库导入
     * @param swJsGoodsList
     * @return 结果
     */
    @Transactional
    @Override
    public String importSwJsGoods(List<CbpcDto> swJsGoodsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(swJsGoodsList) || swJsGoodsList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        this.insertSwJsStores(swJsGoodsList);


        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();    }



    public int insertCBPC(Cbpc cbpc)
    {
        return cbpdMapper.insertCBPC(cbpc);
    }

    public int updateCBPC(Cbpc cbpc)
    {
        return cbpdMapper.updateCBPC(cbpc);
    }


}


