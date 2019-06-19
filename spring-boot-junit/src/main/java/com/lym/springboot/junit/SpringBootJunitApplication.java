package com.lym.springboot.junit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.lym.springboot", "com.lbx.framework.common.advice"})
public class SpringBootJunitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJunitApplication.class, args);
    }

}
