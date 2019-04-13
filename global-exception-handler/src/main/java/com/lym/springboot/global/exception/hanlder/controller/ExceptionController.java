package com.lym.springboot.global.exception.hanlder.controller;

import com.lym.springboot.global.exception.hanlder.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/13/013 15:57
 */
@RestController
public class ExceptionController {
    @GetMapping("/exception/{id}")
    public String Demo(@PathVariable Integer id) {
        if (id < 0) {
            throw new BusinessException("输入的参数ID，必须大于0! ", -1);
        }
        return String.valueOf(id);
    }
}
