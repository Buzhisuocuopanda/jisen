package com.ruoyi.system.domain.Do;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@Data
public class CbpbDo {
    private Integer cbpb01;

    private Date cbpb02;

    private Date cbpb03;

    private Integer cbpb04;

    private Integer cbpb05;

    private Integer cbpb06;

    private String cbpb07;
    @NotBlank(message = "商品品牌不能为空")
    @Length(min=1, max=50)
    private String cbpb08;
    @NotBlank(message = "商品描述不能为空")
    @Length(min=1, max=50)
    private String cbpb09;

    private Integer cbpb10;

    private Integer cbpb11;
    @NotBlank(message = "商品型号不能为空")
    @Length(min=1, max=50)
    private String cbpb12;

    private Double cbpb13;

    private Integer cbpb14;
    @NotBlank(message = "upc不能为空")
    private String cbpb15;
}
