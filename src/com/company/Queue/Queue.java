package com.company.Queue;

/**
 * Queue
 * 队列接口
 * @author heng
 **/
public interface Queue<E>{
    /**
     * 存入队列中
     * @param e
     */
    void enqueue(E e);

    /**
     * 从队列中取出一个元素  出队
     * @return
     */
    E dequeue();

    /**
     * 拿到队首
     * @return
     */
    E getFront();

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
