package com.lym.springboot.shardingjdbc.repository;

import com.lym.springboot.shardingjdbc.domain.MyFriendEntity;
import com.lym.springboot.shardingjdbc.domain.MyFriendEntityId;
import com.lym.springboot.shardingjdbc.domain.UserAuthEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/21 16:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcTest {

    @Autowired
    private MyFriendRespository myFriendRespository;

    @Autowired
    private UserAuthRespository userAuthRespository;

    @Test
    public void testInsert() {

        MyFriendEntity friendEntity = new MyFriendEntity();
        friendEntity.setMyFriendId(new MyFriendEntityId(3l, 5l));
        friendEntity.setAddDate(LocalDateTime.now());
        myFriendRespository.save(friendEntity);

        friendEntity.setMyFriendId(new MyFriendEntityId(5l, 5l));
        friendEntity.setAddDate(LocalDateTime.now());
        myFriendRespository.save(friendEntity);

        friendEntity.setMyFriendId(new MyFriendEntityId(6l, 5l));
        friendEntity.setAddDate(LocalDateTime.now());
        myFriendRespository.save(friendEntity);

        UserAuthEntity user = new UserAuthEntity();
        user.setUserId(2);
        user.setLocalPassword("123");
        userAuthRespository.save(user);
    }

    @Test
    public void testQuery(){
        Optional<MyFriendEntity> byId = myFriendRespository.findById(new MyFriendEntityId(6l, 5l));
        byId.ifPresent(one -> System.out.println(one.getMyFriendId().getFriendId()));

        List<MyFriendEntity> all = myFriendRespository.findAll();
        System.out.println(all);
    }

}
