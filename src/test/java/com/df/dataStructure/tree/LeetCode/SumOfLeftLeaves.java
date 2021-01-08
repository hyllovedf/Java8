package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.TreeNode;

/**
 * 404. 左叶子之和
 *
 * @author hanyli
 * @date 2021/1/7
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, false);//只有一个节点不是左子树
    }

    private int dfs(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        //需判断是否为左叶子节点
        if (root.left == null && root.right == null && left) {
            return root.val;
        }
        return dfs(root.left, true) + dfs(root.right, false);
    }
}
