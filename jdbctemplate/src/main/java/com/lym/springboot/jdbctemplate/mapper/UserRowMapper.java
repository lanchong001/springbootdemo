package com.lym.springboot.jdbctemplate.mapper;

import com.lym.springboot.jdbctemplate.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/11/011 15:11
 */
public class UserRowMapper implements RowMapper<User> {

    @Nullable
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        return user;
    }
}
