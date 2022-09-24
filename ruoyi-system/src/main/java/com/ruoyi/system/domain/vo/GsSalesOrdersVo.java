package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class GsSalesOrdersVo {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;

    private String orderNo;

    private String supplier;

    private String saler;

    private String customer;

    private Date orderDate;

    private Byte status;

    private String wh;

    private Integer userId;

    //单据开始时间
    private Date startTime;

    //单据结束时间
    private Date endTime;



    private Integer supplierId;

    private Integer salerId;

    private Integer customerId;



    private Integer whId;

}
