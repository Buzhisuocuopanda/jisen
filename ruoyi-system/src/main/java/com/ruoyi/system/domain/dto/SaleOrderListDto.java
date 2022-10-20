package com.ruoyi.system.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName SaleOrderListDto
 * Description
 * Create by gfy
 * Date 2022/8/4 16:23
 */
@Data
public class SaleOrderListDto {

    //单据开始时间
    @ApiModelProperty("单据开始时间")
    private Date startTime;

    //单据结束时间
    @ApiModelProperty("单据结束时间")

    private Date endTime;
    @ApiModelProperty("单据状态")
    private Integer status;

    //单据号
    @ApiModelProperty("单据号")

    private String orderNo;

    //客户名称
    @ApiModelProperty("客户名称")

    private String customer;

    //订单分类 1：国际订单 2：国内订单
    @ApiModelProperty("订单分类 1：国际订单 2：国内订单 " )

    private Integer type;

    //销售订单编号
    @ApiModelProperty("销售订单编号")

    private String saleNo;





}
