package com.example.elmbs.config;

import com.example.elmbs.config.secrity.handler.SuccessLoginHandler;
import com.example.elmbs.config.secrity.provider.UserAuthenticationProvider;
import com.example.elmbs.filter.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 自定义登录逻辑验证器
     */
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;
    /**
     * 登录成功逻辑验证器
     */
    @Autowired
    private SuccessLoginHandler successLoginHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(userAuthenticationProvider);
       auth.eraseCredentials(false);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                // 不进行权限验证的请求或资源(从配置文件中读取)
                .antMatchers("/auth/*").permitAll()
                // 其他的需要登陆后才能访问
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //.loginProcessingUrl("/user/selectOne")
                // 配置登录成功自定义处理类
                .successHandler(successLoginHandler)
                .and()
                // 开启跨域
                //.addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .cors()
                .and()
                // 取消跨站请求伪造防护
                .csrf().disable();
    }

}
