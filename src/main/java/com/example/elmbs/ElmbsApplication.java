package com.example.elmbs;

import com.example.elmbs.config.secrity.provider.UserAuthenticationProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(basePackages = "com.example.elmbs.dao")
public class ElmbsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ElmbsApplication.class, args);
    }
    @Autowired
    DataSource dataSource;
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;
    @Override
    public void run(String... args) throws Exception {
        if(userAuthenticationProvider!=null){
            System.out.println("ok");
        }
    }
}
