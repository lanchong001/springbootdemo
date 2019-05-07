package com.lym.springboot.springbootshiro.repository;

import com.lym.springboot.springbootshiro.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/6 19:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUserByName(){
        String name = "lym";
        User user = userRepository.findByName(name);
        Assert.assertTrue(user != null && user.getId() > 0);
    }

}