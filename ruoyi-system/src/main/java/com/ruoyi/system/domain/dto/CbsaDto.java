package com.ruoyi.system.domain.dto;

import com.ruoyi.common.annotation.Excel;
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
    @Excel(name = "名称")

    @NotBlank
    private String cbsa08;
    @NotBlank
    private String cbsa09;
    @NotBlank
    @Excel(name = "开户行")

    private String cbsa10;
    @NotBlank
    @Excel(name = "账号")
    private String cbsa11;
    @NotBlank
    @Excel(name = "纳税人识别号")
    private String cbsa12;
    @NotBlank
    @Excel(name = "地址")
    private String cbsa13;
    @NotBlank
    @Excel(name = "联系人")
    private String cbsa14;
    @NotBlank
    @Excel(name = "联系电话")
    private String cbsa15;
    @NotBlank
    private String cbsa16;
    @NotBlank
    private String cbsa17;
    @NotNull(message = "供应商状态不能为空")
    private Integer cbsa18;
}
