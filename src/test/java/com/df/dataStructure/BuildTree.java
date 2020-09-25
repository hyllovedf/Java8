package com.df.dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据中序遍历数组和后序遍历数组构造二叉树
 * @author hanyli
 * @date 2020/9/25
 */
public class BuildTree {
    private Map<Integer, Integer> map = new HashMap<>();
    private int[] inorder;
    private int[] postorder;
    private int rootIdx = 0;

    public TreeNode buildTree() {
        int idx = 0;
        for (int i : inorder) {
            map.put(i, idx++);
        }
        rootIdx = postorder.length - 1;
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int val = postorder[rootIdx];
        TreeNode root = new TreeNode(val);
        rootIdx--;
        Integer index = map.get(val);
        root.right = helper(index + 1, right);
        root.left = helper(left, index - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder ={9,3,1,15,2,20,7};
        int[] postorder ={9,1,2,15,7,20,3};
        BuildTree buildTree = new BuildTree(inorder, postorder);
        TreeNode treeNode = buildTree.buildTree();
        System.out.println();
    }

    public BuildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}

