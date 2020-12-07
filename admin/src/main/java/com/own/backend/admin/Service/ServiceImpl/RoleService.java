package com.own.backend.admin.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.own.backend.admin.Entity.Role;
import com.own.backend.admin.Mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author fangting
 * @create 2020/12/3 16:39
 * @description
 **/
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {
    @Resource
    private RoutesService routesService;
    /**
     * 获取角色列表及各角色权限集合
     */
    public List<Role> getList() {
        List<Role> list = this.list();
        for(Role role : list) {
            role.setRoutes(routesService.getRoutes(role.getName()));
        }
        return list;
    }
}
