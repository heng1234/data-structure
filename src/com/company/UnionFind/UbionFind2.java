package com.company.UnionFind;

/**
 * UbionFind2
 * 第二版并查集
 * @author heng
 * @date 2019/11/14
 **/
public class UbionFind2 implements UF {

    private int[] parent;//指向哪个节点

    public UbionFind2(int size){
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    /**
     * 查找元素p的集合编号
     * O(h)复杂度 h为数的高度
     * @param p
     * @return
     */
    private  int find(int p){
        if(p< 0 || p>parent.length){
            throw  new IllegalArgumentException("p is out of  bound. ");
        }
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
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
        parent[pRoot] = parent[qRoot];
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
