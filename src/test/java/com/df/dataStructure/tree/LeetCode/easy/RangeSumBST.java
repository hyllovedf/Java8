package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * @author hanyli
 * @date 2021/1/11
 */
public class RangeSumBST {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val > high) {
            rangeSumBST(root.left, low, high);
        } else if (root.val < low){
            rangeSumBST(root.right, low, high);
        }else {
            sum += root.val;
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
