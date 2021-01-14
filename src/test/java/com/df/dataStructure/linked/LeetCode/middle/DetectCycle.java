package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.ListNode;
import com.mysql.fabric.FabricStateResponse;

/**
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 先找到快慢指针的相遇点  然后一个指针从头开始 一个从相遇点开始
 *     速度一致  再次相遇的的地方就是切入点
 * @author hanyli
 * @date 2021/1/14
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
