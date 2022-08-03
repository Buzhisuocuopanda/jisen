package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName SaleOrderSkuListVo
 * Description
 * Create by gfy
 * Date 2022/8/2 9:56
 */
@Data
public class SaleOrderSkuListVo {

    //可用库存
    private Double canUseSku;

    private List<SaleOrderSkuVo> list =new ArrayList<>();

}
