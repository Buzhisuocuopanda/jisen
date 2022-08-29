package com.ruoyi.system.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class CbwaDto {

    private Integer cbwa01;

    private Date cbwa02;

    private Integer cbwa03;

    private Date cbwa04;

    private Integer cbwa05;

    private Integer cbwa06;
    @NotNull(message = "仓库优先级不能为空")
    private Integer cbwa07;
    @NotBlank(message = "状态不能为空")
    @Length(min =1 , max = 10)
    private String cbwa08;
    @NotBlank(message = "仓库名称不能为空")
    @Length(min =1 , max = 25)
    private String cbwa09;

    private String cbwa10;
    @NotBlank(message = "仓库类型不能为空")
    @Length(min =1 , max = 25)
    private String cbwa11;
    @NotBlank(message = "仓库管理模式不能为空")
    @Length(min =1 , max = 25)
    private String cbwa12;
    @NotNull(message = "是否启用总订单不能为空")
    private Integer cbwa13;
    @NotNull(message = "是否启用提货单不能为空")
    private Integer cbwa14;

    private Integer cbwa15;

}
