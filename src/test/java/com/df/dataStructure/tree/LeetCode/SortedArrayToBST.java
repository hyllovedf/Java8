package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * BST平衡二叉搜索树  中序遍历后的是升序顺序
 * 所以有序数组中间那一个是一个父节点
 * 左右两个就是其左右子节点
 * @author hanyli
 * @date 2021/1/7
 */
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length - 1);
    }

    private static TreeNode create(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = create(nums, start, middle - 1);
        root.right = create(nums, middle + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        sortedArrayToBST(arr);
    }
}
