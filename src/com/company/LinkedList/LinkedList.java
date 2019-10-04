package com.company.LinkedList;

/**
 * LinkedList
 *
 * @author heng
 * @date 2019/10/3
 **/
public class LinkedList<E> {
    /**
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
     * 链表的第一个数据
     * 虚拟头节点
     *虚拟头节点
     */
    private  Node dummyHead;

    /**
     * 大小
     */
    private int size;

    public LinkedList(){
        //初始化虚拟头节点
        dummyHead = new Node(null,null);
        size = 0;
    }

    //获取链表中的元素的个数
    public int getSize(){
        return size;
    }
    //链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //在链表头添加新的元素e
    public void addFirst(E e){
    //    Node node = new Node(e,null);
     //   node.next = head;
     //   head = node;
       /* dummyHead = new Node(e,dummyHead);
        size ++;*/
       add(0,e);
    }
    //在链表的index(0-based)位置添加新的元素e
    //在链表中不是一个常用的操作 练习用
    public void add(int index,E e){
        if (index < 0 || index > size){
            throw  new IllegalArgumentException("Add failed Illegal index.");
        }
//        if (index == 0){
//            addFirst(e);
//        }else {
            Node prev = dummyHead ;
            //拿到待插入的前一个
            //第一个是null 是一个虚拟的这里的index 其实是下标1才是0
            for (int i = 0; i < index; i++) {
                prev = prev.next;
           // }

         /*   Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;*/

        }
        prev.next = new Node(e,prev.next);
        size ++;
    }
    //在链表的末尾添加一个新的元素e
    public  void addLast(E e){
        add(size,e);
    }

    //获得链表的第index(0-based)个位置的元素
    //在链表中不是一个常用的操作 练习用
    public E get(int index){
        if (index < 0 || index > size){
            throw  new IllegalArgumentException("Get failed Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return  cur.e;
    }
    //获得链表第一个元素
    public E getFirst(){
        return get(0);
    }
    //获得链表最后一个元素
    public E getLast(){
        return get(size - 1);
    }
    //修改链表的第index(0-based)个位置的元素
    //在链表中不是一个常用的操作 练习用
   public void set(int index,E e){
       if (index < 0 || index > size){
           throw  new IllegalArgumentException("Set failed Illegal index.");
       }
       Node cur = dummyHead.next;
       for (int i = 0; i < index; i++) {
           cur = cur.next;
       }
       cur.e = e;
   }

   //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
       /* for (int i = 0; i < size - 1; i++) {
            if (cur.e.equals(e)){
                return  true;
            }
            cur = cur.next;
        }
        return false;*/
       while (cur != null){
           if (cur.e.equals(e)){
               return  true;
           }
           cur = cur.next;
       }
       return  false;
    }
    //删除链表的第index(0-based)个位置的元素
    //在链表中不是一个常用的操作 练习用
    public E reomve(int index){
        if (index < 0 || index > size){
            throw  new IllegalArgumentException("Reomve failed Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;

    }

    //链表中删除第一个元素
    public E removeFirst(){
        return  reomve(0);
    }
    //链表中删除最后一个元素
    public E removeLast(){
        return reomve(size - 1);
    }
    @Override
    public String toString(){
     StringBuilder res = new StringBuilder();
   //  Node cur = dummyHead.next;
//     while (cur != null){
//       res.append(cur+"->");
//       cur = cur.next;
//     }
        for (Node cur = dummyHead.next; cur != null ; cur = cur.next) {
            res.append(cur+"->");
        }
     res.append("NULL");
     return res.toString();
    }
}
