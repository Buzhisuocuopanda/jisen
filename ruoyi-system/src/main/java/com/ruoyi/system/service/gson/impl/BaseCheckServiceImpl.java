package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.gson.BaseCheckService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName BaseCheckServiceImpl
 * Description
 * Create by gfy
 * Date 2022/8/1 10:17
 */
@Service
public class BaseCheckServiceImpl implements BaseCheckService {
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
    private CbwaMapper cbwaMapper;
    @Resource
    private SysUserMapper sysUserMapper;

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

    @Override
    public Cbsa checksupplier(Integer supplierid) {
        if(supplierid==null){
            throw new SwException("请选择供应商");
        }

        Cbsa cbsa = cbsaMapper.selectByPrimaryKey(supplierid);
        if(cbsa==null || DeleteFlagEnum.DELETE.getCode().equals(cbsa.getCbsa06())){

            throw new SwException("未找到供应商");
        }
        return cbsa;
    }

    @Override
    public Cbwa checkStore(Integer Storeid) {
        if(Storeid==null){
            throw new SwException("请选择仓库");
        }

        Cbwa cbwa = cbwaMapper.selectByPrimaryKey(Storeid);
        if(cbwa==null || DeleteFlagEnum.DELETE.getCode().equals(cbwa.getCbwa06())){

            throw new SwException("未找到仓库");
        }
        return cbwa;
    }

    @Override
    public Cbpb checkGoods(Integer goodsId) {
        if(goodsId==null){
            throw new SwException("请选择要下单的商品");
        }


        Cbpb cbpb = cbpbMapper.selectByPrimaryKey(goodsId);
        if(cbpb==null || DeleteFlagEnum.DELETE.getCode().equals(cbpb.getCbpb06())){

            throw new SwException("未找到商品：");
        }

        if(UseFlagEnum.JINYONG.getCode().equals(cbpb.getCbpb07())){
            throw new SwException("该商品已禁用:");
        }
        return cbpb;
    }

    @Override
    public SysUser checkUserTask(Long userId,Byte auditPerm) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        Byte auditPerm1 = sysUser.getAuditPerm();
        String s = auditPerm1.toString();
        String s1 = auditPerm.toString();
        if(!s.contains(s1)){
            throw new SwException("没有审核权限：");
        }
        return sysUser;
    }
}



