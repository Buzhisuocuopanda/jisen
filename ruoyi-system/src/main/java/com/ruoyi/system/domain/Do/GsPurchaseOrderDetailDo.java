package com.ruoyi.system.domain.Do;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class GsPurchaseOrderDetailDo{
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;

    private Integer goodsId;

    private Double qty;

    private BigDecimal price;

    private String remark;

    private Double inQty;

    private Double changeQty;

    private Double surplusQty;

    private Integer purchaseOrderId;
}
