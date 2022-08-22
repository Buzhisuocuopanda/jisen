package com.ruoyi.common.constant;

/**
 * ClassName AuditStatusConstants
 * Description
 * Create by gfy
 * Date 2022/8/4 14:57
 */
public class AuditStatusConstants {

    /**
     * 销售订单的状态
     * 0：未提交  1：已提交 2：已审核 4:已完成   5已复审 6：指定结束
     */

    public static final Integer SO_NO_COMMIT=0;
    public static final Integer SO_COMMIT=1;
    public static final Integer SO_REVIEWWD=2;
    public static final Integer SO_COMPLETED=4;
    public static final Integer SO_TWO_REV=5;
    public static final Integer SO_SPECIFYEND=6;

}
