package com.lordma.employ.common.base.component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @Description TODO
 * @Author lordma
 * @Date 2020/5/5 10:15
 * @Version 1.0
 */
@Component
public class JwtComponent {
    /**
     * 过期时间
     */
    @Value("#{${system.expireTime}}")
    private Map<String, Long> expireTime;
    /**
     * 生成签名,expireTime后过期
     *
     * @param loginAccount
     *            用户账号
     * @param secret
     *            用户的密码
     * @param expTimeType
     *            (1、web 2、 app) 失效时间类型
     * @return 加密的token
     */
    public String sign(String loginAccount, String secret, String expTimeType) {
        try {
            long expTime = expireTime.get(expTimeType);
            Date date = new Date(System.currentTimeMillis() + expTime);
            Algorithm algorithm = Algorithm.HMAC256(loginAccount + secret);
            // 附带username信息
            return JWT.create().withClaim("loginAccount", loginAccount).withExpiresAt(date).sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 校验token是否正确
     *
     * @param token
     *            密钥
     * @param secret
     *            用户的密码
     * @return 是否正确
     */
    public boolean verify(String token, String loginAccount, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(loginAccount + secret);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("loginAccount", loginAccount).build();
            verifier.verify(token);
            return true;
        } catch (TokenExpiredException expiredException) {
            throw expiredException;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public String getUserAccount(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("loginAccount").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得token中的过期时间，判断是否重新生成token
     *
     * @return token中包含的过期时间
     */
    public Date getExpiresAt(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getExpiresAt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
