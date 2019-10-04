package com.company.Queue;

import com.company.LinkedList.LinkedListQueue;

import java.util.Random;

/**
 * Main
 * 循环队列测试
 * @author heng
 * @date 2019/10/2
 **/
public class Main {
    //测试使用q运行opCount个enqueue和dequeue操作所需要的时间 单位:秒
  private static  double testQueue(Queue<Integer> q,int opCount){
      long startTime = System.nanoTime();
      Random random = new Random();
      for (int i = 0; i < opCount; i++) {
        q.enqueue(random.nextInt(Integer.MAX_VALUE));
      }
      for (int i = 0; i < opCount; i++) {
          q.dequeue();
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
     /*   LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 12; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i  == 5 || i == 7){
                queue.dequeue();
                System.out.println(queue);
            }
        }*/

     //测试均摊时间

        int opCount = 1000000;
      //  ArrayQueue<Integer> arrayQueue =  new ArrayQueue<Integer>();
        LoopQueue<Integer> loopQueue =  new LoopQueue<Integer>();
        LinkedListQueue<Integer> linkedListQueue =  new LinkedListQueue<>();
      //  double time1 =testQueue(arrayQueue,opCount);
        double time2 =testQueue(loopQueue,opCount);
        double time3 =testQueue(linkedListQueue,opCount);
        //System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
    }
}
