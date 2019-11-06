package com.company.SegmentTree;

/**
 * Main
 *
 * @author heng
 * @date 2019/11/4
 **/
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2,0,3,-5,2,-1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a+b;
            }
        });
        System.err.println(segmentTree);
    }
}
