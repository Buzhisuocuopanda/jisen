package com.ruoyi.system.domain.vo;

import lombok.Data;

/**
 * ClassName GoodsUseVo
 * Description
 * Create by gfy
 * Date 2022/8/22 8:48
 */
@Data
public class GoodsUseVo {

    private Integer id;

    //销售订单号
    private String orderNp;


    //客户
    private String customerName;


    //客户订单号
    private String customerNo;


    //商品分类
    private String goodsClass;


    //品牌
    private String brand;


    //型号

    private String model;

    //占用数量
    private Double useQty;

    //订单数量
    private Double orderQty;

    //取消数量
    private Double cancelQty;



}
