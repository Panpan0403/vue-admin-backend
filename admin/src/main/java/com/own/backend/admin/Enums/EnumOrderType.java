package com.own.backend.admin.Enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author fangting
 * @create 2020/12/3 10:51
 * @description 订单类型
 **/
@Getter
public enum EnumOrderType {
    success(1, "success"),
    pending(2, "pending");

    @EnumValue
    @JsonValue
    private int code;
    private String message;

    EnumOrderType(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
