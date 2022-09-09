package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class GsPurchaseOrdersVo {
    private Long id;

    private String orderNo;

    private Date orderDate;

    private String cbca08;

    private String caua09;

    private String cbsa08;

    private String cbwa08;

    private String cbwa09;

    private Integer goodsId;

    private Double qty;

    private BigDecimal price;

    private String remark;

    private Double inQty;

    private Double changeQty;

    private Double surplusQty;

    private Integer purchaseOrderId;

    private String cbpb12;

    private String cbpb15;

    private String cbpb08;

}
