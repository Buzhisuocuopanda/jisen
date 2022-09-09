package com.ruoyi.system.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName DelSaleChangeDto
 * Description
 * Create by gfy
 * Date 2022/8/11 11:21
 */
@Data
public class DelSaleChangeDto {


    @NotNull(message = "请选择要删除的销售变更单")
    @ApiModelProperty("销售变更单id")
    private Integer id;

    private Integer userId;


}
