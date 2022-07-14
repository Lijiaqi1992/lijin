package com.ljq.plugins.base.security.jwt;

import com.ljq.plugins.base.common.CommonTools;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2022-01-09
 */
public class LjqJwt {

    private final static String jwtHeader = "{\"typ\":\"JWT\",\"alg\":\"HS256\"}";

    private final static String secretKey = "Ij9KEl1lObo00(8sd8L3d8In2J";

    /**
     * token生成
     *
     * @param userId
     * @param userName
     * @return
     */
    public static String generateToken(String userId, String userName) {
        Date date = new Date();
        JwtBuilder builder = Jwts.builder()
                .setId(userId)   //设置唯一编号
                .setSubject(userName)//设置主题  可以是JSON数据
                .setIssuedAt(date)//设置签发日期
                .setExpiration(CommonTools.addDays(date, 1))
                .signWith(SignatureAlgorithm.HS256, secretKey);//设置签名 使用HS256算法，并设置SecretKey(字符串)
        return builder.compact();
    }

    /**
     * token解析
     * @param compactJwt
     * @return
     */
    public static Claims decodeToken(String compactJwt) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(compactJwt).getBody();
    }
}
