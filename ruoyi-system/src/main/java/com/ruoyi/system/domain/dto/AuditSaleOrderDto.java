package com.ruoyi.system.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ClassName AuditSaleOrderDto
 * Description
 * Create by gfy
 * Date 2022/8/8 13:36
 */
@Data
public class AuditSaleOrderDto {

    @NotNull(message = "请选择销售订单")
    @ApiModelProperty("销售订单id")
    //如果是销售变更单就是销售变更单id
    private Integer orderId;


    private Integer userId;

    @NotNull(message = "审核操作为空")
    @ApiModelProperty("1 提交操作 2、撤销提交  3 审核 4、复审 5、指定结束 6、反审 7 标记完成 8 已复核反审")

    //1 提交操作 2、撤销提交  3 审核 4、复审 5、指定结束 6、反审
    private Integer opeateType;

}
