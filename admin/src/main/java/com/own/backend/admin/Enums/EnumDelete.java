package com.own.backend.admin.Enums;

/**
 * @Author fangting
 * @create 2020/11/4 16:04
 * @description
 **/
public enum EnumDelete {
    Y("Y", "已删除"),
    N("N", "未删除");

    private String code;
    private String message;

    EnumDelete(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
