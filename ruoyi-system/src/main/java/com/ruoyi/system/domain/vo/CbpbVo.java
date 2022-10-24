package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;
@Data
public class CbpbVo {
  @Excel(name = "分类编号")

  private String cbpa11;

  @Excel(name = "商品分类")
  private String cbpa07;
  @Excel(name = "品牌")
  private String cala08;
  private Integer type;
  @Excel(name = "型号")
  private String cbpb12;
    //@Excel(name = "主键id")
    private Integer cbpb01;
   // @Excel(name = "创建时间")
    private Date cbpb02;
  //  @Excel(name = "修改时间")
    private Date cbpb03;
  //  @Excel(name = "创建人id")
    private Integer cbpb04;
  //  @Excel(name = "修改人id")
    private Integer cbpb05;
  //  @Excel(name = "是否删除")
    private Integer cbpb06;

    @Excel(name = "描述")
    private String cbpb08;

    private String cbpb09;
    private Integer cbpb10;

    private Integer cbpb11;

  private Integer id;

    private Double cbpb13;

    private Integer cbpb14;
    @Excel(name = "upc")
    private String cbpb15;


  private String sfqy;
  @Excel(name = "是否启用")
  private String cbpb07;
}
