package com.example.elmbs.controller;

import com.example.elmbs.config.secrity.bean.AuthUser;
import com.example.elmbs.config.secrity.provider.UserAuthenticationProvider;
import com.example.elmbs.config.secrity.service.MultyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

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
}
