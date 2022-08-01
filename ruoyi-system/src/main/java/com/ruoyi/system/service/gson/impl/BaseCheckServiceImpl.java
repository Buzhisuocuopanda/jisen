package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.UseFlagEnum;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.mapper.CbpbMapper;
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

    @Override
    public Cbpb checkGoodsForUpdate(Integer goodsId, String goodsName) {
        if(goodsId==null){
            throw new ServiceException("请选择要下单的商品");
        }


        Cbpb cbpb = cbpbMapper.selectByPrimaryKeyForUpdate(goodsId);
        if(cbpb==null || DeleteFlagEnum.DELETE.equals(cbpb.getCbpb06())){

            throw new ServiceException("未找到商品："+goodsName==null?"":goodsName);
        }

        if(UseFlagEnum.JINYONG.equals(cbpb.getCbpb07())){
            throw new ServiceException("该商品已禁用:"+goodsName==null?"":goodsName);
        }
        return cbpb;
    }

    @Override
    public Cbpb checkGoods(Integer goodsId, String goodsName) {
        if(goodsId==null){
            throw new ServiceException("请选择要下单的商品");
        }


        Cbpb cbpb = cbpbMapper.selectByPrimaryKey(goodsId);
        if(cbpb==null || DeleteFlagEnum.DELETE.equals(cbpb.getCbpb06())){

            throw new ServiceException("未找到商品："+goodsName==null?"":goodsName);
        }

        if(UseFlagEnum.JINYONG.equals(cbpb.getCbpb07())){
            throw new ServiceException("该商品已禁用:"+goodsName==null?"":goodsName);
        }
        return cbpb;
    }
}
