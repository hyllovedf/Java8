package com.df.dataStructure.linked.LeetCode.easy;

import com.df.dataStructure.linked.ListNode;

/**
 * 1290. 二进制链表转整数
 * 从高位计算
 *     当前整数左移为计算加上当前节点值  就是所需的整数
 *     (sum << 1) + head.val   相当于  (sum*2)+head.val
 * @author hanyli
 * @date 2021/1/14
 */
public class DecimalValue {
    public int getDecimalValue(ListNode head) {
        return getDecimalValue(head, 0);

    }

    private int getDecimalValue(ListNode head, int sum) {
        if (head==null) return sum;
        sum = head.val << 1 + sum;
        return getDecimalValue(head.next, sum);
    }
}
