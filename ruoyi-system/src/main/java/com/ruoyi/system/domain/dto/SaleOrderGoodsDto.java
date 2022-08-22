package com.ruoyi.system.domain.dto;

import lombok.Data;
import org.springframework.security.web.PortResolverImpl;

import java.math.BigDecimal;

/**
 * ClassName TotalOrderGoodsDto
 * Description
 * Create by gfy
 * Date 2022/8/5 13:55
 */
@Data
public class SaleOrderGoodsDto {

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

    private String totalOrderNo;



}
