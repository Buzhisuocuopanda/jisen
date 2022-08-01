package com.ruoyi.system.domain.Do;

import lombok.Data;

/**
 * ClassName GoodsOperationDo
 * Description
 * Create by gfy
 * Date 2022/7/28 17:17
 */
@Data
    public class GoodsOperationDo {

    private Integer goodsId;

    private Integer orderType;

    //占用库存
    private Integer num;

    private String goodsName;

//    private String orderNo;

}
