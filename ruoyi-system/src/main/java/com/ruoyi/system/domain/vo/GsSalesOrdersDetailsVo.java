package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class GsSalesOrdersDetailsVo extends BaseEntity {

    private Integer detailId;
    private Integer id;

    private Integer goodsId;

    private Double qty;

    private BigDecimal price;

    private String remark;

    private String gsSalesOrders;

    private String orderNo;

    private String saler;

    private String salerMag;

    private String supplier;

    private String supplierMge;

    private String customer;

    private String customerMag;

    private Date orderDate;

    private Byte status;

    private String wh;

    private Integer whId;

    //商品描述
    private String cbpb08;

    //商品品牌id
    private String cbpb10;

    //商品品牌名称
    private String cala08;

    //商品型号
    private String cbpb12;

    //
    private String cbwa09;



}
