package com.company.LiKou;

/**
 * Solution
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @author heng
 * @date 2019/10/5
 **/
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
      while (head != null && head.val == val){
        //  ListNode delNode = head;
          head = head.next;
       //   delNode.next = null;
      }
      if (head == null){
          return  null;
      }
      ListNode prev = head;
      while (prev.next != null){
          if (prev.next.val == val){
             // ListNode delNode = prev.next;
              //prev.next = delNode.next;
              prev.next = prev.next.next;
             // delNode.next = null;
          }else {
              prev = prev.next;
          }
      }
      return  head;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,5,7,9,2,4,6,8,0};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        System.out.println(new Solution().removeElements(listNode, 3));

    }

}
