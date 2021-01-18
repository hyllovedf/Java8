package com.df.dataStructure.linked.LeetCode.middle;

import org.springframework.beans.CachedIntrospectionResults;

/**
 * 430. 扁平化多级双向链表
 * @author hanyli
 * @date 2021/1/18
 */
public class Flatten {
    public Node flatten(Node head) {
        if (head==null) return head;
        Node sen = new Node(0, null, head, null);
        dfs(sen, head);
        sen.next.prev = null;
        return sen.next;
    }

    private Node dfs(Node pre, Node cur) {
        if (cur==null) return pre;
        cur.prev = pre;
        pre.next=cur;
        Node temp = cur.next;
        Node tail = dfs(cur, cur.child);
        cur.child = null;
        return dfs(tail, temp);
    }
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}