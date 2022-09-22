package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CbpgVo  extends BaseEntity
{
    private String pinpai;

    private Integer cbph01;

    private Integer cbpg01;

    private String cbpg07;

    private Date cbpg08;
    private Long cbpg11;


    private String cbsa08;

    private String cbsa09;
    private String cbwa09;

    private String cala08;

    private String cbpb08;

    private Integer cbph08;


    private String cbpb12;

    private Double cbph09;

    private Double cbph10;

    private Double cbph11;

    private String cbph13;

    @ApiParam(value = "开始时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;
    @ApiParam(value = "结束时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;

    private String cbpb15;
    private String cbla09;
    private Integer cbpi01;

    private Integer cbpi02;

    private Date cbpi03;

    private Integer cbpi04;

    private Date cbpi05;

    private Integer cbpi06;

    private Integer cbpi07;

    private Integer cbpi08;

    private String cbpi09;

    private Integer cbpi10;

    private Integer cbpi11;

    private String cbpi12;
    private String cbpa08;
    private Integer saoma;
    private List<ScanVo> goods = new ArrayList<>();

}
