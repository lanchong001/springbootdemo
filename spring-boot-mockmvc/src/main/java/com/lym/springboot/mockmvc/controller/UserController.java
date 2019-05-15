package com.lym.springboot.mockmvc.controller;

import com.lym.springboot.mockmvc.domain.ResponseResult;
import com.lym.springboot.mockmvc.domain.User;
import com.lym.springboot.mockmvc.exception.WebApiException;
import com.lym.springboot.mockmvc.exception.WebException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/14 19:08
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    /**
     * Get
     *
     * @return
     */
    @RequestMapping(value = "/index")
    @ResponseBody
    public User index() {
        User user = new User();
        user.setId(1);
        user.setName("lili");
        return user;
    }

    /**
     * Post
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public User login(@RequestBody User user) {
        return user;
    }

    /**
     * WebApi Exception
     *
     * @return
     */
    @RequestMapping(value = "/webapi")
    @ResponseBody
    public ResponseResult<User> webApiException() {
        throw new WebApiException(-1, "web api error");
    }

    /**
     * WebException
     *
     * @return
     */
    @RequestMapping(value = "/web")
    public String webException() {
        throw new WebException(-1, "web error");
    }

    /**
     * WebException
     *
     * @return
     */
    @RequestMapping(value = "/500")
    public String error_500() {
        int i = 1 / 0;
        return "";
    }
}
