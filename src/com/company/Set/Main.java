package com.company.Set;

import java.util.ArrayList;

/**
 * Main
 *
 * @author heng
 * @date 2019/10/14
 **/
public class Main {

    public static void main(String[] args) {
        System.out.println("text.txt");
        /**
         * 不去重复
         */
        ArrayList<String> words = new ArrayList<>();
       boolean bol = FileOperation.readFile("H:\\gitdemo\\data-structure\\src\\com\\company\\Set\\text.txt",words);
       if(bol){
           System.out.println("ArrayList------"+words.size());


        /**
         * 去重复
         */
        BSTSet<String> bstSet = new BSTSet<>();
        words.forEach(str ->bstSet.add(str));
        System.out.println("Set------"+bstSet.getSize());
       }
    }

}
