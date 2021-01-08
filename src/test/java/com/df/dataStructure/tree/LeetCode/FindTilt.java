package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

/**
 * 563. 二叉树的坡度
 * 就是每个节点的左子树所有节点和  与右子树所有节点和的绝对差
 *
 * @author hanyli
 * @date 2021/1/8
 */
public class FindTilt {
    static int tilt = 0;

    public static int findTilt(TreeNode root) {
        sum(root);
        return tilt;
    }

    private static int sum(TreeNode root) {
        if (root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.createTree(new Integer[]{4, 2, 3, null, null, 5, null, null, 9, null, 7});
        findTilt(tree);
    }
}
