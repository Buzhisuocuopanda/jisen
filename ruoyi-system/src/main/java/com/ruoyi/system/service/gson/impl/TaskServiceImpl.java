package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.enums.TaskType;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Do.GsGoodsSkuDo;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.Do.GsGoodsSnTransDo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.gson.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private CbpcMapper cbpcMapper;
    @Resource
    private CbsaMapper cbsaMapper;
    @Resource
    private CbpbMapper cbpbMapper;

    @Resource
    private CbpdMapper cbpdMapper;

    @Resource
    private CbibMapper cbibMapper;

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;
    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;

    @Resource
    private GsGoodsSnTransMapper gsGoodsSnTransMapper;
    @Override
    public Cbib InsertCBIB(Integer typeid, Integer storeId, String type) {

        if(type==null){
            throw new SwException("单据类型名称不能为空");
        }
        if(TaskType.cgrkd.getMsg().equals(type)){

            Cbpc cbpc = cbpcMapper.selectByPrimaryKey(typeid);
            if(cbpc==null || DeleteFlagEnum.DELETE.getCode().equals(cbpc.getCbpc06())){

                throw new SwException("未找到采购入库单：");
            }

            Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbpc.getCbpc09());
            if(cbsa==null || DeleteFlagEnum.DELETE.getCode().equals(cbsa.getCbsa06())){

                throw new SwException("未找到供应商：");
            }


            CbpdCriteria example = new CbpdCriteria();
            example.createCriteria().andCbpc01EqualTo(typeid)
                    .andCbpd07EqualTo(DeleteFlagEnum.DELETE.getCode());
            List<Cbpd> cbpds = cbpdMapper.selectByExample(example);
            //  Cbpd[] cbpds1 = cbpds.toArray(new Cbpd[]{});
            //金额
            List<Double> collect2 = cbpds.stream().map(Cbpd::getCbpd12).collect(Collectors.toList());
            double[] doubles1 = collect2.stream().mapToDouble(Double::doubleValue).toArray();

            //数量
            List<Double> collect1 = cbpds.stream().map(Cbpd::getCbpd09).collect(Collectors.toList());
            double[] doubles = collect1.stream().mapToDouble(Double::doubleValue).toArray();

            //获取商品id
            List<Integer> collect = cbpds.stream().map(Cbpd::getCbpd08).collect(Collectors.toList());
            int[] ints = collect.stream().mapToInt(Integer::intValue).toArray();
            if(ints.length==0){
                throw new SwException("没获取到商品id：");

            }


            CbibCriteria example1 = new CbibCriteria();
            example1.createCriteria()
                    .andCbib02EqualTo(storeId)
                    .andCbib08EqualTo(ints[0]);
            List<Cbib> cbibs = cbibMapper.selectByExample(example1);
            Cbib cbib1 = selectLastOne(cbibs);


            Date date = new Date();
            Long userid = SecurityUtils.getUserId();

            Cbib cbib = new Cbib();
            cbib.setCbib02(storeId);
            cbib.setCbib03(cbpc.getCbpc07());
            cbib.setCbib04(date);
            cbib.setCbib05(String.valueOf(TaskType.cgrkd.getCode()));
            cbib.setCbib06(cbsa.getCbsa07());
            cbib.setCbib07(typeid);
            cbib.setCbib08(ints[0]);
            cbib.setCbib09(cbib1.getCbib09());
            cbib.setCbib10(cbib1.getCbib10());
            cbib.setCbib11(doubles[0]);
            cbib.setCbib12(doubles1[0]);

            cbib.setCbib15(doubles[0]);
            cbib.setCbib16(doubles1[0]);
            cbib.setCbib17("采购入库单");
            cbib.setCbib18(cbib1.getCbib18()+1);
            cbib.setCbib19(cbpc.getCbpc09());
            cbibMapper.insertSelective(cbib);
        }
        return null;
    }

    @Override
    public int InsertGsGoodsn(GsGoodsSnDo goodsSnDo) {
        Long userid = SecurityUtils.getUserId();
        GsGoodsSn gsGoodsSn = BeanCopyUtils.coypToClass(goodsSnDo, GsGoodsSn.class, null);
        Date date=new Date();
        gsGoodsSn.setId(Math.toIntExact(userid));
        gsGoodsSn.setCreateTime(date);
        gsGoodsSn.setUpdateTime(date);
        gsGoodsSn.setCreateBy(Math.toIntExact(userid));
        gsGoodsSn.setUpdateBy(Math.toIntExact(userid));
        gsGoodsSn.setDeleteFlag(DeleteFlagEnum1.DELETE.getCode());
        return gsGoodsSnMapper.insertSelective(gsGoodsSn);
    }

    @Override
    public int InsertGsGoodsntrans(GsGoodsSnTransDo goodsSnTransDo) {
        Long userid = SecurityUtils.getUserId();
        GsGoodsSnTrans gsGoodsSnTrans = BeanCopyUtils.coypToClass(goodsSnTransDo, GsGoodsSnTrans.class, null);
        Date date=new Date();
        gsGoodsSnTrans.setId(Math.toIntExact(userid));
        gsGoodsSnTrans.setCreateTime(date);
        gsGoodsSnTrans.setUpdateTime(date);
        gsGoodsSnTrans.setCreateBy(Math.toIntExact(userid));
        gsGoodsSnTrans.setUpdateBy(Math.toIntExact(userid));
        return  gsGoodsSnTransMapper.insertSelective(gsGoodsSnTrans);
    }

    @Override
    public Cbib InsertCBIB(CbibDo cbibDo) {

        CbibCriteria example1 = new CbibCriteria();
        example1.createCriteria()
                .andCbib02EqualTo(cbibDo.getCbib02())
                .andCbib08EqualTo(cbibDo.getCbib08());
        List<Cbib> cbibs = cbibMapper.selectByExample(example1);
        Cbib cbib1 = selectLastOne(cbibs);

        Cbib cbib = BeanCopyUtils.coypToClass(cbibDo, Cbib.class, null);
        Date date=new Date();
        cbib.setCbib04(date);
        cbib.setCbib09(cbib1.getCbib09());
        cbib.setCbib10(cbib1.getCbib10());
        cbib.setCbib18(cbib1.getCbib18()+1);
        cbibMapper.insertSelective(cbib);
        return cbib;
    }

    @Override
    public GsGoodsSku addGsGoodsSku(GsGoodsSkuDo goodsSkuDo) {
        Date date=new Date();
        Long userid = SecurityUtils.getUserId();
        GsGoodsSku gsGoodsSku = BeanCopyUtils.coypToClass(goodsSkuDo, GsGoodsSku.class, null);
        gsGoodsSku.setCreateTime(date);
        gsGoodsSku.setUpdateTime(date);
        gsGoodsSku.setCreateBy(Math.toIntExact(userid));
        gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
        gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
        gsGoodsSku.setGoodsId(goodsSkuDo.getGoodsId());
        gsGoodsSku.setWhId(goodsSkuDo.getWhId());
        gsGoodsSku.setQty(goodsSkuDo.getQty());
        gsGoodsSku.setLocationId(goodsSkuDo.getLocationId());
           gsGoodsSkuMapper.insertSelective(gsGoodsSku);
           return gsGoodsSku;

    }

    @Override
    public GsGoodsSn addGsGoodsSn(GsGoodsSnDo goodsSnDo) {
        GsGoodsSnCriteria example1 = new GsGoodsSnCriteria();
        example1.createCriteria()
                .andSnEqualTo(goodsSnDo.getSn());
        List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example1);
        if(gsGoodsSns.size()>0){
            throw new SwException("sn码已存在才能审核");
        }
        Date date=new Date();
        Long userid = SecurityUtils.getUserId();
        GsGoodsSn gsGoodsSn = BeanCopyUtils.coypToClass(goodsSnDo, GsGoodsSn.class, null);
        gsGoodsSn.setCreateTime(date);
        gsGoodsSn.setUpdateTime(date);
        gsGoodsSn.setCreateBy(Math.toIntExact(userid));
        gsGoodsSn.setUpdateBy(Math.toIntExact(userid));
        gsGoodsSn.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
        gsGoodsSnMapper.insertSelective(gsGoodsSn);
        return gsGoodsSn;
    }

    @Override
    public GsGoodsSn updateGsGoodsSn(GsGoodsSnDo goodsSnDo) {
        Date date=new Date();
        Long userid = SecurityUtils.getUserId();
        GsGoodsSn gsGoodsSn = BeanCopyUtils.coypToClass(goodsSnDo, GsGoodsSn.class, null);
        gsGoodsSn.setUpdateTime(date);
        gsGoodsSn.setUpdateBy(Math.toIntExact(userid));

        GsGoodsSnCriteria example1 = new GsGoodsSnCriteria();
        example1.createCriteria().andSnEqualTo(goodsSnDo.getSn())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,example1);
        return gsGoodsSn;
    }

    @Override
    public GsGoodsSku updateGsGoodsSku(GsGoodsSkuDo goodsSkuDo) {
        Date date=new Date();
        Long userid = SecurityUtils.getUserId();
        GsGoodsSku gsGoodsSku = BeanCopyUtils.coypToClass(goodsSkuDo, GsGoodsSku.class, null);
        gsGoodsSku.setUpdateTime(date);
        gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
        GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
            example.createCriteria()
                .andGoodsIdEqualTo(goodsSkuDo.getGoodsId())
                .andWhIdEqualTo(goodsSkuDo.getWhId())
                .andLocationIdEqualTo(goodsSkuDo.getLocationId());
        gsGoodsSkuMapper.updateByExampleSelective(gsGoodsSku,example);
        return gsGoodsSku;
    }

    @Override
    public List<GsGoodsSku> checkGsGoodsSku(GsGoodsSkuDo goodsSkuDo) {
        GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
        example.createCriteria().andWhIdEqualTo(goodsSkuDo.getWhId())
                .andGoodsIdEqualTo(goodsSkuDo.getGoodsId())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
        return gsGoodsSkus;
    }


    public Cbib selectLastOne(List<Cbib> list) {
        Cbib card = new Cbib();

        Long dates[] = new Long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            // 把date类型的时间对象转换为long类型，时间越往后，long的值就越大，
            dates[i] = list.get(i).getCbib04().getTime();
        }

        Long maxIndex = dates[0];// 定义最大值为该数组的第一个数
        for (int j = 0; j < dates.length; j++) {
            if (maxIndex < dates[j]) {
                maxIndex = dates[j];
                // 找到了这个j
                card = list.get(j);
            }
        }
        return card;
    }


}
