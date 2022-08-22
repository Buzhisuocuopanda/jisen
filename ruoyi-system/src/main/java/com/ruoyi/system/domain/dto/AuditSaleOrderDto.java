package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * ClassName AuditSaleOrderDto
 * Description
 * Create by gfy
 * Date 2022/8/8 13:36
 */
@Data
public class AuditSaleOrderDto {

    @NotBlank(message = "请选择销售订单")
    //如果是销售变更单就是销售变更单id
    private Integer orderId;


    private Integer userId;

    @NotBlank(message = "审核操作为空")
    //1 提交操作 2、撤销提交  3 审核 4、复审 5、指定结束 6、反审
    private Integer opeateType;

}
