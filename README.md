### Spring Boot 多模块父子依赖

1. 创建父项目工程
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!-- 1.基本信息 -->
    <modelVersion>4.0.0</modelVersion>
    <packaging>pom</packaging>

    <!-- 2.项目说明：这里作为聚合工程的父工程 -->
    <groupId>com.lym.springboot</groupId>
    <artifactId>springboot-demo</artifactId>
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