package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.GsGoodsUse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName SaleOrderSkuVo
 * Description
 * Create by gfy
 * Date 2022/8/1 17:10
 */
@Data
public class SaleOrderSkuVo {


    @ApiModelProperty("销售订单号")
    private String orderNo;


    @ApiModelProperty("生产总订单号")
    private String totalOrderNo;

    @ApiModelProperty("优先级")
    private String priority;

    @ApiModelProperty("商品库存数量")
    private Double goodsNum;

    @ApiModelProperty("商品名称")
    private String goodsMsg;

    private String brand;
    private String model;
    private String description;

    @ApiModelProperty("占用数量")
    //占用数量
    private Double lockQty;
    @ApiModelProperty("分配数量")
    //分配数量
    private Double makeQty;
    @ApiModelProperty("发货数量")
    //发货数量
    private Double shipmentQty;

    private Double canUseQty;

    private List<GsGoodsUse> goodsUses=new ArrayList<>();




}
