package com.lym.springboot.reflection.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/7 21:42
 */
@Getter
@Setter
public class UserVo extends BaseVo {

    private int id;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("create_date")
    private Date createDate;
}
