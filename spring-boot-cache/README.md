### spring-boot-cache : Spring Boot cache 的使用
---
1. 创建SpringBoot项目,引入相关POM文件
```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-cache</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
```
2. SpringBoot 启动类增加@EnableCaching注解,启动Spring Cache.(@EnableCache注解启动了Spring的缓存机制，它会使应用检测所有缓存相关的注解并开始工作，同时还会创建一个CacheManager的bean,可以被我们的应用注入使用)





http://www.cnblogs.com/yueshutong/p/9381540.html

https://www.jianshu.com/p/fc076b6c2a13
https://www.jianshu.com/p/3fbd5af2d789
https://blog.csdn.net/weixin_36279318/article/details/82820880