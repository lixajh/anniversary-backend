package com.peake.webseed.core;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(EnumResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(EnumResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(EnumResultCode.FAIL)
                .setMessage(message);
    }
    public static Result genFailResult(EnumErrorCode errorCode) {
        return new Result()
                .setCode(EnumResultCode.FAIL)
                .setErrorCode(errorCode);
    }
    public static Result genNotAuthResult(){
        return new Result()
                .setCode(EnumResultCode.UNAUTHORIZED)
                .setMessage("未登录");
    }
}
