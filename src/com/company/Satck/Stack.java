package com.company.Satck;

/**
 * Stack
 * 栈的接口
 * @author heng
 **/
public interface Stack<E> {

    /**
     * 拿到栈的大小
     * @return
     */
    int getSize();

    /**
     * 是否存在数据
     * @return
     */
    boolean isEmpty();

    /**
     * 添加数据到栈
     * @param e
     */
    void push (E e);

    /**
     * 拿到栈顶数据
     * @return
     */
    E pop();

    /**
     * 查看栈顶数据
     * @return
     */
    E peek();

}
