package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CbaasVo {

    private String pinpai;


    private Integer cbab01;

    private Integer cbsa01;

    private Integer cbaa01;

    private String cbaa07;

    private Date cbaa08;

    private String cbwa09;

    private String cbwa10;

    private String cala08;
    private String cbsa08;

    private Integer cbab15;

    private Integer cbpb01;


    private String cbpb08;

    private Integer cbpb10;


    private String cbpb12;

    private String cbpb15;


    private Double cbab09;

    private Integer cbab08;

    private Double cbab11;

    private Double cbab12;

    private String cbab13;

    private String cbpa08;

    private String cbac09;

    private String cbla09;


    private Integer saoma;
    private List<ScanVo> goods = new ArrayList<>();

    private String orderClass;

    private Integer cbaa09;

    private Integer cbaa10;

}
