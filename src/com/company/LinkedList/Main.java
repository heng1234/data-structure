package com.company.LinkedList;

import com.company.Array.Array;

/**
 * Main
 * 链表测试
 * @author heng
 * @date 2019/10/3
 **/
public class Main {
    public static void main(String[] args) {
      LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);
        linkedList.reomve(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);


    }
}
