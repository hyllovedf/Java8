package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.TreeNode;

/**
 * 226. 翻转二叉树
 * 其实就是左右子树交换
 *
 * @author hanyli
 * @date 2021/1/7
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return root;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
