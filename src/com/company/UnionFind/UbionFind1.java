package com.company.UnionFind;

/**
 * UbionFind1
 * 第一版并查集
 * @author heng
 * @date 2019/11/14
 **/
public class UbionFind1 implements UF {

    private int[] id;

    public UbionFind1(int size){
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 查找元素p的集合编号
     * @param p
     * @return
     */
    private  int find(int p){
        if(p< 0 || p>id.length){
            throw  new IllegalArgumentException("p is out of  bound. ");
        }
        return id[p];
    }

    /**
     * 查看p和q是否在一个集合
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
        int pid = find(p);
        int qid = find(q);
        if(pid == qid){
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pid){
                id[i] = qid;
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
