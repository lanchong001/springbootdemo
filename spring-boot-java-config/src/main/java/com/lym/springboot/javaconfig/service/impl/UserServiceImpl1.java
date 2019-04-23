package com.lym.springboot.javaconfig.service.impl;

import com.lym.springboot.javaconfig.service.UserService;
import org.springframework.context.annotation.Scope;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/23/023 15:22
 */
@Scope(scopeName = "userService1", value = "prototype")
public class UserServiceImpl1 implements UserService {

    @Override
    public String getUser() {
        System.out.println("UserServiceImpl 1 ...");
        return "UserServiceImpl1";
    }
}
