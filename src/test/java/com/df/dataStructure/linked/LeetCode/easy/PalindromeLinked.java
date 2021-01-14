package com.df.dataStructure.linked.LeetCode.easy;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

/**
 * 234. 回文链表
 * 回文链表 反转后和原链表一样
 * 无需全部反转
 * 将后半部分反转 与前半部分比较  一样就是回文链表
 */
public class PalindromeLinked {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fristHalf = lastHalfLinked(head);
        ListNode secondHalf = reverseLinked(fristHalf.next);
        ListNode p1 = head;
        ListNode p2 = secondHalf;

        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        fristHalf.next = reverseLinked(secondHalf);
        return true;
    }

    /**
     * 反转链表
     * 头插法
     * @param head
     * @return
     */
    private static ListNode reverseLinked(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = LinkedUtil.create(new int[]{1, 2, 2, 1});
        boolean palindrome = isPalindrome(listNode);
        System.out.println(palindrome);
    }

    /**
     * 获取链表后半段
     * 使用快慢两个指针
     * @param head
     * @return
     */
    private static ListNode lastHalfLinked(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}

