package com.company.LiKou;



import java.util.*;

/**
 * Solution347
 *给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 ** @author heng
 * @date 2019/10/29
 **/
public class Solution347_2 {

    private class Freq/* implements Comparable<Freq>*/{
        public int e,freq;
        public Freq(int e,int freq){
            this.e=e;//元素
            this.freq=freq;//频次
        }
      /*  @Override
        public int compareTo(Freq o) {
            if (this.freq > o.freq){
                return 1;
            } else if(this.freq < o.freq){
                return -1;
            }else {
                return 0;
            }
        }*/
    }
/* private class FreqComparator implements Comparator<Freq>{

     @Override
     public int compare(Freq o1, Freq o2) {
         return o1.freq-o2.freq;
     }
 }*/

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }

        }
        /**
         * java PriorityQueue内部是最小堆
         */
        /**
         * 定义自己的比较器 FreqComparator
         */
//        PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> map.get(a)-map.get(b));
        for (int key : map.keySet()) {
            if (pq.size()<k){//还没有存够k个元素
                pq.add(key);//add
            }else if(map.get(key) > map.get(pq.peek())){//如果当前key和队列队首的频次要高
                   pq.remove();//出队
                   pq.add(key);//入队
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()){
            res.add(pq.remove());
        }
        return res;
    }
}
