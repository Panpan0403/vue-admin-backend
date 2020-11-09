package com.own.backend.admin.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


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

    @ApiModelProperty("密码")
    private String password;
}
