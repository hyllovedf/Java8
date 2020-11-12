package com.df.dataStructure.tree;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 其实就是遍历二叉树思想
 * 利用dequeue记录目前的路径
 */
public class TreeSum {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Deque<Integer> path = new ArrayDeque<>();
    public static List<List<Integer>> getpath(TreeNode root,int sum) {
        preorder(root, sum);
        return result;
    }

    private static void preorder(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.addLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<>(path));
        }
        preorder(root.left, sum);
        preorder(root.right, sum);
        path.pollLast();
    }
    private static int sum=0;
    private static StringBuilder bu = new StringBuilder();
    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int i) {
        if (root==null) return 0;
        int sum = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    public static void test() {
        StringBuilder builder = new StringBuilder("2059");
        Random mr = new Random();
        Random mir = new Random();
        Random cr = new Random();
        Random r = new Random();
        builder.append(mr.nextInt(60)).append(mir.nextInt(1000));
        BigDecimal bigDecimal = new BigDecimal(builder.toString());
        StringBuilder cai = new StringBuilder();
        StringBuilder ren = new StringBuilder("60");
        for (int i = 0; i < 5; i++) {
            cai.append(cr.nextInt(10));
        }
        BigDecimal bigDecimal1 = new BigDecimal(cai.toString());
        ren.append(r.nextInt(4000) + 6000);
        BigDecimal bigDecimal2 = new BigDecimal(ren.toString());
//        System.out.println("time "+builder.toString());
//        System.out.println("cai "+cai.toString());
//        System.out.println("ren "+ren.toString());
        System.out.println(bigDecimal.multiply(bigDecimal1).remainder(bigDecimal2).add(new BigDecimal(10000001)));


    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100000; i++) {
//            test();
//            System.out.println("=========");
//        }
        String s = "899";
        int i = s.charAt(1)-48;
        System.out.println(i);

//        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        /*LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{4,9,5,null,null,1,null,null,0}));
        TreeNode tree = TreeUtil.createTree(inputList);
        int i = sumNumbers(tree);
        List<List<Integer>> getpath = getpath(tree, 18);
        System.out.println(getpath);*/
    }
}
