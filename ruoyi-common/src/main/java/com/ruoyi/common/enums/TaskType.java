package com.ruoyi.common.enums;

public enum TaskType {
    cqrk(new Byte("0"), "初期入库"),
    cgrkd(new Byte("1"), "采购入库单"),
    cgtkd(new Byte("2"), "采购退库单"),
    xsckd(new Byte("3"), "销售发货单"),
    xstkd(new Byte("4"), "销售退库单"),

    xsthd(new Byte("6"), "调拨单调入"),
    zjd(new Byte("7"), "调拨单调出"),
    xsdd(new Byte("10"), "销售订单"),
    xsddcwfs(new Byte("10"), "销售订单财务复审"),



    ;

    private Byte code;

    private String msg;

    public Byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    TaskType(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
