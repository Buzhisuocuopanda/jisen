package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GsSalesOrderssVo {
    private Integer id;



    private String orderNo;

    private Date orderDate;

    private String cbsa08;

    private String caua17;

    private String cbca08;

    private String cbwa09;

    private Integer goodsId;

    private Double qty;

    private BigDecimal price;

    private String remark;

    private Double inQty;

    private String cbpb08;

    private String cala08;

    private String cbpb12;


    private Double qtys;




    //单据开始时间
    private Date startTime;

    //单据结束时间
    private Date endTime;
}
