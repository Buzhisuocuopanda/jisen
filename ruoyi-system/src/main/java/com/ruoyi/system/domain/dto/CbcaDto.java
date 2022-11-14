package com.ruoyi.system.domain.dto;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.vo.GoodsPriceAndSkuVo;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
   // @Length(min =1 , max = 20, message = "客户名称长度不能超过20个字符")
    @Excel(name = "客户全称")
    private String cbca08;
  //  @Excel(name = "订单号")
   // @NotBlank(message = "订单号不能为空")
    private String cbca09;
    @Excel(name = "名称首字母简写")
   // @NotBlank(message = "名称首字母不能为空")
    private String cbca10;

  @Excel(name = "联系人")
  @NotBlank(message = "联系人不能为空")
  private String cbca14;

  @NotBlank(message = "电话不能为空")
  //@Length(min =1 , max = 20, message = "电话长度不能超过20个字符")
  @Excel(name = "电话")
  private String cbca16;

  @NotBlank(message = "公司地址不能为空")
  // @Length(min =1 , max = 20, message = "地址长度不能超过20个字符")
  @Excel(name = "公司地址")
  private String cbca15;

  @Excel(name = "客户等级")
  @NotNull(message = "客户等级不能为空")
  private Integer cbca28;

  @NotBlank(message = "纳税人识别号不能为空")
  // @Length(min =1 , max = 30, message = "纳税人识别号长度不能超过30个字符")
  @Excel(name = "纳税人识别号")
  private String cbca13;

  @Excel(name = "税务登记地址")
  private String cbca26;

    @NotBlank(message = "开户行不能为空")
   // @Length(min =1 , max = 20, message = "开户行长度不能超过20个字符")
    @Excel(name = "开户行")
    private String cbca11;

    @NotBlank(message = "银行账号不能为空")
   // @Length(min =1 , max = 30, message = "账号长度不能超过30个字符")
    @Excel(name = "银行账号")

    private String cbca12;




    @Excel(name = "备注")

    private String cbca17;
    @Excel(name = "联系人1")

    private String cbca18;
  @Excel(name = "联系人1办公室电话")
  @NotBlank(message = "联系人1办公室电话不能为空")

  private String cbca19;
  @Excel(name = "联系人2办公室电话")
  @NotBlank(message = "联系人2办公室电话不能为空")

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


    private String cbca27;


    private List<Integer> goodsIds=new ArrayList<>();
    private List<GoodsPriceAndSkuVo> goodsres=new ArrayList<>();

}
