package com.own.backend.admin.Controller;

import com.own.backend.admin.Common.BusinessException;
import com.own.backend.admin.Common.Result;
import com.own.backend.admin.Enums.Code;
import com.own.backend.admin.Request.LoginReq;
import com.own.backend.admin.Service.LoginService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author fangting
 * @create 2020/11/11 15:34
 * @description
 **/
@RestController
@RequestMapping("/")
@ApiModel("登录")
public class LoginController {

    @Resource
    private LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("login")
    public Result<Long> login(@Valid @RequestBody LoginReq loginReq){
        Long uid = loginService.login(loginReq);
        if(uid == null)
            throw new BusinessException(Code.USEREXIST);
        return Result.success(uid);
    }
}
