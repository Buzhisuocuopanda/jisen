package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.enums.GoodsType;
import com.ruoyi.common.enums.Groudstatus;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.dto.TakeGoodsOrderListDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.CbpkVo;
import com.ruoyi.system.domain.vo.TakeGoodsOrderListVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISellinglistingsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SellinglistingsServiceImpl implements ISellinglistingsService {

@Resource
private GsGoodsSnMapper goodsSnMapper;

@Resource
private CbpmMapper cbpmMapper;

    @Resource
    private CbpkMapper cbpkMapper;

@Resource
private CblaMapper cblaMapper;

@Resource
private CbpbMapper cbpbMapper;
    @Transactional
    @Override
    public int insertSwJsSkuBarcodes(GsGoodsSnDo goodsSnDo) {


CbpmCriteria cbpmCriteria = new CbpmCriteria();
        cbpmCriteria.createCriteria().andCbpm09EqualTo(goodsSnDo.getSn());
        List<Cbpm> cbpmList = cbpmMapper.selectByExample(cbpmCriteria);
        if (cbpmList.size() == 0) {
            throw new SwException("该sn不存在于销售提货单");
        }
        if(cbpmList.get(0).getCbpk01()==null){
            throw new SwException("销售提货单主键id为空");
        }
        Cbpk cbpk = cbpkMapper.selectByPrimaryKey(cbpmList.get(0).getCbpk01());
        if(cbpk.getCbpk11()!=2){
            throw new SwException("该销售提货单不是审核状态");
        }
        if(goodsSnDo.getSn()!=null) {
            GsGoodsSnCriteria gsGoodsSnCriteria = new GsGoodsSnCriteria();
            gsGoodsSnCriteria.createCriteria().andSnEqualTo(goodsSnDo.getSn());
            List<GsGoodsSn> gsGoodsSns = goodsSnMapper.selectByExample(gsGoodsSnCriteria);
            if(gsGoodsSns.size()>0){
                Cbpb cbpb = cbpbMapper.selectByPrimaryKey(gsGoodsSns.get(0).getGoodsId());
                if(Objects.equals(cbpb.getCbpb12(), goodsSnDo.getSn())){
                    throw new SwException("sn不正确");
                }
            }
        }

        if(goodsSnDo.getLocationId()==null){
            throw new SwException("库位不能为空不能为空");
        }
        GsGoodsSnCriteria criterisa = new GsGoodsSnCriteria();
        criterisa.createCriteria().andSnEqualTo(goodsSnDo.getSn());
        List<GsGoodsSn> gsGoodssSns = goodsSnMapper.selectByExample(criterisa);
        if(gsGoodssSns.size()==0){
            throw new SwException("该条码已存在");
        }


        Cbla cbla = cblaMapper.selectByPrimaryKey(goodsSnDo.getLocationId());
        if(!gsGoodssSns.get(0).getWhId().equals(cbla.getCbla10())){
            throw new SwException("该条码不属于该库位");
        }



        if(goodsSnDo.getSn()==null){
                throw new SwException("SN不能为空");
        }


        GsGoodsSnCriteria example1 = new GsGoodsSnCriteria();
        example1.createCriteria().andSnEqualTo(goodsSnDo.getSn());
        List<GsGoodsSn> gsGoodsSns = goodsSnMapper.selectByExample(example1);
        if(gsGoodsSns.size()==0){
            throw new SwException("SN不存在");
        }
        if(gsGoodsSns.get(0).getGroudStatus()!=null){
            if(gsGoodsSns.get(0).getGroudStatus()==1){
                throw new SwException("SN已经上架");
            }
        }

        if(gsGoodsSns.get(0).getLocationId()!=null){
            throw new SwException("该SN已经绑定库位");
        }


        Long userid = SecurityUtils.getUserId();
        GsGoodsSn goodsSn = BeanCopyUtils.coypToClass(goodsSnDo, GsGoodsSn.class, null);
        Date date = new Date();
        goodsSn.setStatus(GoodsType.yrk.getCode());
        goodsSn.setUpdateTime(date);
        goodsSn.setUpdateBy(Math.toIntExact(userid));
        goodsSn.setGroudStatus(Groudstatus.SJ.getCode());

        goodsSn.setLocationId(goodsSnDo.getLocationId());
        GsGoodsSnCriteria example = new GsGoodsSnCriteria();
        example.createCriteria().andSnEqualTo(goodsSnDo.getSn());
         goodsSnMapper.updateByExampleSelective(goodsSn, example);
        return 1;
    }

    @Override
    public List<TakeGoodsOrderListVo> selectSwJsTaskGoodsRelLists(TakeGoodsOrderListDto takeGoodsOrderListDto) {
        return      goodsSnMapper.selectSwJsTaskGoodsRelLists(takeGoodsOrderListDto);
    }
    @Transactional
    @Override
    public int deleteSwJsSkuBarcodes(GsGoodsSnDo goodsSnDo) {
        Long userid = SecurityUtils.getUserId();
        GsGoodsSn goodsSn = BeanCopyUtils.coypToClass(goodsSnDo, GsGoodsSn.class, null);
        Date date = new Date();
        goodsSn.setUpdateTime(date);
        goodsSn.setUpdateBy(Math.toIntExact(userid));
        goodsSn.setDeleteFlag(DeleteFlagEnum1.DELETE.getCode());
        GsGoodsSnCriteria example = new GsGoodsSnCriteria();
        example.createCriteria().andIdEqualTo(goodsSnDo.getId())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        return      goodsSnMapper.updateByExampleSelective(goodsSn, example);    }


}
