package com.own.backend.admin.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.own.backend.admin.Config.JwtConfig;
import com.own.backend.admin.Entity.User;
import com.own.backend.admin.Service.ServiceImpl.UserService;
import com.own.backend.admin.Util.JwtTokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @program: paz
 * @description: token过滤器，用来验证token的有效性
 * @author: wangzh
 * @create: 2019-03-21 15:41
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(JwtConfig.TOKEN_HEADER);
        if(token != null && StringUtils.startsWith(token, JwtConfig.TOKEN_PREFIX)) {
            token = StringUtils.substring(token, JwtConfig.TOKEN_PREFIX.length());
        } else {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            String username = JwtTokenUtils.getUsername(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                /*
                 *  注意：
                 *       这里代码不应该从数据库中去查，而是从缓存中根据token去查，目前只是做测试，无关紧要
                 *      如果是真正的项目实际开发需要增加缓存
                 */
                User user = userService.getByName(username);

                if (JwtTokenUtils.validateToken(token, user)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            user, null, null);
                    authentication.setDetails(new WebAuthenticationDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

            }
        } catch (Exception e) {
            throw e;
        }
        filterChain.doFilter(request, response);
    }
}

