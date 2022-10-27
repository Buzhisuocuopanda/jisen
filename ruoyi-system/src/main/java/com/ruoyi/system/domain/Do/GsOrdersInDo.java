package com.ruoyi.system.domain.Do;

import com.ruoyi.system.domain.GsSalesOrdersChange;
import com.ruoyi.system.domain.GsSalesOrdersIn;
import com.ruoyi.system.domain.vo.GsSalesOrdersInVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class GsOrdersInDo {

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

    private Integer statuss;

    private String ponumber;

    private String factory;

    private Integer cas;

    private Integer gsid;

    List<GsSalesOrdersIn> goods =new ArrayList<>();

    private String customerName;

    private String supplierName;

    private String salerName;

}
