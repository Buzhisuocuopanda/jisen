package com.ruoyi.system.domain.Do;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data

public class GsGoodsSnDo {
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

}
