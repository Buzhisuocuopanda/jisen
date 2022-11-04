package com.ruoyi.system.domain.dto;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;
@Data
public class cbaaDto {
    @Excel(name = "日期")
    private Date time;
    @Excel(name = "调出仓库")
    private String outstore;
    @Excel(name = "调入仓库")
    private String intstore;
    @Excel(name = "结算货币")
    private String current;
    @Excel(name = "供应商")
    private String supplierName;
    @Excel(name = "订单分类")
    private String orderNo;
    @Excel(name = "商品型号")
    private String goodssku;

    @Excel(name = "数量")
    private Integer num;
    @Excel(name = "单价")
    private Double price;
    @Excel(name = "备注")
    private String mark;
}
