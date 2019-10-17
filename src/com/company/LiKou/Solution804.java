package com.company.LiKou;

import java.util.TreeSet;

/**
 * Solution804
 * 莫斯密码
 * @author heng
 * @date 2019/10/16
 **/
public class Solution804 {


    public int uniqueMorseRepresentations(String [] words) {
        String [] wors = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> treeSet = new TreeSet<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(wors[word.charAt(i) - 'a']);
            }
            treeSet.add(res.toString());
        }
        return treeSet.size();
    }
}
