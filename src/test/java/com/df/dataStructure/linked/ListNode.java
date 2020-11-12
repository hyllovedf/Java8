package com.df.dataStructure.linked;

/**
 * @author hanyli
 * @date 2020/10/23
 */
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
