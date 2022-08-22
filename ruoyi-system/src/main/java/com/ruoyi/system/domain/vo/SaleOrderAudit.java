package com.ruoyi.system.domain.vo;

import lombok.Data;

/**
 * ClassName SaleOrderAudit
 * Description
 * Create by gfy
 * Date 2022/8/6 15:55
 */
@Data
public class SaleOrderAudit {
    //审核记录id
    private Integer id;

    //角色
    private String role;

    // 描述
    private String description;

    //结果
    private String auditResult;

}
