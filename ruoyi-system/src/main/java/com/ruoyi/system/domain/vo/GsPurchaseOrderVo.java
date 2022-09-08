package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.Date;
@Data
public class GsPurchaseOrderVo {

    private Long id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;

    private String orderNo;

    private Date orderDate;

    private Integer customerId;

    private Integer salerId;

    private Integer supplierId;

    private Byte status;

    private Integer whId;

    private Integer userId;
}
