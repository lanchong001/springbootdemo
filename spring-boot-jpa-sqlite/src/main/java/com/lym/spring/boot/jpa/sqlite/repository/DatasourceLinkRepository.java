package com.lym.spring.boot.jpa.sqlite.repository;

import com.lym.spring.boot.jpa.sqlite.domain.DatasourceLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chenbingkun on 2019/5/24.
 */
@Repository
public interface DatasourceLinkRepository extends JpaRepository<DatasourceLinkEntity, String> {

    /**
     * @param status
     * @param type
     * @return
     */
    List<DatasourceLinkEntity> findByStatusAndType(Integer status, String type);

    /**
     * @param id 主键Id
     * @return 更新结果
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update DatasourceLinkEntity d set d.status=0 where d.id=:id")
    int remove(@Param("id") String id);
}
