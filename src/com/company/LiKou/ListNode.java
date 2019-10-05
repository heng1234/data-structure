package com.company.LiKou;

/**
 * ListNode
 * 203. 移除链表元素
 * @author heng
 * @date 2019/10/5
 **/
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    //链表节点的构造函数
    //使用arr作为参数创建一个链表 当前的listNode为链表的头节点
    ListNode(int[] arr){
        if (arr == null || arr.length <= 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
            this.val = arr[0];
            ListNode cur =this;
            for (int i = 1; i < arr.length; i++) {
                cur.next =new ListNode(arr[i]);
                cur = cur.next;
            }
      }
    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        ListNode listNode =this;
        res.append("CUR-->");
        while (listNode != null){
            res.append(listNode.val+"->");
            listNode = listNode.next;
        }
        res.append("--NULL");
        return res.toString();
    }
}
