package com.lym.springboot.starter.client;

import com.lym.springboot.starter.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootStarterClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterClientApplication.class, args);
    }

    @Autowired
    public ExampleService exampleService;

    @GetMapping("/input")
    public String input(String word){
        return exampleService.wrap(word);
    }
}
