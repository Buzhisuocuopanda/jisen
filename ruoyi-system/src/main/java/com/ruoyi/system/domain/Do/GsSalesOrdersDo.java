package com.ruoyi.system.domain.Do;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;
@Data
public class GsSalesOrdersDo extends BaseEntity {

    private String orderNo;

    private Integer supplierId;

    private Integer salerId;

    private Integer customerId;

    private Date orderDate;

    private Byte status;

    private Integer whId;

    private Integer userId;
}
