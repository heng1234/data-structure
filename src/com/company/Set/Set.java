package com.company.Set;

/**
 * Set接口
 *
 * @author heng
 * @date 2019/10/14
 **/
public interface Set<E> {
    /**
     * 新增
     * @param e
     */
    void add(E e);

    /**
     * 删除
     * @param e
     */
    void remove(E e);

    /**
     * 是否包含e
     * @param e
     * @return
     */
    boolean contauns(E e);

    /**
     * 大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
}
