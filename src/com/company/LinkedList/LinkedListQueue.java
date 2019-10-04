package com.company.LinkedList;

import com.company.Queue.Queue;

/**
 * LinkedListQueue
 * 使用链表实现队列
 * @author heng
 * @date 2019/10/4
 **/
public class LinkedListQueue<E> implements Queue<E> {
    /**
     * 节点
     * 内部类
     */
    private class Node{
        //存放数据
        public E e;
        //指向下一个节点
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return  e.toString();
        }
    }

    /**
     * 头部
     */
    private Node head;

    /**
     * 尾部
     */
    private Node tail;

    /**
     * size
     */
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
     if(tail == null){
         tail = new Node(e);
         head = tail;
      }else {
         tail.next = new Node(e);
         tail = tail.next;
     }
     size ++;
    }

    /**
     * 出对
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()){
            throw  new IllegalArgumentException("Canneot dequeue an empty queue.");
        }
        Node reNode = head;
        head = head.next;
        reNode.next = null;
        if (head == null){
            tail = null;
        }
        size --;
        return reNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw  new IllegalArgumentException("Canneot dequeue an empty queue.");
        }
        return head.e;
    }

    /**
     * size
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front");
        for (Node cur = head; cur != null ; cur = cur.next) {
            res.append(cur+"->");
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
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
