package com.lym.springboot.lombok.controller;

import com.lym.springboot.lombok.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/13/013 14:37
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("lili")
    public String getUser(){
        User user = new User();
        user.setId(1L);
        user.setName("lili");
        user.setAge(18);
        return user.toString();
    }
}
