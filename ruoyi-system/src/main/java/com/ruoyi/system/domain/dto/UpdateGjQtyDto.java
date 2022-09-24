package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ClassName UpdateGjQtyDto
 * Description
 * Create by gfy
 * Date 2022/9/20 10:38
 */
@Data
public class UpdateGjQtyDto {

    @NotNull(message = "请选择要确认库存的商品明细")
    private Integer id;

    @NotBlank(message = "请选择销售订单号")
    private String saleOrderNo;

    @NotNull(message = "请填写确认库存的数量")
    private Double qty;

    @NotNull(message = "请选择商品")
    private Integer goodsId;

    private Integer userId;
}
