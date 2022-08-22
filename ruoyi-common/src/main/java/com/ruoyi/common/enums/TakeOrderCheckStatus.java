package com.ruoyi.common.enums;

/**
 * ClassName TakeOrderCheckStatus
 * Description
 * Create by gfy
 * Date 2022/8/13 12:04
 */
public enum TakeOrderCheckStatus {
    CHECK(new Integer("1"), "质检完成"),
    NOCHECK(new Integer("2"), "未质检"),
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    TakeOrderCheckStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
