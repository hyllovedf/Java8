package com.df.dataStructure.tree.LeetCode.middle;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

/**
 * 1038. 把二叉搜索树转换为累加树
 * 538. 把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，
 * 请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * @author hanyli
 * @date 2021/1/13
 */
public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode root, int start) {
        if (root == null) return start;
        int right = dfs(root.right, start);
        root.val += right;
        start = root.val;
        return dfs(root.left, start);
    }

    int pre = -1;
    public TreeNode convertBST2(TreeNode root) {
        dfs2(root);
        return root;
    }

    private void dfs2(TreeNode root) {
        if (root==null) return;
        dfs2(root.right);
        if (pre == -1) {
            pre = root.val;
        } else {
            root.val += pre;
            pre = root.val;
        }
        dfs2(root.left);
    }

    public static void main(String[] args) {
        ConvertBST convertBST = new ConvertBST();
        TreeNode treePost = TreeUtil.createTreePost(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        convertBST.convertBST2(treePost);
    }
}
