package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class UnfinishedentsVo extends BaseEntity {
    private String orderNo;

    private Byte orderType;
    private String orderMsg;
    private Date cboc08;
    private Date cboc13;

    private Integer cabraa01;

    private Date cabraa02;

    private Date cabraa03;

    private Integer cabraa04;

    private Integer cabraa05;

    private Integer cabraa06;

    private String cabraa07;

    private Integer cabraa08;

    private String cabraa09;

    private String cabraa10;

    private Integer cabraa11;

    private Date cabraa12;

    private Integer cabraa13;

    private String cabraa14;

    private Date cabraa15;

    private Integer cabraa16;

    private Integer cabraa17;

    private String cabraa18;

    private String cabraa19;

    private Integer cabraa20;

    private String cabraa21;

    @ApiModelProperty("单据开始时间")
    private Date startTime;

    //单据结束时间
    @ApiModelProperty("单据结束时间")

    private Date endTime;
}
