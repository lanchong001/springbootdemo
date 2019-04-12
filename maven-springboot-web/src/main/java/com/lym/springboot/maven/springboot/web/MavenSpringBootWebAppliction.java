package com.lym.springboot.maven.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MavenSpringBootWebAppliction {
    public static void main(String[] args) {
        //启动springboot程序,启动spring容器.如果引用了spring-boot-starter-web的话,默认启动内嵌的tomcat服务器
        SpringApplication.run(MavenSpringBootWebAppliction.class);
    }
}









