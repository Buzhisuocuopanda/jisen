package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class GsSalesOrdersChangeVo extends BaseEntity {
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

    private String caua17;


    private String cbsa08;
}
