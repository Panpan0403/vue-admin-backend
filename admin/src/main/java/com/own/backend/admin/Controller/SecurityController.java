package com.own.backend.admin.Controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.own.backend.admin.Common.BusinessException;
import com.own.backend.admin.Enums.Code;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: paz
 * @description: 发送请求，如果token为空，跳转到这个controller
 * @author: wangzh
 * @create: 2019-03-21 15:41
 */
@RestController
@RequestMapping("auth")
@Api(value = "身份验证", tags = "身份验证")
public class SecurityController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 当需要身份认证时，跳转到这里
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public void requireAuthentication(HttpServletRequest request, HttpServletResponse response){
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                // TODO 跳转到登陆页面
                //redirectStrategy.sendRedirect(request, response, "/login.html");
            }
        }
        throw new BusinessException(Code.NO_LOGIN);
    }
}
