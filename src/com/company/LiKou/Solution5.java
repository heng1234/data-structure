package com.company.LiKou;

/**
 * Solution
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author heng
 * @date 2019/10/5
 **/
public class Solution5 {
    public ListNode reverseList(ListNode head) {
        //1.第一个条件是判断递归开始，传入的参数的合法性。第二个是递归的终止条件
        if(head == null || head.next ==null) return head;
        //2.开始进行递归
        ListNode newHead = reverseList(head.next);
        //3.尾部2-3-null中，head=2,head.next=2-3 head.next.next=2-3-null,也就是3的后继指向2
        head.next.next = head;
        //4.断开之前2-3之间的连接，将2的后继指向null
        head.next = null;
        //5.返回已经反转的链表
        return newHead;
    }
  /**
  //Leetcode 24. 两两交换链表中的节点
   public ListNode swapPairs(ListNode head) {
        //终止条件：链表只剩一个节点或者没节点了，没得交换了。返回的是已经处理好的链表
        if(head == null || head.next == null){
            return head;
        }
        //一共三个节点:head, next, swapPairs(next.next)
        //下面的任务便是交换这3个节点中的前两个节点
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        //根据第二步：返回给上一级的是当前已经完成交换后，即处理好了的链表部分
        return next;
    }*/
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        ListNode listNode = new ListNode(arr);
       // System.out.println(listNode);
       System.out.println(new Solution5().reverseList(listNode));

    }
  public static String  stringBuldString(int path){
        StringBuilder res = new StringBuilder();
      for (int i = 0; i < path; i++) {
          res.append("-");
      }
      return res.toString();
  }
}
