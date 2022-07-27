package com.ruoyi.common.enums;

public enum GSSystemUseEnum {
    SPFLXX(new Byte("1"), "商品分类信息"),
    SPXX(new Byte("2"), "商品信息"),
    KWXX(new Byte("3"), "库位信息"),
    KHXX(new Byte("4"), "客户信息"),
    GYSXX(new Byte("4"), "供应商信息"),
    ;

    private Byte code;

    private String msg;

    public Byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    GSSystemUseEnum(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

