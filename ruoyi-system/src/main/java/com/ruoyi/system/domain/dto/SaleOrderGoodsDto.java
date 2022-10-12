package com.ruoyi.system.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.web.PortResolverImpl;

import java.math.BigDecimal;

/**
 * ClassName TotalOrderGoodsDto
 * Description
 * Create by gfy
 * Date 2022/8/5 13:55
 */
@Data
public class SaleOrderGoodsDto {

    //行号
    @ApiModelProperty("行号")
    private Integer number;

    //货物id
    @ApiModelProperty("商品id")
    private Integer goodsId;

    //货物数量
    @ApiModelProperty("货物数量")
    private Double qty;

    //标准价格
    @ApiModelProperty("标准单价")
    private Double normalPrice;

    //本次单价
    @ApiModelProperty("本次单价")
    private Double currentPrice;
    //金额
    @ApiModelProperty("金额")
    private Double totalPrice;
    //备注
    @ApiModelProperty("备注")
    private String remark;

    private String totalOrderNo;

    private Integer id;

    public Integer getGoodsId() {
        if(goodsId==null){
            return id;
        }
        return goodsId;
    }
}
