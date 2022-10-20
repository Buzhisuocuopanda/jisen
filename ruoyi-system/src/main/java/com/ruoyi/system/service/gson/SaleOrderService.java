package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.GsWorkInstance;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.*;

import java.util.List;

/**
 * ClassName SaleOrderService
 * Description
 * Create by gfy
 * Date 2022/8/1 17:26
 */
public interface SaleOrderService {

    List<SaleOrderSkuVo> saleOrderSkuList(SaleOrderSkuDto saleOrderSkuDto);

    List<TotalOrderListVo> totalOrderList(TotalOrderListDto totalOrderListDto);

    Cbba addTotalOrder(TotalOrderAddDto totalOrderAddDto);
    Cbba addTotalOrderPl(TotalOrderAddDto totalOrderAddDto);

    Cbba mdfTotalOrder(TotalOrderAddDto totalOrderAddDto);

    List<SaleOrderListVo> saleOrderList(SaleOrderListDto saleOrderListDto);

    String importTotalOrder(List<TotalOrderExcelDto> list, Long userId);

    void addSaleOrder(SaleOrderAddDto saleOrderAddDto);

    SaleOrderDetailVo saleOderDetail(Integer orderId);

    void mdfSaleOrder(SaleOrderAddDto saleOrderAddDto);

    void delSaleOrder(DelSaleOrderDto delSaleOrderDto);

    void  revokeSaleOrder(Integer orderId,Integer userId);

    String importySaleOrder(List<SaleOrderExcelDto> list, Long userId);

    void reAddSaleOrder(Integer orderId, Long userId);

    GoodsPriceAndSkuVo goodsPriceAndSku(GoodsPriceAndSkuDto goodsPriceAndSkuDto);

    void auditSaleOrder(AuditSaleOrderDto auditSaleOrderDto);

    List<SaleOrderListVo> finsaleOrderList(SaleOrderListDto saleOrderListDto);

    void auditFinSaleOrder(AuditSaleOrderDto auditSaleOrderDto);

    List<GoodsShopVo> goodsShopList(Integer userId);

    List<SaleOrderListVo> saleChangeList(SaleOrderListDto saleOrderListDto);

    void addSaleOrderChange(SaleOrderChangeDto saleOrderChangeDto);

    List<OrderChangeGoodsMsgVo> orderChangeGoodsMsg(OrderChangeGoodsMsgDto orderChangeGoodsMsgDto);

    OrderChangeDetailVo orderChangeDetail(Integer orderId);

    void mdfSaleOrderChange(SaleOrderChangeDto saleOrderChangeDto);

    void auditSaleChange(AuditSaleOrderDto auditSaleOrderDto);

    void delSaleChange(DelSaleChangeDto delSaleChangeDto);

    void printSaleOrder(Integer sqleOrderId);

    TotalOrderVo totalOrderDetail(Integer id);

    void updateGjQty(UpdateGjQtyDto updateGjQtyDto);

    void confirmSkuSaleOrder(ConfirmSkuDto confirmSkuDto);

    List<BaseSelectVo> orderlistSelect(BaseSelectDto baseSelectDto);

    List<BaseSelectVo> orderChangeGoodsSelect(BaseSelectDto baseSelectDto);

    GoodsPriceAndSkuVo goodsPriceAndSkuByOrderChange(GoodsPriceAndSkuDto goodsPriceAndSkuDto);



    void insertgoodsShop(Integer goodsId);


    List<GoodsDetailAndSkuVo> goodsShopLists(List<GoodsPriceAndSkuDto> itemList);

    void delgoodsShop(DelSaleOrderDto delSaleOrderDto);

    void initSn();

    Cbba auditTotalOrder(TotalOrderAddDto totalOrderAddDto);

    void pldelSaleOrder(DelSaleOrderDto delSaleOrderDto);

    List<SaleOrderListVo> saleOrderListPj(SaleOrderListDto saleOrderListDto);


//    GsWorkInstance createTask();

}
