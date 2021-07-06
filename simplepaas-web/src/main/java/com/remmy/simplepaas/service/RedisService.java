package com.remmy.simplepaas.service;

import java.util.Map;

/**
 * @author yejiaxin
 */
public interface RedisService {
    /**
     * 保存属性
     *
     * @param key   属性key
     * @param value 属性value
     */
    void set(String key, Object value);

    /**
     * 保存属性
     *
     * @param key   属性key
     * @param value 属性value
     * @param time  有效时长
     */
    void set(String key, Object value, long time);

    /**
     * 删除属性
     *
     * @param key 属性key
     * @return 是否删除成功
     */
    boolean del(String key);

    /**
     * 获取属性
     *
     * @param key 属性key
     * @return 属性值
     */
    Object get(String key);

    /**
     * 在Hash结构放入一个属性
     *
     * @param key     hash结构的key
     * @param hashKey 属性key
     * @param value   属性值
     */
    void hSet(String key, Object hashKey, Object value);

    /**
     * 从Hash结构中删除一个属性
     *
     * @param key      hash结构的key
     * @param hashKeys 属性key列表
     */
    void hDel(String key, Object... hashKeys);

    /**
     * 获取整个Hash结构
     *
     * @param key hash结构的key
     * @return Hash所有属性
     */
    Map<Object, Object> hGetAll(String key);

    /**
     * 获取hash结构的属性
     *
     * @param key     hash结构的key
     * @param hashKey 属性key
     * @return 属性值
     */
    Object hGet(String key, Object hashKey);
}
