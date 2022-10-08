package com.ruoyi.system.domain.dto;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class InwuquDto extends BaseEntity {
    @Excel(name = "大类")
    private String totalclassify;
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
    private Double cbif09;


    private String cbwa09;
    private String[] cbwa09s;

    @Excel(name = "可用库存数量")
    private Double lockQty;
    private Integer cbpb01;

    private Integer cbpb10;
//    @Excel(name = "分类id")
    private Integer classId;

    private Long userId;

    private Long deptId;

}
