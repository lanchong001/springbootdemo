package com.lym.springboot.shiro.redis.config;

import com.lym.springboot.shiro.redis.cache.ShiroCache;
import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * 5.实现 shiro cache Manager 接口
 * https://www.cnblogs.com/nbfujx/p/7773833.html
 */
public class RedisCacheManager extends AbstractCacheManager {

    /**
     * 注入 redisTemplate 对象
     */
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 创建 Shiro Cache
     *
     * @param name
     * @return
     * @throws CacheException
     */
    @Override
    protected Cache<String, Object> createCache(String name) throws CacheException {
        return new ShiroCache<>(name, redisTemplate);
    }
}
