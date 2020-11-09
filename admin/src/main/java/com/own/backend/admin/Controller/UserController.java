package com.own.backend.admin.Controller;

import com.own.backend.admin.Entity.User;
import com.own.backend.admin.Request.SaveUserReq;
import com.own.backend.admin.Request.UserIdReq;
import com.own.backend.admin.Service.UserService;
import com.own.backend.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author fangting
 * @create 2020/11/3 14:19
 * @description
 **/
@RestController
@RequestMapping("user")
@Api(value = "用户模块", tags="用户模块")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("新增用户")
    @PostMapping("save")
    public CommonResult<Boolean> save(@RequestBody SaveUserReq userReq){
        return CommonResult.success(userService.saveUser(userReq));
    }

    @ApiOperation("更新用户")
    @PostMapping("update")
    public CommonResult<Boolean> update(@RequestBody User user){
        return CommonResult.success(userService.updateUser(user));
    }

    @ApiOperation("获取用户")
    @GetMapping("getUser")
    public CommonResult<User> get(@RequestBody UserIdReq idReq){
        return CommonResult.success(userService.getUser(idReq.getUserId()));
    }
}
