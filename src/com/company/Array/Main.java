package com.company.Array;

import com.company.Array.Array;

/**
 * 声明数组
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        array.addLast(11);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(1);
        array.addLast(1);
        array.addLast(1);
        array.addLast(1);
        array.addLast(9);
        System.out.println(array);

        array.add(6,99);
        array.addFirst(0);
        System.out.println(array);
        array.romoveElementAll(1);
        System.out.println(array);


    }
}
