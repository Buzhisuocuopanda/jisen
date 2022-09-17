package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName TotalOrderExportTmpVo
 * Description
 * Create by gfy
 * Date 2022/9/15 17:43
 */
@Data
public class TotalOrderExportTmpVo {

    @Excel(name = "priority")
    private String priority;

    @Excel(name = "PoNumber")
    private String orderNo;

    @Excel(name = "SKU")
    private String model;
    @Excel(name = "Description")
    private String description;
    @Excel(name = "PO Qty")
    private Double orderQty;

    @Excel(name = "Allocated Qty")
    private String makeQty;

    @Excel(name = "Situation")
    private Integer status;

}
