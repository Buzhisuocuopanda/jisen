package com.ruoyi.system.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName SaleOderDetailGoods
 * Description
 * Create by gfy
 * Date 2022/8/6 15:39
 */
@Data
public class SaleOderDetailGoods {

    private Integer id;
    private Integer goodsId;

    //品牌
    @ApiModelProperty("品牌")

    private String brand;
    //型号
    @ApiModelProperty("型号")

    private String model;
    //描述
    @ApiModelProperty("描述")

    private String description;

    @ApiModelProperty("分配的数量")

    private Double fpQty;

    //数量
    @ApiModelProperty("数量")

    private Double qty;
    //标准单价
    @ApiModelProperty("标准单价")

    private Double normPrice;
    //本次单价
    @ApiModelProperty("本次单价")

    private Double currentPrice;
    //金额
    @ApiModelProperty("金额")

    private Double totalPrice;
    //备注
    @ApiModelProperty("备注")

    private String remark;

    //生产总订单号
    @ApiModelProperty("生产总订单号")

    private String totalOrderNo;

    private double canUseSku;

    private String goodsMsg;
    private Double confirmQty;

    public Double getConfirmQty() {
        if(confirmQty==null){
            return 0.0;
        }
        return confirmQty;
    }

    public String getGoodsMsg() {
        return brand+"-"+model+"-"+description;
    }

//    public Integer getGoodsId() {
//        return id;
//    }


    private BaseSelectVo goodsVo =new BaseSelectVo();

    public BaseSelectVo getGoodsVo() {
        goodsVo.setLabel(getGoodsMsg());
        goodsVo.setValue(getGoodsId());
        return goodsVo;
    }

}
