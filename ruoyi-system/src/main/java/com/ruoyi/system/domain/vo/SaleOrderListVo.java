package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * ClassName SaleOrderListVo
 * Description
 * Create by gfy
 * Date 2022/8/4 16:27
 */
@Data
public class SaleOrderListVo {

    private Integer id;

    private String orderNo;

    private String customerNo;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String customerName;

    private String saleUser;

    //结算货币 6:CNY
    private Integer settleCurrent;


    private String receiver;

    private String address;

    private String phone;

    private Integer orderClass;

    private Integer orderType;

    private String fcNumber;

    private String other;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date orderDate;

    private Integer status;


}
