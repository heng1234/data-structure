package com.company.Map;

/**
 * LinkedListMap
 *
 * @author heng
 * @date 2019/10/17
 **/
public class LinkedListMap<K,V> implements Map<K,V> {

    /**
     * 内部类
     */
    private class Node{
        //存放数据
        public K k;
        public V v;
        //指向下一个节点
        public Node next;

        public Node(K k,V v,Node next){
            this.k = k;
            this.v = v;
            this.next = next;
        }
        public Node(K k){
                this(k,null,null);
        }
        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString(){
            return  k.toString()+":"+v.toString();
        }
    }


    private Node dummyHead;

    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }
    @Override
    public void add(K key, V value) {
    Node node = getNode(key);
    if(node == null){
        dummyHead.next = new Node(key,value,dummyHead.next);
        size ++;
    }else {
        //node.v = value;
        set(key,value);
    }

    }

    @Override
    public V remove(K key) {
        Node pre = dummyHead;
        while(pre.next != null){
            if(pre.next.k.equals(key))
                break;

            pre = pre.next;
        }
        if(pre.next != null){
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.v;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node cur = getNode(key);
        return cur==null?null:cur.v;
    }

    @Override
    public void set(K key, V newValue) {
     Node node = getNode(key);
     if (node == null){
         throw  new IllegalArgumentException(key+"dont's extis");
     }
     node.v = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key){
     Node cur = dummyHead.next;
     while (cur != null){
         if (cur.k.equals(key)){
             return cur;
         }
         cur = cur.next;
     }
     return null;
    }


}
