package com.company.Set;

import com.company.BST.BST;

/**
 * BSTSet
 * 基于二分搜索树实现
 * @author heng
 * @date 2019/10/14
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public  BSTSet(){
        bst = new BST<>();
    }

    /**
     * add
     * @param e
     */
    @Override
    public void add(E e) {
         bst.add(e);
    }

    /**
     * remove
     * @param e
     */
    @Override
    public void remove(E e) {
      bst.remove(e);
    }

    @Override
    public boolean contauns(E e) {
        return bst.contains(e);
    }

    /**
     * size
     * @return
     */
    @Override
    public int getSize() {
        return bst.size();
    }

    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return bst.size() == 0;
    }
}
