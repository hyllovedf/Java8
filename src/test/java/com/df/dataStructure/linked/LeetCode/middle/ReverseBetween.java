package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.ListNode;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * @author hanyli
 * @date 2021/1/15
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return null;
        ListNode pre=null;
        ListNode cur=head;
        for(int i=1;i<m;i++){
            pre=cur;
            cur=cur.next;
        }
        ListNode newhead = reverse(cur,n-m+1);
        if(pre==null) return newhead;
        pre.next=newhead;
        return head;
    }

    private ListNode reverse(ListNode head, int n) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && n-- > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next=cur;
        return pre;
    }
}
