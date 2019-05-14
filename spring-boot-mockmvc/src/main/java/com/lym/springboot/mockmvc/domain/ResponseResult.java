package com.lym.springboot.mockmvc.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: in liuyuanming
 * @Description: 通用返回结果类,http请求返回的最外层对象
 * @Date:Created in  2019/4/19/019 17:23
 */
@Data
public class ResponseResult<T> implements Serializable {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;



}
