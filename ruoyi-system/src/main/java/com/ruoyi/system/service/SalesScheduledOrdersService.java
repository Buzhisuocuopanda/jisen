package com.ruoyi.system.service;

import com.ruoyi.system.domain.Do.GsSalesOrdersDo;
import com.ruoyi.system.domain.dto.DeleteSaleOrderDto;
import com.ruoyi.system.domain.dto.GsSalesOrdersChangeDto;
import com.ruoyi.system.domain.dto.GsSalesOrdersDto;
import com.ruoyi.system.domain.dto.GsSalesOrdersInDto;
import com.ruoyi.system.domain.vo.*;

import java.util.List;

public interface SalesScheduledOrdersService {
    void addSalesScheduledOrders(GsSalesOrdersDto gsSalesOrdersDto);

    void editSalesScheduledOrders(GsSalesOrdersDto gsSalesOrdersDto);

    void deleteSalesScheduledOrders(DeleteSaleOrderDto deleteSaleOrderDto);

    List<GsSalesOrdersVo> saleOrderList(GsSalesOrdersDo gsSalesOrdersDo);

    List<GsSalesOrdersDetailsVo> saleOrderListdetail(GsSalesOrdersDetailsVo gsSalesOrdersDetailsVo);

    void SalesScheduledOrderssh(GsSalesOrdersDto gsSalesOrdersDto);

    void SalesScheduledOrdersfs(GsSalesOrdersDto gsSalesOrdersDto);

    void SalesScheduledOrdersbjwc(GsSalesOrdersDto gsSalesOrdersDto);

    void SalesScheduledOrdersqxwc(GsSalesOrdersDto gsSalesOrdersDto);

    void addSubscribetotheinventoryslip(GsSalesOrdersInDto gsSalesOrdersInDto);

    void editSubscribetotheinventoryslip(GsSalesOrdersInDto gsSalesOrdersInDto);

    void deleteSubscribetotheinventoryslip(GsSalesOrdersInDto gsSalesOrdersInDto);

    List<GsSalesOrdersInVo> seleteSubscribetotheinventoryslip(GsSalesOrdersInVo gsSalesOrdersInVo);

    void Subscribetotheinventoryslipsh(GsSalesOrdersInDto gsSalesOrdersInDto);

    void Subscribetotheinventoryslipfs(GsSalesOrdersInDto gsSalesOrdersInDto);

    void Subscribetotheinventoryslipbjwc(GsSalesOrdersInDto gsSalesOrdersInDto);

    void Subscribetotheinventoryslipqxwc(GsSalesOrdersInDto gsSalesOrdersInDto);

    void addGsSalesOrdersChange(GsSalesOrdersChangeDto gsSalesOrdersChangeDto);

    void editGsSalesOrdersChange(GsSalesOrdersChangeDto gsSalesOrdersChangeDto);

    void deleteGsSalesOrdersChange(GsSalesOrdersChangeDto gsSalesOrdersChangeDto);

    List<GsSalesOrdersChangeVo> seleteGsSalesOrdersChange(GsSalesOrdersChangeVo gsSalesOrdersChangeVo);

    void GsSalesOrdersChangesh(GsSalesOrdersChangeDto gsSalesOrdersChangeDto);

    void GsSalesOrdersChangefs(GsSalesOrdersChangeDto gsSalesOrdersChangeDto);

    void GsSalesOrdersChangebjwc(GsSalesOrdersChangeDto gsSalesOrdersChangeDto);

    void GsSalesOrdersChangeqxwc(GsSalesOrdersChangeDto gsSalesOrdersChangeDto);

    List<GsSalesOrderssVo> seleteSalesbookingsummary(GsSalesOrderssVo gsSalesOrderssVo);
}
