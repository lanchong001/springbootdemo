package com.lym.springboot.starter.config;

import com.lym.springboot.starter.properties.ExampleServiceProperties;
import com.lym.springboot.starter.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/10 15:27
 */
@Configuration
@ConditionalOnClass(ExampleService.class)
@EnableConfigurationProperties(ExampleServiceProperties.class)
public class ExampleAutoConfigure {

    @Autowired
    private ExampleServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "com.lym.spring.service", value = "enabled", havingValue = "true")
    ExampleService exampleService() {
        return new ExampleService(properties.getPrefix(), properties.getSuffix());
    }

}
