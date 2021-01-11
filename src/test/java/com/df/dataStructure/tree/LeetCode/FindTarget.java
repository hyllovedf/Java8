package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，
 * 如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * @author hanyli
 * @date 2021/1/11
 */
public class FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
