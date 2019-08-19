package com.lym.springboot.thymeleaf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

    @PostMapping(value = "/boot/getXQrcodeUrl")
    public void getXQrcodeUrl(HttpServletRequest request, HttpServletResponse response) {
        String clientUrl = request.getParameter("clientUrl");
        String isAuth = request.getParameter("isAuth");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("clientUrl", clientUrl);
        map.put("isAuth", isAuth);
        try {
            //设定编码
            response.setCharacterEncoding("UTF-8");
            //表示是json类型的数据
            response.setContentType("application/json");
            //获取PrintWriter 往浏览器端写数据
            PrintWriter writer = response.getWriter();
            /*     转换器       */
            ObjectMapper mapper = new ObjectMapper();
            //获取到转化后的JSON 数据
            String json = mapper.writeValueAsString(map);
            //写数据到浏览器
            writer.write(json);
            //刷新，表示全部写完，把缓存数据都刷出去
            writer.flush();

            //关闭writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
