package com.lym.springboot.shardingjdbc.repository;

import com.lym.springboot.shardingjdbc.domain.MyFriendEntity;
import com.lym.springboot.shardingjdbc.domain.MyFriendEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/21 16:18
 */
public interface MyFriendRespository extends JpaRepository<MyFriendEntity, MyFriendEntityId> {

}
