package com.ruoyi.system.domain.dto;

import lombok.Data;

/**
 * ClassName TakeOrderGoodsDto
 * Description
 * Create by gfy
 * Date 2022/8/11 14:31
 */
@Data
public class TakeOrderGoodsDto {


    //货物id
    private Integer goodsId;

    //行号
    private Integer number;

    //供应商id
    private Integer supplierId;

    //订单分类
    private Integer orderClass;

    //数量
    private Double qty;

    //单价
    private Double price;

    //金恩
    private Double totalPrice;


    //商品信息
    private String goodsMsg;


    //剩余未发量
    private Double noSendQty;

    //订单占用数量
    private Double useQty;

    //备注
    private String remark;


    private Integer cbpc099;


}
