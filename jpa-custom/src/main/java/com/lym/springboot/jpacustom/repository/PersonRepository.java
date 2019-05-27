package com.lym.springboot.jpacustom.repository;

import com.lym.springboot.jpacustom.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/27 9:58
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByAddress(String name);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    Person withNameAndAddressNameQuery(String name, String address);

}
