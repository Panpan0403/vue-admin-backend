package com.own.backend.admin.Controller;

import com.own.backend.admin.Common.Message;
import com.own.backend.admin.Config.JwtConfig;
import com.own.backend.admin.Entity.User;
import com.own.backend.admin.Enums.Code;
import com.own.backend.admin.Vo.Request.UserReq;
import com.own.backend.admin.Service.ServiceImpl.UserService;
import com.own.backend.admin.Util.JwtTokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author fangting
 * @create 2020/11/3 14:19
 * @description 用户模块
 **/
@RestController
@RequestMapping("user")
@Api(value = "用户模块", tags="用户模块")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("新增用户")
    @PostMapping
    public Message<Boolean> save(@Valid @RequestBody UserReq userReq){
        return Message.success(userService.saveUser(userReq.toUser(userReq), userReq.toLogin(userReq)));
    }

    @ApiOperation("更新用户")
    @PatchMapping
    public Message<Boolean> update(@RequestBody User user){
        return Message.success(userService.updateUser(user));
    }

    @ApiOperation("获取用户")
    @GetMapping
    public Message<User> get(@RequestParam Long id){
        return Message.success(userService.getUser(id));
    }


    @GetMapping("/getUserByToken")
    @ApiOperation(value = "根据token得到用户信息")
    public Message getUserDetailByToken(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader(JwtConfig.TOKEN_HEADER);
        if (token != null && StringUtils.startsWith(token, JwtConfig.TOKEN_PREFIX)) {
            token = StringUtils.substring(token, JwtConfig.TOKEN_PREFIX.length());
            User user = userService.getByName(JwtTokenUtils.getUsername(token));
            List<String> roles = new ArrayList<>();
            roles.add("admin");
            user.setRoles(roles);
            return Message.success(user);
        } else {
            return new Message(Code.PERMISSION_TOKEN_EXPIRED.getCode(), Code.PERMISSION_TOKEN_EXPIRED.getMessage());
        }
    }
}
