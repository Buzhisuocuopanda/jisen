package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.enums.UseFlagEnum;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.GsGoodsSku;
import com.ruoyi.system.mapper.CbpbMapper;
import com.ruoyi.system.mapper.GsGoodsSkuMapper;
import com.ruoyi.system.service.gson.BaseCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName BaseCheckServiceImpl
 * Description
 * Create by gfy
 * Date 2022/8/1 10:17
 */
@Service
public class BaseCheckServiceImpl implements BaseCheckService {
    @Resource
    private CbpbMapper cbpbMapper;

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;

    @Override
    public Cbpb checkGoodsForUpdate(Integer goodsId, String goodsName) {
        if(goodsId==null){
            throw new SwException("请选择要下单的商品");
        }


        Cbpb cbpb = cbpbMapper.selectByPrimaryKeyForUpdate(goodsId);
        if(cbpb==null || DeleteFlagEnum.DELETE.equals(cbpb.getCbpb06())){

            throw new SwException("未找到商品："+goodsName==null?"":goodsName);
        }

        if(UseFlagEnum.JINYONG.equals(cbpb.getCbpb07())){
            throw new SwException("该商品已禁用:"+goodsName==null?"":goodsName);
        }
        return cbpb;
    }

    @Override
    public Cbpb checkGoods(Integer goodsId, String goodsName) {
        if(goodsId==null){
            throw new SwException("请选择要下单的商品");
        }


        Cbpb cbpb = cbpbMapper.selectByPrimaryKey(goodsId);
        if(cbpb==null || DeleteFlagEnum.DELETE.equals(cbpb.getCbpb06())){

            throw new SwException("未找到商品："+goodsName==null?"":goodsName);
        }

        if(UseFlagEnum.JINYONG.equals(cbpb.getCbpb07())){
            throw new SwException("该商品已禁用:"+goodsName==null?"":goodsName);
        }
        return cbpb;
    }

    @Override
    public GsGoodsSku checkGoodsSkuForUpdate(Integer Id) {
        if(Id==null){
            throw new ServiceException("请选择库存");
        }

        GsGoodsSku gsGoodsSku= gsGoodsSkuMapper.selectByPrimaryKeyForUpdate(Id);
        if(gsGoodsSku==null || DeleteFlagEnum1.DELETE.getCode().equals(gsGoodsSku.getDeleteFlag())){

            throw new ServiceException("未找到库存");
        }
        return gsGoodsSku;
    }
}
