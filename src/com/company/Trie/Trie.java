package com.company.Trie;

import java.util.TreeMap;

/**
 * Trie
 * 字典树
 * @author heng
 * @date 2019/11/7
 **/
public class Trie {
    private class Node{
        public boolean isWord;//标记是否找到单词
        public TreeMap<Character,Node> next;
        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }
    //获取Trie中存储的单词数量
    public int getSize(){
        return size;
    }
    //向Trie中添加一个新的单词
    public void add(String word){
     Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){//如果这个字符为空
                cur.next.put(c,new Node());//创建并添加
            }
            cur=cur.next.get(c);//否则表示存在 当前cur=c这个cur
        }
        if(!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }
/**
 * 查询单词word是否在Trie中
 */
public boolean contains(String  word){
    Node cur = root;
    for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if(cur.next.get(c) == null){
            return false;
        }
        cur = cur.next.get(c);
    }
    return cur.isWord;
}
    /**
     * 递归写法未测试
     * @param word
     */
    public void addN(String word){
        addN(0,word,root);
    }
    private Node addN(int i,String word,Node cur){
        if(i == word.length()-1){
            size++;
            return cur.next.put(word.charAt(i),new Node());
        }
        cur = addN (i+1,word,cur);
        return cur;
    }
}
