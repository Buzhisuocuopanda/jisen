package com.ruoyi.system.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class CbsaDto {
    private Integer cbsa01;

    private Date cbsa02;

    private Integer cbsa03;

    private Date cbsa04;

    private Integer cbsa05;

    private Integer cbsa06;
    @NotBlank(message = "供应商名称不能为空")
    @Length(min =1 , max = 20)
    private String cbsa07;

    private String cbsa08;

    private String cbsa09;

    private String cbsa10;

    private String cbsa11;

    private String cbsa12;

    private String cbsa13;

    private String cbsa14;

    private String cbsa15;

    private String cbsa16;

    private String cbsa17;
    @NotNull(message = "供应商状态不能为空")
    @Length(min =1 , max = 20)
    private Integer cbsa18;
}
