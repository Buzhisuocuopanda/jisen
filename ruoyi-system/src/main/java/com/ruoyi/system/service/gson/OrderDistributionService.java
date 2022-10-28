package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.dto.DirectWarehousingDto;
import com.ruoyi.system.domain.vo.*;

/**
 * ClassName OrderDistributionService
 * Description 订单分配占用逻辑接口服务
 * Create by gfy
 * Date 2022/7/27 9:18
 */

public interface OrderDistributionService {
    /**
     * 生产订单主要是分配和占用
     * 不良品仓不参与分配
     * 当货物直接入库或者采购入库的时候 会按照优先级（数字越小优先级越高）进行总订单数量分配
     *
     *销售出库，要修改优先级最高的（国内订单对应国内总订单，国际订单对应国际订单）总订单的分配数量 回写总订单的发货数量
     * 采购出库或者调拨到不良品仓的时候要修改优先级最低的分配数量
     * 销售下单国内订单：根据订单类型按照优先级来回写已占用数量和现有订单数量
     * 国际订单，确认库存后根据订单号回写占用数量和现有订单数量
     */


    /**
     * 重新分配逻辑 用于创建新的总订单，和修改优先级使用
     * @param orderDistributionDo
     */
    Cbba reassign(OrderDistributionDo orderDistributionDo);


    /**
     * 采购订单入库逻辑
     * @param orderDistributionDo
     */
//    Cbba purhaseOrderWarehousing(OrderDistributionDo orderDistributionDo);


    /**
     * 采购入库逻辑
     * @param orderDistributionDo
     */
//    Cbba purchaseWarehousing(OrderDistributionDo orderDistributionDo);

    /**
     * 直接入库逻辑
     * @param directWarehousingDto
     */
    DirectWarehousingVo directWarehousing(DirectWarehousingDto directWarehousingDto);


    /**
     * 采购出库
     */

//    Cbba purchaseExit(OrderDistributionDo orderDistributionDo);
    /**
     * 销售订单出库
     */

    SaleOrderExitVo saleOrderExit(SaleOrderExitDo saleOrderExitDo);


    /**
     * 调拨单入库良品仓
     */

    TransferOrderVo transferOrder(TransferOrderDo transferOrderDo);


    /**
     * 销售订单下单占用库存逻辑
     * @param goodsOperationDo
     * @return
     */
    SaleOrderMakeDo saleOrderMake(GoodsOperationDo goodsOperationDo);
    /**
     * 释放占用
     * @param goodsOperationDo
     * @return
     */
    Integer cancelOccupy(GoodsOperationDo goodsOperationDo);


    /**
     * 检查商品可用库存
     * @param checkSkuDo
     * @return
     */

    QtyMsgVo checkSku(CheckSkuDo checkSkuDo);


    /**
     * 修改库存占用（国际订单）
     * @param changeSkuUseDo
     * @return
     */
    ChangeSkuUseVo changeSkuUse(ChangeSkuUseDo changeSkuUseDo);



    Boolean diaoboUseOp(TranUseQtyDo tranUseQtyDo);


}
