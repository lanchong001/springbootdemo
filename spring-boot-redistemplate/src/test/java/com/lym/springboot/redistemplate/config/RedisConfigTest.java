package com.lym.springboot.redistemplate.config;


import org.apereo.cas.model.WhileList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.net.MalformedURLException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisConfig.class)
public class RedisConfigTest {

    @Autowired
    private RedisTemplate<String, WhileList> redisTemplate;

    /**
     * 白名单 redis key 前缀
     */
    private static final String CAS_WHITE_LIST = "CAS_WHITELIST:";

    /**
     * 执行单元测试添加白名单
     */
    @Test
    public void testSet() {
        String ip = "10.249.0.121:30024";
        //redis key : 前缀 + ip : port
        String key = String.format("%s%s", CAS_WHITE_LIST, ip);
        WhileList whileList1 = new WhileList();
        // auth : 授权码 1: 已授权; 0: 取消授权;
        whileList1.setIsAuth(1);
        // url : 白名单地址;
        whileList1.setUrl(ip);
        redisTemplate.boundValueOps(key).set(whileList1);
    }

    /**
     * redisTemplate get 获取
     */
    @Test
    public void testGet() {

        String key = "app2.cas.com:8082123123";
        WhileList whileList = redisTemplate.boundValueOps(key).get();
        if (whileList != null && whileList.getIsAuth() == 1) {
            System.out.println(whileList);
        }
    }

    /**
     * 获取url 主机名与端口号
     */
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

    /**
     * 字符串截图测试
     */
    @Test
    public void testSplit() {
//        String url = "http://castest.lbxdrugs.com:18080/cas/ConfirmLogin/TST-23-qESkYEjQ-bCPIvgxz-g9vo1Qw5D2gmIq/";
//        String url = "http://castest.lbxdrugs.com:18080/cas/ConfirmLogin/TST-23-qESkYEjQ-bCPIvgxz-g9vo1Qw5D2gmIq";
//        String url = "http://castest.lbxdrugs.com:18080/cas/ConfirmLogin/234234234";
//        String url = "http://castest.lbxdrugs.com:18080/cas/ConfirmLogin";
//        String url = "";
        String url = null;
        System.out.printf(getClientId(url));
    }

    public String getClientId(String url) {
        String result = "";
        if (!StringUtils.isEmpty(url)) {
            String[] urls = url.split("/ConfirmLogin/");
            if (urls.length >= 2) {
                if (!StringUtils.isEmpty(urls[1])) {
                    result = urls[1].replace("/", "");
                }
            }
        }
        return result;
    }
}