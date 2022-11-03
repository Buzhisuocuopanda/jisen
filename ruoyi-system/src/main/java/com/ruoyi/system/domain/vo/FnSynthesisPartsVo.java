package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;
/**
 *@author: zhaoguoliang
 *@date: Create in 2022/11/2 15:11
 *配件财务综合报表
 */
@Data
public class FnSynthesisPartsVo {



    private Date inWhTime;

    //入库时间
//    @Excel(name = "入库时间")
    private String inWhTimeMsg;


    private Date outWhTime;

    //出库时间
    @Excel(name = "出库时间")
    private String  outWhTimeMsg;

    @Excel(name = "订单号")
    private String orderNo;
    @Excel(name = "生产总订单号")
    private String totalOrderNo;
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
//    @Excel(name = "采购单价U")
    private Double cgUprice;
//    @Excel(name = "采购单价R")
    private Double cgRprice;


    private Integer cbsd01;
    private Integer goodsId;

    private Integer currency;

    private Double salePrice;

    private Integer cbsb01;
    private String cbsd09;

    private Integer cbpc16;
//    private Double cgPrice;












    //销售订单号
    private String saleOrderNo;


    //仓库名字
    private Integer whId;

    //客户名称
    private String customerName;
    //客户id
    private Integer customerId;

    //开始日期
    private Date startTime;

    //结束时间
    private Date endTime;


}
