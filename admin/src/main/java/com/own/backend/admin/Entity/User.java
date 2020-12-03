package com.own.backend.admin.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * @Author fangting
 * @create 2020/11/3 18:42
 * @description
 **/
@ApiModel("用户表")
@Data
@TableName("user")
public class User extends BaseEntity{

    @ApiModelProperty("主键id")
    @TableId(value = "id",type = IdType.INPUT)
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("头像")
    private String avatar = "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif";

    @ApiModelProperty("介绍")
    private String introduction = "这个人很懒什么也没有留下。";

    @ApiModelProperty("权限")
    @TableField(exist = false)
    private List<String> roles;
}
