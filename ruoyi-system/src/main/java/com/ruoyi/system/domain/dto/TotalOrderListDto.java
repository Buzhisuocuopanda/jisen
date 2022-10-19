package com.ruoyi.system.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName TotalOrderListDto
 * Description
 * Create by gfy
 * Date 2022/8/3 15:47
 */
@Data
public class TotalOrderListDto {

    @ApiModelProperty("型号")

    //型号
    private String model;

    @ApiModelProperty("生产总订单号")

    //生产总订单号
    private String orderNo;

    @ApiModelProperty("状态 0：NO  4:OK")

    //
    private Integer status;

    private String sortKey;

    private String sortType;

}
