package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;
@Data
public class CbpgVo  extends BaseEntity
{
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

}
