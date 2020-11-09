package com.own.backend.admin.Common;

import com.own.backend.admin.Enums.Code;
import lombok.Data;

/**
 * @Author fangting
 * @create 2020/11/9 14:13
 * @description 业务统一异常处理
 **/
@Data
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = -1924284503499932262L;

    private Code code;

    public BusinessException(Code code) {
        this.code = code;
    }
}
