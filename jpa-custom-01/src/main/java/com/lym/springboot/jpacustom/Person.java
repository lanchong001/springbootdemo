package com.lym.springboot.jpacustom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/27 9:35
 */
@Entity
@NamedQuery(name = "Person.withNameAndAddressNameQuery", query = "select p from Person p where p.name= ?1 and  p.address= ?2")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    private String address;

    public Person() {
        super();
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
