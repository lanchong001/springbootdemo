package com.lym.springboot.mockmvc.domain;

import lombok.Data;

/**
 * @Author: in liuyuanming
 * @Description: 异常信息实体类
 * @Date:Created in  2019/5/15 15:13
 */
@Data
public class ExceptionEntity {
    /**
     * 错误消息
     */
    private String message;
    /**
     * 错误码
     */
    private int code;
    /**
     * 错误url
     */
    private String url;
    /**
     * 错误类
     */
    private String errorClass;
}
