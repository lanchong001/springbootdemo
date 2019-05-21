package com.lym.springboot.shardingjdbc.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/21 16:13
 */
@Entity
@Table(name = "MY_FRIEND")
public class MyFriendEntity implements Serializable {

    private static final long serialVersionUID = -952799334936333550L;

    @EmbeddedId
    private MyFriendEntityId myFriendId;

    @Column(name = "REMARK", length = 16)
    private String remark;

    @Column(name = "ADD_DATE", nullable = false, columnDefinition = " datetime default now() ")
    private LocalDateTime addDate;

    public MyFriendEntityId getMyFriendId() {
        return myFriendId;
    }

    public void setMyFriendId(MyFriendEntityId myFriendId) {
        this.myFriendId = myFriendId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
    }
}