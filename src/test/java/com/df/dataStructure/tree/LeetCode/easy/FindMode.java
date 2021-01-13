package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * @author hanyli
 * @date 2021/1/13
 */
public class FindMode {
    int pre=-1;
    int count = 0;
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
            count = 1;
        } else if (pre == root.val) {
            count++;
        } else {
            count = 1;
        }
        pre = root.val;
        if (count > maxcount) {
            maxcount = count;
            list.clear();
            list.add(root.val);
        } else if (count == maxcount) {
            list.add(root.val);
        }
        inorder(root.right, list);
    }
}
