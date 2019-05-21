package com.lym.springboot.shardingjdbc.domain;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/21 16:14
 */
public class MyFriendEntityId implements Serializable {

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "FRIEND_ID", nullable = false)
    private Long friendId;

    public MyFriendEntityId(){

    }

    public MyFriendEntityId(Long userId, Long friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }
}
