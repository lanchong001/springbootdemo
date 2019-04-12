package com.lym.springboot.jpa.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * @Author: in liuyuanming
 * @Description: 纯java config的方式去配置druid, javaBean方式注册数据库连接池
 * @Date:Created in  2019/4/12/012 19:18
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
