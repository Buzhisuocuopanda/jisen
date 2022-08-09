package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;
@Data
public class QualityinspectionVo {
    private Integer cbqa01;

    private String cala08;

    private String cbpb12;


    private String cbpb08;

    private Integer cbqb08;

    private String cbqb09;

    private String cbqa07;

    private Date cbqa08;

    private Integer cbqa09;

    @ApiParam(value = "开始时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;
    @ApiParam(value = "结束时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;
}
