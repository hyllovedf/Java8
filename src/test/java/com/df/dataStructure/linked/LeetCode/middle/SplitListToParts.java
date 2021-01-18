package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 725. 分隔链表
 * @author hanyli
 * @date 2021/1/18
 */
public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = root;
        ListNode temp;
        while (cur != null) {
            list.add(cur);
            temp = cur.next;
            cur.next = null;
            cur = temp;
        }
        int size = list.size();
        //算出每个部分的最小长度
        int i = size / k;
        //如果有余数  前面j个部分长度均+1
        int j = size % k;
        ListNode[] listNodes = new ListNode[k];
        for (int i1 = 0; i1 < listNodes.length; i1++) {
            listNodes[i1] = build(list, i, j--);
        }
        return listNodes;
    }

    private ListNode build(List<ListNode> list, int i, int j) {
        j = j > 0 ? 1 : 0;
        int len = i + j;
        ListNode sen = new ListNode(0);
        ListNode cur=sen;
        while (len-- > 0) {
            cur.next = list.remove(0);
            cur=cur.next;
        }
        return sen.next;
    }

    public static void main(String[] args) {
        SplitListToParts splitListToParts = new SplitListToParts();
        ListNode listNode = LinkedUtil.create(1, 2, 3,4);
        splitListToParts.splitListToParts(listNode, 5);
    }
}
