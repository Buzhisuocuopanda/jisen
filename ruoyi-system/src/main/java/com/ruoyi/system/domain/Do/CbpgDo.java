package com.ruoyi.system.domain.Do;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.Cbph;
import lombok.Data;

import java.util.Date;
@Data
public class CbpgDo extends Cbph {

    private Date cbpg08;

    private Integer cbpg09;
    @Excel(name = "日期")
    private Integer cbpg10;

    @Excel(name = "供料单位")
    private String SuppierName;

    @Excel(name = "仓库")
    private String storename;


    @Excel(name = "结算货币")
    private String moneytype;


    @Excel(name = "商品型号")
    private String goodtype;



    private Integer cbpg16;

    private Integer cbph08;
    @Excel(name = "数量")
    private Double cbph09;


    @Excel(name = "单价")
    private Double cbph10;

    @Excel(name = "备注")
    private String cbph13;





}
