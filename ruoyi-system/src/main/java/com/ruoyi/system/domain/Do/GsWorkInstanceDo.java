package com.ruoyi.system.domain.Do;

import lombok.Data;

import java.util.Date;

@Data
public class GsWorkInstanceDo {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;

    private String orderNo;

    private Byte orderType;

    private Byte orderClose;

    private Byte orderStatus;

    private String orderMsg;
}
