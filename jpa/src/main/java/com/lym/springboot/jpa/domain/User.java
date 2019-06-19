package com.lym.springboot.jpa.domain;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/11/011 16:11
 */
@Entity
@Table(name = "user")
/**
 * 注意   User.withNameAndAddressNamedQuery User 必须大写
 *        select p from User p where p.name=?1 and p.address=?2  User必须大写
 */
@NamedQuery(name = "User.withNameAndAddressNamedQuery", query = "select p from User p where p.name=?1 and p.address=?2")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String address;

    private Timestamp birthday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }
}
