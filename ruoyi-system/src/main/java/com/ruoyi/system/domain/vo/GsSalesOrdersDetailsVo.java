package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class GsSalesOrdersDetailsVo extends BaseEntity {

    private Integer id;

    private Integer goodsId;

    private Double qty;

    private BigDecimal price;

    private String remark;

    private String gsSalesOrders;

    private String orderNo;

    private String supplier;

    private String saler;

    private String customer;

    private Date orderDate;

    private Byte status;

    private String wh;

}
