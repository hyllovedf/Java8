package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 注意是每一个节点的左右两个子树的高度差不超过1
 * @author hanyli
 * @date 2021/1/7
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
    public boolean isBalanced2(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root==null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
