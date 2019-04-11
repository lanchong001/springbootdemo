package com.lym.springboot.jdectemplate.repository;

import com.lym.springboot.jdectemplate.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/11/011 15:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUsers() throws Exception {
        List<User> list = userRepository.findUsers();
        Assert.assertTrue(list != null && list.size() > 0);
    }

    @Test
    public void findUserById() throws Exception {
        User user = userRepository.findUserById(2L);
        Assert.assertTrue(user != null && user.getName().equals("zhangsan99"));
    }

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setName("test1111");
        user.setAge(11);
        int id = userRepository.saveUser(user);
        Assert.assertTrue(id > 0);
    }

    @Test
    public void delUserById() throws Exception {
        long id = 111;
        int result = userRepository.delUserById(111);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setId(111);
        user.setName("test2222");
        user.setAge(22);
        int result = userRepository.updateUser(user);
        Assert.assertTrue(result > 0);
    }

}