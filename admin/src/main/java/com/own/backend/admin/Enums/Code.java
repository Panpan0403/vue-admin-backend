package com.own.backend.admin.Enums;

/**
 * @Author fangting
 * @create 2020/10/16 10:27
 * @description 返回Code枚举
 **/
public enum Code {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(405, "参数校验失败"),
    UNAUTHORIZED(401, "暂未登录或token已过期"),
    FORBIDDEN(403, "没有相关权限"),
    USEREXIST(501, "用户已存在");
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
