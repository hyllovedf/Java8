package com.df.dataStructure.linked.LeetCode.easy;

import com.df.dataStructure.linked.ListNode;

/**
 * 206. 反转链表
 *
 * @author hanyli
 * @date 2021/1/14
 */
public class ReverseList {
    /**
     * 双指针法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return reverseList2(null, head);
    }

    private ListNode reverseList2(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
        return reverseList2(pre, cur);
    }
}
