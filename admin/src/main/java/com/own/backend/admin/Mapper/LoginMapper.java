package com.own.backend.admin.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.own.backend.admin.Entity.Login;

/**
 * @Author fangting
 * @create 2020/11/10 16:48
 * @description
 **/
public interface LoginMapper extends BaseMapper<Login> {
    /**
     * 登录
     */
    Long login(String username, String password);
}
