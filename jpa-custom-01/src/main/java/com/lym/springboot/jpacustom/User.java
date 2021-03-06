package com.lym.springboot.jpacustom;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/27 18:40
 */
public class User {

    private String name;

    private Integer age;

    private String address;

    public User() {

    }

    public User(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
