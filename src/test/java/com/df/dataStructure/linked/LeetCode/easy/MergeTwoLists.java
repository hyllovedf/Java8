package com.df.dataStructure.linked.LeetCode.easy;

import com.df.dataStructure.linked.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author hanyli
 * @date 2021/1/14
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode sen = new ListNode(0);
        ListNode cur = sen;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            //选取较小的作为下一个节点  然后较小的链表节点指针后移
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        //最后接上剩下的节点
        if (cur1 != null) cur.next = cur1;
        if (cur2 != null) cur.next = cur2;
        return sen.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        //较小的节点作为头结点 下一节点递归获取
        if (l1.val < l2.val) {
            //相当于较小链表指针后移
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

}
