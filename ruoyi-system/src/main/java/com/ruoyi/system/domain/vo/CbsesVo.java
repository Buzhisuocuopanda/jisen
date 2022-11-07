package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CbsesVo extends BaseEntity {
    private Integer cbla01;

    private Integer cbca01;
    private Integer cbwa01;
    private Integer cbsa01;
    private Integer cbpb01;

    private Integer cbsf01;

    private String cbse07;
    private String cbpb15;

    private Date cbse08;
    private String cbca08;
    private String cbwa08;
    private String cala08;
    private Integer cbse18;
    private Integer cbse11;

    //供应商id
    private Integer cbsf15;
    private String cbsa08;
    private Integer cbsf16;
    private String cbpb12;
    private String cbpb08;
    private Double cbsf09;
    private Double cbsf11;
    private Double cbsf12;

    private String cbsf13;
    private String cbsg09;
    private String cbla09;
    private Integer cbse01;

    private String cbwa09;

    private Integer cbsf08;
    private String cbpa07;
    private Integer cbpa01;
    //  @Excel(name = "创建时间")

    private Date cbpa02;
    // @Excel(name = "修改时间")
    private Date cbpa03;
    //   @Excel(name = "创建人id")

    private Integer cbpa04;
    //   @Excel(name = "修改人id")

    private Integer cbpa05;
    //  @Excel(name = "是否删除")

    private Integer cbpa06;
    // @Excel(name = "分类名称")

    //  @Excel(name = "名称1")

    private String cbpa08;
    //  @Excel(name = "父节点id")

    private Integer cbpa09;
    //  @Excel(name = "分类编号")

    private String cbpa11;
    // @Excel(name = "父节点编号")

    private String cbpa12;


    private Integer saoma;
    private List<ScanVo> goods = new ArrayList<>();

    private String pinpai;





    private Integer saomanums;

    private Double nums;
}
