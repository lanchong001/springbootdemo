package com.lym.springboot.jpacustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * The interface Base repository.
 *
 * @param <T>  the type parameter
 * @param <ID> the type parameter
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in 2019/5/27 15:53
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {


    /**
     * 使用原生sql 查询 list列表
     *
     * @param sql   the sql
     * @param clzss the clzss
     * @return the list
     */
    List<T> findListByNativeSql(String sql, Class<T> clzss);

}
