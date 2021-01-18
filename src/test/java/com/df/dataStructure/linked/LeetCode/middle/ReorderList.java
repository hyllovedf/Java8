package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * @author hanyli
 * @date 2021/1/18
 */
public class ReorderList {
    /**
     * 将每个节点存储到list  然后重新连接
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        if (list.isEmpty()) {
            return;
        }
        ListNode sen = new ListNode(0);

        for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
            sen.next = list.get(i);
            sen = sen.next;
            if (i == j) {
                continue;
            }
            sen.next = list.get(j);
            sen = sen.next;
        }
        sen.next = null;
    }

    /**
     * 将链表分成两个部分  后面部分反转
     * 然后合并两个链表
     * @param head
     */
    public void reorderList2(ListNode head) {
        if (head==null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //保证后面部分是比较短的一部分 这样才能根据后面节点作为循环条件
        slow = reverse(slow.next);
        fast = head;
        ListNode fastnext;
        ListNode slownext;
        while (slow != null) {
            fastnext = fast.next;
            slownext = slow.next;
            fast.next = slow;
            slow.next = fastnext;
            slow = slownext;
            fast = fastnext;
        }
        fast.next = null;
    }

    private ListNode reverse(ListNode slow) {
        ListNode pre = null;
        ListNode cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(LinkedUtil.create(1, 2, 3, 4));
    }
}
