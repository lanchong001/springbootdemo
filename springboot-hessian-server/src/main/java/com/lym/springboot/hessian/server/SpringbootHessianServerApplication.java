package com.lym.springboot.hessian.server;

import com.lym.springboot.hessian.interfaces.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;

@SpringBootApplication
public class SpringbootHessianServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHessianServerApplication.class, args);
    }

    @Autowired
    private HelloWorldService helloWorldService;

    @Bean(name = "/hello/world/service")
    public HessianServiceExporter accountService(){
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(helloWorldService);
        exporter.setServiceInterface(HelloWorldService.class);
        return exporter;
    }

}
