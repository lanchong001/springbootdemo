package com.lym.springboot.cach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootCachApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCachApplication.class, args);
	}
}
