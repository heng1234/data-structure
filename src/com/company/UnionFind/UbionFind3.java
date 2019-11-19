package com.company.UnionFind;

/**
 * UbionFind3
 * 第三版并查集 优化size
 * @author heng
 * @date 2019/11/14
 **/
public class UbionFind3 implements UF {
    //指向哪个节点
    private int[] parent;
    /**
     *  sz[i]表示以i为跟的集合中元素的个数
     */

    private  int[] sz;
    public UbionFind3(int size){
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
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
        while (p != parent[p]){
            parent[p] = parent[parent[p]];
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
        //根据2个元素的树的元素个数不同判断合并方向
        //将元素个数少的集合合并到元素个数多的集合上
        if(sz[pRoot] < sz[qRoot]){
        parent[pRoot] = qRoot;
        sz[qRoot] += sz[pRoot];
        }else{// sz[qRoot]<= sz[pRoot]
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
