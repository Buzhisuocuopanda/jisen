package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;
@Data
public class CbsbVo  extends BaseEntity
{
    private Integer cbsb01;

    private Date cbsb02;

    private Integer cbsb03;

    private Date cbsb04;

    private Integer cbsb05;

    private Integer cbsb06;

    private String cbsb07;

    private Date cbsb08;

    private Integer cbsb09;

    private Integer cbsb10;

    private Integer cbsb11;

    private Integer cbsb12;

    private Date cbsb13;

    private Integer cbsb14;

    private Date cbsb15;

    private Integer cbsb16;

    private String cbsb17;

    private String cbsb18;

    private String cbsb19;

    private Integer cbsb20;

    private String cbsb21;

    private String cbsb22;

    private String cbsb23;

    private String cbsb24;

    private String cbsb25;

    private String cbsb26;

    private String cbsb27;

    private String cbsb28;

    private String cbsb29;

    private String cbsb30;

    private Integer cbsb31;

    private Integer cbsb32;

    private Integer userId;

    private String cbca08;

    private Integer cbca28;

    @ApiParam(value = "开始时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;
    @ApiParam(value = "结束时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;

}
