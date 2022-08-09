package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class CbshVo {

    private String cbsh07;

    private String cbsh08;


    private Integer cbsh09;

    private String cbla08;

    private String cbpb15;

    private String cbpb12;

    private String cbpb08;

    private String sn;

    private String cbla09;

    private Integer cbsj11;

    private String cbsj12;

    private String cbwa09;

    @ApiParam(value = "开始时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;
    @ApiParam(value = "结束时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;

}
