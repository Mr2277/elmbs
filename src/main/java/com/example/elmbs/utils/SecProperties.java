package com.example.elmbs.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Jwt参数配置
 * @author Zheng Jie
 * @date 2019年11月28日
 */
//@Data
@Configuration
//@EnableConfigurationProperties(SecProperties.class)
//@ConfigurationProperties(prefix = "jwt")
public class SecProperties {

    /** Request Headers ： Authorization */
    @Value("${jwt.header}")
    private static String header="Authorization";

    /** 令牌前缀，最后留个空格 Bearer */
    @Value("${jwt.token-start-with}")

    private static String tokenStartWith="Bearer";

    /** 必须使用最少88位的Base64对该令牌进行编码 */
    @Value("${jwt.base64-secret}")

    private static String base64Secret="ZmQ0ZGI5NjQ0MDQwY2I4MjMxY2Y3ZmI3MjdhN2ZmMjNhODViOTg1ZGE0NTBjMGM4NDA5NzYxMjdjOWMwYWRmZTBlZjlhNGY3ZTg4Y2U3YTE1ODVkZDU5Y2Y3OGYwZWE1NzUzNWQ2YjFjZDc0NGMxZWU2MmQ3MjY1NzJmNTE0MzI";

    /** 令牌过期时间 此处单位/毫秒 */
    @Value("${jwt.token-validity-in-seconds}")

    private static Long tokenValidityInSeconds=14400000L;

    /** 在线用户 key，根据 key 查询 redis 中在线用户的数据 */
    @Value("${jwt.online-key}")

    private static String onlineKey="online-token";

    /** 验证码 key */
    @Value("${jwt.code-key}")

    private static String codeKey="code-key";

    public static String getTokenStartWith() {
        return tokenStartWith + " ";
    }

    public static String getHeader() {
        return header;
    }

    public static void setHeader(String header) {
        header = header;
    }

    public void setTokenStartWith(String tokenStartWith) {
        tokenStartWith = tokenStartWith;
    }

    public static String getBase64Secret() {
        return base64Secret;
    }

    public void setBase64Secret(String base64Secret) {
        base64Secret = base64Secret;
    }

    public static Long getTokenValidityInSeconds() {
        return tokenValidityInSeconds;
    }

    public void setTokenValidityInSeconds(Long tokenValidityInSeconds) {
        tokenValidityInSeconds = tokenValidityInSeconds;
    }

    public static String getOnlineKey() {
        return onlineKey;
    }

    public static void setOnlineKey(String onlineKey) {
        onlineKey = onlineKey;
    }

    public static String getCodeKey() {
        return codeKey;
    }

    public static void setCodeKey(String codeKey) {
        codeKey = codeKey;
    }
}
