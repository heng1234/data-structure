package com.company.Map;

/**
 * Map
 * 映射集合
 * @author heng
 **/
public interface Map<K,V> {
    /**
     * 新增
     * @param key
     * @param value
     */
    void add(K key,V value);

    /**
     * 根据key删除
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 查看该key是否存在
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 根据key查询对应的value
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 根据key修改
     * @param set
     * @param newValue
     */
    void  set(K set,V newValue);

    /**
     * size
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
}
