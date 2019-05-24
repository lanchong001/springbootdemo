package com.lym.springboot.jpa.repository;

import com.lym.springboot.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: in liuyuanming
 * @Description: 使用jpa最大的好处就是你只需要基础一个JpaRepository接口，其余的都交给jpa自己去处理，我们只负责调用就好了
 * @Date:Created in  2019/4/11/011 16:13
 */
@SuppressWarnings("ALL")
public interface UserRepository extends JpaRepository<User, Long> {

    //使用jpa最大的好处就是你只需要基础一个JpaRepository接口，其余的都交给jpa自己去处理，我们只负责调用就好了

    /**
     * 根据属性名查询
     *
     * @param name
     * @return
     */
    List<User> findByAddress(String name);

    /**
     * 根据属性名查询
     *
     * @param name
     * @param address
     * @return
     */
    User findByNameAndAddress(String name, String address);

    /**
     * @Query 中表名 User 必须大写, 与实体类的名称一致
     * 使用@Query查询 命名参数
     */
    @Query("select p from User p where p.name = :name and p.address = :address")
    User withNameAndAddressQuery1(@Param("name") String name, @Param("address") String address);

    /**
     * @param name
     * @param address
     * @return
     * @Query 中表名 User 必须大写, 与实体类的名称一致
     * 使用@Query查询 参数索引
     */
    @Query("select p from User p where p.name = ?1 and p.address = ?2")
    User withNameAndAddressQuery2(String name, String address);

    /**
     * 使用 @NamedQuery 进行查询
     * @param name
     * @param address
     * @return
     */
    List<User> withNameAndAddressNamedQuery(String name, String address);
}
