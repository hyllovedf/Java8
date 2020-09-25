package com.df.dataStructure;

import sun.security.util.LegacyAlgorithmConstraints;

import javax.sound.midi.Soundbank;

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
    public static boolean loopLinked(Node head) {
        Node p1 = head;
        Node p2 = head;
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
    public static int loopLength(Node head) {
        Node p1 = head;
        Node p2 = head;
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
    public static Node findNode(Node head) {
        Node p1 = head;
        Node p2 = head;
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

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println(loopLinked(node1));
        System.out.println(loopLength(node1));
        System.out.println(findNode(node1).data);
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
