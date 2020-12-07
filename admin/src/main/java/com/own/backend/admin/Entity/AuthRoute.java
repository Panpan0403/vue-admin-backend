package com.own.backend.admin.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author fangting
 * @create 2020/12/3 16:30
 * @description 角色路由权限实体
 **/
@Data
@ApiModel("角色路由权限表")
@TableName("auth_route")
public class AuthRoute extends BaseEntity{
    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @ApiModelProperty("路径")
    private String path;

    @ApiModelProperty("角色")
    private String role;
}
