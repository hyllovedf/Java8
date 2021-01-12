package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

/**
 * 1022. 从根到叶的二进制数之和
 * @author hanyli
 * @date 2021/1/11
 */
public class SumRootToLeaf {
    int ans;
    public int sumRootToLeaf(TreeNode root) {
        preorder(root, 0);
        return ans;
    }

    private void preorder(TreeNode root, int val) {
        if (root==null) return;
        int temp = (val << 1) + root.val;
        if (root.left == null && root.right == null) {
            ans += temp;
            return;
        }
        preorder(root.left, temp);
        preorder(root.right, temp);
    }

    public static void main(String[] args) {
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        TreeNode treePost = TreeUtil.createTreePost(new Integer[]{1, 0, 1, 0, 1, 0, 1});
        sumRootToLeaf.sumRootToLeaf(treePost);
    }
}
