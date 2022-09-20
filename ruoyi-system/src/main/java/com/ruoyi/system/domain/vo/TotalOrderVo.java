package com.ruoyi.system.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ClassName TotalOrderVo
 * Description
 * Create by gfy
 * Date 2022/9/19 17:44
 */
@Data
public class TotalOrderVo {

    @ApiModelProperty("优先级")

    private String priority;

    @ApiModelProperty("订单号")

    private String orderNo;

    @ApiModelProperty("商品id")

    private Integer goodsId;

    private String goods;

    @ApiModelProperty("数量")

    private Double qty;



}
