package com.ruoyi.system.domain.Do;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName OutSuggestionsDo
 * Description 缺货建议
 * Create by gfy
 * Date 2022/8/1 9:04
 */
@Data
public class OutSuggestionsDo {

    //仓库id
    private Integer whId;

    //仓库名称
    private String whName;


    //所需数量
    private BigDecimal qty;

}
