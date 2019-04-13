### Swagger2-1 : 采用 io.springfox.springfox-swagger2 实现WebApi文档
---
1. 在 pom 文件中增加 Swagger2 相关的依赖
```
    <!--Swagger2 相关的依赖-->
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.6.1</version>
    </dependency>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.6.1</version>
    </dependency>
```
2. 创建 Swagger2 相关的 java bean 注解配置类
```
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lym.springboot.swagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot利用Swagger构建api文档")
                .description("创建restful风格 WebApi 接口")
                .termsOfServiceUrl("http://blog.csdn.net/saytime")
                .version("1.0")
                .build();
    }
}
```
3. 创建 controller , 在对应的 WebApi 方法上增加相关的注解和属性配置
```
    /**
     * 根据ID查询用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    
    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    
    /**
     * 根据id修改用户信息
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "更新信息", notes = "根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
```
3. Spring Boot main 方法中增加 @EnableSwagger2 注解
```
    @SpringBootApplication
    @EnableSwagger2
    public class SwaggerApplication {
        public static void main(String[] args) {
            SpringApplication.run(SwaggerApplication.class, args);
        }
    }
```

---
### Swagger2 更改成中文的处理方式

1. 从 External Libraries 库中找到 springfox-swagger-ui.xxx.jar , 打开类库 META-INF / resources / swagger-ui.html.
2. 将 swagger-ui.html 复制到当前项目的 src / resources / META-INF.resource 目录中
3. 修改 swagger-ui.html 文件，增加中文环境相关的js
```
    <head>
      ...
      <script src='webjars/springfox-swagger-ui/springfox.js' type='text/javascript'></script>
      <!--国际化操作：选择中文版 -->
      <script src='webjars/springfox-swagger-ui/lang/translator.js' type='text/javascript'></script>
      <script src='webjars/springfox-swagger-ui/lang/zh-cn.js' type='text/javascript'></script>
    </head>
```

---
### 扩展功能

https://github.com/SpringForAll/spring-boot-starter-swagger