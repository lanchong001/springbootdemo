package com.lym.springboot.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: in liuyuanming
 * @Description: 公共属性配置类
 * @Date:Created in  2019/5/10 15:09
 */
@ConfigurationProperties("com.lym.spring.service")
public class ExampleServiceProperties {

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 后缀
     */
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
