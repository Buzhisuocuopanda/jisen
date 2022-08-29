package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.dto.CbpgDto;
import com.ruoyi.system.domain.vo.CbpgVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.domain.vo.NumberVo;
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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private  NumberGenerate numberGenerate;
    /**
     * 新增采购退货主单
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
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

     /*   CbpgCriteria example1 = new CbpgCriteria();
        example1.createCriteria().andCbpg07EqualTo(cbpgDto.getCbpg07())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpg> cbpgs1 = cbpgMapper.selectByExample(example);
        List<Integer> collect = cbpgs1.stream().map(Cbpg::getCbpg01).collect(Collectors.toList());
        int[] ints = collect.stream().mapToInt(Integer::intValue).toArray();

        Cbph cbph = BeanCopyUtils.coypToClass(cbpgDto, Cbph.class, null);
        cbph.setCbph03(date);
        cbph.setCbph04(Math.toIntExact(userid));
        cbph.setCbph05(date);
        cbph.setCbph06(Math.toIntExact(userid));
        cbph.setCbph07(DeleteFlagEnum.NOT_DELETE.getCode());
        cbph.setCbpg01(ints[0]);
        cbph.setUserId(Math.toIntExact(userid));
        cbph.setCbph09(cbpgDto.getCbph09());
        cbph.setCbph10(cbpgDto.getCbph10());
        BigDecimal num = BigDecimal.valueOf(cbpgDto.getCbph09());
        BigDecimal price = BigDecimal.valueOf(cbpgDto.getCbph10());
        BigDecimal b =num.multiply(price).setScale(2, RoundingMode.HALF_UP);
        cbph.setCbph11(cbpgDto.getCbph11());
        cbph.setCbph12(cbpgDto.getCbph12());*/
        IdVo idVo = new IdVo();
        idVo.setId(cbpgs1.get(0).getCbpg01());
        return idVo;
    }
    /**
     * 新增采购退货单明细
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Override
    public int insertSwJsSkuBarcodess(List<Cbph> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbphMapper mapper = session.getMapper(CbphMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
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
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Override
    public int insertSwJsSkuBarcodesm(List<Cbpi> itemList) {

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbpiMapper mapper = session.getMapper(CbpiMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbpi03(date);
            itemList.get(i).setCbpi04(Math.toIntExact(userid));
            itemList.get(i).setCbpi05(date);
            itemList.get(i).setCbpi06(Math.toIntExact(userid));
            itemList.get(i).setCbpi07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));
         //   mapper.insertSelective(itemList.get(i));

            //如果查不到添加信息到库存表
            Cbpg cbpg = cbpgMapper.selectByPrimaryKey(itemList.get(i).getCbpg01());
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

            }
            //更新sn表
            GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setSn(itemList.get(i).getCbpi09());
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
        session.commit();
        session.clearCache();
        return 1;
    }

    /**
     * 删除采购退货单
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
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
        Integer cbph08 = cbphs.get(0).getCbph08();

        Cbba cbba = cbbaMapper.selectByPrimaryKey(cbph08);
        Integer goodsid = cbba.getCbba08();
        //检查是否有库存
        baseCheckService.checkGoodsSku(goodsid,storeid);

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
        return    cbpgMapper.updateByExampleSelective(cbpg, example2);
    }
    /**
     * 采购退货单详情
     *
     * @param cbpgVo 审核信息
     * @return 结果
     */
    @Override
    public List<CbpgVo> selectSwJsTaskGoodsRelLists(CbpgVo cbpgVo) {
        return  cbpgMapper.getInfoss(cbpgVo);
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
    @Override
    public int SwJsSkuBarcodeshs(CbpgDto cbpgDto) {
        Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(cbpgDto.getCbpg01());
        if(!cbpg1.getCbpg11().equals(TaskStatus.mr.getCode())){
            throw new SwException("不是审核状态");
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
    @Override
    public int SwJsSkuBarcodesh(CbpgDto cbpgDto) {
        Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(cbpgDto.getCbpg01());
        if(!cbpg1.getCbpg11().equals(TaskStatus.sh.getCode())){
            throw new SwException("不是审核状态");
        }
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date();
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg11(TaskStatus.fsh.getCode());

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
    @Override
    public int SwJsSkuBarcodeshss(CbpgDto cbpgDto) {
        Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(cbpgDto.getCbpg01());
        if(!cbpg1.getCbpg11().equals(TaskStatus.bjwc.getCode())){
            throw new SwException("不是标记完成状态");
        }
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date();
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg11(TaskStatus.qxwc.getCode());

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
    @Override
    public int SwJsSkuBarcodes(CbpgDto cbpgDto) {

        Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(cbpgDto.getCbpg01());
        if(cbpg1.getCbpg11().equals(TaskStatus.sh.getCode())||cbpg1.getCbpg11().equals(TaskStatus.fsh.getCode())){}
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



    /*    //数量管理查找商品id和仓库id，没有就加入
        CbphCriteria example1=new CbphCriteria();
        example1.createCriteria()
                .andCbph06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCbph01EqualTo(cbpgDto.getCbph01());
        List<Cbph> cbphs = cbphMapper.selectByExample(example1);
        for (Cbph cbph : cbphs) {
            Cbba cbba = cbbaMapper.selectByPrimaryKey(cbph.getCbph08());
            //供应商id
            Integer vendorid = cbpg1.getCbpg09();
            //商品id
            Integer goodsid = cbba.getCbba08();
            //仓库id
            Integer storeid = cbpg1.getCbpg10();
            //数量
            Double num = cbph.getCbph09();
            //编号
            String number = cbpg1.getCbpg07();
            //金额
            Double money = cbph.getCbph11();

            //判断是哪个仓库  数量仓库
            if (cbpg1.getCbpg10().equals(WarehouseSelect.CBW.getCode()) ||
                    cbpg1.getCbpg10().equals(WarehouseSelect.GLW.getCode())) {
                //检查是否有数据存在
                GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
                example.createCriteria()
                        .andGoodsIdEqualTo(goodsid)
                        .andWhIdEqualTo(storeid);
                List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
                //库存表id
                Integer id = gsGoodsSkus.get(0).getId();
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
                    gsGoodsSku.setWhId(storeid);
                    gsGoodsSku.setQty(num);
                    gsGoodsSkuMapper.insertSelective(gsGoodsSku);
                } else {
                    GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);
                    gsGoodsSku.setQty(gsGoodsSku.getQty() - num);
                    gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                    gsGoodsSku.setUpdateTime(date);
                    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
                }
                //台账操作
                CbibDo cbibDo = new CbibDo();
                cbibDo.setCbib02(storeid);
                cbibDo.setCbib03(number);
                cbibDo.setCbib05(String.valueOf(TaskType.cgtkd.getCode()));
                cbibDo.setCbib06(cbsa.getCbsa07());
                cbibDo.setCbib07(cbpgDto.getCbpg01());
                cbibDo.setCbib08(goodsid);
                cbibDo.setCbib13(num);
                cbibDo.setCbib14(money);
                cbibDo.setCbib15(num);
                cbibDo.setCbib16(money);
                cbibDo.setCbib17(TaskType.cgrkd.getMsg());
                cbibDo.setCbib19(vendorid);
                taskService.InsertCBIB(cbibDo);

            }
            //扫码仓库
            else {
                CbpiCriteria example2 = new CbpiCriteria();
                example2.createCriteria().andCbpi01EqualTo(cbpgDto.getCbpg01())
                        .andCbpi07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                List<Cbpi> cbpis = cbpiMapper.selectByExample(example2);
                for (Cbpi cbpi : cbpis) {
                    //sn
                    String sn = cbpi.getCbpi09();
                    //以扫数量
                    Integer snum = cbpi.getCbpi11();

                    //检查是否有数据存在
                    GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
                    example.createCriteria()
                            .andGoodsIdEqualTo(goodsid)
                            .andWhIdEqualTo(storeid);
                    List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
                    //库存表id
                    Integer id = gsGoodsSkus.get(0).getId();


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
                        gsGoodsSku.setWhId(storeid);
                        gsGoodsSku.setQty(Double.valueOf(snum));
                        gsGoodsSkuMapper.insertSelective(gsGoodsSku);
                    } else {
                        //对库存进行更新操作
                        GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);
                        gsGoodsSku.setQty(gsGoodsSku.getQty() + snum);
                        gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                        gsGoodsSku.setUpdateTime(date);
                        gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
                    }
                    //对货物sn表操作
                    GsGoodsSnDo goodsSnDo = new GsGoodsSnDo();
                    goodsSnDo.setSn(sn);
                    goodsSnDo.setGoodsId(goodsid);
                    goodsSnDo.setStatus(GoodsType.yrk.getCode());
                    goodsSnDo.setInTime(date);
                    taskService.InsertGsGoodsn(goodsSnDo);


                    //商品sn扫码交易表
                    GsGoodsSnTransDo goodsSnTransDo = new GsGoodsSnTransDo();
                    goodsSnTransDo.setSn(sn);
                    goodsSnTransDo.setTransType(TaskType.cgrkd.getCode());
                    goodsSnTransDo.setTransId(cbpgDto.getCbpg01());
                    goodsSnTransDo.setTransLineId(cbpg1.getCbpg07());
                    goodsSnTransDo.setGoodsId(goodsid);
                    taskService.InsertGsGoodsntrans(goodsSnTransDo);


                    //台账操作
                    CbibDo cbibDo = new CbibDo();
                    cbibDo.setCbib02(storeid);
                    cbibDo.setCbib03(number);
                    cbibDo.setCbib05(String.valueOf(TaskType.cgtkd.getCode()));
                    cbibDo.setCbib06(cbsa.getCbsa07());
                    cbibDo.setCbib07(cbpgDto.getCbpg01());
                    cbibDo.setCbib08(goodsid);
                    cbibDo.setCbib13(num);
                    cbibDo.setCbib14(money);
                    cbibDo.setCbib15(num);
                    cbibDo.setCbib16(money);
                    cbibDo.setCbib17(TaskType.cgrkd.getMsg());
                    cbibDo.setCbib19(vendorid);
                    taskService.InsertCBIB(cbibDo);
                }
            }
        }*/
        CbpgCriteria example = new CbpgCriteria();
        example.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return cbpgMapper.updateByExampleSelective(cbpg, example);      }



}
