package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.Date;
@Data
public class FgkVo {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;

    private String orderNo;

    private Date orderDate;

    private Integer salerId;

    private Integer supplierId;

    private String goodsclassify;

    private Double qty;

    private Integer gsSalesOrders;

    private Byte status;

    private Integer goodsId;

    private String saleruser;

    private String supplieruser;




}
