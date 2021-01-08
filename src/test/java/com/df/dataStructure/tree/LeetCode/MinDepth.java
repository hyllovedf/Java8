package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 *
 * @author hanyli
 * @date 2021/1/7
 */
public class MinDepth {
    public static int minDepth3(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth3(root.left);
        int right = minDepth3(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    public static int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth2(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth2(root.right), min);
        }
        return min + 1;
    }

    /**
     * 利用层序遍历  找到第一个叶子节点
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                QueueNode poll = queue.poll();
                TreeNode node = poll.node;
                int depth = poll.depth;
                if (node.left == null && node.right == null) {
                    //左右子树均为null说明是叶子结点
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(new QueueNode(node.left, depth + 1));
                }
                if (node.right != null) {
                    queue.offer(new QueueNode(node.right, depth + 1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        minDepth2(TreeUtil.createTree());
    }

    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
