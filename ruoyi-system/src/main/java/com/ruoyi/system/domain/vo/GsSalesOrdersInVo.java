package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;
@Data
public class GsSalesOrdersInVo   {

    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private String deleteFlag;

    private String ponumber;

    private Integer goodsId;

    private Double inQty;

    private Integer gsSalesOrders;

    private Byte status;

    private String CBPB08;
    //单据开始时间
    private Date startTime;

    //单据结束时间
    private Date endTime;
}
