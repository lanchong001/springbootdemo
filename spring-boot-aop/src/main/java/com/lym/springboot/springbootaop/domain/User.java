package com.lym.springboot.springbootaop.domain;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/6/6 16:15
 */
@Data
public class User {
    private String id;

    private int age;

    private Timestamp brithday;
}
