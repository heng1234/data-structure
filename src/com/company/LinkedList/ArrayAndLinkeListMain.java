package com.company.LinkedList;

import com.company.Satck.ArrayStack;
import com.company.Satck.Stack;

import java.util.Random;

/**
 * ArrayAndLinkeListMain
 * 测试数组和链表实现的栈的性能
 * @author heng
 * @date 2019/10/4
 **/
public class ArrayAndLinkeListMain {
    //测试使用q运行opCount个enqueue和dequeue操作所需要的时间 单位:秒
    private static  double testQueue(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return  (endTime - startTime) / 1000000000.0;
    }

    /**
     * 316.577275898
     * 0.067320411
     * @param args
     */
    public static void main(String[] args) {
        //测试均摊时间

        int opCount = 10000000;
        ArrayStack<Integer> arrayStack =  new ArrayStack<>();
        LinkedListStack<Integer> listStack =  new LinkedListStack<>();
        double time1 =testQueue(arrayStack,opCount);
        double time2 =testQueue(listStack,opCount);
        System.out.println(time1);
        System.out.println(time2);
        //其实这个时间比较很复杂 因为LinkedListStack中包含更多new操作
    }
}
