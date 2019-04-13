package com.lym.springboot.swagger.domain;

import lombok.Data;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/13/013 17:13
 */
@Data
public class JsonResult {

    private String status = null;

    private Object result = null;

}
