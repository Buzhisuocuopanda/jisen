package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;
@Data
public class CboeVo extends BaseEntity {

    private Integer id;

    private Integer cboe01;

    private Date cboe02;

    private Integer cboe03;

    private Date cboe04;

    private Integer cboe05;

    private Integer cboe06;

    private String cboe07;

    private Date cboe08;

    private Integer cboe10;

    private String cboe21;

    private Integer cboe09;

    private Integer userId;

    private String cbca08;

    private String caua15;



    @ApiParam(value = "开始时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;
    @ApiParam(value = "结束时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;

    private Integer cboe22;
}
