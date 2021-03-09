package com.df.dataStructure.tree.LeetCode.middle;

import com.df.dataStructure.tree.TreeNode;
import com.df.dataStructure.tree.TreeUtil;

import java.util.*;

/**
 * 662. 二叉树最大宽度
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * @author hanyli
 * @date 2021/3/8
 */
public class WidthOfBinaryTree {
    int ans;
    //记录每层最左开始的位置
    Map<Integer,Integer> map;

    /**
     * 深度优先
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        ans=0;
        map = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root==null) return;
        map.putIfAbsent(depth, pos);
        ans = Math.max(ans, pos - map.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }

    /**
     * 广度优先
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree2(TreeNode root) {
        Queue<MyNode> queue = new LinkedList<>();
        queue.add(new MyNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            MyNode poll = queue.poll();
            if (poll.root != null) {
                queue.add(new MyNode(poll.root.left, poll.depth + 1, poll.pos * 2));
                queue.add(new MyNode(poll.root.right, poll.depth + 1, poll.pos * 2 + 1));
                if (curDepth != poll.depth) {
                    curDepth = poll.depth;
                    left = poll.pos;
                }
                ans = Math.max(ans, poll.pos - left + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WidthOfBinaryTree width = new WidthOfBinaryTree();
        width.widthOfBinaryTree(TreeUtil.createTreePost(new Integer[]{1, 3, 2, 5, 3, null, 9}));
    }
    class MyNode{
        private TreeNode root;
        private int depth;
        private int pos;

        public MyNode(TreeNode root, int depth, int pos) {
            this.root = root;
            this.depth = depth;
            this.pos = pos;
        }
    }
}
