package com.ruoyi.system.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * ClassName TakeGoodsOrderDto
 * Description
 * Create by gfy
 * Date 2022/8/10 17:10
 */
@Data
public class TakeGoodsOrderListDto {


    //编号
    private String orderNo;

    //开始日期
    private Date startTime;

    //结束日期
    private Date endTime;

    //客户
    private String customerName;

    //状态
    private Integer status;

    private String whName;

    //销售订单订单号
    private String saleOrderNo;


}
