package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Do.GsPurchaseOrderDetailDo;
import com.ruoyi.system.domain.Do.GsPurchaseOrderDo;
import com.ruoyi.system.domain.Do.NumberDo;
import com.ruoyi.system.domain.vo.GsPurchaseOrderVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.domain.vo.NumberVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.IPurchaseordertableService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
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

    @Resource
    private NumberGenerate numberGenerate;

    @Resource
    private CbsaMapper cbsaMapper;

    @Resource
    private TaskService taskService;
    @Resource
    private GsPurchaseOrderDetailMapper gsPurchaseOrderDetailMapper;
    @Transactional
    @Override
    public IdVo insertSwJsSkuBarcodes(GsPurchaseOrderDo gsPurchaseOrderDo) {
        NumberDo numberDo=new NumberDo();
        numberDo.setType(NumberGenerateEnum.SALEORDER.getCode());
        NumberVo orderNo = numberGenerate.createOrderNo(numberDo);

        Long userid = SecurityUtils.getUserId();
        GsPurchaseOrder gsPurchaseOrder = BeanCopyUtils.coypToClass(gsPurchaseOrderDo, GsPurchaseOrder.class, null);
        Date date = new Date();
        gsPurchaseOrder.setCreateTime(date);
        gsPurchaseOrder.setUpdateTime(date);
        gsPurchaseOrder.setCreateBy(userid);
        gsPurchaseOrder.setUpdateBy(userid);
        gsPurchaseOrder.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
        gsPurchaseOrder.setStatus(TaskStatus.mr.getCode().byteValue());
        gsPurchaseOrder.setOrderNo(orderNo.getOrderNo());
        purchaseOrderMapper.insertSelective(gsPurchaseOrder);
        GsPurchaseOrderCriteria example = new GsPurchaseOrderCriteria();
            example.createCriteria().andOrderNoEqualTo(orderNo.getOrderNo())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<GsPurchaseOrder> gsPurchaseOrders = purchaseOrderMapper.selectByExample(example);

        IdVo idVo = new IdVo();
        idVo.setId(Math.toIntExact(gsPurchaseOrders.get(0).getId()));
        return idVo;
    }
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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


        GsPurchaseOrderDetailCriteria example1 = new GsPurchaseOrderDetailCriteria();
        example1.createCriteria()
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode())
                .andPurchaseOrderIdEqualTo(Math.toIntExact(gsPurchaseOrderDo.getId()));
        List<GsPurchaseOrderDetail> gsPurchaseOrderDetails = purchaseOrderDetailMapper.selectByExample(example1);

        for (int i = 0; i < gsPurchaseOrderDetails.size(); i++) {
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
            //回写更新采购订单明细
            GsPurchaseOrderDetail gsPurchaseOrderDetail = new GsPurchaseOrderDetail();
            //更新入库数量
            gsPurchaseOrderDetail.setInQty(num);
            gsPurchaseOrderDetail.setChangeQty(num);
            GsPurchaseOrderDetailCriteria example3 = new GsPurchaseOrderDetailCriteria();
            example3.createCriteria()
                    .andGoodsIdEqualTo(goodsid)
                    .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());

            gsPurchaseOrderDetailMapper.updateByExampleSelective(gsPurchaseOrderDetails.get(i), example3);

            CbibDo cbibDo = new CbibDo();
            cbibDo.setCbib02(gsPurchaseOrder1.getWhId());
            cbibDo.setCbib03(gsPurchaseOrder1.getOrderNo());
            cbibDo.setCbib05(String.valueOf(TaskType.cgdd.getCode()));
            Cbsa cbsa = cbsaMapper.selectByPrimaryKey(gsPurchaseOrder1.getSupplierId());

            cbibDo.setCbib06(cbsa.getCbsa08());
            cbibDo.setCbib07(Math.toIntExact(gsPurchaseOrderDetails.get(i).getId()));
            cbibDo.setCbib08(gsPurchaseOrderDetails.get(i).getGoodsId());
            //本次入库数量
            cbibDo.setCbib11(gsPurchaseOrderDetails.get(i).getQty());

            double v = gsPurchaseOrderDetails.get(i).getPrice().doubleValue();
            cbibDo.setCbib12(v);
            cbibDo.setCbib13((double) 0);
            cbibDo.setCbib14((double) 0);

            cbibDo.setCbib17(TaskType.xstkd.getMsg());
            cbibDo.setCbib19(gsPurchaseOrder1.getSupplierId());
            taskService.InsertCBIB(cbibDo);
        }
        //写台账



        return   purchaseOrderMapper.updateByExampleSelective(gsPurchaseOrder, example);
    }
    @Transactional
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

    @Override
    public List<GsPurchaseOrderVo> selectSwJsTaskGoodsRelLists(GsPurchaseOrderVo gsPurchaseOrderVo) {
        return purchaseOrderMapper.selectSwJsTaskGoodsRelLists(gsPurchaseOrderVo);
    }
}
