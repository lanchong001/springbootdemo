package com.lym.springboot.cach.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/4/18/018 19:39
 */
@Service
public class CacheService {

    private static final Logger logger = LoggerFactory.getLogger(CacheService.class);

    private final Map<String, String> mpas = new HashMap<>();

    public CacheService() {
        mpas.put("1", " no 1");
    }

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(cacheNames = "cache")
    public String get(String id) {
        // 记录数据产生的时间，用于测试对比
        long time = System.currentTimeMillis();

        // 打印使用到的cacheManager
        logger.info("The cacheManager is" + cacheManager);

        // 当数据不是从cache里面获取时，打印日志
        logger.info("Get value by id=" + id + ", The time is " + time);

        return "Get value by id=" + id + ",the value is" + mpas.get(id);
    }

    @CacheEvict(cacheNames = "cache")
    public String delete(String id) {
        return mpas.remove(id);
    }

    @CachePut(cacheNames = "cache")
    public String save(String id, String value) {
        logger.info("save value " + value + " with key " + id);
        mpas.put(id, value);
        return value;
    }

    @CachePut(cacheNames = "cache")
    public String update(String id, String value) {
        return mpas.put(id, value);
    }

}
