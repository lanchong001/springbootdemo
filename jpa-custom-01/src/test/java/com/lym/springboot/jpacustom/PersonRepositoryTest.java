package com.lym.springboot.jpacustom;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/27 16:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    /**
     * 查询自定义库中的方法, 实时执行 Sql 语句
     */
    @Test
    public void testFindListByNativeSql() {
        List<Person> listByNativeSql = personRepository.findListByNativeSql("select * from person where name='lili'", Person.class);
        Assert.assertTrue(!CollectionUtils.isEmpty(listByNativeSql));
    }


//    @Test
//    public void testUserQuery(){
//        List<User> listByNativeSql = personRepository.findListByNativeSql("select name,age,address from person where name='lili'", User.class);
//        Assert.assertTrue(!CollectionUtils.isEmpty(listByNativeSql));
//    }

    /**
     * 查询自定义实体类
     */
    @Test
    public void testQueryAllUsers() {
        List<User> listByNativeSql = personRepository.queryAllUsers();
        Assert.assertTrue(!CollectionUtils.isEmpty(listByNativeSql));
    }
}