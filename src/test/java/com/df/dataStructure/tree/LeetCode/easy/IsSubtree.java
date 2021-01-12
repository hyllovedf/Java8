package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;

/**
 * 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * @author hanyli
 * @date 2021/1/8
 */
public class IsSubtree {
    boolean is = false;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    private boolean dfs(TreeNode s, TreeNode t) {
        if (s==null) return false;
        return isSameTree(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
