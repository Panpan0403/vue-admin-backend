package com.own.backend.admin.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.own.backend.admin.Entity.Login;
import com.own.backend.admin.Entity.User;

/**
 * @Author fangting
 * @create 2020/11/10 16:48
 * @description
 **/
public interface LoginMapper extends BaseMapper<Login> {
    /**
     * 登录
     */
    User login(String username, String password);
}
