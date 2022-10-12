package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OccupancyVo {
    @Excel(name = "销售订单号")
    @ApiModelProperty("销售订单号")
    private String cboa07;
    @Excel(name = "客户")
    @ApiModelProperty("客户")
    private String cbca08;

    @Excel(name = "客户订单号")
    @ApiModelProperty("客户订单号")
    private String cboa25;

    @Excel(name = "分类")
    @ApiModelProperty("分类")
    private String cbpa07;

    @Excel(name = "品牌")
    @ApiModelProperty("品牌")
    private String cala08;

    @Excel(name = "商品型号")
    @ApiModelProperty("商品型号")
    private String cbpb12;

    @Excel(name = "占用数量")
    @ApiModelProperty("占用数量")
    private Double lockQty;

    @Excel(name = "订单数量")
    @ApiModelProperty("订单数量")
    private Double cbob09;

    @Excel(name = "已发数量")
    @ApiModelProperty("已发数量")
    private Double cbob10;

    @Excel(name = "取消数量")
    @ApiModelProperty("取消数量")
    private Double cbob15;

//    @Excel(name = "商品id")
//    @ApiModelProperty("商品id")
    private Integer cbpb01;
    private Integer cboa01;

}
