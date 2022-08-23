package com.ruoyi.common.enums;

public enum checkstatusEnum  {
    ZJWC(new Byte("1"), "质检完成"),
    WZJ(new Byte("2"), "未质检"),
    ;

    private Byte code;

    private String msg;

    public Byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    checkstatusEnum(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
