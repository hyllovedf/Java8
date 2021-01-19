package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.ListNode;

/**
 * 1670. 设计前中后队列
 * 请你完成 FrontMiddleBack 类：
 * <p>
 * FrontMiddleBack() 初始化队列。
 * void pushFront(int val) 将 val 添加到队列的 最前面 。
 * void pushMiddle(int val) 将 val 添加到队列的 正中间 。
 * void pushBack(int val) 将 val 添加到队里的 最后面 。
 * int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作
 *
 * @author hanyli
 * @date 2021/1/19
 */
public class FrontMiddleBackQueue {
    private ListNode sen;
    int size;

    public FrontMiddleBackQueue() {
        sen = new ListNode(0);
        size = 0;
    }

    public void pushFront(int val) {
        ListNode head = new ListNode(val);
        head.next = sen.next;
        sen.next = head;
        size++;
    }

    public void pushMiddle(int val) {
        ListNode mid = new ListNode(val);
        ListNode fast = sen;
        ListNode slow = sen;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        mid.next = slow.next;
        slow.next = mid;
        size++;
    }

    public void pushBack(int val) {

        ListNode cur = sen;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        size++;
    }

    public int popFront() {
        if (size == 0) return -1;
        ListNode temp = sen.next;
        sen.next = sen.next.next;
        size--;
        return temp.val;
    }

    public int popMiddle() {
        if (size == 0) return -1;
        ListNode fast = sen.next;
        ListNode slow = sen.next;
        ListNode pre = sen;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        size--;
        return slow.val;
    }

    public int popBack() {
        if (size == 0) return -1;
        ListNode pre = sen;
        ListNode cur = sen.next;
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = cur.next;
        size--;
        return cur.val;
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushMiddle(1);   // [1]
        q.pushMiddle(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        System.out.println();

    }
}
