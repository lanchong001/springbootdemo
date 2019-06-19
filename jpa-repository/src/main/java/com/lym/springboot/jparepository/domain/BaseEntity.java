package com.lym.springboot.jparepository.domain;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: in liuyuanming
 * @Description: 公共基类
 * @Date:Created in  2019/4/22/022 18:14
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String Id;

    @CreatedBy
    @Column(name = "creation_user", nullable = true)
    private String creationUser;

    @CreatedDate
    @Column(name = "creation_date", nullable = true)
    private Date creationDate;

    @LastModifiedBy
    @Column(name = "modification_user", nullable = true)
    private String modification_user;

    @LastModifiedDate
    @Column(name = "modification_date", nullable = true)
    private Date modificationDate;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getModification_user() {
        return modification_user;
    }

    public void setModification_user(String modification_user) {
        this.modification_user = modification_user;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
