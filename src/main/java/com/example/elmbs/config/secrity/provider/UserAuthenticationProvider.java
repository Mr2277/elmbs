package com.example.elmbs.config.secrity.provider;

import com.example.elmbs.config.secrity.bean.UserDetailImp;
import com.example.elmbs.config.secrity.service.MultyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
        System.out.println(userDetails.getUsername());
        System.out.print(userDetails.getPassword());
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        userDetails.setAuthorities(authorities);
        return new UsernamePasswordAuthenticationToken(userDetails,password,authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
