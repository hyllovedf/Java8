package com.df.dataStructure.tree;

import com.df.dataStructure.tree.LeetCode.MaxDepthN;

import java.util.List;

/**
 * N 叉树节点
 * @author hanyli
 * @date 2021/1/8
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
