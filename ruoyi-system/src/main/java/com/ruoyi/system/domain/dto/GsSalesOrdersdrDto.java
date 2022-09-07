package com.ruoyi.system.domain.dto;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.GsSalesOrdersDetails;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GsSalesOrdersdrDto extends GsSalesOrdersDetails {
    @Excel(name = "日期")
    @NotBlank(message = "日期不能为空")
    private String date;

    @Excel(name = "供料单位")
    @NotBlank(message = "供料单位不能为空")
    private String supperilername;

    @Excel(name = "销售人员")
    @NotBlank(message = "销售人员不能为空")
    private String salaername;

    @Excel(name = "客户名称")
    @NotBlank(message = "客户名称不能为空")
    private String clientname;

    @Excel(name = "PONumber")
    @NotBlank(message = "PONumber不能为空")
    private String PONumber;

    @Excel(name = "商品型号")
    @NotBlank(message = "商品型号不能为空")
    private String goodstype;

    @Excel(name = "数量")
    @NotNull(message = "数量不能为空")
    private double num;

    @Excel(name = "价格")
    @NotNull(message = "价格不能为空")
    private double prices;

    @Excel(name = "备注")
    @NotNull(message = "备注不能为空")
    private String remark;


}
