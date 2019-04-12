package com.lym.springboot.jpa.service;

import com.lym.springboot.jpa.domain.User;

import java.util.List;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/12/012 16:50
 */
public interface UserService {

    List<User> findUsers();

    User findUserById(Long id);

    boolean saveUser(User user);

    void delUserById(Long id);

    boolean updateUser(User user);

}
