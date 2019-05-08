package com.lym.springboot.shiro.redis.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Author: in liuyuanming
 * @Description: 自定义 Realm 类
 * @Date:Created in  2019/5/6 10:39
 */
public class UserRealm extends AuthorizingRealm {

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    /**
     *
     * @param authenticationToken
     * @return 执行认证逻辑
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        //假设数据库的用户名和密码
        String name = "lym";
        String password = "123456";

        //编写shiro判断逻辑
        // 1. 判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        if(!token.getUsername().equals(name)){
            //用户名不存在, Shiro底层会抛出UnknownAccountException异常
            return null;
        }

        // 2. 判断密码
        return new SimpleAuthenticationInfo("",password,"");
    }
}
