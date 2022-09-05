package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.Date;
@Data
public class GsAfterSalesVo {

    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;

    private Integer customerId;

    private String saleOrderNo;

    private Integer goodsId;

    private String question;

    private String sn;

    private Integer suplierId;

    private String answerMsg;

    private String process;

}
