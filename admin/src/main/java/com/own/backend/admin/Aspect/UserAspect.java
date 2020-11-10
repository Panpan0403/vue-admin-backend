package com.own.backend.admin.Aspect;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.own.backend.admin.Common.BusinessException;
import com.own.backend.admin.Entity.User;
import com.own.backend.admin.Enums.Code;
import com.own.backend.admin.Service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author fangting
 * @create 2020/11/9 10:52
 * @description 用户切片
 **/
@Aspect
@Component
public class UserAspect {

    @Resource
    private UserService userService;

    @Pointcut("execution( * com.own.backend.admin.Service.UserService.saveUser(com.own.backend.admin.Entity.User,..))&&args(user,..)")
    public void pointcutSave(User user) {
    }

    @Before("pointcutSave(user)")
    public void beforeSaveMethod(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUsername, user.getUsername());
        User res = userService.getOne(wrapper);
        if(res != null)
            throw new BusinessException(Code.USEREXIST);
    }
}
