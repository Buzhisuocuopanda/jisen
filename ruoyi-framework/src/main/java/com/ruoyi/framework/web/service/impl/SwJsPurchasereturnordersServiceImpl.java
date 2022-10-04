package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.dto.CbpgDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISwJsPurchasereturnordersService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SwJsPurchasereturnordersServiceImpl implements ISwJsPurchasereturnordersService {

    @Resource
    private CbpgMapper cbpgMapper;

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;

    @Resource
    private CbphMapper cbphMapper;

    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;
    @Resource
    private BaseCheckService baseCheckService;
    @Resource
    private CbpcMapper cbpcMapper;

    @Resource
    private CbpdMapper cbpdMapper;

    @Resource
    private CbbaMapper cbbaMapper;
    @Resource
    private CbsaMapper cbasMapper;

    @Resource
    private CbpeMapper cbpeMapper;
    @Resource
    private CbpiMapper cbpiMapper;

    @Resource
    private TaskService taskService;

    @Resource
    private CblaMapper cblaMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private  NumberGenerate numberGenerate;

    @Resource
    private CbsaMapper cbsaMapper;

    @Resource
    private CbwaMapper cbwaMapper;

    @Resource
    private CalaMapper calaMapper;

    @Resource
    private CbpbMapper cbpbMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 新增采购退货主单
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public IdVo insertSwJsSkuBarcodes(CbpgDto cbpgDto) {

        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date();
        cbpg.setCbpg02(date);
        cbpg.setCbpg03(Math.toIntExact(userid));
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpg.setCbpg10(cbpgDto.getCbpg10());
        cbpg.setCbpg11(TaskStatus.mr.getCode());
        cbpg.setCbpg12(Math.toIntExact(userid));
        String purchasereturnNo = numberGenerate.getPurchasereturnNo(cbpgDto.getCbpg10());
        cbpg.setCbpg07(purchasereturnNo);
        cbpg.setCbpg08(date);
        cbpg.setCbpg11(TaskStatus.mr.getCode());
        cbpg.setUserId(Math.toIntExact(userid));
        cbpgMapper.insertSelective(cbpg);
        CbpgCriteria example1 = new CbpgCriteria();
        example1.createCriteria().andCbpg07EqualTo(purchasereturnNo)
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpg> cbpgs1 = cbpgMapper.selectByExample(example1);


        IdVo idVo = new IdVo();
        idVo.setId(cbpgs1.get(0).getCbpg01());
        return idVo;
    }
    /**
     * 新增采购退货单明细
     *
     * @param itemList 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodess(List<Cbph> itemList) {
        if(itemList.size()==0){
            throw new SwException("采购退货单明细不能为空");
        }
        if(itemList.get(0).getCbpg01()==null){
            throw new SwException("采购退货单主单id不能为空");
        }
        Cbpg cbpg = cbpgMapper.selectByPrimaryKey(itemList.get(0).getCbpg01());
        if(cbpg==null){
            throw new SwException("采购退货单主单不存在");
        }
        Integer storeid = cbpg.getCbpg10();
        GsGoodsSkuCriteria sku = new GsGoodsSkuCriteria();
        sku.createCriteria().andWhIdEqualTo(storeid);
        List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(sku);
        if(gsGoodsSkus.size()==0){
            throw new SwException("库存没有该仓库信息");
        }
        Set<Integer> skuIds = new HashSet<>();
        for (GsGoodsSku gsGoodsSku : gsGoodsSkus) {
            skuIds.add(gsGoodsSku.getGoodsId());
        }

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbphMapper mapper = session.getMapper(CbphMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            if(itemList.get(i).getCbph08()==null){
                throw new SwException("采购退货单明细商品id不能为空");
            }
            if(!skuIds.contains(itemList.get(i).getCbph08())){
                throw new SwException("仓库里没有该商品");
            }

            itemList.get(i).setCbph03(date);
            itemList.get(i).setCbph04(Math.toIntExact(userid));
            itemList.get(i).setCbph05(date);
            itemList.get(i).setCbph06(Math.toIntExact(userid));
            itemList.get(i).setCbph07(DeleteFlagEnum.NOT_DELETE.getCode());
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
     * 新增采购退货单扫码
     *
     * @param itemList 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodesm(List<Cbpi> itemList) {
        //id 商品id，库位id，
        if (itemList.size() == 0) {
            throw new SwException("请选择要扫描的商品");
        }
        if (itemList.get(0).getCbpg01() == null) {
            throw new SwException("采购退货单主表id不能为空");
        }
        CbphCriteria cas = new CbphCriteria();
        cas.createCriteria().andCbpg01EqualTo(itemList.get(0).getCbpg01())
                .andCbph07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbph> cbphs = cbphMapper.selectByExample(cas);
        if (cbphs.size() == 0) {
            throw new SwException("采购退货单明细为空");
        }
        List<Integer> goodsids = cbphs.stream().map(Cbph::getCbph08).collect(Collectors.toList());
        Set<Integer> uio = new HashSet<>(goodsids);
/*
        Set<Integer> uio = null;
*/
    /*    for (int i = 0; i < cbphs.size(); i++) {
            Integer cbph08 = cbphs.get(i).getCbph08();
            uio = new HashSet<>();
            uio.add(cbph08);
        }*/
        Cbpg cbpg = cbpgMapper.selectByPrimaryKey(itemList.get(0).getCbpg01());
        if (cbpg == null) {
            throw new SwException("采购退货单主表为空");
        }
        Integer storeid = cbpg.getCbpg10();
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbpiMapper mapper = session.getMapper(CbpiMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getCbpi08() == null) {
                throw new SwException("商品id不能为空");
            }
           if(!uio.contains(itemList.get(i).getCbpi08())){
                throw new SwException("该商品不在采购退货单明细中");
            }
            Cbla cbla = cblaMapper.selectByPrimaryKey(itemList.get(i).getCbpi10());
            if (cbla == null) {
                throw new SwException("库位不存在");
            }
            if (!cbla.getCbla10().equals(storeid)) {
                throw new SwException("库位不属于该仓库");
            }
            String sn = itemList.get(i).getCbpi09();

            while (!redisTemplate.opsForValue().setIfAbsent("lock1",sn, 3, TimeUnit.SECONDS)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace(); }
            }
            String lock = redisTemplate.opsForValue().get("lock1");

            CbpiCriteria erd = new CbpiCriteria();
            erd.createCriteria().andCbpi09EqualTo(sn)
                    .andCbpi06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbpi> cbpiList = cbpiMapper.selectByExample(erd);
            if (cbpiList.size() > 0) {
                throw new SwException("该sn已存在");
            }
            //校验sn库存表李是否有该sn
            GsGoodsSnDo gsGoodsSnDoss = new GsGoodsSnDo();
            gsGoodsSnDoss.setSn(sn);
            baseCheckService.checkGsGoodsSn(gsGoodsSnDoss);


            Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(itemList.get(i).getCbpg01());
            if (!cbpg1.getCbpg11().equals(TaskStatus.sh.getCode())) {
                throw new SwException("审核状态才能扫码");
            }

            itemList.get(i).setCbpi03(date);
            itemList.get(i).setCbpi04(Math.toIntExact(userid));
            itemList.get(i).setCbpi05(date);
            itemList.get(i).setCbpi06(Math.toIntExact(userid));
            itemList.get(i).setCbpi07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));
            itemList.get(i).setCbpi11(ScanStatusEnum.YISAOMA.getCode());
            //   mapper.insertSelective(itemList.get(i));

            //查商品数量和单价
