package com.df.dataStructure.tree.LeetCode.middle;

import com.df.dataStructure.tree.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * 没有需要删除的节点  直接返回
 * 有需要删除的节点:
 * 1.为叶子节点 直接删除即可
 * 2.只有左子树  删除节点左子树补位
 * 3.只有右子树  右子树补位
 * 4.左右都有  将左子树放到右子树最左面节点的左子树上  右子树补位
 *或者将右子树放到左子树最右面的节点的右子树上  左子树补位
 * @author hanyli
 * @date 2021/1/13
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            return deal(root.left, root.right);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode deal(TreeNode left, TreeNode right) {
        if (left == null) {
            return right;
        }
        left.right = deal(left.right, right);
        return left;
    }
}

