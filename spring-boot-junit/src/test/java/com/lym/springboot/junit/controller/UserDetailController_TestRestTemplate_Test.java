package com.lym.springboot.junit.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lym.springboot.junit.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: in liuyuanming
 * @Description: 利用TestRestTemplate进行测试
 * @Date:Created in  2019/5/7 15:55
 */
@RunWith(SpringRunner.class)
//1. 启动Spring Boot Web 容器进行单元测试,随机分配端口
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserDetailController_TestRestTemplate_Test {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getUser() throws JsonProcessingException {
        String result = testRestTemplate.getForObject("/user_detail/index?name=",String.class);
        System.out.println(result);
        Assert.assertEquals("error",result);

        User user = new User();
        user.setId(1);
        user.setName("lym");
        user.setPassword("123456");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        String result1 = testRestTemplate.getForObject("/user_detail/index?name=lym",String.class);
        System.out.println(result1);
        Assert.assertEquals(json,result1);
    }
}