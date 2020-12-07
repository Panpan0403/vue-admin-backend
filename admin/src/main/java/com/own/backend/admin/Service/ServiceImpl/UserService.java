package com.own.backend.admin.Service.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.own.backend.admin.Entity.Login;
import com.own.backend.admin.Entity.User;
import com.own.backend.admin.Mapper.UserMapper;
import com.own.backend.admin.Service.BaseInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author fangting
 * @create 2020/11/4 14:58
 * @description
 **/
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements BaseInterface<User> {
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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        login.setPassword(encoder.encode(login.getPassword()));
        this.save(user);
        loginService.save(login);
        return true;
    }

    /**
     * 更新用户
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(User user){
        return this.updateById(user);
    }

    /**
     * 获取用户
     */
    public User getUser(Long userId){
        return this.getById(userId);
    }

    public User getByName(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, name);
        return this.getOne(queryWrapper);
    }
}
