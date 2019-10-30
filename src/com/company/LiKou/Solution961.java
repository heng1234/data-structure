package com.company.LiKou;

import java.util.TreeMap;

/**
 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 返回重复了 N 次的那个元素。
 示例 1：
 输入：[1,2,3,3]
 输出：3
 示例 2：
 输入：[2,1,2,5,3,2]
 输出：2
 示例 3：
 输入：[5,1,5,2,5,3,5,4]
 输出：5
 * @author heng
 * @date 2019/10/23
 **/
public class Solution961 {
    public int repeatedNTimes(int[] A) {
        TreeMap<Integer,Integer> map =new TreeMap<>();
        for (int a : A) {

            if (map.containsKey(a)){
                return a;
            }
            map.put(a,a);
        }
        return  0;
    }
}
