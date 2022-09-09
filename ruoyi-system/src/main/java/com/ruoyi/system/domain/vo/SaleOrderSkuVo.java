package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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

    @ApiModelProperty("商品库存数量")
    private Double goodsNum;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("占用数量")
    //占用数量
    private Double lockQty;
    @ApiModelProperty("分配数量")
    //分配数量
    private Double makeQty;
    @ApiModelProperty("发货数量")
    //发货数量
    private Double shipmentQty;





}
