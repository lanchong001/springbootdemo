### jpa durid yml 配置文件的方式
---
1. 引入druid相关的依赖
```
    <!-- 引入druid依赖 -->
    <!-- 此处的引用有两种 -->
    <!-- 一种是直接引用druid包,另一种是引用starter方式 -->
    <!-- 在此处我引用的是start包,为什么呢，因为方便呀... -->
    <!-- 注:如果没有该包,application.properties/application.yml 中将不会出现关于druid的提示 -->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
        <version>1.1.10</version>
    </dependency>
```
2. 创建 Druid DataSourceConfig java 注解配置类
```
package com.lym.springboot.jpa.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * @Description: 纯java config的方式去配置druid, javaBean方式注册数据库连接池
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DruidDataSource getDataSourceConfig() throws SQLException {
        DruidDataSource ds = new DruidDataSource();
        // 基本属性
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        // 配置初始化大小、最小、最大
        ds.setInitialSize(5);
        ds.setMinIdle(5);
        ds.setMaxActive(50);
        // 配置获取连接等待超时的时间
        ds.setMaxWait(60000);
        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        ds.setTimeBetweenEvictionRunsMillis(60000);
        // 配置一个连接在池中最小生存的时间，单位是毫秒
        ds.setMinEvictableIdleTimeMillis(300000);
        ds.setValidationQuery("SELECT 'X'");
        ds.setTestWhileIdle(true);
        ds.setTestOnBorrow(false);
        ds.setTestOnReturn(false);

        // 打开PSCache，并且指定每个连接上PSCache的大小
        ds.setPoolPreparedStatements(false);
        ds.setMaxPoolPreparedStatementPerConnectionSize(20);
        // 配置监控统计拦截的filters
        ds.setFilters("stat,wall");
        return ds;
    }

    // JDBC模板
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource) throws SQLException {
        return new JdbcTemplate(druidDataSource);
    }
}

```
3. 创建 DruidStatViewServletConfig Druid 监控启动Servlet 注解配置类
```
package com.lym.springboot.jpa.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: druid监控页面的配置
 */
@Configuration
public class DruidStatViewServletConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        //添加初始化参数：initParams
        //白名单：
//        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
//        servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
```

4. 启动Web项目，访问 http://localhost:8080/druid 查看 druid 相关的监控信息
