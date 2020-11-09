package com.own.backend.admin.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.own.backend.admin.Entity.User;
import com.own.backend.admin.Mapper.UserMapper;
import com.own.backend.admin.Request.SaveUserReq;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author fangting
 * @create 2020/11/4 14:58
 * @description
 **/
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Resource
    private SnowFlakeIdService idService;
    /**
     * 新增用户
     */
    public boolean saveUser(SaveUserReq userReq){
        User user = new User();
        BeanUtils.copyProperties(userReq, user);
        user.setId(idService.nextId());
        user.setCreateBy("admin");
        user.setUpdateBy("admin");
        this.save(user);
        return true;
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
