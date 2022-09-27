package com.ruoyi.system.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * ClassName FnQueryGoodsSkuDto
 * Description
 * Create by gfy
 * Date 2022/9/2 15:29
 */
@Data
public class FnQueryAynthesisDto {


    //销售订单号
    private String saleOrderNo;


    //仓库名字
    private Integer whId;

    //客户名称
    private String customerName;
    //客户id
    private Integer customerId;

    //开始日期
    private Date startTime;

    //结束时间
    private Date endTime;

}
