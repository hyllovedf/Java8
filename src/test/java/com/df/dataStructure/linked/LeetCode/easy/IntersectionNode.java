package com.df.dataStructure.linked.LeetCode.easy;

import com.df.dataStructure.linked.ListNode;

/**
 * 160. 相交链表
 * A  B 两个遍历  走到结尾A转到B头开始  B转到A头开始  再次相遇的地方是交点
 *     如果是null说明不相交
 * @author hanyli
 * @date 2021/1/14
 */
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            if (pa.next == null) {
                pa = headB;
            } else {
                pa = pa.next;
            }
            if (pb.next == null) {
                pb = headA;
            } else {
                pb = pb.next;
            }
        }
        return pa;
    }
}
