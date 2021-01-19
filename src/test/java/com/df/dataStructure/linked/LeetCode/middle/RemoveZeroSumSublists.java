package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 *
 * @author hanyli
 * @date 2021/1/18
 */
public class RemoveZeroSumSublists {
    /**
     * 依次从每个元素开始排查
     * 遇到符合条件的一部分  直接删除
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode cur;
        ListNode start = sen;
        int sum = 0;
        while (start.next != null) {
            cur = start.next;
            while (cur != null) {
                sum += cur.val;
                if (sum == 0) {//符合部分删除
                    start.next = cur.next;
                    break;
                }
                cur = cur.next;
            }
            if (sum != 0) {
                //没有符合部分  指针后移 继续排查
                start = start.next;
                sum = 0;
            }
        }
        return sen.next;
    }

    public static void main(String[] args) {
        RemoveZeroSumSublists removeZeroSumSublists = new RemoveZeroSumSublists();
        ListNode listNode = LinkedUtil.create(1, 2, 3, -3, 1);
        removeZeroSumSublists.removeZeroSumSublists(listNode);
    }
}
