package com.company.Satck;

/**
 * Main
 * 栈的测试
 * @author heng
 * @date 2019/9/30
 **/
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 6; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
