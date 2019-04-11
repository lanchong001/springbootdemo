### mybatis xml 配置

---

* nested exception is java.sql.SQLSyntaxErrorException: Table 'baseinfo.USER_DETAIL' doesn't exist
```

```

* org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)
```
// 错误
mybatis:
  typeAliasesPackage: com.lym.springboot.mybatis.xml.domain
  mybatis.mapper-locations: classpath:mapper/*Mapper.xml
---
// 正确
mybatis:
  typeAliasesPackage: com.lym.springboot.mybatis.xml.domain
  mapper-locations: classpath:mapper/*Mapper.xml
```

---

### Spring Boot , Mybatis , Xml 注解 步骤
1. 创建 Spring boot 项目，添加 mybatis, mysql 项目依赖
```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.0.1</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
```
2. 在application.yml 添加数据库连接及 mybatis  mapper-locations(xml文件路径) 属性
```
    spring:
      datasource:
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://10.249.0.25:3307/baseinfo?useUnicode=true&characterEncoding=utf-8&useSSL=false
        username: root
        password: 123456
    
    #mybatis.typeAliasesPackage：为实体对象所在的包，跟数据库表一一对应
    #mybatis.mapperLocations：mapper文件的位置
    
    mybatis:
      typeAliasesPackage: com.lym.springboot.mybatis.xml.domain
      mapper-locations: classpath:mapper/*Mapper.xml
```
3. 创建对应的实体类
```
public class User {
    ...
}
```
4. 创建对应的mapper接口和接口方法
```
public interface UserMapper {
    List<User> findUsers();
    User findUserById(long id);
    int saveUser(User user);
    int delUserById(long id);
    int updateUser(User user);
    int getCount();
}
```
5. 创建Mapper.xml文件,并配置接口对应的方法
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<!--你接口的包名是com.abc.dao,接口名是NameMapper.java，那么你的mapper.xml的namespace应该是com.abc.dao.NameMapper-->
<mapper namespace="com.lym.springboot.mybatis.xml.mapper.UserMapper">

    <!--resultMap对应的是表与实体类的映射  - type 数据库表对应的实体类，别名或完整类名都可以-->
    <resultMap id="BaseResultMap" type="com.lym.springboot.mybatis.xml.domain.User">
        <!-- 结果集的主键 -->
        <id column="id" property="id" jdbcType="BIGINT"/>
        <!-- 普通的列  -column 是数据库中字段， property是实体类中字段-->
        <result column="name" property="name" jdbcType="VARCHAR"/>
        <result column="age" property="age" jdbcType="INTEGER"/>
    </resultMap>

    <!--parameterType(输入类型)、resultType(输出类型)-->
    <select id="findUsers" resultMap="BaseResultMap" resultType="java.util.List">
        SELECT * FROM user
    </select>

    <select id="findUserById" parameterType="java.lang.Long" resultMap="BaseResultMap"
            resultType="com.lym.springboot.mybatis.xml.domain.User">
        SELECT * FROM user WHERE id = #{id,jdbcType=BIGINT}
    </select>

    <insert id="saveUser" parameterType="com.lym.springboot.mybatis.xml.domain.User">
        insert into user(name,age) values (#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})
    </insert>

    <update id="updateUser" parameterType="com.lym.springboot.mybatis.xml.domain.User">
        update user set name = #{name,jdbcType=VARCHAR}, age = #{age,jdbcType=INTEGER} where id = #{id}
    </update>

    <delete id="delUserById" parameterType="java.lang.Long">
        delete from user where id = #{id,jdbcType=BIGINT}
    </delete>

    <select id="getCount" resultType="java.lang.Integer">
        SELECT count(*) FROM user
    </select>
</mapper>
```
6. main方法增加 MapperScan 注解扫描
```
@SpringBootApplication
// mybatis扫描路径，针对的是接口Mapper类
@MapperScan("com.lym.springboot.mybatis.xml.mapper")
public class MybatisXmlApplication {
	public static void main(String[] args) {
		SpringApplication.run(MybatisXmlApplication.class, args);
	}
}
```

---
### 注意事项：
1. application.yml 中 数据源配置 和 Mybatis配置不能出错
2. main 方法增加 mpper 接口的扫描配置
3. 检查 xml 文件中不能存在语法错误？数据表名在数据库是否存在？ namespace 是否是完整的 命令空间 + 类名
