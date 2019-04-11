package com.lym.springboot.mybatis.xml.mapper;

import com.lym.springboot.mybatis.xml.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/11/011 19:07
 */
public interface UserMapper {

    List<User> findUsers();

    User findUserById(long id);

    int saveUser(User user);

    int delUserById(long id);

    int updateUser(User user);

    int getCount();

}
