package com.lym.springboot.jpacustom.repository;

import com.lym.springboot.jpacustom.domain.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/27 17:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class UserReposotoryTest {

    @Autowired
    private UserReposotory userReposotory;

    @Test
    public void testFindByAuto(){
        Person person = new Person();
        person.setName("xx");
        Pageable pageable = PageRequest.of(0, 2);
        Page<Person> byAuto = userReposotory.findByAuto(person, pageable);
        Assert.assertTrue(byAuto != null && byAuto.getTotalPages() > 0);
    }

}