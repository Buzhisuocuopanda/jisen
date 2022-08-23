package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.Do.GsGoodsSnTransDo;
import com.ruoyi.system.domain.dto.CbpdDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISwJsPurchaseinboundService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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




    /**
     * 新增采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int insertSwJsSkuBarcodes(CbpdDto cbpdDto) {

       // 检查供应商
        baseCheckService.checksupplier(cbpdDto.getCbpc09());
        //检查仓库
        baseCheckService.checkStore(cbpdDto.getCbpc10());
        //检查商品
        baseCheckService.checkGoods(cbpdDto.getCbpd08());

        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc07EqualTo(cbpdDto.getCbpc07())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpc> cbpcs = cbpcMapper.selectByExample(example);
        //主表根据输入编号查不到数据，添加数据
        if(cbpcs.size()==0){
            NumberGenerate numberGenerate = new NumberGenerate();
            Long userid = SecurityUtils.getUserId();
            Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
            Date date = new Date();
            cbpc.setCbpc02(date);
            cbpc.setCbpc03(Math.toIntExact(userid));
            cbpc.setCbpc04(date);
            cbpc.setCbpc05(Math.toIntExact(userid));
            cbpc.setCbpc06(DeleteFlagEnum.NOT_DELETE.getCode());
            String purchaseinboundNo = numberGenerate.getPurchaseinboundNo(cbpdDto.getCbpc10());
            cbpc.setCbpc07(purchaseinboundNo);
            cbpc.setUserId(Math.toIntExact(userid));
            cbpcMapper.insertSelective(cbpc);

            CbpcCriteria example1 = new CbpcCriteria();
            example1.createCriteria().andCbpc07EqualTo(cbpdDto.getCbpc07())
                    .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbpc> cbpcs1 = cbpcMapper.selectByExample(example1);
            Cbpd cbpd = BeanCopyUtils.coypToClass(cbpdDto, Cbpd.class, null);

            cbpd.setCbpd02(cbpdDto.getCbpd02());
            cbpd.setCbpd03(date);
            cbpd.setCbpd04(Math.toIntExact(userid));
            cbpd.setCbpd05(date);
            cbpd.setCbpd06(Math.toIntExact(userid));
            cbpd.setCbpd07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbpd.setCbpd09(cbpdDto.getCbpd09());
            cbpd.setCbpd11(cbpdDto.getCbpd11());

            BigDecimal num = BigDecimal.valueOf(cbpdDto.getCbpd09());
            BigDecimal price = BigDecimal.valueOf(cbpdDto.getCbpd11());
            BigDecimal b =num.multiply(price).setScale(2, RoundingMode.HALF_UP);
            cbpd.setCbpd12(Double.valueOf(String.valueOf(b)));
            cbpd.setCbpc01(cbpcs1.get(0).getCbpc01());
            cbpd.setUserId(Math.toIntExact(userid));
            return cbpdMapper.insertSelective(cbpd);
        }

        //主表插入后通过编号获取主表id
        CbpcCriteria example1 = new CbpcCriteria();
        example1.createCriteria().andCbpc07EqualTo(cbpdDto.getCbpc07())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpc> cbpcs1 = cbpcMapper.selectByExample(example1);
        //通过主表id去查明细表
        CbpdCriteria example2 = new CbpdCriteria();
        example2.createCriteria().andCbpc01EqualTo(cbpcs1.get(0).getCbpc01());
        List<Cbpd> cbpds = cbpdMapper.selectByExample(example2);
        //主表查出的编号存在，明细里商品id不同,增加明细表
        if(!cbpds.get(0).getCbpd08().equals(cbpdDto.getCbpd08()) && cbpcs1.size()>0){


        Cbpd cbpd = BeanCopyUtils.coypToClass(cbpdDto, Cbpd.class, null);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        cbpd.setCbpd02(cbpdDto.getCbpd02());
        cbpd.setCbpd03(date);
        cbpd.setCbpd04(Math.toIntExact(userid));
        cbpd.setCbpd05(date);
        cbpd.setCbpd06(Math.toIntExact(userid));
        cbpd.setCbpd07(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpd.setCbpd09(cbpdDto.getCbpd09());
        cbpd.setCbpd11(cbpdDto.getCbpd11());

        BigDecimal num = BigDecimal.valueOf(cbpdDto.getCbpd09());
        BigDecimal price = BigDecimal.valueOf(cbpdDto.getCbpd11());
        BigDecimal b =num.multiply(price).setScale(2, RoundingMode.HALF_UP);
        cbpd.setCbpd12(Double.valueOf(String.valueOf(b)));
        cbpd.setCbpc01(cbpcs1.get(0).getCbpc01());
        cbpd.setUserId(Math.toIntExact(userid));
        return cbpdMapper.insertSelective(cbpd);}
        return 0;
    }
    /**
     * 新增采购入库单扫码
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int insertSwJsSkuBarcodesm(CbpdDto cbpdDto) {
        // 检查供应商
        baseCheckService.checksupplier(cbpdDto.getCbpc09());
        //检查仓库
        baseCheckService.checkStore(cbpdDto.getCbpc10());
        //检查商品
        baseCheckService.checkGoods(cbpdDto.getCbpd08());

        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc07EqualTo(cbpdDto.getCbpc07())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpc> cbpcs = cbpcMapper.selectByExample(example);
        //主表根据输入编号查不到数据，添加数据
        if (cbpcs.size() == 0) {

            Long userid = SecurityUtils.getUserId();
            Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
            Date date = new Date();
            cbpc.setCbpc02(date);
            cbpc.setCbpc03(Math.toIntExact(userid));
            cbpc.setCbpc04(date);
            cbpc.setCbpc05(Math.toIntExact(userid));
            cbpc.setCbpc06(DeleteFlagEnum.NOT_DELETE.getCode());
            cbpc.setUserId(Math.toIntExact(userid));
            cbpcMapper.insertSelective(cbpc);

            CbpcCriteria example1 = new CbpcCriteria();
            example1.createCriteria().andCbpc07EqualTo(cbpdDto.getCbpc07())
                    .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            List<Cbpc> cbpcs1 = cbpcMapper.selectByExample(example1);
            Cbpd cbpd = BeanCopyUtils.coypToClass(cbpdDto, Cbpd.class, null);

            cbpd.setCbpd02(cbpdDto.getCbpd02());
            cbpd.setCbpd03(date);
            cbpd.setCbpd04(Math.toIntExact(userid));
            cbpd.setCbpd05(date);
            cbpd.setCbpd06(Math.toIntExact(userid));
            cbpd.setCbpd07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbpd.setCbpd09(cbpdDto.getCbpd09());
            cbpd.setCbpd11(cbpdDto.getCbpd11());

            BigDecimal num = BigDecimal.valueOf(cbpdDto.getCbpd09());
            BigDecimal price = BigDecimal.valueOf(cbpdDto.getCbpd11());
            BigDecimal b = num.multiply(price).setScale(2, RoundingMode.HALF_UP);
            cbpd.setCbpd12(Double.valueOf(String.valueOf(b)));
            cbpd.setCbpc01(cbpcs1.get(0).getCbpc01());
            cbpd.setUserId(Math.toIntExact(userid));
            cbpdMapper.insertSelective(cbpd);
            Cbpe cbpe = BeanCopyUtils.coypToClass(cbpdDto, Cbpe.class, null);
            cbpe.setCbpe02(cbpdDto.getCbpd02());
            cbpe.setCbpe03(date);
            cbpe.setCbpe04(Math.toIntExact(userid));
            cbpe.setCbpe05(date);
            cbpe.setCbpe06(Math.toIntExact(userid));
            cbpe.setCbpe07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbpe.setCbpc01(cbpcs1.get(0).getCbpc01());
            cbpeMapper.insertSelective(cbpe);
        }

        //主表插入后通过编号获取主表id
        CbpcCriteria example1 = new CbpcCriteria();
        example1.createCriteria().andCbpc07EqualTo(cbpdDto.getCbpc07())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpc> cbpcs1 = cbpcMapper.selectByExample(example1);
        //通过主表id去查明细表
        CbpdCriteria example2 = new CbpdCriteria();
        example2.createCriteria().andCbpc01EqualTo(cbpcs1.get(0).getCbpc01());
        List<Cbpd> cbpds = cbpdMapper.selectByExample(example2);
        //主表查出的编号存在，明细里商品id不同,增加明细表
        int i = 0;
        if (!cbpds.get(0).getCbpd08().equals(cbpdDto.getCbpd08()) && cbpcs1.size() > 0) {


            Cbpd cbpd = BeanCopyUtils.coypToClass(cbpdDto, Cbpd.class, null);
            Date date = new Date();
            Long userid = SecurityUtils.getUserId();
            cbpd.setCbpd02(cbpdDto.getCbpd02());
            cbpd.setCbpd03(date);
            cbpd.setCbpd04(Math.toIntExact(userid));
            cbpd.setCbpd05(date);
            cbpd.setCbpd06(Math.toIntExact(userid));
            cbpd.setCbpd07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbpd.setCbpd09(cbpdDto.getCbpd09());
            cbpd.setCbpd11(cbpdDto.getCbpd11());

            BigDecimal num = BigDecimal.valueOf(cbpdDto.getCbpd09());
            BigDecimal price = BigDecimal.valueOf(cbpdDto.getCbpd11());
            BigDecimal b = num.multiply(price).setScale(2, RoundingMode.HALF_UP);
            cbpd.setCbpd12(Double.valueOf(String.valueOf(b)));
            cbpd.setCbpc01(cbpcs1.get(0).getCbpc01());
            cbpd.setUserId(Math.toIntExact(userid));
            cbpdMapper.insertSelective(cbpd);
            Cbpe cbpe = BeanCopyUtils.coypToClass(cbpdDto, Cbpe.class, null);
            cbpe.setCbpe02(cbpdDto.getCbpd02());
            cbpe.setCbpe03(date);
            cbpe.setCbpe04(Math.toIntExact(userid));
            cbpe.setCbpe05(date);
            cbpe.setCbpe06(Math.toIntExact(userid));
            cbpe.setCbpe07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbpe.setCbpc01(cbpcs1.get(0).getCbpc01());
            i = cbpeMapper.insertSelective(cbpe);
        }
        return i;
    }

    /**
     * 审核采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
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
    @Override
    public int SwJsSkuBarcodeshss(CbpdDto cbpdDto) {
        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc11(TaskStatus.fsh.getCode());
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
    @Override
    public int SwJsSkuBarcodeshsss(CbpdDto cbpdDto) {

        Cbpc cbpc1 = cbpcMapper.selectByPrimaryKey(cbpdDto.getCbpc01());
        if(cbpc1.getCbpc11().equals(TaskStatus.sh.getCode())||cbpc1.getCbpc11().equals(TaskStatus.fsh.getCode())){}
        else {
            throw new SwException("不是审核状态或反审状态不能标记完成");
        }
        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc11(TaskStatus.bjwc.getCode());
        cbpc.setCbpc12(cbpdDto.getCbpc12());
        cbpc.setCbpc13(cbpdDto.getCbpc13());

        Cbsa cbsa = cbasMapper.selectByPrimaryKey(cbpc1.getCbpc09());


        //判断是哪个仓库  数量仓库
        if(cbpc1.getCbpc10().equals(WarehouseSelect.CBW.getCode()) ||
                cbpc1.getCbpc10().equals(WarehouseSelect.GLW.getCode())){
            //数量管理查找商品id和仓库id，没有就加入
            CbpdCriteria example1=new CbpdCriteria();
            example1.createCriteria()
                    .andCbpd06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                    .andCbpc01EqualTo(cbpdDto.getCbpc01());
            List<Cbpd> cbpds = cbpdMapper.selectByExample(example1);
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

                } else {
                    //更新数据
                    List<Integer> collect1 = gsGoodsSkus.stream().map(GsGoodsSku::getGoodsId).collect(Collectors.toList());
                    int[] ints1 = collect1.stream().mapToInt(Integer::intValue).toArray();
                    int id = ints1[0];
                    GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);
                    gsGoodsSku.setQty(gsGoodsSku.getQty() + num);
                    gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                    gsGoodsSku.setUpdateTime(date);
                    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
                }
                //台账操作
                taskService.InsertCBIB(cbpc1.getCbpc01(), cbpc1.getCbpc10(), TaskType.cgrkd.getMsg());
            }

        }
        //扫码仓库
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
            }

            CbpcCriteria example = new CbpcCriteria();
            example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                    .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            return cbpcMapper.updateByExampleSelective(cbpc, example);

    }
    /**
     * 采购入库单取消完成
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int SwJsSkuBarcodesh(CbpdDto cbpdDto) {
        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc11(TaskStatus.sh.getCode());
        cbpc.setCbpc12(Math.toIntExact(userid));
        cbpc.setCbpc13(date);
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpcMapper.updateByExampleSelective(cbpc, example);
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
    @Override
    public int deleteSwJsSkuBarcodsById(CbpdDto cbpdDto) {

        //标记完成不可删除
        Cbpc cbpc1 = cbpcMapper.selectByPrimaryKey(cbpdDto.getCbpc01());
        if(cbpc1.getCbpc11().equals(TaskStatus.bjwc.getCode()) ||
                cbpc1.getCbpc11().equals(TaskStatus.qxwc.getCode()) ||
                cbpc1.getCbpc11().equals(TaskStatus.sh.getCode())  ){
            throw new SwException("非反审或默认不可删除");
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
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int updateSwJsSkuBarcodes(CbpdDto cbpdDto) {
        //标记完成不可修改
        Cbpc cbpc1 = cbpcMapper.selectByPrimaryKey(cbpdDto.getCbpc01());
        if(cbpc1.getCbpc11().equals(TaskStatus.bjwc.getCode()) ||
                cbpc1.getCbpc11().equals(TaskStatus.qxwc.getCode()) ||
                cbpc1.getCbpc11().equals(TaskStatus.sh.getCode())  ){
            throw new SwException("非反审或默认不可修改");
        }

        if(cbpdDto.getCbpc07()!=null){
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc07EqualTo(cbpdDto.getCbpc07())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpc> cbpcs = cbpcMapper.selectByExample(example);
        if(cbpcs.size() >0){
            throw new SwException("编号已存在");

        }}
        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc07(cbpdDto.getCbpc07());
        cbpc.setCbpc08(cbpdDto.getCbpc08());
        cbpc.setCbpc09(cbpdDto.getCbpc09());
        cbpc.setCbpc10(cbpdDto.getCbpc10());
        cbpc.setCbpc11(cbpdDto.getCbpc11());
        cbpc.setCbpc12(cbpdDto.getCbpc12());
        cbpc.setCbpc13(cbpdDto.getCbpc13());
        cbpc.setCbpc14(cbpdDto.getCbpc14());
        cbpc.setCbpc15(cbpdDto.getCbpc15());
        cbpc.setCbpc16(cbpdDto.getCbpc16());
        cbpc.setCbpc17(cbpdDto.getCbpc17());
        CbpcCriteria example2 = new CbpcCriteria();
        example2.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpcMapper.updateByExampleSelective(cbpc, example2);

        Cbpd cbpd = BeanCopyUtils.coypToClass(cbpdDto, Cbpd.class, null);
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
        return  cbpdMapper.updateByExampleSelective(cbpd, example1);
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
        return cbpdMapper.getInfossss(cbpcVo);
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
    @Override
    public String importSwJsGoods(List<Cbpc> swJsGoodsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(swJsGoodsList) || swJsGoodsList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Cbpc swJsGoods : swJsGoodsList)
        {
            try {
                // 验证是否存在这个用户
                Cbpc u = cbpcMapper.selectByPrimaryKey(swJsGoods.getCbpc01());
                log.info(swJsGoods.getCbpc01() + "");
                if (StringUtils.isNull(u)) {
                    swJsGoods.setCbpc12(swJsGoods.getCbpc12());
                    this.insertCBPC(swJsGoods);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("采购入库单").append(swJsGoods.getCbpc12()).append(" 导入成功");
                } else if (updateSupport) {
                    //  swJsGoods.setUpdateBy(Long.valueOf(operName));
                    this.updateCBPC(swJsGoods);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("采购入库单 ").append(swJsGoods.getCbpc12()).append(" 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("采购入库单").append(swJsGoods.getCbpc12()).append(" 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "采购入库单" + swJsGoods.getCbpc12() + " 导入失败：";
                failureMsg.append(msg).append(e.getMessage());
                log.error(msg, e);
            }
        }
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


