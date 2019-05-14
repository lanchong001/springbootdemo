package com.lym.springboot.mockmvc.enums;

import lombok.Getter;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/22/022 10:28
 */
@Getter
public enum ResultEnum {
    SECCESS(1, "操作成功"),
    FAILURE(-1, "操作失败"),
    INPUT_PARAM_ERROR(10001, "参数异常"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
