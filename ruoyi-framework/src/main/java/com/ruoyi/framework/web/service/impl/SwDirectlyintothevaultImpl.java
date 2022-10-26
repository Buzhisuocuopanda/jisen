package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Do.GsGoodsSkuDo;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.dto.CbicDto;
import com.ruoyi.system.domain.dto.DirectWarehousingDto;
import com.ruoyi.system.domain.dto.GsOrdersInDto;
import com.ruoyi.system.domain.vo.CbicVo;
import com.ruoyi.system.domain.vo.DirectWarehousingVo;
import com.ruoyi.system.domain.vo.GsOrdersInVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISwDirectlyintothevaultService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.OrderDistributionService;
import com.ruoyi.system.service.gson.TaskService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class SwDirectlyintothevaultImpl implements ISwDirectlyintothevaultService {
    @Resource
    private CbicMapper cbicMapper;
    @Resource
    private BaseCheckService baseCheckService;

    @Resource
    private OrderDistributionService orderDistributionService;

    @Resource
    private TaskService taskService;

    @Resource
    private CbsaMapper cbsaMapper;
    @Resource
    private CblaMapper cblaMapper;

    @Resource
    private CbpbMapper cbbpbMapper;

    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;

    private GsOrdersInMapper gsOrdersInMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Transactional
    @Override
    public int insertSwJsSkuBarcodess(List<CbicDto> cbicDto) {
        Date date = new Date();

        if(cbicDto.get(0).getUpc()==null){
            throw new SwException("upc没输入");
        }
       //  log.info("获取的upc为"+cbicDto.getUpc()+"长度为"+cbicDto.getUpc().length());
/*        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbicMapper mapper = session.getMapper(CbicMapper.class);*/


        for (int i=0;i<cbicDto.size();i++) {

            CbpbCriteria exampe = new CbpbCriteria();
            exampe.createCriteria().andCbpb15EqualTo(cbicDto.get(i).getUpc());
            List<Cbpb> cbpbs = cbbpbMapper.selectByExample(exampe);
            if(cbpbs.size()==0){
                throw new SwException("该upc没有对应商品");
            }


            String cbic10 = cbicDto.get(i).getSn();
            String uuid = UUID.randomUUID().toString();
            Boolean lock = redisTemplate.opsForValue().setIfAbsent(cbic10, uuid, 3, TimeUnit.SECONDS);
            if (!lock) {
                throw new SwException("sn重复，请勿重复提交");
            }
            String s = redisTemplate.opsForValue().get(cbic10);


            try {

              /*  CbicCriteria example1 = new CbicCriteria();
                example1.createCriteria().andCbic10EqualTo(cbicDto.getCbic10());
                List<Cbic> cbicss = cbicMapper.selectByExample(example1);
                if (cbicss.size() > 0) {
                    throw new SwException("该sn已经存在");
                }else{

                }


                GsGoodsSnCriteria example = new GsGoodsSnCriteria();
                example.createCriteria().andSnEqualTo(cbicDto.getCbic10());
                List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
                if (gsGoodsSns.size() > 0) {
                    throw new SwException("该sn已经存在仓库中");
                }*/

                // 检查供应商
                // baseCheckService.checksupplier(cbicDto.getCbic13());

                //检查商品
                // Cbpb cbpb = baseCheckService.checkGoods(cbicDto.getCbic09());

                Long userid = SecurityUtils.getUserId();

                //获取仓库id
                CblaCriteria example = new CblaCriteria();
                example.createCriteria().andCbla09EqualTo(cbicDto.get(i).getKuwei());
                List<Cbla> cbla = cblaMapper.selectByExample(example);

                if (cbla == null) {
                    throw new SwException("找不到该仓库");

                }

                Integer storeid = cbla.get(0).getCbla10();
                //回写生产总订单id
                DirectWarehousingDto directWarehousingDto = new DirectWarehousingDto();
                directWarehousingDto.setStoreId(storeid);
                directWarehousingDto.setUserId(Math.toIntExact(userid));
                directWarehousingDto.setGoodsId(cbpbs.get(0).getCbpb01());
                // directWarehousingDto.setOrderType(cbicDto.getCbic15());
                DirectWarehousingVo directWarehousingVo = orderDistributionService.directWarehousing(directWarehousingDto);

                CbicCriteria example1 = new CbicCriteria();
                example1.createCriteria().andCbic10EqualTo(cbicDto.get(i).getSn());
                List<Cbic> cbicss = cbicMapper.selectByExample(example1);
          /*      if (cbicss.size() > 0) {


                    Cbic cbic=new Cbic();
                    cbic.setCbic02(date);
                    CbicCriteria example2 = new CbicCriteria();
                    example2.createCriteria().andCbic10EqualTo(cbicDto.getCbic10());
                    cbicMapper.updateByExampleSelective(cbic,example2);

                    GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
                    //获取仓库id
                    gsGoodsSkuDo.setWhId(cbicDto.getCbic07());
                    //获取商品id
                    gsGoodsSkuDo.setGoodsId(cbpbs.get(0).getCbpb01());
                    //获取库位id
                    gsGoodsSkuDo.setLocationId(cbicDto.getCbic08());
                    gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                    //通过仓库id和货物id判断是否存在
                    List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
                    if (gsGoodsSkus.size() == 0) {
                        GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                        gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                        gsGoodsSkuDo1.setWhId(cbicDto.getCbic07());
                        gsGoodsSkuDo1.setLocationId(cbicDto.getCbic08());
                        gsGoodsSkuDo1.setQty(1.0);
                        taskService.addGsGoodsSku(gsGoodsSkuDo1);
                    }
                    //如果存在则更新库存数量
                    else {
                        //加锁
                        baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                        GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                        gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                        gsGoodsSkuDo1.setWhId(cbicDto.getCbic07());
                        gsGoodsSkuDo1.setLocationId(cbicDto.getCbic08());
                        //查出
                        Double qty = gsGoodsSkus.get(0).getQty();
                        gsGoodsSkuDo1.setQty(qty + 1.0);
                        taskService.updateGsGoodsSku(gsGoodsSkuDo1);

                    }

                    CbicCriteria cbicCriteria = new CbicCriteria();
                    cbicCriteria.createCriteria().andCbic10EqualTo(cbicDto.getCbic10());
                    List<Cbic> cbics = cbicMapper.selectByExample(cbicCriteria);

                    // Integer cbic13 = cbicDto.getCbic13();
                    //  Cbsa cbsa1 = cbsaMapper.selectByPrimaryKey(cbic13);

                    CbibDo cbibDo = BeanCopyUtils.coypToClass(cbic, CbibDo.class, null);
                    cbibDo.setCbib02(storeid);
                    cbibDo.setCbib04(date);
                    cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
                    // cbibDo.setCbib06(cbsa1.getCbsa08());
                    Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbicDto.getCbic13());
                    // cbibDo.setCbib06(cbsa.getCbsa08());

                    cbibDo.setCbib07(cbics.get(0).getCbic01());
                    cbibDo.setCbib08(cbpbs.get(0).getCbpb01());

                    cbibDo.setCbib17(TaskType.zjrk.getMsg());
                    cbibDo.setCbib19(cbicDto.getCbic13());

                    taskService.InsertCBIB(cbibDo);
                }
                else{
                    //添加
                    Cbic cbic = BeanCopyUtils.coypToClass(cbicDto, Cbic.class, null);
                    cbic.setCbic02(date);
                    cbic.setCbic03(date);
                    cbic.setCbic04(Math.toIntExact(userid));
                    cbic.setCbic05(Math.toIntExact(userid));
                    cbic.setCbic06(DeleteFlagEnum.NOT_DELETE.getCode());
                    cbic.setCbic09(cbpbs.get(0).getCbpb01());
                    cbic.setCbic12(date);
                    cbic.setCbic15(directWarehousingVo.getOrderType());
                    cbic.setUserId(Math.toIntExact(userid));
                    cbicMapper.insertSelective(cbic);

                    GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
                    //获取仓库id
                    gsGoodsSkuDo.setWhId(cbicDto.getCbic07());
                    //获取商品id
                    gsGoodsSkuDo.setGoodsId(cbpbs.get(0).getCbpb01());
                    //获取库位id
                    gsGoodsSkuDo.setLocationId(cbicDto.getCbic08());
                    gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                    //通过仓库id和货物id判断是否存在
                    List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
                    if (gsGoodsSkus.size() == 0) {
                        GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                        gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                        gsGoodsSkuDo1.setWhId(cbicDto.getCbic07());
                        gsGoodsSkuDo1.setLocationId(cbicDto.getCbic08());
                        gsGoodsSkuDo1.setQty(1.0);
                        taskService.addGsGoodsSku(gsGoodsSkuDo1);
                    }
                    //如果存在则更新库存数量
                    else {
                        //加锁
                        baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                        GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                        gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                        gsGoodsSkuDo1.setWhId(cbicDto.getCbic07());
                        gsGoodsSkuDo1.setLocationId(cbicDto.getCbic08());
                        //查出
                        Double qty = gsGoodsSkus.get(0).getQty();
                        gsGoodsSkuDo1.setQty(qty + 1.0);
                        taskService.updateGsGoodsSku(gsGoodsSkuDo1);

                    }

                    CbicCriteria cbicCriteria = new CbicCriteria();
                    cbicCriteria.createCriteria().andCbic10EqualTo(cbicDto.getCbic10());
                    List<Cbic> cbics = cbicMapper.selectByExample(cbicCriteria);

                    // Integer cbic13 = cbicDto.getCbic13();
                    //  Cbsa cbsa1 = cbsaMapper.selectByPrimaryKey(cbic13);

                    CbibDo cbibDo = BeanCopyUtils.coypToClass(cbic, CbibDo.class, null);
                    cbibDo.setCbib02(storeid);
                    cbibDo.setCbib04(date);
                    cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
                    // cbibDo.setCbib06(cbsa1.getCbsa08());
                    Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbicDto.getCbic13());
                    // cbibDo.setCbib06(cbsa.getCbsa08());

                    cbibDo.setCbib07(cbics.get(0).getCbic01());
                    cbibDo.setCbib08(cbpbs.get(0).getCbpb01());

                    cbibDo.setCbib17(TaskType.zjrk.getMsg());
                    cbibDo.setCbib19(cbicDto.getCbic13());

                    taskService.InsertCBIB(cbibDo);
                }*/

                if(cbicss.size()>0){
                    throw new SwException("sn重复");

                }
    //添加
                Cbic cbic =new Cbic();
                cbic.setCbic02(date);
                cbic.setCbic03(date);
                cbic.setCbic04(Math.toIntExact(userid));
                cbic.setCbic05(Math.toIntExact(userid));
                cbic.setCbic06(DeleteFlagEnum.NOT_DELETE.getCode());
                cbic.setCbic09(cbpbs.get(0).getCbpb01());
                cbic.setCbic12(date);
                cbic.setCbic15(directWarehousingVo.getOrderType());
                cbic.setCbic10(cbicDto.get(i).getSn());
                cbic.setCbic09(cbpbs.get(0).getCbpb01());
                cbic.setCbic07(cbla.get(0).getCbla10());
                cbic.setUserId(Math.toIntExact(userid));
                cbicMapper.insertSelective(cbic);

                GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
                //获取仓库id
                gsGoodsSkuDo.setWhId(cbla.get(0).getCbla10());
                //获取商品id
                gsGoodsSkuDo.setGoodsId(cbpbs.get(0).getCbpb01());
                //获取库位id
                gsGoodsSkuDo.setLocationId(cbla.get(0).getCbla01());
                gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                //通过仓库id和货物id判断是否存在
                List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
                if (gsGoodsSkus.size() == 0) {
                    GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                    gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                    gsGoodsSkuDo1.setWhId(cbla.get(0).getCbla10());
                    gsGoodsSkuDo1.setLocationId(cbla.get(0).getCbla01());
                    gsGoodsSkuDo1.setQty(1.0);
                    taskService.addGsGoodsSku(gsGoodsSkuDo1);
                }
                //如果存在则更新库存数量
                else {
                    //加锁
                    baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                    GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                    gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                    gsGoodsSkuDo1.setWhId(cbla.get(0).getCbla10());
                    gsGoodsSkuDo1.setLocationId(cbla.get(0).getCbla01());
                    //查出
                    Double qty = gsGoodsSkus.get(0).getQty();
                    gsGoodsSkuDo1.setQty(qty + 1.0);
                    taskService.updateGsGoodsSku(gsGoodsSkuDo1);

                }

                CbicCriteria cbicCriteria = new CbicCriteria();
                cbicCriteria.createCriteria().andCbic10EqualTo(cbicDto.get(i).getSn());
                List<Cbic> cbics = cbicMapper.selectByExample(cbicCriteria);

                // Integer cbic13 = cbicDto.getCbic13();
                //  Cbsa cbsa1 = cbsaMapper.selectByPrimaryKey(cbic13);

                CbibDo cbibDo = BeanCopyUtils.coypToClass(cbic, CbibDo.class, null);
                cbibDo.setCbib02(storeid);
                cbibDo.setCbib04(date);
                cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
                // cbibDo.setCbib06(cbsa1.getCbsa08());
               // Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbicDto.getCbic13());
                // cbibDo.setCbib06(cbsa.getCbsa08());

               // cbibDo.setCbib07(cbics.get(0).getCbic01());
                cbibDo.setCbib08(cbpbs.get(0).getCbpb01());

                cbibDo.setCbib17(TaskType.zjrk.getMsg());
                //cbibDo.setCbib19(cbicDto.getCbic13());

                taskService.InsertCBIB(cbibDo);
                GsGoodsSnCriteria exampler = new GsGoodsSnCriteria();
                exampler.createCriteria().andSnEqualTo(cbicDto.get(i).getSn());
                List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(exampler);

                if (gsGoodsSns.size() > 0 ) {
                    if(gsGoodsSns.get(0).getStatus()==1){
                        throw new SwException("该商品sn已入库");
                    }

                    /*GsGoodsSn  gsGoodsSn=new GsGoodsSn();
                    gsGoodsSn.setRepairStatus(0);
                    gsGoodsSn.setStatus(TaskStatus.sh.getCode().byteValue());
                    gsGoodsSn.setUpdateTime(date);
                    gsGoodsSn.setInTime(date);
                    GsGoodsSnCriteria tyui = new GsGoodsSnCriteria();
                    tyui.createCriteria().andSnEqualTo(cbicDto.getCbic10());
                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, tyui);*/
                }
                else {
                    //加sn表
                    GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
                    gsGoodsSnDo.setSn(cbicDto.get(i).getSn());
                    gsGoodsSnDo.setGoodsId(cbpbs.get(0).getCbpb01());
                    gsGoodsSnDo.setWhId(cbla.get(0).getCbla10());
                    gsGoodsSnDo.setLocationId(cbla.get(0).getCbla01());
                    gsGoodsSnDo.setStatus(GoodsType.yrk.getCode());
                    gsGoodsSnDo.setInTime(date);
                    gsGoodsSnDo.setGroudStatus(Groudstatus.SJ.getCode());
                    taskService.addGsGoodsSns(gsGoodsSnDo);
                }


            }
            finally {


                String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                        "then " +
                        "return redis.call('del', KEYS[1]) " +
                        "else " +
                        "return 0 " +
                        "end";
              this.redisTemplate.execute(new DefaultRedisScript<>(script,Boolean.class), Arrays.asList("lock"), uuid);
            }
           // cbicMapper.insertSelective(cbicDto.get(i));


        }

        return 1;

    }



    @Transactional
    @Override
    public int insertSwJsSkuBarcodes(CbicDto cbicDto) {
        Date date = new Date();

        if(cbicDto.getUpc()==null){
            throw new SwException("upc没输入");
        }
        log.info("获取的upc为"+cbicDto.getUpc()+"长度为"+cbicDto.getUpc().length());

        CbpbCriteria exampe = new CbpbCriteria();
        exampe.createCriteria().andCbpb15EqualTo(cbicDto.getUpc());
        List<Cbpb> cbpbs = cbbpbMapper.selectByExample(exampe);
        if(cbpbs.size()==0){
            throw new SwException("该upc没有对应商品");
        }

        String cbic10 = cbicDto.getCbic10();
        String uuid = UUID.randomUUID().toString();
        Boolean lock = redisTemplate.opsForValue().setIfAbsent(cbic10, uuid, 3, TimeUnit.SECONDS);
        if (!lock) {
            throw new SwException("sn重复，请勿重复提交");
        }
        String s = redisTemplate.opsForValue().get(cbic10);


        try {

          /*  CbicCriteria example1 = new CbicCriteria();
            example1.createCriteria().andCbic10EqualTo(cbicDto.getCbic10());
            List<Cbic> cbicss = cbicMapper.selectByExample(example1);
            if (cbicss.size() > 0) {
                throw new SwException("该sn已经存在");
            }else{

            }


            GsGoodsSnCriteria example = new GsGoodsSnCriteria();
            example.createCriteria().andSnEqualTo(cbicDto.getCbic10());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
            if (gsGoodsSns.size() > 0) {
                throw new SwException("该sn已经存在仓库中");
            }*/

            // 检查供应商
            // baseCheckService.checksupplier(cbicDto.getCbic13());

            //检查商品
            // Cbpb cbpb = baseCheckService.checkGoods(cbicDto.getCbic09());

            Long userid = SecurityUtils.getUserId();

            //获取仓库id
            Cbla cbla = cblaMapper.selectByPrimaryKey(cbicDto.getCbic08());
            if (cbla == null) {
                throw new SwException("找不到该仓库");

            }
            Integer storeid = cbla.getCbla10();
            //回写生产总订单id
            DirectWarehousingDto directWarehousingDto = new DirectWarehousingDto();
            directWarehousingDto.setStoreId(storeid);
            directWarehousingDto.setUserId(Math.toIntExact(userid));
            directWarehousingDto.setGoodsId(cbpbs.get(0).getCbpb01());
            // directWarehousingDto.setOrderType(cbicDto.getCbic15());
            DirectWarehousingVo directWarehousingVo = orderDistributionService.directWarehousing(directWarehousingDto);

            CbicCriteria example1 = new CbicCriteria();
            example1.createCriteria().andCbic10EqualTo(cbicDto.getCbic10());
            List<Cbic> cbicss = cbicMapper.selectByExample(example1);
      /*      if (cbicss.size() > 0) {


                Cbic cbic=new Cbic();
                cbic.setCbic02(date);
                CbicCriteria example2 = new CbicCriteria();
                example2.createCriteria().andCbic10EqualTo(cbicDto.getCbic10());
                cbicMapper.updateByExampleSelective(cbic,example2);

                GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
                //获取仓库id
                gsGoodsSkuDo.setWhId(cbicDto.getCbic07());
                //获取商品id
                gsGoodsSkuDo.setGoodsId(cbpbs.get(0).getCbpb01());
                //获取库位id
                gsGoodsSkuDo.setLocationId(cbicDto.getCbic08());
                gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                //通过仓库id和货物id判断是否存在
                List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
                if (gsGoodsSkus.size() == 0) {
                    GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                    gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                    gsGoodsSkuDo1.setWhId(cbicDto.getCbic07());
                    gsGoodsSkuDo1.setLocationId(cbicDto.getCbic08());
                    gsGoodsSkuDo1.setQty(1.0);
                    taskService.addGsGoodsSku(gsGoodsSkuDo1);
                }
                //如果存在则更新库存数量
                else {
                    //加锁
                    baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                    GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                    gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                    gsGoodsSkuDo1.setWhId(cbicDto.getCbic07());
                    gsGoodsSkuDo1.setLocationId(cbicDto.getCbic08());
                    //查出
                    Double qty = gsGoodsSkus.get(0).getQty();
                    gsGoodsSkuDo1.setQty(qty + 1.0);
                    taskService.updateGsGoodsSku(gsGoodsSkuDo1);

                }

                CbicCriteria cbicCriteria = new CbicCriteria();
                cbicCriteria.createCriteria().andCbic10EqualTo(cbicDto.getCbic10());
                List<Cbic> cbics = cbicMapper.selectByExample(cbicCriteria);

                // Integer cbic13 = cbicDto.getCbic13();
                //  Cbsa cbsa1 = cbsaMapper.selectByPrimaryKey(cbic13);

                CbibDo cbibDo = BeanCopyUtils.coypToClass(cbic, CbibDo.class, null);
                cbibDo.setCbib02(storeid);
                cbibDo.setCbib04(date);
                cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
                // cbibDo.setCbib06(cbsa1.getCbsa08());
                Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbicDto.getCbic13());
                // cbibDo.setCbib06(cbsa.getCbsa08());

                cbibDo.setCbib07(cbics.get(0).getCbic01());
                cbibDo.setCbib08(cbpbs.get(0).getCbpb01());

                cbibDo.setCbib17(TaskType.zjrk.getMsg());
                cbibDo.setCbib19(cbicDto.getCbic13());

                taskService.InsertCBIB(cbibDo);
            }
            else{
                //添加
                Cbic cbic = BeanCopyUtils.coypToClass(cbicDto, Cbic.class, null);
                cbic.setCbic02(date);
                cbic.setCbic03(date);
                cbic.setCbic04(Math.toIntExact(userid));
                cbic.setCbic05(Math.toIntExact(userid));
                cbic.setCbic06(DeleteFlagEnum.NOT_DELETE.getCode());
                cbic.setCbic09(cbpbs.get(0).getCbpb01());
                cbic.setCbic12(date);
                cbic.setCbic15(directWarehousingVo.getOrderType());
                cbic.setUserId(Math.toIntExact(userid));
                cbicMapper.insertSelective(cbic);

                GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
                //获取仓库id
                gsGoodsSkuDo.setWhId(cbicDto.getCbic07());
                //获取商品id
                gsGoodsSkuDo.setGoodsId(cbpbs.get(0).getCbpb01());
                //获取库位id
                gsGoodsSkuDo.setLocationId(cbicDto.getCbic08());
                gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                //通过仓库id和货物id判断是否存在
                List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
                if (gsGoodsSkus.size() == 0) {
                    GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                    gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                    gsGoodsSkuDo1.setWhId(cbicDto.getCbic07());
                    gsGoodsSkuDo1.setLocationId(cbicDto.getCbic08());
                    gsGoodsSkuDo1.setQty(1.0);
                    taskService.addGsGoodsSku(gsGoodsSkuDo1);
                }
                //如果存在则更新库存数量
                else {
                    //加锁
                    baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                    GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                    gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                    gsGoodsSkuDo1.setWhId(cbicDto.getCbic07());
                    gsGoodsSkuDo1.setLocationId(cbicDto.getCbic08());
                    //查出
                    Double qty = gsGoodsSkus.get(0).getQty();
                    gsGoodsSkuDo1.setQty(qty + 1.0);
                    taskService.updateGsGoodsSku(gsGoodsSkuDo1);

                }

                CbicCriteria cbicCriteria = new CbicCriteria();
                cbicCriteria.createCriteria().andCbic10EqualTo(cbicDto.getCbic10());
                List<Cbic> cbics = cbicMapper.selectByExample(cbicCriteria);

                // Integer cbic13 = cbicDto.getCbic13();
                //  Cbsa cbsa1 = cbsaMapper.selectByPrimaryKey(cbic13);

                CbibDo cbibDo = BeanCopyUtils.coypToClass(cbic, CbibDo.class, null);
                cbibDo.setCbib02(storeid);
                cbibDo.setCbib04(date);
                cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
                // cbibDo.setCbib06(cbsa1.getCbsa08());
                Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbicDto.getCbic13());
                // cbibDo.setCbib06(cbsa.getCbsa08());

                cbibDo.setCbib07(cbics.get(0).getCbic01());
                cbibDo.setCbib08(cbpbs.get(0).getCbpb01());

                cbibDo.setCbib17(TaskType.zjrk.getMsg());
                cbibDo.setCbib19(cbicDto.getCbic13());

                taskService.InsertCBIB(cbibDo);
            }*/

            if(cbicss.size()>0){
                throw new SwException("sn重复");

            }
//添加
            Cbic cbic = BeanCopyUtils.coypToClass(cbicDto, Cbic.class, null);
            cbic.setCbic02(date);
            cbic.setCbic03(date);
            cbic.setCbic04(Math.toIntExact(userid));
            cbic.setCbic05(Math.toIntExact(userid));
            cbic.setCbic06(DeleteFlagEnum.NOT_DELETE.getCode());
            cbic.setCbic09(cbpbs.get(0).getCbpb01());
            cbic.setCbic12(date);
            cbic.setCbic15(directWarehousingVo.getOrderType());
            cbic.setUserId(Math.toIntExact(userid));
            cbicMapper.insertSelective(cbic);

            GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
            //获取仓库id
            gsGoodsSkuDo.setWhId(cbicDto.getCbic07());
            //获取商品id
            gsGoodsSkuDo.setGoodsId(cbpbs.get(0).getCbpb01());
            //获取库位id
            gsGoodsSkuDo.setLocationId(cbicDto.getCbic08());
            gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //通过仓库id和货物id判断是否存在
            List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
            if (gsGoodsSkus.size() == 0) {
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                gsGoodsSkuDo1.setWhId(cbicDto.getCbic07());
                gsGoodsSkuDo1.setLocationId(cbicDto.getCbic08());
                gsGoodsSkuDo1.setQty(1.0);
                taskService.addGsGoodsSku(gsGoodsSkuDo1);
            }
            //如果存在则更新库存数量
            else {
                //加锁
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                gsGoodsSkuDo1.setWhId(cbicDto.getCbic07());
                gsGoodsSkuDo1.setLocationId(cbicDto.getCbic08());
                //查出
                Double qty = gsGoodsSkus.get(0).getQty();
                gsGoodsSkuDo1.setQty(qty + 1.0);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);

            }

            CbicCriteria cbicCriteria = new CbicCriteria();
            cbicCriteria.createCriteria().andCbic10EqualTo(cbicDto.getCbic10());
            List<Cbic> cbics = cbicMapper.selectByExample(cbicCriteria);

            // Integer cbic13 = cbicDto.getCbic13();
            //  Cbsa cbsa1 = cbsaMapper.selectByPrimaryKey(cbic13);

            CbibDo cbibDo = BeanCopyUtils.coypToClass(cbic, CbibDo.class, null);
            cbibDo.setCbib02(storeid);
            cbibDo.setCbib04(date);
            cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
            // cbibDo.setCbib06(cbsa1.getCbsa08());
            Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbicDto.getCbic13());
            // cbibDo.setCbib06(cbsa.getCbsa08());

            cbibDo.setCbib07(cbics.get(0).getCbic01());
            cbibDo.setCbib08(cbpbs.get(0).getCbpb01());

            cbibDo.setCbib17(TaskType.zjrk.getMsg());
            cbibDo.setCbib19(cbicDto.getCbic13());

            taskService.InsertCBIB(cbibDo);
            GsGoodsSnCriteria example = new GsGoodsSnCriteria();
            example.createCriteria().andSnEqualTo(cbicDto.getCbic10());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);

            if (gsGoodsSns.size() > 0 ) {
                if(gsGoodsSns.get(0).getStatus()==1){
                    throw new SwException("该商品sn已入库");
                }

                /*GsGoodsSn  gsGoodsSn=new GsGoodsSn();
                gsGoodsSn.setRepairStatus(0);
                gsGoodsSn.setStatus(TaskStatus.sh.getCode().byteValue());
                gsGoodsSn.setUpdateTime(date);
                gsGoodsSn.setInTime(date);
                GsGoodsSnCriteria tyui = new GsGoodsSnCriteria();
                tyui.createCriteria().andSnEqualTo(cbicDto.getCbic10());
                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, tyui);*/
            }
            else {
                //加sn表
                GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
                gsGoodsSnDo.setSn(cbicDto.getCbic10());
                gsGoodsSnDo.setGoodsId(cbpbs.get(0).getCbpb01());
                gsGoodsSnDo.setWhId(cbicDto.getCbic07());
                gsGoodsSnDo.setLocationId(cbicDto.getCbic08());
                gsGoodsSnDo.setStatus(GoodsType.yrk.getCode());
                gsGoodsSnDo.setInTime(date);
                gsGoodsSnDo.setGroudStatus(Groudstatus.SJ.getCode());
                taskService.addGsGoodsSns(gsGoodsSnDo);
            }


        }
        finally {


            String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                    "then " +
                    "return redis.call('del', KEYS[1]) " +
                    "else " +
                    "return 0 " +
                    "end";
            this.redisTemplate.execute(new DefaultRedisScript<>(script,Boolean.class), Arrays.asList("lock"), uuid);
        }
        return 1;

    }



    @Transactional
    @Override
    public int deleteSwJsSkuBarcodsById(CbicDto cbicDto) {
        Long userid = SecurityUtils.getUserId();

        Cbic cbic = BeanCopyUtils.coypToClass(cbicDto, Cbic.class, null);
        Date date = new Date();
        cbic.setCbic05(Math.toIntExact(userid));
        cbic.setCbic06(DeleteFlagEnum.DELETE.getCode());
        CbicCriteria example = new CbicCriteria();
        example.createCriteria().andCbic01EqualTo(cbicDto.getCbic01())
                .andCbic06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbicMapper.updateByExampleSelective(cbic,example);
    }

    @Override
    public List<CbicVo> selectSwJsTaskGoodsRelListss(CbicVo cbicVo) {
        return cbicMapper.selectSwJsTaskGoodsRelListss(cbicVo);
    }

    @Override
    public List<CbicVo> selectSwJsTaskGoodsRelLists(CbicVo cbicVo) {
        return cbicMapper.selectSwJsTaskGoodsRelLists(cbicVo);
    }

    @Override
    public List<GsOrdersInVo> swJsOrderInlist(GsOrdersInDto gsOrdersInDto) {
        return gsOrdersInMapper.swJsOrderInlist(gsOrdersInDto);
    }


}
