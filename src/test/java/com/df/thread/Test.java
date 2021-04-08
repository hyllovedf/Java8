package com.df.thread;

/**
 * 5-6-3
 * 365+227
 *
 * @author hanyli
 * @date 2021/3/29
 */
public class Test {
    public Node getSum(Node node1, Node node2) {
        Node sen = new Node(0);
        getNode(node1, node2, sen, false);
        return sen.next;
    }

    private void getNode(Node node1, Node node2, Node sen, boolean ten) {
        if (node1 == null && node2 == null) {
            if (ten) {
                sen.next = new Node(1);
            }
            return;
        }
        int a = node1 == null ? 0 : node1.val;
        int b = node2 == null ? 0 : node2.val;
        int sum = ten ? a + b + 1 : a + b;
        if (sum >= 10) {
            sen.next = new Node(sum % 10);
            ten = true;
        } else {
            sen.next = new Node(sum);
            ten = false;
        }
        getNode(node1 == null ? null : node1.next, node2 == null ? null : node2.next, sen.next, ten);
    }

    public static void main(String[] args) {
        Test test = new Test();
        Node node = new Node(5, new Node(3, new Node(2)));
        Node node2 = new Node(5, new Node(3, new Node(2)));
        Node sum = test.getSum(node, node2);
        System.out.println(sum);
    }

}

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}