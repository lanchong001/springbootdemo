package com.lym.springboot.jpa.repository;

import com.lym.springboot.jpa.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/11/011 16:15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUsers() throws Exception {
        // JdbcTemplate
        // List<User> list = userRepository.findUsers();

        List<User> list = userRepository.findAll();
        Assert.assertTrue(list != null && list.size() > 0);
    }

    @Test
    @Transactional
    public void findUserById() throws Exception {
        // JdbcTemplate
        // User user = userRepository.findUserById(2);


        User user = userRepository.getOne(2L);

        // User user = userRepository.findAllById(2L).get();
        Assert.assertTrue(user != null && user.getName().equals("zhangsan99"));
    }

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setName("test jpa  155");
        user.setAge(22);

        // JdbcTemplate
        // int id = userRepository.saveUser(user);
        // Assert.assertTrue(id > 0);

        user = userRepository.save(user);
        Assert.assertTrue(user.getId() > 0);
    }

    @Test
    public void delUserById() throws Exception {
        long id = 112L;

        // JdbcTemplate
        // int result = userRepository.delUserById(111);
        // Assert.assertTrue(result > 0);

       userRepository.deleteById(id);

    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setId(113);
        user.setName("test jpa 555");
        user.setAge(33);

        // JdbcTemplate
        // int result = userRepository.updateUser(user);
        // Assert.assertTrue(result > 0);

        user = userRepository.save(user);
        Assert.assertTrue(user.getName().equals("test jpa 555"));
    }

}