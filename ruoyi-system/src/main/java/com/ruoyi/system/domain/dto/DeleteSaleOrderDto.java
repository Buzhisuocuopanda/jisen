package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeleteSaleOrderDto {
    @NotNull(message = "请选择要删除的订单")
    private Integer orderId;

    private Integer userId;

}
