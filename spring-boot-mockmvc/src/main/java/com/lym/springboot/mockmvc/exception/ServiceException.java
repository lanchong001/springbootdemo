package com.lym.springboot.mockmvc.exception;

/**
 * @Author: in lym
 * @Description: 业务处理类产生的异常
 * @Date:Created in  2019/5/14 16:57
 */
public class ServiceException extends BaseException {

    public ServiceException(int code, String message) {
        super(code, message);
    }
}
