package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cbpg;
import com.ruoyi.system.domain.Do.GsPurchaseOrderDo;
import com.ruoyi.system.domain.GsPurchaseOrder;
import com.ruoyi.system.domain.GsPurchaseOrderCriteria;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.GsPurchaseOrderMapper;
import com.ruoyi.system.service.IPurchaseordertableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class PurchaseordertableServiceImpl implements IPurchaseordertableService {

    @Resource
    private GsPurchaseOrderMapper purchaseOrderMapper;
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
        purchaseOrderMapper.insertSelective(gsPurchaseOrder);
        GsPurchaseOrderCriteria example = new GsPurchaseOrderCriteria();
            example.createCriteria().andOrderNoEqualTo(gsPurchaseOrderDo.getOrderNo())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<GsPurchaseOrder> gsPurchaseOrders = purchaseOrderMapper.selectByExample(example);

        IdVo idVo = new IdVo();
        idVo.setId(Math.toIntExact(gsPurchaseOrders.get(0).getId()));
        return idVo;
    }
}
