package com.lym.springboot.generatecode.core;

import com.lym.springboot.generatecode.SpringBootVelocityGenerateCodeUtilApplicationTests;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/25/025 9:59
 */

public class CodeUtilTest extends SpringBootVelocityGenerateCodeUtilApplicationTests {

    @Test
    public void generateCode() throws Exception {

        String templateName = "vm/Controller.vm";
        String className = "User";
        String pakeageName = "com.lym.springboot";
        Map<String,String> map = new HashMap<>();
        map.put("serviceImport","com.lym.springboot.service.UserService");
        map.put("description","用户管理模块");
        map.put("author","liuyuanming");
        map.put("nameSpace","com.lym.springboot");
        map.put("resultLocation","User");
        map.put("className","UserController");
        map.put("serviceInterface","UserService");
        map.put("serviceName","userService");
        map.put("methodName","User");

        CodeUtil.generateCode(templateName,className,pakeageName,map);

    }

}