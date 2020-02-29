package com.example.elmbs.controller;

import com.example.elmbs.config.secrity.bean.AuthUser;
import com.example.elmbs.config.secrity.provider.UserAuthenticationProvider;
import com.example.elmbs.config.secrity.service.MultyUserDetailsService;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    private MultyUserDetailsService userDetailsService;

    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder,MultyUserDetailsService userDetailsService) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDetailsService=userDetailsService;
    }

    @RequestMapping("/login")
    public ResponseEntity<Object> login(@Validated @RequestBody AuthUser authUser, HttpServletRequest request) {
        System.out.println("login");
        String username = authUser.getUsername();
        String password = authUser.getPassword();
        //Authentication authentication=new UsernamePasswordAuthenticationToken(username,password);
        //userAuthenticationProvider.authenticate(authentication);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authUser.getUsername(), password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("ok");
    }
    @GetMapping(value = "/code")
    public ResponseEntity<Object> getCode(){
        // 算术类型 https://gitee.com/whvse/EasyCaptcha
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = captcha.text();
        System.out.print(result);
        //String uuid = properties.getCodeKey() + IdUtil.simpleUUID();
        //System.out.println(uuid);
        // 保存
        //redisUtils.set(uuid, result, expiration, TimeUnit.MINUTES);
        // 验证码信息
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            put("img", captcha.toBase64());
          //  put("uuid", uuid);
        }};
        return ResponseEntity.ok(imgResult);
    }
}
