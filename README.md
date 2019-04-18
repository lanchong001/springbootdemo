### Spring Boot Demo 简介
---
名称 | 描述 | 时间
-- | -- | --
jdbctemplate | JdbcTemplate访问Mysql数据库 | 2019.04.11
jpa | jpa 访问Mysql数据库 | 2019.04.11
mybatis-annotation | mybatis mapper注解方式访问mysql数据库 | 2019.04.11
mybatis-xml | mybatis xml 配置方式访问mysql数据库 | 2019.04.11
jpa-druid-javaconfig | jpa访问mysql数据库,采用java bean config配置方式集成druid数据访问线程池 | 2019.04.12
jpa-druid-yml | jpa访问mysql数据库,采用yml配置文件的方式集成druid数据访问线程池 | 2019.04.12
maven-springboot-web | 通过Maven脚手架创建SpringBoot项目 | 2019.04.12
lombok | lombok应用 | 2019.04.13
logback | Spring Boot 自带日志库 | 2019.04.13
global-exception-handler | Spring MVC 全局异常处理 | 2019.04.13
Swagger2-1 | 采用 io.springfox.springfox-swagger2 实现WebApi文档 | 2019.04.13
thymeleaf | Spring Boot thymeleaf 模板引擎的使用 | 2019.04.16
thymeleaf-layui | Spring Boot thymeleaf, Layui 模板引擎的使用 | 2019.04.16
websocket | Spring Boot websocket 的使用 | 2019.04.17
spring-boot-cache | Spring Boot cache 的使用 | 2019.04.18


http://www.importnew.com/26055.html
https://blog.csdn.net/gnail_oug/article/details/80662553
https://segmentfault.com/a/1190000008847948
https://segmentfault.com/a/1190000014479154


### Spring Boot 多模块父子依赖
---
1. 创建父项目工程
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!-- 1.基本信息 -->
    <modelVersion>4.0.0</modelVersion>
    <packaging>pom</packaging>
    <name>springbootdemo</name>

    <!-- 2.项目说明：这里作为聚合工程的父工程 -->
    <groupId>com.lym.springboot</groupId>
    <artifactId>springbootdemo</artifactId>
    <version>1.0.0</version>

    <!-- 3. 继承说明：这里继承SpringBoot提供的父工程 -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.4.RELEASE</version>
        <relativePath/>
    </parent>

    <!-- 4.模块说明：这里声明多个子模块 -->
    <modules>
        <module>jdectemplate</module>
        ...
    </modules>

    <properties>
        <java.version>1.8</java.version>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>


    <!-- 5. 版本说明：这里统一管理依赖的版本号 -->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-parent</artifactId>
                <version>2.1.4.RELEASE</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```
2. 创建子模块
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<!-- 1.基本信息 -->
	<modelVersion>4.0.0</modelVersion>
	<name>jdectemplate</name>
	<description>jdectemplate demo</description>

	<!-- 2.继承说明：这里继承SpringBoot提供的父工程 -->
	<parent>
		<groupId>com.lym.springboot</groupId>
		<artifactId>springboot-demo</artifactId>
		<version>1.0.0</version>
	</parent>

	<!-- 3.项目说明：这里作为聚合工程的子工程 -->
	<groupId>com.lym.springboot</groupId>
	<artifactId>jdectemplate</artifactId>
	<version>1.0.0</version>

	<!-- 4.模块相关依赖 -->
	<dependencies>
        ...
	</dependencies>
</project>

```