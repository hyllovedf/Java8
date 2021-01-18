package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

import java.util.Stack;

/**
 * 147. 对链表进行插入排序
 *
 * @author hanyli
 * @date 2021/1/18
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode sen = new ListNode(Integer.MIN_VALUE);
        stack.push(sen);
        ListNode cur = head;
        ListNode stack_temp;
        ListNode head_temp;
        ListNode pop = null;
        while (cur != null) {
            ListNode peek = stack.peek();
            if (peek.val < cur.val || peek == sen) {
                //栈顶元素比当前小  将当前节点接到栈顶节点之后
                head_temp = cur.next;
                stack_temp = peek.next;
                peek.next = cur;
                stack.push(cur);
                cur.next = stack_temp;
                //将之前pop出的节点放回
                while (pop != null) {
                    stack.push(pop);
                    pop = pop.next;
                }
                cur = head_temp;
            } else {
                //栈顶节点比当前大  pop 继续比较
                pop = stack.pop();
            }
        }
        return sen.next;
    }

    /**
     * 利用指针  lastSort排序部分的最后一个节点
     * @param head
     * @return
     */
    public ListNode insertionSortList2(ListNode head) {
        if (head == null) return null;
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode lastSort = head;
        ListNode cur = head.next;
        ListNode pre;
        ListNode cur_temp;
        ListNode pre_temp;
        while (cur != null) {
            cur_temp = cur.next;
            if (lastSort.val <= cur.val) {
                //如果最后一个节点比当前的小  直接接到后面
                lastSort.next = cur;
                lastSort = cur;
            } else {
                //如果比较大 找到合适的位置插入
                pre = sen;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                pre_temp = pre.next;
                pre.next = cur;
                cur.next = pre_temp;
            }
            cur = cur_temp;
        }
        lastSort.next = null;
        return sen.next;
    }

    public static void main(String[] args) {
        InsertionSortList insertionSortList = new InsertionSortList();
        insertionSortList.insertionSortList(LinkedUtil.create(4, 2, 1, 3));
    }
}
