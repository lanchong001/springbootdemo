package com.lym.springboot.javaconfig.service.impl;

import com.lym.springboot.javaconfig.service.UserService;
import org.springframework.context.annotation.Scope;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/23/023 15:23
 */
@Scope(scopeName = "userService2", value = "prototype")
public class UserServiceImpl2 implements UserService {

    @Override
    public String getUser() {
        System.out.println("UserServiceImpl 2 ...");
        return "UserServiceImpl2";
    }
}
