package com.df.dataStructure;

import java.util.*;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 其实就是遍历二叉树思想
 * 利用dequeue记录目前的路径
 */
public class TreeSum {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Deque<Integer> path = new ArrayDeque<>();
    public static List<List<Integer>> getpath(TreeNode root,int sum) {
        preorder(root, sum);
        return result;
    }

    private static void preorder(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.addLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<>(path));
        }
        preorder(root.left, sum);
        preorder(root.right, sum);
        path.pollLast();
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode tree = TreeUtil.createTree(inputList);
        List<List<Integer>> getpath = getpath(tree, 18);
        System.out.println(getpath);
    }
}
