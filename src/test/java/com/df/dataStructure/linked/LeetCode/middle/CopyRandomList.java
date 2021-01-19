package com.df.dataStructure.linked.LeetCode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 138. 复制带随机指针的链表
 * @author hanyli
 * @date 2021/1/19
 */
public class CopyRandomList {
    /**
     * 核心就是使用map存储原节点和clone节点对应关系
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head==null) return head;
        //map存储原节点和clone节点对应关系
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        Node sen = new Node(0);
        Node newhead=sen;
        while (cur != null) {
            if (map.containsKey(cur)) {
                newhead.next = map.get(cur);
            } else {
                newhead.next = new Node(cur.val);
                map.put(cur,newhead.next);
            }
            newhead=newhead.next;
            if (cur.random != null) {
                if (map.containsKey(cur.random)) {
                    newhead.random = map.get(cur.random);
                } else {
                    Node random = new Node(cur.random.val);
                    newhead.random = random;
                    map.put(cur.random, random);
                }
            } else {
                newhead.random = null;
            }
            cur=cur.next;
        }
        return sen.next;
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
