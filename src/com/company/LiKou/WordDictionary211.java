package com.company.LiKou;

import com.company.Trie.Trie;

import java.util.TreeMap;

/**
 * WordDictionary211
 *
 * @author heng
 * @date 2019/11/12
 **/
public class WordDictionary211 {
    private class Node{
        public boolean isWord;//标记是否找到单词
        public TreeMap<Character, Node> next;
        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary211() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){//如果这个字符为空
                cur.next.put(c,new Node());//创建并添加
            }
            cur=cur.next.get(c);//否则表示存在 当前cur=c这个cur
        }
            cur.isWord = true;

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
     return match(root,word,0);
    }

    private boolean match(Node node,String word,int index) {
       if(index == word.length()){
           return node.isWord;
       }
       char c = word.charAt(index);
       if(c != '.'){
           if(node.next.get(c) == null){
               return false;
           }
           return match(node.next.get(c),word,index+1);
       }else {
           for(char nextChar: node.next.keySet()){
               if(match(node.next.get(nextChar),word,index+1)){
                   return true;
               }

           }
           return false;
       }
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */