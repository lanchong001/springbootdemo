package com.lym.springboot.jdbctemplate.repository;

import com.lym.springboot.jdbctemplate.domain.User;

import java.util.List;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/11/011 15:00
 */
public interface UserRepository {

    List<User> findUsers();

    User findUserById(long id);

    int saveUser(User user);

    int delUserById(long id);

    int updateUser(User user);

    int getCount();
}
