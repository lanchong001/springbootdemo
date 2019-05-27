package com.lym.springboot.jpacustom.controller;

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

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/27 10:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void save() throws Exception {
        String url = "/save";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("name","lili")
                .param("address","岳阳")
                .param("age","18")
        ).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        int status = response.getStatus();

        String context = response.getContentAsString();

        System.out.println(context);

        Assert.assertEquals(status, 200);
    }

    @Test
    public void q1() throws Exception {
        String url = "/q1";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .param("address","上海")
        ).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        int status = response.getStatus();

        String contentAsString = response.getContentAsString();

        System.out.println(contentAsString);

        Assert.assertTrue(status == 200);
    }

    @Test
    public void q2() throws Exception {
        String url = "/q2";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .param("name","lili")
            .param("address","岳阳")
        ).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        String contentAsString = response.getContentAsString();

        int status = response.getStatus();

        System.out.println(contentAsString);

        Assert.assertTrue(status == 200);
    }

    @Test
    public void q3() throws Exception {
        String url = "/q3";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("name","lili")
                .param("address","岳阳")
        ).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        String contentAsString = response.getContentAsString();

        int status = response.getStatus();

        System.out.println(contentAsString);

        Assert.assertTrue(status == 200);
    }

    @Test
    public void q4() throws Exception {
        String url = "/q4";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("name","lili")
                .param("address","岳阳")
        ).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        String contentAsString = response.getContentAsString();

        int status = response.getStatus();

        System.out.println(contentAsString);

        Assert.assertTrue(status == 200);
    }

    @Test
    public void sort() throws Exception {
        String url = "/sort";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        String contentAsString = response.getContentAsString();

        int status = response.getStatus();

        System.out.println(contentAsString);

        Assert.assertTrue(status == 200);
    }

    @Test
    public void page() throws Exception {
        String url = "/page";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        String contentAsString = response.getContentAsString();

        int status = response.getStatus();

        System.out.println(contentAsString);

        Assert.assertTrue(status == 200);
    }
}