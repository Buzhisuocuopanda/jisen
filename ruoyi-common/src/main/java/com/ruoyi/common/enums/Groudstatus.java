package com.ruoyi.common.enums;

public enum Groudstatus {
    SJ(new Byte("1"), "上架"),
    XJ(new Byte("2"), "已下架"),
    ;

    private Byte code;

    private String msg;

    public Byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    Groudstatus(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}


