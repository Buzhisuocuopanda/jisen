package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

@Data
public class CbicVo extends BaseEntity {

    private Integer cbic01;
    private String cbpa07;

    private String cala08;

    private String cbpb08;

    private String cbpb12;

    private Date cbic02;
    private Integer cbic08;


    private String cbic10;

    @ApiParam(value = "开始时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;
    @ApiParam(value = "结束时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;
}
