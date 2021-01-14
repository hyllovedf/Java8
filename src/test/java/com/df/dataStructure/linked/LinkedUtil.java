package com.df.dataStructure.linked;

/**
 * @author hanyli
 * @date 2021/1/14
 */
public class LinkedUtil {
    public static ListNode create(int[] arr) {
        ListNode sen = new ListNode(0);
        ListNode cur = sen;
        for (int i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return sen.next;
    }
}
