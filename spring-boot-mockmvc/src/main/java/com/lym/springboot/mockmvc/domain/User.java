package com.lym.springboot.mockmvc.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/7 14:38
 */
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

}
