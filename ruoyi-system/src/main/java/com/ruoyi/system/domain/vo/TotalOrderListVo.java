package com.ruoyi.system.domain.vo;

import lombok.Data;

/**
 * ClassName TotalOrderListVo
 * Description
 * Create by gfy
 * Date 2022/8/3 15:47
 */
@Data
public class TotalOrderListVo {
    private Integer priority;

    private Integer id;

    private String orderNo;

    private String model;

    private String description;

    private Double orderQty;

    private Double makeQty;

    private Double shippedQty;

    private Double currentOrderQty;

    private Integer orderType;

    private Integer status;
}
