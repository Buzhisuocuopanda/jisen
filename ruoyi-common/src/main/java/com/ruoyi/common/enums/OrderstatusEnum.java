package com.ruoyi.common.enums;

public enum OrderstatusEnum {
    DAISHENPI(new Byte("1"), "待审批"),
    YISHENPI(new Byte("2"), "已审批"),
    FUSHENWANCHENG(new Byte("3"), "复审完成"),
    ;

    private Byte code;

    private String msg;

    public Byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    OrderstatusEnum(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
