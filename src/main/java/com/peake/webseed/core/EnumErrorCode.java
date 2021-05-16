package com.peake.webseed.core;

public enum EnumErrorCode {


    PARAM_ERROR(-999, "参数错误"),
    LOGIN_TIME_OUT_ERROR(-997, "用户登录超时"),
    LOGIN_OTHER_ERROR(-996, "用户在别处登录"),
    MEMBER_FROZEN_ERROR(-995, "会员冻结"),
    MEMBER_NOT_ACTIVATE_ERROR(-994, "会员未激活"),

    OTHER_ERROR(-1, "其他错误");

    private int value;
    private String desc;


    private EnumErrorCode(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static EnumErrorCode setValue(int code) {
        for (EnumErrorCode e : EnumErrorCode.values()) {
            if (e.getValue() == code) {
                return e;
            }
        }
        return OTHER_ERROR;

    }

}
