package com.df.dataStructure;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除没有排序的链表重复的元素
 * 空间复杂度O(1)
 * @author hanyli
 * @date 2020/9/25
 */
public class DelDuplicateLinked {
    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode p = head;
        ListNode prev;
        ListNode curr;
        while(p!=null&&p.next!=null){
            prev = p;
            curr = p.next;
            int val = p.val;
            while(curr!=null){
                if(curr.val==val){
                    prev.next = curr.next;
                }else{
                    prev = curr;
                }
                curr = curr.next;
            }
            p = p.next;
        }
        return head;
    }

    public static ListNode removeDuplicateNodes2(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr!=null){
            map.put(prev.val, prev);
            if (map.containsKey(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;

            }
            curr = curr.next;
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
  static   class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

