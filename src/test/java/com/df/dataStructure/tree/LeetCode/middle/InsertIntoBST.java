package com.df.dataStructure.tree.LeetCode.middle;

import com.df.dataStructure.tree.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 * @author hanyli
 * @date 2021/1/13
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
