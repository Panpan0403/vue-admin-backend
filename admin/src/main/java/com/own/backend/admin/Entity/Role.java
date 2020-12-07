package com.own.backend.admin.Entity;

import com.baomidou.mybatisplus.annotation.*;
import com.own.backend.admin.Vo.Reponse.RoutesRep;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author fangting
 * @create 2020/12/3 16:30
 * @description 角色实体
 **/
@Data
@ApiModel("角色表")
@TableName("role")
public class Role extends BaseEntity{
    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @ApiModelProperty("name")
    private String name;

    @ApiModelProperty("description")
    private String description;

    @TableField(exist = false)
    @ApiModelProperty("权限集合")
    private List<AuthRoute> routes;
}
