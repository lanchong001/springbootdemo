package com.lym.springboot.mockmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lym.springboot.mockmvc.domain.User;
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
 * @Date:Created in  2019/5/14 19:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//1. 注入 MockMvc
@AutoConfigureMockMvc
public class UserControllerTest {

    //2. 创建 mockMvc
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void index() throws Exception {
        String url = "/user/index";

        //3. 利用 mockMvc 创建请求, 录入请求url,请求类型
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)).andReturn();

        //4. 获取 webapi 返回的结果
        MockHttpServletResponse response = mvcResult.getResponse();

        int status = response.getStatus();
        String contentAsString = response.getContentAsString();
        System.out.println(contentAsString);

        Assert.assertTrue(status == 200);
    }

    @Test
    public void login() throws Exception {
        String url = "/user/login";

        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setId(2);
        user.setName("zhangshan");
        user.setPassword("30");
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        //3. 利用 mockMvc 创建请求, 录入请求url,请求类型
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json)).andReturn();

        //4. 获取 webapi 返回的结果
        MockHttpServletResponse response = mvcResult.getResponse();

        int status = response.getStatus();
        String contentAsString = response.getContentAsString();
        System.out.println(contentAsString);

        Assert.assertTrue(status == 200);
        Assert.assertTrue(contentAsString.equals(json));
    }

    @Test
    public void webapiExcetpionTest() throws Exception {
        String url = "/user/webapi";

        //3. 利用 mockMvc 创建请求, 录入请求url,请求类型
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)).andReturn();

        //4. 获取 webapi 返回的结果
        MockHttpServletResponse response = mvcResult.getResponse();

        int status = response.getStatus();
        String contentAsString = response.getContentAsString();
        System.out.println(contentAsString);

        Assert.assertTrue(status == 200);
    }

    @Test
    public void webExceptionTest() throws Exception {
        String url = "/user/web";

        //3. 利用 mockMvc 创建请求, 录入请求url,请求类型
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.ALL)).andReturn();

        //4. 获取 webapi 返回的结果
        MockHttpServletResponse response = mvcResult.getResponse();

        int status = response.getStatus();
        String contentAsString = response.getContentAsString();
        System.out.println(contentAsString);

        Assert.assertTrue(status == 200);
    }
}