package com.own.backend.admin.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.own.backend.admin.Entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author fangting
 * @create 2020/11/6 13:24
 * @description
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
