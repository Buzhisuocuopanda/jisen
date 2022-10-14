package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;
@Data
public class OccuspancyVo extends BaseEntity {

    @Excel(name = "单据编号")
    private String cboa07;

    @Excel(name = "单据日期",dateFormat = "yyyy-MM-dd")
    private Date cboa08;

    @Excel(name = "客户")
    private String cbca08;

    @Excel(name = "销售人员")
    private String caua17;

    @Excel(name = "品牌")
    private String cala08;

    @Excel(name = "类型")
    private String cbpa08;

    @Excel(name = "型号")
    private String cbpb12;
    @Excel(name = "数量")
    private Double cbob09;
    @Excel(name = "已发货数量")
    private Double cbob10;

    @Excel(name = "数量")
    private Double num;

    @Excel(name = "单价")
    private Double cbob11;

    @Excel(name = "金额")
    private Double cbob12;

    private Integer cbpb01;

    private Date startTime;

    private Date endTime;

}
