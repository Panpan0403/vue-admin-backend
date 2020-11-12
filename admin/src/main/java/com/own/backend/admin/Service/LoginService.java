package com.own.backend.admin.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.own.backend.admin.Entity.Login;
import com.own.backend.admin.Mapper.LoginMapper;
import com.own.backend.admin.Request.LoginReq;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * @Author fangting
 * @create 2020/11/10 16:47
 * @description
 **/
@Service
public class LoginService extends ServiceImpl<LoginMapper, Login> {

    /**
     * 登录验证
     */
    public Long login(@Valid LoginReq loginReq) {
        return baseMapper.login(loginReq.getUsername(), loginReq.getPassword());
    }
}
