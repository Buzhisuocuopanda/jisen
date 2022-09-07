package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class GsSalesOrdersDetailsDto {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String createBy;

    private String updateBy;

    private String deleteFlag;
    @NotNull(message = "货物id不能为空")
    private Integer goodsId;
    @NotNull(message = "数量不能为空")
    private Double qty;

    private BigDecimal price;

    private String remark;

    private String gsSalesOrders;
}
