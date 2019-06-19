package com.lym.springboot.mockmvc.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import java.io.File;
import java.io.FileInputStream;

/**
 * @Author: in liuyuanming
 * @Description: MockMVC附件上传测试
 * @Date:Created in  2019/6/19 15:15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void applyByForm() throws Exception {
        String url = "/api/v1/face/apply";

        File file = new File("E:\\test1.bmp");
        FileInputStream fileInputStream = new FileInputStream(file);
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "test1.bmp", "x-bmp", fileInputStream);

        MockMultipartHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.fileUpload(url);
        builder.with(new RequestPostProcessor() {
            @Override
            public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
                request.setMethod("POST");
                return request;
            }
        });

        MvcResult mvcResult = mockMvc.perform(builder.file(mockMultipartFile)
                .param("user_id", "1")
                .param("user_name", "1")
                .param("app_id", "1")
                .param("appId", "1")
                .param("time_stamp", "1")
                .param("nonce_str", "1")
                .param("sign", "1")
        ).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        System.out.println(response.getContentAsString());
        Assert.assertTrue(response.getStatus() == 200);
    }
}