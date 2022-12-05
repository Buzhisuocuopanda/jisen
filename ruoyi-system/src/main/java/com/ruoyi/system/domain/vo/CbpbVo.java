package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.Cbpf;
import com.ruoyi.system.domain.Do.CbpfDo;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

  @Excel(name = "商品类型")
  private String types;

  private String sfqy;
  @Excel(name = "是否启用")
  private String cbpb07;
//客户等级1
  @Excel(name = "客户等级")
  private Integer cbpf02;

  @Excel(name = "标准进价")
  private Double cbpf04;
  @Excel(name = "标准销货价")
  private Double cbpf05;

  @Excel(name = "结算类型")
  private String cbpf06;
  @Excel(name = "生效日期")
  private String cbpf07;
  //客户等级2
  @Excel(name = "客户等级")
  private Integer cbpf022;

  @Excel(name = "标准进价")
  private Double cbpf044;
  @Excel(name = "标准销货价")
  private Double cbpf055;

  @Excel(name = "结算类型")
  private String cbpf066;
  @Excel(name = "生效日期")
  private String cbpf077;
//客户等级3
@Excel(name = "客户等级")
private Integer cbpf0222;

  @Excel(name = "标准进价")
  private Double cbpf0444;
  @Excel(name = "标准销货价")
  private Double cbpf0555;

  @Excel(name = "结算类型")
  private String cbpf0666;
  @Excel(name = "生效日期")
  private String cbpf0777;
  //客户等级4
  @Excel(name = "客户等级")
  private Integer cbpf02222;

  @Excel(name = "标准进价")
  private Double cbpf04444;
  @Excel(name = "标准销货价")
  private Double cbpf05555;

  @Excel(name = "结算类型")
  private String cbpf06666;
  @Excel(name = "生效日期")
  private String cbpf07777;


}
