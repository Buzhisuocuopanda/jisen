package com.ruoyi.system.domain.vo;

import lombok.Data;

/**
 * ClassName GoodsPriceAndSkuVo
 * Description
 * Create by gfy
 * Date 2022/8/9 16:23
 */
@Data
public class GoodsPriceAndSkuVo {

    //货物id
    private Integer goodsId;

    //标准单价
    private Double normalPrice;

    //参考库存
    private Double ckSku;

    //可用库存
    private Double canUseSku;

}
