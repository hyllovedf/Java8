package com.df.dataStructure.tree.LeetCode.middle;

import com.df.dataStructure.tree.TreeNode;

/**
 * 654. 最大二叉树
 * <p>
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * <p>
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 *
 * @author hanyli
 * @date 2021/1/12
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);

    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = getMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(nums, start, index - 1);
        root.right = constructMaximumBinaryTree(nums, index + 1, end);
        return root;
    }

    private int getMaxIndex(int[] nums, int start, int end) {
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }
}
