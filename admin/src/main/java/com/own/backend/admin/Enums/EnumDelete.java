package com.own.backend.admin.Enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @Author fangting
 * @create 2020/11/4 16:04
 * @description 删除枚举
 **/
@Getter
public enum EnumDelete {
    Y("Y", "已删除"),
    N("N", "未删除");

    @EnumValue
    @JsonValue
    private String code;
    private String message;

    EnumDelete(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
