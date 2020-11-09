package com.own.backend.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author fangting
 * @create 2020/10/16 10:27
 * @description 返回Code枚举
 **/
public enum ErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数校验失败"),
    UNAUTHORIZED(401, "暂未登录或token已过期"),
    FORBIDDEN(403, "没有相关权限");
    private Long code;
    private String message;
    private static Map<Long, ErrorCode> codeMap = new HashMap<Long, ErrorCode>();

    /**
     * 初始化MAP
     **/
    static{
        for(ErrorCode item : values()) {
            codeMap.put(item.getCode(), item);
        }
    }

    ErrorCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode(){
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getMessageByCode(Long code) {
        return codeMap.get(code).getMessage();
    }
}
