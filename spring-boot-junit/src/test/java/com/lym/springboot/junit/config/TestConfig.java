package com.lym.springboot.junit.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Author: in liuyuanming
 * @Description: @TestConfiguration注解的配置内的Bean仅在测试时装配  @TestConfiguration注解修饰的配置类内的Bean仅在测试的时候才会装配
 * @Date:Created in  2019/5/7 15:25
 */
@TestConfiguration
public class TestConfig {

    //1. 注册一个Runnable类型的bean
    @Bean
    public Runnable createRunnable() {
        return () -> {
            System.out.println("This is a test Runnable bean...");
        };
    }

}
