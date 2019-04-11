package com.lym.springboot.jdectemplate.repository.impl;

import com.lym.springboot.jdectemplate.domain.User;
import com.lym.springboot.jdectemplate.mapper.UserRowMapper;
import com.lym.springboot.jdectemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/11/011 15:01
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findUsers() {
        // JdbcTemplate 查询方式三 : 查询对象集合
        return jdbcTemplate.query("select * from user", new UserRowMapper());
    }

    public User findUserById(long id) {
//        List<User> users = jdbcTemplate.query("select * from user where id = ?", new Object[]{id}, new UserRowMapper());
//        User user = null;
//        if (users != null && !users.isEmpty()) {
//            user = users.get(0);
//        }
//        return user;

        // JdbcTemplate 查询方式一 : 查询单个对象
        return jdbcTemplate.queryForObject("select * from user where id = ?", new UserRowMapper(),new Object[]{id});
    }

    public int saveUser(User user) {
        return jdbcTemplate.update("insert into user (name,age) values (?,?)", new Object[]{user.getName(), user.getAge()});
    }

    public int delUserById(long id) {
        return jdbcTemplate.update("delete from user where id = ?", new Object[]{id});
    }

    public int updateUser(User user) {
        return jdbcTemplate.update("update user set name = ? , age = ? where id = ?", new Object[]{user.getName(), user.getAge(), user.getId()});
    }

    public int getCount() {
        // JdbcTemplate 查询方式二 : 查询单个值
        return jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
    }
}
