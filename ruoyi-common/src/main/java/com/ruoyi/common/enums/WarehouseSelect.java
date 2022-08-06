package com.ruoyi.common.enums;

public enum WarehouseSelect {
    CBW(new Integer("3"), "数量仓库"),
    GLW(new Integer("4"), "数量仓库"),
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    WarehouseSelect(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

