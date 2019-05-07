package com.lym.springboot.junit.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lym.springboot.junit.domain.User;
import com.lym.springboot.junit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/7 15:50
 */
@RestController
@RequestMapping(value = "/user_detail")
public class UserDetailController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/index")
    public String getUser(@RequestParam(name = "name", required = true) String userName) throws JsonProcessingException {
        if (StringUtils.isEmpty(userName)) {
            return "error";
        }
        User user = userRepository.findByName(userName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(user);
    }

}
