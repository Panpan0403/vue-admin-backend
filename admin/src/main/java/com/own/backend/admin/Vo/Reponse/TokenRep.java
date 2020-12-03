package com.own.backend.admin.Vo.Reponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author fangting
 * @create 2020/12/2 13:44
 * @description
 **/
@Data
@ApiModel("登录出参")
public class TokenRep {

    @ApiModelProperty("token")
    private String token;

    public TokenRep(String token) {
        this.token = token;
    }
}
