package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

import java.util.*;

import static com.df.dataStructure.tree.BinaryTree.createTree;

/**
 * @author hanyli
 * @date 2020/12/22
 */
public class ZigzagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root ==null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean left = true;
        while (!queue.isEmpty()) {
            Deque<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (left) {
                    list.offerLast(poll.val);
                } else {
                    list.offerFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res.add(new ArrayList<>(list));
            left = !left;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode tree = TreeUtil.createTree(inputList);
        zigzagLevelOrder(tree);
    }
}