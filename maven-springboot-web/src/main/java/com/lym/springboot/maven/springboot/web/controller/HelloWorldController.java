package com.lym.springboot.maven.springboot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/helloworld")
public class HelloWorldController {

    @GetMapping("/hi")
    public String sayHi() {
        return "Hello World, Spring Boot!";
    }
}
