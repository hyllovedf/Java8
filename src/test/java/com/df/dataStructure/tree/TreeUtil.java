package com.df.dataStructure.tree;

import java.util.Arrays;
import java.util.LinkedList;

public class TreeUtil {
    public static TreeNode createTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer integer = inputList.removeFirst();
        if (integer != null) {
            node = new TreeNode(integer);
            node.left = (createTree(inputList));
            node.right = (createTree(inputList));
        }
        return node;
    }

    public static TreeNode createTree(Integer[] integers) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(integers));
        return createTree(inputList);
    }

    public static TreeNode createTree() {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        return createTree(inputList);
    }

    public static TreeNode createTreePost(Integer[] integers) {
        TreeNode root = new TreeNode(integers[0]);
        return create(integers, 0, root);
    }

    private static TreeNode create(Integer[] integers, int parent, TreeNode root) {
        int childleft = 2 * parent + 1;
        int childright = 2 * parent + 2;
        if (childleft < integers.length && integers[childleft] != null) {
            root.left = create(integers, childleft, new TreeNode(integers[childleft]));
        }
        if (childright < integers.length && integers[childright] != null) {
            root.right = create(integers, childright, new TreeNode(integers[childright]));
        }
        return root;
    }
}
