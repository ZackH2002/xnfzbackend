package com.hwadee.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hwadee.entity.User;

import java.util.Date;

public class TokenUtil {
    // token过期时间为30min
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

    public static boolean verify(String token){
        try{
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过");
            System.out.println("userAccount:"+jwt.getClaim("userAccount").asString());
            System.out.println("过期时间"+jwt.getExpiresAt());
            return true;
        }catch (Exception e){
            return false;
        }
    }


    // 测试
//    public static void main(String[] args) {
//        //生成Token
////        User u = new User();
////        String sign = sign(u);
////        System.out.println(sign);
//        //验证Token
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCIsImV4cCI6MTY5MDYxMzUwMH0.ZoMXomxQMx-l2pi" +
//                "D3Xgj36xXwD_8MAeDUaFVMSQER4o";
//        System.out.println(verify(token));
//    }
}
