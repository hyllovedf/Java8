package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.ListNode;

/**
 * 86. 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，
 * 使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * @author hanyli
 * @date 2021/1/15
 */
public class Partition {
    /**
     * 使用两个链表 一个存储小于x的节点
     * 另一个存储大于等于的节点
     * 最后两个链表合并成一个新链表
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode s = small;
        ListNode l = large;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                s.next = cur;
                s = s.next;
            } else {
                l.next = cur;
                l = l.next;
            }
            cur = cur.next;
        }
        //小链表后面接上大链表
        s.next = large.next;
        //大链表最后一个节点指向null
        l.next = null;
        return small.next;
    }
}