//             CbphCriteria example = new CbphCriteria();
//            example.createCriteria().andCbpg01EqualTo(itemList.get(i).getCbpg01())
//                    .andCbph07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
//            List<Cbph> cbphs = cbphMapper.selectByExample(example);
            //数量
            //单价

            //如果查不到报错
     /*       Cbpg cbpg = cbpgMapper.selectByPrimaryKey(itemList.get(i).getCbpg01());
            GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
            //获取仓库id
            gsGoodsSkuDo.setWhId(cbpg.getCbpg10());
            //获取商品id
            gsGoodsSkuDo.setGoodsId(itemList.get(i).getCbpi08());
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
                gsGoodsSkuDo1.setWhId(cbpg.getCbpg10());
                //获取商品id
                gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbpi08());
                gsGoodsSkuDo1.setLocationId(itemList.get(i).getCbpi10());
                gsGoodsSkuDo1.setQty(qty-1);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);

            }*/
            GsGoodsSnCriteria example = new GsGoodsSnCriteria();
            example.createCriteria().andSnEqualTo(itemList.get(i).getCbpi09());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
            if (gsGoodsSns.size() >=1 && gsGoodsSns.get(0).getStatus().equals(GoodsType.yck.getCode())) {
                throw new SwException("该sn已出库");
            }

            //更新sn表
            GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setUpdateTime(date);
            gsGoodsSnDo.setUpdateBy(Math.toIntExact(userid));
            gsGoodsSnDo.setSn(itemList.get(i).getCbpi09());
            gsGoodsSnDo.setStatus(GoodsType.yck.getCode());
            gsGoodsSnDo.setOutTime(date);
            gsGoodsSnDo.setGroudStatus(Groudstatus.XJ.getCode());
            taskService.updateGsGoodsSn(gsGoodsSnDo);
        /*    //更新台账
            CbibDo cbibDo = new CbibDo();
            cbibDo.setCbib01(itemList.get(i).getCbpg01());
            cbibDo.setCbib02(cbpg.getCbpg10());
            cbibDo.setCbib03(cbpg.getCbpg07());
            cbibDo.setCbib05(String.valueOf(TaskType.cgtkd.getCode()));
            Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbpg.getCbpg09());
            cbibDo.setCbib06(cbsa.getCbsa08());
            cbibDo.setCbib07(cbpg.getCbpg01());
            cbibDo.setCbib08(itemList.get(i).getCbpi08());
            cbibDo.setCbib13(cbph09);
            cbibDo.setCbib14(cbph10);
            cbibDo.setCbib17(TaskType.cgtkd.getMsg());
            cbibDo.setCbib19(cbpg.getCbpg09());
           taskService.InsertCBIB(cbibDo);*/
            mapper.insertSelective(itemList.get(i));
            redisTemplate.delete("lock1");

            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }
     /*   CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(itemList.get(0).getCbpg01());
        //标记审核完成
        this.SwJsSkuBarcodes(cbpgDto);*/

        session.commit();
        session.clearCache();
        return 1;
    }
    //导入新增
    @Transactional
    @Override
    public int insertSwJsStores(List<CbpgDo> itemList) {
        if(Objects.isNull(itemList.get(0).getSuppierName())){
            throw new SwException("供应商名称不能为空");

        }
        CbsaCriteria cbsaCriteria = new CbsaCriteria();
        cbsaCriteria.createCriteria().andCbsa08EqualTo(itemList.get(0).getSuppierName());
        List<Cbsa> cbsas = cbsaMapper.selectByExample(cbsaCriteria);
        if(cbsas.size()==0){
            throw new SwException("供应商不存在");
        }
        Integer cbsa01 = cbsas.get(0).getCbsa01();
        if(itemList.get(0).getStorename()==null){
            throw new SwException("仓库名称不能为空");
        }
        String storename = itemList.get(0).getStorename();
        CbwaCriteria cbwaCriteria = new CbwaCriteria();
        cbwaCriteria.createCriteria().andCbwa09EqualTo(storename);
        List<Cbwa> cbwas = cbwaMapper.selectByExample(cbwaCriteria);
        if(cbwas.size()==0){
            throw new SwException("仓库不存在");
        }
        Integer cbwa01 = cbwas.get(0).getCbwa01();

        if(Objects.isNull(itemList.get(0).getMoneytype())){
            throw new SwException("货币类形不能为空");
        }
        CalaCriteria calaCriteria = new CalaCriteria();
        calaCriteria.createCriteria()
                .andCala08EqualTo(itemList.get(0).getMoneytype())
                .andCala10EqualTo("币种");
        List<Cala> calas = calaMapper.selectByExample(calaCriteria);
        if(calas.size()==0){
            throw new SwException("货币类形不存在");
        }
        Integer cala01 = calas.get(0).getCala01();


        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        Date cbpg08 = itemList.get(0).getCbpg08();
        Integer cbpg10 = itemList.get(0).getCbpg10();
        Integer cbpg16 = itemList.get(0).getCbpg16();
        String purchaseinboundNo = numberGenerate.getPurchasereturnNo(cbwa01);

        Cbpg cbpg = new Cbpg();
        cbpg.setCbpg02(date);
        cbpg.setCbpg03(Math.toIntExact(userid));
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpg.setCbpg07(purchaseinboundNo);
        cbpg.setCbpg08(date);
        cbpg.setCbpg09(cbsa01);
        cbpg.setCbpg10(cbwa01);
        cbpg.setCbpg11(TaskStatus.mr.getCode());
        cbpg.setCbpg16(cala01);
        cbpg.setCbpg06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpgMapper.insertSelective(cbpg);

        CbpgCriteria cbpgCriteria = new CbpgCriteria();
        cbpgCriteria.createCriteria().andCbpg07EqualTo(purchaseinboundNo);
        List<Cbpg> cbpgs = cbpgMapper.selectByExample(cbpgCriteria);
        Integer cbpg01 = cbpgs.get(0).getCbpg01();

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbphMapper mapper = session.getMapper(CbphMapper.class);

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


            itemList.get(i).setCbph03(date);
            itemList.get(i).setCbph04(Math.toIntExact(userid));
            itemList.get(i).setCbph05(date);
            itemList.get(i).setCbph06(Math.toIntExact(userid));
            itemList.get(i).setCbph07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setCbph08(cbpb01);
            itemList.get(i).setUserId(Math.toIntExact(userid));
            itemList.get(i).setCbpg01(cbpg01);
            itemList.get(i).setCbph09(itemList.get(0).getCbph09());
            itemList.get(i).setCbph10(itemList.get(0).getCbph10());
            itemList.get(i).setCbph13(itemList.get(0).getCbph13());

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
//导入
@Transactional
@Override
    public String importSwJsGoods(List<CbpgDo> swJsGoodsList, boolean updateSupport, String operName) {
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

    @Override
    public void SwJsPurchasereturnorderseditone(CbpgDto cbpgDto) {
        if(cbpgDto.getCbpg01()==null){
            throw new SwException("采购退库单主表不能为空");
        }
        List<Cbph> goods = cbpgDto.getGoods();
        if(goods==null||goods.size()==0){
            throw new SwException("请至少添加一件货物");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        cbpg.setCbpg01(cbpgDto.getCbpg01());
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpgMapper.updateByPrimaryKeySelective(cbpg);

        Cbph cbph = null;
        for(Cbph good:goods){
            cbph = new Cbph();
            if(good.getCbph01()==null){
                throw new SwException("采购退库单明细id不能为空");
            }
            cbph.setCbph01(good.getCbph01());
            cbph.setCbph04(Math.toIntExact(userid));
            cbph.setCbph05(date);
            cbph.setCbph06(Math.toIntExact(userid));
            cbph.setCbph08(good.getCbph08());
            cbph.setCbph09(good.getCbph09());
            cbph.setCbph10(good.getCbph10());
            cbph.setCbph11(good.getCbph11());
            cbph.setCbph12(good.getCbph12());
            cbph.setCbph13(good.getCbph13());
            cbphMapper.updateByPrimaryKeySelective(cbph);
        }
return;

    }

    /**
     * 删除采购退货单
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSwJsSkuBarcodsById(CbpgDto cbpgDto) {
        //标记完成不可删除
        Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(cbpgDto.getCbpg01());
        if(cbpg1.getCbpg11().equals(TaskStatus.bjwc.getCode()) ||
                cbpg1.getCbpg11().equals(TaskStatus.qxwc.getCode()) ||
                cbpg1.getCbpg11().equals(TaskStatus.sh.getCode())  ){
            throw new SwException("非反审或默认不可删除");
        }
        Integer storeid = cbpg1.getCbpg10();
        CbphCriteria example1=new CbphCriteria();
        example1.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbph07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbph> cbphs = cbphMapper.selectByExample(example1);
        if(cbphs.size()>0) {
for(int i=0;i<cbphs.size();i++) {
    Integer cbph08 = cbphs.get(i).getCbph08();

    //检查是否有库存
    baseCheckService.checkGoodsSku(cbph08, storeid);
}
        }
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date();
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg06(DeleteFlagEnum.DELETE.getCode());

        CbpgCriteria example = new CbpgCriteria();
        example.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbpgMapper.updateByExampleSelective(cbpg, example);
    }
    /**
     * 更新采购退货单
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSwJsSkuBarcodes(CbpgDto cbpgDto) {
        //标记完成不可删除
        Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(cbpgDto.getCbpg01());
        if(cbpg1.getCbpg11().equals(TaskStatus.bjwc.getCode()) ||
                cbpg1.getCbpg11().equals(TaskStatus.qxwc.getCode()) ||
                cbpg1.getCbpg11().equals(TaskStatus.sh.getCode())  ){
            throw new SwException("非反审或默认不可删除");
        }

        CbpgCriteria example = new CbpgCriteria();
        if(cbpgDto.getCbpg07()!=null){
        example.createCriteria().andCbpg07EqualTo(cbpgDto.getCbpg07())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpg> cbpgs = cbpgMapper.selectByExample(example);
        if(cbpgs.size() >0 && !cbpgs.get(0).getCbpg01().equals(cbpgDto.getCbpg01())){
            throw new SwException("编号已存在");
        }}
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date();
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));

        CbpgCriteria example2 = new CbpgCriteria();
        example2.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            cbpgMapper.updateByExampleSelective(cbpg, example2);
        return 1;
    }
    /**
     * 采购退货单详情
     *
     * @param cbpgVo 审核信息
     * @return 结果
     */
    @Override
    public List<CbpgVo> selectSwJsTaskGoodsRelLists(CbpgVo cbpgVo) {
        List<CbpgVo> infoss = cbpgMapper.getInfoss(cbpgVo);
        CbpgVo res = new CbpgVo();
        List<ScanVo> goods = res.getGoods();

       if(cbpgVo.getCbpg01()==null){
       throw new SwException("采购退货单号不能为空");
        }

        Integer cbpg01 = cbpgVo.getCbpg01();
        CbpiCriteria example1 = new CbpiCriteria();
        example1.createCriteria().andCbpg01EqualTo(cbpg01);
        List<Cbpi> cbpiss = cbpiMapper.selectByExample(example1);
        Double sum = 0.0;

        if(cbpiss.size()>0) {
            Integer saoma = 0;

            for (int i = 0; i < infoss.size(); i++) {

                CbpiCriteria example = new CbpiCriteria();
                example.createCriteria().andCbpg01EqualTo(cbpg01)
                        .andCbpi08EqualTo(infoss.get(i).getCbph08());
                List<Cbpi> cbpis = cbpiMapper.selectByExample(example);
                int size = cbpis.size();
                for (int j = 0; j < size; j++) {
                    ScanVo scanVo = new ScanVo();
                    scanVo.setLx(infoss.get(i).getCbpa08());
                    scanVo.setPinpai(infoss.get(i).getPinpai());
                    scanVo.setCbpb08(infoss.get(i).getCbpb08());
                    scanVo.setCbpb12(infoss.get(i).getCbpb12());
                    scanVo.setCbpb15(infoss.get(i).getCbpb15());
                    scanVo.setSn(infoss.get(j).getCbpi09());
                    scanVo.setKwm(infoss.get(i).getCbla09());
                    scanVo.setCbpe03(infoss.get(j).getCbpi03());
                    goods.add(scanVo);
                }
                infoss.get(i).setSaoma(size);
                saoma += infoss.get(i).getSaoma();
            }
            infoss.get(0).setSaomanums(saoma);
            infoss.get(0).setGoods(goods);
        }
if(infoss.size()>0) {
    for (int i = 0; i < infoss.size(); i++) {
        sum += infoss.get(i).getCbph09();
    }

    infoss.get(0).setNums(sum);
}
        return infoss;
    }
    /**
     * 采购退货单列表
     *
     * @param cbpgVo 审核信息
     * @return 结果
     */
    @Override
    public List<CbpgVo> selectSwJsTaskGoodsRelList(CbpgVo cbpgVo) {
        return  cbpgMapper.getInfos(cbpgVo);

    }
    /**
     * 查询退货单列表
     *
     * @param cbpgVo 审核信息
     * @return 结果
     */
    @Override
    public List<CbpgVo> selectSwJsTaskGoodsRelListss(CbpgVo cbpgVo) {
        return  cbpgMapper.getInfosss(cbpgVo);
    }
    /**
     * 审核退货单列表
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int SwJsSkuBarcodeshs(CbpgDto cbpgDto) {
        Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(cbpgDto.getCbpg01());
        if(!cbpg1.getCbpg11().equals(TaskStatus.mr.getCode())){
            throw new SwException("不是未审核状态不能审核");
        }
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date();
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg11(TaskStatus.sh.getCode());

        cbpg.setCbpg12(Math.toIntExact(userid));
        cbpg.setCbpg13(date);
        //cbpg.setCbpg15(date);
        CbpgCriteria example = new CbpgCriteria();
        example.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpgMapper.updateByExampleSelective(cbpg, example);

    }
    /**
     * 反审退货单列表
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int SwJsSkuBarcodesh(CbpgDto cbpgDto) {


        CbpiCriteria example1 = new CbpiCriteria();
        example1.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01());
        List<Cbpi> cbpes = cbpiMapper.selectByExample(example1);
        if(cbpes.size()>0 ){
            int size = cbpes.size();
            for(int i=0;i<size;i++){
                if(cbpes.get(i).getCbpi11().equals(ScanStatusEnum.YISAOMA.getCode())) {

                    throw new SwException("已扫码不能反审");
                }
            }
        }
        Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(cbpgDto.getCbpg01());
        if(!cbpg1.getCbpg11().equals(TaskStatus.sh.getCode())){
            throw new SwException("不是审核状态");
        }
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date();
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg11(TaskStatus.mr.getCode());

        cbpg.setCbpg12(Math.toIntExact(userid));
        cbpg.setCbpg13(date);
        //cbpg.setCbpg15(date);
        CbpgCriteria example = new CbpgCriteria();
        example.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpgMapper.updateByExampleSelective(cbpg, example);    }
    /**
     * 取消完成退货单列表
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int SwJsSkuBarcodeshss(CbpgDto cbpgDto) {


        CbpiCriteria example1 = new CbpiCriteria();
        example1.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01());
        List<Cbpi> cbpes = cbpiMapper.selectByExample(example1);
        if(cbpes.size()>0 ){
            int size = cbpes.size();
            for(int i=0;i<size;i++){
                if(cbpes.get(i).getCbpi11().equals(ScanStatusEnum.YISAOMA.getCode())) {

                    throw new SwException("已扫码不能取消完成");
                }
            }
        }

        Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(cbpgDto.getCbpg01());
        if(!cbpg1.getCbpg11().equals(TaskStatus.bjwc.getCode())){
            throw new SwException("不是标记完成状态");
        }
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date();
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg11(TaskStatus.sh.getCode());

        cbpg.setCbpg12(Math.toIntExact(userid));
        cbpg.setCbpg13(date);
        //cbpg.setCbpg15(date);
        CbpgCriteria example = new CbpgCriteria();
        example.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpgMapper.updateByExampleSelective(cbpg, example);    }
    /**
     * 标记完成退货单列表
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Transactional
    @Override
    public int SwJsSkuBarcodes(CbpgDto cbpgDto) {
        if(cbpgDto.getCbpg01()==null){
            throw new SwException("退货单id不能为空");
        }

        Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(cbpgDto.getCbpg01());
        if(cbpg1.getCbpg11().equals(TaskStatus.sh.getCode())){}
        else{
            throw new SwException("不是审核状态或反审状态");
        }
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date();
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg11(TaskStatus.bjwc.getCode());

        cbpg.setCbpg12(Math.toIntExact(userid));
        cbpg.setCbpg13(date);
        //cbpg.setCbpg15(date);
        Cbsa cbsa = cbasMapper.selectByPrimaryKey(cbpg1.getCbpg09());


        UIOVo uioVo = new UIOVo();
        uioVo.setId(cbpgDto.getCbpg01());
        List<UIOVo> selectbyid = cbpiMapper.selectbyid(uioVo);
        if(selectbyid.size()>0){
            for(int k=0;k<selectbyid.size();k++) {
                GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
                //获取仓库id
                gsGoodsSkuDo.setWhId(cbpg1.getCbpg10());
                gsGoodsSkuDo.setLocationId(selectbyid.get(k).getStoreskuid());
                //获取商品id
                gsGoodsSkuDo.setGoodsId(selectbyid.get(k).getGoodsId());
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
                    gsGoodsSkuDo1.setWhId(cbpg1.getCbpg10());
                    //获取商品id
                    gsGoodsSkuDo1.setGoodsId(selectbyid.get(k).getGoodsId());
                    gsGoodsSkuDo1.setLocationId(selectbyid.get(k).getStoreskuid());
                    if(qty-selectbyid.get(k).getNums()<0){
                        throw new SwException("库存数量不足");
                    }
                    gsGoodsSkuDo1.setQty(qty-selectbyid.get(k).getNums());
                    taskService.updateGsGoodsSku(gsGoodsSkuDo1);


                }
            }}

        //数量管理查找商品id和仓库id，没有就加入
        CbphCriteria example1=new CbphCriteria();
        example1.createCriteria()
                .andCbph07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCbpg01EqualTo(cbpgDto.getCbpg01());
        List<Cbph> cbphs = cbphMapper.selectByExample(example1);
        for (Cbph cbph : cbphs) {
            Cbba cbba = cbbaMapper.selectByPrimaryKey(cbph.getCbph08());
            //供应商id
            Integer vendorid = cbpg1.getCbpg09();
            //商品id
            Integer goodid = cbph.getCbph08();
            //仓库id
            Integer storeid = cbpg1.getCbpg10();
            //数量
            //Double num = cbph.getCbph09();
            //编号
            String number = cbpg1.getCbpg07();
            //金额
            Double money = cbph.getCbph10();

            //判断是哪个仓库  数量仓库

            //扫码仓库

                CbpiCriteria example2 = new CbpiCriteria();
                example2.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                        .andCbpi07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                        .andCbpi08EqualTo(cbph.getCbph08());
                List<Cbpi> cbpis = cbpiMapper.selectByExample(example2);
                if(cbpis.size()==0){
                    throw new SwException("没有该采购退库扫码信息");
                }
            Double num= (double) cbpis.size();
/*
                for (Cbpi cbpi : cbpis) {

                    Integer goodsid = cbpi.getCbpi08();
                    //库位id
                    if(cbpi.getCbpi10()==null){
                        throw new SwException("库位id不能为空");
                    }
                    Integer cbpi10 = cbpi.getCbpi10();
                    //sn
//                    String sn = cbpi.getCbpi09();
//                    //以扫数量
//                    Integer snum = cbpi.getCbpi11();

                    //检查是否有数据存在
//                    GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
//                    example.createCriteria()
//                            .andGoodsIdEqualTo(goodsid)
//                            .andWhIdEqualTo(storeid);
//                    List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
//                    //库存表id
//                    Integer id = gsGoodsSkus.get(0).getId();
                   // Cbpg cbpg = cbpgMapper.selectByPrimaryKey(itemList.get(i).getCbpg01());
                    GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
                    //获取仓库id
                    gsGoodsSkuDo.setWhId(storeid);
                    gsGoodsSkuDo.setLocationId(cbpi10);
                    //获取商品id
                    gsGoodsSkuDo.setGoodsId(goodsid);
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
                        gsGoodsSkuDo1.setWhId(cbpg1.getCbpg10());
                        //获取商品id
                        gsGoodsSkuDo1.setGoodsId(goodsid);
                        gsGoodsSkuDo1.setLocationId(cbpi10);
                        gsGoodsSkuDo1.setQty(qty-1);
                        taskService.updateGsGoodsSku(gsGoodsSkuDo1);


                }}
*/
            //台账操作
            CbibDo cbibDo = new CbibDo();
            cbibDo.setCbib02(storeid);
            cbibDo.setCbib03(number);
            cbibDo.setCbib05(String.valueOf(TaskType.cgtkd.getCode()));
            cbibDo.setCbib06(cbsa.getCbsa07());
            cbibDo.setCbib07(cbpgDto.getCbpg01());
            cbibDo.setCbib08(goodid);
            cbibDo.setCbib13(num);
            cbibDo.setCbib14(money*num);
            cbibDo.setCbib17(TaskType.cgtkd.getMsg());
            cbibDo.setCbib19(vendorid);
            taskService.InsertCBIB(cbibDo);
        }
        CbpgCriteria example = new CbpgCriteria();
        example.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return cbpgMapper.updateByExampleSelective(cbpg, example);      }



}
