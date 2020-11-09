package com.own.backend.api;

import com.own.backend.enums.ErrorCode;

/**
 * @Author fangting
 * @create 2020/10/16 10:23
 * @description 通用返回对象
 **/
public class CommonResult<T>{
    private Long code;
    private String message;
    private  T data;

    protected CommonResult(){}

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    protected CommonResult(long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 成功
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), data);
    }

    /**
     * 失败
     */
    public static  <T> CommonResult<T> error(long code) {
        return new CommonResult<T>(code, ErrorCode.getMessageByCode(code));
    }
}
