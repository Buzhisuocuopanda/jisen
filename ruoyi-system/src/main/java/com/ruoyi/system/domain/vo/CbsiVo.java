package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

@Data
public class CbsiVo extends BaseEntity
{
    private String cbsh07;

    private Date cbsh08;

    private Integer cbsh09;

    private Integer cbsh10;

    private String cala08;

    private String cbpb15;

    private String cbpb12;

    private String cbpb08;

    private Double cbsi09;

    private Double cbsi10;

    private String cbsi11;

    private String cbwa09;

    @ApiParam(value = "开始时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;
    @ApiParam(value = "结束时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;


    private Integer cbsh01;

}
