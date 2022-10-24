package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbshDo;
import com.ruoyi.system.domain.Do.CbsjDo;
import com.ruoyi.system.domain.Do.GsGoodsSkuDo;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.CbsgMapper;
import com.ruoyi.system.mapper.CbshMapper;
import com.ruoyi.system.mapper.CbsjMapper;
import com.ruoyi.system.mapper.GsGoodsSnMapper;
import com.ruoyi.system.service.ISWWarehouseinventoryscheduleService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SWWarehouseinventoryscheduleImpl implements ISWWarehouseinventoryscheduleService {
@Resource
private CbshMapper cbshMapper;
@Resource
private CbsjMapper cbbsjMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private  NumberGenerate numberGenerate;

    @Resource
    private TaskService taskService;

    @Resource
    private BaseCheckService baseCheckService;

    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Resource
    private CbsjMapper cbsjMapper;
    @Override
    public List<CbshVo> selectSwJsStoreList(CbshVo cbshVo) {
        return cbshMapper.selectstorelist(cbshVo);
    }

    @Transactional
    @Override
    public IdVo insertSwJsStore(CbshDo cbshDo) {
        if(cbshDo.getCbsh09().equals(WarehouseSelect.CBW.getCode()) ||
                cbshDo.getCbsh09().equals(WarehouseSelect.GLW.getCode())){
            throw new SwException("请选择扫码仓库");
        }
        Long userId = SecurityUtils.getUserId();
        String warehouseinitializationNo = numberGenerate.getWarehouseinitializationNo(cbshDo.getCbsh10());
        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh02(date);
        cbsh.setCbsh03(date);
        cbsh.setCbsh04(Math.toIntExact(userId));
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh07(warehouseinitializationNo);
        cbsh.setCbsh08(cbshDo.getCbsh08());
        cbsh.setCbsh09(TaskStatus.mr.getCode());
        cbsh.setUserId(Math.toIntExact(userId));
        cbshMapper.insertSelective(cbsh);
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh07EqualTo(warehouseinitializationNo)
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example);
        IdVo idVo = new IdVo();
        idVo.setId(cbshes.get(0).getCbsh01());
        return idVo;
    }

    @Transactional
    @Override
    public int insertSwJsStores(Cbsj itemList) {
        Cbsh cbsh1 = cbshMapper.selectByPrimaryKey(itemList.getCbsh01());
        if(!cbsh1.getCbsh09().equals(TaskStatus.sh.getCode())){
            throw new SwException("审核状态才能扫码");
        }
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbsjMapper mapper = session.getMapper(CbsjMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
            if( itemList.getCbsj09() == null){
                throw new SwException("商品sn不能为空");
            }

        String cbic10 = itemList.getCbsj09();
        String uuid = UUID.randomUUID().toString();
        Boolean lock = redisTemplate.opsForValue().setIfAbsent(cbic10, uuid, 3, TimeUnit.SECONDS);
        if (!lock) {
            throw new SwException("sn重复，请勿重复提交");
        }
        String s = redisTemplate.opsForValue().get(cbic10);


        try {
      /*      GsGoodsSnCriteria example = new GsGoodsSnCriteria();
            example.createCriteria().andSnEqualTo(itemList.get(i).getCbsj09());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
            if(gsGoodsSns.size() > 0){
                throw new SwException("商品sn已存在");
            }
            CbsjCriteria example1 = new CbsjCriteria();
            example1.createCriteria().andCbsj09EqualTo(itemList.get(i).getCbsj09());
            List<Cbsj> cbsjs = cbsjMapper.selectByExample(example1);
            if(cbsjs.size() > 0){
                throw new SwException("商品sn已存在");
            }*/
            CbsjCriteria CAS = new CbsjCriteria();
            CAS.createCriteria()
                    .andCbsj09EqualTo(itemList.getCbsj09())
                            .andCbsj11EqualTo(TaskStatus.sh.getCode());
            List<Cbsj> cbsjs = cbsjMapper.selectByExample(CAS);
            if(cbsjs.size() > 0){
                throw new SwException("商品sn已盘点，不能重复盘点");
            }
            CbsjCriteria tyui = new CbsjCriteria();
            tyui.createCriteria()
                    .andCbsj09EqualTo(itemList.getCbsj09());
            List<Cbsj> cbsjs1 = cbsjMapper.selectByExample(tyui);
            if(cbsjs1.size()==0){
                throw new SwException("商品sn不在仓库盘点明细里");
            }


            itemList.setCbsj03(date);
            itemList.setCbsj04(Math.toIntExact(userid));
            itemList.setCbsj05(date);
            itemList.setCbsj06(Math.toIntExact(userid));
            itemList.setCbsj07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.setUserId(Math.toIntExact(userid));
            itemList.setCbsj11(TaskStatus.sh.getCode());


            //如果查不到添加信息到库存表
            Cbsh cbsh = cbshMapper.selectByPrimaryKey(itemList.getCbsh01());
          /*  GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
            //获取仓库id
            gsGoodsSkuDo.setWhId(cbsh.getCbsh10());
            //获取商品id
            gsGoodsSkuDo.setGoodsId(itemList.get(i).getCbsj08());
            gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //通过仓库id和货物id判断是否存在
            List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
            if(gsGoodsSkus.size()==0){
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbsj08());
                gsGoodsSkuDo1.setWhId(cbsh.getCbsh10());
                gsGoodsSkuDo1.setLocationId(itemList.get(i).getCbsj10());
                gsGoodsSkuDo1.setQty(1.0);
                taskService.addGsGoodsSku(gsGoodsSkuDo1);            }
//如果存在则更新库存数量
            else {
                //加锁
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbsj08());
                gsGoodsSkuDo1.setWhId(cbsh.getCbsh10());
                gsGoodsSkuDo1.setLocationId(itemList.get(i).getCbsj10());
                //查出
                Double qty = gsGoodsSkus.get(0).getQty();
                gsGoodsSkuDo1.setQty(qty+1.0);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);

            }*/
     /*       GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setSn(itemList.get(i).getCbsj09());
            gsGoodsSnDo.setGoodsId(itemList.get(i).getCbsj08());
            gsGoodsSnDo.setWhId(cbsh.getCbsh10());
            gsGoodsSnDo.setLocationId(itemList.get(i).getCbsj10());
            gsGoodsSnDo.setStatus(GoodsType.yrk.getCode());
            gsGoodsSnDo.setInTime(date);
            gsGoodsSnDo.setGroudStatus(Groudstatus.SJ.getCode());
            taskService.addGsGoodsSn(gsGoodsSnDo);*/
        } finally {
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                    "then " +
                    "return redis.call('del', KEYS[1]) " +
                    "else " +
                    "return 0 " +
                    "end";
            this.redisTemplate.execute(new DefaultRedisScript<>(script, Boolean.class), Arrays.asList("lock"), uuid);

        }

        CbsjCriteria example2 = new CbsjCriteria();
            example2.createCriteria().andCbsj09EqualTo(itemList.getCbsj09());

        cbsjMapper.updateByExampleSelective(itemList,example2);


   /*     itemList.get(0).getCbsh01();
        CbshDo cbshDo = new CbshDo();
        cbshDo.setCbsh01(itemList.get(0).getCbsh01());
        this.swJsStoreend(cbshDo);*/

        return 1;    }

    @Transactional
    @Override
    public int deleteSwJsStoreById(CbshDo cbshDo) {
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.DELETE.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbshMapper.updateByExampleSelective(cbsh, example);
    }

    @Transactional
    @Override
    public int swJsStoreend(CbshDo cbshDo) {
        CbshCriteria example1 = new CbshCriteria();
        example1.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example1);
        if(cbshes.size()==0){
            throw new SwException("库存盘点主表找不到");

        }
        if(!cbshes.get(0).getCbsh09().equals(TaskStatus.sh.getCode())){

            throw new SwException("非审核不能完成");
        }
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh09(TaskStatus.bjwc.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());


       /* CbsjCriteria example2 = new CbsjCriteria();
        example2.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01());
        List<Cbsj> cbsjs = cbbsjMapper.selectByExample(example2);
        for(int i=0;i<cbsjs.size();i++) {
            double num = cbsjs.size();
            GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
            //获取仓库id
            gsGoodsSkuDo.setWhId(cbsh.getCbsh10());
            //获取商品id
            gsGoodsSkuDo.setGoodsId(cbsjs.get(i).getCbsj08());
            gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //通过仓库id和货物id判断是否存在
            List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
            if (gsGoodsSkus.size() == 0) {
                if(cbsjs.get(i).getCbsj10()==null){
                    throw new SwException("商品没有货位");
                }

                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                gsGoodsSkuDo1.setGoodsId(cbsjs.get(i).getCbsj08());
                gsGoodsSkuDo1.setWhId(cbsh.getCbsh10());
                gsGoodsSkuDo1.setLocationId(cbsjs.get(i).getCbsj10());
                gsGoodsSkuDo1.setQty(num);
                taskService.addGsGoodsSku(gsGoodsSkuDo1);
            }
//如果存在则更新库存数量
            else {
                //加锁
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                gsGoodsSkuDo1.setGoodsId(cbsjs.get(i).getCbsj08());
                gsGoodsSkuDo1.setWhId(cbsh.getCbsh10());
                gsGoodsSkuDo1.setLocationId(cbsjs.get(i).getCbsj10());
                //查出
                Double qty = gsGoodsSkus.get(0).getQty();
                gsGoodsSkuDo1.setQty(qty + num);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);

            }


        }*/
        return   cbshMapper.updateByExampleSelective(cbsh, example);
    }

    @Transactional
    @Override
    public int swJsStoreendd(CbshDo cbshDo) {
        CbshCriteria example1 = new CbshCriteria();
        example1.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example1);
        if(!cbshes.get(0).getCbsh09().equals(TaskStatus.bjwc.getCode())){
            throw new SwException("非标记完成不能取消");
        }
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh09(TaskStatus.sh.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbshMapper.updateByExampleSelective(cbsh, example);
    }

    @Override
    public List<CbshVo> SwJsStorelists(CbshVo cbshVo) {
        return   cbshMapper.SwJsStorelists(cbshVo);    }

    @Override
    public List<CbshVo> SwJsStorelistss(CbshVo cbshVo) {
        return   cbshMapper.SwJsStorelistss(cbshVo);    }

    @Transactional
    @Override
    public List<CbsjVo> SwJsStorelistsss(CbsjVo cbsjVo) {


        List<CbsjVo> cbsjVos = cbshMapper.SwJsStorelistsss(cbsjVo);
        CbsjVo res = new CbsjVo();
        List<ScanVo> goods = res.getGoods();

        CbsjCriteria example = new CbsjCriteria();
        example.createCriteria().andCbsh01EqualTo(cbsjVo.getCbsh01());
        List<Cbsj> cbsjs = cbbsjMapper.selectByExample(example);

        CbsjCriteria example1 = new CbsjCriteria();
        example1.createCriteria().andCbsh01EqualTo(cbsjVo.getCbsh01())
                .andCbsj11EqualTo(TaskStatus.sh.getCode());
        List<Cbsj> cbsjss = cbbsjMapper.selectByExample(example1);

        if(cbsjss.size()>0){
            for(int i=0;i<cbsjss.size();i++){
                ScanVo scanVo = new ScanVo();
                scanVo.setSn(cbsjss.get(i).getCbsj09());
                scanVo.setKwm(cbsjVos.get(i).getCbla09());
                scanVo.setCbpb15(cbsjVos.get(i).getCbpb15());
                goods.add(scanVo);
            }

            cbsjVos.get(0).setGoods(goods);


            cbsjVos.get(0).setSaoma(cbsjss.size());
            int size = cbsjs.size();
            cbsjVos.get(0).setNums((double) size);
        }


        return cbsjVos;
    }

    @Override
    public int swJsStoreendsh(CbshDo cbshDo) {
        CbshCriteria example1 = new CbshCriteria();
        example1.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example1);
        if(!cbshes.get(0).getCbsh09().equals(TaskStatus.mr.getCode())){
            throw new SwException("非标记完成不能取消");
        }
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh09(TaskStatus.sh.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbshMapper.updateByExampleSelective(cbsh, example);
    }

    @Override
    public int swJsStoreendfs(CbshDo cbshDo) {
        CbshCriteria example1 = new CbshCriteria();
        example1.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example1);
        if(!cbshes.get(0).getCbsh09().equals(TaskStatus.sh.getCode())){
            throw new SwException("审核状态才能反审");
        }
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh09(TaskStatus.mr.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbshMapper.updateByExampleSelective(cbsh, example);
    }

    @Override
    public int insertSwJsStoress(List<Cbsj> itemList) {

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbsjMapper mapper = session.getMapper(CbsjMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            if( itemList.get(i).getCbsj09() == null){
                throw new SwException("商品sn不能为空");
            }

      /*      GsGoodsSnCriteria example = new GsGoodsSnCriteria();
            example.createCriteria().andSnEqualTo(itemList.get(i).getCbsj09());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
            if(gsGoodsSns.size() > 0){
                throw new SwException("商品sn已存在");
            }
            CbsjCriteria example1 = new CbsjCriteria();
            example1.createCriteria().andCbsj09EqualTo(itemList.get(i).getCbsj09());
            List<Cbsj> cbsjs = cbsjMapper.selectByExample(example1);
            if(cbsjs.size() > 0){
                throw new SwException("商品sn已存在");
            }*/


            itemList.get(i).setCbsj03(date);
            itemList.get(i).setCbsj04(Math.toIntExact(userid));
            itemList.get(i).setCbsj05(date);
            itemList.get(i).setCbsj06(Math.toIntExact(userid));
            itemList.get(i).setCbsj07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setCbsj08(itemList.get(i).getCbsj08());
            itemList.get(i).setCbsj09(itemList.get(i).getCbsj09());
            itemList.get(i).setCbsj10(itemList.get(i).getCbsj10());
            itemList.get(i).setUserId(Math.toIntExact(userid));
            itemList.get(i).setCbsj11(TaskStatus.mr.getCode());
            itemList.get(i).setCbsj12(itemList.get(i).getCbsj12());
            itemList.get(i).setCbsh01(itemList.get(i).getCbsh01());

            //如果查不到添加信息到库存表
            Cbsh cbsh = cbshMapper.selectByPrimaryKey(itemList.get(i).getCbsh01());
          /*  GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
            //获取仓库id
            gsGoodsSkuDo.setWhId(cbsh.getCbsh10());
            //获取商品id
            gsGoodsSkuDo.setGoodsId(itemList.get(i).getCbsj08());
            gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //通过仓库id和货物id判断是否存在
            List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
            if(gsGoodsSkus.size()==0){
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbsj08());
                gsGoodsSkuDo1.setWhId(cbsh.getCbsh10());
                gsGoodsSkuDo1.setLocationId(itemList.get(i).getCbsj10());
                gsGoodsSkuDo1.setQty(1.0);
                taskService.addGsGoodsSku(gsGoodsSkuDo1);            }
//如果存在则更新库存数量
            else {
                //加锁
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbsj08());
                gsGoodsSkuDo1.setWhId(cbsh.getCbsh10());
                gsGoodsSkuDo1.setLocationId(itemList.get(i).getCbsj10());
                //查出
                Double qty = gsGoodsSkus.get(0).getQty();
                gsGoodsSkuDo1.setQty(qty+1.0);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);

            }*/
     /*       GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setSn(itemList.get(i).getCbsj09());
            gsGoodsSnDo.setGoodsId(itemList.get(i).getCbsj08());
            gsGoodsSnDo.setWhId(cbsh.getCbsh10());
            gsGoodsSnDo.setLocationId(itemList.get(i).getCbsj10());
            gsGoodsSnDo.setStatus(GoodsType.yrk.getCode());
            gsGoodsSnDo.setInTime(date);
            gsGoodsSnDo.setGroudStatus(Groudstatus.SJ.getCode());
            taskService.addGsGoodsSn(gsGoodsSnDo);*/

            CbsjCriteria example2 = new CbsjCriteria();
            example2.createCriteria().andCbsj09EqualTo(itemList.get(i).getCbsj09());

            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }
   /*     itemList.get(0).getCbsh01();
        CbshDo cbshDo = new CbshDo();
        cbshDo.setCbsh01(itemList.get(0).getCbsh01());
        this.swJsStoreend(cbshDo);*/
        session.commit();
        session.clearCache();
        return 1;    }


}
