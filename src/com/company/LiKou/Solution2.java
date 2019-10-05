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
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next=head;

      ListNode prev = dummyHead;
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
      return  dummyHead.next;
    }
}
