package com.yb.luckycoffeebackend.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    // ⚠️ 修复：使用一个固定的字符串作为密钥，而不是每次随机生成
    // 在实际项目中，这个字符串应该放在 application.yml 配置文件中
    private static final String SECRET_STRING = "MySuperSecretKeyForLuckyCoffeeProject2026!@#$%";
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET_STRING.getBytes());

    // 生成 Token
    public static String createToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24小时过期
                .signWith(KEY)
                .compact();
    }

    // 解析 Token
    public static String getUsernameFromToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .get("username", String.class);
        } catch (Exception e) {
            return null;
        }
    }
}