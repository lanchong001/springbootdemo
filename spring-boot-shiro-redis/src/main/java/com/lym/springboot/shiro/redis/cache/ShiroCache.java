package com.lym.springboot.shiro.redis.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 4. 实现 shiro cache 接口, Shiro Cache 共享
 */
@SuppressWarnings("unchecked")
public class ShiroCache<K, V> implements Cache<K, V> {

    /**
     * redis key 前缀
     */
    private static String prefix = "shiro-session:";

    /**
     * Session 缓存 Redis Key
     */
    private String cacheKey;

    /**
     * redisTemplate 访问 Redis
     */
    private RedisTemplate<K, V> redisTemplate;

    /**
     * 有效期 30 分钟
     */
    private long expire = 30;

    @SuppressWarnings("rawtypes")
    public ShiroCache(String name, RedisTemplate client) {
        this.cacheKey = prefix + name + ":";
        this.redisTemplate = client;
    }


    /**
     * 根据 Key值后缀 获取Redis中对应的Session缓存值,并将原Redis缓存增加 expire 分钟有效期
     *
     * @param key Key值后缀
     * @return Session对象
     * @throws CacheException
     */
    @Override
    public V get(K key) throws CacheException {
        redisTemplate.boundValueOps(getCacheKey(key)).expire(expire, TimeUnit.MINUTES);
        return redisTemplate.boundValueOps(getCacheKey(key)).get();
    }

    /**
     * 根据 Key值后缀 获取Redis中对应的Session缓存值并返回,同时保存新的Session值
     *
     * @param key   Key值后缀
     * @param value 新的Session对象
     * @return 旧Session对象
     * @throws CacheException
     */
    @Override
    public V put(K key, V value) throws CacheException {
        V old = get(key);
        redisTemplate.boundValueOps(getCacheKey(key)).set(value);
        return old;
    }

    /**
     * 根据 Key值后缀 获取Redis中对应的Session缓存值并返回,同时删除Redis缓存中的Seesion
     *
     * @param key Key值后缀
     * @return 旧Session对象
     * @throws CacheException
     */
    @Override
    public V remove(K key) throws CacheException {
        V old = get(key);
        redisTemplate.delete(getCacheKey(key));
        return old;
    }

    /**
     * 清空所有Session缓存
     *
     * @throws CacheException
     */
    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());
    }

    /**
     * 获取所有Session缓存的总个数
     *
     * @return 总数
     */
    @Override
    public int size() {
        return keys().size();
    }

    /**
     * 获取所有保存在Redis中的Session的Key集合
     *
     * @return Key 集合
     */
    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    /**
     * 获取所有缓存在Redis中的Session对象集合
     *
     * @return
     */
    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<>();
        for (K s : set) {
            list.add(get(s));
        }
        return list;
    }

    /**
     * 根据 Key 前缀和 Key 值后缀 获取 Key
     *
     * @param object Key 值后缀
     * @return
     */
    private K getCacheKey(Object object) {
        return (K) (this.cacheKey + object);
    }
}
