package com.hwadee.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hwadee.entity.User;

import java.util.Date;

public class TokenUtil {
    // token过期时间
    private static final long EXPIRE_TIME = 30*60*1000;

    // token的密钥
    private static final String TOKEN_SECRET = "hwadee";

    public static String sign(User user){
        String token = null;

        try{
            Date expireAt = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("userAccount", user.getAccount())
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        }catch(Exception e) {
            e.printStackTrace();
        }
        return token;
    }
}
