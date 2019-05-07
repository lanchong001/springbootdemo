package com.lym.springboot.springbootshiro.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/6 14:10
 */
@Controller
public class UserController {

    @RequestMapping("/test")
    public String hello(Model model){
        model.addAttribute("name","黑马程序员");
        return "test";
    }

    @RequestMapping("/add")
    public String add(){
        return "/user/add";
    }

    @RequestMapping("/update")
    public String update(){
        return "/user/update";
    }

    @RequestMapping("/tologin")
    public String toLogin(){
        return "login";
    }

    /**
     * 登录逻辑处理
     * @return
     */
    @RequestMapping(name = "/login")
    public String login(String name, String password, Model model){
        /**
         *  使用Shiro编写认证操作
         */
        //1. 使用 Subject
        Subject subject = SecurityUtils.getSubject();

        //2. 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);

        //3. 执行登录方法
        try {
            subject.login(token);
            return "redirect:/test";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","用户名不存在");
            return "login";
        }finally {

        }

    }
}
