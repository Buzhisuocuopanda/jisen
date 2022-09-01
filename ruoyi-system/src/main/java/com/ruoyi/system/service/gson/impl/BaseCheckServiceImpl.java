package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.constant.AuditStatusConstants;
import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.UseFlagEnum;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.CbbaCriteria;
import com.ruoyi.system.domain.Cboa;
import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.Do.SaleOrderCheckDo;
import com.ruoyi.system.domain.vo.GoodsCheckStockVo;
import com.ruoyi.system.mapper.CbbaMapper;
import com.ruoyi.system.mapper.CbpbMapper;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.vo.CbpdVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.gson.BaseCheckService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;
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
    private CbpcMapper cbpcMapper;
    @Resource
    private CbsaMapper cbsaMapper;
    @Resource
    private CbpbMapper cbpbMapper;

    @Resource
    private CbbaMapper cbbaMapper;

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
    @Resource
    private CbcaMapper cbcaMapper;

    @Resource
    private CboaMapper cboaMapper;

    @Override
    public Cbpb checkGoodsForUpdate(Integer goodsId, String goodsName) {
        if(goodsId==null){
            throw new SwException("请选择要下单的商品");
        }


        Cbpb cbpb = cbpbMapper.selectByPrimaryKeyForUpdate(goodsId);
        if(cbpb==null || DeleteFlagEnum.DELETE.equals(cbpb.getCbpb06())){

            throw new SwException("未找到商品");
        }

        if(UseFlagEnum.JINYONG.equals(cbpb.getCbpb07())){
            throw new SwException("该商品已禁用");
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
            if(goodsName!=null){
                throw new SwException("该货物不可用"+goodsName);
            }else {
                throw new SwException("该货物不可用");
            }

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
        String s1 = auditPerm.toString();

        String s = auditPerm1.toString();
        String[] split = s.split(",");
        Set<String> set = new HashSet<String>(Arrays.asList(split));

        if(!set.contains(s1)){
            throw new SwException("没有审核权限：");
        }
        return sysUser;
    }


    @Override
    public GsGoodsSku checkGoodsSku(Integer goodsId, Integer storeId) {
        if(goodsId==null ||storeId==null){
            throw new SwException("商品id不能为空");
        }
        GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
        example.createCriteria().andGoodsIdEqualTo(goodsId)
                                .andWhIdEqualTo(storeId);
        List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
        if(gsGoodsSkus.size()>0){
            throw new SwException("已有库存不能为删除");

        }
        return null;
    }
    //模糊查询品牌型号描述
    @Override
    public CbpdVo selectgoodsinfo(CbpdVo cbpdVo) {
        return cbpdMapper.selectgoodsinfo(cbpdVo);
    }

    @Override
    public Cbca checkCustomer(Integer customerId) {
        Cbca cbca = cbcaMapper.selectByPrimaryKey(customerId);
        if(cbca==null || DeleteFlagEnum.DELETE.getCode().equals(cbca.getCbca06())){
            throw new SwException("没有查到该客户");

        }

        if(!"启用".equals(cbca.getCbca07())){
            throw new SwException("该客户已禁用");
        }

        return cbca;
    }

    @Override
    public Cboa checkSaleOrder(Integer orderId) {

        Cboa cboa = cboaMapper.selectByPrimaryKey(orderId);
        if(cboa==null || !DeleteFlagEnum.NOT_DELETE.equals(cboa.getCboa06())){
            throw new SwException("没有查到该销售订单订单");
        }

        return cboa;
    }


}



