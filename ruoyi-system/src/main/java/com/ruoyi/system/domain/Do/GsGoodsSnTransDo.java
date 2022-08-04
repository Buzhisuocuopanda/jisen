package com.ruoyi.system.domain.Do;

import lombok.Data;

import java.util.Date;
@Data
public class GsGoodsSnTransDo {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer createBy;

    private Integer updateBy;

    private String sn;

    private Byte transType;

    private Integer transId;

    private String transLineId;

    private Integer whId;

    private Integer goodsId;

    private Integer scanBy;

    private Integer locationId;
}
