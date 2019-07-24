package com.lym.spring.boot.jpa.sqlite.service;

import com.lym.spring.boot.jpa.sqlite.domain.DatasourceLinkEntity;

import java.util.List;

public interface DatasourceLinkService {

    /**
     * 编辑数据库连接配置
     *
     * @param id
     */
    boolean edit(String id);

    /**
     * 保存数据库连接配置
     *
     * @param datasourceLinkEntity
     */
    boolean save(DatasourceLinkEntity datasourceLinkEntity);


    /**
     * 删除数据库连接配置
     *
     * @param id
     */
    boolean delete(String id);


    /**
     * 获取数据库连接配置
     *
     * @param datasourceLinkEntity
     * @return
     */
    List<DatasourceLinkEntity> getList(DatasourceLinkEntity datasourceLinkEntity, Integer page, Integer size);

}
