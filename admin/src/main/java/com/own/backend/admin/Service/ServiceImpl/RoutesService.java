package com.own.backend.admin.Service.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.own.backend.admin.Entity.AuthRoute;
import com.own.backend.admin.Mapper.RoutesMapper;
import com.own.backend.admin.Vo.Reponse.RoutesRep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author fangting
 * @create 2020/12/3 14:27
 * @description
 **/

@Service
public class RoutesService extends ServiceImpl<RoutesMapper, AuthRoute> {

    /**
     * 获取角色下菜单权限
     */
    public List<AuthRoute> getRoutes(String role) {
        RoutesRep routesRep = new RoutesRep();
        QueryWrapper<AuthRoute> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AuthRoute::getRole, role);
        List<AuthRoute> list = this.list(queryWrapper);
        return list;
    }
}
