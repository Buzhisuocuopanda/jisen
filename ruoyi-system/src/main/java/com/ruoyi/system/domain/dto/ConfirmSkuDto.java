package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName ConfirmSkuDto
 * Description
 * Create by gfy
 * Date 2022/9/20 14:34
 */
@Data
public class ConfirmSkuDto {
    @NotNull(message = "请选择订单")
    private Integer id;

    //1.确认库存 2取消确认
    @NotNull(message = "请选择操作类型")
    private Integer opearte;

    private Integer userId;

}
