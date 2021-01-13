package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 反中序遍历  递减序列
 *
 * @author hanyli
 * @date 2021/1/13
 */
public class KthLargest {
    int ans = -1;
    int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null || ans > -1) return;
        inorder(root.right);
        if (k == 1) {
            ans = root.val;
        }
        k--;
        inorder(root.left);
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        TreeNode treePost = TreeUtil.createTreePost(new Integer[]{3, 1, 4, null, 2});
        kthLargest.kthLargest(treePost, 1);
    }
}
