package com.company.SegmentTree;


/**
 * SegmentTree
 * 线段树
 * @author heng
 * @date 2019/10/31
 **/
public class SegmentTree<E> {
    private E[] tree;//满二叉树
    private E[] data;
    private Merger<E> merger;
    public SegmentTree(E[] arr,Merger<E> merger){
        this.merger = merger;
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4*arr.length];//这里需要开4倍空间
        //创建线段树
        buildSegmentTree(0,0,data.length-1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l...r]的线段树
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex,int l,int r) {
       if(l == r){//如果是最后一个
           tree[treeIndex] = data[l];
           return;
       }
       int leftTreeIndex = leftChild(treeIndex);//拿到下标的左子节点
       int rightTreeIndex = rightChild(treeIndex);//右子节点
       int mid =l+ (r - l) / 2;
      buildSegmentTree(leftTreeIndex,l,mid);
      buildSegmentTree(rightTreeIndex,mid+1,r);
       tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]) ;
    }


    public int getSize(){
        return data.length;
    }
    /**
     * 拿到index 下标值
     * @param index
     * @return
     */
    public E get(int index){
        if(index<0 || index>=data.length){
            throw new IllegalArgumentException(("Index is Illegal..."));
        }
        return  data[index];
    }

    /**
     * 返回queryL到queryR区间的值
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL,int queryR){
        if(queryL<0 || queryL >= data.length ||
                queryR < 0 || queryR>= data.length
                ||queryL > queryR){
            throw new IllegalArgumentException("Index is Illegal.");
        }
        
        return query(0,0,data.length-1,queryL,queryR);
    }

    /**
     * 以treeId为跟的线段树[l...r]的范围里搜寻[queryL...queryR]的值
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex,int l,int r,int queryL,int queryR) {
      if (l == queryL && r == queryR){
          return tree[treeIndex];
      }
        int mid = l + (r-l)/2;
        int leftTreeIndex = leftChild(treeIndex);//拿到下标的左子节点
        int rightTreeIndex = rightChild(treeIndex);//右子节点
        if (queryL >= mid+1){
            return query(rightTreeIndex,mid+1,r,queryL,queryR);
        }else if(queryR <= mid) {
            return query(leftTreeIndex,l,mid,queryL,queryR);
        }else {
          E leftResult = query(leftTreeIndex,l,mid,queryL,mid);
          E rightResult = query(rightTreeIndex,mid+1,r,mid+1,queryR);
        return   merger.merge(leftResult,rightResult);
        }
    }
    //index位置更新为e
  public void set( int index,E e){
        if(index<0 || index>=data.length){
            throw new IllegalArgumentException("Index is Illegal.");
        }
        data[index] = e;
        set(0,0,data.length-1,index,e);
  }

  //在以treeIndex为根的线段树中跟新index的值为e
    private void set(int treeIndex,int l,int r ,int index,E e) {
         if(l==r){
             tree[treeIndex] = e;
             return;
         }
         int mid = l+(r-l)/2;
        int leftTreeIndex = leftChild(treeIndex);//拿到下标的左子节点
        int rightTreeIndex = rightChild(treeIndex);//右子节点
        if(index >= mid+1){
           set(rightTreeIndex,mid+1,r,index,e);
        }else if(index<=mid){
           set(leftTreeIndex,l,mid,index,e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    /**
     * 返回完全二叉树下标的左孩子
     * @param index
     * @return
     */
  private int leftChild(int index){
        return 2*index+1;
  }

    /**
     * 返回完全二叉树下标的右孩子
     * @param index
     * @return
     */
    private int rightChild(int index){
        return 2*index+2;
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i]!= null){
                builder.append(tree[i]);
            }else {
                builder.append("null");
            }
            if (i != tree.length-1){
                builder.append(",");
            }
        }
        return builder.toString();
    }
}
