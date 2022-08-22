package com.ruoyi.system.domain.Do;

import com.ruoyi.system.domain.Cboa;
import lombok.Data;

/**
 * ClassName UserAuditCheckDo
 * Description
 * Create by gfy
 * Date 2022/8/4 10:57
 */
@Data
public class SaleOrderCheckDo {





    /**
     * 单据的操作类型
     * 销售订单  1：审核  2：复审
     *
     */
    private Integer operateType;

    private Cboa cboa;










}
