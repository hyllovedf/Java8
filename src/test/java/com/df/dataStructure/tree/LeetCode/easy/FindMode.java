package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * 就是出现次数最多的节点
 * 二叉搜索树  中序遍历是递增序列
 * 所以采用中序遍历  相同的数一定是相连的
 * @author hanyli
 * @date 2021/1/13
 */
public class FindMode {
    //记录前一个节点值  用于判断当前节点是否和前面的一样
    int pre=-1;
    //记录当前节点相同的数量
    int count = 0;
    //记录最大数量
    int maxcount = 0;
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root==null) return;
        inorder(root.left, list);
        if (pre == -1) {
            //第一个节点
            count = 1;
        } else if (pre == root.val) {
            //相同节点 数量加一
            count++;
        } else {
            //是不同的节点数量重新计算
            count = 1;
        }
        pre = root.val;
        if (count > maxcount) {
            //当前节点数量为最多  清空list  添加当前节点
            maxcount = count;
            list.clear();
            list.add(root.val);
        } else if (count == maxcount) {
            //如果是相等直接添加
            list.add(root.val);
        }
        inorder(root.right, list);
    }
}
