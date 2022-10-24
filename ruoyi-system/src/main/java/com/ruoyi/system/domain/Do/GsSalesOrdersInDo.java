package com.ruoyi.system.domain.Do;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.GsSalesOrdersIn;
import lombok.Data;

import java.util.Date;
@Data
public class GsSalesOrdersInDo extends GsSalesOrdersIn {
    @Excel(name = "客户名称")
    private String custmername;

    @Excel(name = "供料单位")
    private String SuppierName;

    @Excel(name = "结算货币")
    private String moneytype;

    @Excel(name = "销售人员")
    private String saleruser;



    @Excel(name = "日期")
    private Date date;

    @Excel(name = "PONumber")
    private String ponumber;

    @Excel(name = "商品型号")
    private String sku;

    @Excel(name = "数量")
    private Double inQty;

    @Excel(name = "单价")
    private Double price;


    @Excel(name = "备注")
    private String remark;

}
