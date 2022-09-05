package com.ruoyi.system.domain.Do;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.entity.Cbpa;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
@Data
public class CbpaDo extends Cbpa {
    private Integer cbpa01;

    private Date cbpa02;

    private Date cbpa03;

    private Integer cbpa04;

    private Integer cbpa05;

    private Integer cbpa06;
    @NotBlank(message = "分类名称不能为空")
    @Length(min=1, max=11, message="分类名称长度必须1位到10位之间")
    @Excel(name = "分类名称")
    private String cbpa07;

    private String cbpa08;
    //@NotNull(message = "父级id不能为空")
    private Integer cbpa09;
    @NotBlank(message = "分类编号不能为空")
    @Pattern(regexp = "^[0-9]*$", message = "分类编号必须为数字")
    @Length(min=1, max=10, message = "分类编号长度必须1位到10位之间")
    @Excel(name = "分类编号")
    private String cbpa11;

    private String cbpa12;
}
