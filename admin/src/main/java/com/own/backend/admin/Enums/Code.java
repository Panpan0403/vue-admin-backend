package com.own.backend.admin.Enums;

/**
 * @Author fangting
 * @create 2020/10/16 10:27
 * @description 返回Code枚举
 **/
public enum Code {
    SUCCESS(200, "success"),
    FAILED(500, "error"),
    VALIDATE_FAILED(400, "参数校验失败"),
    PERMISSION_TOKEN_EXPIRED(401, "未登录或token已过期"),
    PERMISSION_TOKEN_INVALID(402, "token解析异常"),
    PERMISSION_SIGNATURE_ERROR(403, "签名失败"),
    NO_LOGIN(405, "未登录"),
    USERNAME_EXIST(501, "用户名称重复"),
    LOGIN_FAILED(502, "用户不存在或密码不正确");
    private int code;
    private String message;

    Code(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }

    public String getMessage() {
        return message;
    }
}
