package com.lym.springboot.jpacustom;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * The type Base repository.
 *
 * @param <T>  the type parameter
 * @param <TD> the type parameter
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in 2019/5/27 15:54
 */
public class BaseRepositoryImpl<T, TD extends Serializable> extends SimpleJpaRepository<T, TD> implements BaseRepository<T, TD> {

    /**
     * 父类没有不带参数的构造方法，这里手动构造父类
     */
    private final EntityManager entityManager;

    /**
     * Instantiates a new Base repository.
     *
     * @param domainClass   the domain class
     * @param entityManager the entity manager
     */
    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public List<T> findListByNativeSql(String sql, Class<T> clzss) {
        return entityManager.createNativeQuery(sql, clzss).getResultList();
    }
}
