package com.lym.springboot.logback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/13/013 15:14
 */
@RestController
public class LogbackController {

    private static final Logger logger = LoggerFactory.getLogger(LogbackController.class);

    @GetMapping("/logback/info")
    public String logback() {
        logger.info("进入test方法");
        logger.debug("进入test方法");
        logger.warn("进入test方法");
        logger.error("进入test方法");
        return "测试 Logback 日志";
    }
}
