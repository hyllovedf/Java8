package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * 104. 二叉树的最大深度
 * @author hanyli
 * @date 2021/1/7
 */
public class MaxDepth {
    static int depth = 1;
    public static int maxDepth(TreeNode root) {
        if (root==null) return 0;

        dfs(root, 1);
        return depth;
    }

    private static void dfs(TreeNode root, int level) {
        if (root==null) return;
        depth = Math.max(level, depth);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
    public static int maxDepth2(TreeNode root) {
        if (root==null) return 0;
        int leftHeight = maxDepth2(root.left);
        int rightHeight = maxDepth2(root.right);
        return Math.max(leftHeight, rightHeight) + 1;

    }
    public static void main(String[] args) {
        TreeNode tree = TreeUtil.createTree();
        int i = maxDepth(tree);
        maxDepth2(tree);
        System.out.println(i);
    }
}
