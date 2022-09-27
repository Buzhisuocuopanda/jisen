package com.ruoyi.system.domain.dto;

import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName TakeGoodsOrderDto
 * Description
 * Create by gfy
 * Date 2022/8/10 17:10
 */
@Data
public class TakeGoodsOrderListDto extends BaseEntity {


    //编号
    @ApiModelProperty("编号")
    private String orderNo;

    //开始日期
    @ApiModelProperty("开始日期")
    private Date startTime;

    //结束日期
    @ApiModelProperty("结束日期")
    private Date endTime;

    //客户
    @ApiModelProperty("客户")
    private String customerName;

    //状态
    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("仓库名称")
    private Integer whName;

    //销售订单订单号
    @ApiModelProperty("销售订单订单号")
    private String saleOrderNo;


}
