package com.example.elmbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(basePackages = "com.example.elmbs.dao")
public class ElmbsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ElmbsApplication.class, args);
    }
    @Autowired
    DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(dataSource.getClass().getName());

        System.out.println("DATASOURCE="+dataSource);
    }
}
