package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class GsSalesOrdersChangeDto  {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;

    private String orderNo;

    private Date orderDate;
    @NotNull(message = "销售人员id不能为空")
    private Integer salerId;
    @NotNull(message = "供应商id不能为空")
    private Integer supplierId;
    @NotBlank(message = "商品型号不能为空")
    private String goodsclassify;
    @NotNull(message = "数量不能为空")
    private Double qty;
    @NotNull(message = "销售预订单主表id不能为空")
    private Integer gsSalesOrders;

    private Byte status;

    private Integer goodsId;

}
