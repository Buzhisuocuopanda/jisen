package com.ruoyi.system.domain.Do;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.Cbif;
import lombok.Data;

import java.util.Date;
@Data
public class cbifsDo extends Cbif {
    private Integer cbie01;

    private Date cbie02;

    private Integer cbie03;

    private Date cbie04;

    private Integer cbie05;

    private Integer cbie06;

    private String cbie07;

    private Date cbie08;

    private Integer cbie09;

    private Integer cbie10;

    private Integer cbie11;

    private Date cbie12;

    private Integer cbie13;

    private Date cbie14;

    private String cbie15;

    private Integer cbie16;

    private Integer userId;

    @Excel(name = "供应商")
    private String SuppierName;
    @Excel(name = "仓库")
    private String storename;

    @Excel(name = "商品型号")
    private String goodtype;
    @Excel(name = "upc")
    private String goodupc;

    @Excel(name = "币种")
    private String moneytype;

    @Excel(name = "数量")
    private Integer cbif08;
    @Excel(name = "单价")
    private Double cbif11;
    @Excel(name = "金额")
    private Double cbif12;
}
