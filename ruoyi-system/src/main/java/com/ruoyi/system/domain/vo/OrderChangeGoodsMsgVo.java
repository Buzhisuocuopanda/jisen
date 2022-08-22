package com.ruoyi.system.domain.vo;

import lombok.Data;

/**
 * ClassName OrderChangeGoodsMsgVo
 * Description
 * Create by gfy
 * Date 2022/8/10 14:04
 */
@Data
public class OrderChangeGoodsMsgVo {

    //商品id
    private Integer goodsId;

    //商品信息 品牌-型号-描述
    private String goodsMsg;



    //标准单价
    private Double normalPrice;

    //金额
    private Double totalPrice;

    //已发货数量
    private Double sendQty;

    //备注
    private String remark;

    private String brand;

    private String description;

    private String model;

    public String getGoodsMsg() {


        return brand+"-"+model+"-"+description;
    }
}
