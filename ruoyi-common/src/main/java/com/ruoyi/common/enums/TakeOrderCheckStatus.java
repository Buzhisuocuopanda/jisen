package com.ruoyi.common.enums;

/**
 * ClassName TakeOrderCheckStatus
 * Description
 * Create by gfy
 * Date 2022/8/13 12:04
 */
public enum TakeOrderCheckStatus {
    CHECK(new Byte("1"), "质检完成"),
    NOCHECK(new Byte("2"), "未质检"),
    ;

    private Byte code;

    private String msg;

    public Byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    TakeOrderCheckStatus(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
