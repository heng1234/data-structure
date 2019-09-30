package com.company.Satck;

import com.company.Array.Array;

/**
 * ArrayStack
 * 栈的实现
 * @author heng
 * @date 2019/9/30
 **/
public class ArrayStack<E> implements Stack<E> {

    /**
     * 初始化容器
     */
    Array<E> array;

    /**
     * 初始化大小
     * @param capacity
     */
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    /**
     * 没有传入则默认大小
     */
    public ArrayStack(){
        array = new Array<>();
    }
    /**
     * 拿到栈的大小
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }
    /**
     * 是否存在数据
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
    /**
     * 添加数据到栈
     * @param e
     */
    @Override
    public void push(E e) {
     array.addLast(e);
    }
    /**
     * 拿到栈顶数据
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }
    /**
     * 查看栈顶数据
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 查看用户有多少容积
     * @return
     */
    public int getCapacity(){
     return  array.getCapacaity();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            builder.append(array.get(i));
            if (i != array.getSize()-1){
                builder.append(" , ");
            }
        }
        builder.append("] top");
        return builder.toString();
    }
}
