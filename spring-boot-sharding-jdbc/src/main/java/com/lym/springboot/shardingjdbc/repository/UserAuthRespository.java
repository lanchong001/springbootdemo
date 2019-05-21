package com.lym.springboot.shardingjdbc.repository;

import com.lym.springboot.shardingjdbc.domain.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/21 16:12
 */
@Repository
public interface UserAuthRespository extends JpaRepository<UserAuthEntity, Integer> {

    public List<UserAuthEntity> findByUserIdBetween(int start, int end);

}
