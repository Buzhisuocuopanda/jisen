package com.ruoyi.system.domain.dto;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class CbcaDto {
    private Integer cbca01;

    private Date cbca02;

    private Integer cbca03;

    private Date cbca04;

    private Integer cbca05;

    private Integer cbca06;

    private String cbca07;
    @NotBlank(message = "客户名称不能为空")
    @Length(min =1 , max = 20)
    @Excel(name = "名称")
    private String cbca08;
  //  @Excel(name = "订单号")
   // @NotBlank(message = "订单号不能为空")
    private String cbca09;
    @Excel(name = "名称首字母")
   // @NotBlank(message = "名称首字母不能为空")
    private String cbca10;
    @NotBlank(message = "开户行不能为空")
    @Length(min =1 , max = 20)
    @Excel(name = "开户行")
    private String cbca11;
    @NotBlank(message = "账号不能为空")
    @Length(min =1 , max = 30)
    @Excel(name = "银行账号")

    private String cbca12;
    @NotBlank(message = "纳税人识别号不能为空")
    @Length(min =1 , max = 30)
    @Excel(name = "纳税人识别号")

    private String cbca13;
    @Excel(name = "联系人")
    @NotBlank(message = "联系人不能为空")
    private String cbca14;
    @NotBlank(message = "地址不能为空")
    @Length(min =1 , max = 20)
    @Excel(name = "地址")
    private String cbca15;
    @NotBlank(message = "电话不能为空")
    @Length(min =1 , max = 20)
    @Excel(name = "电话")
    private String cbca16;
    @Excel(name = "备注")

    private String cbca17;
    @Excel(name = "联系人1")

    private String cbca18;
  @Excel(name = "联系人1办公室电话不能为空")
    private String cbca19;
  @Excel(name = "联系人2办公室电话不能为空")
    private String cbca20;

    private String cbca21;

    private String cbca22;

    private String cbca23;
    @Excel(name = "发票类型")
    @NotBlank(message = "发票类型不能为空")

    private String cbca24;
    @Excel(name = "发票邮递地址")
    @NotBlank(message = "发票邮递地址不能为空")

    private String cbca25;
    @Excel(name = "地址1")

    private String cbca26;

    private String cbca27;
    @Excel(name = "客户等级")
    @NotNull(message = "客户等级不能为空")
    private Integer cbca28;
}
