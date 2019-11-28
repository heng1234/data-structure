package com.company.UnionFind;

/**
 * UbionFind6
 * 第五版并查集 路径压缩直接指向根节点
 * @author heng
 * @date 2019/11/14
 **/
public class UbionFind6 implements UF {
    //指向哪个节点
    private int[] parent;
    /**
     *  rank[i]表示以i为跟的集合所表示树的层数
     */

    private  int[] rank;
    public UbionFind6(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 查找元素p的集合编号
     * O(h)复杂度 h为数的高度
     * @param p
     * @return
     */
    private  int find(int p){
        if(p< 0 || p>=parent.length){
            throw  new IllegalArgumentException("p is out of  bound. ");
        }
        if (p != parent[p]){
             parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    /**
     * 查看p和q是否在一个集合
     * O(h)复杂度 h为数的高度
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q的集合
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }
        //根据2个元素的树的rank不同判断合并方向
        //将rank元素个数底的集合合并到rank高的集合上
        if(rank[pRoot] < rank[qRoot]){
           parent[pRoot] = qRoot;
        }else if(rank[qRoot]< rank[pRoot]){
            parent[qRoot] = pRoot;
        }else{
            parent[qRoot] = pRoot;
            rank[pRoot] +=1;
        }

    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
