package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class GsGoodsSnsVo {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createBy;

    private Integer updateBy;

    private Byte deleteFlag;

    private String sn;

    private Integer goodsId;

    private Integer locationId;

    private Byte status;

    private Integer whId;

    private Date inTime;

    private Date outTime;

    private Date prdDate;

    private Byte groudStatus;

    private Integer repairStatus;

    //库位名称
    private String cbla09;

    //品牌
    private String cbpb10;

    //型号
    private String cbpb12;
    private String cbpb15;

    //商品描述
    private String cbpb08;
}
