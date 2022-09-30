package com.ruoyi.system.domain.dto;

import lombok.Data;

@Data
public class InwuqusDto {
    private String cbwa09;
    private String[] cbwa09s;

    private String cbla09;
    private String[] cbla09s;

    private Integer cbig09;

    private String cbig10;

    private Integer cbpb01;

    //上架状态 1：上架 2：已下架
    private Integer groudStatus;
    //商品状态 1：已入库 2：出库中 3：已出库
    private Integer status;

}
