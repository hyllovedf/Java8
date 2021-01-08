package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.Node;

import java.util.List;

/**
 * 559. N 叉树的最大深度
 * 类似于二叉树的最大深度
 * @author hanyli
 * @date 2021/1/8
 */
public class MaxDepthN {
    public int maxDepth(Node root) {
        if (root==null) return 0;
        List<Node> list = root.children;
        int max=0;
        if (list != null) {
            for (Node node : list) {
                max = Math.max(maxDepth(node),max);
            }
        }
        return max + 1;
    }
}
