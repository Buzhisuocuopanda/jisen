package com.ruoyi.system.domain.dto;

import lombok.Data;

/**
 * ClassName TotalOrderListDto
 * Description
 * Create by gfy
 * Date 2022/8/3 15:47
 */
@Data
public class TotalOrderListDto {


    //型号
    private String model;

    //生产总订单号
    private String orderNo;

    //状态 0：NO  4:OK
    private Integer status;
}
