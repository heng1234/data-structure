package com.company.LiKou;

/**
 * Solution
 * 203. 移除链表元素
 * 使用递归解决
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @author heng
 * @date 2019/10/5
 **/
public class Solution4 {
    public ListNode removeElements(ListNode head, int val) {
     if (head == null){
         return  null;
     }
    head.next = removeElements(head.next,val);
     if (head.val == val){
         return head.next;
     }else {
         return  head;
     }
     }


    public static void main(String[] args) {
        int [] arr = {1,3,3,7,3,9,2,4,6,8,0};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        System.out.println(new Solution4().removeElements(listNode, 3));

    }

}
