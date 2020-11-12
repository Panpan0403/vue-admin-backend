package com.own.backend.admin.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.own.backend.admin.Entity.Login;
import com.own.backend.admin.Entity.User;
import com.own.backend.admin.Mapper.UserMapper;
import com.own.backend.admin.Request.LoginReq;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author fangting
 * @create 2020/11/4 14:58
 * @description
 **/
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Resource
    private SnowFlakeIdService idService;
    @Resource
    private LoginService loginService;

    /**
     * 新增用户
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean saveUser(User user, Login login){
        Long id = idService.nextId();
        user.setId(id);
        user.setCreateBy("admin");
        user.setUpdateBy("admin");
        login.setUid(id);
        BeanUtils.copyProperties(user, login);
        return this.save(user) && loginService.save(login);
    }

    /**
     * 更新用户
     */
    public boolean updateUser(User user){
        return this.updateById(user);
    }

    /**
     * 获取用户
     */
    public User getUser(Long userId){
        return this.getById(userId);
    }

}
