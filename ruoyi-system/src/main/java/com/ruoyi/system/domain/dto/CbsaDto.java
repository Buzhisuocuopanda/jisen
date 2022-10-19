package com.ruoyi.system.domain.dto;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
@Data
public class CbsaDto {
    private Integer cbsa01;

    private Date cbsa02;

    private Integer cbsa03;

    private Date cbsa04;

    private Integer cbsa05;

    private Integer cbsa06;
    @NotBlank(message = "供应商状态不能为空")
   // @Length(min =1 , max = 10, message = "供应商状态长度必须小于10")
    private String cbsa07;
    @Excel(name = "名称")
    @NotBlank(message = "供应商名称不能为空")
    private String cbsa08;

 //   @NotBlank(message = "供应商名称大写字母不能为空")
    private String cbsa09;

   // @NotBlank(message = "开户行不能为空")
    @Excel(name = "开户行")
    private String cbsa10;

   // @NotBlank(message = "账号不能为空")
    @Excel(name = "账号")
    private String cbsa11;

   // @NotBlank(message = "纳税人识别号不能为空")
    @Excel(name = "纳税人识别号")
    private String cbsa12;

    @NotBlank(message = "地址不能为空")
    @Excel(name = "地址")
    private String cbsa13;

    @NotBlank(message = "联系人不能为空")
    @Excel(name = "联系人")
    private String cbsa14;

   // @NotBlank(message = "联系电话不能为空")
    @Excel(name = "联系电话")
    private String cbsa15;
   // @NotBlank(message = "发票地址不能为空")
    @Excel(name = "发票地址")
    private String cbsa16;

   // @NotBlank(message = "发票电话不能为空")
    @Excel(name = "发票电话")
    private String cbsa17;

   // @NotNull(message = "出库顺序不能为空")
    private Integer cbsa18;
}
