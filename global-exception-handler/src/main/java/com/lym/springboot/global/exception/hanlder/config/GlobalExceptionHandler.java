package com.lym.springboot.global.exception.hanlder.config;

import com.lym.springboot.global.exception.hanlder.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/13/013 15:53
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public BusinessException exceptionHandler(BusinessException e) {
        BusinessException exception = new BusinessException(e.getMessage(), e.getCode());
        return exception;
    }
}
