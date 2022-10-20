package com.ruoyi.system.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CbofVo {
    private Integer cbof01;
    private String makeUser;

    private Integer cboe01;
    private String cboe07;

    private Date cboe08;

    private String cbca08;
    private String caua15;
    private String cala08;
    private String cbpb08;
    private String cbpb12;
    private Double cbof09;
    private String cbof13;

    private Integer customerId;

    private String customerName;


    @ApiModelProperty("销售人员")
    private String saleUser;
    @ApiModelProperty("销售人员")
    private Integer saleUserId;
    private List<SaleOderDetailGoods> goods = new ArrayList<>();

    private Double sumQty;
    private Double thisprice;
    private Double Standardprice;

    private Double money;

    private String cboe21;
    private Integer cboe22;

}
