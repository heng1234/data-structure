package com.company.LiKou;

import com.company.SegmentTree.Merger;
import com.company.SegmentTree.SegmentTree;

/**
 * NumArray303
 *给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * @author heng
 * @date 2019/11/5
 **/
public class NumArray303_2 {

    private int[] sum;//sum[i]存储的就是前i个元素的和 sum[0] = 0

    public NumArray303_2(int[] nums) {
        sum = new int[nums.length+1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i]+nums[i];
        }

    }

    public int sumRange(int i, int j) {
       return sum[j] - sum[i+1];
    }




}
