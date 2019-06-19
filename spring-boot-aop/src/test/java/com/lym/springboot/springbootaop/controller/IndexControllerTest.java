package com.lym.springboot.springbootaop.controller;

import com.lym.springboot.springbootaop.domain.User;
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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/6/5 16:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUserName() throws Exception {
        String url = "/index?userId=123";
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get(url).
                        accept(MediaType.APPLICATION_JSON)
        ).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        String content = response.getContentAsString();
        System.out.println(content);
        Assert.assertTrue(status == 200);
    }

    @Test
    public void testEncode() throws UnsupportedEncodingException {
        User user = new User();
        user.setId("111");
        user.setAge(20);

        URLEncoder.encode(user.toString(), "UTF-8");
    }
}