package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class GsGoodsSnVo {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createBy;

    private Integer updateBy;

    private Byte deleteFlag;
    //sn
    private String sn;

    private Integer goodsId;

    private Integer locationId;

    private Byte status;

    private Integer whId;

    private Date inTime;

    private Date outTime;

    private Date prdDate;

    private Byte groudStatus;

    //库位名称
    private String cbla09;

    //品牌
    private String cbpb10;

    //型号
    private String cbpb12;

    //商品描述
    private String cbpb08;


}