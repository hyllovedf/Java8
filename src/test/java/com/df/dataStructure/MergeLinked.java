package com.df.dataStructure;

import java.util.Stack;

/**
 * @author hanyli
 * @date 2020/9/23
 */
public class MergeLinked {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public static int getDecimalValue(ListNode head) {
        int num = 0;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        while(head!=null){
            int val = head.val;
            stack.push(val);
            head = head.next;
            count++;
        }
        for (int i = 0; i < count; i++) {
            Integer pop = stack.pop();
            num += pop * getnum(i);
        }
        return num;
    }
    public static int getnum(int count){
        if(count==0){
            return 1;
        }
        return (int) Math.pow(2,count);
    }
    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p1 = null;
        ListNode p2 = head;
        while(p2!=null){
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        return p1;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode1 = mergeTwoLists(listNode, listNode2);
        int cou = 3;
        double pow = Math.pow(2, cou);
        System.out.println((int) pow);
        ListNode listNod3e = new ListNode(1, new ListNode(0, new ListNode(1,new ListNode(0,new ListNode(1,new ListNode(0))))));
        int decimalValue = getDecimalValue(listNod3e);
        System.out.println(decimalValue);
        System.out.println(Integer.toString(27,16));
        reverseList(listNode);

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
