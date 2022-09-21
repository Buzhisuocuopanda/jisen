package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * ClassName SaleAnalysisVo
 * Description
 * Create by gfy
 * Date 2022/9/6 14:02
 */
@Data
public class SaleAnalysisVo {

    @Excel(name = "客户名称")
    private String customerName;

    @Excel(name = "下单时间")
    private String createTimeMsg;

    private Date createTime;
    @Excel(name = "供应商")
    private String supplier;
    @Excel(name = "销售人员")
    private String saleUser;
    @Excel(name = "销售订单号")
    private String saleOrderNo;
    @Excel(name = "型号")
    private String model;


    private Integer brand;
    @Excel(name = "品牌")
    private String brandName;

    @Excel(name = "数量")
    private Double qty;


    @Excel(name = "金额")
    private Double price;

    @Excel(name = "成本")
    private String cost;





}
