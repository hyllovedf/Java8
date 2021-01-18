package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;

import java.util.*;

/**
 * 817. 链表组件
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 *
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 *
 * 返回列表 G 中组件的个数，这里对组件的定义为：
 * 链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 * @author hanyli
 * @date 2021/1/18
 */
public class NumComponents {
    public int numComponents(ListNode head, int[] G) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : G) {
            map.put(i, i);
        }
        ListNode start=head;
        ListNode end = head;
        int count=0;
        while (end != null) {
            if (map.containsKey(end.val)) {
                if (start == end) {
                    //只在第一次加一
                    count++;
                }
            } else {
                //不存在  说明组件到此结束
                start=end.next;
            }
            end=end.next;
        }
        return count;
    }

    public static void main(String[] args) {
        NumComponents numComponents = new NumComponents();
        ListNode listNode = LinkedUtil.create(0, 1, 2, 3);
        int[] arr = {0, 1, 3};
        numComponents.numComponents(listNode, arr);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.remove(1);
        System.out.println(list);
    }
}
