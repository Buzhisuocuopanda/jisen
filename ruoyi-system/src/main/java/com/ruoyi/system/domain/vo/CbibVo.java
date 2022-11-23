package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;
import org.apache.poi.ss.formula.functions.Count;

import java.util.Date;

@Data
public class CbibVo {
    @Excel(name = "月份")
    private String yearAndMonth;

    private Integer cbib01;

    private Integer cbib02;

    private String cbib03;

    private Date cbib04;

    private String cbib05;

    private String cbib06;

    private Integer cbib07;

    private Integer cbib08;

    private Double cbib09;

    private Double cbib10;

    private Double cbib11;

    private Double cbib12;

    private Double cbib13;

    private Double cbib14;

    private Double cbib15;

    private Double cbib16;

    private String cbib17;

    private Integer cbib18;

    private Integer cbib19;

    private Integer num;
    @Excel(name = "仓库")
    private String winName;
    @Excel(name = "型号")
    private String cbpb12;
    @Excel(name = "商品")
    private String goodsName;

    @Excel(name = "入库数量")
    private Double inCount;
    @Excel(name = "出库数量")
    private Double outCount;

    @Excel(name = "采购退库数量")
    private Double cgOutCount;

    @Excel(name = "产出差")
    private Double outPutCount;

    private String[] monthlys;

}
