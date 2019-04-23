package com.lym.springboot.velocity.config;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class VolecityConfig {

    @Bean
    public VelocityEngine velocityEngine() {
        Properties properties = new Properties();
        // 加载classpath目录下的vm文件
        properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        // 定义字符集
        properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty("", "");
        return velocityEngine;
    }

}
