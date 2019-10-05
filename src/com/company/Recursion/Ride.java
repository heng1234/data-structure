package com.company.Recursion;

/**
 * Ride
 * 传入一个输求它的乘积 阶乘
 * 比如传入一个100 求出1*2*3...*100的和
 * 用递归运算
 * @author heng
 * @date 2019/10/5
 **/
public class Ride {
    /**
     * 注意递归算法 方法本身调用本身
     * 1、递归必须要有出口return
     * 2、递归内存消耗大 容易发生内存溢出
     * 3、层次调用越多内存占用越大 越危险
     * @param num
     * @return
     */
    public  int sumRide(int num){
        if (num <=1){
            return 1;
        }
        return   num* sumRide(num-1);
    }

    public static void main(String[] args) {
        System.out.println(new Ride().sumRide(10));
    }
}
