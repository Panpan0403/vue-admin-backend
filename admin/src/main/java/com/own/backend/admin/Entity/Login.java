package com.own.backend.admin.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author fangting
 * @create 2020/11/10 15:53
 * @description 登录实体
 **/
@ApiModel("登陆表")
@Data
@TableName("login")
public class Login extends BaseEntity{
    @ApiModelProperty("用户id")
    @TableId(value = "uid", type = IdType.INPUT)
    private Long uid;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;
}
