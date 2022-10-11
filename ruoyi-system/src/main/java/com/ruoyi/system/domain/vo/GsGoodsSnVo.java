package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class GsGoodsSnVo {
    private Integer id;

    //sn
    private String sn;
    //商品id
    private Integer goodsId;
    //库位id
    private Integer locationId;

    //仓库id
    private Integer whId;

    private Date prdDate;


    //库位名称
    private String cbla09;

    //品牌
    private String cbpb10;

    //型号
    private String cbpb12;

    //商品描述
    private String cbpb08;

    private String goodsMsg;

}