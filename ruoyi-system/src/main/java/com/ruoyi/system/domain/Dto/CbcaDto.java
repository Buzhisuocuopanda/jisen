package com.ruoyi.system.domain.Dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
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
    private String cbca08;

    private String cbca09;

    private String cbca10;
    @NotBlank(message = "开户行不能为空")
    @Length(min =1 , max = 20)
    private String cbca11;
    @NotBlank(message = "账号不能为空")
    @Length(min =1 , max = 30)
    private String cbca12;
    @NotBlank(message = "纳税人识别号不能为空")
    @Length(min =1 , max = 30)
    private String cbca13;

    private String cbca14;
    @NotBlank(message = "地址不能为空")
    @Length(min =1 , max = 20)
    private String cbca15;
    @NotBlank(message = "电话不能为空")
    @Length(min =1 , max = 20)
    private String cbca16;

    private String cbca17;

    private String cbca18;

    private String cbca19;

    private String cbca20;

    private String cbca21;

    private String cbca22;

    private String cbca23;

    private String cbca24;

    private String cbca25;

    private String cbca26;

    private String cbca27;

    private Integer cbca28;
}
