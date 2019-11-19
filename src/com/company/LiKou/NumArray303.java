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
public class NumArray303 {

    private SegmentTree<Integer> segmentTree;

    public NumArray303(int[] nums) {

        if (nums.length > 0) {
            Integer[] data=new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }

            segmentTree = new SegmentTree<Integer>(data, new Merger<Integer>() {
                @Override
                public Integer merge(Integer a, Integer b) {
                    return a + b;
                }
            });

        }
    }

    public int sumRange(int i, int j) {
      if(segmentTree == null){
          throw new IllegalArgumentException("Segment tree is null.");
      }
    return   segmentTree.query(i,j);
    }
}
