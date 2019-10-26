package com.company.MaxHeap;

import com.company.Array.Array;

/**
 * MaxHeap
 *
 * @author heng
 * @date 2019/10/24
 **/
public class MaxHeap<E extends Comparable<E>>   {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }
    public MaxHeap(){
        data = new Array<>();
    }

    //返回堆中有多少元素
    public int size(){
        return data.getSize();
    }
    //是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //是否存在
    public boolean contains(E e){
        return data.contains(e);
    }
//返回完全二叉树的数组表示中 一个所以所表示的元素的父亲节点的索引
    private int parent(int index){
        if (index == 0){
          throw new IllegalArgumentException("index-0 doesn't have parent");
        }
         return (index-1)/2;
    }

    //返回完全二叉树的数组表示中一个索引所表示元素左孩子的索引
    private int leftChild(int index){
        return index * 2+1;
    }
    //返回完全二叉树的数组表示中一个索引所表示元素右孩子的索引
    private int rightChild(int index){
        return index * 2+2;
    }

    //向对中添加元素
    public void add(E e){
        data.addLast(e);
        shiftUp(data.getSize()-1);
    }

    private void shiftUp(int k) {
        //k大于0 并且父亲元素和k元素要小的话就进行移位
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k))<0){
           //进行位置交换
            data.swap(k,parent(k));
            //k就等于k的父亲节点索引
            k = parent(k);
        }
    }

    //看一下堆中最大元素
    public E findMax(){
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }
    //取出堆中最大元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize()-1);//先把最大值也就是第一位和最后一位交换
        data.removeLast();//然后删除最后一位
        siftDown(0);//进行下沉操作不然会破坏规则
        return ret;
    }

    private void siftDown(int i) {
        //如果左孩子索引小于data的isze
        while (leftChild(i) < data.getSize()){
            //定义个变量 j等于左孩子索引
            int j = leftChild(i);
            //如果右孩子小于data的size的话
            if (j+1 < data.getSize() &&
                    //如果右孩子大于左孩子的话
            data.get(j+1).compareTo(data.get(j))>0){
                //j就是右孩子的索引
                j = rightChild(i);
                //data[j] 是leftChild和 rightChild 中的最大值
            }
            //如果当前i大于 j索引的话 结束
            if(data.get(i).compareTo(data.get(j))>0){
                break;
            }
            //如果没有break进行位置交换
            data.swap(i,j);
            //当前i等于j
            i=j;
        }
    }
}
