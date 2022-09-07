package com.ruoyi.system.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * ClassName FnsalesAnalysisDto
 * Description
 * Create by gfy
 * Date 2022/9/6 11:57
 */
@Data
public class FnsalesAnalysisDto {

    //经销商id
    private Integer customerId;

    //开始时间
    private Date startTime;

    //结束时间
    private Date endTime;

    //供应商id
    private Integer supplierId;

    //型号
    private String model;

    //品牌
    private String brand;

    //销售人员id
    private String saleUserId;


}
