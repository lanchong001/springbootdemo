package com.lym.springboot.junit.controller;

import com.lbx.framework.common.exception.BaseException;
import com.lbx.framework.common.exception.WebApiException;
import com.lym.springboot.junit.domain.PosInfo;
import com.lym.springboot.junit.service.UserService;
import com.lym.springboot.junit.util.WebApiAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/6/12 14:34
 */
@RestController
@RequestMapping(value = "/pos")
public class PosController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/getinfo")
    public PosInfo getInfo(@RequestBody PosInfo posInfo) {
        WebApiAssert.validation(posInfo);
        return posInfo;
    }

    @GetMapping(value = "/controller")
    public PosInfo controller() {
        throw new BaseException(-1, "controller异常");
    }

    @GetMapping(value = "/service")
    public PosInfo service() {
        Integer userAge = userService.getUserAge(11111L);
        return null;
    }

    @PostMapping(value = "/post_controller")
    public PosInfo post_controller() {
        throw new WebApiException(-1, "controller异常");
    }


    @PostMapping(value = "/post_service")
    public PosInfo post_service() {
        Integer userAge = userService.getUserAge(11111L);
        return null;
    }
}
