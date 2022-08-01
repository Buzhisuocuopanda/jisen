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

    private Integer orderId;

    private Integer num;


    private Integer goodsId;

    private Integer oldNum;

    private Cbba cbba;

    private Integer priority;

    private Integer oldPriority;

    //1、创建 2、修改优先级 3、修改数量
    private Integer type;



}
