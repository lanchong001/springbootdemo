package com.lym.springboot.junit.service.impl;

import com.lbx.framework.common.exception.WebApiException;
import com.lym.springboot.junit.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/6/19 13:48
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public Integer getUserAge(Long userId) {
//        throw new BaseException(-1, "server  异常");
        throw new WebApiException(-1, "webapi service 异常");
    }
}
