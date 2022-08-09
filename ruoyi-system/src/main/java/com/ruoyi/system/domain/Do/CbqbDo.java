package com.ruoyi.system.domain.Do;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class CbqbDo {
    private Integer cbqb01;

    private Integer cbqb02;

    private Date cbqb03;

    private Integer cbqb04;

    private Date cbqb05;

    private Integer cbqb06;

    private Integer cbqb07;
    @NotNull(message = "销售提货单扫描记录表id不能为空")
    private Integer cbqb08;
    @NotBlank(message = "替换商品sn不能为空")
    private String cbqb09;
    @NotBlank(message = "原商品sn不能为空")
    private String cbqb10;

    private Integer cbqa01;

    private Integer userId;
}
