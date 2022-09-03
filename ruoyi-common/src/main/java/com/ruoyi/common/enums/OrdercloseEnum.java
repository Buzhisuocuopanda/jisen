package com.ruoyi.common.enums;

public enum OrdercloseEnum {

    JIESHU(new Byte("1"), "结束"),
    WEIJIESHU(new Byte("2"), "未结束"),
    ;

    private Byte code;

    private String msg;

    public Byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    OrdercloseEnum(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
