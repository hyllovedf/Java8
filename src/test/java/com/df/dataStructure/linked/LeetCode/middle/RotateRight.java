package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * @author hanyli
 * @date 2021/1/15
 */
public class RotateRight {
    /**
     * 循环定位到最后一个节点和前一个节点
     * 将最后一个节点放到头
     * 可以实现但是k较大的时候太耗时
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode sen = new ListNode(0);
        sen.next = head;
        while (k-- > 0) {
            ListNode cur = sen.next;
            ListNode pre = sen;
            while (cur.next != null) {
                cur = cur.next;
                pre = pre.next;
            }
            pre.next = null;
            cur.next = sen.next;
            sen.next = cur;
        }
        return sen.next;
    }

    /**
     * 利用双向链表 存储节点
     * 循环取出对头元素放入队尾
     * 最后一次连接就是需要的链表
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null) return null;
        ListNode sen = new ListNode(0);

        Deque<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            queue.offerFirst(cur);
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        int size = queue.size();
        k = k % size;
        while (k-- > 0) {
            cur = queue.poll();
            queue.offer(cur);
        }
        cur = sen;
        while (!queue.isEmpty()) {
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        return sen.next;
    }

    /**
     * 把链表构造成一个闭环  然后在需要的地方断开环
     * 得到需要的链表
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight3(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int count = 1;
        //得出链表的长度
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        //构造闭环
        cur.next = head;
        /*
        确定断开的位置  不需要完全遍历 k 因为链表长度固定的
        所以 count - (k % count) 的位置就是新头的位置  需要断开的位置就是
        k % count -1
         */
        cur = head;
        for (int i = 0; i < count - k % count - 1; i++) {
            cur = cur.next;
        }
        ListNode newhead = cur.next;
        //断开
        cur.next = null;
        return newhead;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        RotateRight rotateRight = new RotateRight();
        ListNode listNode = LinkedUtil.create(ints);
        rotateRight.rotateRight2(listNode, 2);
    }
}
