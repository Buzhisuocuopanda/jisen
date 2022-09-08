package com.ruoyi.system.domain.dto;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class CblaDto {
    @Excel(name = "仓库名称")
    private String storename;

    private Integer cbla01;

    private Date cbla02;

    private Integer cbla03;

    private Date cbla04;

    private Integer cbla05;

    private Integer cbla06;
    @NotNull(message = "库位码不能为空")
    @Excel(name = "库位顺序")

    private Integer cbla07;
    @NotBlank(message = "库位状态不能为空")
   // @Length(min =1 , max = 5, message = "库位状态长度不能超过5个字符")
    @Excel(name = "状态")
    private String cbla08;

    @NotBlank(message = "库位码不能为空")
    //@Length(min =1 , max = 30, message = "库位码长度不能超过30个字符")
    @Excel(name = "库位码")
    private String cbla09;

    private Integer cbla10;
    @NotNull(message = "库位容量不能为空")
    @Excel(name = "库位容量")
    private Double cbla11;

    @NotBlank(message = "优选型号不能为空")
  //  @Length(min =1 , max = 30, message = "优选型号长度不能超过30个字符")
    @Excel(name = "优先型号")

    private String cbla12;
   // @NotBlank(message = "备注不能为空")
  //  @Length(min =1 , max = 30, message = "备注长度不能超过30个字符")
    @Excel(name = "备注")
    private String cbla13;



}
