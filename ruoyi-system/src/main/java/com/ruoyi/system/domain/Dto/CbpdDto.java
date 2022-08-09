package com.ruoyi.system.domain.Dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
public class CbpdDto {
    private Integer cbpc01;

    private Date cbpc02;

    private Integer cbpc03;

    private Date cbpc04;

    private Integer cbpc05;

    private Integer cbpc06;

    private String cbpc07;

    private Date cbpc08;
    @NotNull(message = "供应商不能为空")
    private Integer cbpc09;
    @NotNull(message = "仓库不能为空")
    private Integer cbpc10;

    private Integer cbpc11;

    private Integer cbpc12;

    private Date cbpc13;

    private Integer cbpc14;

    private Date cbpc15;
    @NotNull(message = "结算货币类型不能为空")
    private Integer cbpc16;

    private String cbpc17;

    private Integer userId;

    private Integer cbpd01;

    private Integer cbpd02;

    private Date cbpd03;

    private Integer cbpd04;

    private Date cbpd05;

    private Integer cbpd06;

    private Integer cbpd07;
    @NotNull(message = "商品id不能为空")
    private Integer cbpd08;
    @NotNull(message = "数量不能为空")
    @Min(value = 0, message = "必须大于等于0")

    private Double cbpd09;

    private Double cbpd10;

    @NotNull(message = "单价不能为空")
    @Min(value = 0, message = "必须大于等于0")

    private Double cbpd11;

    @NotNull(message = "金额不能为空")
    @Min(value = 0, message = "必须大于等于0")
    private Double cbpd12;

    private String cbpd13;

    private Integer cbpe01;

    private Integer cbpe02;

    private Date cbpe03;

    private Integer cbpe04;

    private Date cbpe05;

    private Integer cbpe06;

    private Integer cbpe07;

    private Integer cbpe08;

    private String cbpe09;

    private Integer cbpe10;

    private Integer cbpe11;

    private String cbpe12;



}
