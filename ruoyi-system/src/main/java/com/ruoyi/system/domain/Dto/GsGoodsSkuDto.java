package com.ruoyi.system.domain.Dto;

import lombok.Data;

import java.util.Date;
@Data
public class GsGoodsSkuDto {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createBy;

    private Integer updateBy;

    private Byte deleteFlag;

    private Integer goodsId;

    private Integer whId;

    private Double qty;

    private Integer locationId;

}
