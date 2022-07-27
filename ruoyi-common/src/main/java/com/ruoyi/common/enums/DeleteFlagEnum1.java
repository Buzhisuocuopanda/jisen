package com.ruoyi.common.enums;

public enum DeleteFlagEnum1 {
    DELETE(new Byte("1"), "已删除"),
     NOT_DELETE(new Byte("-1"), "未删除"),
    ;

    private Byte code;

    private String msg;

    public Byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    DeleteFlagEnum1(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
