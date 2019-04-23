package com.lym.springboot.javaconfig;

import com.lym.springboot.javaconfig.config.Config;
import com.lym.springboot.javaconfig.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/23/023 14:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Config.class)
//@ContextConfiguration(classes = Config.class)
public class ConfigTest {

    //Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test

//    @Resource
//    private DoWorkBean doWorkBean;
//
//    @Test
//    public void doWorkBean() throws Exception {
//        doWorkBean.doWork();
//    }

    @Autowired
    public ApplicationContext context;

    @Test
    public void doWorkBean() throws Exception {
        DoWorkBean doWorkBean1 = context.getBean(DoWorkBean.class);
        System.out.println(doWorkBean1);
        DoWorkBean doWorkBean2 = context.getBean(DoWorkBean.class);
        System.out.println(doWorkBean2);
    }

    @Test
    public void doWorkBean1() throws Exception {
        DoWorkBean doWorkBean1 = context.getBean("doWorkBean",DoWorkBean.class);
        System.out.println(doWorkBean1);
        DoWorkBean doWorkBean2 = context.getBean("doWorkBean",DoWorkBean.class);
        System.out.println(doWorkBean2);
    }

    @Test
    public void doUserService() throws Exception {
        UserService userService1 = context.getBean("userService1",UserService.class);
        System.out.println(userService1);
        UserService userService2 = context.getBean("userService2",UserService.class);
        System.out.println(userService2);
    }
}