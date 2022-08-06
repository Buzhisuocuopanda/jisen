package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.SaleOrderListVo;
import com.ruoyi.system.domain.vo.SaleOrderSkuListVo;
import com.ruoyi.system.domain.vo.SaleOrderSkuVo;
import com.ruoyi.system.domain.vo.TotalOrderListVo;

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

    Cbba mdfTotalOrder(TotalOrderAddDto totalOrderAddDto);

    List<SaleOrderListVo> saleOrderList(SaleOrderListDto saleOrderListDto);

    String importTotalOrder(List<TotalOrderExcelDto> list, Long userId);

    void addSaleOrder(SaleOrderAddDto saleOrderAddDto);
}
