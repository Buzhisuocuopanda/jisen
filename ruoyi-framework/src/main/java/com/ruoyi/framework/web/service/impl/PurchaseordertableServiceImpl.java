package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.enums.TaskStatus;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.GsPurchaseOrderDetailDo;
import com.ruoyi.system.domain.Do.GsPurchaseOrderDo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.CbpiMapper;
import com.ruoyi.system.mapper.GsGoodsSkuMapper;
import com.ruoyi.system.mapper.GsPurchaseOrderDetailMapper;
import com.ruoyi.system.mapper.GsPurchaseOrderMapper;
import com.ruoyi.system.service.IPurchaseordertableService;
import com.ruoyi.system.service.gson.BaseCheckService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PurchaseordertableServiceImpl implements IPurchaseordertableService {

    @Resource
    private GsPurchaseOrderMapper purchaseOrderMapper;

    @Resource
    private GsPurchaseOrderDetailMapper purchaseOrderDetailMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;

    @Resource
    private BaseCheckService baseCheckService;
    @Override
    public IdVo insertSwJsSkuBarcodes(GsPurchaseOrderDo gsPurchaseOrderDo) {

        Long userid = SecurityUtils.getUserId();
        GsPurchaseOrder gsPurchaseOrder = BeanCopyUtils.coypToClass(gsPurchaseOrderDo, GsPurchaseOrder.class, null);
        Date date = new Date();
        gsPurchaseOrder.setCreateTime(date);
        gsPurchaseOrder.setUpdateTime(date);
        gsPurchaseOrder.setCreateBy(userid);
        gsPurchaseOrder.setUpdateBy(userid);
        gsPurchaseOrder.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
        gsPurchaseOrder.setStatus(TaskStatus.mr.getCode().byteValue());
        purchaseOrderMapper.insertSelective(gsPurchaseOrder);
        GsPurchaseOrderCriteria example = new GsPurchaseOrderCriteria();
            example.createCriteria().andOrderNoEqualTo(gsPurchaseOrderDo.getOrderNo())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<GsPurchaseOrder> gsPurchaseOrders = purchaseOrderMapper.selectByExample(example);

        IdVo idVo = new IdVo();
        idVo.setId(Math.toIntExact(gsPurchaseOrders.get(0).getId()));
        return idVo;
    }

    @Override
    public int insertSwJsSkuBarcodesm(List<GsPurchaseOrderDetail> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        GsPurchaseOrderDetailMapper mapper = session.getMapper(GsPurchaseOrderDetailMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCreateTime(date);
            itemList.get(i).setCreateBy(userid);
            itemList.get(i).setUpdateTime(date);
            itemList.get(i).setUpdateBy(userid);
            itemList.get(i).setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
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

    @Override
    public int deleteSwJsSkuBarcodsById(GsPurchaseOrderDo gsPurchaseOrderDo) {
        //标记完成不可删除
        GsPurchaseOrder gsPurchaseOrder1 = purchaseOrderMapper.selectByPrimaryKey(gsPurchaseOrderDo.getId());
        Byte status = gsPurchaseOrder1.getStatus();
        int statuss = status.intValue();
        if(statuss==(TaskStatus.bjwc.getCode())){
            throw new SwException("标记未完成不可删除");
        }
        Long userid = SecurityUtils.getUserId();
        GsPurchaseOrder gsPurchaseOrder = BeanCopyUtils.coypToClass(gsPurchaseOrderDo, GsPurchaseOrder.class, null);
        Date date = new Date();
        gsPurchaseOrder.setCreateTime(date);
        gsPurchaseOrder.setUpdateTime(date);
        gsPurchaseOrder.setCreateBy(userid);
        gsPurchaseOrder.setUpdateBy(userid);
        gsPurchaseOrder.setDeleteFlag(DeleteFlagEnum1.DELETE.getCode());
        GsPurchaseOrderCriteria example = new GsPurchaseOrderCriteria();
        example.createCriteria().andIdEqualTo(gsPurchaseOrderDo.getId())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        return   purchaseOrderMapper.updateByExampleSelective(gsPurchaseOrder, example);
    }

    @Override
    public int swJsPurchasereturnordersh(GsPurchaseOrderDo gsPurchaseOrderDo) {
        //标记完成不可删除
        GsPurchaseOrder gsPurchaseOrder1 = purchaseOrderMapper.selectByPrimaryKey(gsPurchaseOrderDo.getId());
        if(!gsPurchaseOrder1.getStatus().equals(TaskStatus.mr.getCode().byteValue())){
            throw new SwException("未审核状态才能审核");
        }
        Long userid = SecurityUtils.getUserId();
        GsPurchaseOrder gsPurchaseOrder = BeanCopyUtils.coypToClass(gsPurchaseOrderDo, GsPurchaseOrder.class, null);
        Date date = new Date();
        gsPurchaseOrder.setCreateTime(date);
        gsPurchaseOrder.setUpdateTime(date);
        gsPurchaseOrder.setCreateBy(userid);
        gsPurchaseOrder.setUpdateBy(userid);
        gsPurchaseOrder.setStatus(TaskStatus.sh.getCode().byteValue());
        GsPurchaseOrderCriteria example = new GsPurchaseOrderCriteria();
        example.createCriteria().andIdEqualTo(gsPurchaseOrderDo.getId())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        return   purchaseOrderMapper.updateByExampleSelective(gsPurchaseOrder, example);
    }

    @Override
    public int swJsPurchasereturnorderfs(GsPurchaseOrderDo gsPurchaseOrderDo) {
        //标记完成不可删除
        GsPurchaseOrder gsPurchaseOrder1 = purchaseOrderMapper.selectByPrimaryKey(gsPurchaseOrderDo.getId());
        if(!gsPurchaseOrder1.getStatus().equals(TaskStatus.sh.getCode().byteValue())){
            throw new SwException("审核核状态才能反审");
        }
        Long userid = SecurityUtils.getUserId();
        GsPurchaseOrder gsPurchaseOrder = BeanCopyUtils.coypToClass(gsPurchaseOrderDo, GsPurchaseOrder.class, null);
        Date date = new Date();
        gsPurchaseOrder.setCreateTime(date);
        gsPurchaseOrder.setUpdateTime(date);
        gsPurchaseOrder.setCreateBy(userid);
        gsPurchaseOrder.setUpdateBy(userid);
        gsPurchaseOrder.setStatus(TaskStatus.mr.getCode().byteValue());
        GsPurchaseOrderCriteria example = new GsPurchaseOrderCriteria();
        example.createCriteria().andIdEqualTo(gsPurchaseOrderDo.getId())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        return   purchaseOrderMapper.updateByExampleSelective(gsPurchaseOrder, example);
    }

    @Override
    public int swJsPurchasereturnorderbjwc(GsPurchaseOrderDo gsPurchaseOrderDo) {
        //标记完成不可删除
        GsPurchaseOrder gsPurchaseOrder1 = purchaseOrderMapper.selectByPrimaryKey(gsPurchaseOrderDo.getId());
        if (!gsPurchaseOrder1.getStatus().equals(TaskStatus.sh.getCode().byteValue())) {
            throw new SwException("审核核状态才能标记完成");
        }
        Integer whId = gsPurchaseOrder1.getWhId();
        Long userid = SecurityUtils.getUserId();
        GsPurchaseOrder gsPurchaseOrder = BeanCopyUtils.coypToClass(gsPurchaseOrderDo, GsPurchaseOrder.class, null);
        Date date = new Date();
        gsPurchaseOrder.setCreateTime(date);
        gsPurchaseOrder.setUpdateTime(date);
        gsPurchaseOrder.setCreateBy(userid);
        gsPurchaseOrder.setUpdateBy(userid);
        gsPurchaseOrder.setStatus(TaskStatus.bjwc.getCode().byteValue());
        GsPurchaseOrderCriteria example = new GsPurchaseOrderCriteria();
        example.createCriteria().andIdEqualTo(gsPurchaseOrderDo.getId())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());


        GsPurchaseOrderDetailCriteria example1=new GsPurchaseOrderDetailCriteria();
        example1.createCriteria()
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode())
                .andPurchaseOrderIdEqualTo(Math.toIntExact(gsPurchaseOrderDo.getId()));
        List<GsPurchaseOrderDetail> gsPurchaseOrderDetails = purchaseOrderDetailMapper.selectByExample(example1);

        for(int i=0;i<gsPurchaseOrderDetails.size();i++) {
            int goodsid = gsPurchaseOrderDetails.get(i).getGoodsId();
            Double num = gsPurchaseOrderDetails.get(i).getQty();
            GsGoodsSkuCriteria example2 = new GsGoodsSkuCriteria();
            example2.createCriteria()
                    .andGoodsIdEqualTo(goodsid)
                    .andWhIdEqualTo(whId);
            List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example2);
        if (gsGoodsSkus.size() == 0) {
            //新增数据
            GsGoodsSku gsGoodsSku = new GsGoodsSku();
            gsGoodsSku.setCreateTime(date);
            gsGoodsSku.setUpdateTime(date);
            gsGoodsSku.setCreateBy(Math.toIntExact(userid));
            gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
            gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            gsGoodsSku.setGoodsId(goodsid);
            gsGoodsSku.setWhId(whId);
            gsGoodsSku.setQty(num);
            gsGoodsSkuMapper.insertSelective(gsGoodsSku);

        } else {
            //更新数据
            List<Integer> collect1 = gsGoodsSkus.stream().map(GsGoodsSku::getGoodsId).collect(Collectors.toList());
            int[] ints1 = collect1.stream().mapToInt(Integer::intValue).toArray();
            int id = ints1[0];
            //  Integer id1 = gsGoodsSkus.get(0).getId();
            GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);
            gsGoodsSku.setQty(gsGoodsSku.getQty() + num);
            gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
            gsGoodsSku.setUpdateTime(date);
            gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
        }
    }
        return   purchaseOrderMapper.updateByExampleSelective(gsPurchaseOrder, example);
    }

    @Override
    public int swJsPurchasereturnorderqxwc(GsPurchaseOrderDo gsPurchaseOrderDo) {
        //标记完成不可删除
        GsPurchaseOrder gsPurchaseOrder1 = purchaseOrderMapper.selectByPrimaryKey(gsPurchaseOrderDo.getId());
        if(!gsPurchaseOrder1.getStatus().equals(TaskStatus.bjwc.getCode().byteValue())){
            throw new SwException("标记完成状态才能取消完成");
        }
        Long userid = SecurityUtils.getUserId();
        GsPurchaseOrder gsPurchaseOrder = BeanCopyUtils.coypToClass(gsPurchaseOrderDo, GsPurchaseOrder.class, null);
        Date date = new Date();
        gsPurchaseOrder.setCreateTime(date);
        gsPurchaseOrder.setUpdateTime(date);
        gsPurchaseOrder.setCreateBy(userid);
        gsPurchaseOrder.setUpdateBy(userid);
        gsPurchaseOrder.setStatus(TaskStatus.bjwc.getCode().byteValue());
        GsPurchaseOrderCriteria example = new GsPurchaseOrderCriteria();
        example.createCriteria().andIdEqualTo(gsPurchaseOrderDo.getId())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        return   purchaseOrderMapper.updateByExampleSelective(gsPurchaseOrder, example);
    }
}