package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;
@Data
public class GsAfterSalesVo extends BaseEntity {

    private Integer id;

    private Date createTime;

    private Date updateTime;



    private Byte deleteFlag;

    private Integer customerId;

    private String saleOrderNo;

    private Integer goodsId;

    private String question;

    private String sn;

    private Integer suplierId;

    private Integer answerMsg;

    private Integer process;
    private String cbpb08;
    private String cbpb15;

    private String cbca08;
    private String cbsa08;

    private Date startTime;

    private Date endTime;


    private String salerId;
    //销售人员名称
    private String salerName;
    //反馈时间
    private Date feedbackTime;
}
