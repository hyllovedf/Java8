package com.df.dataStructure.linked.LeetCode.easy;

import com.df.dataStructure.linked.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 双指针 一个指针先走k步  然后同时走  先走的走到最后时  后走的指针就是需要的节点
 * @author hanyli
 * @date 2021/1/14
 */
public class KthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        ListNode pre = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            cur=cur.next;
            pre=pre.next;
        }
        return pre;
    }
}
