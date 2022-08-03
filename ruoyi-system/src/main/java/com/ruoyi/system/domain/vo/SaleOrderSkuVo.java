package com.ruoyi.system.domain.vo;

import lombok.Data;

/**
 * ClassName SaleOrderSkuVo
 * Description
 * Create by gfy
 * Date 2022/8/1 17:10
 */
@Data
public class SaleOrderSkuVo {

    private String orderNo;

    private Double goodsNum;

    private String goodsName;

    //占用数量
    private Double lockQty;

    //分配数量
    private Double makeQty;

    //发货数量
    private Double shipmentQty;





}
