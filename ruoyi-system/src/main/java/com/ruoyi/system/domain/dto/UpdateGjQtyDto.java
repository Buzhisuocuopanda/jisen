package com.ruoyi.system.domain.dto;

import javax.validation.constraints.NotBlank;

/**
 * ClassName UpdateGjQtyDto
 * Description
 * Create by gfy
 * Date 2022/9/20 10:38
 */
public class UpdateGjQtyDto {

    @NotBlank(message = "请选择销售订单号")
    private String saleOrderNo;

    @NotBlank(message = "请填写确认库存的数量")
    private Double qty;

}
