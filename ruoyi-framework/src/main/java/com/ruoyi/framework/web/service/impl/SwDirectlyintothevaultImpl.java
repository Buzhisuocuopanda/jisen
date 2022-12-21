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
import com.ruoyi.system.domain.vo.*;
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
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
private CbscMapper cbscMapper;
    @Resource
    private TaskService taskService;

    @Resource
    private CbsaMapper cbsaMapper;
    @Resource
    private CblaMapper cblaMapper;
@Resource
private CbwaMapper cbwaMapper;

@Resource
private CbaaMapper cbaaMapper;
    @Resource
    private CbpbMapper cbbpbMapper;

    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;
    @Resource
    private GsOrdersInMapper gsOrdersInMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Resource
    private CbpbMapper cbpbMapper;

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;

    @Resource
    private CbsgMapper cbsgMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
@Resource
private CbiwMapper cbiwMapper;

@Resource
private CbpeMapper cbpeMapper;

@Resource
private CbpiMapper cbpiMapper;

@Resource
private CbsdMapper cbsdMapper;

@Resource
private CbsjMapper cbsjMapper;

@Resource
private CbacMapper cbacMapper;

@Resource
private CbpmMapper cbpmMapper;



    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSwJsSkuBarcodess(List<CbicDto> cbicDto) throws InterruptedException {
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
     if(cbicDto.size()==0){
         throw  new SwException("请扫码");
      }
        if(cbicDto.get(0).getUpc()==null){
            throw new SwException("upc没输入");
        }

        Map<String, Long> map  = cbicDto.stream().collect(Collectors.groupingBy(CbicDto::getUpc, Collectors.counting()));
        for(Map.Entry<String, Long> entry : map.entrySet()){
            System.out.println("key ："+entry.getKey()+", value ："+entry.getValue());
            CbibDo cbibDo = new CbibDo();
            CbpbCriteria cbpbCriteria = new CbpbCriteria();
            cbpbCriteria.createCriteria().andCbpb15EqualTo(entry.getKey());
            List<Cbpb> cbpbs = cbbpbMapper.selectByExample(cbpbCriteria);
            if(cbpbs.size()==0){
                throw new SwException("upc没找到");
            }
            cbibDo.setCbib02(5);
            cbibDo.setCbib04(date);
            cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
            cbibDo.setCbib08(cbpbs.get(0).getCbpb01());
            cbibDo.setCbib11(Double.valueOf(entry.getValue()));
            cbibDo.setCbib17(TaskType.zjrk.getMsg());

            taskService.InsertCBIB(cbibDo);
        }
        //






        ///


        for (CbicDto dto : cbicDto) {


            CbpbCriteria exampe = new CbpbCriteria();
            exampe.createCriteria().andCbpb15EqualTo(dto.getUpc());
            List<Cbpb> cbpbs = cbbpbMapper.selectByExample(exampe);
            if (cbpbs.size() == 0) {
                throw new SwException("该upc没有对应商品");
            }

            //删除临时表
            String cbic10 = dto.getSn();


            String uuid = UUID.randomUUID().toString();
            Boolean lock = redisTemplate.opsForValue().setIfAbsent(cbic10, uuid, 3, TimeUnit.SECONDS);
            if (Boolean.FALSE.equals(lock)) {
                throw new SwException("sn重复，请勿重复提交");
            }
            redisTemplate.opsForValue().get(cbic10);


            try {


                // Long userid = SecurityUtils.getUserId();

                //获取仓库id
                CblaCriteria example = new CblaCriteria();
                example.createCriteria().andCbla09EqualTo(dto.getStoresku());
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
                example1.createCriteria().andCbic10EqualTo(dto.getSn());
                List<Cbic> cbicss = cbicMapper.selectByExample(example1);


                if (cbicss.size() > 0) {
                    CbicCriteria asf = new CbicCriteria();
                    asf.createCriteria().andCbic10EqualTo(dto.getSn());
                    dto.setCbic02(date);
                    dto.setCbic03(date);
                    dto.setCbic04(Math.toIntExact(userid));
                    dto.setCbic05(Math.toIntExact(userid));
                    dto.setCbic07(cbla.get(0).getCbla10());
                    dto.setCbic09(cbpbs.get(0).getCbpb01());
                    dto.setCbic08(cbla.get(0).getCbla01());
                    dto.setCbic06(DeleteFlagEnum.NOT_DELETE.getCode());

                    cbicMapper.updateByExampleSelective(dto, asf);

                }
                //添加
                else {
                    // Cbic cbic =new Cbic();
                    dto.setCbic02(date);
                    dto.setCbic03(date);
                    dto.setCbic04(Math.toIntExact(userid));
                    dto.setCbic05(Math.toIntExact(userid));
                    dto.setCbic06(DeleteFlagEnum.NOT_DELETE.getCode());
                    dto.setCbic09(cbpbs.get(0).getCbpb01());
                    dto.setCbic12(date);
                    dto.setCbic15(directWarehousingVo.getOrderType());
                    dto.setCbic10(dto.getSn());
                    dto.setCbic09(cbpbs.get(0).getCbpb01());
                    dto.setCbic07(cbla.get(0).getCbla10());
                    dto.setCbic08(cbla.get(0).getCbla01());
                    dto.setUserId(Math.toIntExact(userid));
                    cbicMapper.insertSelective(dto);
                }
                //  cbicMapper.insertSelective(cbic);
                GsGoodsSnCriteria exampler = new GsGoodsSnCriteria();
                exampler.createCriteria().andSnEqualTo(dto.getSn());
                List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(exampler);

                if (gsGoodsSns.size() > 0) {
                    //在库存且是维修状态是正常
                    if (gsGoodsSns.get(0).getStatus() == 1 && gsGoodsSns.get(0).getRepairStatus()==0) {
                        throw new SwException("该商品sn已入库,维修状态为正常"+gsGoodsSns.get(0).getSn());
                    }
                    if (gsGoodsSns.get(0).getStatus() == 2) {
                        throw new SwException("该商品sn处于出库中,不能入库");
                    }
                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
                    gsGoodsSn.setRepairStatus(0);
                    gsGoodsSn.setStatus(TaskStatus.sh.getCode().byteValue());
                    gsGoodsSn.setUpdateTime(date);
                    gsGoodsSn.setInTime(date);
                    gsGoodsSn.setWhId(cbla.get(0).getCbla10());
                    gsGoodsSn.setGoodsId(cbpbs.get(0).getCbpb01());
                    gsGoodsSn.setLocationId(cbla.get(0).getCbla01());
                    gsGoodsSn.setStatus(GoodsType.yrk.getCode());
                    gsGoodsSn.setGroudStatus(Groudstatus.SJ.getCode());
                    gsGoodsSn.setRepairStatus(0);
                    GsGoodsSnCriteria tyui = new GsGoodsSnCriteria();
                    tyui.createCriteria().andSnEqualTo(dto.getSn());
                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, tyui);
                    //台账

                } else {
                    //加sn表
                    GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
                    gsGoodsSnDo.setSn(dto.getSn());
                    gsGoodsSnDo.setGoodsId(cbpbs.get(0).getCbpb01());
                    gsGoodsSnDo.setWhId(cbla.get(0).getCbla10());
                    gsGoodsSnDo.setLocationId(cbla.get(0).getCbla01());
                    gsGoodsSnDo.setStatus(GoodsType.yrk.getCode());
                    gsGoodsSnDo.setInTime(date);
                    gsGoodsSnDo.setGroudStatus(Groudstatus.SJ.getCode());
                    taskService.addGsGoodsSns(gsGoodsSnDo);


                }


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

                    GsGoodsSkuCriteria example21 = new GsGoodsSkuCriteria();
                    example21.createCriteria()
                            .andLocationIdEqualTo(cbla.get(0).getCbla01());
                    List<GsGoodsSku> gsGoodsSkus1 = gsGoodsSkuMapper.selectByExample(example21);
                    //校验库位逻辑
                    if (gsGoodsSkus1.size() > 0) {
                        double sum = gsGoodsSkus1.stream().mapToDouble(GsGoodsSku::getQty).sum();
                        if (sum + 1 > cbla.get(0).getCbla11()) {
                              throw new SwException("库位容量不足，库位码为"+cbla.get(0).getCbla09());
                        }
                    }

                    GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                    gsGoodsSkuDo1.setGoodsId(cbpbs.get(0).getCbpb01());
                    gsGoodsSkuDo1.setWhId(cbla.get(0).getCbla10());
                    gsGoodsSkuDo1.setLocationId(cbla.get(0).getCbla01());
                    gsGoodsSkuDo1.setQty(1.0);
                    taskService.addGsGoodsSku(gsGoodsSkuDo1);
                }
                //如果存在则更新库存数量
                else {

                    GsGoodsSkuCriteria example21 = new GsGoodsSkuCriteria();
                    example21.createCriteria()
                            .andLocationIdEqualTo(cbla.get(0).getCbla01());
                    List<GsGoodsSku> gsGoodsSkus1 = gsGoodsSkuMapper.selectByExample(example21);

                    //校验库位逻辑
                    if (gsGoodsSkus1.size() > 0) {
                        double sum = gsGoodsSkus1.stream().mapToDouble(GsGoodsSku::getQty).sum();
                        if (sum + 1 > cbla.get(0).getCbla11()) {
                              throw new SwException("库位容量不足，库位码为"+cbla.get(0).getCbla09());
                        }
                    }

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
                cbicCriteria.createCriteria().andCbic10EqualTo(dto.getSn());
                cbicMapper.selectByExample(cbicCriteria);


            } finally {

                String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                        "then " +
                        "return redis.call('del', KEYS[1]) " +
                        "else " +
                        "return 0 " +
                        "end";
                this.redisTemplate.execute(new DefaultRedisScript<>(script, Boolean.class), Collections.singletonList("lock"), uuid);
            }
            //  mapper.insertSelective(cbicDto.get(i));

        }
    /*    session.commit();
        session.clearCache();*/
        return 1;

    }

    @Override
    public void addless(Cbiw cbiw) {
        Long userid = SecurityUtils.getUserId();

        Date date = new Date();
        if(cbiw.getSn()==null){
            throw new SwException("upc不能为空");
        }
        CbpbCriteria cbpbCriterias = new CbpbCriteria();
        cbpbCriterias.createCriteria().andCbpb12EqualTo(cbiw.getSn());
        List<Cbpb> cbpbss = cbpbMapper.selectByExample(cbpbCriterias);
        if(cbpbss.size()>0){
            throw new SwException("sn不正确");
        }




        if(cbiw.getUpc()==null){
            throw new SwException("upc不能为空");
        }
        if(Objects.equals(cbiw.getSn(), cbiw.getUpc())){
            throw new SwException("sn不正确");
        }
        //判断sn是否存在
        CbiwCriteria cbiwCriteria = new CbiwCriteria();
        cbiwCriteria.createCriteria().andSnEqualTo(cbiw.getSn());
        List<Cbiw> cbicDtos = cbiwMapper.selectByExample(cbiwCriteria);
        if(cbicDtos.size()>0){
            throw new SwException("sn重复"+cbiw.getSn());
        }

        GsGoodsSnCriteria exampler = new GsGoodsSnCriteria();
        exampler.createCriteria().andSnEqualTo(cbiw.getSn())
                        .andStatusEqualTo(GoodsType.yrk.getCode());
        List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(exampler);
        if(gsGoodsSns.size()>0){
            throw new SwException("sn已入库"+cbiw.getSn());
        }
//库位容量控制
        CbiwCriteria dfg= new CbiwCriteria();
        dfg.createCriteria().andStoreskuEqualTo(cbiw.getStoresku());
        cbiwMapper.selectByExample(dfg);

        CblaCriteria cblaCriteria = new CblaCriteria();
        cblaCriteria.createCriteria().andCbla09EqualTo(cbiw.getStoresku());
        List<Cbla> cblas = cblaMapper.selectByExample(cblaCriteria);
        if(cblas.size()>0){
            if(cblas.get(0).getCbla10()!=null){
            if(cblas.get(0).getCbla10()!=5){
               throw new SwException("库位不属于GQW仓库");
                }
            }
            //库位容量


        }

        else {
            throw new SwException("库位不存在");
        }



        cbiw.setCreatetime(date);
        cbiw.setSn(cbiw.getSn());
        cbiw.setUpc(cbiw.getUpc());
        cbiw.setUser(Math.toIntExact(userid));
        CbpbCriteria cbpbCriteria = new CbpbCriteria();
        cbpbCriteria.createCriteria().andCbpb15EqualTo(cbiw.getUpc());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(cbpbCriteria);
        if(cbpbs.size()>0){
            cbiw.setGoodssku(cbpbs.get(0).getCbpb12());
        }
        else {
            throw new SwException("upc不存在");
        }

        if(Objects.equals(cbiw.getGoodssku(), cbiw.getSn())){
            throw new SwException("sn不正确");
        }

        cbiw.setGoodssku(cbiw.getGoodssku());
        cbiwMapper.insertSelective(cbiw);

    }

    @Override
    public List<CbiwVo> swJsGoodslistBySelect(CbiwVo cbiwVo) {
        Long userid = SecurityUtils.getUserId();
        cbiwVo.setUser(Math.toIntExact(userid));
        return cbiwMapper.swJsGoodslistBySelect(cbiwVo);
    }

    @Override
    public void deleteless(Cbiw cbiw) {
        Long userid = SecurityUtils.getUserId();

        if(cbiw.getSn()==null){
            throw new SwException("sn不能为空");
        }
        CbiwCriteria cbiwCriteria = new CbiwCriteria();
        cbiwCriteria.createCriteria().andSnEqualTo(cbiw.getSn())
                .andUserEqualTo(userid.intValue());
        cbiwMapper.deleteByExample(cbiwCriteria);

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
        exampe.createCriteria().andCbpb15EqualTo(cbicDto.getUpc())
        .andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode().byteValue());
        List<Cbpb> cbpbs = cbbpbMapper.selectByExample(exampe);
        if(cbpbs.size()==0){
            throw new SwException("该upc没有对应商品");
        }

        String cbic10 = cbicDto.getCbic10();
        String uuid = UUID.randomUUID().toString();
        Boolean lock = redisTemplate.opsForValue().setIfAbsent(cbic10, uuid, 3, TimeUnit.SECONDS);
        if (Boolean.FALSE.equals(lock)) {
            throw new SwException("sn重复，请勿重复提交");
        }
        redisTemplate.opsForValue().get(cbic10);


        try {

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
        cbsaMapper.selectByPrimaryKey(cbicDto.getCbic13());
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


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {


            String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                    "then " +
                    "return redis.call('del', KEYS[1]) " +
                    "else " +
                    "return 0 " +
                    "end";
            this.redisTemplate.execute(new DefaultRedisScript<>(script,Boolean.class), Collections.singletonList("lock"), uuid);
        }
        return 1;

    }



    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteSwJsSkuBarcodsById(CbicDto cbicDto)  {
        Long userid = SecurityUtils.getUserId();

        Date date = new Date();
        if(cbicDto.getCbic01()==null){
            throw new SwException("直接入库id不能为空");
        }
        Cbic cbic1 = cbicMapper.selectByPrimaryKey(cbicDto.getCbic01());
        //sn操作
        GsGoodsSnCriteria example = new GsGoodsSnCriteria();
        example.createCriteria().andSnEqualTo(cbic1.getCbic10());
        List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
        if(gsGoodsSns.size()>0){
            if(gsGoodsSns.get(0)!=null){
                if(gsGoodsSns.get(0).getStatus()!=null){
                    if(gsGoodsSns.get(0).getStatus()!=1){
                        throw new SwException("该商品sn不是入库状态");
                    }
                    GsGoodsSnCriteria tyui = new GsGoodsSnCriteria();
                    tyui.createCriteria().andSnEqualTo(cbic1.getCbic10());
                    gsGoodsSnMapper.deleteByExample(tyui);
                }
            }
            GsGoodsSnCriteria tyui = new GsGoodsSnCriteria();
            tyui.createCriteria().andSnEqualTo(cbic1.getCbic10());
            gsGoodsSnMapper.deleteByExample(tyui);
        }


        //库存操作
        GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
        //获取仓库id
        gsGoodsSkuDo.setWhId(cbic1.getCbic07());
        //获取商品id
        gsGoodsSkuDo.setGoodsId(cbic1.getCbic09());
        //获取库位id
        gsGoodsSkuDo.setLocationId(cbic1.getCbic08());
        gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
        //通过仓库id和货物id判断是否存在
        List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
        if (gsGoodsSkus.size() == 0) {
          throw new SwException("库位该商品数量为0");
        }
        //如果存在则更新库存数量
        else {
            //加锁
            baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
            GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
            gsGoodsSkuDo1.setGoodsId(cbic1.getCbic09());
            gsGoodsSkuDo1.setWhId(cbic1.getCbic07());
            gsGoodsSkuDo1.setLocationId(cbic1.getCbic08());
            //查出
            Double qty = gsGoodsSkus.get(0).getQty();
            if(qty - 1.0 < 0){
                throw new SwException("库位该商品数量不足");
            }
            gsGoodsSkuDo1.setQty(qty - 1.0);
            taskService.updateGsGoodsSku(gsGoodsSkuDo1);

        }

        DirectWarehousingDto directWarehousingDto = new DirectWarehousingDto();
        directWarehousingDto.setGoodsId(cbic1.getCbic09());
        directWarehousingDto.setStoreId(cbic1.getCbic07());
        directWarehousingDto.setUserId(Math.toIntExact(userid));

        orderDistributionService.deldirectWarehousing(directWarehousingDto);

        CbibDo cbibDo = new CbibDo();
        cbibDo.setCbib02(cbic1.getCbic07());
        cbibDo.setCbib04(date);
        cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
        cbibDo.setCbib08(cbic1.getCbic09());
        cbibDo.setCbib11(1.0);
        cbibDo.setCbib17(TaskType.zjrkde.getMsg());

        try {
            taskService.InsertCBIB(cbibDo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


       // Long userid = SecurityUtils.getUserId();

        Cbic cbic = BeanCopyUtils.coypToClass(cbicDto, Cbic.class, null);
        cbic.setCbic05(Math.toIntExact(userid));
        cbic.setCbic06(DeleteFlagEnum.DELETE.getCode());
        CbicCriteria example1 = new CbicCriteria();
        example1.createCriteria().andCbic01EqualTo(cbicDto.getCbic01())
                .andCbic06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
         cbicMapper.updateByExampleSelective(cbic,example1);



        return 1;
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

    @Override
    public void deletelesss(deleteVo cbiw) {
if(cbiw.getSn()==null){
    throw new SwException("sn不能为空");
}
if(cbiw.getType()==null){
    throw new SwException("类型不能为空");
}
if(cbiw.getTypes()==null){
    throw new SwException("订单类型不能为空");
}
if(cbiw.getTypes()==1){
    CbpeCriteria example = new CbpeCriteria();
    example.createCriteria().andCbpe09EqualTo(cbiw.getSn())
            .andCbpc01EqualTo(cbiw.getId());
   cbpeMapper.deleteByExample(example);

   GsGoodsSnCriteria saf=new GsGoodsSnCriteria();
    saf.createCriteria().andSnEqualTo(cbiw.getSn());
    gsGoodsSnMapper.deleteByExample(saf);

}
if(cbiw.getTypes()==2){
            CbpiCriteria example = new CbpiCriteria();
            example.createCriteria().andCbpi09EqualTo(cbiw.getSn())
                    .andCbpg01EqualTo(cbiw.getId());
            cbpiMapper.deleteByExample(example);

    GsGoodsSn gsGoodsSn = new GsGoodsSn();
    gsGoodsSn.setStatus(cbiw.getType().byteValue());
    gsGoodsSn.setGroudStatus(Groudstatus.SJ.getCode());
    gsGoodsSn.setSn(cbiw.getSn());
    GsGoodsSnCriteria exampleq = new GsGoodsSnCriteria();
    exampleq.createCriteria().andSnEqualTo(cbiw.getSn());
    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampleq);
        }
//销售出库删除
        if(cbiw.getTypes()==3){
            CbsdCriteria example = new CbsdCriteria();
            example.createCriteria().andCbsd09EqualTo(cbiw.getSn())
                    .andCbsb01EqualTo(cbiw.getId());

            CbsdCriteria ere = new CbsdCriteria();
            ere.createCriteria().andCbsd09EqualTo(cbiw.getSn())
                    .andCbsb01EqualTo(cbiw.getId());
            List<Cbsd> cbsds = cbsdMapper.selectByExample(ere);
if(cbsds.size()>0) {
    CbscCriteria example1 = new CbscCriteria();
    example1.createCriteria().andCbsb01EqualTo(cbiw.getId())
            .andCbsc08EqualTo(cbsds.get(0).getCbsd08());
    List<Cbsc> cbscList = cbscMapper.selectByExample(example1);
    if (cbscList.size() > 0) {
        for (Cbsc cbsc : cbscList) {
            if (cbsc.getScannum() != null) {
                if (cbsc.getScannum() - 1.0 >= 0) {

                    cbsc.setScannum(cbsc.getScannum() - 1);
                    cbscMapper.updateByPrimaryKeySelective(cbsc);
                    break;
                }
                if (cbsc.getScannum() - 1.0 < 0) continue;
            } else {
                throw new SwException("扫描数量不能为空");

            }
        }
    }
}
            cbsdMapper.deleteByExample(example);

            GsGoodsSn gsGoodsSn = new GsGoodsSn();
            gsGoodsSn.setStatus(cbiw.getType().byteValue());
            gsGoodsSn.setSn(cbiw.getSn());
            GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
            exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
            gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
        }
        if(cbiw.getTypes()==4){
            CbsgCriteria example = new CbsgCriteria();
            example.createCriteria().andCbsg09EqualTo(cbiw.getSn())
                    .andCbse01EqualTo(cbiw.getId());
            cbsgMapper.deleteByExample(example);


            GsGoodsSn gsGoodsSn = new GsGoodsSn();
            gsGoodsSn.setStatus(cbiw.getType().byteValue());
            gsGoodsSn.setSn(cbiw.getSn());
            GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
            exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
            gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
        }
        //调拨单调出删除
        //真删
        if(cbiw.getTypes()==6){
            CbacCriteria example = new CbacCriteria();
            example.createCriteria().andCbac09EqualTo(cbiw.getSn())
                    .andCbaa01EqualTo(cbiw.getId());
            Cbac cbac =  Cbac.getInstance();
            cbac.setCbac07(DeleteFlagEnum.DELETE.getCode());
            cbacMapper.deleteByExample(example);

            GsGoodsSn gsGoodsSn = new GsGoodsSn();
            gsGoodsSn.setStatus(cbiw.getType().byteValue());
            gsGoodsSn.setSn(cbiw.getSn());
            GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
            exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
            gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);

        }
        //调拨单调入删除
        if(cbiw.getTypes()==5){
            Cbaa cbaa = cbaaMapper.selectByPrimaryKey(cbiw.getId());
            if(cbaa!=null){
                if(cbaa.getCbaa11()!=null){
                    if(cbaa.getCbaa11().equals(4)){
                        throw new SwException("调拨单已经标记完成，不能删除");
                    }
                }
                if(cbaa.getCbaa09()!=null){
                    Cbwa cbwa = cbwaMapper.selectByPrimaryKey(cbaa.getCbaa09());
                    if(Objects.equals(cbwa.getCbwa12(), "数量管理")){
                        CbacCriteria example = new CbacCriteria();
                        example.createCriteria().andCbac09EqualTo(cbiw.getSn())
                                .andCbaa01EqualTo(cbiw.getId());
                         cbacMapper.deleteByExample(example);
                    }else {
                        CbacCriteria example = new CbacCriteria();
                        example.createCriteria().andCbac09EqualTo(cbiw.getSn())
                                .andCbaa01EqualTo(cbiw.getId());
                        List<Cbac> cbacs = cbacMapper.selectByExample(example);
                        if(cbacs.size()>0){
                            if(cbacs.get(0).getCbac11()!=null){
                                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                                gsGoodsSn.setStatus(cbiw.getType().byteValue());
                                gsGoodsSn.setSn(cbiw.getSn());
                                gsGoodsSn.setLocationId(cbacs.get(0).getCbac11());
                                GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
                                exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
                                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
                            }

                        }
                        Cbac cbac = Cbac.getInstance();
                        cbac.setCbac14(1);
                        cbacMapper.updateByExampleSelective(cbac,example);
                    }

                }
            }

        /*    CbacCriteria example = new CbacCriteria();
            example.createCriteria().andCbac09EqualTo(cbiw.getSn())
                    .andCbaa01EqualTo(cbiw.getId());
            List<Cbac> cbacs = cbacMapper.selectByExample(example);
            if(cbacs.size()>0){
                if(cbacs.get(0).getCbac11()!=null){
                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
                    gsGoodsSn.setStatus(cbiw.getType().byteValue());
                    gsGoodsSn.setSn(cbiw.getSn());
                    gsGoodsSn.setLocationId(cbacs.get(0).getCbac11());
                    GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
                    exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
                }

            }
            Cbac cbac = new Cbac();
            cbac.setCbac14(1);
            cbacMapper.updateByExampleSelective(cbac,example);*/

            GsGoodsSn gsGoodsSn = new GsGoodsSn();
            gsGoodsSn.setStatus(cbiw.getType().byteValue());
            gsGoodsSn.setSn(cbiw.getSn());
            GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
            exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
            gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
        }
        if(cbiw.getTypes()==7){
            CbpmCriteria example = new CbpmCriteria();
            example.createCriteria().andCbpm09EqualTo(cbiw.getSn())
                    .andCbpk01EqualTo(cbiw.getId());
            Cbpm cbpm = new Cbpm();
            cbpm.setCbpm11(0);
            cbpmMapper.updateByExampleSelective(cbpm,example);

            GsGoodsSn gsGoodsSn = new GsGoodsSn();
            gsGoodsSn.setStatus(cbiw.getType().byteValue());
            gsGoodsSn.setSn(cbiw.getSn());
            GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
            exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
            gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
        }

        if(cbiw.getTypes()==8){
            CbsjCriteria example = new CbsjCriteria();
            example.createCriteria().andCbsj09EqualTo(cbiw.getSn())
                    .andCbsh01EqualTo(cbiw.getId());
            cbsjMapper.deleteByExample(example);


            GsGoodsSn gsGoodsSn = new GsGoodsSn();
            gsGoodsSn.setStatus(cbiw.getType().byteValue());
            gsGoodsSn.setSn(cbiw.getSn());
            GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
            exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
            gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
        }




    }

    @Override
    public int deletelessmore(List<Cbiw> cbiw) {
        Long userid = SecurityUtils.getUserId();

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbiwMapper mapper = session.getMapper(CbiwMapper.class);
        for (Cbiw value : cbiw) {
            if (value.getSn() == null) {
                throw new SwException("sn不能为空");
            }
            CbiwCriteria example = new CbiwCriteria();
            example.createCriteria().andSnEqualTo(value.getSn())
                    .andUserEqualTo(Math.toIntExact(userid));

            mapper.deleteByExample(example);
        }
        session.commit();
        session.clearCache();
        return 1;
        }

    @Override
    public int deletelessws(List<deleteVo> cbiw) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        GsGoodsSnMapper mapper = session.getMapper(GsGoodsSnMapper.class);
        for (com.ruoyi.system.domain.vo.deleteVo deleteVo : cbiw) {
            if (deleteVo.getSn() == null) {
                throw new SwException("sn不能为空");
            }
            if (deleteVo.getType() == null) {
                throw new SwException("类型不能为空");
            }
            if (deleteVo.getTypes() == null) {
                throw new SwException("订单类型不能为空");
            }
            if (deleteVo.getTypes() == 1) {
                CbpeCriteria example = new CbpeCriteria();
                example.createCriteria().andCbpe09EqualTo(deleteVo.getSn())
                        .andCbpc01EqualTo(deleteVo.getId());
                cbpeMapper.deleteByExample(example);


                GsGoodsSnCriteria saf = new GsGoodsSnCriteria();
                saf.createCriteria().andSnEqualTo(deleteVo.getSn());
                gsGoodsSnMapper.deleteByExample(saf);
            }
            if (deleteVo.getTypes() == 2) {
                CbpiCriteria example = new CbpiCriteria();
                example.createCriteria().andCbpi09EqualTo(deleteVo.getSn())
                        .andCbpg01EqualTo(deleteVo.getId());
                cbpiMapper.deleteByExample(example);

                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                gsGoodsSn.setStatus(deleteVo.getType().byteValue());
                gsGoodsSn.setSn(deleteVo.getSn());
                GsGoodsSnCriteria examples = new GsGoodsSnCriteria();
                examples.createCriteria().andSnEqualTo(deleteVo.getSn());
                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, examples);
            }
            if (deleteVo.getTypes() == 3) {
                CbsdCriteria example = new CbsdCriteria();
                example.createCriteria().andCbsd09EqualTo(deleteVo.getSn())
                        .andCbsb01EqualTo(deleteVo.getId());
                cbsdMapper.deleteByExample(example);

                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                gsGoodsSn.setStatus(deleteVo.getType().byteValue());
                gsGoodsSn.setSn(deleteVo.getSn());
                GsGoodsSnCriteria examples = new GsGoodsSnCriteria();
                examples.createCriteria().andSnEqualTo(deleteVo.getSn());
                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, examples);
            }
            if (deleteVo.getTypes() == 4) {
                CbsgCriteria example = new CbsgCriteria();
                example.createCriteria().andCbsg09EqualTo(deleteVo.getSn())
                        .andCbse01EqualTo(deleteVo.getId());
                cbsgMapper.deleteByExample(example);

                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                gsGoodsSn.setStatus(deleteVo.getType().byteValue());
                gsGoodsSn.setSn(deleteVo.getSn());
                GsGoodsSnCriteria examples = new GsGoodsSnCriteria();
                examples.createCriteria().andSnEqualTo(deleteVo.getSn());
                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, examples);
            }
            //调拨单调出删除
            if (deleteVo.getTypes() == 6) {
                CbacCriteria example = new CbacCriteria();
                example.createCriteria().andCbac09EqualTo(deleteVo.getSn())
                        .andCbaa01EqualTo(deleteVo.getId());
                Cbac cbac = Cbac.getInstance();
                cbac.setCbac07(DeleteFlagEnum.DELETE.getCode());
                cbacMapper.updateByExampleSelective(cbac, example);

                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                gsGoodsSn.setStatus(deleteVo.getType().byteValue());
                gsGoodsSn.setSn(deleteVo.getSn());
                GsGoodsSnCriteria examples = new GsGoodsSnCriteria();
                examples.createCriteria().andSnEqualTo(deleteVo.getSn());
                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, examples);
            }
            //调拨单调入删除
            if (deleteVo.getTypes() == 5) {
                CbacCriteria example = new CbacCriteria();
                example.createCriteria().andCbac09EqualTo(deleteVo.getSn())
                        .andCbaa01EqualTo(deleteVo.getId());
                Cbac cbac = Cbac.getInstance();
                cbac.setCbac14(1);
                cbacMapper.updateByExampleSelective(cbac, example);

                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                gsGoodsSn.setStatus(deleteVo.getType().byteValue());
                gsGoodsSn.setSn(deleteVo.getSn());
                GsGoodsSnCriteria examples = new GsGoodsSnCriteria();
                examples.createCriteria().andSnEqualTo(deleteVo.getSn());
                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, examples);
            }
            if (deleteVo.getTypes() == 7) {
                CbpmCriteria example = new CbpmCriteria();
                example.createCriteria().andCbpm09EqualTo(deleteVo.getSn())
                        .andCbpk01EqualTo(deleteVo.getId());
                Cbpm cbpm = new Cbpm();
                cbpm.setCbpm11(0);
                cbpmMapper.updateByExampleSelective(cbpm, example);

                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                gsGoodsSn.setStatus(deleteVo.getType().byteValue());
                gsGoodsSn.setSn(deleteVo.getSn());
                GsGoodsSnCriteria examples = new GsGoodsSnCriteria();
                examples.createCriteria().andSnEqualTo(deleteVo.getSn());
                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, examples);
            }

            if (deleteVo.getTypes() == 8) {
                CbsjCriteria example = new CbsjCriteria();
                example.createCriteria().andCbsj09EqualTo(deleteVo.getSn())
                        .andCbsh01EqualTo(deleteVo.getId());
                cbsjMapper.deleteByExample(example);

                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                gsGoodsSn.setStatus(deleteVo.getType().byteValue());
                gsGoodsSn.setSn(deleteVo.getSn());
                GsGoodsSnCriteria examples = new GsGoodsSnCriteria();
                examples.createCriteria().andSnEqualTo(deleteVo.getSn());
                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, examples);
            }

            GsGoodsSn gsGoodsSn = new GsGoodsSn();
            gsGoodsSn.setStatus(deleteVo.getType().byteValue());
            gsGoodsSn.setSn(deleteVo.getSn());
            GsGoodsSnCriteria example = new GsGoodsSnCriteria();
            example.createCriteria().andSnEqualTo(deleteVo.getSn());
            mapper.updateByExampleSelective(gsGoodsSn, example);
        }
        session.commit();
        session.clearCache();
        return 1;
    }

    @Override
    public String SwJsPusn(CbicDto cbicDto) {
        if (cbicDto==null) {
            throw new SwException("sn不能为空");
        }
       CbpbCriteria example = new CbpbCriteria();
        example.createCriteria().andCbpb12EqualTo(cbicDto.getSn());
List<Cbpb> cbpb = cbpbMapper.selectByExample(example);
if(cbpb.size()>0){
    throw new SwException("1");
}

        return "0";
    }

    @Override
    public String SwJsPusns(CbicDto cbicDto) {
        if(cbicDto.getSn()==null){
            throw new SwException("sn不能为空");
        }
        GsGoodsSnCriteria example = new GsGoodsSnCriteria();
        example.createCriteria().andSnEqualTo(cbicDto.getSn());
        List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
        if(gsGoodsSns.size()==0){
            throw new SwException("0");
        }
        else {
            if(gsGoodsSns.get(0).getGoodsId()!=null){
                Cbpb cbpb = cbpbMapper.selectByPrimaryKey(gsGoodsSns.get(0).getGoodsId());
                if(cbpb!=null){
                    if(cbpb.getCbpb15()!=null){
                        return cbpb.getCbpb15();
                    }
                }
            }
        }
        return "1";
    }

    @Override
    public Cbiw addlessui(Cbiw cbiw) {
         //型号
        if(cbiw.getSn()==null){
            throw new SwException("sn不能为空");
        }
        CbpbCriteria cbpbCriterias = new CbpbCriteria();
        cbpbCriterias.createCriteria().andCbpb12EqualTo(cbiw.getSn());
        List<Cbpb> cbpbss = cbpbMapper.selectByExample(cbpbCriterias);
        if(cbpbss.size()>0){
            throw new SwException("sn不正确");
        }




        if(cbiw.getUpc()==null){
            throw new SwException("upc不能为空");
        }
        if(Objects.equals(cbiw.getSn(), cbiw.getUpc())){
            throw new SwException("sn不正确");
        }
        //判断sn是否存在

        GsGoodsSnCriteria exampler = new GsGoodsSnCriteria();
        exampler.createCriteria().andSnEqualTo(cbiw.getSn())
                .andStatusEqualTo(GoodsType.yrk.getCode());
        List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(exampler);
        if(gsGoodsSns.size()>0){
            throw new SwException("sn已入库"+cbiw.getSn());
        }
//库位容量控制

        CblaCriteria cblaCriteria = new CblaCriteria();
        cblaCriteria.createCriteria().andCbla09EqualTo(cbiw.getStoresku());
        List<Cbla> cblas = cblaMapper.selectByExample(cblaCriteria);
        if(cblas.size()>0){
            if(cblas.get(0).getCbla10()!=null){
                if(cblas.get(0).getCbla10()!=5){
                    throw new SwException("库位不属于GQW仓库");
                }


            }
            //库位容量
           GsGoodsSkuCriteria gsGoodskuCriteria = new GsGoodsSkuCriteria();
            gsGoodskuCriteria.createCriteria().andLocationIdEqualTo(cblas.get(0).getCbla01());
            List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(gsGoodskuCriteria);
            if(gsGoodsSkus.size()>0){
                if(gsGoodsSkus.get(0).getQty()!=null){
                    if(gsGoodsSkus.get(0).getQty()>0){
                        if(gsGoodsSkus.get(0).getQty()+1>cblas.get(0).getCbla11()){
                            throw new SwException("库位容量不足,库位码为"+cblas.get(0).getCbla09());
                        }
                    }
                }
            }
        }

        else {
            throw new SwException("库位不存在");
        }




        CbpbCriteria cbpbCriteria = new CbpbCriteria();
        cbpbCriteria.createCriteria().andCbpb15EqualTo(cbiw.getUpc());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(cbpbCriteria);
        if(cbpbs.size()>0){
            cbiw.setGoodssku(cbpbs.get(0).getCbpb12());
        }
        else {
            throw new SwException("upc不存在");
        }

        if(Objects.equals(cbiw.getGoodssku(), cbiw.getSn())){
            throw new SwException("sn不正确");
        }


        return cbiw;
    }


}
