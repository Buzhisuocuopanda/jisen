package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;
@Data
public class CbaaVo extends BaseEntity {

    private Integer cbaa01;

    private Date cbaa02;

    private Integer cbaa03;

    private Date cbaa04;

    private Integer cbaa05;

    private Integer cbaa06;
    @Excel(name = "编号")
    private String cbaa07;
    @Excel(name = "日期")
    private Date cbaa08;
    private Integer cbaa09;
    private Integer cbaa10;

    private Integer cbaa11;

    private Integer cbaa12;

    private Date cbaa13;

    private Integer cbaa14;

    private Date cbaa15;

    private Integer cbaa16;

    private String cbaa17;

    private Integer cbaa18;

    private Integer cbaa19;

    private Integer userId;
    @Excel(name = "调出仓库")
    private String cbwa09;
    @Excel(name = "调入仓库")
    private String cbwa10;
    @Excel(name = "结算货币")
    private String cala08;
   // @Excel(name = "完成状态")
    private String overstatue;

}
