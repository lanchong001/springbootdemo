package com.lym.springboot.mybatis.annotation.mapper;

import com.lym.springboot.mybatis.annotation.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/11/011 17:42
 */
@Mapper
public interface UserMapper {

    @Select("select * from user ")
    List<User> findUsers();

    @Select("select * from user where id = #{id}")
    User findUserById(long id);

    @Insert("insert into user(name,age) values (#{name},#{age})")
    int saveUser(User user);

    @Delete("delete from user where id = #{id}")
    int delUserById(long id);

    @Update("update user set name = #{name}, age = #{age} where id = #{id} ")
    int updateUser(User user);

    @Select("select count(*) from user ")
    int getCount();
}
