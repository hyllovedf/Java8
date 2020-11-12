package com.df.dataStructure.linked;

/**
 * @author hanyli
 * @date 2020/9/23
 */
public class LinkedQuestion {
    /**
     * 判断链表是否有环
     * 使用两个指针 一个快速一个慢速
     * 同时出发 如果有环 两个指针会相遇
     * @param head
     */
    public static boolean loopLinked(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 链表有环  求出环的长度
     * 依然是两个指针  在初次相遇后  继续遍历
     * 再次相遇是 慢的指针走的长度就是环长度
     * 好比两个人跑步  一个速度1 一个速度2
     * 两个人再次相遇 快的比慢的多跑了一圈
     * @param head
     * @return
     */
    public static int loopLength(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        int count = 0;
        int length = 0;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (count == 1) {
                length++;
            } else if (count == 2) {
                break;
            }
            if (p1 == p2) {
                count++;
            }
        }
        return length;
    }

    /**
     * 找到入环点
     * 两个指针一个从首次相遇点出发  一个从头出发
     * 速度一致 再次相遇的就是入环点
     * @param head
     * @return
     */
    public static ListNode findNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                break;
            }
        }
        p1 = head;
        while (true) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2) {
                return p1;
            }
        }
    }

    /**
     * k个一组反转链表
     * 给你这个链表：1->2->3->4->5
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head==null||getSize(head)<k) return head;
        int temp = k;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        while (cur != null && temp-- > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(cur, k);
        return pre;
    }

    private static int getSize(ListNode head) {
        int size = 0;
        while (head!=null){
            head = head.next;
            size++;
        }
        return size;
    }

    /**
     * 指定范围反转链表
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return null;
        ListNode pre=null;
        ListNode cur=head;
        for(int i=1;i<m;i++){
            pre=cur;
            cur=cur.next;
        }
        ListNode newhead = reverse(cur,n);
        if(pre==null) return newhead;
        pre.next=newhead;
        return head;

    }
    public static ListNode reverse(ListNode head,int n){
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null&&n-->0){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        head.next=cur;
        return pre;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        ListNode listNode1 = reverseBetween(node1, 3, 1);
        ListNode listNode = reverseKGroup(node1, 2);
        System.out.println(loopLinked(node1));
        System.out.println(loopLength(node1));
        System.out.println(findNode(node1).val);
    }

}
