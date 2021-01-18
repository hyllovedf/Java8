package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.ListNode;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * @author hanyli
 * @date 2021/1/18
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head==null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd=odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next=evenhead;
        return head;
    }
}
