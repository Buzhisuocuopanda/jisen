package com.ruoyi.system.domain.Dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@Data
public class CalaDto {
    private Integer cala01;

    private String cala02;

    private Date cala03;

    private Date cala04;

    private Integer cala05;

    private Integer cala06;

    private Integer cala07;
    @NotBlank(message = "名称不能为空")
    @Length(min =1 , max = 25)
    private String cala08;

    private String cala09;
    @NotBlank(message = "类别不能为空")
    @Length(min =1 , max = 25)
    private String cala10;

    private String cala11;

    private String cala12;
}
