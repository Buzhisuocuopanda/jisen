package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;
@Data
public class GsPurchaseOrderVo extends BaseEntity {

    private Long id;

    private String orderNo;

    private Date orderDate;

    private String cbca08;

    private String caua09;

    private String cbsa08;

    private String cbwa08;

}
