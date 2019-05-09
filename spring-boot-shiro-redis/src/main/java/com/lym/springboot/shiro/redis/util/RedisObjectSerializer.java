package com.lym.springboot.shiro.redis.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * 1. redis 序列化对象
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

    /**
     * 序列化转换器
     */
    private Converter<Object, byte[]> serializer = new SerializingConverter();

    /**
     * 反序列化转换器
     */
    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    /**
     * 0 字节数据
     */
    static final byte[] emptyArray = new byte[0];

    /**
     * 对象 转 二进制字节数组， 序列化
     * @param object
     * @return
     * @throws SerializationException
     */
    @Override
    public byte[] serialize(Object object) throws SerializationException {
        if (object == null) {
            return emptyArray;
        }
        try {
            return serializer.convert(object);
        } catch (Exception ex) {
            return emptyArray;
        }
    }

    /**
     * 二进制字节数据 转 对象 , 反序列化
     * @param bytes
     * @return
     * @throws SerializationException
     */
    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes)) {
            return null;
        }
        try {
            return deserializer.convert(bytes);
        } catch (Exception ex) {
            throw new SerializationException("Can't Deserializer", ex);
        }
    }

    /**
     * 字节数据 空判断
     * @param data
     * @return
     */
    private boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }
}
