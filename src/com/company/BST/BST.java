package com.company.BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BST
 * 二分搜索树
 * 二分搜索树并不支持所有类型
 * 因为要有可比较性所有要这样写 <E extends Comparable<E>>
 * @author heng
 * @date 2019/10/7
 **/
public class BST<E extends Comparable<E>> {

    /**
     * 节点类
     */
    private class Node{
        //存放的值
        public E e;
        /**
         * left表示左孩子 right表示右孩子
         */
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * 根节点
     */
    private Node root;

    /**
     * 元素的size
     */
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    /**
     * 存放的大小
     * @return
     */
    public int size(){
        return  size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * 向二分搜索树中添加新的元素e
     */
    public void add(E e){
        //根节点为空
//        if (root == null){
//            //直接指向根节点
//            root = new Node(e);
//            size++;
//        }else {
            //从根节点添加新的元素
           root =  add(root,e);
       // }
    }

    /**
     * 向以node为根的二分搜索树中插入e 递归算法
     * 返回插入新节点后二分搜索树的根
     */
     private Node add(Node node,E e){
         //如果要插入的e跟node相同表示存在直接返回return
//         if(e.equals(node.e)){
////             return;
////         }else if (e.compareTo(node.e)<0 && node.left == null){
////             //如果e比node的e要小放入左子树
////             //compareTo如果参数字符串等于此字符串，则返回值 0；
////             //compareTo如果此字符串小于字符串参数，则返回一个小于 0 的值；
////             //compareTo如果此字符串大于字符串参数，则返回一个大于 0 的值。
////             node.left = new Node(e);
////             size ++;
////             return;
////         } else if (e.compareTo(node.e)>0 && node.right == null){
////             //如果e比node的e要大放入右子树
////             node.right = new Node(e);
////             size ++;
////             return;
////         }
         if (node == null){
             size ++;
            return new Node(e);
         }
         if (e.compareTo(node.e) < 0){
             //向左子树插入
            node.left = add(node.left,e);
         } else if(e.compareTo(node.e) > 0) { // e.compareTo(node.e) > 0
            //向有子树插入
             node.right = add(node.right,e);
         }
         return  node;
     }
     //查看是否包含元素e
     public boolean contains(E e){
          return contains(root,e);
     }
     //看以node为根的二分搜索树中是否包含元素e
     private boolean contains(Node node,E e){
         if (node == null){
             return  false;
         }
         if (e.compareTo(node.e) == 0){//如果相同
             return true;
         } else if(e.compareTo(node.e) < 0){//如果小于
             contains(node.left,e);
         }else {//e.compareTo(node.e) > 0 //如果大于
             contains(node.right,e);
         }
         return  false;
     }
     //二分搜索树前序遍历
     public void preOrder(){
         preOrder(root);
     }
     //前序遍历以node为根的二分搜索树 递归算法
     private void preOrder(Node node){
       /*  if(node == null) {
             return;
         }*/
       if (node != null) {
           System.out.println(node.e);
           preOrder(node.left);
           preOrder(node.right);
       }
     }
     //二分搜索树非递归 使用栈
     public void preOrderNR(){
         Stack<Node> stack = new Stack<>();
         stack.push(root);
         while (!stack.isEmpty()){
             Node cur = stack.pop();
             System.out.println(cur.e);
             if (cur.right != null)
             stack.push(cur.right);
             if (cur.left != null)
                 stack.push(cur.left);
         }
     }
     //二分搜索树的层次遍历 使用队列
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }
 //生成以node为根节点 深度为depth的描述二叉树的字符串
     private void generateBSTString(Node node , int depth,StringBuilder builder){
         if (node == null){
             builder.append(generateDepthString(depth)+"null\n");
             return;
         }
         builder.append(generateDepthString(depth)+node.e+"\n");
         generateBSTString(node.left,depth+1,builder);
         generateBSTString(node.right,depth+1,builder);
     }
     private String generateDepthString(int depth){
         StringBuilder builder = new StringBuilder();
         for (int i = 0; i < depth; i++) {
             builder.append("--");
         }
         return builder.toString();
     }
     //中序遍历
     public void inOrder(){
         inOrder(root);
     }
    //中序遍历 递归
     private void inOrder(Node node){
         if (node != null){
             inOrder(node.left);
             System.out.println(node.e);
             inOrder(node.right);
         }
     }
    //后续遍历
    public void postOrder(){
        postOrder(root);
    }
    //后续遍历
    private void postOrder(Node node){
        if (node != null){
            inOrder(node.left);
            inOrder(node.right);
            System.out.println(node.e);

        }
    }

    /**
     * 拿到二分搜索树的最小值
     * 递归
     * @return
     */
    public E mininum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return mininum(root).e;
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
     * 拿到二分搜索树的最大值
     * 递归
     * @return
     */
    public E maxnum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maxnum(root).e;
    }
    /**
     * 拿到二分搜索树的最大值
     * 递归
     * @return
     */
    private Node maxnum(Node node){
        if(node.right == null){
            return node;
        }
        return maxnum(node.right);
    }

    /**
     * 拿到二分搜索树的最大值
     * 非递归
     * @return
     */
    public E getMaxVal(){
       return getMaxVal(root);
    }
    /**
     * 拿到二分搜索树的最大值
     * 非递归
     * @return
     */
    private E getMaxVal(Node node){
        Node cur = node.right;
        while (cur != null){
            if(cur.right == null){
                return cur.e;
            }
            cur = cur.right;
        }
        return node.e;
    }

    /**
     * 拿到二分搜索树的最小值
     * 非递归
     * @return
     */
    public E getMinVal(){
        if (root == null) {
          return  null;
        }
        return getMinVal(root);
    }

    /**
     * 拿到二分搜索树的最小值
     * 非递归
     * @param node
     * @return
     */
    private E getMinVal(Node node){
            Node cur = node.left;
          while (cur != null){
              if(cur.left == null){
                  return cur.e;
              }
              cur = cur.left;
          }
        return node.e;

    }

    /**
     * 二分搜索树递归删除最小值
     * @return
     */
    public E removeMin(){
        E ret = mininum();
        root =removeMin(root);
        return ret;
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

    /**
     * 二分搜索树递归删除最大值
     * @return
     */
    public E removeMax(){
        E ret = maxnum();
        root =removeMax(root);
        return ret;
    }
    /**
     * 删除以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        if (node.right == null){
            //因为node.right ==null说明没有右子节点了
            //可能还要存在左子节点需要把
            //左子节点变为要删除的位置也就是右子节点
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     * @param e
     */
    public void remove(E e){
        root = remove(root,e);
    }
    //删除以node为根的二分搜索树中值为e的节点
    //返回删除节点后新的二分搜索树
    private Node remove(Node node,E e){
      if(node == null){
          return null;
      }
      if (e.compareTo(node.e)< 0){
         node.left = remove(node.left,e);
         return node;
      }else if(e.compareTo(node.e)>0){
          node.left = remove(node.right,e);
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
              successor .right = removeMin(node.right);
              //   size++;
              successor.left = node.left;
              node.left = node.right = null;
              //   size -- ;
              return successor;
          }
      }
    }

     @Override
    public String toString(){
         StringBuilder builder = new StringBuilder();
         generateBSTString(root,0,builder);
         return builder.toString();
     }
}
