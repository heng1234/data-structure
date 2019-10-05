package com.company.Recursion;

/**
 * Sum
 * 递归求和
 * @author heng
 * @date 2019/10/5
 **/
public class Sum {

    public static  int sum(int[] arr){

        return sum(arr,0);
    }

    /**
     * 计算arr[l...n]这个区间内所有数字的和
     * @param arr
     * @param l
     * @return
     */
    private static  int sum(int[] arr,int l){
     if (l == arr.length) {
         return 0;
     }
     return arr[l]+sum(arr,l+1);
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7,8,9,10,6,6,6};
        System.out.println(sum(nums));
    }
}
