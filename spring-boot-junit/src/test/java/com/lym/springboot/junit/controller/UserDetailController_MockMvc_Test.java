package com.lym.springboot.junit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lym.springboot.junit.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/7 16:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserDetailController_MockMvc_Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUser() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user_detail/index?name=")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        String result = response.getContentAsString();
        System.out.println(result);
        Assert.assertEquals("error", result);

        MvcResult mvcResult1 = mockMvc.perform(MockMvcRequestBuilders.get("/user_detail/index?name=lym")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        User user = new User();
        user.setId(1);
        user.setName("lym");
        user.setPassword("123456");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        MockHttpServletResponse response1 = mvcResult1.getResponse();
        String result1 = response1.getContentAsString();
        System.out.println(result1);
        Assert.assertEquals(json, result1);


    }
}