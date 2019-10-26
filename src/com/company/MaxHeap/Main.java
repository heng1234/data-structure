package com.company.MaxHeap;

import java.util.Random;

/**
 * Main
 * 堆测试
 * @author heng
 * @date 2019/10/26
 **/
public class Main {

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int j = 1; j < arr.length; j++) {
            if(arr[j-1] < arr[j]){
                throw new IllegalArgumentException("error");
            }

        }
        System.out.println("Test MaxHeap completed.");
    }
}
