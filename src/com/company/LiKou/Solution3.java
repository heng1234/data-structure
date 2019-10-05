package com.company.LiKou;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution3
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author heng
 * @date 2019/10/5
 **/
public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        int [] indexs = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                indexs[0] = map.get(nums[i]);
                indexs[1] = i;
            }
            map.put(target-nums[i],i);
        }
        return  indexs;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int [] nums = {1,2,3,4,5,6,7,8,9,10};
        for (int i : solution3.twoSum(nums, 19)) {
            System.out.println(i);
        }
    }
}
