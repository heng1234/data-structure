package com.company.Queue;

/**
 * Main
 * 循环队列测试
 * @author heng
 * @date 2019/10/2
 **/
public class Main {

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 12; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i  == 5 || i == 7){
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}
