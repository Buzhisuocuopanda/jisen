package com.ruoyi.system.domain.Do;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName SaleOrderMakeDo
 * Description
 * Create by gfy
 * Date 2022/8/1 8:59
 */
@Data
public class SaleOrderMakeDo {

    //是否提示缺货建议 1:提示 2：不提示
    private Integer prompt;

    //货物所属仓库
    private List<OutSuggestionsDo> list=new ArrayList<>();

}
