package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

@Data
public class SczddVo {
    @Excel(name="订单号")
    private String cbba07;

    @Excel(name="品牌")
    private String cala08;

    @Excel(name="型号")
    private String cbpb12;

    @Excel(name="描述")
    private String cbpb08;

    @Excel(name="订单数量")
    private Double cbba09;

    @Excel(name="已发货数量")
    private Double cbba11;

//    @Excel(name="已生产数量")
    private Double cbba13;
    @Excel(name="已生产数量")
    private Double producedNum;
    @Excel(name="缺货数量")
    private Double stockoutNum;
  /*  @Excel(name="缺货数量")*/
    private Double cbba14;

    @Excel(name="状态",readConverterExp = "0=NO,4=OK")
    private Integer cbba12;

    private Integer cbpb01;

    private String sortKey;

}
