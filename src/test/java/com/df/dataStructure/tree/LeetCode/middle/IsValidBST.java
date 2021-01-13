package com.df.dataStructure.tree.LeetCode.middle;

import com.df.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * @author hanyli
 * @date 2021/1/12
 */
public class IsValidBST {
    /**
     * 暴力  判断中序序列是否递增
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }

    /**
     * 中序  下一个节点是不是比之前节点大
     */
    long max = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root==null) return true;
        boolean left = isValidBST2(root.left);
        if (max < root.val) {
            max = root.val;
        } else {
            return false;
        }
        boolean right = isValidBST2(root.right);
        return left && right;
    }
}
