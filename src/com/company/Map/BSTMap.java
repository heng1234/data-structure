package com.company.Map;

import com.company.Set.FileOperation;

import java.util.ArrayList;

/**
 * BSTMap
 *
 * @author heng
 * @date 2019/10/22
 **/
public class BSTMap<K extends Comparable<K>,V> implements  Map<K,V> {
    /**
     * 内部类
     */
    private class Node{
        //存放数据
        public K k;
        public V v;
        //
        public Node left,right;

        public Node(K k,V v){
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString(){
            return  k.toString()+":"+v.toString();
        }
    }
    private Node root;

    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root =  add(root,key,value);
    }
    /**
     * 向以node为根的二分搜索树中插入k v 递归算法
     * 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node,K k ,V v){
        //如果要插入的e跟node相同表示存在直接返回return

        if (node == null){
            size ++;
            return new Node(k,v);
        }
        if (k.compareTo(node.k) < 0){
            //向左子树插入
            node.left = add(node.left,k,v);
        } else if(k.compareTo(node.k) > 0) { // e.compareTo(node.e) > 0
            //向有子树插入
            node.right = add(node.right,k,v);
        }else {// k.compareTo(node.k) == 0
            node.v = v;
        }
        return  node;
    }
    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if (node != null){
            root = remove(root,key);
            return node.v;
        }
        return  null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node == null?null:node.v;
    }
    //返回以node为根节点的二分搜索树中 key所在的节点
  private Node getNode(Node node,K k){
        if (node == null){
            return  null;
        }
        if(k.compareTo(node.k) == 0){
            return  node;
        }else if (k.compareTo(node.k) < 0){
            return  getNode(node.left,k);
        }else {//k.compareTo(node.k) > 0
            return  getNode(node.right,k);
        }

  }
    @Override
    public void set(K set, V newValue) {
    Node node = getNode(root,set);
        if (node == null){
            throw  new IllegalArgumentException(set+" doesn's exist!");
        }
        node.v = newValue;
    }
    /**
     * 拿到二分搜索树的最小值
     * 递归
     * @return
     */
    private Node mininum(Node node){
        if(node.left == null){
            return node;
        }
        return mininum(node.left);
    }
    /**
     * 删除以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if (node.left == null){
            //因为node.left ==null说明没有左子节点了
            //可能还要存在右子节点需要把
            //右子节点变为要删除的位置也就是左子节点
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    //删除以node为根的二分搜索树中值为key的节点
    //返回删除节点后新的二分搜索树
    private Node remove(Node node,K key){
        if(node == null){
            return null;
        }
        if (key.compareTo(node.k)< 0){
            node.left = remove(node.left,key);
            return node;
        }else if(key.compareTo(node.k)>0){
            node.right = remove(node.right,key);
            return node;
        }else { //e == node.e
            //开始删除
            //左子树为空
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
                //右子树为空
            }else if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }else {
                /**
                 * 待删除节点左右子树均不为空的情况
                 * 找到比待删除节点大的最小节点 即待删除节点右子树的最小节点
                 * 用这个节点顶替待删除节点的位置
                 */
                Node successor = mininum(node.right);
                successor.right = removeMin(node.right);
                //   size++;
                successor.left = node.left;
                node.left = node.right = null;
                //   size -- ;
                return successor;
            }
        }
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        System.out.println("text.txt");
        /**
         * 不去重复
         */
        ArrayList<String> words = new ArrayList<>();
        boolean bol = FileOperation.readFile("H:\\gitdemo\\data-structure\\src\\com\\company\\Set\\text.txt", words);
        if (bol) {
            System.out.println("ArrayList------" + words.size());

            BSTMap<String,Integer> str = new BSTMap<>();
            for (String word : words) {
                if(str.contains(word)){
                    str.set(word,str.get(word)+1);
                }else{
                    str.add(word,1);
                }
            }

            System.out.println(str.getSize());
            System.out.println("all" + str.get("all"));
        }
    }
}
