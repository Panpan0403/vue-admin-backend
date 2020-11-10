package com.own.backend.admin.Handler;

import com.own.backend.admin.Common.BusinessException;
import com.own.backend.admin.Common.Result;
import com.own.backend.admin.Enums.Code;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * @Author fangting
 * @create 2020/11/9 15:11
 * @description 统一异常处理返回数据
 **/
@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseBody//返回json格式数据
    public Result<Object> handlerException(BusinessException bx) {
        Code code = bx.getCode();
        return new Result<>(code.getCode(),code.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<Object> validExceptionHandler(MethodArgumentNotValidException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        assert fieldError != null;
        return new Result<>(Code.VALIDATE_FAILED.getCode(), fieldError.getDefaultMessage());
    }
}
