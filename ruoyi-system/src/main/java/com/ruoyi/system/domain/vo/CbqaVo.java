package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

@Data
public class CbqaVo extends BaseEntity {
    private Integer cbqa01;

    private String cala08;

    private String cbpb12;


    private String cbpb08;

    private Integer cbqb08;

    private String cbqb09;

    private String cbqa07;

    private Date cbqa08;

    private Integer cbqa09;
    private Date cbqa11;
    private String cbqb10;

    private Integer cbqb01;

    @ApiParam(value = "开始时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;
    @ApiParam(value = "结束时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;

    private Integer cbpm08;

    private String cbpm09;

    private String cbpk07;


    private String f;

    private Integer cbpk01;

}
