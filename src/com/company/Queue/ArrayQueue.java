package com.company.Queue;

import com.company.Array.Array;

/**
 * ArrayQueue
 * 队列的实现
 * @author heng
 * @date 2019/10/1
 **/
public class ArrayQueue<E> implements  Queue<E> {

    /**
     * 初始化容器
     */
   private Array<E> array;

    /**
     * 初始化大小
     * @param capacity
     */
    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    /**
     * 没有传入则默认大小
     */
    public ArrayQueue(){
        array = new Array<>();
    }
    /**
     * 存入队列中
     * @param e
     */
    @Override
    public void enqueue(E e) {
      array.addLast(e);
    }

    /**
     * 从队列中取出一个元素  出队
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }
    /**
     * 拿到队首
     * @return
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }
    /**
     * 大小
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }
    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 查看有多少容积
     * @return
     */
    public int getCapacity(){
        return  array.getCapacaity();
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Queue: front [");
        for (int i = 0; i < array.getSize(); i++) {
            builder.append(array.get(i));
            if (i != array.getSize()-1){
                builder.append(" , ");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2){
               queue.dequeue();
                System.out.println(queue);
            }
        }


    }
}
