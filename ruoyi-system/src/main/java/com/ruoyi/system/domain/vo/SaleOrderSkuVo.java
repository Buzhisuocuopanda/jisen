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

    private Integer id;

    @ApiModelProperty("销售订单号")
    private String orderNo;


    @ApiModelProperty("生产总订单号")
    private String totalOrderNo;

    @ApiModelProperty("优先级")
    private String priority;

    @ApiModelProperty("商品库存数量")
    private Double goodsNum;

    private Integer goodsId;

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

    private Double orderQty;

    private Double canUseQty;

    private Double confirmQty;

    private List<GsGoodsUse> goodsUses=new ArrayList<>();


    public Double getGoodsNum() {
        if(goodsNum==null){
            return 0.0;
        }
        return goodsNum;
    }

    public Double getLockQty() {
        if(lockQty==null){
            return 0.0;
        }
        return lockQty;
    }

    public Double getMakeQty() {
        if(makeQty==null){
            return 0.0;
        }
        return makeQty;
    }

    public Double getCanUseQty() {
        if(canUseQty==null){
            return 0.0;
        }
        return canUseQty;
    }

    public Double getConfirmQty() {
        if(confirmQty==null){
            return 0.0;
        }
        return confirmQty;
    }
}
