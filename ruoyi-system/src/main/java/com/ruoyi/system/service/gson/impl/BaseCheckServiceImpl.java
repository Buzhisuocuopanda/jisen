package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.constant.AuditStatusConstants;
import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.UseFlagEnum;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.CbbaCriteria;
import com.ruoyi.system.domain.Cboa;
import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.Do.SaleOrderCheckDo;
import com.ruoyi.system.mapper.CbbaMapper;
import com.ruoyi.system.mapper.CbpbMapper;
import com.ruoyi.system.service.gson.BaseCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    private CbbaMapper cbbaMapper;

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

            throw new SwException("未找到商品"+goodsName==null?"":goodsName);
        }

        if(UseFlagEnum.JINYONG.equals(cbpb.getCbpb07())){
            throw new SwException("该商品已禁用"+goodsName==null?"":cbpb.getCbpb12());
        }
        return cbpb;
    }

    @Override
    public Cbba checkTotalExist(Integer goodsId, String orderNO) {

        CbbaCriteria example=new CbbaCriteria();
        example.createCriteria()
                .andCbba07EqualTo(orderNO)
                .andCbba08EqualTo(goodsId)
                .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbba> cbbas = cbbaMapper.selectByExample(example);
        if(cbbas.size()>0){
            return cbbas.get(0);
        }else {
            return null;
        }


    }

    @Override
    public Boolean saleOrderStatusChekc(SaleOrderCheckDo saleOrderCheckDo) {
        //0：未提交  1：已提交 2：已审核 4:已完成 6：指定结束  5已复审

        //已提交状态下才能审核
        Cboa cboa = saleOrderCheckDo.getCboa();
        if(saleOrderCheckDo.getOperateType().equals(AuditStatusConstants.SO_COMMIT)){
            if(!cboa.getCboa11().equals(AuditStatusConstants.SO_NO_COMMIT)){
                throw new SwException("该订单必须为未提交状态才能提交");
            }
        }else if(saleOrderCheckDo.getOperateType().equals(AuditStatusConstants.SO_REVIEWWD)){
            if(!cboa.getCboa11().equals(AuditStatusConstants.SO_COMMIT)){
                throw new SwException("该订单必须为已提交状态才能审核");
            }
        }else if(saleOrderCheckDo.getOperateType().equals(AuditStatusConstants.SO_TWO_REV)){
            if(!cboa.getCboa11().equals(AuditStatusConstants.SO_COMMIT)){
                throw new SwException("该订单必须为已审核状态才能复核");
            }
        }else if(saleOrderCheckDo.getOperateType().equals(AuditStatusConstants.SO_COMPLETED)){
            if(!cboa.getCboa11().equals(AuditStatusConstants.SO_TWO_REV)){
                throw new SwException("该订单必须为已复审状态才能标记完成");
            }
        }


        return true;
    }


}
