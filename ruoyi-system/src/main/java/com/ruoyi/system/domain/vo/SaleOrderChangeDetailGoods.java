package com.ruoyi.system.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.web.PortResolverImpl;

/**
 * ClassName SaleOrderChangeDetailGoods
 * Description
 * Create by gfy
 * Date 2022/8/10 15:04
 */
@Data
public class SaleOrderChangeDetailGoods {

    private Integer id;

    //品牌
    @ApiModelProperty("品牌")
    private String brand;
    //型号
    @ApiModelProperty("型号")

    private String model;
    //描述
    @ApiModelProperty("描述")

    private String description;

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

    //修改前价格
    @ApiModelProperty("修改前价格")

    private Double bfPrice;

    //修改前数量
    @ApiModelProperty("修改前数量")

    private Double bfQty;

    private Integer goodsId;

    private Double canUseSku;

    private String goodsMsg;
    private Double confirmQty;

    private Integer cbob01;

    public Double getConfirmQty() {
        if(confirmQty==null){
            return 0.0;
        }
        return confirmQty;
    }

    public String getGoodsMsg() {
        return brand+"-"+model+"-"+description;
    }

    public Integer getGoodsId() {
        if(goodsId==null){
            return id;
        }else {
            return goodsId;
        }

    }

    private BaseSelectVo goodsVo=new BaseSelectVo();

    public BaseSelectVo getGoodsVo() {
        goodsVo.setLabel(getGoodsMsg());
        goodsVo.setValue(getGoodsId());
        return goodsVo;
    }


    public Double getBfPrice() {
        if(bfPrice==null){
            return 0.00;
        }
        return bfPrice;
    }

    public Double getBfQty() {
        if(bfQty==null){
            return 0.00;
        }
        return bfQty;
    }
}
