package com.ruoyi.system.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class GsOrdersInDto implements Serializable {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;

    private String orderNo;

    private Integer supplierId;

    private String supplierName;

    private Integer salerId;

    private Integer customerId;

    private String customerName;

    private Date orderDate;

    private Byte status;

    private Integer whId;

    private Integer userId;

    private Integer statuss;

    private String ponumber;

    private String factory;

    private Integer cas;

    private Integer gsid;

    private static final long serialVersionUID = 1L;

    private Date beginTime;

    private Date endTime;
}