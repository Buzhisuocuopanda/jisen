package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * ClassName GoodsChangeSelectDto
 * Description
 * Create by gfy
 * Date 2022/9/21 18:33
 */
@Data
public class GoodsChangeSelectDto extends BaseSelectDto {

    @NotBlank(message = "请选择要变更的销售订单")
    private Integer orderId;

}
