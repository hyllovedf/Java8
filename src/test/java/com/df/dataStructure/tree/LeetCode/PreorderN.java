package com.df.dataStructure.tree.LeetCode;

import com.df.dataStructure.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * @author hanyli
 * @date 2021/1/8
 */
public class PreorderN {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root==null) return null;

        List<Node> children = root.children;
        if (children != null) {
            for (Node child : children) {
                preorder(child);
            }
        }
        list.add(root.val);
        return list;
    }
}
