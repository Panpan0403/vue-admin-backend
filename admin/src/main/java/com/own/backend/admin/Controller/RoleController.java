package com.own.backend.admin.Controller;

import com.own.backend.admin.Common.Message;
import com.own.backend.admin.Entity.Role;
import com.own.backend.admin.Enums.Code;
import com.own.backend.admin.Service.ServiceImpl.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author fangting
 * @create 2020/12/3 16:40
 * @description
 **/
@Api(value = "角色模块", tags = "角色模块")
@RestController
@RequestMapping
public class RoleController {
    @Resource
    private RoleService roleService;

    @ApiOperation("角色列表")
    @GetMapping("/roles")
    public Message<List<Role>> getList() {
        return Message.success(roleService.getList());
    }

    @ApiOperation("删除角色")
    @DeleteMapping("role/{id}")
    public Message delete(@PathVariable Long id) {
        return Message.success(roleService.removeById(id));
    }
}
