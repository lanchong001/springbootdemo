package com.lym.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/16/016 10:10
 */
@Controller
public class ThymeController {

    @RequestMapping("/boot/index")
    public String index(Model model){
        model.addAttribute("msg","Spring Boot 集成 Thymeleaf");
        return "index";
    }

}
