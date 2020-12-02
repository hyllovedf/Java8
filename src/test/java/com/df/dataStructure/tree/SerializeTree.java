package com.df.dataStructure.tree;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author hanyli
 * @date 2020/11/19
 */
public class SerializeTree {
    public static String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        getString(root, builder);
        return builder.toString();
    }

    private static void getString(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("null").append(",");
            return;
        }
        builder.append(root.val).append(",");
        getString(root.left, builder);
        getString(root.right, builder);
    }

    public static TreeNode deserialize(String data) {
        if (data==null) return null;
        String[] split = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        return build(list);
    }

    private static TreeNode build(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String remove = list.remove(0);
        if ("null".equals(remove)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(remove));
        root.left = build(list);
        root.right = build(list);
        return root;
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(10000);
        BigDecimal bigDecimal1 = new BigDecimal(0);
        System.out.println(bigDecimal1.divide(bigDecimal).setScale(2,BigDecimal.ROUND_HALF_UP));
        String[][][] cancelRuleCodes = {{{"ZH3-1,ZH6-7,ZH8"}}, {{"ZH4-1,ZH5"}}};
        System.out.println(cancelRuleCodes[0][0]);
        String data = "1,2,3,null,null,4,5";
//        TreeNode deserialize = deserialize2(data);
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        String serialize = serialize(treeNode);
        TreeNode deserialize = deserialize(serialize);
        String s = levelSerialize(treeNode);
        TreeNode treeNode1 = levelDeserialize(s);
        System.out.println(serialize);
    }

    public static String levelSerialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        rlevelSerialize(root, builder);
        return builder.toString();
    }

    private static void rlevelSerialize(TreeNode root, StringBuilder builder) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                builder.append("null").append(",");
            } else {
                builder.append(poll.val).append(",");
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
    }

    public static TreeNode levelDeserialize(String data) {
        String[] split = data.split(",");
        return rlevelDeserialize(split);
    }

    private static TreeNode rlevelDeserialize(String[] list) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        queue.offer(root);
        int cur = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (!"null".equals(list[cur])) {
                poll.left = new TreeNode(Integer.parseInt(list[cur]));
                queue.offer(poll.left);
            }
            cur++;
            if (!"null".equals(list[cur])) {
                poll.right = new TreeNode(Integer.parseInt(list[cur]));
                queue.offer(poll.right);
            }
            cur++;
        }
        return root;
    }
}
