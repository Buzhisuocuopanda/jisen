package com.ruoyi.system.domain.Do;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName GoodsOperationDo
 * Description
 * Create by gfy
 * Date 2022/7/28 17:17
 */
@Data
    public class GoodsOperationDo {

    private Integer goodsId;

    //1:国际订单 2：国内订单
    private Integer orderType;

    //占用库存
    private Double num;

    //订单数量 国内订单和占用库粗库存数量相等 国际不一样
    private Double orderNum;

    private String goodsName;

    //订单号
    private String orderNo;

    private Integer userId;

    private String totalOrderNo;

//    private String orderNo;

}
