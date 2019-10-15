package com.company.Set;

import com.company.LinkedList.LinkedList;

import java.util.ArrayList;

/**
 * LinkedListSet
 * 基于链表实现set集合
 * @author heng
 * @date 2019/10/15
 **/
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public  LinkedListSet(){
        linkedList = new LinkedList<>();
    }

    /**
     * 新增
     * @param e
     */
    @Override
    public void add(E e) {
        if (!contauns(e))
           linkedList.addFirst(e);
    }

    /**
     * remove
     * @param e
     */
    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    /**
     * 是否存在
     * @param e
     * @return
     */
    @Override
    public boolean contauns(E e) {
        return linkedList.contains(e);
    }

    /**
     * set集合大小
     * @return
     */
    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println("text.txt");
        /**
         * 不去重复
         */
        ArrayList<String> words = new ArrayList<>();
        boolean bol = FileOperation.readFile("H:\\gitdemo\\data-structure\\src\\com\\company\\Set\\text.txt",words);
        if(bol){
            System.out.println("ArrayList------"+words.size());


            /**
             * 去重复
             */
            LinkedListSet<String> linkedListSet = new LinkedListSet<>();
            words.forEach(str ->linkedListSet.add(str));
            System.out.println("Set------"+linkedListSet.getSize());
        }
    }

}
