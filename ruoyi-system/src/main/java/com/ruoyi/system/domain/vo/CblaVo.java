package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;
@Data
public class CblaVo {

    private Integer cbla01;

    private Date cbla02;

    private Integer cbla03;

    private Date cbla04;

    private Integer cbla05;

    private Integer cbla06;
    @Excel(name = "库位顺序")

    private Integer cbla07;

    private String cbla08;
    @Excel(name = "库位码")

    private String cbla09;

    private Integer cbla10;
    @Excel(name = "库位容量")

    private Double cbla11;
    @Excel(name = "优先型号")

    private String cbla12;

    private String cbla13;

    private String cbwa09;
}
