package com.company.MaxHeap;

import com.company.Queue.Queue;

/**
 * PriorityQueue
 * 优先队列
 * @author heng
 * @date 2019/10/29
 **/
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

   private MaxHeap<E> maxHeap;

   public PriorityQueue(){
       maxHeap = new MaxHeap<>();
   }

    @Override
    public void enqueue(E e) {
     maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
    //是否存在
    public boolean contains(E e){
        return maxHeap.contains(e);
    }
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
