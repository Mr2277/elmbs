package com.example.elmbs.controller;

import cn.hutool.core.util.IdUtil;
import com.example.elmbs.config.secrity.bean.AuthUser;
import com.example.elmbs.config.secrity.bean.UserDetailImp;
import com.example.elmbs.config.secrity.provider.UserAuthenticationProvider;
import com.example.elmbs.config.secrity.service.MultyUserDetailsService;
import com.example.elmbs.utils.JwtTokenUtils;
import com.example.elmbs.utils.SecProperties;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    private MultyUserDetailsService userDetailsService;
    @Autowired
    private SecProperties properties;
    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder,MultyUserDetailsService userDetailsService) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDetailsService=userDetailsService;
    }

    @RequestMapping("/login")
    public ResponseEntity<Object> login(@Validated @RequestBody AuthUser authUser, HttpServletRequest request) {
        String username = authUser.getUsername();
        String password = authUser.getPassword();

        //Authentication authentication=new UsernamePasswordAuthenticationToken(username,password);
        //userAuthenticationProvider.authenticate(authentication);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authUser.getUsername(), password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = JwtTokenUtils.createToken(username,"ROLE_ADMIN");
        // 返回 token 与 用户信息
        final UserDetailImp jwtUser = (UserDetailImp) authentication.getPrincipal();

        Map<String,Object> authInfo = new HashMap<String,Object>(2){{
           // properties.g
            put("token", SecProperties.getTokenStartWith() + token);
            put("user", jwtUser);
        }};

        return ResponseEntity.ok(authInfo);
    }
    @GetMapping(value = "/code")
    public ResponseEntity<Object> getCode(){
        // 算术类型 https://gitee.com/whvse/EasyCaptcha
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = captcha.text();
        String uuid = "code-key" + IdUtil.simpleUUID();
        //System.out.println(uuid);
        // 保存
        //redisUtils.set(uuid, result, expiration, TimeUnit.MINUTES);
        // 验证码信息
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};
        return ResponseEntity.ok(imgResult);
    }
}
