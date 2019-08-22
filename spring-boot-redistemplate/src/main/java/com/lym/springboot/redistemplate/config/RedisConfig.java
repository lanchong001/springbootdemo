package com.lym.springboot.redistemplate.config;

import org.apereo.cas.model.WhileList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class RedisConfig {

    @Value("#{'${spring.redis.sentinel.nodes}'.split(',')}")
    private List<String> nodes;

    @Bean
    @ConfigurationProperties(prefix="spring.redis")
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }
    @Bean
    public RedisSentinelConfiguration sentinelConfiguration(){
        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        //配置matser的名称
        redisSentinelConfiguration.master("mymaster");
        //配置redis的哨兵sentinel
        Set<RedisNode> redisNodeSet = new HashSet<>();
        nodes.forEach(x->{
            redisNodeSet.add(new RedisNode(x.split(":")[0],Integer.parseInt(x.split(":")[1])));
        });
        redisSentinelConfiguration.setSentinels(redisNodeSet);
        return redisSentinelConfiguration;
    }

    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName("10.249.0.26");
        jedisConFactory.setPort(6379);
        jedisConFactory.setDatabase(1);
        return jedisConFactory;
    }

    @Bean
    public RedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig,RedisSentinelConfiguration redisSentinelConfiguration) {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory(redisSentinelConfiguration,jedisPoolConfig);
        jedisConFactory.setPassword("1234");
        jedisConFactory.setDatabase(0);
        return jedisConFactory;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, WhileList> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisSerializer<String> string = new StringRedisSerializer();
        JdkSerializationRedisSerializer jdk = new JdkSerializationRedisSerializer();
        final RedisTemplate<String, WhileList> template = new RedisTemplate<String, WhileList>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(string);
        template.setValueSerializer(jdk);
        return template;
    }
}