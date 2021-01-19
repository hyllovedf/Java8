package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

/**
 * 1721. 交换链表中的节点
 * 给你链表的头节点 head 和一个整数 k 。
 *
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 * @author hanyli
 * @date 2021/1/19
 */
public class SwapNodes  {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node1=head;
        ListNode node2=head;
        ListNode cur=head;
        for(int i=1;i<k;i++){
            cur=cur.next;
            node1=node1.next;
        }
        while(cur.next!=null){
            node2=node2.next;
            cur=cur.next;
        }
        int val = node1.val;
        node1.val=node2.val;
        node2.val = val;
        return head;
    }

    public static void main(String[] args) {
        SwapNodes swapNodes = new SwapNodes();
        ListNode listNode = LinkedUtil.create(1, 2, 3, 4, 5);
        swapNodes.swapNodes(listNode, 2);
    }
}
