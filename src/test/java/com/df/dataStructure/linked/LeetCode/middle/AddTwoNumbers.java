package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

import java.util.Stack;

/**
 * 2. 两数相加
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author hanyli
 * @date 2021/1/14
 */
public class AddTwoNumbers {
    /**
     * 每个节点相加  如果>=10  后面的需要进一位
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sen = new ListNode(0);
        addTwoNumbers(l1, l2, sen, false);
        return sen.next;
    }

    /**
     * @param l1
     * @param l2
     * @param sen 哨兵节点 用于返回结果
     * @param ten 是否进一位标志 true 进一位 false  不进
     */
    private void addTwoNumbers(ListNode l1, ListNode l2, ListNode sen, boolean ten) {
        if (l1 == null && l2 == null) {
            if (ten) {
                sen.next = new ListNode(1);
            }
            return;
        }
        int a = l1 == null ? 0 : l1.val;
        int b = l2 == null ? 0 : l2.val;
        int sum = ten ? a + b + 1 : a + b;
        if (sum >= 10) {
            sen.next = new ListNode((sum) % 10);
            ten = true;
        } else {
            sen.next = new ListNode(sum);
            ten = false;
        }
        addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sen.next, ten);
    }

    public static void main(String[] args) {
        ListNode listNode = LinkedUtil.create(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode listNode1 = LinkedUtil.create(new int[]{9, 9, 9, 9});
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(listNode, listNode1);
    }

    /**
     * 445. 两数相加 II
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
     * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * <p>
     * <p>
     * 注意本题数字从高位存储
     * 1.可以直接反转  然后用上面的方法
     * 进阶：
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     * <p>
     * 如果不能反转 只能使用栈 达到逆序操作的目的
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> add = new Stack<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null) {
            stack1.push(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            stack2.push(cur2);
            cur2 = cur2.next;
        }
        cal(stack1, stack2, add, false);
        ListNode sen = new ListNode(0);
        ListNode l = sen;
        while (!add.isEmpty()) {
            l.next = add.pop();
            l = l.next;
        }
        return sen.next;
    }

    private void cal(Stack<ListNode> stack1, Stack<ListNode> stack2, Stack<ListNode> add, boolean ten) {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            if (ten) {
                add.push(new ListNode(1));
            }
            return;
        }
        int a = stack1.isEmpty() ? 0 : stack1.pop().val;
        int b = stack2.isEmpty() ? 0 : stack2.pop().val;
        int sum = ten ? a + b + 1 : a + b;
        if (sum >= 10) {
            add.push(new ListNode((sum) % 10));
            ten = true;
        } else {
            add.push(new ListNode(sum));
            ten = false;
        }
        cal(stack1, stack2, add, ten);
    }
}
