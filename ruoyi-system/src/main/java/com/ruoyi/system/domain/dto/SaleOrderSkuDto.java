package com.ruoyi.system.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName SaleOrderSkuDto
 * Description
 * Create by gfy
 * Date 2022/8/1 17:16
 */
@Data
@ApiModel("销售库存查询")
public class SaleOrderSkuDto {

    @ApiModelProperty("销售订单号")
    private String orderNo;

    private String totalOrderNo;

    private Integer goodsId;


//    private String goodsName;
//
//    private Date startTime;
//
//    private Date endTime;

}
