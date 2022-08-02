package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.dto.SaleOrderSkuDto;
import com.ruoyi.system.domain.vo.SaleOrderSkuListVo;
import com.ruoyi.system.domain.vo.SaleOrderSkuVo;

import java.util.List;

/**
 * ClassName SaleOrderService
 * Description
 * Create by gfy
 * Date 2022/8/1 17:26
 */
public interface SaleOrderService {

    List<SaleOrderSkuVo> saleOrderSkuList(SaleOrderSkuDto saleOrderSkuDto);
}
