package com.df.dataStructure.linked.LeetCode.easy;

import com.df.dataStructure.linked.ListNode;
import org.springframework.core.NamedInheritableThreadLocal;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 快慢两个指针  如果最终可以相遇 则链表有环
 * @author hanyli
 * @date 2021/1/14
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
