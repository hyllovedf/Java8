package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层序遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 就是层序遍历  然后反转
 * @author hanyli
 * @date 2021/1/7
 */
public class LevelOrderBottom {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(0,list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.createTree();
        List<List<Integer>> lists = levelOrderBottom(tree);

    }
}
