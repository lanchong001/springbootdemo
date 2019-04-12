package com.lym.springboot.jpa.service.impl;

import com.lym.springboot.jpa.domain.User;
import com.lym.springboot.jpa.repository.UserRepository;
import com.lym.springboot.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/12/012 16:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        List<User> list = userRepository.findAllById(Arrays.asList(id));
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean saveUser(User user) {
        User newUser = userRepository.save(user);
        if (newUser != null && newUser.getId() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean updateUser(User user) {
        User newUser = userRepository.save(user);
        if (newUser != null && newUser.getName() == user.getName() && newUser.getAge() == user.getAge()) {
            return true;
        } else {
            return false;
        }
    }
}
