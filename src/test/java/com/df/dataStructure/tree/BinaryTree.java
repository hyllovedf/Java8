package com.df.dataStructure.tree;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历:
 * 前序遍历: 根节点->左子树->右子树
 * 后序遍历: 左子树->右子树->根节点
 * 中序遍历: 左子树->根节点->右子树
 * 层序遍历: 每层所有节点
 */
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

    /**
     * 前序遍历
     * @param treeNode
     */
    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.data);
        preOrder(treeNode.leftChild);
        preOrder(treeNode.rightChild);
    }

    public static void perOrderStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }
    public static void perOrderStack2(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.data);
            if (pop.rightChild != null) {
                stack.push(pop.rightChild);
            }
            if (pop.leftChild != null) {
                stack.push(pop.leftChild);
            }
        }
    }

    /**
     * 中序遍历
     * @param treeNode
     */
    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.leftChild);
        System.out.println(treeNode.data);
        inOrder(treeNode.rightChild);
    }

    public static void inOrderStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.data);
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 后序遍历
     * @param treeNode
     */
    public static void lastOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        lastOrder(treeNode.leftChild);
        lastOrder(treeNode.rightChild);
        System.out.println(treeNode.data);
    }

    public static void lastOrderStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> rootStack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            rootStack.push(pop);
            if (pop.leftChild != null) {
                stack.push(pop.leftChild);
            }
            if (pop.rightChild != null) {
                stack.push(pop.rightChild);
            }
        }
        while (!rootStack.isEmpty()) {
            System.out.println(rootStack.pop().data);
        }
    }

    public static void levelOrder(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.data);
            if (poll.leftChild != null) {
                queue.add(poll.leftChild);
            }
            if (poll.rightChild != null) {
                queue.add(poll.rightChild);
            }
        }
    }
   static TreeNode head = new TreeNode(-1);
    static TreeNode prev = null;
    public static TreeNode convertBiNode(TreeNode root) {

        postorder(root);
        return head.rightChild;
    }
    public static void postorder(TreeNode root){
        if(root==null) return ;
        postorder(root.leftChild);
        if(prev==null){
            head=root;
            head.rightChild=root;
        }else{
            prev.rightChild=root;
            prev=root;
        }
        root.leftChild=null;
        postorder(root.rightChild);
    }
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode tree = createTree(inputList);
//        convertBiNode(tree);
        levelOrder(tree);
        System.out.println("====preOrder=====");
        preOrder(tree);
        System.out.println("----perOrderStack-----");
        perOrderStack(tree);
        perOrderStack2(tree);
        System.out.println("====inOrder=====");
        inOrder(tree);
        System.out.println("----inOrderStack-----");
        inOrderStack(tree);
        System.out.println("====lastOrder=====");
        lastOrder(tree);
        System.out.println("====lastOrderStack=====");
        lastOrderStack(tree);
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
