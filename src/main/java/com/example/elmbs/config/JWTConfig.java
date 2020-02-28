package com.example.elmbs.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT配置类
 * @Author Sans
 * @CreateTime 2019/10/1 22:56
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTConfig {
    /**
     * 密钥KEY
     */
    @Value("${jwt.secret}")
    public  String secret;
    /**
     * TokenKey
     */
    @Value("${jwt.tokenHeader}")
    public  String tokenHeader;
    /**
     * Token前缀字符
     */
    @Value("${jwt.tokenPrefix}")

    public  String tokenPrefix;

    public String getSecret() {
        return secret;
    }

    public String getTokenHeader() {
        return tokenHeader;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public Integer getExpiration() {
        return expiration;
    }

    /**
     * 过期时间
     */
    @Value("${jwt.expiration}")

    public  Integer expiration;



    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public void setExpiration(Integer expiration) {
        this.expiration = expiration * 1000;
    }

}
