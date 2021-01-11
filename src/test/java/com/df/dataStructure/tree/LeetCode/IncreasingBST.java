package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，
 * 使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * @author hanyli
 * @date 2021/1/11
 */
public class IncreasingBST {
    TreeNode node = null;
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return build(list);
    }

    private TreeNode build(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        Integer remove = list.remove(0);
        TreeNode treeNode = new TreeNode(remove);
        treeNode.right = build(list);
        return treeNode;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    TreeNode cur;
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode treePost = TreeUtil.createTreePost(new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9});
        IncreasingBST increasingBST = new IncreasingBST();
        increasingBST.increasingBST2(treePost);
    }
}
