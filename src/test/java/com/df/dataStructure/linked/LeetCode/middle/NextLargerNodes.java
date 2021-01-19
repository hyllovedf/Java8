package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1019. 链表中的下一个更大节点
 *
 * @author hanyli
 * @date 2021/1/18
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //链表元素存储到集合中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(j)>list.get(i)){
                    res[i]=list.get(j);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NextLargerNodes nextLargerNodes = new NextLargerNodes();
        nextLargerNodes.nextLargerNodes(LinkedUtil.create(2, 1, 5));
    }
}
