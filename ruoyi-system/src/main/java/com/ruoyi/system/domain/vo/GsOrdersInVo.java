package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class GsOrdersInVo implements Serializable {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;
    @Excel(name = "订单编号")
    private String orderNo;
//    @Excel(name = "供应商id")
    private Integer supplierId;
    @Excel(name = "供应商名称")
    private String supplierName;

    private Integer salerId;
//    @Excel(name = "客户id")
    private Integer customerId;
    @Excel(name = "客户名称")
    private String customerName;
    @Excel(name = "订单时间")
    private Date orderDate;
    @Excel(name = "订单状态")
    private Byte status;
//    @Excel(name = "仓库id")
    private Integer whId;

    private Integer userId;

    private Integer statuss;

    private String ponumber;
    @Excel(name = "工厂")
    private String factory;



    private Integer cas;

    private Integer gsid;

    private static final long serialVersionUID = 1L;

    private Date startTime;

    private Date endTime;
}
