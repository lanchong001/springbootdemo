package com.lym.springboot.junit.controller;

import com.lym.springboot.junit.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/7 14:36
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/index")
    public User index() {
        User user = new User();
        user.setId(1);
        user.setName("lili");
        return user;
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody User user){
        return user;
    }

}
