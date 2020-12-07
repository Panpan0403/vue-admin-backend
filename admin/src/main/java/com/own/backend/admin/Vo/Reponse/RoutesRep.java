package com.own.backend.admin.Vo.Reponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author fangting
 * @create 2020/12/4 14:22
 * @description 所有角色路由权限出参
 **/
@Data
@ApiModel("所有角色路由权限出参")
public class RoutesRep {
    @ApiModelProperty("所有角色路由权限 Map(path, List of roles)")
    private Map<String, List<String>> routesMap;
}
