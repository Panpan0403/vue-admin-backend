package com.own.backend.admin.Request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author fangting
 * @create 2020/11/6 16:37
 * @description
 **/
@ApiModel("用户Id请求参数")
@Data
public class UserIdReq {
    @ApiModelProperty("用户Id")
    @NotEmpty(message = "用户Id不能为空")
    public Long userId;
}
