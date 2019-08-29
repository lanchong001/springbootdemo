package com.lym.springboot.hessian.server.impl;

import com.lym.springboot.hessian.interfaces.HelloWorldService;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String sayHello(String name) {
        return "Hello world! "+ name;
    }

}
