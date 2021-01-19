package com.df.dataStructure.linked.LeetCode.middle;

import com.df.dataStructure.linked.LinkedUtil;
import com.df.dataStructure.linked.ListNode;
import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

/**
 * 1367. 二叉树中的列表
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以
 * head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 *
 * @author hanyli
 * @date 2021/1/19
 */
public class IsSubPath {
    /**
     * 枚举所有路径进行比较
     * 由于是自上而下的路径  肯定是前序遍历
     * @param head
     * @param root
     * @return
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        //当前根节点不符合  继续从左右子树寻找
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }


    private boolean dfs(ListNode head, TreeNode root) {
        //说明链表已经比较完毕  直接返回true
        if (head == null) return true;
        //节点为null肯定是false
        if (root == null) return false;
        //当前两个节点值不一样false
        if (head.val != root.val) return false;
        //值一样  继续比较下一节点  左右子树有一个符合即可
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }

    public static void main(String[] args) {
        IsSubPath isSubPath = new IsSubPath();
//        TreeNode treePost = TreeUtil.createTreePost(new Integer[]{1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3});
        TreeNode treePost = TreeUtil.createTreePost(new Integer[]{1, null, 1, 10, 1, 9});
        ListNode listNode = LinkedUtil.create(1, 10);
        isSubPath.isSubPath(listNode, treePost);

    }
}
