package com.lym.springboot.thymeleaflayui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: in liuyuanming
 * @Description: Spring Boot + Thymeleaf + LayUI
 * @Date:Created in  2019/4/16/016 12:24
 */
@Controller
@RequestMapping("/layui")
public class LayController {
    @RequestMapping("/index")
    public String demo() {
        return "layui/index";
    }
}
