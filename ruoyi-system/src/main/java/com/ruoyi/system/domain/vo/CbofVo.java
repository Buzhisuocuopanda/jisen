package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CbofVo {

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

    private List<SaleOderDetailGoods> goods = new ArrayList<>();
}
