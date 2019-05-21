package com.lym.springboot.shardingjdbc.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: in liuyuanming
 * @Description: 用户认证信息
 * @Date:Created in  2019/5/21 16:10
 */

@Entity
@Table(name = "USER_AUTH")
public class UserAuthEntity<UniqueConstraint> implements Serializable {

    private static final long serialVersionUID = -3050810548161476299L;

    @Id
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "PHONE", length = 16)
    private String phone;

    @Column(name = "EMAIL", length = 16)
    private String email;

    @Column(name = "LOCAL_PASSWORD", length = 32, nullable = false)
    private String localPassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalPassword() {
        return localPassword;
    }

    public void setLocalPassword(String localPassword) {
        this.localPassword = localPassword;
    }
}