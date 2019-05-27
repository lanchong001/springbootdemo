package com.lym.springboot.jpacustom.controller;

import com.lym.springboot.jpacustom.domain.Person;
import com.lym.springboot.jpacustom.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Person controller.
 *
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in 2019/5/27 10:06
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    /**
     * Save person.
     *
     * @param name    the name
     * @param address the address
     * @param age     the age
     * @return the person
     */
    @RequestMapping("/save")
    public Person save(String name, String address, Integer age) {
        return personRepository.save(new Person(name, age, address));
    }


    /**
     * Q 1 list. 方法命名 属性查询
     *
     * @param address the address
     * @return the list
     */
    @RequestMapping("q1")
    public List<Person> q1(String address) {
        return personRepository.findByAddress(address);
    }


    /**
     * Q 2 person. 方法命名 属性组合查询
     *
     * @param name    the name
     * @param address the address
     * @return the person
     */
    @RequestMapping("/q2")
    public Person q2(String name, String address) {
        return personRepository.findByNameAndAddress(name, address);
    }

    /**
     * Q 3 person. @Query JPQL 查询
     *
     * @param name    the name
     * @param address the address
     * @return the person
     */
    @RequestMapping("/q3")
    public Person q3(String name, String address) {
        return personRepository.withNameAndAddressQuery(name, address);
    }

    /**
     * Q 4 person. @NameQuery查询 JPQL查询
     *
     * @param name    the name
     * @param address the address
     * @return the person
     */
    @RequestMapping("/q4")
    public Person q4(String name, String address) {
        return personRepository.withNameAndAddressNameQuery(name, address);
    }

    /**
     * Sort list. 排序
     *
     * @return the list
     */
    @RequestMapping("/sort")
    public List<Person> sort() {
        return personRepository.findAll(new Sort(Sort.Direction.DESC, "age"));
    }

    /**
     * Page page. 分页
     *
     * @return the page
     */
    @RequestMapping("/page")
    public Page<Person> page() {
        return personRepository.findAll(PageRequest.of(2, 2));
    }
}
