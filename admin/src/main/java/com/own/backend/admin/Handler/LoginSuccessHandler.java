package com.own.backend.admin.Handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.own.backend.admin.Common.BusinessException;
import com.own.backend.admin.Common.Message;
import com.own.backend.admin.Config.JwtConfig;
import com.own.backend.admin.Entity.User;
import com.own.backend.admin.Enums.Code;
import com.own.backend.admin.Service.ServiceImpl.UserService;
import com.own.backend.admin.Util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @Author fangting
 * @create 2020/12/2 15:38
 * @description
 **/
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        try {
            User user = userService.getByName(authentication.getName());

            String token = JwtConfig.TOKEN_PREFIX  + JwtTokenUtils.createToken(user);

            // 重定向
            response.setHeader(JwtConfig.TOKEN_HEADER, token);
            response.getWriter().write(objectMapper.writeValueAsString(Message.success(token)));
        } catch (Exception e) {
            throw new BusinessException(Code.PERMISSION_TOKEN_EXPIRED);
        }

    }

}
