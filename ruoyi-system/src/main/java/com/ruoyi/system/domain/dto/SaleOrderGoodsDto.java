package com.ruoyi.system.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName TotalOrderGoodsDto
 * Description
 * Create by gfy
 * Date 2022/8/5 13:55
 */
@Data
public class SaleOrderGoodsDto {

    private Integer goodsId;

    private Double qty;

    private BigDecimal normalPrice;

    private BigDecimal currentPrice;

    private BigDecimal totalPrice;

    private String remark;

}
