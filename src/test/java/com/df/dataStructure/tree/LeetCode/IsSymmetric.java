package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

import java.util.*;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * @author hanyli
 * @date 2021/1/6
 */
public class IsSymmetric {
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    list.add(poll.val);
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                } else {
                    list.add(-1);
                }
            }
            if (!isArraySymmetric(list)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isArraySymmetric(List<Integer> list) {
        if (list.size() == 1) return true;
        if (list.size() % 2 != 0) return false;
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (list.get(left).intValue() != list.get(right).intValue()) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{2, 3, 4, null, null, 5, null, null, 3, 5, null, null}));
        TreeNode tree = TreeUtil.createTree(inputList);
        boolean symmetric2 = isSymmetric2(tree);
        System.out.println(symmetric2);

    }

    /**
     * 判断是否对称就是判断左右子树是否相同
     *进一步就是判断两个树是否相同  IsSameTree
     * @param root
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        if(root==null) return true;
        return check(root.left, root.right);
    }

    private static boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
