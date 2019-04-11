package com.lym.springboot.jpa.repository;

import com.lym.springboot.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: in liuyuanming
 * @Description:   使用jpa最大的好处就是你只需要基础一个JpaRepository接口，其余的都交给jpa自己去处理，我们只负责调用就好了
 * @Date:Created in  2019/4/11/011 16:13
 */
public interface UserRepository extends JpaRepository<User,Long> {

    //使用jpa最大的好处就是你只需要基础一个JpaRepository接口，其余的都交给jpa自己去处理，我们只负责调用就好了

}
