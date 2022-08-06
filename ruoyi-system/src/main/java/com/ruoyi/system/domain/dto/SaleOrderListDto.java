package com.ruoyi.system.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * ClassName SaleOrderListDto
 * Description
 * Create by gfy
 * Date 2022/8/4 16:23
 */
@Data
public class SaleOrderListDto {

    private Date startTime;

    private Date endTime;

    private Integer status;

    private String orderNo;

    private String customer;

    private Integer type;


}
