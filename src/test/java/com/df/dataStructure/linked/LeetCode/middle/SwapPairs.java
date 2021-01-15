package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author hanyli
 * @date 2021/1/15
 */
public class SwapPairs {
    /**
     * 递归 每次处理前两个节点 返回新头节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode newhead = sen;
        ListNode pre = head;
        ListNode cur = head.next;
        while (pre != null && cur != null) {
            pre.next = cur.next;
            cur.next = pre;
            newhead.next = cur;
            newhead = pre;
            pre = pre.next;
            if (pre != null) {
                cur = pre.next;
            }
        }
        return sen.next;
    }

    public static void main(String[] args) {
        ListNode listNode = LinkedUtil.create(new int[]{1, 2, 3, 4});
        SwapPairs swapPairs = new SwapPairs();
        swapPairs.swapPairs2(listNode);
    }
}
