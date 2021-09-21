package com.lordma.employ.system.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Description JWTToken
 * @Author lordma
 * @Date 2020/5/20 10:44
 * @Version 1.0
 */
public class JWTToken implements AuthenticationToken {


    private static final long serialVersionUID = 6927704016438843691L;
    /**
     * 密钥
     */
    private String token;

    public JWTToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
