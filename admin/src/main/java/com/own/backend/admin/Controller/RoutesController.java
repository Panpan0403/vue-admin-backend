package com.own.backend.admin.Controller;

import com.own.backend.admin.Common.Message;
import com.own.backend.admin.Entity.AuthRoute;
import com.own.backend.admin.Service.ServiceImpl.RoleService;
import com.own.backend.admin.Service.ServiceImpl.RoutesService;
import com.own.backend.admin.Vo.Reponse.RoutesRep;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author fangting
 * @create 2020/12/3 14:22
 * @description
 **/
@RestController
@Api(value = "路由权限模块", tags = "路由权限模块")
@RequestMapping("routes")
public class RoutesController {

    @Resource
    private RoutesService routesService;

    @ApiOperation("获取admin对应的路由权限")
    @GetMapping
    public Message<List<AuthRoute>> getRoutes() {
        return Message.success(routesService.getRoutes("admin"));
    }
}
