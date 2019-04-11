### mybatais 注解方式

---

* org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dataSource' defined in class path resource
```
// 配置错误
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url:jdbc: mysql://10.249.0.25:3307/baseinfo?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: root
    password: 123456

---
// 配置正确
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://10.249.0.25:3307/baseinfo?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: root
    password: 123456
logging:
  level:
    com:
      lym:
       springboot:
         mybatis:
           annotation.mapper: debug

```