package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CbiwVo {
    private String goodssku;

    private String sn;

    private String storesku;

    private String upc;

    private Date createtime;

    private Double sum;

    private Integer goodsid;

    private Integer storeid;

    private Integer user;
}
