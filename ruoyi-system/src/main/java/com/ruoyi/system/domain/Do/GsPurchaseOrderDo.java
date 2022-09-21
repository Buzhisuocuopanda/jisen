package com.ruoyi.system.domain.Do;

import com.ruoyi.system.domain.GsPurchaseOrderDetail;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class GsPurchaseOrderDo {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;

    private String orderNo;

    private Date orderDate;

    private Integer customerId;

    private Integer salerId;

    private Integer supplierId;

    private Byte status;

    private Integer whId;

    private Integer userId;

    private List<GsPurchaseOrderDetail> goods=new ArrayList<>();

}
