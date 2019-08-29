package com.lym.springboot.springboothessianclient.controller;

import com.lym.springboot.hessian.interfaces.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/test")
    public String test(){
        return helloWorldService.sayHello("zzz");
    }

}
