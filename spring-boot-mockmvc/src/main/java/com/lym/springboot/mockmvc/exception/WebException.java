package com.lym.springboot.mockmvc.exception;

/**
 * @Author: in lym
 * @Description: Web页面(ModelAndView)方法产生的异常
 * @Date:Created in  2019/5/14 16:54
 */
public class WebException extends BaseException {

    public WebException(int code, String message) {
        super(code, message);
    }
}
