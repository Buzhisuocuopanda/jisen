package com.ruoyi.system.domain.Do;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@Data
public class CbqaDo {
    private Integer cbqa01;

    private Date cbqa02;

    private Integer cbqa03;

    private Date cbqa04;

    private Integer cbqa05;

    private Integer cbqa06;
    @NotBlank(message = "编号不能为空")
    private String cbqa07;

    private Date cbqa08;

    private Integer cbqa09;

    private Integer cbqa10;

    private Date cbqa11;

    private Integer userId;
}
