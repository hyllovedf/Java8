package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

/**
 * 2. 两数相加
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author hanyli
 * @date 2021/1/14
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sen = new ListNode(0);
        addTwoNumbers(l1, l2, sen, false);
        return sen.next;
    }

    private void addTwoNumbers(ListNode l1, ListNode l2, ListNode sen, boolean ten) {
        if (l1 == null && l2 == null) {
            if (ten) {
                sen.next = new ListNode(1);
            }
            return;
        }
        int a = l1 == null ? 0 : l1.val;
        int b = l2 == null ? 0 : l2.val;
        int sum = ten ? a + b + 1 : a + b;
        if (sum >= 10) {
            sen.next = new ListNode((sum) % 10);
            ten = true;
        } else {
            sen.next = new ListNode(sum);
            ten = false;
        }
        addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sen.next, ten);
    }

    public static void main(String[] args) {
        ListNode listNode = LinkedUtil.create(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode listNode1 = LinkedUtil.create(new int[]{9, 9, 9, 9});
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(listNode, listNode1);
    }
}
