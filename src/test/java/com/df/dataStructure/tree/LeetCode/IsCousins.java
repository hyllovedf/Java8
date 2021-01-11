package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.TreeNode;

/**
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * @author hanyli
 * @date 2021/1/11
 */
public class IsCousins {
    Integer prex = null;
    int levelx = 0;
    Integer prey = null;
    int levely = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, null, x, y);
        return levelx == levely && prex.intValue() != prey.intValue();
    }

    private void dfs(TreeNode root, int level, Integer pre, int x, int y) {
        
        if (root == null) return;
        if (x == root.val) {
            levelx = level;
            prex=pre;
        }
        if (y == root.val) {
            levely = level;
            prey = pre;
        }
        dfs(root.left, level + 1, root.val, x, y);
        dfs(root.right, level + 1, root.val, x, y);
    }
}
