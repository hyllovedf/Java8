package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * @author hanyli
 * @date 2021/1/15
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode newhead = sen;
        ListNode pre = head;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            if (cur.val == pre.val) {
                cur = cur.next;
                count++;
            } else {
                if (count > 1) {
                    newhead.next = cur;
                } else {
                    newhead = pre;
                }
                pre = cur;
                cur = cur.next;
                count = 1;
            }
        }
        return sen.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode listNode = LinkedUtil.create(1, 1, 1, 2, 3);
        deleteDuplicates.deleteDuplicates(listNode);
    }
}
