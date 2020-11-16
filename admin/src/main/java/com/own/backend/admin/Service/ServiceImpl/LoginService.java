package com.own.backend.admin.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.own.backend.admin.Common.BusinessException;
import com.own.backend.admin.Entity.Login;
import com.own.backend.admin.Entity.User;
import com.own.backend.admin.Enums.Code;
import com.own.backend.admin.Mapper.LoginMapper;
import com.own.backend.admin.Request.LoginReq;
import com.own.backend.admin.Util.JwtTokenUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * @Author fangting
 * @create 2020/11/10 16:47
 * @description
 **/
@Service
public class LoginService extends ServiceImpl<LoginMapper, Login>{

    /**
     * 登录验证
     */
    public String login(@Valid LoginReq loginReq) {
        User user = baseMapper.login(loginReq.getUsername(), loginReq.getPassword());
        if(user == null)
            throw new BusinessException(Code.LOGIN_FAILED);
        else return JwtTokenUtils.createToken(user);
    }
}
