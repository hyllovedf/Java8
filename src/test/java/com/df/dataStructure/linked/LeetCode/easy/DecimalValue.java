package com.df.dataStructure.linked.LeetCode.easy;

import com.df.dataStructure.linked.ListNode;

/**
 * 1290. 二进制链表转整数
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
