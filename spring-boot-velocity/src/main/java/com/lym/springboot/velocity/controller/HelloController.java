package com.lym.springboot.velocity.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello(Model model) {
        model.addAttribute("toUserName","lili");
        model.addAttribute("message","很高兴认识你");
        model.addAttribute("fromUserName","pp");
        model.addAttribute("time","2019-04-23");
        return "index";
    }
}
