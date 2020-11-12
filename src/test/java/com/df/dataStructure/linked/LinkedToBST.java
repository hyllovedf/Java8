package com.df.dataStructure.linked;

import com.df.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 有序链表变为平衡搜索二叉树
 * @author hanyli
 * @date 2020/10/23
 */
public class LinkedToBST {
    private static TreeNode root;
    public static TreeNode linkedToBST(ListNode head) {
        if (head == null) return null;
        return build(head, null);
    }

    private static TreeNode build(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = build(left, mid);
        root.right = build(mid.next, right);
        return root;
    }

    private static ListNode getMid(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        //[-10, -3, 0, 5, 9]
        ListNode listNode = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        TreeNode treeNode = linkedToBST(listNode);
        System.out.println();
    }
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while(p!=null){
            list.add(p);
            p = p.next;
        }
        list.sort(Comparator.comparingInt(a -> a.val));
        for(int i =0 ; i<list.size()-1;i++){
            ListNode node = list.get(i);
            node.next = list.get(i+1);
        }
        return list.get(0);
    }
}
