package com.own.backend.admin.Controller;

import com.own.backend.admin.Common.BusinessException;
import com.own.backend.admin.Common.Result;
import com.own.backend.admin.Enums.Code;
import com.own.backend.admin.Request.LoginReq;
import com.own.backend.admin.Service.ServiceImpl.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author fangting
 * @create 2020/11/11 15:34
 * @description
 **/
@RestController
@RequestMapping("/")
@Api(value = "登录模块", tags = "登录模块")
public class LoginController {

    @Resource
    private LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("login")
    public Result<String> login(@Valid @RequestBody LoginReq loginReq){
        String token = loginService.login(loginReq);
        if(token == null)
            throw new BusinessException(Code.LOGIN_FAILED);
        return Result.success(token);
    }

}
