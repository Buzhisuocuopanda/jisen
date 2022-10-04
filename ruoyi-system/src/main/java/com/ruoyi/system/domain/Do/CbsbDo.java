package com.ruoyi.system.domain.Do;

import com.ruoyi.system.domain.Cbsc;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CbsbDo {
    private Integer cbsb01;

    private Date cbsb02;

    private Integer cbsb03;

    private Date cbsb04;

    private Integer cbsb05;

    private Integer cbsb06;
    //@NotBlank(message = "编号不能为空")
   // @Length(min =1 , max = 20)
    private String cbsb07;

    private Date cbsb08;
   @NotNull(message = "客户id不能未空")
    private Integer cbsb09;
    @NotNull(message = "仓库id不能未空")
    private Integer cbsb10;

    private Integer cbsb11;

    private Integer cbsb12;

    private Date cbsb13;

    private Integer cbsb14;

    private Date cbsb15;

    private Integer cbsb16;
    @NotBlank(message = "销售人员不能为空")
  //  @Length(min =1 , max = 10, message = "销售人员长度")
    private String cbsb17;
    @NotBlank(message = "联系人不能为空")
  //  @Length(min =1 , max = 10)
    private String cbsb18;
    @NotBlank(message = "电话不能为空")
  //  @Length(min =1 , max = 20)
    private String cbsb19;

    private Integer cbsb20;
    @NotBlank(message = "收货地址不能为空")
   // @Length(min =1 , max = 20)
    private String cbsb21;

    private String cbsb22;

    private String cbsb23;

    private String cbsb24;

    private String cbsb25;

    private String cbsb26;

    private String cbsb27;

    private String cbsb28;

    private String cbsb29;
    @NotBlank(message = "客户订单号不能为空")
  //  @Length(min =1 , max = 20)
    private String cbsb30;

    private Integer cbsb31;

    private Integer cbsb32;

    private Integer userId;

    private List<Cbsc> goods=new ArrayList<>();

    //提货单id
    private Integer takeId;





}
