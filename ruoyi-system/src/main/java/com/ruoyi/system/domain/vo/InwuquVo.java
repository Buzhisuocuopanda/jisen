package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class InwuquVo extends BaseEntity {
    @Excel(name = "大类")
    private String totalclassify;
    @Excel(name = "分类名称")
    private String cbpa07;

    @Excel(name = "品牌")
    private String cala08;

    @Excel(name = "型号")
    private String cbpb12;

    @Excel(name = "UPC")
    private String cbpb15;

    @Excel(name = "描述")
    private String cbpb08;

 /*   @Excel(name = "数量")
    private Double cbif09;*/
     @Excel(name = "数量",cellType = Excel.ColumnType.NUMERIC)
     private Double cbib15;

    @Excel(name = "仓库")
    private String cbwa09;
    private String[] cbwa09s;

    @Excel(name = "可用库存数量",cellType = Excel.ColumnType.NUMERIC)
    private Double lockQty;
    //可用库存总数
    private Double totallockQty;
    //库存总数
    private Double totalcbib15;

    private Integer cbpb01;

    private Integer shopping;
    private Integer cbib01;
    private Integer cbib02;
    private Integer cbib08;



    private Date cbib04;

    private Integer cbpb10;
    //商品分类id
    private Integer cbpb14;


    private Integer whid;

    @Excel(name = "不良数量",cellType = Excel.ColumnType.NUMERIC)
    private Double badqty;
    @Excel(name = "已占用数量",cellType = Excel.ColumnType.NUMERIC)
    private Double lockuseqty;

    private Double totalbadqty;

    private Double totallockuseqty;

}
