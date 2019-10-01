package com.company.Satck;
import  java.util.Stack;
/**
 * 这里先使用java util提供的Satck
 * Solution
 * https://leetcode-cn.com题号为20题的案例
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * @author heng
 * @date 2019/10/1
 **/
public class Solution {
    public boolean isValid(String s) {
     Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
            /**
             * 如果是左括号的话则存入栈中
             */
            if (c == '(' || c == '[' || c == '{' ) {
                 stack.push(c);
             }else {
                /**
                 * 否则进行括号的匹配
                 */
                if (stack.isEmpty()){
                    return  false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '('){
                    return  false;
                }
                if (c == ']' && topChar != '['){
                    return  false;
                }
                if (c == '}' && topChar != '{'){
                    return  false;
                }

            }

        }
        /**
         * 如果还有值也是匹配失败
         */
        return stack.isEmpty();
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        //true
        System.out.println(solution.isValid("{()[]}"));
        //false
        System.out.println(solution.isValid("{([})[]}"));

    }
}
