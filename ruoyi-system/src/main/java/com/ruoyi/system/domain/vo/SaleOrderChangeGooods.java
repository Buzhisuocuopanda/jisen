package com.ruoyi.system.domain.vo;

import lombok.Data;

/**
 * ClassName SaleOrderChangeGooods
 * Description
 * Create by gfy
 * Date 2022/8/10 10:12
 */
@Data
public class SaleOrderChangeGooods {

    private Integer id;

    //品牌
    private String brand;
    //型号
    private String model;
    //描述
    private String description;

    //变更前数量
    private Double beforeQty;

    //变更后数量
    private Double afterQty;
    //标准单价
    private Double normPrice;
    //变更前单价
    private Double beforeCurrentPrice;
    //变更后单价
    private Double affterCurrentPrice;
    //金额
    private Double totalPrice;
    //备注
    private String remark;

    //可用库存
    private Double canUseQty;

    //已发货数量
    private Double sendQty;





}
