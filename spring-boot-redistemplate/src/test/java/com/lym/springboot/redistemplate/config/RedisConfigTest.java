package com.lym.springboot.redistemplate.config;


import org.apereo.cas.model.WhileList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisConfig.class)
public class RedisConfigTest {

    @Autowired
    private RedisTemplate<String, WhileList> redisTemplate;

    @Test
    public void testSet() {

        String key1 = "10.252.0.210:31381";
        WhileList whileList1 = new WhileList();
        whileList1.setIsAuth(1);
        whileList1.setUrl("10.252.0.210:31381");
        redisTemplate.boundValueOps(key1).set(whileList1);

//        String key2 = "app2.cas.com:8082";
//        WhileList whileList2 = new WhileList();
//        whileList2.setIsAuth(0);
//        whileList2.setUrl("app2.cas.com:8082");
//        redisTemplate.boundValueOps(key2).set(whileList2);
    }

    @Test
    public void testGet() {

        String key = "app2.cas.com:8082123123";
        WhileList whileList = redisTemplate.boundValueOps(key).get();
        if (whileList != null && whileList.getIsAuth() == 1) {
            System.out.println(whileList);
        }
    }

    @Test
    public void testUrl() {

        try {
            java.net.URL url = new java.net.URL("http://blog.csdn.net:9090/zhujianlin1990");
            String host = url.getHost();// 获取主机名
            int port = url.getPort();
            System.out.println(host);
            System.out.println(port);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}