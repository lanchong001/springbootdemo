package com.lym.springboot.thymeleaf.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/16/016 10:10
 */
@Controller
public class ThymeController {

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // CustomDateEditor为自定义日期编辑器
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/boot/index")
    public String index(Model model) {
        model.addAttribute("msg", "Spring Boot 集成 Thymeleaf");
        model.addAttribute("date", new Date());
        return "index";
    }

    @GetMapping("/boot/info")
    public Object index() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("msg", "Spring Boot 集成 Thymeleaf");
        maps.put("date", new Date());
        return maps;
    }

}
