package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * ClassName FnQueryAyntgesisVo
 * Description
 * Create by gfy
 * Date 2022/9/2 15:34
 */
@Data
public class FnQueryAyntgesisVo {



    private Date inWhTime;

    //入库时间
    @Excel(name = "入库时间")
    private String inWhTimeMsg;


    private Date outWhTime;

    //出库时间
    @Excel(name = "出库时间")
    private String  outWhTimeMsg;

    @Excel(name = "订单号")
    private String orderNo;
    @Excel(name = "型号")
    private String model;
    @Excel(name = "描述")
    private String description;
    //数据库注释 数量 表cbsc
    @Excel(name = "数量")
    private Double qty;
    @Excel(name = "序列号")
    private String sn;
    //数据库注释 本次单价 表cbob
    @Excel(name = "销售单价U")
    private Double uPrice;
    //数据库注释 标准单价 表cbob
    @Excel(name = "销售单价R")
    private Double rPrice;
    @Excel(name = "经销商名称")
    private String suplierName;
    @Excel(name = "品牌")
    private String brand;
    @Excel(name = "工厂")
    private String gc;
    //数据库注释 单价 表cbpd
    @Excel(name = "采购单价U")
    private Double cgUprice;
    @Excel(name = "采购单价R")
    private Double cgRprice;

    //不显示了
    @Excel(name = "生产总订单号")
    private String totalOrderNo;

    private Integer cbsd01;
    private Integer goodsId;

    private Integer currency;

    private Double salePrice;

    private Integer cbsb01;
    private String cbsd09;

    private Integer cbpc16;
//    private Double cgPrice;




}
