package com.ruoyi.system.domain.Do;

import com.ruoyi.system.domain.GsSalesOrdersChange;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public class GsSalesChangeDo {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;

    private String orderNo;

    private Integer supplierId;

    private Integer salerId;

    private Integer customerId;

    private Date orderDate;

    private Byte status;

    private Integer whId;

    private Integer userId;

    private Integer gsid;

    List<GsSalesOrdersChange> goods =new ArrayList<>();
}
