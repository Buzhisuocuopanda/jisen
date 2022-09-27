package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * ClassName gsOutStockAdivceVo
 * Description
 * Create by gfy
 * Date 2022/9/26 17:37
 */
@Data
public class GsOutStockAdivceVo {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createBy;

    private Integer updateBy;

    private Byte deleteFlag;

    private String saleOrderNo;

    private Integer whId;

    private Integer goodsId;

    private Double qty;

    private Byte status;


    private String brand;

    private String whName;

    private String model;

    private String description;

    private String goodsMsg;
}
