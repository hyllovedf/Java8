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

}
