package com.ruoyi.system.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * ClassName FnGoodsSkuDto
 * Description
 * Create by gfy
 * Date 2022/9/5 15:59
 */
@Data
public class FnGoodsSkuDto {


    //仓库id
    private Integer whId;

    //商品id
    private Integer goodsId;

    //品牌id
    private Integer brandId;


    private Date startTime;

    private Date endTime;

}
