package com.df.dataStructure;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree {
    public static TreeNode createTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer integer = inputList.removeFirst();
        if (integer != null) {
            node = new TreeNode(integer);
            node.setLeftChild(createTree(inputList));
            node.setRightChild(createTree(inputList));
        }
        return node;
    }

    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.data);
        preOrder(treeNode.leftChild);
        preOrder(treeNode.rightChild);
    }
    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.leftChild);
        System.out.println(treeNode.data);
        inOrder(treeNode.rightChild);
    }
    public static void lastOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        lastOrder(treeNode.leftChild);
        lastOrder(treeNode.rightChild);
        System.out.println(treeNode.data);
    }
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode tree = createTree(inputList);
        preOrder(tree);
        System.out.println("=========");
        inOrder(tree);
        System.out.println("=========");
        lastOrder(tree);
    }
    private static class TreeNode{
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }
}
