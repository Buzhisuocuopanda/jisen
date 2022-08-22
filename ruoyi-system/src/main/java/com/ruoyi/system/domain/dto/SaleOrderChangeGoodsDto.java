package com.ruoyi.system.domain.dto;

import lombok.Data;

/**
 * ClassName SaleOrderChangeGoodsDto
 * Description
 * Create by gfy
 * Date 2022/8/10 10:27
 */
@Data
public class SaleOrderChangeGoodsDto {
    //行号
    private Integer number;

    //货物id
    private Integer goodsId;

    //货物数量
    private Double qty;

    //标准价格
    private Double normalPrice;

    //本次单价
    private Double currentPrice;
    //金额
    private Double totalPrice;
    //备注
    private String remark;



}
