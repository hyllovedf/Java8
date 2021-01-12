package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 毫无疑问  dfs
 *
 * @author hanyli
 * @date 2021/1/7
 */
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();
        if (root == null) return path;
        dfs(root, path, "");
        return path;
    }

    private static void dfs(TreeNode root, List<String> paths, String path) {
        if (root == null) {
            return;
        }
        StringBuilder builder = new StringBuilder(path);
        int val = root.val;
        builder.append(val);
        if (root.left == null && root.right == null) {
            paths.add(builder.toString());
            return;
        }
        builder.append("->");
        dfs(root.left, paths, builder.toString());
        dfs(root.right, paths, builder.toString());
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.createTree(new Integer[]{1,2,null,5,null,null,3});
        binaryTreePaths(tree);
    }
}
