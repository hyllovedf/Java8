package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

/**
 * 617. 合并二叉树
 * @author hanyli
 * @date 2021/1/11
 */
public class MergeTrees {
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1==null) return t2;
        if (t2==null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode treePost = TreeUtil.createTreePost(new Integer[]{1, 3, 2, 5});
        TreeNode treePost2 = TreeUtil.createTreePost(new Integer[]{2,1,3,null,4,null,7});
        TreeNode treeNode = mergeTrees(treePost, treePost2);
        System.out.println();
    }
}
