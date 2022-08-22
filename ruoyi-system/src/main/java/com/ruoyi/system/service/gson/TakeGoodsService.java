package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.dto.AuditTakeOrderDto;
import com.ruoyi.system.domain.dto.TakeGoodsOrderAddDto;
import com.ruoyi.system.domain.dto.TakeGoodsOrderListDto;
import com.ruoyi.system.domain.vo.TakeGoodsOrderDetailVo;
import com.ruoyi.system.domain.vo.TakeGoodsOrderListVo;
import com.ruoyi.system.domain.vo.TakeOrderDetailVo;

import java.util.List;

/**
 * ClassName TakeGoodsService
 * Description
 * Create by gfy
 * Date 2022/8/10 17:51
 */
public interface TakeGoodsService {
    List<TakeGoodsOrderListVo> takeOrderList(TakeGoodsOrderListDto takeGoodsOrderListDto);

    void addTakeGoodsOrder(TakeGoodsOrderAddDto takeGoodsOrderAddDto);

    TakeGoodsOrderDetailVo takeOrderDetail(Integer id);

    TakeGoodsOrderDetailVo takeOrderDetailBySaleId(Integer saleOrderId,Integer whId);

    void mdfTakeGoodsOrder(TakeGoodsOrderAddDto takeGoodsOrderAddDto);

    void delTakeGoodsOrder(Integer id, Long userId);

    void auditTakeOrder(AuditTakeOrderDto auditTakeOrderDto);
}
