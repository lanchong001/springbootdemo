package com.lym.springboot.mockmvc.exception;

/**
 * @Author: in lym
 * @Description: WebApi接口方法 产生的异常
 * @Date:Created in  2019/5/14 16:56
 */
public class WebApiException extends BaseException {

    public WebApiException(int code, String message) {
        super(code, message);
    }
}
