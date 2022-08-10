package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class CbsiVo {

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
}
