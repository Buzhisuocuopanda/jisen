package com.ruoyi.common.enums;

public enum TaskStatus {
    mr(new Integer("0"), "未审核"),

    sh(new Integer("1"), "审核"),
    fsh(new Integer("2"), "反审"),
    qxwc(new Integer("3"), "取消完成"),
    bjwc(new Integer("4"), "标记完成"),




    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    TaskStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
