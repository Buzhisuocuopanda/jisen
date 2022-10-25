package com.ruoyi.system.domain.Do;

import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.system.domain.Cbba;
import lombok.Data;

/**
 * ClassName OrderDistributionDo
 * Description
 * Create by gfy
 * Date 2022/7/27 11:31
 */
@Data
public class OrderDistributionDo {



    private Double num;


    private Integer goodsId;

    private Double oldNum;

    private Cbba cbba;

    private Long priority;

    private Long oldPriority;

    //1、创建 2、修改优先级 3、修改数量
    private Integer type;



}
