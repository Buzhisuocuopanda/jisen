package com.ruoyi.system.domain.vo;

import lombok.Data;

/**
 * ClassName TakeOrderGoodsDetail
 * Description
 * Create by gfy
 * Date 2022/8/13 11:00
 */
@Data
public class TakeOrderGoodsDetail {


    //货物id
    private Integer goodsId;

    //品牌
    private String brand;

    //型号
    private String model;

    //描述
    private String description;

    //数量
    private Double qty;

    //单价
    private Double price;


    //金额
    private Double totalPrice;

    //剩余未发量
    private  Double noSendQty;

    //订单占用量
    private Double useQty;

    private String remark;


}
