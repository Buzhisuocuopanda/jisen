package com.ruoyi.system.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.web.PortResolverImpl;

/**
 * ClassName SaleOrderChangeDetailGoods
 * Description
 * Create by gfy
 * Date 2022/8/10 15:04
 */
@Data
public class SaleOrderChangeDetailGoods {

    private Integer id;

    //品牌
    @ApiModelProperty("品牌")
    private String brand;
    //型号
    @ApiModelProperty("型号")

    private String model;
    //描述
    @ApiModelProperty("描述")

    private String description;

    //数量
    @ApiModelProperty("数量")

    private Double qty;
    //标准单价
    @ApiModelProperty("标准单价")

    private Double normPrice;
    //本次单价
    @ApiModelProperty("本次单价")

    private Double currentPrice;
    //金额
    @ApiModelProperty("金额")

    private Double totalPrice;
    //备注
    @ApiModelProperty("备注")

    private String remark;

    //修改前价格
    @ApiModelProperty("修改前价格")

    private Double bfPrice;

    //修改前数量
    @ApiModelProperty("修改前数量")

    private Double bfQty;



}
