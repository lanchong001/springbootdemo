package com.lym.springboot.redistemplate.config;

import org.apereo.cas.model.WhileList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName("10.249.0.26");
        jedisConFactory.setPort(6379);
        jedisConFactory.setDatabase(1);
        return jedisConFactory;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, WhileList> redisTemplate() {
        RedisSerializer<String> string = new StringRedisSerializer();
        JdkSerializationRedisSerializer jdk = new JdkSerializationRedisSerializer();
        final RedisTemplate<String, WhileList> template = new RedisTemplate<String, WhileList>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(string);
        template.setValueSerializer(jdk);
        return template;
    }
}