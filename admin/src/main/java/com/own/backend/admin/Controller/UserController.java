package com.own.backend.admin.Controller;

import com.own.backend.admin.Common.Result;
import com.own.backend.admin.Entity.User;
import com.own.backend.admin.Request.SaveUserReq;
import com.own.backend.admin.Request.UserIdReq;
import com.own.backend.admin.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    public Result<Boolean> save(@Valid @RequestBody SaveUserReq userReq){
        return Result.success(userService.saveUser(userReq.toUser(userReq)));
    }

    @ApiOperation("更新用户")
    @PostMapping("update")
    public Result<Boolean> update(@RequestBody User user){
        return Result.success(userService.updateUser(user));
    }

    @ApiOperation("获取用户")
    @GetMapping("getUser")
    public Result<User> get(@RequestBody UserIdReq idReq){
        return Result.success(userService.getUser(idReq.getUserId()));
    }
}
