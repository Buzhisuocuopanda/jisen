package com.ruoyi.system.domain.dto;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.Cbpd;
import lombok.Data;

import java.util.Date;
@Data
public class CbpcDto extends Cbpd {
    private Integer cbpc01;

    private Date cbpc02;

    private Integer cbpc03;

    private Date cbpc04;

    private Integer cbpc05;

    private Integer cbpc06;

    private String cbpc07;
    @Excel(name = "日期")

    private Date cbpc08;
    @Excel(name = "供料单位")
    private String SuppierName;

    private Integer cbpc09;
    @Excel(name = "仓库")
    private String storename;

    private Integer cbpc10;

    private Integer cbpc11;

    private Integer cbpc12;

    private Date cbpc13;

    private Integer cbpc14;

    private Date cbpc15;
    @Excel(name = "结算货币")
    private String moneytype;

    private Integer cbpc16;

    private String cbpc17;

    private Integer userId;

    private Integer cbpd01;

    private Integer cbpd02;

    private Date cbpd03;

    private Integer cbpd04;

    private Date cbpd05;

    private Integer cbpd06;

    private Integer cbpd07;
    @Excel(name = "商品型号")
    private String goodtype;

    private Integer cbpd08;
    @Excel(name = "数量")

    private Double cbpd09;

    private Double cbpd10;
    @Excel(name = "单价")
    private Double cbpd11;

    private Double cbpd12;
    @Excel(name = "备注")
    private String cbpd13;


}
