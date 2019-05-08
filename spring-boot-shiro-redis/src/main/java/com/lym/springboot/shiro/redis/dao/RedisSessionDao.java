package com.lym.springboot.shiro.redis.dao;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * 3. redis 实现 shiro session 共享
 */
@Component
public class RedisSessionDao extends EnterpriseCacheSessionDAO {

    /**
     * redis key 有效期
     */
    private static int expireTime = 1800;

    /**
     * redis key 前缀
     */
    private static String prefix = "shiro-session:";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 创建 Session, 并保存到 Redis 缓存中
     *
     * @param session
     * @return
     */
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.create(session);
        redisTemplate.opsForValue().set(prefix + sessionId.toString(), session);
        return sessionId;
    }

    /**
     * 根据 SessionId 获取 Session
     *
     * @param sessionId
     * @return
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = super.doReadSession(sessionId);
        if (session == null) {
            session = (Session) redisTemplate.opsForValue().get(prefix + sessionId.toString());
        }
        return session;
    }

    /**
     * 将 Session 更新到redis. 如果redis中不存在,则保存session到redis中;如果redis中存在,则更新有效期;
     *
     * @param session
     */
    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        String key = prefix + session.getId().toString();
        if (!redisTemplate.hasKey(key)) {
            redisTemplate.opsForValue().set(key, session);
        } else {
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        }
    }

    /**
     * 删除 session ,删除 redis 中缓存的Session
     *
     * @param session
     */
    @Override
    protected void doDelete(Session session) {
        super.doDelete(session);
        redisTemplate.delete(prefix + session.getId().toString());
    }
}
