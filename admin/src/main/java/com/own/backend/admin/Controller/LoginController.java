package com.own.backend.admin.Controller;

import com.own.backend.admin.Common.Message;
import com.own.backend.admin.Vo.Reponse.TokenRep;
import com.own.backend.admin.Vo.Request.LoginReq;
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
    public Message<TokenRep> login(@Valid @RequestBody LoginReq loginReq){
        return Message.success(loginService.login(loginReq));
    }
}
