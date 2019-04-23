package com.lym.springboot.javaconfig;

import org.springframework.context.annotation.Scope;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/23/023 14:33
 */
@Scope(scopeName = "scopeName", value = "prototype")
public class DoWorkBean {

    private void init() {
        System.out.println("init...");
    }

    public void doWork(){
        System.out.println("do work...");
    }

    private void destory() {
        System.out.println("destroy...");
    }
}
