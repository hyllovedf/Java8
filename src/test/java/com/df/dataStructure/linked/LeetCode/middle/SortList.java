package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 排序可以使用插入  {@link InsertionSortList}时间复杂度 O(n2)
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * @author hanyli
 * @date 2021/1/18
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    /**
     * 归并
     *
     * @param head
     * @param tail
     * @return
     */
    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == tail) return head;
        ListNode cur = head;
        ListNode mid = head;
        while (cur.next != tail && cur.next.next != tail) {
            cur = cur.next.next;
            mid = mid.next;
        }
        ListNode next = mid.next;
        mid.next = null;
        ListNode l1 = sortList(head, mid);
        ListNode l2 = sortList(next, tail);

        return merge(l1, l2);
    }

    /**
     * 合并两个有序链表  {@link com.df.dataStructure.linked.LeetCode.easy.MergeTwoLists}
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        SortList sortList = new SortList();
        sortList.sortList(LinkedUtil.create(4, 2, 1, 3));
    }
}
