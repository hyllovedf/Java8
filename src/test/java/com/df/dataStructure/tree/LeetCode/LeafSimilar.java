package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * 一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * @author hanyli
 * @date 2021/1/11
 */
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        inorder(root1, list);
        List<Integer> list1 = new ArrayList<>();
        inorder(root2, list1);
        if (list.size() != list1.size()) return false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != list1.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        inorder(root.right, list);
    }
}
