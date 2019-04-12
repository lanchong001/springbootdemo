package com.lym.springboot.jpa.controller;

import com.lym.springboot.jpa.domain.User;
import com.lym.springboot.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/12/012 17:44
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
       return userService.findUserById(id);
    }
}
