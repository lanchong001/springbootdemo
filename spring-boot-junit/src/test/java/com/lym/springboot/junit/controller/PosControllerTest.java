package com.lym.springboot.junit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lym.springboot.junit.domain.PosInfo;
import com.lym.springboot.junit.domain.TestNet;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/6/12 15:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInfo() throws Exception {
        String url = "/pos/getinfo";

        PosInfo posInfo = new PosInfo();
        posInfo.setAppId("2571767865");
        posInfo.setTimeStamp(1560302609);
        posInfo.setNonceStr("1ff2f366ae2a497da750af96e7b4b298");
        posInfo.setSign("6301CA9D49678A0AA32E6C4482DAEB64");
        posInfo.setDeptid(9);
        posInfo.setDeptname("测试门店");
        posInfo.setSadress("10.254.0.11");
        posInfo.setPadress("220.19.11.234");
        posInfo.setNetaddress("湖南省长沙市");
        posInfo.setNettype("电信");
        List<TestNet> list = new ArrayList<>();
        list.add(new TestNet(new BigDecimal("2.899999999999999911182158029987476766109466552734375"),"1543981755951",0,0,"220.168.29.170:21",2,4,1,"网络测试",2,1));
        list.add(new TestNet(new BigDecimal("2.899999999999999911182158029987476766109466552734375"),"1543981755951",1,0,"220.168.29.170:21",2,4,1,"网络测试",2,1));
        list.add(new TestNet(new BigDecimal("2.899999999999999911182158029987476766109466552734375"),"1543981755951",0,1,"220.168.29.170:21",2,4,1,"网络测试",2,1));
        list.add(new TestNet(new BigDecimal("2.899999999999999911182158029987476766109466552734375"),"1543981755951",1,1,"220.168.29.170:21",2,4,1,"网络测试",2,1));
        posInfo.setDetail(list);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(posInfo);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json)).andReturn();


        MockHttpServletResponse response = mvcResult.getResponse();

        int status = response.getStatus();

        System.out.println(response.getContentAsString());

        Assert.assertEquals(status,200);
    }
}