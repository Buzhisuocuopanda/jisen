package com.ruoyi.system.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName DelSaleOrderDto
 * Description
 * Create by gfy
 * Date 2022/8/8 15:08
 */
@Data
public class DelSaleOrderDto {

    @NotNull(message = "请选择要删除的订单")
    @ApiModelProperty("销售订单id")
    private Integer orderId;

    private Integer userId;

}
