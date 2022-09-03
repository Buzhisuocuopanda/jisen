package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class ApprovalVo extends BaseEntity {

    private Byte orderType;

    private String orderNo;

    private Date cboa08;

    private Date cboa13;

    private String orderMsg;

}
