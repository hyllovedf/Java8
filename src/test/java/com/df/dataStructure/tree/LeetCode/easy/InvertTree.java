package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;

import java.util.Stack;

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
    public TreeNode invertTree2(TreeNode root) {
        if (root==null) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            TreeNode temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return root;
    }

}
