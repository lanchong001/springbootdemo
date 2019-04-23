package com.lym.springboot.javaconfig.config;

import com.lym.springboot.javaconfig.DoWorkBean;
import com.lym.springboot.javaconfig.service.UserService;
import com.lym.springboot.javaconfig.service.impl.UserServiceImpl1;
import com.lym.springboot.javaconfig.service.impl.UserServiceImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.WebEndpoint;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/23/023 14:33
 */
@Configuration
public class Config {

    /*
        @Bean
        public DoWorkBean doWorkBean() {
            return new DoWorkBean();
        }
    */

    /**
     * 一个完整的bean配置包括了 id,class,initMethod,destroyMethod,·ref,scope
     *
     * @return
     */
    @Bean(initMethod = "init",destroyMethod = "destory")
    public DoWorkBean doWorkBean() {
        return new DoWorkBean();
    }

    @Bean
    public UserService userService1() {
        return new UserServiceImpl1();
    }

    @Bean
    public UserService userService2() {
        return new UserServiceImpl2();
    }

}
