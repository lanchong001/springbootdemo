package com.lym.springboot.springbootshiro.repository;


import com.lym.springboot.springbootshiro.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: in liuyuanming
 * @Description: 使用jpa最大的好处就是你只需要基础一个JpaRepository接口，其余的都交给jpa自己去处理，我们只负责调用就好了
 * @Date:Created in  2019/4/11/011 16:13
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    //使用jpa最大的好处就是你只需要基础一个JpaRepository接口，其余的都交给jpa自己去处理，我们只负责调用就好了
    @Query(value = "select u.id, u.name,u.password from user u where u.name = :name", nativeQuery = true)
    User findByName(@Param("name") String name);

}
