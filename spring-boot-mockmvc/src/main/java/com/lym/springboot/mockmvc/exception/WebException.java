package com.lym.springboot.mockmvc.exception;

/**
 * @Author: in lym
 * @Description: Web页面(ModelAndView)方法产生的异常
 * @Date:Created in  2019/5/14 16:54
 */
public class WebException extends RuntimeException {

    private int code;

    public WebException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
