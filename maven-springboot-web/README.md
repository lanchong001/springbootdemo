### maven-springboot-web 通过Maven脚手架创建SpringBoot项目
---
1. 创建空的Maven项目
2. 创建对应的命名空间 (com.lym.springboot.maven.springboot.web)
3. pom文件中增加 spring boot 父级项目依赖和springboot项目起步依赖
4. 创建包含main方法的Appliction启动类,添加@SpringBootApplition启动类

### 快速开发springboot程序步骤
---
1. 创建一个spring boot 项目
(S1:使用eclipse 的 Spring Tool Suite(STS) 插件、或者 IDEA自带的插件创建;S2:直接使用Maven创建项目的方式创建)


2. POM文件中增加 spring boot parent 依赖,以及其他的启动依赖
```
    <!--继承spring boot的父级项目依赖-->
    <parent>
        <groupId>com.lym.springboot</groupId>
        <artifactId>springboot-demo</artifactId>
        <version>1.0.0</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <!--spring boot web 开发启动依赖-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
 ```
3. 创建Spring boot 的入口main方法，添加@SpringBootApplication注解
```
@SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        //启动springboot程序,启动spring容器.如果引用了spring-boot-starter-web的话,默认启动内嵌的tomcat服务器
        SpringApplication.run(SpringBootApplication.class, args);
    }

}
```
4. 创建一个Spring MVC 的 Controler类
```
@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
    @GetMapping("/hi}")
    public String (){
       return "Hi, Spring Boot!";
    }
}
```

### 问题汇总:
---

-  Unable to start ServletWebServerApplicationContext due to missing ServletWebServerFactory bean.
```
// 错误,类名 SpringAppliction 与 SpringBoot spring 启动容器的类名一致
@SpringBootApplication
public class SpringAppliction {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplication.class);
    }
}
// 重命名类名后    SpringAppliction 修改为 MavenSpringBootWebAppliction
@SpringBootApplication
public class MavenSpringBootWebAppliction {
    public static void main(String[] args) {
        SpringApplication.run(MavenSpringBootWebAppliction.class);
    }
}
```