package com.df.dataStructure;

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
}
