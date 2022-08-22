package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ClassName AuditTakeOrderDto
 * Description
 * Create by gfy
 * Date 2022/8/17 18:51
 */
@Data
public class AuditTakeOrderDto {

    @NotNull(message = "请选择要更改状态的提货单")
    private Integer takeOrderId;

    @NotNull(message = "操作类型不能为空")
    // 1:审核通过 2：撤销 3：反审 4标记完成 5取消完成
    private Integer opType;

    private Integer userId;

}
