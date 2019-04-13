package com.lym.springboot.global.exception.hanlder.exception;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/13/013 15:49
 */
public class BusinessException extends RuntimeException {

    private String message;
    private Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException(String message, Integer code) {
        super();
        this.message = message;
        this.code = code;
    }
}
