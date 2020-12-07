package com.own.backend.admin.Util;

import java.util.Date;
import java.util.HashMap;

import com.own.backend.admin.Common.BusinessException;
import com.own.backend.admin.Entity.User;

import com.own.backend.admin.Enums.Code;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.swing.plaf.synth.SynthScrollBarUI;

import static com.own.backend.admin.Config.JwtConfig.*;


/**
 * @author : wangzh
 * @version V1.0
 * @Description: jwt工具类
 */
public class JwtTokenUtils {
    /**
     * 创建token
     */
    public static String createToken(User user){
        long expiration = EXPIRATION;

        HashMap<String, Object> map = new HashMap<>();

        map.put("userInfo", user); // 角色名字
        return Jwts.builder().signWith(SignatureAlgorithm.HS512, SECRET) // 加密算法
                .setClaims(map) // 自定义信息
                .setIssuer(ISS) // jwt发行人
                .setSubject(user.getUsername()) // jwt面向的用户
                .setIssuedAt(new Date()) // jwt发行人
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // key过期时间
                .compact();
    }

    /**
     * 从token获取用户信息
     * @return
     */
    public static String getUsername(String token){
        return getTokenBody(token).getSubject();
    }

    /**
     * 是否已过期
     */
    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    /**
     * 验证token
     */
    public static boolean validateToken(String token, User user){
        if(user == null) return false;
        final String username = getUsername(token);
        return (username.equals(user.getUsername()) && isExpiration(token) == false);
    }

}