package com.ruoyi.system.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName GoodsShopVo
 * Description
 * Create by gfy
 * Date 2022/8/10 8:47
 */
@Data
public class GoodsShopVo {

    //主鍵id
    @ApiModelProperty("购物车id")
    private Integer id;

    //品牌
    @ApiModelProperty("品牌")
    private String brand;

    //商品id
    @ApiModelProperty("商品id")
    private Integer goodsId;

    //型号
    @ApiModelProperty("型号")
    private String model;

    //描述
    @ApiModelProperty("描述")
    private String description;



    private Date createTime;

    private Date updateTime;

    private Integer createBy;

    private Integer updateBy;

    private Byte deleteFlag;

    private Integer goodsId;

    private Integer userId;



}
