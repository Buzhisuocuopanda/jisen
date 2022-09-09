package com.ruoyi.system.domain.Do;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.dto.SaleOrderGoodsDto;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CbpbDo {
    private Integer cbpb01;

    private Date cbpb02;

    private Date cbpb03;

    private Integer cbpb04;

    private Integer cbpb05;

    private Integer cbpb06;

    private String cbpb07;
    @NotBlank(message = "商品描述不能为空")
   // @Length(min=1, max=50, message="商品描述长度不能超过50个字符")
    @Excel(name = "商品描述")
    private String cbpb08;

    private String cbpb09;
    @Excel(name = "是否启用")

    private Integer cbpb10;

    private Integer cbpb11;
    @NotBlank(message = "商品型号不能为空")
   // @Length(min=1, max=15, message="商品型号长度不能超过15个字符")
    @Excel(name = "型号")
    private String cbpb12;

    private Double cbpb13;

    private Integer cbpb14;
    @NotBlank(message = "upc不能为空")
    @Excel(name = "upc")
    private String cbpb15;
   // @Size(min = 1,message = "请至少添加一条客户明细")
    private List<CbpfDo> goods=new ArrayList<>();

    private Integer cbpf01;
    @Excel(name = "客户等级")
    private Integer cbpf02;
    @Excel(name = "完成状态6")
    private Integer cbpf03;
    @Excel(name = "标准进价")
    private Double cbpf04;
    @Excel(name = "标准销货价")
    private Double cbpf05;
    @Excel(name = "货币id")
    private Integer cbpf06;
    @Excel(name = "生效时间")
    private Date cbpf07;

}
