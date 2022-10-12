package com.ruoyi.system.domain.Do;

import lombok.Data;

/**
 * ClassName SaleOrderExitDo
 * Description
 * Create by gfy
 * Date 2022/8/2 13:58
 */
@Data
public class SaleOrderExitDo {

    private String orderNo;

    private Integer goodsId;

    private Double qty;

    private String totalOrderNo;

//    private Integer cbobId;
//
//    private Integer orderClass;



}
