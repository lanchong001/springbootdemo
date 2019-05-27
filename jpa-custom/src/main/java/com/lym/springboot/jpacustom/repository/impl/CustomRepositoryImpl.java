package com.lym.springboot.jpacustom.repository.impl;

import com.lym.springboot.jpacustom.repository.CustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static com.lym.springboot.jpacustom.repository.CustomerSpecs.byAuto;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/27 14:58
 */
public class CustomRepositoryImpl<T, TD extends Serializable> extends SimpleJpaRepository<T, TD> implements CustomRepository<T, TD> {

    /**
     * 父类没有不带参数的构造方法，这里手动构造父类
     */
    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Page findByAuto(Object example, Pageable pageable) {
        return findAll((Specification<T>) byAuto(entityManager, example), pageable);
    }
}