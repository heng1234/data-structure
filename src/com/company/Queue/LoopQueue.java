package com.company.Queue;


/**
 * LoopQueue
 * 循环队列的实现
 * 循环队列需要从底层写起 不再用Array类了
 * @author heng
 * @date 2019/10/2
 **/
public class LoopQueue<E> implements  Queue<E> {

    /**
     * 存储数组
     */
    private E[] data;

    /**
     * front指的是队首
     * tail指的是队列里的最后一个元素的下一个位置
     */
    private int front,tail;

    /**
     * 存在多少个元素
     */
    private int size;

    /**
     * 这里需要浪费一个空间  所以用户传入的大小需要+1
     * @param capacity
     */
    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue(){
        this(10);
    }

    /**
     * 返回数组大小
     * 因为浪费了一个所以需要-1
     * @return
     */
    public int getCapacity(){
        return  data.length - 1;
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
      if ((tail + 1) % data.length == front){
          resize(getCapacity() * 2);
      }
      data[tail] = e;
      tail = (tail + 1) % data.length;
      size++;
    }

    /**
     * 扩容
     * @param newCapatity
     */
    private void resize(int newCapatity) {
        E[] newData = (E[]) new Object[newCapatity+1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw  new IllegalArgumentException("Cannot dequeue from an empty.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        /**
         * 缩容
         */
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    /**
     * 拿到队首
     * @return
     */
    @Override
    public E getFront() {
        if(isEmpty()){
            throw  new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue: size = %d , capacaity = %d\n",size,getCapacity()));
        builder.append("front[ ");
        for (int i = front; i != tail; i=(i+1) % data.length) {
            builder.append(data[i]);
            if ((i+1)% data.length != tail){
                builder.append(" , ");
            }
        }
        builder.append(" ]tail");
        return builder.toString();
    }
}
