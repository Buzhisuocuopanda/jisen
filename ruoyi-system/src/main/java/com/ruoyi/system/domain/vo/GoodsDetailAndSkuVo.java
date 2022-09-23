package com.ruoyi.system.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class GoodsDetailAndSkuVo {
    @ApiModelProperty("商品id")
    private Integer goodsId;

    @ApiModelProperty("客户id")
    private Integer customerId;

    @ApiModelProperty("订单分类 1:国际订单 2：国内订单")
    private Integer orderClass;

    @ApiModelProperty("商品品牌")
    private String goodsBrand;

    @ApiModelProperty("商品型号")
    private String goodsModel;

    @ApiModelProperty("商品描述")
    private String goodsdatail;

    @ApiModelProperty("数量")
    private Integer goodsNum;

    @ApiModelProperty("标准单价")
    private Double goodsPrice;

    @ApiModelProperty("本次单价")
    private Double goodsPriceNow;

    @ApiModelProperty("金额")
    private Double goodsMoney;

    @ApiModelProperty("可用库存")
    private Double goodsStock;

    @ApiModelProperty("备注")
    private String goodsRemark;

    @ApiModelProperty("参考库存")
    private Double ckgoodsStock;




}
