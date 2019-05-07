package com.lym.springboot.springbootshiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: in liuyuanming
 * @Description: Shiro的配置类
 * @Date:Created in  2019/5/6 10:14
 */
@Configuration
public class ShiroConfig {

    /**
     * 1. 创建 ShiorFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         *  添加shiro内置过滤器,可以实现权限相关的拦截器
         *  常用过滤器：
         *      anon: 无需认证(登录)就可以访问
         *      authc: 必须认证才可以访问
         *      user: 如果使用rememberMe的功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      role: 该资源必须得到角色权限才可以访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

//        filterMap.put("/add", "authc");
//        filterMap.put("/update", "authc");


        // test页面无需认证  注意优先级
        filterMap.put("/test", "anon");

        //login页面无需认证
        filterMap.put("/login", "anon");

        // 拦截所有页面
        filterMap.put("/*", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        //修改 shiro 默认登录页面
        shiroFilterFactoryBean.setLoginUrl("/tologin");

        return shiroFilterFactoryBean;
    }


    /**
     * 2. 创建 DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 3. 创建 Realm对象(自定义)
     */
    @Bean(name = "userRealm")
    public UserRealm getUserRealm() {
        return new UserRealm();
    }
}
