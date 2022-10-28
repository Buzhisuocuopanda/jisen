package com.ruoyi.system.domain.Do;

import lombok.Data;

/**
 * ClassName TranUseQtyDo
 * Description
 * Create by gfy
 * Date 2022/10/28 13:40
 */
@Data
public class TranUseQtyDo {

    private Integer goodsId;

    private Double qty;

    private Integer inWhId;

    private Integer outWhId;



}
