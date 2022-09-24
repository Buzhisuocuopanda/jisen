package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;

@Data
public class OutofstockregistrationVo {
    @Excel(name = "大类")
    private String cbpa08;

    @Excel(name = "分类名称")
    private String cbpa07;

    @Excel(name = "品牌")
    private String cala08;

    @Excel(name = "型号")
    private String cbpb12;

    @Excel(name = "UPC")
    private String cbpb15;

    @Excel(name = "描述")
    private String cbpb08;

    @Excel(name = "数量")
    private Double cbof09;

    @Excel(name = "客户")
    private String cbca08;

    @Excel(name = "日期",dateFormat = "yyyy-MM-dd")
    private Date cboe08;

    private Integer cbpb01;

}
