package com.ruoyi.common.enums;

import lombok.Data;

/**
 * ClassName ScanStatusEnum
 * Description
 * Create by gfy
 * Date 2022/8/15 11:45
 */
public enum ScanStatusEnum {
    WEISAOMA(new Integer("0"), "未扫码"),
    YISAOMA(new Integer("1"), "已扫码"),

    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ScanStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ScanStatusEnum findByKey(int i) {
        ScanStatusEnum[] testEnums = ScanStatusEnum.values();
        for (ScanStatusEnum testEnum : testEnums) {
            if (testEnum.code == i) {
                return testEnum;
            }
        }
        return null;
    }
}
