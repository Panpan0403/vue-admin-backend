package com.own.backend.admin.Request;

import com.own.backend.admin.Entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotEmpty;

/**
 * @Author fangting
 * @create 2020/11/6 15:54
 * @description
 **/
@Data
@ApiModel("新增用户请求参数")
public class SaveUserReq {

    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    public User toUser(SaveUserReq userReq) {
        User user = new User();
        BeanUtils.copyProperties(userReq, user);
        return user;
    }
}
