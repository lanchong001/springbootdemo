package com.lym.springboot.junit.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: in liuyuanming
 * @Description: Environment测试  通过@SpringBootTest注解的properties属性向Environment中设置新的属性
 *                                可以通过使用EnvironmentTestUtils工具类来向ConfigurableEnvironment中添加新的属性
 * @Date:Created in  2019/5/7 16:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "app.token=test_token", "app.secret=test_secret" })
public class EnvironmentTest {

    @Autowired
    private Environment environment;

    @Autowired
    private ConfigurableEnvironment configurableEnvironment;

    @Test
    public void testEnvironment(){
        System.out.println(environment.getProperty("app.token"));
        Assert.assertEquals("test_token",environment.getProperty("app.token"));
        Assert.assertEquals("test_secret",environment.getProperty("app.secret"));
    }

    @Test
    @Ignore // 忽略测试方法
    public void testIgnore() {
        System.out.println("你看不见我...");
    }

}
