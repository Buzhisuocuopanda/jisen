package com.ruoyi.system.domain.Do;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@Data
public class CbpaDo {
    private Integer cbpa01;

    private Date cbpa02;

    private Date cbpa03;

    private Integer cbpa04;

    private Integer cbpa05;

    private Integer cbpa06;
    @NotBlank(message = "分类名称不能为空")
    private String cbpa07;

    private String cbpa08;

    private Integer cbpa09;
    @NotBlank(message = "分类编号不能为空")
    private String cbpa11;

    private String cbpa12;
}
