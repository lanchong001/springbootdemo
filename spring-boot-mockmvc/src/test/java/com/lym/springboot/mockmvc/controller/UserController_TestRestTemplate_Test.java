package com.lym.springboot.mockmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lym.springboot.mockmvc.domain.ResponseResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: in liuyuanming
 * @Description: 利用TestRestTemplate进行测试
 * @Date:Created in  2019/5/7 15:55
 */
@RunWith(SpringRunner.class)
//1. 启动Spring Boot Web 容器进行单元测试,随机分配端口
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserController_TestRestTemplate_Test {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void webapiExcetpionTest() throws Exception {
        String url = "/user/webapi";
        String result = testRestTemplate.getForObject(url,String.class);
        System.out.println(result);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseResult reponse = objectMapper.readValue(result, ResponseResult.class);
        Assert.assertEquals(Integer.valueOf(-1),reponse.getCode());
    }
}