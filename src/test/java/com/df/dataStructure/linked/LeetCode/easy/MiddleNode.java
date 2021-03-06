package com.df.dataStructure.linked.LeetCode.easy;

import com.df.dataStructure.linked.ListNode;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 快慢两个指针
 * 注意:
 *      这个写法节点数是偶数时返回的是第二个中间节点
 *      如果要返回第一个中间节点 循环条件为
 *      while (fast.next != null && fast.next.next != null) {}
 * @author hanyli
 * @date 2021/1/14
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
