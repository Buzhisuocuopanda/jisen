package com.ruoyi.common.enums;

public enum GoodsType {

    yrk(new Byte("1"), "已入库"),
    ckz(new Byte("2"), "出库中"),
    yck(new Byte("3"), "已出库"),




    ;

    private Byte code;

    private String msg;

    public Byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    GoodsType(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
