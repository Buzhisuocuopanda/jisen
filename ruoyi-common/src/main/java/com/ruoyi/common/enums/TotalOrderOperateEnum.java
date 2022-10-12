package com.ruoyi.common.enums;

/**
 * ClassName TotalOrderOperateEnum
 * Description
 * Create by gfy
 * Date 2022/8/3 17:55
 */
public enum TotalOrderOperateEnum {


    MAKEORDER(new Integer("1"), "创建生产订单"),
    MDFPRIORITY(new Integer("2"), "修改优先级"),
    MDFQTY(new Integer("3"), "修改数量"),
    DELETE(new Integer("4"), "删除"),
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    TotalOrderOperateEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
