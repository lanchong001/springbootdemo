package com.lym.springboot.jpacustom;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/27 16:10
 */
public interface PersonRepository extends BaseRepository<Person,Long> {

    @Query("SELECT new com.lym.springboot.jpacustom.User(name,age,address) FROM Person")
    List<User> queryAllUsers();

}
