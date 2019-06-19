package com.lym.springboot.jparepository.domain;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/28 17:29
 */
@Entity
@Table(name = "tb_face_lib")
@DynamicUpdate
public class FaceLib extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "face_encoding", nullable = true)
    private String faceEncoding;

    @Column(name = "img_url", nullable = true)
    private String imgUrl;

    @Column(name = "status", nullable = true)
    private int status ;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFaceEncoding() {
        return faceEncoding;
    }

    public void setFaceEncoding(String faceEncoding) {
        this.faceEncoding = faceEncoding;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
