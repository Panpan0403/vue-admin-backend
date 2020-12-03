package com.own.backend.admin.Common;

import com.own.backend.admin.Enums.Code;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author fangting
 * @create 2020/11/9 10:09
 * @description 通用返回对象
 **/
@Data
@ApiModel("通用返回对象")
public class Message<T> implements Serializable {

    private static long serialVersionUID = -6872727223667337704L;

    @ApiModelProperty("响应码")
    private int code;
    @ApiModelProperty("错误信息")
    private String errMsg;
    @ApiModelProperty("数据体")
    private T data;
    @ApiModelProperty("时间戳")
    private long timestamp = System.currentTimeMillis();

    public Message(int code, String message, T data) {
        this.code = code;
        this.errMsg = message;
        this.data = data;
    }

    public Message(int code, String message) {
        this.code = code;
        this.errMsg = message;
    }

    public static <T> Message<T> success(T data) {
        return new Message<T>((int) Code.SUCCESS.getCode(), Code.SUCCESS.getMessage(), data);
    }
}
