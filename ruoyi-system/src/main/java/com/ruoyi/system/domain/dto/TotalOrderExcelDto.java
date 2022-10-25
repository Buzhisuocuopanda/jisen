package com.ruoyi.system.domain.dto;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

/**
 * ClassName TotalOrderExcelDto
 * Description
 * Create by gfy
 * Date 2022/8/5 10:22
 */
@Data
public class TotalOrderExcelDto {

    @Excel(name = "priority")
    private Long priority;

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
