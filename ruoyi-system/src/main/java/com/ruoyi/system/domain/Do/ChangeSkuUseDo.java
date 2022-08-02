package com.ruoyi.system.domain.Do;

import lombok.Data;

/**
 * ClassName ChangeSkuUseDo
 * Description
 * Create by gfy
 * Date 2022/8/2 8:55
 */
@Data
public class ChangeSkuUseDo {

    private String orderNo;

    private Integer goodsId;

    private Double oldQty;

    private Double qty;

    private Integer userId;
}
