package com.ruoyi.system.domain.dto;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

/**
 * ClassName SaleOrderExcelDto
 * Description
 * Create by gfy
 * Date 2022/8/8 17:28
 */
@Data
public class SaleOrderExcelDto {

    @Excel(name = "日期")
    private String date;

    @Excel(name = "客户")
    private String customerName;


    @Excel(name = "订单类型")
    private String orderType;

    @Excel(name = "总订单号")
    private String totalOrderNo;

    @Excel(name = "SKU")
    private String sku;



    @Excel(name = "Release Quantity")
    private Double qty;

    @Excel(name = "本次单价")
    private Double price;

    @Excel(name = "备注")
    private String remark;

}
