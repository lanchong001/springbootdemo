package com.lym.springboot.junit.controller;

import com.lym.springboot.junit.config.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: in liuyuanming
 * @Description: ApplicationContext测试  https://blog.csdn.net/pengjunlee/article/details/80206615
 * @Date:Created in  2019/5/7 15:20
 */

@RunWith(SpringRunner.class)
//2. 加载测试环境使用的 Config Bean配置. @SpringBootTest注解的classes可以指定用来加载Spring容器所使用的配置类
@SpringBootTest(classes = {TestConfig.class} )
public class ApplicationContextTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testApplicationContext(){
        //3. 获取 bean 对象
        Runnable runnable = context.getBean(Runnable.class);
        Assert.assertNotNull(runnable);
        runnable.run();
    }
}
