package com.df.dataStructure.linked.LeetCode.easy;

import com.df.dataStructure.linked.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author hanyli
 * @date 2020/9/25
 */
public class DelDuplicateLinked {
    /**
     * 83. 删除排序链表中的重复元素
     * 因为是排序链表  所以重复的元素是相邻的
     *
     * 使用双指针  判断前后指针是否相同
     * 如果相同  删除后面的指针  只移动后面的指针
     * 不同  两个指针后移
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (pre.val == cur.val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /*
    依然是有序的
    使用一个指针即可
     */
    public static ListNode removeDuplicateNodes2(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 面试题 02.01. 移除重复节点
     * 注意此链表没有顺序
     * 只能使用map记录已经有的节点  后面的节点有相同的直接删除
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes3(ListNode head) {
        if (head==null) return head;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            map.put(pre.val, pre);
            if (map.containsKey(cur.val)) {
                pre.next = cur.next;
            } else {

                pre=cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(1);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
//        ListNode listNode1 = removeDuplicateNodes(listNode);
        ListNode listNode7 = removeDuplicateNodes2(listNode);
        System.out.println();

    }
}

