package com.ruoyi.system.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * ClassName OrderChangeGoodsMsgDto
 * Description
 * Create by gfy
 * Date 2022/8/10 14:02
 */
@Data
public class OrderChangeGoodsMsgDto {

    //销售订单id
    @NotBlank(message = "请选择销售订单")
    @ApiModelProperty("销售订单id")
    private Integer orderId;

    //搜索内容
    @ApiModelProperty("搜索内容")

    private String goodsText;

}
