package com.ruoyi.system.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
@Data
public class CbwaDto {

    private Integer type;

    private Byte allocationFlag;

    private Integer cbwa01;

    private Date cbwa02;

    private Integer cbwa03;

    private Date cbwa04;

    private Integer cbwa05;

    private Integer cbwa06;
    @NotNull(message = "仓库优先级不能为空")
   // @Range(max = 100, min = 1, message = "必须大于等于1或小于等于100")
    private Integer cbwa07;

    @NotBlank(message = "状态不能为空")
    //@Length(min =1 , max = 10, message = "状态长度必须小于10")
    private String cbwa08;

    @NotBlank(message = "仓库名称不能为空")
   // @Length(min =2, max = 5, message = "仓库名称长度必须2位到5位之间")
    @Pattern(regexp = "^[A-Z]+$", message = "仓库名称必须为大写字母")
    private String cbwa09;

    private String cbwa10;

    @NotBlank(message = "仓库类型不能为空")
  //  @Length(min =1 , max = 10, message = "仓库类型长度必须1位到10位之间")
    private String cbwa11;

    @NotBlank(message = "仓库管理模式不能为空")
   // @Length(min =1 , max = 10, message = "仓库管理模式长度必须1位到10位之间")
    private String cbwa12;

    @NotNull(message = "是否启用总订单不能为空")
    private Integer cbwa13;

    @NotNull(message = "是否启用提货单不能为空")
    private Integer cbwa14;

    private Integer cbwa15;

}
