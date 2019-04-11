package com.lym.springboot.mybatis.annotation.mapper;

import com.lym.springboot.mybatis.annotation.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/11/011 18:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findUsers() throws Exception {
        List<User> list = userMapper.findUsers();
        Assert.assertTrue(list != null && list.size() > 0);
    }

    @Test
    public void findUserById() throws Exception {
        User user = userMapper.findUserById(2L);
        Assert.assertTrue(user != null && user.getName().equals("zhangsan99"));
    }

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setName("test1111");
        user.setAge(11);
        int id = userMapper.saveUser(user);
        Assert.assertTrue(id > 0);
    }

    @Test
    public void delUserById() throws Exception {
        long id = 115;
        int result = userMapper.delUserById(id);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setId(116);
        user.setName("test2222");
        user.setAge(22);
        int result = userMapper.updateUser(user);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void getCount() throws Exception {
        int result = userMapper.getCount();
        Assert.assertTrue(result > 0);
    }

}