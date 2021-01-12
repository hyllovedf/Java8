package com.df.dataStructure.tree.LeetCode.easy;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 671. 二叉树中第二小的节点
 * <p>
 * 给定一个非空特殊的二叉树，每个节点都是正数，
 * 并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，
 * 那么该节点的值等于两个子节点中较小的一个。
 * <p>
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * @author hanyli
 * @date 2021/1/11
 */
public class FindSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        inorder(root, set);
        int min = -1, min2 = -1;
        for (Integer integer : set) {
            if (integer < min || min == -1) {
                min2 = min;
                min = integer;
            } else if (min2 != -1) {
                min2 = Math.min(integer, min2);
            } else {
                min2 = integer;
            }
        }
        return min2;
    }

    private void inorder(TreeNode root, Set<Integer> set) {
        if (root == null) return;
        set.add(root.val);
        inorder(root.left, set);
        inorder(root.right, set);
    }

    public static void main(String[] args) {
        FindSecondMinimumValue findSecondMinimumValue = new FindSecondMinimumValue();
        TreeNode treePost = TreeUtil.createTreePost(new Integer[]{2, 2, 5, null, null, 5, 7});
        findSecondMinimumValue.findSecondMinimumValue(treePost);
    }
}
