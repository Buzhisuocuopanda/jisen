package com.ruoyi.system.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName GoodsPriceAndSkuDto
 * Description
 * Create by gfy
 * Date 2022/8/9 16:11
 */
@Data
public class GoodsPriceAndSkuDto {

    @NotNull(message = "请选择货物id")
    @ApiModelProperty("商品id")
    private Integer goodsId;

    @NotNull(message = "请选择客户id")
    @ApiModelProperty("客户id")
    private Integer customerId;

    @NotNull(message = "请选择是国际订单还是国内订单")
    @ApiModelProperty("订单分类 1:国际订单 2：国内订单")
    private Integer orderClass;


    private Integer cbobId;



}
