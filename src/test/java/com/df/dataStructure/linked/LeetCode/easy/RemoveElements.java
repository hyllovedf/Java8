package com.df.dataStructure.linked.LeetCode.easy;

import com.df.dataStructure.linked.ListNode;

/**
 * 203. 移除链表元素
 *
 * @author hanyli
 * @date 2021/1/14
 */
public class RemoveElements {
    /**
     * 1.直接处理  需要对头节点单独处理
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {

            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }
        return head;
    }

    /**
     * 2.设置前置哨兵节点  处理逻辑可以统一
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode cur = sen;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return sen.next;
    }
}
