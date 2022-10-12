package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class GsSalesOrdersDetailsDto2 {
    private Integer id;

    private Date startTime;

    private Date endTime;


//    private Integer goodsId;
    //客户id
    private Integer customerId;

    //供应商id
    private Integer supplierId;

    //销售人员id
    private Integer salerId;
    //型号
    private String cbpb12;
}
