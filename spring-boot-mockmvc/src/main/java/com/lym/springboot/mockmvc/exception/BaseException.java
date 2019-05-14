package com.lym.springboot.mockmvc.exception;

/**
 * @Author: in lym
 * @Description: 自定义基础异常
 * @Date:Created in  2019/4/19/019 19:00
 */
public class BaseException extends RuntimeException {

    private int code;

    public BaseException(int code, String message) {
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
