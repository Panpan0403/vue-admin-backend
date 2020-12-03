package com.own.backend.admin.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author fangting
 * @create 2020/11/16 14:47
 * @description JWT配置
 **/
@Component
public class JwtConfig {
    public static String TOKEN_HEADER;

    public static String TOKEN_PREFIX;
    /**
     * 密钥key
     */
    public static String SECRET;

    /**
     * JWT的发行人
     */
    public static String ISS;

    /**
     * 过期时间是3600秒，既是1个小时
     */
    public static long EXPIRATION;

    @Value("${jwt.header}")
    public void setTokenHeader(String tokenHeader) {
        JwtConfig.TOKEN_HEADER = tokenHeader;
    }

    @Value("${jwt.prefix}")
    public void setTokenPrefix(String tokenPrefix) {
        JwtConfig.TOKEN_PREFIX = tokenPrefix;
    }

    @Value("${jwt.secret}")
    public void setSECRET(String secret) {
        JwtConfig.SECRET = secret;
    }

    @Value("${jwt.iss}")
    public void setISS(String iss) {
        JwtConfig.ISS = iss;
    }

    @Value("${jwt.expiration}")
    public void setExpiration(long expiration) {
        JwtConfig.EXPIRATION = expiration;
    }
}
