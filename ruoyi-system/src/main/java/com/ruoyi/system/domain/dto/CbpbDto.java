package com.ruoyi.system.domain.dto;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.Cbpf;
import com.ruoyi.system.domain.Do.CbpfDo;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public class CbpbDto extends Cbpf {

    @Excel(name = "商品分类编号")
    private Integer cbpb14;

    @Excel(name = "商品分类名称")
    private String cbpb10s;


    @Excel(name = "品牌")
    private String cbpb10;

    @NotBlank(message = "商品型号不能为空")
    @Length(min=1, max=50)
    @Excel(name = "型号")
    private String cbpb12;


    @NotBlank(message = "upc不能为空")
    @Excel(name = "upc")
    private String cbpb15;

    @NotBlank(message = "商品描述不能为空")
    @Length(min=1, max=50)
    @Excel(name = "商品描述")
    private String cbpb08;

    private Double cbpb13;

    private Integer cbpb01;

    private Date cbpb02;

    private Date cbpb03;

    private Integer cbpb04;

    private Integer cbpb05;

    private Integer cbpb06;

    private String cbpb07;

    @NotBlank(message = "商品描述不能为空")
    @Length(min=1, max=50)
    private String cbpb09;


    private Integer cbpb11;





    private Integer cbpf01;
    @Excel(name = "客户等级")
    private Integer cbpf02;

    private Integer cbpf03;
    @Excel(name = "标准进价")
    private Double cbpf04;

    @Excel(name = "标准销货价")
    private Double cbpf05;

    //@Excel(name = "货币id")
    private Integer cbpf06;
    @Excel(name = "生效时间")
    private Date cbpf07;
    @Excel(name = "货币")
    private String moneyType;
    @Excel(name = "类型", readConverterExp = "0=配件,1=商品")
    private Integer type;
}
