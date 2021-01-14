package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * @author hanyli
 * @date 2021/1/14
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode cur = head;
        ListNode pre = sen;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return sen.next;
    }
}
