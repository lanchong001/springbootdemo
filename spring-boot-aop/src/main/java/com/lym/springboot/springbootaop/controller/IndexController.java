package com.lym.springboot.springbootaop.controller;

import com.lym.springboot.springbootaop.annotation.LoggerManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: in liuyuanming
 * @Description: Index Controller 控制类
 * @Date:Created in  2019/6/5 16:01
 */
@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/index")
    @LoggerManage(description = "获取用户名")
    public String getUserName(String userId){
        logger.info(userId);
        return "lym";
    }

}
