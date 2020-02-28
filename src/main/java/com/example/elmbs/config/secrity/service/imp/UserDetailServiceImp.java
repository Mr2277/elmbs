package com.example.elmbs.config.secrity.service.imp;

import com.example.elmbs.config.secrity.bean.UserDetailImp;
import com.example.elmbs.config.secrity.service.MultyUserDetailsService;
import com.example.elmbs.entity.User;
import com.example.elmbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements MultyUserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user= userService.loadUserByUsername(s);
        UserDetailImp userDetailImp=new UserDetailImp();
        userDetailImp.setUsername(user.getUsername());
        userDetailImp.setPassword(user.getPassword());
        return userDetailImp;
    }
}
