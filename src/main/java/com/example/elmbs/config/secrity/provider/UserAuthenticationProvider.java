package com.example.elmbs.config.secrity.provider;

import com.example.elmbs.config.secrity.bean.UserDetailImp;
import com.example.elmbs.config.secrity.service.MultyUserDetailsService;
import com.example.elmbs.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private MultyUserDetailsService userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username= (String) authentication.getPrincipal();
        String password= (String) authentication.getCredentials();
        UserDetailImp userDetails= (UserDetailImp) userDetailsService.loadUserByUsername(username);
        System.out.println(userDetails.getUsername()+"##UserAuthenticationProvider");
        System.out.println(userDetails.getPassword()+"##UserAuthenticationProvider");
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        userDetails.setAuthorities(authorities);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,password,authorities);
        String token = JwtTokenUtils.createToken(username,"ROLE_ADMIN");
        System.out.println(token+"##UserAuthenticationProvider");
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        return usernamePasswordAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
