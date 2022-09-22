package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CbpcVo  extends BaseEntity
{
    private Integer cbpc01;
    private Date cbpc08;

    private String cala08;

    private String cbsa08;

    private String cbwa09;

    private String cala08s;

    private String cbpb08;

    private String cbpb12;

    private String cbpb15;

    private Double cbpd09;

    private Double cbpd10;

    private Double cbpd11;

    private Double cbpd12;

    private String cbpd13;

    private String cbpa07;


    private Date cbpc02;

    private Integer cbpc03;

    private Date cbpc04;

    private Integer cbpc05;

    private Integer cbpc06;

    private String cbpc07;


    private Integer cbpc09;

    private Integer cbpc10;

    private Integer cbpc11;

    private Integer cbpc12;

    private Date cbpc13;

    private Integer cbpc14;

    private Date cbpc15;

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

    private Integer cbpd08;

    private String cbpe09;

    private Integer cbpe10;

    private String cbla09;

    private Integer cbpe01;

    private Integer cbpe02;

    private Date cbpe03;

    private Integer cbpe04;

    private Date cbpe05;

    private Integer cbpe06;

    private Integer cbpe07;

    private Integer cbpe08;


    private Integer cbpe11;

    private String cbpe12;

    @ApiParam(value = "开始时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;
    @ApiParam(value = "结束时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;

    private String cbpb09;

    private List<ScanVo> goods = new ArrayList<>();


    private Integer saoma;

}
