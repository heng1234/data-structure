package com.company.UnionFind;

/**
 * UF
 * 并查集接口
 * @author heng
 **/
public interface UF {

    /**
     * 是否连接点
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p,int q);

    /**
     * 合并
     * @param p
     * @param q
     */
    void unionElements(int p,int q);

    int getSize();
}
