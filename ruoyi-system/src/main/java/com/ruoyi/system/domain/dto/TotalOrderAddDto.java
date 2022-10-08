package com.ruoyi.system.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ClassName TotalOrderAddDto
 * Description
 * Create by gfy
 * Date 2022/8/3 17:06
 */
@Data
public class TotalOrderAddDto {

    @NotBlank(message = "优先级不能为空")
    @ApiModelProperty("优先级")

    private String priority;

    @NotBlank(message = "订单号不能为空")
    @ApiModelProperty("订单号")

    private String orderNo;

    @NotNull(message = "商品不能为空")
    @ApiModelProperty("商品id")

    private Integer goodsId;

    @NotNull(message = "数量不能为空")
    @ApiModelProperty("数量")

    private Double qty;

    private Integer userId;

    private Integer id;

    private Integer delete;






}
