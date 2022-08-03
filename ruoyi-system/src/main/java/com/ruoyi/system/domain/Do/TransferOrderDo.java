package com.ruoyi.system.domain.Do;

import lombok.Data;

/**
 * ClassName TransferOrderDo
 * Description
 * Create by gfy
 * Date 2022/8/3 11:36
 */
@Data
public class TransferOrderDo {

    private String orderNo;

    private Double qty;

    private Integer inWhId;

    private Integer outWhId;

    private Integer userId;

    private Integer goodsId;

    private String transNo;

    private Double orderQty;


}
