package com.ruoyi.system.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName TakeOrderSugestVo
 * Description
 * Create by gfy
 * Date 2022/8/15 10:59
 */
@Data
public class TakeOrderSugestVo {

    private Integer cbpm01;
    //序号
    @ApiModelProperty("序号")
    private Integer number;

    //类型
    private String goodClass;

    //品牌
    private String brand;

    //型号
    private String model;

    //描述
    private String description;
    //商品id
    private Integer goodsId;

    //SN
    private String sn;

    private String bfSn;

    //库位
    private String sku;

    //扫码状态
    private String scanStatus;

    private String goodsMsg;

    private String upc;

    public String getGoodsMsg() {

        if(brand!=null){
            return brand+"-"+model+"-"+description;
        }
        return "";
    }
}
