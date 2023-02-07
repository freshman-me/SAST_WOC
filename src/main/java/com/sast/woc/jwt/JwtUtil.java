package com.sast.woc.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.sast.woc.entity.User;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    // 密钥
    public static final String SECRET = "sast_2022_woc";

    // token 过期时间: 10天
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 10;

    /**
     * 创造token
     * @param user 个人信息
     * @return token
     */
    public static String createToken(User user) throws Exception{
        // 现在时间
        Date iatDate = new Date();

        // 过期时间
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();

        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        String token = JWT.create().withHeader(map)
                .withClaim("id", user.getId().toString())
                .withClaim("username", user.getUserName())
                .withClaim("isAdmin", user.getRole() != 1 ? 0 : user.getRole())
                .withIssuedAt(iatDate)
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    /**
     * 验证token
     * @param token token
     * @return payload
     */
    public static Map<String, Claim> verifyToken(String token){
        DecodedJWT jwt = null;
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = jwtVerifier.verify(token);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return jwt !=null ? jwt.getClaims(): null;
    }
}
