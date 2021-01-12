package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;

import java.util.Stack;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * @author hanyli
 * @date 2021/1/7
 */
public class MinimumDifference {
    int abs = Integer.MAX_VALUE;
    int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        getMin(root);
        return abs;
    }

    private void getMin(TreeNode root) {
        if (root == null) {
            return;
        }
        getMin(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            abs = Math.min(Math.abs(root.val - pre), abs);
            pre = root.val;
        }
        getMin(root.right);
    }
    private void getMin2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (pre == -1) {
                    pre = pop.val;
                } else {
                    abs = Math.min(Math.abs(pop.val - pre), abs);
                    pre = pop.val;
                }
                root = pop.right;
            }
        }
    }
}
