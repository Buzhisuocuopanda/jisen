package com.ruoyi.common.enums;

public enum Task1Status {


    wsh(new Integer("1"), "未审核"),
    ysh(new Integer("2"), "已审核"),





    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    Task1Status(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
