package com.ruoyi.system.domain.vo;

import lombok.Data;

/**
 * ClassName TakeOrderGoodsVo
 * Description
 * Create by gfy
 * Date 2022/8/11 17:27
 */
@Data
public class TakeOrderGoodsVo {

    //货物id
    private Integer goodsId;

    //品牌
    private String brand;

    //型号
    private String model;

    //描述
    private String description;

    //供应商id
    private Integer supplierId;

    //订单分类
    private String orderClass;

    //提货数量
    private Double qty;

    //单价
    private Double price;

    //金恩
    private Double totalPrice;


    //剩余未发量
    private Double noSendQty;

    //订单占用数量
    private Double useQty;

    //备注
    private String remark;

    //良品数量
    private Double goodsNum;

    //订单数量
    private Double orderQty;

    //已扫数量
    private Integer scanQty;

    //后台使用 前端无需显示
    private String goodClass;

}
