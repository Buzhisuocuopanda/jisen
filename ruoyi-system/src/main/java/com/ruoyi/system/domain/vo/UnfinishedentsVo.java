package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;
@Data
public class UnfinishedentsVo extends BaseEntity {
    private String orderNo;

    private Byte orderType;
    private String orderMsg;
    private Date cboc08;
    private Date cboc13;

}
